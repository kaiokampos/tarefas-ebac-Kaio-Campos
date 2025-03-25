package com.kaio.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe responsável por criar conexões com o banco de dados
public class ConnectionFactory {
    private static Connection connection;

    // Definir o ambiente (produção ou teste)
    private static final String AMBIENTE = System.getenv("PRODUCAO"); // "PRODUCAO" ou "TESTE"

    private ConnectionFactory() {
        // Construtor privado para evitar instanciação externa
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() throws SQLException {
        try {
            // Definindo a URL do banco de dados para produção
            //String url = "jdbc:postgresql://localhost:5432/vendas_online";  // Para Produção

            // Para o banco de dados de teste (se necessário, use esse URL)
            String url = "jdbc:postgresql://localhost:5433/vendas_online_test";  // Para Testes

            // Estabelecendo a conexão com o banco
            return DriverManager.getConnection(url, "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
/*
                        Explicação das melhorias
Uso de synchronized: Torna o método getConnection() thread-safe, evitando condições de corrida.
Construtor privado sem argumentos: Evita que a classe seja instanciada acidentalmente.
Validação de connection.isClosed(): Se a conexão for fechada, criamos uma nova.*/
