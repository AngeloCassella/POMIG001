package esercizio.dao;

import esercizio.enumerations.Role;
import esercizio.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.*;
import java.util.List;

public class UserDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String saveUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return "User has been saved successfully";
    }

    public static User getUser(int id) {
        return em.find(User.class, id);
    }

    public static String deleteUser(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        return "User has been deleted successfully";
    }

    public static List<User> getAllUsers() {
        Query query = em.createNamedQuery("User.findAll");
        return query.getResultList();
    }

    public static List<User> getUserByUsername(String username) {
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }

    public static List<User> getUserByUsernameAndPassword(String username, String password) {
        Query query = em.createNamedQuery("User.findByUsernameAndPassword");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getResultList();
    }

    // Example Data
    public static void createAdminUser() throws SQLException {
        Query query = em.createNamedQuery("User.findAdmin");
        query.setParameter("role", Role.ADMIN);
        List<User> adminUsers = query.getResultList();

        if(adminUsers == null || adminUsers.size() == 0) {
            User user = new User();
            user.setFullname("Mario Rossi");
            user.setUsername("admin");
            user.setPassword("admin");
            user.setRole(Role.ADMIN);
            saveUser(user);
            System.out.println("Admin created successfully.");
        } else {
            System.out.println("Admin already exists.");
            return;
        }

    }
}
