package com.kaio.service.impl;

import com.kaio.dao.interfaces.ICategoriaDAO;
import com.kaio.domain.Categoria;
import com.kaio.exception.DAOException;
import com.kaio.exception.TipoChaveNaoEncontradaException;
import com.kaio.service.interfaces.ICategoriaService;

import java.util.Collection;
import java.util.List;

public class CategoriaService implements ICategoriaService {

    private ICategoriaDAO categoriaDAO;

    @Override
    public Boolean salvar(Categoria entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public void deletar(Long valor) throws DAOException {

    }

    @Override
    public void atualizar(Categoria entity) throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Override
    public Categoria consultar(Long valor) throws DAOException, TipoChaveNaoEncontradaException {
        return null;
    }

    @Override
    public Collection<Categoria> listar() throws DAOException {
        return List.of();
    }

    @Override
    public Collection<Categoria> consultarPorFiltro(Categoria filtro) throws DAOException {
        return List.of();
    }

    @Override
    public Categoria consultarPorNome(String nome) throws DAOException {
        return null;
    }
}
