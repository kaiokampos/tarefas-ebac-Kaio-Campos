package br.com.kaiokampos.service;

import br.com.kaiokampos.dao.ClienteDAO;
import br.com.kaiokampos.dao.IClienteDAO;
import br.com.kaiokampos.dao.mocks.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteServiceTest {

    String esperado = "Sucesso do Cliente Service";

    @Test
    public void salvarTest() {

        IClienteDAO mockDao = new ClienteDAOMock();

        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals(esperado, retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {

        IClienteDAO mockDao = new ClienteDAO();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals(esperado, retorno);
    }
}