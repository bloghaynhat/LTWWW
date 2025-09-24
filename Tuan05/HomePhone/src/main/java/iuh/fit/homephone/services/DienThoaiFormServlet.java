package iuh.fit.homephone.services;

import iuh.fit.homephone.daos.impl.NhaCungCapDAO;
import iuh.fit.homephone.models.DienThoai;
import iuh.fit.homephone.models.NhaCungCap;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

@WebServlet("/dienthoaiform")
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhaCungCap> nhaCungCaps = nhaCungCapDAO.findAll();
        req.setAttribute("nhaCungCaps", nhaCungCaps);
        req.getRequestDispatcher("DienThoaiForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null){
            switch (action){
                case "SAVE" -> {
                    String ma = req.getParameter("maDT");
                    String ten = req.getParameter("tenDT");
                    int nam = Integer.parseInt(req.getParameter("namSanXuat"));
                    String cauHinh = req.getParameter("cauHinh");
                    Part filePath = req.getPart("hinhAnh");
                    byte[] anh =null;
                    if (filePath != null && filePath.getSize() > 0){
                        anh = filePath.getInputStream().readAllBytes();
                    }
                    String maNCC = req.getParameter("nhaCungCapId");
                    NhaCungCap nhaCungCap = nhaCungCapDAO.getNCCTheoMaNCC(maNCC);

                    DienThoai dienThoai = new DienThoai(ma, ten, nam, cauHinh, anh, nhaCungCap);

                    nhaCungCapDAO.addDienThoai(dienThoai);

                    resp.sendRedirect("dienthoai");
                }
            }
        }
    }
}
