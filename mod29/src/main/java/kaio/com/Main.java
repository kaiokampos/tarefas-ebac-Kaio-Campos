package kaio.com;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("CRUD em Java usando JDBC!");
        try (Connection connection = getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}