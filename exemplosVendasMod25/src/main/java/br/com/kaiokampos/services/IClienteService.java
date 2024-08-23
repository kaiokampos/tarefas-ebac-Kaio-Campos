/**
 * @author kaiokampos
 */
package br.com.kaiokampos.services;

import br.com.kaiokampos.domain.Cliente;
import br.com.kaiokampos.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}