package br.com.kaiokampos.services;

import br.com.kaiokampos.dao.IClienteDAO;

public class ClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService( IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public String salvar(){
        clienteDAO.salvar();
        return "Sucesso do Cliente Service";
    }
}
