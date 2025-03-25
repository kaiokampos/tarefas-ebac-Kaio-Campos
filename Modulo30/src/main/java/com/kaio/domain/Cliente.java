package com.kaio.domain;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private Long numero;
    private String cidade;
    private String estado;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*

id BIGSERIAL PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
cpf VARCHAR(11) NOT NULL,
tel VARCHAR(15) NOT NULL,
endereco VARCHAR(100) NOT NULL,
numero BIGINT NOT NULL,
cidade VARCHAR(50) NOT NULL,
estado VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT uk_cpf_cliente UNIQUE (cpf)


*/
