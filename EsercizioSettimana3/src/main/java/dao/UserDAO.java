package dao;

import com.github.javafaker.Faker;
import model.Role;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static String saveUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO users (fullname, username, password, role) " +
                " VALUES (?, ?, ?, ?);";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setString(1, user.getFullname());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole().toString());
        ps.executeUpdate();
        return  "User created successfully.";
    }

    public static User findUserByUsername(String useranme) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE username = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setString(1, useranme);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id = rs.getInt("id");
            String fullname = rs.getString("fullname");
            String username = rs.getString("username");
            String password = rs.getString("password");
            Role role = Role.valueOf(rs.getString("role"));

            return new User(id, fullname, username, password, role);
        }
        return null;
    }

    public static User findUserById(int userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id = rs.getInt("id");
            String fullname = rs.getString("fullname");
            String username = rs.getString("username");
            String password = rs.getString("password");
            Role role = Role.valueOf(rs.getString("role"));

            return new User(id, fullname, username, password, role);
        }
        return null;
    }

    public static void updateUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE users SET fullname=?,username=?,password=?,role=?  WHERE id=?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setString(1, user.getFullname());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole().toString());
        ps.setInt(5, user.getId());
        ps.executeUpdate();
        System.out.println("User " + user.getFullname() + " modified successfully.");
    }

    public static void removeUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.executeUpdate();
        System.out.println("User " + user.getFullname() + " deleted successfully.");
    }

    public static List<User> findAllUsers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

        List<User>  users = new ArrayList<>();
        ResultSet rs = ps.executeQuery(); // null | row
        while(rs.next()){
            int id = rs.getInt("id");
            String fullname = rs.getString("fullname");
            String username = rs.getString("username");
            String password = rs.getString("password");
            Role role = Role.valueOf(rs.getString("role"));

            users.add(new User(id, fullname, username, password, role));
        }
        return users;
    }
}
