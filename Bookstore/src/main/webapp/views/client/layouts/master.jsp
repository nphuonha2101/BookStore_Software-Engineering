<%-- 
    Document   : master
    Created on : May 19, 2024, 2:16:00 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookstore</title>
    </head>
    <body>
        <%@include file="/views/client/partials/header.jsp" %>
        <main>
            <jsp:include page="${page}"/>
        </main>
        <%@include file="/views/client/partials/header.jsp" %>
    </body>
</html>
