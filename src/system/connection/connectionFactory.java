package system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    private static final String URL = "jdbc:mysql://localhost:3306/students_crud";

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS_NAME);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
