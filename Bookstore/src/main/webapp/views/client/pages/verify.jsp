<%-- 
    Document   : verify
    Created on : Jun 3, 2024, 5:24:47 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verify Email</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>
<body>
    <section class="section">
        <div class="container">
            <c:if test="${not empty message}">
                <div class="notification ${alertType}">
                    <button class="delete"></button>
                    ${message}
                </div>
            </c:if>
            <img class="mx-auto" width="200px" height="200px" style="display: block;" src="data:image/png;base64,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">
            <h1 class="title has-text-centered">Xác thực Email</h1>
            <p class="has-text-centered">Xin click vào nút dưới đây để chúng tôi gửi email xác thực đến: <span class="has-text-info">${email}</span></p>
            <form method="POST">
                <button class="button is-primary mx-auto mt-3" style="display: block;" type="submit">Gửi yêu cầu xác thực</button>
            </form>
        </div>
    </section>
</body>
</html>