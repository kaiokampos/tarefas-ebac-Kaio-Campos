package com.kaio.domain;

import java.math.BigDecimal;

/**
 * Representa uma venda realizada para um cliente.
 */
public class Venda implements IPersistente<Long> {
    private Long id;
    private Long clienteId;
    private BigDecimal valorTotal;

    public Venda() {
    }

    public Venda(Long id, Long clienteId, BigDecimal valorTotal) {
        this.id = id;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{id=" + id + ", clienteId=" + clienteId + ", valorTotal=" + valorTotal + "}";
    }
}
