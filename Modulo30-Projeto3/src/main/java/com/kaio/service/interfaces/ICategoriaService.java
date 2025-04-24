package com.kaio.service.interfaces;

import com.kaio.domain.Categoria;
import com.kaio.exception.DAOException;
import com.kaio.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public interface ICategoriaService extends IGenericService<Categoria, Long> {

    /**
     * Método para consultar uma Categoria pelo nome.
     *
     * @param nome Nome da categoria
     * @return Categoria correspondente ao nome informado
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Categoria consultarPorNome(String nome) throws DAOException;

}
