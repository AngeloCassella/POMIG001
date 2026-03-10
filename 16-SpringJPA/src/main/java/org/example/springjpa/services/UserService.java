package org.example.springjpa.services;

import org.example.springjpa.models.Address;
import org.example.springjpa.models.User;
import org.example.springjpa.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDAORepository userDB;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserProvider;
    @Autowired @Qualifier("fakeUser") ObjectProvider<User> fakeUserProvider;
    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminUserProvider;

    public User createCustomUser(String firstName, String lastName, Integer age, String   email, Address address) {
        User user = customUserProvider.getObject();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setAddress(address);
        return user;
    }

    public User createFakeUser(){
        return fakeUserProvider.getObject();
    }

    public User createAdminUser(){
        return adminUserProvider.getObject();
    }

    // JPA Method
    public void saveUser(User user){
        userDB.save(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " saved!");
    }
    public User findUser(long id) {
        return userDB.findById(id).get();
    }
    public void removeUser(User user){
        userDB.delete(user);
        System.out.println(user.getFirstname() + " " + user.getLastname() + " deleted!");
    }
    public List<User> findAll(){
        return userDB.findAll();
    }
    public List<User> getByEmail(String email){
        return userDB.findByEmail(email);
    }

    public List<User> getByAgeBetween(int min, int max){
        return userDB.findByAgeBetween(min, max);
    }
}
