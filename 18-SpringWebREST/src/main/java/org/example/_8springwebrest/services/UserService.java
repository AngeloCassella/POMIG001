package org.example._8springwebrest.services;

import org.example._8springwebrest.models.User;

import java.util.List;

public interface UserService {

    public User createUser(String firstName, String lastName, String city, Integer age, String email, String password);
    public User createFakeUser();

    // CRUD User
    public User saveUser(User user);
    public User getUserById(long id);
    public void removeUserById(long id);
    public void removeUser(User user);
    public List<User> getUsers();

    public User checkEmail(String email);

}
