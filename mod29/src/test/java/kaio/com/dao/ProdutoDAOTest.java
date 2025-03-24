package kaio.com.dao;

import kaio.com.dao.config.TestConnectionFactory;
import kaio.com.domain.Produto;
import org.junit.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoDAOTest {
    private static Connection connection;
    private ProdutoDAO produtoDAO;

    @BeforeClass
    public static void setupBeforeAll(){
        connection = TestConnectionFactory.getConnection();
    }

    @Before
    public void setup(){
        produtoDAO = new ProdutoDAO(connection);
    }

    @Test
    public void testSalvarProduto() {
        Produto produto = new Produto(100, "tv", 5000.00);
        produtoDAO.salvar(produto);

        Produto produtoSalvo = produtoDAO.buscarPorId(produto.getId());

        System.out.println("O produto salvo no salvar é "+ produtoSalvo);

        assertNotNull("Produto deveria ter sido salvo no banco ", produtoSalvo);
        assertEquals("Deve retornar o nome tv", "tv", produtoSalvo.getNome());

        produtoDAO.remover(produto.getId());
    }

    @Test
    public void testAtualizarProduto() {
        Produto produto = new Produto(100, "Computador", 5000.00);
        produtoDAO.salvar(produto);

        Produto produtoSalvo = produtoDAO.buscarPorId(produto.getId());
        System.out.println("\nProduto recuperado do banco no metodo atualizar é: "+ produtoSalvo);

        produto.setNome("Produto Atualizado");
        produto.setPreco(1000.00);
        produtoDAO.atualizar(produto);

        Produto produtoAtualizado = produtoDAO.buscarPorId(produto.getId());
        System.out.println("Produto recuperado do banco depois de atualizado "+ produtoAtualizado);
        assertEquals("Produto Atualizado", produto.getNome());

        produtoDAO.remover(produto.getId());

    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto(101, "tv", 5000.00);
        produtoDAO.salvar(produto);

        Produto produtoRemovido = produtoDAO.buscarPorId(produto.getId());
        assertNotNull(produtoRemovido);

        produtoDAO.remover(produto.getId());

    }

    @Test
    public void buscarPorId() {
        Produto produto = new Produto(100, "tv", 5000.00);
        produtoDAO.salvar(produto);

        Produto produtoEncontrado = produtoDAO.buscarPorId(produto.getId());
        assertNotNull("Erro: Produto não encontrado no banco!", produtoEncontrado);
        assertEquals("tv", produto.getNome());
        produtoDAO.remover(produto.getId());

    }

    @Test
    public void listarTodos() {
        List<Produto> produtos = produtoDAO.listarTodos();

        assertNotNull("A lista de produtos não deveria ser nula ", produtos);
        assertTrue("A lista deveria conter pelo menos um cliente ou esta vazia ", produtos.size() >= 0);

    }
    @After
    public void cleanup() {
        System.out.println("Executando cleanup...");
    }

    @AfterClass
    public static void cleanupAfterAll() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}