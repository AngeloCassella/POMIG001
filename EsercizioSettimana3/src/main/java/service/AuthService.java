package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;

public class AuthService {

    public static User login(String username, String password) throws SQLException, ClassNotFoundException {
        return UserDAO.findUserByUsername(username);
    }

    public static void logout() {
    }

    public static String register(String fullname, String username, String password) throws SQLException, ClassNotFoundException {
        if(UserDAO.findUserByUsername(username) != null) {
            return "Username already exists";
        } else if (username.length() < 5) {
            return "Username too short";
        } else if (password.length() < 7) {
            return "Password too short";
        } else {
            return UserDAO.saveUser(new User(fullname, username, password));
        }
    }


}
