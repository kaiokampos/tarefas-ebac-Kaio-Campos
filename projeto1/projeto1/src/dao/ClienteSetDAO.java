package dao;

import domain.Cliente;

import java.util.*;
import java.util.stream.Collectors;

public class ClienteSetDAO implements IClienteDAO{
    private Set<Cliente> clientesSet;

    public ClienteSetDAO(){
        clientesSet = new HashSet<>();
    }


    @Override
    public Boolean cadastrar(Cliente cliente) {
        return clientesSet.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        clientesSet.removeIf(cliente -> cliente.getCpf().equals(cpf));
    }

    @Override
    public void alterar(Cliente cliente) {
        excluir(cliente.getCpf());
        cadastrar(cliente);

    }

    @Override
    public Cliente consultar(Long cpf) {
        return clientesSet.stream()
                .filter(cliente -> cliente.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clientesSet.stream().collect(Collectors.toList());
    }
}

