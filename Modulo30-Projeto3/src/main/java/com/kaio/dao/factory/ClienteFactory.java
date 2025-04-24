package com.kaio.dao.factory;

import com.kaio.domain.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClienteFactory {

    public static Cliente convert(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        // Convertendo os dados do ResultSet para o Cliente
        cliente.setId(rs.getLong("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setNumero(rs.getInt("numero"));
        cliente.setCidade(rs.getString("cidade"));
        cliente.setEstado(rs.getString("estado"));
        cliente.setEmail(rs.getString("email"));

        // Para o campo data_cadastro, convertendo para LocalDateTime
        String dataCadastroStr = rs.getString("data_cadastro");
        if (dataCadastroStr != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dataCadastro = LocalDateTime.parse(dataCadastroStr, formatter);
            cliente.setDataCadastro(dataCadastro);
        }

        return cliente;
    }
}
