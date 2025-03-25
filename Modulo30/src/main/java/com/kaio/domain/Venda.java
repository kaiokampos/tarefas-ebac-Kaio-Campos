package com.kaio.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Venda {
    public enum Status {
        INICIADA, CONCLUIDA, CANCELADA;

        public static Status getByName(String value) {
            try {
                return Status.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException | NullPointerException e) {
                return null;
            }
        }
    }

    private Long id;
    private String codigo;
    private Cliente cliente;
    private Set<ProdutoQuantidade> produtos = new HashSet<>();
    private BigDecimal valorTotal;
    private Instant dataVenda;
    private Status status;

    public Venda() {
        this.produtos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<ProdutoQuantidade> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

/*
id BIGSERIAL PRIMARY KEY,
codigo VARCHAR(10) NOT NULL,
id_cliente_fk BIGINT NOT NULL,
valor_total NUMERIC(10,2) NOT NULL,
data_venda TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
status_venda VARCHAR(50) NOT NULL,
CONSTRAINT fk_id_cliente_venda FOREIGN KEY(id_cliente_fk) REFERENCES tb_cliente(id),
CONSTRAINT uk_codigo_venda UNIQUE (codigo)
*/

