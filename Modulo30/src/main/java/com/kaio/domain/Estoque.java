package com.kaio.domain;

import com.kaio.anotacao.ColunaTabela;
import com.kaio.anotacao.Tabela;
import com.kaio.interfaces.Persistente;

@Tabela("TB_ESTOQUE")
public class Estoque implements Persistente<Long> {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "id_produto", setJavaName = "setProduto")
    private Produto produto;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    public Estoque() {
        this.quantidade = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

