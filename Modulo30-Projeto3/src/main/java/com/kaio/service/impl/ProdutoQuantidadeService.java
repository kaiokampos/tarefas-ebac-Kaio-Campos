package com.kaio.service.impl;

import com.kaio.dao.interfaces.IProdutoQuantidadeDAO;
import com.kaio.domain.ProdutoQuantidade;
import com.kaio.exception.DAOException;
import com.kaio.service.interfaces.IProdutoQuantidadeService;

import java.util.Collection;
import java.util.List;

/**
 * Classe de serviço que implementa os métodos da interface IProdutoQuantidadeService,
 * estendendo a funcionalidade genérica da GenericService.
 */
public class ProdutoQuantidadeService extends GenericService<ProdutoQuantidade, Long> implements IProdutoQuantidadeService {

    /**
     * Construtor que inicializa a instância com o DAO específico.
     *
     * @param dao DAO de ProdutoQuantidade
     */
    public ProdutoQuantidadeService(IProdutoQuantidadeDAO dao) {
        super(dao);
    }

    @Override
    public Collection<ProdutoQuantidade> consultarPorFiltro(ProdutoQuantidade filtro) throws DAOException {
        // Método ainda não implementado. Retorna uma lista vazia por padrão.
        return List.of();
    }

    // Métodos adicionais específicos podem ser implementados conforme a necessidade
}
