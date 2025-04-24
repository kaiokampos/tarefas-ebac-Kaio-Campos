package com.kaio.dao.interfaces;

import com.kaio.domain.ProdutoQuantidade;
import com.kaio.exception.DAOException;

import java.util.List;

// Interface que define operações específicas para o DAO de ProdutoQuantidade
public interface IProdutoQuantidadeDAO extends IGenericDAO<ProdutoQuantidade, Long> {

    // Método específico para consultar as quantidades de produto em uma venda
    List<ProdutoQuantidade> consultarPorVendaId(Long vendaId) throws DAOException;
}
