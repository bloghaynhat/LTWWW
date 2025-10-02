package me.minhduc.ontapthuoc.services;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.minhduc.ontapthuoc.daos.LoaiThuocDAO;
import me.minhduc.ontapthuoc.models.LoaiThuoc;

import java.io.IOException;
import java.util.List;

@WebServlet("/loaithuoc")
public class LoaiThuocServlet extends HttpServlet {
    private LoaiThuocDAO loaiThuocDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiThuoc> thuocList = loaiThuocDAO.getAll();
        req.setAttribute("loaithuoclist", thuocList);
        req.getRequestDispatcher("loaithuoc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
