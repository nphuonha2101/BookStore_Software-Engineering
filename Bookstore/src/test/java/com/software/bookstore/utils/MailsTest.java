/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.software.bookstore.utils;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.software.bookstore.mail.Mail;

/**
 *
 * @author thang
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Files.class, Mail.class })
public class MailsTest {

    @Before
    public void setUp() {
        PowerMockito.mockStatic(Files.class);
        PowerMockito.mockStatic(Mail.class);
    }

    @Test
    public void testSendEmailVerification() throws Exception {
        String token = "token";
        String email = "test@gmail.com";

        String host = "http://localhost:8080";
        PowerMockito.when(Files.env("app.host")).thenReturn(host);
        PowerMockito.doNothing().when(Mail.class, "sendTo", eq(email), anyString(), anyString(), eq("text/html"));

        Mails.sendEmailVerification(email, token);
        PowerMockito.verifyStatic(Mail.class);
        Mail.sendTo(eq(email), anyString(), anyString(), eq("text/html"));
    }

}
