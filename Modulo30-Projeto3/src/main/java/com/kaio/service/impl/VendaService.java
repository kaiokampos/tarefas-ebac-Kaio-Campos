package com.kaio.service.impl;

import com.kaio.dao.interfaces.IVendaDAO;
import com.kaio.domain.Venda;
import com.kaio.exception.DAOException;
import com.kaio.service.interfaces.IVendaService;

import java.util.Collection;
import java.util.List;

/**
 * Classe de serviço que implementa os métodos da interface IVendaService,
 * estendendo a funcionalidade genérica da GenericService.
 */
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    /**
     * Construtor que inicializa a instância com o DAO específico.
     *
     * @param dao DAO de Venda
     */
    public VendaService(IVendaDAO dao) {
        super(dao);
    }

    @Override
    public Collection<Venda> consultarPorFiltro(Venda filtro) throws DAOException {
        // Método ainda não implementado. Retorna uma lista vazia por padrão.
        return List.of();
    }

    // Métodos adicionais específicos podem ser implementados conforme a necessidade
}
