package kaio.com.dao;


import kaio.com.dao.interfaces.ClienteDAOInterface;
import kaio.com.dao.jdbc.ConnectionFactory;
import kaio.com.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements ClienteDAOInterface {
    @Override
    public void adicionar(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nome, email) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar cliente", e);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        // Implementação futura
    }

    @Override
    public void remover(int id) {
        // Implementação futura
    }

    @Override
    public Cliente buscarPorId(int id) {
        return null; // Implementação futura
    }

    @Override
    public List<Cliente> listarTodos() {
        return null; // Implementação futura
    }
}
