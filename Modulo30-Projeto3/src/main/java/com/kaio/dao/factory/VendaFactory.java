package com.kaio.dao.factory;

import com.kaio.domain.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaFactory {

    public static Venda convert(ResultSet rs) throws SQLException {
        Venda venda = new Venda();

        // Convertendo os dados do ResultSet para a classe Venda
        venda.setId(rs.getLong("id"));
        venda.setClienteId(rs.getLong("cliente_id"));
        venda.setValorTotal(rs.getBigDecimal("valor_total"));

        return venda;
    }
}
