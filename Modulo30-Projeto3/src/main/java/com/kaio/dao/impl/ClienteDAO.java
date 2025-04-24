package com.kaio.dao.impl;

import com.kaio.dao.interfaces.IClienteDAO;
import com.kaio.domain.Cliente;
import com.kaio.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    public String getTableName() {
        return "cliente";
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO cliente (id, nome, cpf, tel, endereco, numero, cidade, estado, email, data_cadastro) " +
                "VALUES (nextval('cliente_id_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException, DAOException {
        stmInsert.setString(1, entity.getNome());
        stmInsert.setString(2, entity.getCpf());
        stmInsert.setString(3, entity.getTelefone());
        stmInsert.setString(4, entity.getEndereco());
        stmInsert.setInt(5, entity.getNumero());
        stmInsert.setString(6, entity.getCidade());
        stmInsert.setString(7, entity.getEstado());
        stmInsert.setString(8, entity.getEmail());
        stmInsert.setTimestamp(9, Timestamp.valueOf(entity.getDataCadastro()));
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM cliente WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException, DAOException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE cliente SET nome = ?, cpf = ?, tel = ?, endereco = ?, numero = ?, cidade = ?, estado = ?, email = ?, data_cadastro = ? WHERE id = ?";
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException, DAOException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setString(2, entity.getCpf());
        stmUpdate.setString(3, entity.getTelefone());
        stmUpdate.setString(4, entity.getEndereco());
        stmUpdate.setInt(5, entity.getNumero());
        stmUpdate.setString(6, entity.getCidade());
        stmUpdate.setString(7, entity.getEstado());
        stmUpdate.setString(8, entity.getEmail());
        stmUpdate.setTimestamp(9, Timestamp.valueOf(entity.getDataCadastro()));
        stmUpdate.setLong(10, entity.getId());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException, DAOException {
        stmSelect.setLong(1, valor);
    }

    @Override
    protected Cliente buildObject(ResultSet rs) throws DAOException {
        try {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("tel"));
            cliente.setEndereco(rs.getString("endereco"));
            cliente.setNumero(rs.getInt("numero"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setEmail(rs.getString("email"));
            Timestamp timestamp = rs.getTimestamp("data_cadastro");
            cliente.setDataCadastro(timestamp != null ? timestamp.toLocalDateTime() : null);
            return cliente;
        } catch (SQLException e) {
            throw new DAOException("Erro ao mapear resultado para Cliente");
        }
    }

    @Override
    public Cliente consultarPorCPF(String cpf) throws DAOException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM cliente WHERE cpf = ?";
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, cpf);
            rs = stm.executeQuery();
            if (rs.next()) {
                return buildObject(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro ao consultar cliente por CPF");
        } finally {
            closeConnection(connection, stm, rs);
        }
    }

}
