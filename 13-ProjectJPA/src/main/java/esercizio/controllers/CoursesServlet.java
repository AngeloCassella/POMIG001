package esercizio.controllers;

import esercizio.dao.CourseDAO;
import esercizio.dao.UserDAO;
import esercizio.models.Course;
import esercizio.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/courses")
public class CoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");

        if(userLogin == null){
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if(c.getName().equals("userLogin")){
                    String username = c.getValue();
                    if(UserDAO.getUserByUsername(username).size() > 0) {
                        userLogin = UserDAO.getUserByUsername(username).get(0);
                        session.setAttribute("userLogin", userLogin);
                        req.setAttribute("userLogin", userLogin);
                    }

                    resp.sendRedirect("/login");
                    return;
                }
            }
            resp.sendRedirect("/login");
            return;
        }

        List<Course> courses = CourseDAO.getAllCourse();
        req.setAttribute("courses", courses);

        req.getRequestDispatcher("jsp/courses.jsp").forward(req, resp);
    }

}
