package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IProdutoQuantidadeDAO;
import com.kaio.domain.ProdutoQuantidade;
import com.kaio.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoQuantidadeDAO extends GenericDAO<ProdutoQuantidade, Long> implements IProdutoQuantidadeDAO {

    public ProdutoQuantidadeDAO() {
        super();
    }

    @Override
    public Class<ProdutoQuantidade> getTipoClasse() {
        return ProdutoQuantidade.class;
    }

    @Override
    public String getTableName() {
        return "produto_quantidade";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO produto_quantidade (id, venda_id, produto_id, quantidade, valor_unitario) " +
                "VALUES (nextval('produto_quantidade_id_seq'), ?, ?, ?, ?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stm, ProdutoQuantidade entity) throws SQLException {
        stm.setLong(1, entity.getVendaId());
        stm.setLong(2, entity.getProdutoId());
        stm.setInt(3, entity.getQuantidade());
        stm.setBigDecimal(4, entity.getValorUnitario());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM produto_quantidade WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stm, Long id) throws SQLException {
        stm.setLong(1, id);
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE produto_quantidade SET venda_id = ?, produto_id = ?, quantidade = ?, valor_unitario = ? " +
                "WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stm, ProdutoQuantidade entity) throws SQLException {
        stm.setLong(1, entity.getVendaId());
        stm.setLong(2, entity.getProdutoId());
        stm.setInt(3, entity.getQuantidade());
        stm.setBigDecimal(4, entity.getValorUnitario());
        stm.setLong(5, entity.getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stm, Long id) throws SQLException {
        stm.setLong(1, id);
    }

    @Override
    protected ProdutoQuantidade buildObject(ResultSet rs) throws DAOException {
        try {
            ProdutoQuantidade pq = new ProdutoQuantidade();
            pq.setId(rs.getLong("id"));
            pq.setVendaId(rs.getLong("venda_id"));
            pq.setProdutoId(rs.getLong("produto_id"));
            pq.setQuantidade(rs.getInt("quantidade"));
            pq.setValorUnitario(rs.getBigDecimal("valor_unitario"));
            return pq;
        } catch (SQLException e) {
            throw new DAOException("Erro ao mapear resultado para ProdutoQuantidade", e);
        }
    }

    @Override
    public List<ProdutoQuantidade> consultarPorVendaId(Long vendaId) throws DAOException {
        List<ProdutoQuantidade> itens = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM produto_quantidade WHERE venda_id = ?";
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setLong(1, vendaId);
            rs = stm.executeQuery();

            while (rs.next()) {
                itens.add(buildObject(rs));
            }

            return itens;
        } catch (SQLException e) {
            throw new DAOException("Erro ao consultar ProdutoQuantidade por venda_id", e);
        } finally {
            closeConnection(connection, stm, rs);
        }
    }
}
