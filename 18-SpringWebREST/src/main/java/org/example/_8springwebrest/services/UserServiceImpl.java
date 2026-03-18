package org.example._8springwebrest.services;

import org.example._8springwebrest.repositories.UserRepo;
import org.example._8springwebrest.models.User;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
public class UserServiceImpl implements UserService {

    @Autowired @Qualifier("createUser") ObjectProvider<User> createUserObjectProvider;
    @Autowired @Qualifier("createFakeUser") ObjectProvider<User> createFakeUserObjectProvider;
    @Autowired
    UserRepo userRepository;

    @Override
    public User createUser(String firstName, String lastName, String city, Integer age, String email, String password) {
        User user = createUserObjectProvider.getObject();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCity(city);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Override
    public User createFakeUser() {
        return createFakeUserObjectProvider.getObject();
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User checkEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
