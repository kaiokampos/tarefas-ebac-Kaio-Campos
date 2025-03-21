package kaio.com;


import kaio.com.dao.ClienteDAO;
import kaio.com.dao.ProdutoDAO;
import kaio.com.dao.jdbc.ClienteDAOImpl;
import kaio.com.dao.jdbc.ProdutoDAOImpl;
import kaio.com.domain.Cliente;
import kaio.com.domain.Produto;
import kaio.com.service.interfaces.ClienteDAOInterface;
import kaio.com.service.interfaces.ProdutoDAOInterface;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("CRUD em Java usando JDBC!");

//        // Testando conexão
//        System.out.println("Testando conexão com o PostgreSQL...");
//
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            if (conn != null) {
//                System.out.println("Conexão bem-sucedida! 🚀");
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao conectar: " + e.getMessage());
//        }
//
        /*ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();*/

        /*// Criando um cliente e adicionando ao banco
        Cliente clienteKaio = new Cliente(1, "Kaio", "kaio@email.com");
        clienteDAO.adicionar(clienteKaio);
        System.out.println("Cliente cadastrado com sucesso!");

        // Criando um produto e adicionando ao banco
        Produto produtoTv = new Produto(1, "Tv", 3500);
        produtoDAO.adicionar(produtoTv);
        System.out.println("Produto cadastrado com sucesso!");
*/

       /* // Buscar cliente por ID
        Cliente cliente = clienteDAO.buscarPorId(1);
        if (cliente != null){
            System.out.println("Cliente encontrado" + cliente);
        }else{
            System.out.println("Cliente não encontrado.");
        }

        //Listar todos os clientes
        List<Cliente> clientes = clienteDAO.listarTodos();
        System.out.println("\n Lista de clientes: ");
        for (Cliente client : clientes){
            System.out.println(client);
        }

        // Buscar produto por ID
        Produto produto = produtoDAO.buscarPorId(1);
        if (produto != null){
            System.out.println("Produto encontrado: " + produto);
        }else {
            System.out.println("Produto não encontrado. ");
        }

        // listar todos os produtos
        List<Produto> produtos = produtoDAO.listarTodos();
        System.out.println("\nLista de produtos:");
        for (Produto product : produtos){
            System.out.println(product);
        }*/

        /*// Atualizar um cliente existente
        Cliente clienteAtualizado = new Cliente(1, "Kaio Souza", "kaio.souza@email.com");
        clienteDAO.atualizar(clienteAtualizado);
        System.out.println("Cliente atualizado com sucesso!");

        // Atualizar um produto existente
        Produto produtoAtualizado = new Produto(1, "Notebook Gamer", 4500.00);
        produtoDAO.atualizar(produtoAtualizado);
        System.out.println("Produto atualizado com sucesso!");*/
/*
        // Remover um cliente pelo ID
        int idClienteRemover = 1;
        clienteDAO.remover(idClienteRemover);
        System.out.println("Cliente removido com sucesso!");

        // Remover um produto pelo ID
        int idProdutoRemover = 1;
        produtoDAO.remover(idProdutoRemover);
        System.out.println("Produto removido com sucesso!");*/

        ClienteDAOInterface clienteService = new ClienteDAOImpl(new ClienteDAO());
        ProdutoDAOInterface produtoService = new ProdutoDAOImpl(new ProdutoDAO());

        // Criar um cliente
        Cliente novoCliente = new Cliente(0, "Kaio Souza", "kaio@email.com");
        clienteService.salvar(novoCliente);
        System.out.println("Cliente salvo com sucesso!");

        // Criar um produto
        Produto novoProduto = new Produto(0, "Mouse Gamer", 150.00);
        produtoService.adicionar(novoProduto);
        System.out.println("Produto salvo com sucesso!");

        // Listar todos os clientes
        System.out.println("Lista de clientes:");
        clienteService.listarTodos().forEach(System.out::println);

        // Listar todos os produtos
        System.out.println("Lista de produtos:");
        produtoService.listarTodos().forEach(System.out::println);
    }
}
































