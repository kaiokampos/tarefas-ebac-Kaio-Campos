package com.kaio.dao.factory;

import com.kaio.domain.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaFactory {

    public static Categoria convert(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();

        // Convertendo os dados do ResultSet para a Categoria
        categoria.setId(rs.getLong("id"));
        categoria.setNome(rs.getString("nome"));

        return categoria;
    }
}
