package iuh.fit.se.baitap1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Le Pham Minh Duc
 */
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Đây là trang Register" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // get data từ input và in ra
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Thông tin" + "</h1>");
        out.println("<p>" + "Họ và tên: " + req.getParameter("firstName") +" " + req.getParameter("lastName") + "</p>");
        out.println("<p>" + "Username: " + req.getParameter("username") + "</p>");
        out.println("<p>" + "Email: " +req.getParameter("email") + "</p>");
        out.println("<p>" + "password: " + req.getParameter("password") + "</p>");
        out.println("<p>" + "Facebook: " + req.getParameter("facebook") + "</p>");
        out.println("<p>" + "Short Bio: " + req.getParameter("shortbio") + "</p>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}