package com.software.bookstore.core.base.page;

import com.software.bookstore.utils.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPage extends APage {
    public AdminPage(HttpServletRequest req, HttpServletResponse resp, String page, String layout) {
        super(req, resp, page, layout);
    }

    @Override
    public void render() {
        // TODO: change pathToPage to Pages.getAdminPageDir() + this.page
        String pathToLayout = Pages.getClientLayoutDir() + this.layout;
        String pathToPage = Pages.getAdminPageDir() + this.page;
        RequestDispatcher rd = req.getRequestDispatcher(pathToLayout);
        try {
            req.setAttribute("page", pathToPage);
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
