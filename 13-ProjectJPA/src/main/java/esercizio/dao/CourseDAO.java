package esercizio.dao;

import com.github.javafaker.Faker;
import esercizio.models.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CourseDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String saveCourse(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        return "Course has been saved successfully";
    }

    public static Course getCourse(int id) {
        return em.find(Course.class, id);
    }

    public static String deleteCourse(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        return "Course has been deleted successfully";
    }

    public static List<Course> getAllCourse() {
        Query query = em.createNamedQuery("Course.findAll");
        return query.getResultList();
    }

    public static void createCourses() throws SQLException, ClassNotFoundException {
        Faker fake =  new Faker(new Locale("it-IT"));

        List<Course> courses = getAllCourse();

        if(courses.size()==0){
            for (int i = 0; i < fake.random().nextInt(5, 10); i++) {
                Course course = new Course();
                course.setTitle(fake.programmingLanguage().name());
                course.setTeacher(fake.name().fullName());
                course.setDuration(fake.number().numberBetween(50, 250));
                course.setMax_students(fake.number().numberBetween(10, 25));

                saveCourse(course);
                System.out.println("Course created successfully.");
            }

        }

    }
}
