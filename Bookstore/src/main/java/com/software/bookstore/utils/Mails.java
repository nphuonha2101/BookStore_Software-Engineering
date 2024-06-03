package com.software.bookstore.utils;

import com.software.bookstore.mail.Mail;

public class Mails {
    public static void sendEmailVerification(String email, String token) {
        String host = Files.env("app.host");
        String mailContent = host + "/verify-email?token=" + token;
        Mail.sendTo(email, "Email Verification", mailContent, "text/html");
    }
}
