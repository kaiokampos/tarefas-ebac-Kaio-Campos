package com.kaio.domain;

/**
 * Representa o estoque de um produto.
 */
public class Estoque implements IPersistente<Long> {
    private Long id;
    private Long produtoId;
    private Integer quantidade;

    public Estoque() {
    }

    public Estoque(Long id, Long produtoId, Integer quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Estoque{id=" + id + ", produtoId=" + produtoId + ", quantidade=" + quantidade + "}";
    }
}
