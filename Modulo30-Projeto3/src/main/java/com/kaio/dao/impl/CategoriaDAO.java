package com.kaio.dao.impl;

import com.kaio.dao.interfaces.ICategoriaDAO;
import com.kaio.domain.Categoria;
import com.kaio.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoriaDAO extends GenericDAO<Categoria, Long> implements ICategoriaDAO {

    @Override
    public Class<Categoria> getTipoClasse() {
        return Categoria.class;
    }

    @Override
    protected String getTableName() {
        return "categoria";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO categoria (nome) VALUES (?)";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE categoria SET nome = ? WHERE id = ?";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM categoria WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Categoria categoria) throws SQLException, DAOException {
        try {
            stmInsert.setString(1, categoria.getNome());
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para inserção de categoria", e);
        }
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Categoria categoria) throws SQLException, DAOException {
        try {
            stmUpdate.setString(1, categoria.getNome());
            stmUpdate.setLong(2, categoria.getId());
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para atualização de categoria", e);
        }
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long id) throws SQLException, DAOException {
        try {
            stmExclusao.setLong(1, id);
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para exclusão de categoria", e);
        }
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long id) throws SQLException, DAOException {
        try {
            stmSelect.setLong(1, id);
        } catch (SQLException e) {
            throw new DAOException("Erro ao setar parâmetros para consulta de categoria", e);
        }
    }

    @Override
    protected Categoria buildObject(ResultSet rs) throws DAOException {
        try {
            Long id = rs.getLong("id");
            String nome = rs.getString("nome");
            return new Categoria(id, nome);
        } catch (SQLException e) {
            throw new DAOException("Erro ao construir objeto Categoria a partir do ResultSet", e);
        }
    }


    @Override
    public Categoria consultarPorId(Long aLong) throws DAOException {
        return null;
    }

    @Override
    public List<Categoria> listar() throws DAOException {
        return super.listar();
    }

    @Override
    public Collection<Categoria> consultarPorFiltro(Categoria filtro) throws DAOException {
        return List.of();
    }

    @Override
    public Categoria consultarPorNome(String nome) throws DAOException {
        // Implementação para consultar por nome
        return null; // Exemplo de retorno, deve ser implementado
    }

    @Override
    public Collection<Categoria> consultarPorFiltro(String filtro) throws DAOException {
        Collection<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria WHERE nome LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getLong("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }

        } catch (Exception e) {
            throw new DAOException("Erro ao consultar categorias por filtro", e);
        }

        return categorias;
    }
}
