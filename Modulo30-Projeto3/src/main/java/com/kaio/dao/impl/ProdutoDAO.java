package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IProdutoDAO;
import com.kaio.domain.Produto;
import com.kaio.exception.DAOException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public String getTableName() {
        return "produto";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO produto (id, codigo, nome, descricao, valor_unitario, categoria_id) " +
                "VALUES (nextval('produto_id_seq'), ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
        stmInsert.setString(1, entity.getCodigo());
        stmInsert.setString(2, entity.getNome());
        stmInsert.setString(3, entity.getDescricao());
        stmInsert.setBigDecimal(4, entity.getValorUnitario());
        stmInsert.setLong(5, entity.getCategoriaId());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM produto WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long id) throws SQLException {
        stmExclusao.setLong(1, id);
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE produto SET codigo = ?, nome = ?, descricao = ?, valor_unitario = ?, categoria_id = ? WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
        stmUpdate.setString(1, entity.getCodigo());
        stmUpdate.setString(2, entity.getNome());
        stmUpdate.setString(3, entity.getDescricao());
        stmUpdate.setBigDecimal(4, entity.getValorUnitario());
        stmUpdate.setLong(5, entity.getCategoriaId());
        stmUpdate.setLong(6, entity.getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long id) throws SQLException {
        stmSelect.setLong(1, id);
    }

    @Override
    protected Produto buildObject(ResultSet rs) throws DAOException {
        try {
            Produto produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setCodigo(rs.getString("codigo"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValorUnitario(rs.getBigDecimal("valor_unitario"));
            produto.setCategoriaId(rs.getLong("categoria_id"));
            return produto;
        } catch (SQLException e) {
            throw new DAOException("Erro ao mapear resultado para Produto", e);
        }
    }

    @Override
    public Produto consultarPorCodigo(String codigo) throws DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM produto WHERE codigo = ?";
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                return buildObject(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro ao consultar produto por código", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
    }
}
