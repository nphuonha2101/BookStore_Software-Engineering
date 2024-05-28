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
        <!-- bootstrap -->
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

        <!-- fontawesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

        <!-- splide js -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@4.1.4/dist/css/splide.min.css">
        <script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@4.1.4/dist/js/splide.min.js"></script>


        <!-- favicon -->
        <link rel="icon" href="/public/favicon.ico" type="image/x-icon">

        <!-- custom css -->
        <link rel="stylesheet" href="/public/css/variables.css">
        <title>${title}</title>
    </head>
    <body>
        <div class="overlay"></div>
        <%@include file="/views/client/partials/header.jsp" %>
        <main>
            <jsp:include page="${page}"/>
        </main>
        <%@include file="/views/client/partials/footer.jsp" %>
    </body>
</html>
