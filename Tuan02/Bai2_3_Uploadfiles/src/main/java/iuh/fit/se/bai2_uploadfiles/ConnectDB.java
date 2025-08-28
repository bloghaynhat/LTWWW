package iuh.fit.se.bai2_uploadfiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String JDBC_URL =
            "jdbc:mariadb://localhost:3306/servlet";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "sapassword";
    static {
        try {
// Load driver chỉ một lần duy nhất
//
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws
            SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,
                JDBC_PASSWORD);
    }
}
