package esercizio.dao;

import esercizio.models.Enrollment;
import esercizio.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class EnrollmentDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String saveEnrollment(Enrollment enrollment) {
        em.getTransaction().begin();
        em.persist(enrollment);
        em.getTransaction().commit();
        return "Enrollment has been saved successfully";
    }

    public static Enrollment getEnrollment(int id) {
        return em.find(Enrollment.class, id);
    }

    public static String deleteEnrollment(Enrollment enrollment) {
        em.getTransaction().begin();
        em.remove(enrollment);
        em.getTransaction().commit();
        return "Enrollment has been deleted successfully";
    }

    public static List<Enrollment> getAllEnrollment() {
        Query query = em.createNamedQuery("Enrollment.findAll");
        return query.getResultList();
    }

    public static List<Enrollment> getEnrollmentsByUser(User user) {
        Query query = em.createNamedQuery("Enrollment.findAllByUser");
        query.setParameter("user", user);
        return query.getResultList();
    }

}
