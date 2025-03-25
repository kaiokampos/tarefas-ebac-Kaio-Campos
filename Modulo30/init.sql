-- Criação das tabelas no banco de dados

-- Tabela de Cliente
CREATE TABLE tb_cliente (
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
);

-- Tabela de Produto
CREATE TABLE tb_produto (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    CONSTRAINT uk_codigo_produto UNIQUE (codigo)
);

-- Tabela de Venda
CREATE TABLE tb_venda (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL,
    id_cliente_fk BIGINT NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL,
    data_venda TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status_venda VARCHAR(50) NOT NULL,
    CONSTRAINT fk_id_cliente_venda FOREIGN KEY(id_cliente_fk) REFERENCES tb_cliente(id),
    CONSTRAINT uk_codigo_venda UNIQUE (codigo)
);

-- Tabela de Produto Quantidade (Relacionamento entre produto e venda)
CREATE TABLE tb_produto_quantidade (
    id BIGSERIAL PRIMARY KEY,
    id_produto_fk BIGINT NOT NULL,
    id_venda_fk BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_total NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_id_prod_venda FOREIGN KEY(id_produto_fk) REFERENCES tb_produto(id),
    CONSTRAINT fk_id_prod_venda_venda FOREIGN KEY(id_venda_fk) REFERENCES tb_venda(id)
);

-- Criação da tabela estoque
CREATE TABLE tb_estoque (
    id BIGSERIAL PRIMARY KEY,
    id_produto_fk BIGINT NOT NULL,
    quantidade_em_estoque INT NOT NULL,
    CONSTRAINT fk_id_produto_estoque FOREIGN KEY(id_produto_fk) REFERENCES tb_produto(id)
);
