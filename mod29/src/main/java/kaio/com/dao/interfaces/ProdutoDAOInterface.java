package kaio.com.dao.interfaces;

import kaio.com.domain.Produto;

import java.util.List;

public interface ProdutoDAOInterface {
    void adicionar(Produto produto);
    void atualizar(Produto produto);
    void remover(int id);
    Produto buscarPorId(int id);
    List<Produto> listarTodos();
}

