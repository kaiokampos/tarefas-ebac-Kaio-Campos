package kaio.com.dao.jdbc;

import kaio.com.dao.ClienteDAO;
import kaio.com.domain.Cliente;
import kaio.com.service.interfaces.ClienteDAOInterface;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAOInterface {
    private final ClienteDAO clienteDAO;


    public ClienteDAOImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteDAO.atualizar(cliente);
    }

    @Override
    public void remover(int id) {
        clienteDAO.remover(id);
    }

    @Override
    public Cliente buscarPorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }
}
