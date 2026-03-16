package org.example.eserciziosettimana5.services;

import org.example.eserciziosettimana5.models.User;
import org.example.eserciziosettimana5.repositories.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired @Qualifier("createuser") ObjectProvider<User> createUserObjectProvider;
    @Autowired @Qualifier("createfakeuser") ObjectProvider<User> createFakeUserObjectProvider;
    @Autowired UserRepository userRepo;

    public User createUser(String nome, String email, String telefono) {
        User user = createUserObjectProvider.getObject();
        user.setNome(nome);
        user.setEmail(email);
        user.setTelefono(telefono);
        return user;
    }

    public User createFakeUser() {
        return createFakeUserObjectProvider.getObject();
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
        System.out.println("User saved: " + user.getNome());
    }

    @Override
    public User findUser(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
        System.out.println("User deleted: " + user.getNome());
    }

}
