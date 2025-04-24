package com.kaio.service.impl;

import com.kaio.dao.interfaces.IClienteDAO;
import com.kaio.domain.Cliente;
import com.kaio.exception.DAOException;
import com.kaio.service.interfaces.IClienteService;


public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    private final IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO dao) {
        super(dao);
        this.clienteDAO = dao;
    }

    @Override
    public Cliente consultarPorCPF(String cpf) throws DAOException {
        try {
            return clienteDAO.consultarPorCPF(cpf);
        } catch (DAOException e) {
            throw new DAOException("Erro ao tentar consultar o cliente pelo CPF: " + cpf, e);
        }
    }

}
