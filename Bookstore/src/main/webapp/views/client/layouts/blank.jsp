<%-- 
    Document   : blank
    Created on : May 21, 2024, 6:41:49 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- bootstrap -->
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

        <!-- fontawesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

        <!-- favicon -->
        <link rel="icon" href="/public/favicon.ico" type="image/x-icon">

        <!-- custom css -->
        <link rel="stylesheet" href="/public/css/variables.css">
        <title>${title}</title>
    </head>
    <body>
        <main>
            <jsp:include page="${page}"/>
        </main>
    </body>
</html>
