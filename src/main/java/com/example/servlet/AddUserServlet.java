package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Warehouse warehouse=Warehouse.getInstance();
        warehouse.addUser(user);
        req.setAttribute("user", user);
//        req.getRequestDispatcher("/add").forward(req, resp);
        resp.sendRedirect("http://localhost:8080/add");
    }
}
