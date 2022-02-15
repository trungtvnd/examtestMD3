package myConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private String jdbcURL = "jdbc:mysql://localhost:3306/productManagement?useUnicode=true&characterEncoding=UTF-8";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
