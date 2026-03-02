package config;

import com.github.javafaker.Faker;
import dao.ConnectionManager;
import dao.CourseDAO;
import dao.UserDAO;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import model.Course;
import model.Role;
import model.User;

import java.sql.*;
import java.util.Locale;

public class DatabaseInitializer {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "gestione_corsi_formativi";
    private Connection conn;
    private Statement st;
    private static DatabaseInitializer instance;

    private DatabaseInitializer() throws SQLException, ClassNotFoundException {
        conn = DriverManager.getConnection(url,user,pass);
        st = conn.createStatement();
        createDatabase();
        createTableUsers();
        createTableCourses();
        createTableEnrollments();
        createAdminUser();
        createCourses();
    }

    // Singleton patterm
    public static DatabaseInitializer getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null) {
            instance = new DatabaseInitializer();
        }
        return instance;
    }
    public Connection getConn() {
        return conn;
    }

    // DB
    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("Database " + dbName + " connected successfully.");
        conn = DriverManager.getConnection(url+dbName,user,pass);
        st = conn.createStatement();
    }

    // Table Users
    private void createTableUsers() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " fullname VARCHAR(50) NOT NULL," +
                " username VARCHAR(50) NOT NULL," +
                " password VARCHAR(255) NOT NULL," +
                " role VARCHAR(20) NOT NULL," +
                " CONSTRAINT pk_user PRIMARY KEY(id)," +
                " CONSTRAINT uk_username UNIQUE(username)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Users created successfully.");
    }

    // Table courses
    private void createTableCourses() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS courses (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " title VARCHAR(100) NOT NULL," +
                " teacher VARCHAR(100) NOT NULL," +
                " duration INT NOT NULL," +
                " max_students INT NOT NULL," +
                " CONSTRAINT pk_course PRIMARY KEY(id)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Courses created successfully.");

    }

    // Table Enrollments
    private void createTableEnrollments() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS enrollments (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " user_id INT NOT NULL," +
                " course_id INT NOT NULL," +
                " enrollment_date DATE NOT NULL," +
                " CONSTRAINT pk_enrollment PRIMARY KEY(id)," +
                " CONSTRAINT fk_enrol_user FOREIGN KEY(user_id) REFERENCES users(id) ON  DELETE CASCADE," +
                " CONSTRAINT fk_enrol_course FOREIGN KEY(course_id) REFERENCES courses(id) ON  DELETE CASCADE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Enrollments created successfully.");

    }

    // Example Data
    private void createAdminUser() throws SQLException {

        String checkSql = "SELECT id FROM users WHERE username=?";
        String insertSql = "INSERT INTO users (fullname, username, password, role) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url + dbName, user, pass);
                PreparedStatement check = conn.prepareStatement(checkSql)
        ) {

            check.setString(1, "admin");
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("Admin already exists.");
                return;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {

                insert.setString(1, "Mario Rossi");
                insert.setString(2, "admin");
                insert.setString(3, "Pa$$w0rd!");
                insert.setString(4, Role.ADMIN.toString());

                insert.executeUpdate();
                System.out.println("Admin created successfully.");
            }
        }
    }

    private void createCourses() throws SQLException, ClassNotFoundException {
        Faker fake =  new Faker(new Locale("it-IT"));

        String checkSql = "SELECT id FROM courses";
        String insertSql = "INSERT INTO courses (title, teacher, duration, max_students) VALUES (?, ?, ?, ?);";

        try (
                Connection conn = DriverManager.getConnection(url + dbName, user, pass);
                PreparedStatement check = conn.prepareStatement(checkSql)
        ) {

            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                System.out.println("Courses already exists.");
                return;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {

                for (int i = 0; i < fake.random().nextInt(5, 10); i++) {
                    insert.setString(1, fake.programmingLanguage().name());
                    insert.setString(2, fake.name().fullName());
                    insert.setInt(3, fake.number().numberBetween(50, 250));
                    insert.setInt(4, fake.number().numberBetween(10, 25));

                    insert.executeUpdate();
                    System.out.println("Course created successfully.");

                }

            }
        }

    }
}
