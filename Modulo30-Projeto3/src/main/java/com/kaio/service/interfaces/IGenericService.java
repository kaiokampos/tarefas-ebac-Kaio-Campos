package com.kaio.service.interfaces;

import com.kaio.domain.IPersistente;
import com.kaio.exception.DAOException;
import com.kaio.exception.TipoChaveNaoEncontradaException;
import java.io.Serializable;
import java.util.Collection;

/**
 * Interface genérica para serviços CRUD.
 *
 * @param <T> Tipo de entidade que implementa a interface IPersistente
 * @param <E> Tipo da chave única da entidade (ID)
 */
public interface IGenericService<T extends IPersistente, E extends Serializable> {

    /**
     * Método para cadastrar um novo registro no banco de dados.
     *
     * @param entity a ser cadastrado
     * @return verdadeiro se o cadastro foi bem-sucedido, falso caso contrário
     * @throws TipoChaveNaoEncontradaException Caso a chave não seja encontrada
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Boolean salvar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados.
     *
     * @param valor chave única do dado a ser excluído
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    void deletar(E valor) throws DAOException;

    /**
     * Método para alterar um registro no banco de dados.
     *
     * @param entity a ser atualizado
     * @throws TipoChaveNaoEncontradaException Caso a chave não seja encontrada
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    void atualizar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados por sua chave única.
     *
     * @param valor chave única do dado a ser consultado
     * @return a entidade correspondente ou null se não encontrado
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     * @throws TipoChaveNaoEncontradaException Caso a entidade não seja encontrada
     */
    T consultar(E valor) throws DAOException, TipoChaveNaoEncontradaException;

    /**
     * Método para buscar todos os registros de uma tabela no banco de dados.
     *
     * @return Coleção de registros encontrados
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Collection<T> listar() throws DAOException;

    /**
     * Método para buscar registros com uma condição específica no banco de dados.
     *
     * @param filtro Condição de filtro para a busca
     * @return Coleção de registros encontrados
     * @throws DAOException Caso ocorra um erro ao acessar o banco de dados
     */
    Collection<T> consultarPorFiltro(T filtro) throws DAOException;

}
