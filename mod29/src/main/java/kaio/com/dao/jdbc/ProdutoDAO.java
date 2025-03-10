package kaio.com.dao.jdbc;

import kaio.com.dao.interfaces.ProdutoDAOInterface;
import kaio.com.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAO implements ProdutoDAOInterface {
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
        // Implementação futura
    }

    @Override
    public void remover(int id) {
        // Implementação futura
    }

    @Override
    public Produto buscarPorId(int id) {
        return null; // Implementação futura
    }

    @Override
    public List<Produto> listarTodos() {
        return null; // Implementação futura
    }
}

