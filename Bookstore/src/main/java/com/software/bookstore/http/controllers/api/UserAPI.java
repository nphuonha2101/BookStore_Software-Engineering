package com.software.bookstore.http.controllers.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.http.response.JsonFactory;
import com.software.bookstore.http.services.UserSerivce;

@WebServlet("/api/users")
public class UserAPI extends HttpServlet {
    private UserSerivce userSerivce = new UserSerivce();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().print(JsonFactory.success("Success", userSerivce.findAll()));
    }
}
