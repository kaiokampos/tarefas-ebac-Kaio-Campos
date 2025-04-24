package com.kaio.service.impl;

import com.kaio.dao.interfaces.IProdutoDAO;
import com.kaio.domain.Produto;
import com.kaio.exception.DAOException;
import com.kaio.exception.TipoChaveNaoEncontradaException;
import com.kaio.service.interfaces.IProdutoService;

import java.util.Collection;
import java.util.List;

public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {

    // Construtor que chama o construtor da classe pai com o DAO de Produto
    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

    @Override
    public Produto consultarPorCodigo(String codigo) throws DAOException {
        try {
            // Consultar o produto pelo código usando o método específico do DAO
            return ((IProdutoDAO) dao).consultarPorCodigo(codigo);
        } catch (DAOException e) {
            // Adicionar log ou mais detalhes, se necessário
            throw new DAOException("Erro ao tentar consultar o produto pelo código: " + codigo, e);
        }
    }

    @Override
    public Collection<Produto> consultarPorFiltro(Produto filtro) throws DAOException {
        return List.of();
    }

    // Se necessário, você pode adicionar mais métodos específicos para o Produto
}
