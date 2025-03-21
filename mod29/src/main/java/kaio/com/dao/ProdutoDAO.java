package kaio.com.dao;

import kaio.com.service.interfaces.ProdutoDAOInterface;
import kaio.com.dao.jdbc.connection.ConnectionFactory;
import kaio.com.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements ProdutoDAOInterface {
    private Connection connection;

    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }

    public ProdutoDAO() {

    }
    @Override
    public void adicionar(Produto produto) {
        String sql = "INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar produto", e);
        }
    }

    @Override
    public void atualizar(Produto produto) {
       String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";
       try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.setString(1, produto.getNome());
           preparedStatement.setDouble(2, produto.getPreco());
           preparedStatement.setInt(3, produto.getId());
           preparedStatement.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException("Erro ao atualizar o produto: ", e);
       }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o produto: ", e);
        }
    }

    @Override
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Produto(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o produto: ",e);
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                produtos.add(new Produto(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getDouble("preco")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }
        return produtos;
    }
}

