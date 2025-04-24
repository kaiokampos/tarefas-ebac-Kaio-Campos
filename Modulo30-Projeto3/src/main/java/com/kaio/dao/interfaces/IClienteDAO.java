package com.kaio.dao.interfaces;

import com.kaio.domain.Cliente;
import com.kaio.exception.DAOException;

// Interface que define operações específicas para o DAO de Cliente
public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    // Método específico para consultar um Cliente pelo CPF
    Cliente consultarPorCPF(String cpf) throws DAOException;
}
