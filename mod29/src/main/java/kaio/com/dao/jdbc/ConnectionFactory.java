package kaio.com.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgress://localhost:5432/vendas";
    private static final String USER = "kaio";
    private static final String PASSWORD = "kaio123";

    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
