package esercizio.services;

import esercizio.dao.UserDAO;
import esercizio.enumerations.Role;
import esercizio.models.User;

public class AuthService {

    public static String register(String fullname, String username, String password) {

        if(UserDAO.getUserByUsername(username).size() > 0) {
            return "Username already exists";
        } else if (username.length() < 5) {
            return "Username too short";
        } else if (password.length() < 7) {
            return "Password too short";
        } else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullname(fullname);
            user.setRole(Role.USER);
            return UserDAO.saveUser(user);
        }

    }

    public static User login(String username, String password) {
        if(UserDAO.getUserByUsernameAndPassword(username, password).size()>0) {
            return UserDAO.getUserByUsernameAndPassword(username, password).get(0);
        }
        return null;
    }

}
