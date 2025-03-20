package kaio.com.dao.jdbc;

import kaio.com.dao.ProdutoDAO;
import kaio.com.domain.Produto;
import kaio.com.service.interfaces.ProdutoDAOInterface;

import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAOInterface {
    private final ProdutoDAO produtoDAO;

    public ProdutoDAOImpl(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public void adicionar(Produto produto) {
        produtoDAO.adicionar(produto);

    }

    @Override
    public void atualizar(Produto produto) {
        produtoDAO.atualizar(produto);

    }

    @Override
    public void remover(int id) {
        produtoDAO.remover(id);

    }

    @Override
    public Produto buscarPorId(int id) {
        return produtoDAO.buscarPorId(id);

    }

    @Override
    public List<Produto> listarTodos() {
        return produtoDAO.listarTodos();
    }
}
