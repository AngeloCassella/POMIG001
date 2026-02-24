package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String check = req.getParameter("check");

        User userLogin = UserService.getUser(email);
        if(userLogin == null){
            // email non corretta
            req.setAttribute("error", "Email is invalid");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        } else if(!password.equals(userLogin.getPassword())){
           // password non corretta
            req.setAttribute("error", "Password is invalid");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("userLogin", userLogin);

        if(check != null && check.equals("on")){
            Cookie userLoginEmail = new Cookie("userLogin", userLogin.getEmail());
            userLoginEmail.setMaxAge(60);
            resp.addCookie(userLoginEmail);
            System.out.println("Cookie: " + userLogin.getEmail());
        }

        req.setAttribute("success", userLogin.getName() + " logged in!");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }
}
