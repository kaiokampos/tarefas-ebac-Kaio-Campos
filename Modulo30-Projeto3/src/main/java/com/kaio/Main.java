package com.kaio;

import com.kaio.dao.impl.ClienteDAO;
import com.kaio.domain.Cliente;
import com.kaio.exception.DAOException;

public class Main {

/*    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        String cpfParaExcluir = "12345678901";

        try {
            // Verifica se o cliente existe antes de excluir
            Cliente cliente = clienteDAO.consultarPorCPF(cpfParaExcluir);
            if (cliente != null) {
                clienteDAO.excluir(cliente.getId());
                System.out.println("Cliente excluído com sucesso: " + cliente.getNome());
            } else {
                System.out.println("Cliente com CPF " + cpfParaExcluir + " não encontrado.");
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }

        Cliente clienteVerificacao = clienteDAO.consultarPorCPF(cpfParaExcluir);
        if (clienteVerificacao == null) {
            System.out.println("Cliente removido com sucesso do banco de dados!");
        } else {
            System.out.println("Erro: cliente ainda existe no banco.");
        }

    }*/
}
