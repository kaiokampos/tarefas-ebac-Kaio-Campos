package kaio.com.service.interfaces;

import kaio.com.domain.Cliente;

import java.util.List;

public interface ClienteDAOInterface {
    void adicionar(Cliente cliente);
    void atualizar(Cliente cliente);
    void remover(int id);
    Cliente buscarPorId(int id);
    List<Cliente> listarTodos();
}

