package br.com.kaiokampos.view;

import br.com.kaiokampos.model.User;

import java.util.List;

public class UserView {
    public void showMenu() {
        System.out.println("1. Create User");
        System.out.println("2. Get User by ID");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. List All Users");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    public void promptForUserId() {
        System.out.println("Enter User ID: ");
    }

    public void promptForUserDetails() {
        System.out.println("Enter User Name: ");
        System.out.println("Enter User Email: ");
    }

    public void showUser(User user) {
        System.out.println(user);
    }

    public void showUserNotFound() {
        System.out.println("User not found.");
    }

    public void showUpdateSuccess() {
        System.out.println("User updated successfully.");
    }

    public void showDeleteSuccess() {
        System.out.println("User deleted successfully.");
    }

    public void showAllUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }

    public void showInvalidOption() {
        System.out.println("Invalid option. Please try again.");
    }
}
