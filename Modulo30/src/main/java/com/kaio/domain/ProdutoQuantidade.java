package com.kaio.domain;

import java.math.BigDecimal;
import java.util.Objects;

@Tabela("TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    private Produto produto;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    @ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
    private BigDecimal valorTotal;

    public ProdutoQuantidade() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
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
        recalcularValorTotal();
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void adicionar(Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade += quantidade;
        recalcularValorTotal();
    }

    public void remover(Integer quantidade) {
        if (quantidade <= 0 || quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade inválida para remoção.");
        }
        this.quantidade -= quantidade;
        recalcularValorTotal();
    }

    private void recalcularValorTotal() {
        if (produto != null) {
            this.valorTotal = produto.getValor().multiply(BigDecimal.valueOf(this.quantidade));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoQuantidade that = (ProdutoQuantidade) o;
        return Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }

    @Override
    public String toString() {
        return "ProdutoQuantidade{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
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
