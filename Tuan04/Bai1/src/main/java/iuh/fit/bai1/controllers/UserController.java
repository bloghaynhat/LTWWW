package iuh.fit.bai1.controllers;

import iuh.fit.bai1.daos.UserDAO;
import iuh.fit.bai1.daos.impl.UserDAOImpl;
import iuh.fit.bai1.entities.User;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@WebServlet(urlPatterns = "/users")
public class UserController extends HttpServlet {

    @Resource(name = "jdbc/user")
    private DataSource dataSource;

    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.userDAO = new UserDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "new" -> handleShowRegisterForm(req, resp);
            case "delete" -> handleDeleteUser(req, resp);
            case "edit" -> handleShowEditForm(req, resp);
            default -> handleShowUser(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add" -> handleAddUser(req, resp);
            case "update" -> handleUpdateUser(req, resp);
            default -> handleShowUser(req, resp);
        }
    }

    //    Post method
    private void handleUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. Lấy dữ liệu từ form
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String birthdayStr = req.getParameter("birthday");
            String gender = req.getParameter("gender");

            // 2. Convert String -> LocalDate
            LocalDate birthday = null;
            if (birthdayStr != null && !birthdayStr.isEmpty()) {
                birthday = LocalDate.parse(birthdayStr); // format mặc định yyyy-MM-dd
            }

            // 3. Tạo User object
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setGender(gender);

//            Validate User bằng Bean validation
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<User>> violations = validator.validate(user);

            if (!violations.isEmpty()) { //Nếu có lỗi validate
                StringBuilder msg = new StringBuilder();
                for (ConstraintViolation<User> violation : violations) {
                    msg.append(violation.getMessage()).append("<br/>");
                }
                req.setAttribute("errors", msg.toString());
                req.setAttribute("user", user); // Giữ lại dữ liệu đã nhập
                req.getRequestDispatcher("views/user/edit.jsp").forward(req, resp);
                return;

            }

//            Nếu không có lỗi!
            // 4. Lưu xuống DB
            userDAO.updateUser(user);

            // 5. Redirect về list
            resp.sendRedirect(req.getContextPath() + "/users");

        } catch (Exception e) {
            // 6. Nếu có lỗi -> forward lại form kèm thông báo
            req.setAttribute("errors", "Có lỗi khi thêm user: " + e.getMessage());
            req.getRequestDispatcher("views/user/edit.jsp").forward(req, resp);
        }
    }

    private void handleAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. Lấy dữ liệu từ form
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String birthdayStr = req.getParameter("birthday");
            String gender = req.getParameter("gender");

            // 2. Convert String -> LocalDate
            LocalDate birthday = null;
            if (birthdayStr != null && !birthdayStr.isEmpty()) {
                birthday = LocalDate.parse(birthdayStr); // format mặc định yyyy-MM-dd
            }

            // 3. Tạo User object
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setGender(gender);

//            Validate User bằng Bean validation
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<User>> violations = validator.validate(user);

            if (!violations.isEmpty()) { //Nếu có lỗi validate
                StringBuilder msg = new StringBuilder();
                for (ConstraintViolation<User> violation : violations) {
                    msg.append(violation.getMessage()).append("<br/>");
                }
                req.setAttribute("errors", msg.toString());
                req.setAttribute("user", user); // Giữ lại dữ liệu đã nhập
                req.getRequestDispatcher("views/user/add.jsp").forward(req, resp);
                return;

            }

//            Nếu không có lỗi!
            // 4. Lưu xuống DB
            userDAO.addUser(user);

            // 5. Redirect về list
            resp.sendRedirect(req.getContextPath() + "/users");

        } catch (Exception e) {
            // 6. Nếu có lỗi -> forward lại form kèm thông báo
            req.setAttribute("errors", "Có lỗi khi thêm user: " + e.getMessage());
            req.getRequestDispatcher("views/user/add.jsp").forward(req, resp);
        }
    }

    //    Get method
    private void handleShowUser(HttpServletRequest req, HttpServletResponse resp) {
        try {
//            1. Lấy danh sách từ DB
            List<User> users = userDAO.getAll();

//        2. Gắn vào request attribute để JSP đọc
            req.setAttribute("users", users);

//        3. Forward sang JSP hiển thị
            req.getRequestDispatcher("views/user/list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleShowEditForm(HttpServletRequest req, HttpServletResponse resp) {
        try{
            String id = req.getParameter("id");
            int userId = Integer.parseInt(id);
            User user = userDAO.findById(userId);
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/user/edit.jsp").forward(req, resp);

        } catch (SQLException | IOException | ServletException e) {
            throw new RuntimeException(e);
        }

    }

    private void handleDeleteUser(HttpServletRequest req, HttpServletResponse resp) {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            userDAO.deleteUser(id);
            resp.sendRedirect(req.getContextPath() + "/users");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void handleShowRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/add.jsp").forward(req, resp);
    }


}
