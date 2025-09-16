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

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

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
    private void handleUpdateUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void handleAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            // 1. Lấy dữ liệu từ form
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String birthday = req.getParameter("birthday");
            String gender = req.getParameter("gender");

            // 2. Validate đơn giản
            StringBuilder errors = new StringBuilder();
            if (name == null || name.isBlank()) {
                errors.append("Tên không được để trống.<br/>");
            }
            if (email == null || email.isBlank()) {
                errors.append("Email không được để trống.<br/>");
            }

            if (!errors.isEmpty()) {
                // Nếu có lỗi -> trả về form + hiện thông báo
                req.setAttribute("errors", errors.toString());
                req.getRequestDispatcher("views/common/error.jsp").forward(req, resp);
                return;
            }

            // 3. Tạo đối tượng User
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setBirthday(birthday);  // có thể convert sang LocalDate nếu DB dùng kiểu DATE
            user.setGender(gender);

            // 4. Gọi DAO để lưu
            userDAO.addUser(user);

            // 5. Redirect về danh sách
            resp.sendRedirect(req.getContextPath() + "/users");

        } catch (Exception e) {
            throw new ServletException("Error while adding user", e);
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
    }

    private void handleDeleteUser(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void handleShowRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/user/add.jsp").forward(req, resp);
    }


}
