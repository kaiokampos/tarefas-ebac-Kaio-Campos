package com.kaio.dao.interfaces;
import com.kaio.domain.Categoria;
import com.kaio.exception.DAOException;

import java.util.Collection;

public interface ICategoriaDAO extends IGenericDAO<Categoria, Long> {

    Categoria consultarPorNome(String nome) throws DAOException;

    Collection<Categoria> consultarPorFiltro(String filtro) throws DAOException; // <- ADICIONE AQUI
}
