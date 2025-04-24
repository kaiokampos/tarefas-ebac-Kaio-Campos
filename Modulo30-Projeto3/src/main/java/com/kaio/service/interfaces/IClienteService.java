package com.kaio.service.interfaces;

import com.kaio.domain.Cliente;
import com.kaio.exception.DAOException;

public interface IClienteService extends IGenericService<Cliente, Long> {

    /**
     * Método para consultar um Cliente pelo CPF.
     *
     * @param cpf CPF do cliente
     * @return Cliente correspondente ao CPF informado
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Cliente consultarPorCPF(String cpf) throws DAOException;
}
