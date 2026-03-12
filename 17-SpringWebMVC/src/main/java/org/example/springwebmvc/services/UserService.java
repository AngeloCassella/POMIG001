package org.example.springwebmvc.services;

import org.example.springwebmvc.models.User;
import org.example.springwebmvc.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired @Qualifier("createuser") ObjectProvider<User> createUserProvider;
    @Autowired @Qualifier("createfakeuser") ObjectProvider<User> createFakeUserProvider;
    @Autowired UserDAORepository userDB;

    public User createUser(String firstname, String lastname, String city, String email, String password) {
        User user = createUserProvider.getObject();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCity(city);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
    public User createFakeUser() {
        return createFakeUserProvider.getObject();
    }

    // CRUD User
    public void saveUser(User user) {
        userDB.save(user);
        System.out.println("User saved: " + user.getFirstname() + " " + user.getLastname());
    }
    public User findUserById(long id) {
        return userDB.findById(id).orElse(null);
    }
    public void deleteUser(User user) {
        userDB.delete(user);
        System.out.println("User deleted: " + user.getFirstname() + " " + user.getLastname());
    }
    public List<User> findAllUsers() {
        return userDB.findAll();
    }

    public User ceckUser(String email, String password) {
        return userDB.findByEmailAndPassword(email, password);
    }
}
