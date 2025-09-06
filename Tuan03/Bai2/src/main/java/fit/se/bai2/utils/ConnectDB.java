package fit.se.bai2.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private static String URL = "jdbc:mariadb://localhost:3333/22683091";
    private static String USERNAME = "root";
    private static String PASSWORD = "1234567890";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
