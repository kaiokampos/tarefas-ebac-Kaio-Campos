package kaio.com.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {
        // Impede a instanciação da classe
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:15432/vendas_online_2", "postgres", "admin");
    }
}