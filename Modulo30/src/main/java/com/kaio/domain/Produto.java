package com.kaio.domain;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;  // Alterado para Double para representar valores com casas decimais
    private String categoria;  // Novo campo categoria

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
/*
* id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    CONSTRAINT uk_codigo_produto UNIQUE (codigo)
* */