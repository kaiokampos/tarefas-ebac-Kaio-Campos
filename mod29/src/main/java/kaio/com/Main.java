package kaio.com;


import kaio.com.dao.ClienteDAO;
import kaio.com.dao.jdbc.ConnectionFactory;
import kaio.com.domain.Cliente;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("CRUD em Java usando JDBC!");

        // Testando conexão
        ConnectionFactory.getConnection();

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente(1, "Kaio", "kaio@email.com");
        clienteDAO.adicionar(cliente);
    }
}