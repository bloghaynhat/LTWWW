package iuh.fit.homephone.services;

import iuh.fit.homephone.daos.impl.NhaCungCapDAO;
import iuh.fit.homephone.models.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/dienthoai")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.getAll();
        req.setAttribute("listNCC", nhaCungCaps);
        req.getRequestDispatcher("DanhSachDienThoaiNCC.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
