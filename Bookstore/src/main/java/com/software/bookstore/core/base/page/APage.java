package com.software.bookstore.core.base.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class APage implements IPage {
    protected HttpServletRequest req;
    protected HttpServletResponse resp;
    protected String page;
    protected String layout;

    @Override
    public abstract void render();

    @Override
    public Object getObject(String key) {
        return req.getAttribute(key);
    }

    @Override
    public void setObject(String key, Object object) {
        req.setAttribute(key, object);
    }

    @Override
    public void setTitle(String title) {
        req.setAttribute("title", title);
    }

    @Override
    public void removeObject(String key) {
        req.removeAttribute(key);
    }

}
