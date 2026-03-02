package dao;

import model.Course;
import model.Enrollment;
import model.Role;
import model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public static String saveEnrollment(Enrollment enrollment) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO enrollments (user_id, course_id, enrollment_date) " +
                " VALUES (?, ?, ?);";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, enrollment.getUser().getId());
        ps.setInt(2, enrollment.getCourse().getId());
        ps.setDate(3, Date.valueOf(enrollment.getEnrollment_date()));
        ps.executeUpdate();
        return "Enrollment created successfully.";
    }

    public static Enrollment findEnrollmentById(int enrollmentId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM enrollments WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, enrollmentId);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id = rs.getInt("id");
            User user = UserDAO.findUserById(rs.getInt("user_id"));
            Course course = CourseDAO.findCourseById(rs.getInt("course_id"));
            LocalDate  enrollmentDate = LocalDate.parse(rs.getString("enrollment_date"));

            return new Enrollment(id, user, course, enrollmentDate);
        }
        return null;
    }

    public static void removeEnrollment(Enrollment enrollment) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM enrollments WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, enrollment.getId());
        ps.executeUpdate();
        System.out.println("Enrollment deleted successfully.");
    }

    public static List<Enrollment> findAllEnrollments() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM enrollments;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

        List<Enrollment> enrollments = new ArrayList<>();
        ResultSet rs = ps.executeQuery(); // null | row
        while (rs.next()){
            int id = rs.getInt("id");
            User user = UserDAO.findUserById(rs.getInt("user_id"));
            Course course = CourseDAO.findCourseById(rs.getInt("course_id"));
            LocalDate  enrollmentDate = LocalDate.parse(rs.getString("enrollment_date"));

            enrollments.add(new Enrollment(id, user, course, enrollmentDate));
        }
        return enrollments;
    }

    public static List<Enrollment> findEnrollmentsByUser(int userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM enrollments WHERE user_id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, userId);

        List<Enrollment> enrollments = new ArrayList<>();
        ResultSet rs = ps.executeQuery(); // null | row
        while(rs.next()){
            int id = rs.getInt("id");
            User user = UserDAO.findUserById(rs.getInt("user_id"));
            Course course = CourseDAO.findCourseById(rs.getInt("course_id"));
            LocalDate  enrollmentDate = LocalDate.parse(rs.getString("enrollment_date"));

            enrollments.add(new Enrollment(id, user, course, enrollmentDate));
        }
        return enrollments;
    }
}
