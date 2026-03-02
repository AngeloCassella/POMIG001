package servlet;

import dao.ConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ConnectionManager.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }

}
