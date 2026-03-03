package dao;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

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
        //Query query = em.createQuery("SELECT u FROM User u");
        Query query = em.createNamedQuery("User.findAll");
        return query.getResultList();
    }

    public static User getUserByEmail(String email) {
        Query query = em.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
