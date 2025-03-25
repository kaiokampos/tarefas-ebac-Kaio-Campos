package com.kaio.domain;

import java.util.Objects;

public class Estoque {

    private Long id;
    private Produto produto;
    private Integer quantidade;

    public Estoque() {}

    public Estoque(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
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

    // Método para adicionar quantidade ao estoque
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    // Método para remover quantidade do estoque (verifica se há estoque suficiente)
    public boolean removerQuantidade(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
            return true;
        }
        return false; // Retorna falso se não houver estoque suficiente
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id) && Objects.equals(produto, estoque.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto);
    }
}

