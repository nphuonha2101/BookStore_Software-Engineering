package com.software.bookstore.core.base.page;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.software.bookstore.utils.Pages;

public class ClientPage extends APage {

    public ClientPage(HttpServletRequest req, HttpServletResponse resp, String page, String layout) {
        super(req, resp, page, layout);
    }

    @Override
    public void render() {
        String pathToLayout = Pages.getClientLayoutDir() + this.layout;
        String pathToPage = Pages.getClientPageDir() + this.page;
        RequestDispatcher rd = req.getRequestDispatcher(pathToLayout);
        try {
            req.setAttribute("page", pathToPage);
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
