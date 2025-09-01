package iuh.fit.bai4_gson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import iuh.fit.bai4_gson.models.User;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Tạo user gỉả
        User user = new User("1", "22683091", "Lê Phạm Minh Đức", "DHKTPM18ATT");

        String json = mapper.writeValueAsString(user);

        // Set header response là JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println(json);
    }


}
