package com.kaio.domain;

import com.kaio.interfaces.Persistente;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Tabela("TB_VENDA")
public class Venda implements Persistente<Long> {

    public enum Status {
        INICIADA, CONCLUIDA, CANCELADA;

        public static Status getByName(String value) {
            for (Status status : Status.values()) {
                if (status.name().equalsIgnoreCase(value)) {
                    return status;
                }
            }
            return null;
        }
    }

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
    private String codigo;

    @ColunaTabela(dbName = "id_cliente_fk", setJavaName = "setIdClienteFk")
    private Long idClienteFk;

    private Cliente cliente;

    private Set<ProdutoQuantidade> produtos;

    @ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
    private BigDecimal valorTotal;

    @ColunaTabela(dbName = "data_venda", setJavaName = "setDataVenda")
    private Instant dataVenda;

    @ColunaTabela(dbName = "status_venda", setJavaName = "setStatus")
    private Status status;

    public Venda() {
        this.produtos = new HashSet<>();
        this.valorTotal = BigDecimal.ZERO;
    }

    // Getters e Setters
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(Long idClienteFk) {
        this.idClienteFk = idClienteFk;
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

    // Métodos de negócio
    public void adicionarProduto(Produto produto, Integer quantidade) {
        validarStatus();
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        Optional<ProdutoQuantidade> op = produtos.stream()
                .filter(pq -> pq.getProduto().getCodigo().equals(produto.getCodigo()))
                .findAny();

        if (op.isPresent()) {
            ProdutoQuantidade produtoQtd = op.get();
            produtoQtd.adicionar(quantidade);
        } else {
            ProdutoQuantidade novoProdutoQtd = new ProdutoQuantidade();
            novoProdutoQtd.setProduto(produto);
            novoProdutoQtd.adicionar(quantidade);
            produtos.add(novoProdutoQtd);
        }
        recalcularValorTotalVenda();
    }

    public void removerProduto(Produto produto, Integer quantidade) {
        validarStatus();

        Optional<ProdutoQuantidade> op = produtos.stream()
                .filter(pq -> pq.getProduto().getCodigo().equals(produto.getCodigo()))
                .findAny();

        if (op.isPresent()) {
            ProdutoQuantidade produtoQtd = op.get();
            if (produtoQtd.getQuantidade() > quantidade) {
                produtoQtd.remover(quantidade);
            } else {
                produtos.remove(produtoQtd);
            }
            recalcularValorTotalVenda();
        }
    }

    public void removerTodosProdutos() {
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public int getQuantidadeTotalProdutos() {
        return produtos.stream().mapToInt(ProdutoQuantidade::getQuantidade).sum();
    }

    private void validarStatus() {
        if (this.status == Status.CONCLUIDA) {
            throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
        }
    }

    public void recalcularValorTotalVenda() {
        this.valorTotal = produtos.stream()
                .map(ProdutoQuantidade::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Equals e HashCode baseados no código da venda
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(codigo, venda.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // toString para facilitar logs e debug
    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", idClienteFk=" + idClienteFk +
                ", valorTotal=" + valorTotal +
                ", dataVenda=" + dataVenda +
                ", status=" + status +
                ", produtos=" + produtos +
                '}';
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

