package com.kaio.dao.interfaces;

import com.kaio.domain.Estoque;
import com.kaio.exception.DAOException;

// Interface que define operações específicas para o DAO de Estoque
public interface IEstoqueDAO extends IGenericDAO<Estoque, Long> {

    // Método específico para consultar o estoque de um produto
    Estoque consultarPorProdutoId(Long produtoId) throws DAOException;
}
