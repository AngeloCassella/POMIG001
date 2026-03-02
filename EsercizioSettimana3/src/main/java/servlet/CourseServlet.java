package servlet;

import dao.CourseDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Course;
import model.User;
import service.AuthService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");

        if(userLogin == null){
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if(c.getName().equals("userLogin")){
                    String username = c.getValue();
                    try {
                        userLogin = UserDAO.findUserByUsername(username);
                        session.setAttribute("userLogin", userLogin);

                        req.setAttribute("userLogin", userLogin);

                    } catch (SQLException | ClassNotFoundException e) {
                        System.err.println(e.getMessage());
                    }

                    resp.sendRedirect("/login");
                    return;
                }
            }
            resp.sendRedirect("login");
            return;
        }

        try {
            List<Course> courses = CourseDAO.findAllCourses();
            req.setAttribute("courses", courses);

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        req.getRequestDispatcher("jsp/courses.jsp").forward(req, resp);
    }
}
