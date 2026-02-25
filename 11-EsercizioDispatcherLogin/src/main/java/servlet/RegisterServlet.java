package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Please fill all the fields");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
            return;
        }

        if(UserService.register(name, username, password)) {
            req.setAttribute("success", "registered successfully");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "username or password is incorrect");
            req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
        }

    }
}
