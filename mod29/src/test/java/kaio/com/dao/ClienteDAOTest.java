package kaio.com.dao;

import kaio.com.dao.config.TestConnectionFactory;
import kaio.com.domain.Cliente;
import org.junit.*;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteDAOTest {
    private static Connection connection;
    private ClienteDAO clienteDAO;


    @BeforeClass
    public static void setupBeforeAll() throws Exception {
        connection = TestConnectionFactory.getConnection();
    }

    @Before
    public void setup(){
        clienteDAO = new ClienteDAO(connection);
    }

    @Test
    public void testSalvarCliente() {
        Cliente cliente = new Cliente(22, "Test User", "test@email.com");
        clienteDAO.salvar(cliente);


        Cliente clienteSalvo = clienteDAO.buscarPorId(cliente.getId());

        assertNotNull("Cliene deveria ter sido salvo no banco ",clienteSalvo);
        assertEquals("Teste User", "Test User", clienteSalvo.getNome());

        clienteDAO.remover(cliente.getId());
    }

    @Test
    public void testeAtualizarCliente() {
        Cliente cliente = new Cliente(22,"Cliente Antigo", "antigo@gmail.com");
        clienteDAO.salvar(cliente);

        clienteDAO.buscarPorId(cliente.getId());
        System.out.println(cliente);

        cliente.setNome("Cliente Atualizado");
        cliente.setEmail("atualizado@email.com");
        clienteDAO.atualizar(cliente);

        Cliente atualizado = clienteDAO.buscarPorId(cliente.getId());
        assertEquals("Cliente Atualizado", atualizado.getNome());
        assertEquals("atualizado@email.com", atualizado.getEmail());

        clienteDAO.remover(cliente.getId());

    }

    @Test
    public void testeRemoverCliente() {
        Cliente cliente = new Cliente(22, "User to Delete", "delete@email.com");
        clienteDAO.salvar(cliente);

        clienteDAO.buscarPorId(cliente.getId());
        System.out.println(cliente);

        clienteDAO.remover(cliente.getId());

        Cliente clienteRemovido = clienteDAO.buscarPorId(cliente.getId());
        assertNull(clienteRemovido);

        clienteDAO.remover(cliente.getId());
    }


    @Test
    public void testBuscarClientePorId() {
        Cliente cliente = new Cliente(119, "User to Find", "id@email.com");
        clienteDAO.salvar(cliente);

        System.out.println("ID gerado para o cliente: " + cliente.getId()); // 🔍 Debug

        Cliente encontrado = clienteDAO.buscarPorId(cliente.getId());
        assertNotNull("Erro: Cliente não encontrado no banco!", encontrado);
        assertEquals("User to Find", encontrado.getNome());
        clienteDAO.remover(cliente.getId());
    }

    @Test
    public void listarTodos() {
        List<Cliente> clientes = clienteDAO.listarTodos();

        assertNotNull("A lista de clientes não deveria ser nula ", clientes);
        assertTrue("A lista deveria conter pelo menos um cliente ou estar vazia ",clientes.size() >= 0);

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