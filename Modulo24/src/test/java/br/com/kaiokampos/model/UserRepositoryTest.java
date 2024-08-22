package br.com.kaiokampos.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private UserRepository repository;

    @BeforeEach
    void setUPTest(){
        repository = new UserRepository();
    }

    @Test
    public void saveTest() {
        User user = repository.save(new User(0,"Kaio", "kaio@kaio.com"));
        assertNotNull(user);
        assertEquals(1,user.getId());
    }

    @Test
    public void findByIdTest() {
        User user = repository.save(new User(0,"Kaio", "kaio@kaio.com"));
        User userFound = repository.findById(user.getId());
        assertNotNull(userFound);
    }

    @Test
    public void findAllTest() {
        User user = repository.save(new User(0,"Kaio", "kaio@kaio.com"));
        List<User> userList = repository.findAll();
        assertFalse(userList.isEmpty());
    }

    @Test
    public void updateTest() {
        User user = repository.save(new User(0,"Kaio", "kaio@kaio.com"));
        boolean updateSuccess = repository.update(user.getId(), new User(user.getId(), "Kaio Kampos", "KaioKcampos@kaio.com"));
        assertTrue(updateSuccess);
        User updated = repository.findById(user.getId());
        assertEquals("Kaio Kampos", updated.getName());

    }

    @Test
    public void deleteTest() {
        User user = repository.save(new User(0, "KaioCampos", "KaioCampos@KaioCampos.com"));
        boolean success = repository.delete(user.getId());
        assertTrue(success);
        assertNull(repository.findById(user.getId()));
    }
}