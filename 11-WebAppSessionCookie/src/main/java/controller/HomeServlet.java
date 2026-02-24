package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        User u = new User("Mario Rossi", "m.rossi@example.com", "Pa$$w0rd!");
        UserService.addUser(u);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");

        if(userLogin == null){
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if(c.getName().equals("userLogin")){
                    String email = c.getValue();
                    userLogin = UserService.getUser(email);
                    session.setAttribute("userLogin", userLogin);
                    req.setAttribute("users", UserService.getUsers());
                    req.setAttribute("userLogin", userLogin);

                    req.getRequestDispatcher("/home.jsp").forward(req, resp);
                    return;
                }
            }
            resp.sendRedirect("login");
            return;
        }

        req.setAttribute("users", UserService.getUsers());
        req.setAttribute("userLogin", userLogin);

        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }


}
