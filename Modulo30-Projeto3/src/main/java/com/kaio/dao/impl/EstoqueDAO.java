package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IEstoqueDAO;
import com.kaio.domain.Estoque;
import com.kaio.exception.DAOException;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    protected String getTableName() {
        return "estoque";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO estoque (produto_id, quantidade) VALUES (?, ?)";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE estoque SET produto_id = ?, quantidade = ? WHERE id = ?";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM estoque WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque estoque) throws SQLException, DAOException {
        try {
            stmInsert.setLong(1, estoque.getProdutoId());
            stmInsert.setInt(2, estoque.getQuantidade());
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para inserção de estoque", e);
        }
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque estoque) throws SQLException, DAOException {
        try {
            stmUpdate.setLong(1, estoque.getProdutoId());
            stmUpdate.setInt(2, estoque.getQuantidade());
            stmUpdate.setLong(3, estoque.getId());
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para atualização de estoque", e);
        }
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long id) throws SQLException, DAOException {
        try {
            stmExclusao.setLong(1, id);
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para exclusão de estoque", e);
        }
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long id) throws SQLException, DAOException {
        try {
            stmSelect.setLong(1, id);
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para consulta de estoque", e);
        }
    }

    @Override
    protected Estoque buildObject(ResultSet rs) throws DAOException {
        try {
            Long id = rs.getLong("id");
            Long produtoId = rs.getLong("produto_id");
            Integer quantidade = rs.getInt("quantidade");
            return new Estoque(id, produtoId, quantidade);
        } catch (SQLException e) {
            throw new DAOException("Erro ao construir objeto Estoque a partir do ResultSet", e);
        }
    }

    @Override
    public List<Estoque> listar() throws DAOException {
        return super.listar();
    }

    @Override
    public Collection<Estoque> consultarPorFiltro(Estoque filtro) throws DAOException {
        return List.of();
    }

    @Override
    public Estoque consultarPorId(Long id) throws DAOException {
        return super.listar().stream()
                .filter(estoque -> estoque.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Estoque consultarPorProdutoId(Long produtoId) throws DAOException {
        return null;
    }
}
