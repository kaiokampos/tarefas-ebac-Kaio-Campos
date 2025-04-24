package com.kaio.domain;

import java.math.BigDecimal;

/**
 * Representa um item vendido dentro de uma venda,
 * associando um produto, sua quantidade e valor unitário.
 */
public class ProdutoQuantidade implements IPersistente<Long> {
    private Long id;
    private Long vendaId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public ProdutoQuantidade() {
    }

    public ProdutoQuantidade(Long id, Long vendaId, Long produtoId, Integer quantidade, BigDecimal valorUnitario) {
        this.id = id;
        this.vendaId = vendaId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "ProdutoQuantidade{id=" + id + ", vendaId=" + vendaId + ", produtoId=" + produtoId +
                ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + "}";
    }
}
