package com.kaio.dao.factory;

import com.kaio.domain.Produto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoFactory {

    public static Produto convert(ResultSet rs) throws SQLException {
        Produto produto = new Produto();

        // Convertendo os dados do ResultSet para o Produto
        produto.setId(rs.getLong("id"));
        produto.setCodigo(rs.getString("codigo"));
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setValorUnitario(rs.getBigDecimal("valor_unitario"));
        produto.setCategoriaId(rs.getLong("categoria_id"));

        return produto;
    }
}
