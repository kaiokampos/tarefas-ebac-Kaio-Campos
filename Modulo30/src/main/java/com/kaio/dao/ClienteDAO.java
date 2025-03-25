package com.kaio.dao;

import com.kaio.domain.Cliente;
import com.kaio.exceptions.DAOException;
import com.kaio.generic.dao.GenericDAO;
import com.kaio.interfaces.dao.IClienteDAO;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setTelefone(entity.getTelefone());
        entityCadastrado.setEmail(entity.getEmail()); // ✅ Adicionando email
        entityCadastrado.setEndereco(entity.getEndereco());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setEstado(entity.getEstado());
    }

    @Override
    protected String getQueryInsercao() {
        return """
            INSERT INTO TB_CLIENTE
            (ID, NOME, CPF, TEL, EMAIL, ENDERECO, NUMERO, CIDADE, ESTADO)
            VALUES (nextval('sq_cliente'), ?, ?, ?, ?, ?, ?, ?, ?)
            """;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
        stmInsert.setString(1, entity.getNome());
        stmInsert.setString(2, entity.getCpf());   // ✅ Alterado para String
        stmInsert.setString(3, entity.getTelefone());   // ✅ Alterado para String
        stmInsert.setString(4, entity.getEmail()); // ✅ Adicionado email
        stmInsert.setString(5, entity.getEndereco());
        stmInsert.setInt(6, entity.getNumero());
        stmInsert.setString(7, entity.getCidade());
        stmInsert.setString(8, entity.getEstado());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return """
            UPDATE TB_CLIENTE 
            SET NOME = ?, TEL = ?, EMAIL = ?, ENDERECO = ?, 
                NUMERO = ?, CIDADE = ?, ESTADO = ?
            WHERE CPF = ?
            """;
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setString(2, entity.getTelefone());   // ✅ Alterado para String
        stmUpdate.setString(3, entity.getEmail()); // ✅ Adicionado email
        stmUpdate.setString(4, entity.getEndereco());
        stmUpdate.setInt(5, entity.getNumero());
        stmUpdate.setString(6, entity.getCidade());
        stmUpdate.setString(7, entity.getEstado());
        stmUpdate.setString(8, entity.getCpf());   // ✅ Alterado para String
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return List.of();
    }
}
