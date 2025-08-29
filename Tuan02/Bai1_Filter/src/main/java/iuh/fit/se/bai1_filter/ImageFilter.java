package iuh.fit.se.bai1_filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebFilter(urlPatterns = {"*.jpg", "*.jpeg", "*.png", "*.img"}, initParams = {
        @WebInitParam(name = "notFoundImage", value = "/images/image_not_found.jpg")
})
public class ImageFilter extends HttpFilter {
    private String configNotFoundImage;
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.configNotFoundImage = config.getInitParameter("notFoundImage");
    }
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // Đường dẫn tuyệt đối của thư mục webapp
        String rootPath = req.getServletContext().getRealPath("");
        String servletPath = req.getServletPath();
        // Đường dẫn tuyệt đối tới file ảnh
        String imagePath = rootPath + servletPath;
        System.out.println("Servlet Path: " + servletPath);
        System.out.println("imagePath: " + imagePath);

        File file = new File(imagePath);
        if(file.exists()){
            chain.doFilter(req,res);
        }else if(!servletPath.equals(configNotFoundImage)){
            // Redirect tới file ảnh not found
            res.sendRedirect(req.getContextPath() + this.configNotFoundImage);
        }
    }


}
