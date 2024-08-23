/**
 * @author kaiokampos
 */
package br.com.kaiokampos.services;

import br.com.kaiokampos.dao.IProdutoDAO;
import br.com.kaiokampos.domain.Produto;
import br.com.kaiokampos.services.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}