package com.kaio.service.interfaces;

import com.kaio.domain.Produto;
import com.kaio.exception.DAOException;
import com.kaio.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface IProdutoService extends IGenericService<Produto, Long> {

    /**
     * Método para consultar um Produto pelo código.
     *
     * @param codigo Código do produto
     * @return Produto correspondente ao código informado
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Produto consultarPorCodigo(String codigo) throws DAOException;
}
