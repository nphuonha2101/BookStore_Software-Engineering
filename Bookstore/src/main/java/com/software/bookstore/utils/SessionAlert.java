package com.software.bookstore.utils;

import javax.servlet.http.HttpSession;

public class SessionAlert {
    public static void setMessage(HttpSession session, String message, String alertType) {
        session.setAttribute("alertMessage", message);
        session.setAttribute("alertType", alertType);
    }

    public static String[] getMessage(HttpSession session) {
        String message = (String) session.getAttribute("alertMessage");
        String alertType = (String) session.getAttribute("alertType");
        clearMessage(session);
        return new String[]{message, alertType};
    }

    public static void clearMessage(HttpSession session) {
        session.removeAttribute("alertMessage");
        session.removeAttribute("alertType");
    }
}
