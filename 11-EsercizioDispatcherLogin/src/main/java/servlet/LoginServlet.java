package servlet;

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
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if(c.getName().equals("userLogin")){
                String username = c.getValue();
                System.out.println(username);
                req.setAttribute("username", username);
                req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
                return;
            }
        }

        req.setAttribute("username", "");
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String check = req.getParameter("check");

        User user = UserService.login(username, password); // null | Obj

        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", user);
            req.setAttribute("success", user.getFullname() + " logged in!");

            if(check != null && check.equals("on")){
                Cookie userLogin = new Cookie("userLogin", username);
                userLogin.setMaxAge(60*60*24); // 1 giorno

                resp.addCookie(userLogin);
                System.out.println("Cookie: " + username);
            }
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);

        } else {
            req.setAttribute("error", "Email or Password is invalid");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
            return;
        }
    }
}
