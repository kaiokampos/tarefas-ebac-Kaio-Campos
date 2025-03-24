Criei o banco de dados para fazer a persistencia dos dados com o docker

docker run -d \
--name loja-virtual-ebac \
-e POSTGRES_USER=admin \
-e POSTGRES_PASSWORD=admin \
-e POSTGRES_DB=loja-virtual-ebac \
-p 5432:5432 \
postgres:latest



docker exec -it loja-virtual-ebac psql -U admin -d loja-virtual-ebac



CREATE TABLE clientes (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE produtos (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
preco DECIMAL(10,2) NOT NULL
);

Isso exibe a estrutura das tabelas.
\d clientes
\d produtos

docker exec -it loja-virtual-ebac psql -U admin

CREATE DATABASE loja_virtual_ebac_test;
CREATE TABLE clientes ( id SERIAL PRIMARY KEY, nome VARCHAR(100) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL );
CREATE TABLE produtos ( id SERIAL PRIMARY KEY, nome VARCHAR(100) NOT NULL, preco DECIMAL(10,2) NOT NULL );

assim ficamos com a mestra estrutuda do banco de producao, no banco de testes