package com.software.bookstore.mail;

import com.software.bookstore.utils.Files;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Mail {
    private static Mail instance;
    private static Properties mailProperties;

    private Mail() {
        mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.host", com.software.bookstore.configs.MailConfig.HOST);
        mailProperties.put("mail.smtp.socketFactory.port", com.software.bookstore.configs.MailConfig.SSL_PORT);
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailProperties.put("mail.smtp.port", com.software.bookstore.configs.MailConfig.SSL_PORT);
    }

    private static void getInstance() {
        if (instance == null) {
            instance = new Mail();
        }
    }

    /**
     * This method is used to authenticate the email account.
     *
     * @return A session object that represents the authenticated email account.
     */
    private static Session authenticate() {

        String appName = Files.env("mail.appName");
        String appPassword = Files.env("mail.appPassword");

        return Session.getInstance(mailProperties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(appName, appPassword);
            }
        });
    }

    /**
     * This method is used to email a user.
     *
     * @param to          The email address of the recipient. This should be a valid email address.
     * @param subject     The subject of the email. This is a string that describes the main content of the email.
     * @param content     The content of the email. This is a string containing the detailed information you want to send.
     * @param contentType The content type of the email. This is a string that describes the format of the email content (e.g., "text/html").
     * @throws RuntimeException If an error occurs during the sending of the email, a RuntimeException will be thrown.
     */
    public static void sendTo(String to, String subject, String content, String contentType) {
        getInstance();

        try {
            // create a message and set the recipients, subject
            MimeMessage mimeMessage = new MimeMessage(authenticate());
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject(subject);

            // create the message part
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            // set the content of the message part
            mimeBodyPart.setContent(content, contentType + "; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            // set the content of the message
            mimeMessage.setContent(multipart, contentType + "; charset=utf-8");

            Transport.send(mimeMessage);
            System.out.println("Sent mail successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
