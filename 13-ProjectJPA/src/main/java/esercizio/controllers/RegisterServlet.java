package esercizio.controllers;

import esercizio.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Please fill all the fields");
            req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
            return;
        }

        String msg = AuthService.register(fullname, username, password);
        if(msg.equals("User has been saved successfully")) {
            req.setAttribute("success", msg);
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", msg);
            req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
        }

    }
}
