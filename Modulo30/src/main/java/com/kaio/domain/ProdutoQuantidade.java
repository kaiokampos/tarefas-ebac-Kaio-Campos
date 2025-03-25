package com.kaio.domain;

import java.math.BigDecimal;

public class ProdutoQuantidade {
    private Long id;
    private Produto produto;  // Relacionamento com Produto
    private Venda venda;  // Relacionamento com Venda
    private Integer quantidade;
    private BigDecimal valorTotal;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
    }
}

/*
id BIGSERIAL PRIMARY KEY,
id_produto_fk BIGINT NOT NULL,
id_venda_fk BIGINT NOT NULL,
quantidade INT NOT NULL,
valor_total NUMERIC(10,2) NOT NULL,
CONSTRAINT fk_id_prod_venda FOREIGN KEY(id_produto_fk) REFERENCES tb_produto(id),
CONSTRAINT fk_id_prod_venda_venda FOREIGN KEY(id_venda_fk) REFERENCES tb_venda(id)
*/
