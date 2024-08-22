package br.com.kaiokampos;

import br.com.kaiokampos.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.run();
    }
}