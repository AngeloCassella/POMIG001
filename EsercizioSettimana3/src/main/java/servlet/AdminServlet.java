package servlet;

import dao.CourseDAO;
import dao.EnrollmentDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Course;
import model.Enrollment;
import model.Role;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");
        if (userLogin == null || !userLogin.getRole().equals(Role.ADMIN)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {
            List<Enrollment> listEnroll = EnrollmentDAO.findAllEnrollments();
            req.setAttribute("enrollments", listEnroll);
            List<Course> listCourse = CourseDAO.findAllCourses();
            req.setAttribute("courses", listCourse);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        req.getRequestDispatcher("jsp/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("remove") != null) {
            try {
                CourseDAO.removeCourse(CourseDAO.findCourseById(Integer.parseInt(req.getParameter("remove"))));
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }

            doGet(req, resp);
            return;
        }


        String title = req.getParameter("title");
        String teacher = req.getParameter("teacher");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int max_students = Integer.parseInt(req.getParameter("max_students"));

        try {
            Course course = new Course(title, teacher, duration, max_students);
            CourseDAO.saveCourse(course);

            req.setAttribute("success", "Course created successfully.");
            doGet(req, resp);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
