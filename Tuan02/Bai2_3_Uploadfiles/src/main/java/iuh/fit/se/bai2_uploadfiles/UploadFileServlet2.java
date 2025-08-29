package iuh.fit.se.bai2_uploadfiles;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Collection;

@WebServlet(value = "/uploadfile2")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 25 // 25MB
)
public class UploadFileServlet2 extends HttpServlet {
    private String uploadPathToSource;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        uploadPathToSource = "D:\\HK1_Nam4\\WWW\\LTWWW\\Tuan02\\Bai2_3_Uploadfiles\\src\\main\\webapp\\uploads";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/uploadfile.html").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Part filePart = req.getPart("photo"); // Lấy file từ form
        InputStream inputStream = null; // Lấy dữ liệu kiểu nhị phân của file
        String fileUploadName = "";

        /**
         * filePart != null: Khi gửi request lên sẽ luôn có phần "photo" trong form chứa thẻ input file (Chắc chắn input file có trong request)
         * filePart.getSubmittedFileName() != null: Kiểm tra xem tên file có tồn tại không. Tuy nhiên có khả năng servlet container trả về tên file rỗng ""
         * !filePart.getSubmittedFileName().isEmpty(): Kiểm tra rằng tên file đó không được là chuỗi rỗng.
         */
        if (filePart != null
                && filePart.getSubmittedFileName() != null
                && !filePart.getSubmittedFileName().isEmpty()) {
            fileUploadName = filePart.getSubmittedFileName();
            inputStream = filePart.getInputStream();
        }
        try (Connection conn = ConnectDB.getConnection()) {
            // Insert dữ liệu vào CSDL UploadFileServletDB, trường hợp này bảng contacts (khóa tự động tăng)
            String sqlInsert = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sqlInsert);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if (inputStream != null) {
                statement.setBlob(3, inputStream);
            }
            int row = statement.executeUpdate();
            // thực hiện lưu thông tin vào CSDL
            if (row > 0) {
                resp.getWriter().println("File uploaded and saved into database");
            }

            // Lấy ảnh từ CSDL lưu ngược về folder uploads trong src
            String filePath = uploadPathToSource + File.separator + fileUploadName;
            String sqlSelect = "SELECT photo FROM contacts WHERE first_name=? AND last_name=?";
            PreparedStatement stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, firstName);
            stm.setString(2, lastName);
            ResultSet resultSet = stm.executeQuery();
            if(resultSet.next()){
                Blob blob = resultSet.getBlob("photo");

                // Lấy stream từ Blob
                try(InputStream inputStream1 = blob.getBinaryStream()){
                    Files.copy(inputStream1, Paths.get(filePath));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

