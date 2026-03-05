package esercizio.controllers;

import esercizio.dao.CourseDAO;
import esercizio.dao.EnrollmentDAO;
import esercizio.dao.UserDAO;
import esercizio.models.Course;
import esercizio.models.Enrollment;
import esercizio.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/enroll")
public class EnrollmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");

        if (userLogin == null) {
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("userLogin")) {
                    String username = c.getValue();
                    if (UserDAO.getUserByUsername(username).size() > 0) {
                        userLogin = UserDAO.getUserByUsername(username).get(0);
                        session.setAttribute("userLogin", userLogin);
                        req.setAttribute("userLogin", userLogin);
                    }

                    resp.sendRedirect("/login");
                    return;
                }
            }
            resp.sendRedirect("login");
            return;
        }

        List<Course> courses = CourseDAO.getAllCourse();
        req.setAttribute("courses", courses);

        req.getRequestDispatcher("jsp/enrollments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User userLogin = (User) session.getAttribute("userLogin");
        int id_corso = Integer.parseInt(req.getParameter("courses"));
        Course course = CourseDAO.getCourse(id_corso);
        Enrollment e = new Enrollment();
        e.setUser(userLogin);
        e.setCourse(course);
        e.setEnrollment_date(LocalDate.now());
        String msg = EnrollmentDAO.saveEnrollment(e);
        req.setAttribute("success", msg);
        req.getRequestDispatcher("jsp/enrollments.jsp").forward(req, resp);
    }
}
