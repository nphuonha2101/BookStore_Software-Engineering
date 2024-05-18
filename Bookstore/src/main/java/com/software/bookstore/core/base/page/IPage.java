package com.software.bookstore.core.base.page;

public interface IPage {
    public void render();
    public void setObject(String key, Object object);
    public Object getObject(String key);
    public void setTitle(String title);
}
