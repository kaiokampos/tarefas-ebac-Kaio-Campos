package br.com.kaiokampos.service;

import br.com.kaiokampos.model.User;
import br.com.kaiokampos.model.UserRepository;

import java.util.List;

public class UserService {
    private UserRepository repository = new UserRepository();

    public User createUser(String name, String email) {
        User user = new User(0, name, email);
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public boolean updatedUser(int id, String name, String email) {
        User updatedUser = new User(id, name, email);
        return repository.update(id, updatedUser);
    }

    public boolean deleteUser(int id) {
        return repository.delete(id);
    }
}
