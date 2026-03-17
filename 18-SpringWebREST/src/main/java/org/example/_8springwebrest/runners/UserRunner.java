package org.example._8springwebrest.runners;

import org.example._8springwebrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        if(userService.getUsers().size()==0){
            initDB(10);
        }
    }

    private void initDB(int num) {
        for (int i = 0; i < num; i++) {
            userService.saveUser(userService.createFakeUser());
        }
        System.out.println("Users created");
    }
}
