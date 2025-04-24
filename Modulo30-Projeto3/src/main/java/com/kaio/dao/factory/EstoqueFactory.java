package com.kaio.dao.factory;

import com.kaio.domain.Estoque;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueFactory {

    public static Estoque convert(ResultSet rs) throws SQLException {
        Estoque estoque = new Estoque();

        // Convertendo os dados do ResultSet para o Estoque
        estoque.setId(rs.getLong("id"));
        estoque.setProdutoId(rs.getLong("produto_id"));
        estoque.setQuantidade(rs.getInt("quantidade"));

        return estoque;
    }
}
