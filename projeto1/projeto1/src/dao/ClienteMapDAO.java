package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Kaio
 */

public class ClienteMapDAO implements IClienteDAO{
    private Map<Long, Cliente> clientesMap;

    public ClienteMapDAO() {
        clientesMap = new TreeMap<>();
    }

    /**
     *
     * @param cliente
     * @return false caso o cpf ja contenha/exista na lista de clientesMap
     * @return true caso o cpf não contenha/exista na lista de clientesMap
     *
     */
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (clientesMap.containsKey(cliente.getCpf())){
            return false;
        }
        clientesMap.put(cliente.getCpf(), cliente);
        return true;
    }

    /**
     *
     * @param cpf
     * no projeto do professor ele optou por remover usando um metodo que recebe chave valor.
     * eu optei por remover usando somente a chave, no nosso caso cpf
     */
    @Override
    public void excluir(Long cpf) {
        clientesMap.remove(cpf);
    }

    /**
     *
     * @param cliente
     */
    @Override
    public void alterar(Cliente cliente) {
        clientesMap.put(cliente.getCpf(), cliente);

    }

    @Override
    public Cliente consultar(Long cpf) {
        return clientesMap.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clientesMap.values();
    }
}
