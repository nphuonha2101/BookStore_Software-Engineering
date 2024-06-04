package com.software.bookstore.http.filters;

import com.software.bookstore.http.enums.EAccountRole;
import com.software.bookstore.http.models.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class AuthenticationAdminFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User loginUser = (User) req.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            res.sendRedirect("/login");
        } else if (!loginUser.getRole().equals(EAccountRole.ADMIN)) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
