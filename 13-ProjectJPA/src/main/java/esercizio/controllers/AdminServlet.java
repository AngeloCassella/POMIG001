package esercizio.controllers;


import esercizio.dao.CourseDAO;
import esercizio.dao.EnrollmentDAO;
import esercizio.enumerations.Role;
import esercizio.models.Course;
import esercizio.models.Enrollment;
import esercizio.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");
        if (userLogin == null || !userLogin.getRole().equals(Role.ADMIN)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        List<Enrollment> listEnroll = EnrollmentDAO.getAllEnrollment();
        req.setAttribute("enrollments", listEnroll);
        List<Course> listCourse = CourseDAO.getAllCourse();
        req.setAttribute("courses", listCourse);

        req.getRequestDispatcher("jsp/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("remove") != null) {
            CourseDAO.deleteCourse(CourseDAO.getCourse(Integer.parseInt(req.getParameter("remove"))));

            doGet(req, resp);
            return;
        }



        String title = req.getParameter("title");
        String teacher = req.getParameter("teacher");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int max_students = Integer.parseInt(req.getParameter("max_students"));

        Course course = new Course();
        course.setTitle(title);
        course.setTeacher(teacher);
        course.setDuration(duration);
        course.setMax_students(max_students);

        CourseDAO.saveCourse(course);

        req.setAttribute("success", "Course created successfully.");
        doGet(req, resp);

    }


}
