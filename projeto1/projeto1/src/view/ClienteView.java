package view;


import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class ClienteView {
    private IClienteDAO clienteDAO;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField telField;
    private JTextField endField;
    private JTextField numeroField;
    private JTextField cidadeField;
    private JTextField estadoField;
    private JTextArea textArea;

    public ClienteView(){
        clienteDAO = new ClienteMapDAO();
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("Gestão de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);

        //Painel Principal
        JPanel panel = new JPanel(new BorderLayout());

        //Área de texto para exibir clientes
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane,BorderLayout.CENTER);

        //Painel de controle para a interação do usuário
        JPanel controlPanel = new JPanel(new GridLayout(10,20));

        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField telField = new JTextField();
        JTextField endField = new JTextField();
        JTextField numeroField = new JTextField();
        JTextField cidadeField = new JTextField();
        JTextField estadoField = new JTextField();

        controlPanel.add(new JLabel("Nome:"));
        controlPanel.add(nomeField);
        controlPanel.add(new JLabel("CPF:"));
        controlPanel.add(cpfField);
        controlPanel.add(new JLabel("Telefone:"));
        controlPanel.add(telField);
        controlPanel.add(new JLabel("Endereço:"));
        controlPanel.add(endField);
        controlPanel.add(new JLabel("Número:"));
        controlPanel.add(numeroField);
        controlPanel.add(new JLabel("Cidade:"));
        controlPanel.add(cidadeField);
        controlPanel.add(new JLabel("Estado:"));
        controlPanel.add(estadoField);

        JButton addButton = new JButton("Adicionar");
        JButton updateButton = new JButton("Atualizar");
        JButton deleteButton = new JButton("Deletar");
        JButton listButton = new JButton("Listar Todos");

        controlPanel.add(addButton);
        controlPanel.add(updateButton);
        controlPanel.add(deleteButton);
        controlPanel.add(listButton);

        panel.add(controlPanel, BorderLayout.NORTH);

        frame.add(panel);

        // Ações dos botões
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Long cpf = Long.parseLong(cpfField.getText());
                Long tel = Long.parseLong(telField.getText());
                String end = endField.getText();
                Integer numero = Integer.parseInt(numeroField.getText());
                String cidade = cidadeField.getText();
                String estado = estadoField.getText();

                Cliente cliente = new Cliente(nome, cpf, tel, end, numero, cidade, estado);
                clienteDAO.cadastrar(cliente);
                clearFields();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Long cpf = Long.parseLong(cpfField.getText());
                Long tel = Long.parseLong(telField.getText());
                String end = endField.getText();
                Integer numero = Integer.parseInt(numeroField.getText());
                String cidade = cidadeField.getText();
                String estado = estadoField.getText();

                Cliente cliente = new Cliente(nome, cpf, tel, end, numero, cidade, estado);
                clienteDAO.alterar(cliente);
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long cpf = Long.parseLong(cpfField.getText());
                clienteDAO.excluir(cpf);
                clearFields();
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<Cliente> clientes = clienteDAO.buscarTodos();
                textArea.setText("");
                for (Cliente cliente : clientes) {
                    textArea.append(cliente.toString() + "\n");
                }
            }
        });

        frame.setVisible(true);
    }
    private void clearFields() {
        nomeField.setText("");
        cpfField.setText("");
        telField.setText("");
        endField.setText("");
        numeroField.setText("");
        cidadeField.setText("");
        estadoField.setText("");
    }

}






























