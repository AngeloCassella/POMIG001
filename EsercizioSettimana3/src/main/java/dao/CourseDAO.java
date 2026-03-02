package dao;

import model.Course;
import model.Role;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public static void saveCourse(Course course) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO courses (title, teacher, duration, max_students) " +
                " VALUES (?, ?, ?, ?);";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setString(1, course.getTitle());
        ps.setString(2, course.getTeacher());
        ps.setInt(3, course.getDuration());
        ps.setInt(4, course.getMax_students());
        ps.executeUpdate();
        System.out.println("Course " + course.getTitle() + " created successfully.");
    }

    public static Course findCourseById(int courseID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM courses WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, courseID);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String teacher = rs.getString("teacher");
            int duration = rs.getInt("duration");
            int max_students = rs.getInt("max_students");

            return new Course(id, title, teacher, duration, max_students);
        }
        return null;
    }

    public static void updateCourse(Course course) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE courses SET title=?,teacher=?,duration=?,max_students=?  WHERE id=?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setString(1, course.getTitle());
        ps.setString(2, course.getTeacher());
        ps.setInt(3, course.getDuration());
        ps.setInt(4, course.getMax_students());
        ps.setInt(5, course.getId());
        ps.executeUpdate();
        System.out.println("Course " + course.getTitle() + " modified successfully.");
    }

    public static void removeCourse(Course course) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM courses WHERE id = ?;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
        ps.setInt(1, course.getId());
        ps.executeUpdate();
        System.out.println("Course " + course.getTitle() + " deleted successfully.");
    }

    public static List<Course> findAllCourses() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM courses;";
        PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

        List<Course> courses = new ArrayList<>();
        ResultSet rs = ps.executeQuery(); // null | row
        while(rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String teacher = rs.getString("teacher");
            int duration = rs.getInt("duration");
            int max_students = rs.getInt("max_students");

            courses.add(new Course(id, title, teacher, duration, max_students));
        }
        return courses;
    }

}
