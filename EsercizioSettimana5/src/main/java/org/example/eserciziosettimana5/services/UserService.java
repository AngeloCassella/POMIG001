package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.User;

import java.util.List;

public interface UserService {

    public User createUser(String nome, String email, String telefono);
    public User createFakeUser();
    public void saveUser(User user);
    public User findUser(long id);
    public List<User> findAll();
    public void deleteUser(User user);

}
