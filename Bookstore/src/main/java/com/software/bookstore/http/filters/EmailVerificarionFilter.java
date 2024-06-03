package com.software.bookstore.http.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.software.bookstore.http.models.User;
import com.software.bookstore.http.models.VerifyEmail;
import com.software.bookstore.http.services.VerifyEmailService;

@WebFilter("/*")
public class EmailVerificarionFilter implements Filter {

    private final VerifyEmailService verifyEmailService = new VerifyEmailService();

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        // Check request is public
        String path = request.getRequestURI().substring(request.getContextPath().length());

        if(path.startsWith("/public")) {
            chain.doFilter(req, resp);
            return;
        }

        if(path.startsWith("/verify-email")) {
            chain.doFilter(request, response);
            return;
        }

        if(loginUser == null) {
            chain.doFilter(req, resp);
        } else {
            VerifyEmail verifyEmail = verifyEmailService.findByUserId(loginUser.getId());
            if(verifyEmail == null) {
                chain.doFilter(req, resp);
            } else {
                if(path.equals("/email/verify")) {
                    chain.doFilter(req, resp);
                    return;
                }
                response.sendRedirect("/email/verify");
            }
        }


    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}
    
}
