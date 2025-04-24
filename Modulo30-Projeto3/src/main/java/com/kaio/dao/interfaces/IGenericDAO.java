package com.kaio.dao.interfaces;

import com.kaio.exception.DAOException;

import java.util.Collection;
import java.util.List;

/**
 * Interface genérica para operações CRUD
 */
public interface IGenericDAO<T, ID> {

    // Salvar uma entidade
    boolean salvar(T entidade) throws DAOException;

    // Atualizar uma entidade
    boolean atualizar(T entidade) throws DAOException;

    // Deletar uma entidade
    boolean deletar(ID valor) throws DAOException;

    // Consultar por ID
    T consultarPorId(ID id) throws DAOException;

    // Listar todas as entidades
    List<T> listar() throws DAOException;

    Collection<T> consultarPorFiltro(T filtro) throws DAOException;


}
