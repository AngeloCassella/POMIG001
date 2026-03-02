package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.AuthService;

import java.io.IOException;
import java.sql.SQLException;

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

        try {
            String msg = AuthService.register(fullname, username, password);
            if(msg.equals("User created successfully.")) {
                req.setAttribute("success", msg);
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", msg);
                req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}
