package com.kaio.generic.dao;

import com.kaio.domain.Cliente;

public class ClienteDAO {
    public ClienteDAO() {
        super();
    }

    public Class<Cliente> getTipoClasse(){
        return Cliente.class;
    }


}
