package com.kaio.domain;

/**
 * Interface genérica para entidades que podem ser persistidas no banco de dados.
 *
 * @param <T> Tipo do identificador único da entidade.
 */
public interface IPersistente<T> {

    /**
     * Retorna o identificador único da entidade.
     *
     * @return o identificador único.
     */
    T getId();

    /**
     * Define o identificador único da entidade.
     *
     * @param id o identificador único.
     */
    void setId(T id);
}
