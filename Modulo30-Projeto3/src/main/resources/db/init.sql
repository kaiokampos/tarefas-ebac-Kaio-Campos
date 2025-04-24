CREATE SEQUENCE IF NOT EXISTS cliente_id_seq;
CREATE SEQUENCE IF NOT EXISTS categoria_id_seq;
CREATE SEQUENCE IF NOT EXISTS produto_id_seq;
CREATE SEQUENCE IF NOT EXISTS estoque_id_seq;
CREATE SEQUENCE IF NOT EXISTS venda_id_seq;
CREATE SEQUENCE IF NOT EXISTS produto_quantidade_id_seq;

CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(100),
    numero INTEGER,
    cidade VARCHAR(50),
    estado VARCHAR(2),
    email VARCHAR(100) UNIQUE NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS categoria (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS produto (
    id BIGINT PRIMARY KEY,
    codigo VARCHAR(10) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    valor_unitario DECIMAL(10, 2) NOT NULL,
    categoria_id BIGINT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS estoque (
    id BIGINT PRIMARY KEY,
    produto_id BIGINT UNIQUE,
    quantidade INTEGER NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE IF NOT EXISTS venda (
    id BIGINT PRIMARY KEY,
    cliente_id BIGINT,
    valor_total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS produto_quantidade (
    id BIGINT PRIMARY KEY,
    venda_id BIGINT,
    produto_id BIGINT,
    quantidade INTEGER NOT NULL,
    valor_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES venda(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
