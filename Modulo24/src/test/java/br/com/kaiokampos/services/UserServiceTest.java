package br.com.kaiokampos.services;

import br.com.kaiokampos.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService service;

    @BeforeEach
    void setUp(){
        service = new UserService();
    }

    @Test
    public void createUser() {
        User user = service.createUser("Kaio", "kaio@kaio.com");
        assertNotNull(user);
        assertEquals(1,user.getId());
    }

    @Test
    public void getAllUsers() {
        service.createUser("Kaio Kampos", "kaio@kaio.com");
        List<User> users = service.getAllUsers();
        assertFalse(users.isEmpty());
    }

    @Test
    public void getUserById() {
        User user = service.createUser("Kaio Kampos", "kaio@kaio.com");
        User found = service.getUserById(user.getId());
        assertNotNull(found);
    }

    @Test
    public void updatedUser() {
        User user = service.createUser("Kaio Kampos", "kaio@kaio.com");
        boolean success = service.updatedUser(user.getId(), "Kaio Campos", "kaio@campos.com");
        assertTrue(success);
        User updated = service.getUserById(user.getId());
        assertEquals("Kaio Campos", updated.getName());
    }

    @Test
    public void deleteUser() {
        User user = service.createUser("Kaio Kampos", "kaio@kaio.com");
        boolean success = service.deleteUser(user.getId());
        assertTrue(success);
        assertNull(service.getUserById(user.getId()));
    }
}