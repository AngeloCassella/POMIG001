package org.example._8springwebrest.controllers;

import org.example._8springwebrest.models.User;
import org.example._8springwebrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

//@Controller
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    // GET | POST | PUT | PATCH | DELETE

    @GetMapping
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getuser(@PathVariable long id) {
        //return userService.getUserById(id);

//        try {
//            return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }

//        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
//        if(userService.checkEmail(user.getEmail()) == null) {
//            return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<String>("Duplicated entry " + user.getEmail(), HttpStatus.BAD_REQUEST);
//        }

//        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);

        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user) {
//        try {
//            userService.getUserById(id);
//            if(id == user.getId()) {
//                return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<String>("ID not found!", HttpStatus.NOT_FOUND);
//            }
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }

            if(userService.getUserById(id).getId() == user.getId()) {
                return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("ID not found!", HttpStatus.NOT_FOUND);
            }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchUser(@PathVariable long id, @RequestBody Map<String, Object> updates) {
//        User user;
//        try {
//            // Controllo se nel DB è presente un Utente con ID come quello passato dal client
//            user = userService.getUserById(id);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }

        User user = userService.getUserById(id);
        // Modifico le proprietà richieste dal client
        updates.forEach((key, value) -> {
            // Cerco nella classe User una proprietà che ha lo stesso nome della chiave inviata dal client
            Field field = ReflectionUtils.findField(User.class, key);

            if(field != null) {
                // Rendo accessibile il campo per la modifica
                field.setAccessible(true);
                // Modifico il campo richiesto nell'oggetto User con il valore inviato dal client
                ReflectionUtils.setField(field, user, value);
            }
        });

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
//        try {
//            userService.removeUser(userService.getUserById(id));
//            return new ResponseEntity<>("User deleted!", HttpStatus.OK);
//        }  catch (NoSuchElementException e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
        userService.removeUser(userService.getUserById(id));
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }

}
