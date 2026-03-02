package servlet;

import dao.EnrollmentDAO;
import dao.UserDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

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
            req.setAttribute("userLogin", userLogin);
            req.setAttribute("userEnrollments", EnrollmentDAO.findEnrollmentsByUser(userLogin.getId()));


            // EnrollmentDAO.findEnrollmentsByUser(userLogin.getId()).get(0).getCourse().getTitle()
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        req.getRequestDispatcher("jsp/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
