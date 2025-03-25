package com.kaio.domain;

import com.kaio.anotacao.ColunaTabela;
import com.kaio.anotacao.Tabela;
import com.kaio.anotacao.TipoChave;
import com.kaio.interfaces.Persistente;

@Tabela("TB_CLIENTE")
public class Cliente implements Persistente<Long> {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "nome", setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "email", setJavaName = "setEmail")
    private String email;

    @TipoChave("getCpf")
    @ColunaTabela(dbName = "cpf", setJavaName = "setCpf")
    private String cpf; // Alterado para String para evitar perda de informação

    @ColunaTabela(dbName = "tel", setJavaName = "setTelefone")
    private String telefone; // Alterado para String

    @ColunaTabela(dbName = "endereco", setJavaName = "setEndereco")
    private String endereco; // Renomeado para manter consistência

    @ColunaTabela(dbName = "numero", setJavaName = "setNumero")
    private Integer numero;

    @ColunaTabela(dbName = "cidade", setJavaName = "setCidade")
    private String cidade;

    @ColunaTabela(dbName = "estado", setJavaName = "setEstado")
    private String estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nome='" + nome + "', cpf='" + cpf + "', telefone='" + telefone + "', endereco='" + endereco + "', numero=" + numero + ", cidade='" + cidade + "', estado='" + estado + "'}";
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
