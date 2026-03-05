package esercizio.controllers;

import esercizio.dao.EnrollmentDAO;
import esercizio.dao.UserDAO;
import esercizio.models.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

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

        req.setAttribute("userLogin", userLogin);
        req.setAttribute("userEnrollments", EnrollmentDAO.getEnrollmentsByUser(userLogin));

        req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
    }

}
