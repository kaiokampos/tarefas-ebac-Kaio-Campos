package br.com.kaiokampos.controller;

import br.com.kaiokampos.model.User;
import br.com.kaiokampos.service.UserService;
import br.com.kaiokampos.view.UserView;

import java.util.Scanner;

public class UserController {
    private UserService service = new UserService();
    private UserView view = new UserView();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            view.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); //Consumir a nova linha apos uma entrada de inteiro

            switch (choice) {
                case 1 -> {
                    view.promptForUserDetails();
                    String name = scanner.nextLine();
                    String email = scanner.nextLine();
                    User user = service.createUser(name, email);
                    view.showUser(user);
                }
                case 2 -> {
                    view.promptForUserId();
                    int id = scanner.nextInt();
                    User user = service.getUserById(id);
                    if (user != null) {
                        view.showUser(user);
                    } else {
                        view.showUserNotFound();
                    }
                }
                case 3 -> {
                    view.promptForUserId();
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    view.promptForUserDetails();
                    String name = scanner.nextLine();
                    String email = scanner.nextLine();
                    boolean success = service.updatedUser(id, name, email);
                    if (success) {
                        view.showUpdateSuccess();
                    } else {
                        view.showUserNotFound();
                    }
                }
                case 4 -> {
                    view.promptForUserId();
                    int id = scanner.nextInt();
                    boolean success = service.deleteUser(id);
                    if (success) {
                        view.showDeleteSuccess();
                    } else {
                        view.showUserNotFound();
                    }
                }
                case 5 -> {
                    view.showAllUsers(service.getAllUsers());
                }
                case 6 -> exit = true;
                default -> view.showInvalidOption();
            }
        }
    }
}
