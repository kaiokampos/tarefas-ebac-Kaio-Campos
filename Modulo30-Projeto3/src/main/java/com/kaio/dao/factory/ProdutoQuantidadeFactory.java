package com.kaio.dao.factory;

import com.kaio.domain.ProdutoQuantidade;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
        ProdutoQuantidade produtoQuantidade = new ProdutoQuantidade();

        // Convertendo os dados do ResultSet para a classe ProdutoQuantidade
        produtoQuantidade.setId(rs.getLong("id"));
        produtoQuantidade.setVendaId(rs.getLong("venda_id"));
        produtoQuantidade.setProdutoId(rs.getLong("produto_id"));
        produtoQuantidade.setQuantidade(rs.getInt("quantidade"));
        produtoQuantidade.setValorUnitario(rs.getBigDecimal("valor_unitario"));

        return produtoQuantidade;
    }
}
