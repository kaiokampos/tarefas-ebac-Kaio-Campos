package kaio.com.dao;


import kaio.com.service.interfaces.ClienteDAOInterface;
import kaio.com.dao.jdbc.connection.ConnectionFactory;
import kaio.com.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ClienteDAOInterface {
    private Connection connection;

    public ClienteDAO(Connection connection){
        this.connection = connection;
    }

    public ClienteDAO() {

    }

    @Override
    public void salvar(Cliente cliente) {
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
        String sql = "UPDATE clientes SET nome = ?, email = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setInt(3, cliente.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o cliente", e);
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover o cliente: ", e);
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cliente não encontrado: "+e);
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()){
                clientes.add(new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: ", e);
        }
        return clientes;
    }
}































