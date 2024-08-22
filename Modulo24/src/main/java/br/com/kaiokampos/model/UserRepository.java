package br.com.kaiokampos.model;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private int currentId = 1;

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        return users.stream().filter(user -> user.getId() == 1).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(currentId++);
        users.add(user);
        return user;
    }

    public boolean update(int id, User updatedUser){
        User user = findById(id);
        if (user != null){
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        return users.removeIf(user -> user.getId() == id);
    }
}
