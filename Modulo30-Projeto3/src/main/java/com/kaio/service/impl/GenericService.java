package com.kaio.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.kaio.dao.interfaces.IGenericDAO;
import com.kaio.exception.*;
import com.kaio.domain.IPersistente;
import com.kaio.service.interfaces.IGenericService;

/**
 * Classe genérica que implementa os serviços CRUD para entidades do tipo Persistente.
 *
 * @param <T> Tipo da entidade que estende Persistente
 * @param <E> Tipo da chave única da entidade (ID)
 */
public abstract class GenericService<T extends IPersistente, E extends Serializable>
        implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            return this.dao.salvar(entity);
        } catch (DAOException e) {
            throw new DAOException("Erro ao tentar cadastrar a entidade.", e);
        }
    }

    @Override
    public void deletar(E valor) throws DAOException {
        try {
            this.dao.deletar(valor);
        } catch (DAOException e) {
            throw new DAOException("Erro ao tentar excluir a entidade.", e);
        }
    }

    @Override
    public void atualizar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        try {
            this.dao.atualizar(entity);
        } catch (DAOException e) {
            throw new DAOException("Erro ao tentar alterar a entidade.", e);
        }
    }

    @Override
    public T consultar(E valor) throws DAOException, TipoChaveNaoEncontradaException {
        try {
            T resultado = this.dao.consultarPorId(valor);
            if (resultado == null) {
                throw new TipoChaveNaoEncontradaException("Entidade não encontrada com a chave: " + valor);
            }
            return resultado;
        } catch (TipoChaveNaoEncontradaException | DAOException e) {
            throw new DAOException("Erro ao consultar a entidade", e);
        }
    }

    @Override
    public Collection<T> listar() throws DAOException {
        try {
            return this.dao.listar();
        } catch (DAOException e) {
            throw new DAOException("Erro ao buscar todos os registros.", e);
        }
    }

    @Override
    public Collection<T> consultarPorFiltro(T filtro) throws DAOException {
        try {
            return this.dao.consultarPorFiltro(filtro);
        } catch (DAOException e) {
            throw new DAOException("Erro ao buscar registros com base na entidade filtro: " + filtro, e);
        }
    }
}
