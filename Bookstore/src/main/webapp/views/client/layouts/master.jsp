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
        <title>${title}</title>
        <script type="text/javascript" src="
       https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
        </script>

        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="/views/client/partials/header.jsp" %>
        <main>
            <jsp:include page="${page}"/>
        </main>
        <%@include file="/views/client/partials/header.jsp" %>
    </body>
</html>
