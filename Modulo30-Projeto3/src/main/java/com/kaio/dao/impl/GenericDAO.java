package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IGenericDAO;
import com.kaio.exception.DAOException;
import com.kaio.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T, ID> implements IGenericDAO<T, ID> {

    protected Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection();
    }

    protected void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // ou use um logger
        }
    }

    @Override
    public boolean salvar(T entity) throws DAOException {
        Connection conn = null;
        PreparedStatement stmInsert = null;
        try {
            conn = getConnection();
            String query = getQueryInsercao();
            stmInsert = conn.prepareStatement(query);
            setParametrosQueryInsercao(stmInsert, entity);
            int rowsInserted = stmInsert.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new DAOException("Erro ao salvar");
        } finally {
            closeConnection(conn, stmInsert, null);
        }
    }

    @Override
    public boolean atualizar(T entity) throws DAOException {
        Connection connection = null;
        PreparedStatement stmUpdate = null;
        try {
            connection = getConnection();
            stmUpdate = connection.prepareStatement(getQueryAtualizacao());
            setParametrosQueryAtualizacao(stmUpdate, entity);
            int rowsUpdated = stmUpdate.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DAOException("Erro ao atualizar registro");
        } finally {
            closeConnection(connection, stmUpdate, null);
        }
    }

    @Override
    public boolean deletar(ID valor) throws DAOException {
        Connection connection = null;
        PreparedStatement stmExclusao = null;
        try {
            connection = getConnection();
            stmExclusao = connection.prepareStatement(getQueryExclusao());
            setParametrosQueryExclusao(stmExclusao, valor);
            int rowsDeleted = stmExclusao.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new DAOException("Erro ao excluir registro");
        } finally {
            closeConnection(connection, stmExclusao, null);
        }
    }

    @Override
    public List<T> listar() throws DAOException {
        Connection conn = null;
        PreparedStatement stmSelect = null;
        ResultSet rs = null;
        List<T> lista = new ArrayList<>();
        try {
            conn = getConnection();
            String query = "SELECT * FROM " + getTableName();
            stmSelect = conn.prepareStatement(query);
            rs = stmSelect.executeQuery();
            while (rs.next()) {
                lista.add(buildObject(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro ao listar registros");
        } finally {
            closeConnection(conn, stmSelect, rs);
        }
    }

    // Métodos abstratos que devem ser implementados pelas classes concretas
    public abstract Class<T> getTipoClasse();
    protected abstract String getTableName();
    protected abstract String getQueryInsercao();
    protected abstract String getQueryAtualizacao();
    protected abstract String getQueryExclusao();

    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, T entity) throws SQLException, DAOException;
    protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, T entity) throws SQLException, DAOException;
    protected abstract void setParametrosQueryExclusao(PreparedStatement stmExclusao, ID id) throws SQLException, DAOException;
    protected abstract void setParametrosQuerySelect(PreparedStatement stmSelect, ID id) throws SQLException, DAOException;

    protected abstract T buildObject(ResultSet rs) throws DAOException;
}
