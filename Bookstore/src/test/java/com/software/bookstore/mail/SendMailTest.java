package com.software.bookstore.mail;

import org.junit.jupiter.api.Test;

class SendMailTest {

    @Test
    void sendMail() {
        SendMail sendMail = SendMail.getInstance();
        sendMail.sendMail("21130122@st.hcmuaf.edu.vn", "Test", "Test", "text/html");
    }
}