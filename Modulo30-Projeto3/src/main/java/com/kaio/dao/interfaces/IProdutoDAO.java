package com.kaio.dao.interfaces;

import com.kaio.domain.Produto;
import com.kaio.exception.DAOException;

// Interface que define operações específicas para o DAO de Produto
public interface IProdutoDAO extends IGenericDAO<Produto, Long> {

    // Método específico para consultar um Produto pelo código
    Produto consultarPorCodigo(String codigo) throws DAOException;
}
