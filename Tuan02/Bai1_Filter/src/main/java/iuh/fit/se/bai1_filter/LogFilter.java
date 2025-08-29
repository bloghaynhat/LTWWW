package iuh.fit.se.bai1_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = "/*")
public class LogFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String servletPath = req.getServletPath();
        System.out.println("#INFO: " + new Date() + " - Servlet Path: " + servletPath + ", URL: " + req.getRequestURL());

        // Cho phép request được đi tiếp
        chain.doFilter(req, res);
    }
}
