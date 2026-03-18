package org.example.gestioneprodotti.services;

import org.example.gestioneprodotti.models.User;
import org.example.gestioneprodotti.repositories.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired @Qualifier("createUser") ObjectProvider<User> createUserProvider;
    @Autowired @Qualifier("createFakeUser") ObjectProvider<User> createFakeUserProvider;
    @Autowired UserRepository userRepository;

    @Override
    public User createUser(String username, String email, String password) {
        User user = createUserProvider.getObject();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Override
    public User createFakeUser() {
        return createFakeUserProvider.getObject();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
