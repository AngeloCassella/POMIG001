package org.example.springwebmvc.runners;

import org.example.springwebmvc.models.User;
import org.example.springwebmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {

        // Controllo se nel database sono già presenti utenti registrati
        // Nel caso in cui non ci sono ne creo 10
        if(userService.findAllUsers().size()==0){
            userService.saveUser(
                    userService.createUser(
                        "Mario",
                        "Rossi",
                        "Roma",
                        "m.rossi@example.com",
                        "Pa$$w0rd!"));
            for (int i = 0; i < 9; i++) {
                userService.saveUser(userService.createFakeUser());
            }
        } else {
            System.out.println("User already exists");
        }

    }
}
