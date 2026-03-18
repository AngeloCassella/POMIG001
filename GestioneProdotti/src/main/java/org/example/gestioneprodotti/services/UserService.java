package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.User;

import java.util.List;

public interface UserService {

    public User createUser(String username, String email, String password);
    public User createFakeUser();
    public List<User> getAllUser();
    public User getUserById(Long id);
    public User saveUser(User user);
    public void deleteUser(Long id);

}
