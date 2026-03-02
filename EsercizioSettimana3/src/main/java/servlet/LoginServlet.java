package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Role;
import model.User;
import service.AuthService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String check = req.getParameter("check");

        try {
            User userLogin = AuthService.login(username, password);
            if(userLogin == null){
                // email non corretta
                req.setAttribute("error", "Email or Password is invalid");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", userLogin);

            if(check != null && check.equals("on")){
                Cookie userLoginCookie = new Cookie("userLogin", userLogin.getUsername());
                userLoginCookie.setMaxAge(60*60*24);
                resp.addCookie(userLoginCookie);
                System.out.println("Cookie: " + userLogin.getUsername());
            }

            if(userLogin.getRole().equals(Role.ADMIN)){
                resp.sendRedirect("/admin");
                return;
            }

            resp.sendRedirect(req.getContextPath() + "/");

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}
