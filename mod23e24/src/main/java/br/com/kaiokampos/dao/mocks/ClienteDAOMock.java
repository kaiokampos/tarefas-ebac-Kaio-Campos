package br.com.kaiokampos.dao.mocks;

import br.com.kaiokampos.dao.IClienteDAO;

public class ClienteDAOMock implements IClienteDAO {
    @Override
    public String salvar() {
        return "Sucesso do ClienteDAOMock";
    }
}
