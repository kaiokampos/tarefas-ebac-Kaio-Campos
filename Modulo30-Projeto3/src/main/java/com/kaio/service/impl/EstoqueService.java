package com.kaio.service.impl;

import com.kaio.dao.interfaces.IEstoqueDAO;
import com.kaio.domain.Estoque;
import com.kaio.exception.DAOException;
import com.kaio.service.interfaces.IEstoqueService;

import java.util.Collection;
import java.util.List;

/**
 * Classe de serviço que implementa os métodos da interface IEstoqueService,
 * estendendo a funcionalidade genérica da GenericService.
 */
public class EstoqueService extends GenericService<Estoque, Long> implements IEstoqueService {

    /**
     * Construtor que inicializa a instância com o DAO específico.
     *
     * @param dao DAO de Estoque
     */
    public EstoqueService(IEstoqueDAO dao) {
        super(dao);
    }

    @Override
    public Collection<Estoque> consultarPorFiltro(Estoque filtro) throws DAOException {
        // Método ainda não implementado. Retorna uma lista vazia por padrão.
        return List.of();
    }

    // Métodos adicionais específicos podem ser implementados conforme a necessidade
}
