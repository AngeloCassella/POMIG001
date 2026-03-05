package esercizio.controllers;

import esercizio.dao.CourseDAO;
import esercizio.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDAO.createAdminUser();
            CourseDAO.createCourses();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }
}
