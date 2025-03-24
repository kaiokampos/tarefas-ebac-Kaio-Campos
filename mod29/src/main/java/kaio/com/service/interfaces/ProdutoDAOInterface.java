package kaio.com.service.interfaces;

import kaio.com.domain.Produto;

import java.util.List;

public interface ProdutoDAOInterface {
    void salvar(Produto produto);
    void atualizar(Produto produto);
    void remover(int id);
    Produto buscarPorId(int id);
    List<Produto> listarTodos();
}

