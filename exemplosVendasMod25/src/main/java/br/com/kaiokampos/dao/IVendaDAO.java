package br.com.kaiokampos.dao;

import br.com.kaiokampos.dao.generics.IGenricDAO;
import br.com.kaiokampos.domain.Venda;
import br.com.kaiokampos.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenricDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}