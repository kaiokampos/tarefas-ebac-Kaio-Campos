package com.kaio.dao.interfaces;

import com.kaio.domain.Venda;
import com.kaio.exception.DAOException;

// Interface que define operações específicas para o DAO de Venda
public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    // Método específico para consultar uma venda por cliente
    Venda consultarPorClienteId(Long clienteId) throws DAOException;
}
