package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IVendaDAO;
import com.kaio.domain.Venda;
import com.kaio.exception.DAOException;

import java.math.BigDecimal;
import java.sql.*;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    protected String getTableName() {
        return "venda";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO venda (id, cliente_id, valor_total) VALUES (?, ?, ?)";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE venda SET cliente_id = ?, valor_total = ? WHERE id = ?";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM venda WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Venda venda) throws SQLException {
        stmInsert.setLong(1, venda.getId());
        stmInsert.setLong(2, venda.getClienteId());
        stmInsert.setBigDecimal(3, venda.getValorTotal());
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Venda venda) throws SQLException {
        stmUpdate.setLong(1, venda.getClienteId());
        stmUpdate.setBigDecimal(2, venda.getValorTotal());
        stmUpdate.setLong(3, venda.getId());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long id) throws SQLException {
        stmExclusao.setLong(1, id);
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long id) throws SQLException {
        stmSelect.setLong(1, id);
    }

    @Override
    protected Venda buildObject(ResultSet rs) throws DAOException {
        try {
            Venda venda = new Venda();
            venda.setId(rs.getLong("id"));
            venda.setClienteId(rs.getLong("cliente_id"));
            venda.setValorTotal(rs.getBigDecimal("valor_total"));
            return venda;
        } catch (SQLException e) {
            throw new DAOException("Erro ao construir objeto Venda", e);
        }
    }

    @Override
    public Venda consultarPorClienteId(Long clienteId) throws DAOException {
        return null;
    }
}
