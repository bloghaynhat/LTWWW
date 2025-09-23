package iuh.fit.homephone.services;

import iuh.fit.homephone.daos.impl.NhaCungCapDAO;
import iuh.fit.homephone.models.DienThoai;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/anhdienthoai")
public class LayAnhDienThoaiServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("maDT");
        if(ma.isBlank()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        DienThoai dienThoai = nhaCungCapDAO.getDienThoaiTheoMaDT(ma);
        if (dienThoai == null || dienThoai.getHinhAnh() == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Gửi ảnh về browser
        resp.setContentType("image/jpeg"); // hoặc image/png
        resp.setContentLength(dienThoai.getHinhAnh().length);
        resp.getOutputStream().write(dienThoai.getHinhAnh());
    }
}
