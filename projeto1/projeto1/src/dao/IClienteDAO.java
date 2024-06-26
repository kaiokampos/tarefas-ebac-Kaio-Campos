package dao;

import domain.Cliente;

import java.util.Collection;

/**
 * @author Kaio
 * Contrato para operações de CRUD de Cliente
 */
public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();

}
