package fit.se.bai2;

import fit.se.bai2.daos.UserDAO;
import fit.se.bai2.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegistrationServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration-form.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");
        String birthday = req.getParameter("day") + "/" + req.getParameter("month") + "/" + req.getParameter("year");
        String gender = req.getParameter("gender");

        User user = new User(firstName, lastName, email, password, birthday, gender);
        userDAO.addUser(user);

        // Hiển thị danh sách
        req.setAttribute("listUsers", userDAO.getAllUser());
        RequestDispatcher dispatcher = req.getRequestDispatcher("listUsers.jsp");
        dispatcher.forward(req, resp);
    }
}
