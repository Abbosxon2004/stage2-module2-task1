package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Warehouse warehouse = Warehouse.getInstance();
        Set<User> users = warehouse.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/add").forward(req, resp);
//        resp.sendRedirect("http://localhost:8080/users");
    }
}
