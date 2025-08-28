package iuh.fit.se.bai2_uploadfiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(value = "/uploadfile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 25 // 25MB
)
public class UploadFileServlet extends HttpServlet {
    public static final String SAVE_DIRECTORY = "T:\\LTWWW\\Tuan02\\Bai2_Uploadfiles\\src\\main\\webapp\\uploads";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/uploadfile.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Lấy tất cả file upload
//        String[] fileNames = {"file1", "file2", "file3", "file4", "file5"};
        Collection<Part> parts = req.getParts();

        for (Part part : parts){
            String fileName = part.getSubmittedFileName();
            if (fileName != null && !fileName.isEmpty()) {
                part.write(SAVE_DIRECTORY + File.separator + fileName);
            }
        }
    resp.getWriter().println("Upload file thanh cong");
    }
}
