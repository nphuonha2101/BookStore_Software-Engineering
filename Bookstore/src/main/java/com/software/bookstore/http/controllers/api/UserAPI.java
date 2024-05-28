package com.software.bookstore.http.controllers.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.http.models.User;
import com.software.bookstore.http.response.JsonFactory;
import com.software.bookstore.http.services.UserSerivce;

@WebServlet("/api/users")
public class UserAPI extends HttpServlet {
    private UserSerivce userSerivce = new UserSerivce();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        List<User> data = userSerivce.findAll();
        resp.getWriter().print(new JsonFactory.Success(data).build());
    }
}
