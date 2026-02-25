package service;

import model.Role;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    // presenza di almeno un ADMIN preconfigurato all’avvio applicazione
    static {
        User a = new User("Mario Rossi", "admin", "Pa$$w0rd!");
        a.setRuolo(Role.ADMIN);
        users.put("admin", a);
    }

    public static boolean register(String fullname, String username, String password) {
        // Controllo username univoco
        if (users.containsKey(username)) {
            return false;
        }

        users.put(username, new User(fullname, username, password));
        return true;
    }

    public static User login(String username,  String password) {
        if (!users.containsKey(username)) {
            return null;
        }

        User user = users.get(username);
        if(user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

}
