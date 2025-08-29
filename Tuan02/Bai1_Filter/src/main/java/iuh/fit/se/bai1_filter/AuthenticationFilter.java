package iuh.fit.se.bai1_filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/login"}, initParams = {
        @WebInitParam(name = "username", value = "minhduc"),
        @WebInitParam(name = "password", value = "123")
})
public class AuthenticationFilter extends HttpFilter {
    private String configUsername;
    private String configPass;

    @Override
    public void init(FilterConfig config) throws ServletException {
        configUsername = config.getInitParameter("username");
        configPass = config.getInitParameter("password");
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        //Nếu là Get thì đi qua để hiển thị form đăng nhập trước
        if (req.getMethod().equals("GET")) {
            chain.doFilter(req, res);
            return;
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (req.getParameter("username").equals(configUsername) && req.getParameter("password").equals(configPass)) {
            out.println("Login thành công");
            out.println("<br/>");
            out.println("<br/>");
            chain.doFilter(req, res);
        } else {
            out.println("Login fail");
            out.println("<br/>");
            out.println("<br/>");
        }
    }

}
