package org.example.gestioneprodotti.controller;

import org.example.gestioneprodotti.models.User;
import org.example.gestioneprodotti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    @GetMapping
    public List<User> getUsers() {
        // GET /users → Restituisce tutti gli utenti.
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable Long id) {
        // GET /users/{id} → Restituisce un utente.
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // POST /users → Registra un nuovo utente.
        user.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(userService.saveUser(user));
    }



}
