package me.minhduc.ontapthuoc.services;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import me.minhduc.ontapthuoc.daos.LoaiThuocDAO;
import me.minhduc.ontapthuoc.daos.ThuocDAO;
import me.minhduc.ontapthuoc.models.LoaiThuoc;
import me.minhduc.ontapthuoc.models.Thuoc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@WebServlet("/thuoc")
@MultipartConfig
public class ThuocServlet extends HttpServlet {
    private ThuocDAO thuocDAO;
    private LoaiThuocDAO loaiThuocDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        thuocDAO = new ThuocDAO();
        loaiThuocDAO = new LoaiThuocDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Thuoc> thuocList;
        String loaiIDStr = req.getParameter("loaiThuocID");
        req.setAttribute("loaithuoclist", loaiThuocDAO.getAll());

        String action = req.getParameter("action");
        if(action!=null && action.equals("ADD")){
            req.getRequestDispatcher("thuoc-form.jsp").forward(req, resp);
            return;
        }

        if (loaiIDStr != null && !loaiIDStr.equals("ALL")){
            int loaiID = Integer.parseInt(loaiIDStr);
            thuocList = thuocDAO.getThuocByLoaiThuocID(loaiID);
            req.setAttribute("selectedLoaiThuocID", loaiID);
        } else thuocList = thuocDAO.getAll();

        req.setAttribute("thuoclist", thuocList);
        req.getRequestDispatcher("thuoc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenThuoc = req.getParameter("tenThuoc");
        double gia = Double.parseDouble(req.getParameter("gia"));
        int namSX = Integer.parseInt(req.getParameter("namSX"));
        int loaiID = Integer.parseInt(req.getParameter("loaiThuocID"));

        LoaiThuoc loaiThuoc = loaiThuocDAO.getLoaiThuocByID(loaiID);

        // Thư mục lưu ảnh (ví dụ: webapp/uploads)
        String uploadPath = req.getServletContext().getRealPath("images");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        // Lấy file upload
        Part filePart = req.getPart("hinhAnh");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String filePath = uploadPath + File.separator + fileName;
        if (filePart.getSize() > 0) {
            filePart.write(filePath);
        }

        // Lưu đường dẫn tương đối (ví dụ: uploads/abc.jpg)
        String imagePath = "images/" + fileName;

        Thuoc thuoc = new Thuoc(null, tenThuoc, gia, namSX, imagePath, loaiThuoc);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Thuoc>> violations = validator.validate(thuoc);

        if (violations.isEmpty()) {
            thuocDAO.save(thuoc);
            resp.sendRedirect("thuoc");
        } else {
            req.setAttribute("thuoc", thuoc);
            req.setAttribute("errors", violations);
            req.getRequestDispatcher("thuoc-form.jsp").forward(req, resp);
        }
    }
}
