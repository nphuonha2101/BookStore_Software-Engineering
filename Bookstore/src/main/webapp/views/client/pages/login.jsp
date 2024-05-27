<%-- 
    Document   : login
    Created on : May 21, 2024, 6:42:29 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="/public/css/auth.css">
</head>
<div id="loginPage">
    <div class="row g-0" style="height: 100vh;">
        <div class="col-md col-12 h-100">
            <div class="d-flex h-100 justify-content-center align-items-center">
                <section id="loginPageLeft">
                    <c:if test="${not empty loginMessage}">
                        <div class="alert alert-danger">${loginMessage}</div>
                    </c:if>
                    <div class="text-center">
                        <h1>B-World</h1>
                        <p class="fs-3">Đăng nhập vào tài khoản của bạn</p>
                    </div>

                    <form action="/auth/login" id="loginForm" method="POST">
                        <div class="form-group my-3">
                            <input type="email" class="form-login-control" id="email" name="email" placeholder="Email" required>
                        </div>
                        <div class="form-group my-3">
                            <input type="password" class="form-login-control" id="password" name="password" placeholder="Mật khẩu" required>
                        </div>

                        <div class="form-group my-3 d-flex justify-content-between align-items-center">

                            <div class="form-check">
                                <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
                                <label class="form-check p-0" for="rememberMe">Lưu đăng nhập</label>
                            </div>

                            <a href="/forgot-password" id="forgotPassword">Quên mật khẩu?</a>
                        </div>
                        <button type="submit" class="d-block w-100 btn-auth-main">Đăng nhập</button>
                    </form>
                </section>
            </div>
        </div>
        <div class="col-md d-none d-md-block">
            <section id="loginPageRight">
                <a href="/home" class="back-to-home d-none d-md-block bg-secondary">Quay lại trang chủ</a>
                <div id="loginPageRightContent">
                    <h1 class="text-uppercase fw-bold fs-1 page-title">
                        <span class="text-white">Chào mừng đã đến với</span>
                        <span class="text-auth-main">B-world</span>
                    </h1>
    
                    <p class="description text-white">Xin vui lòng đăng nhập vào tài khoản của bạn để có thể có những trải nghiệm mua và đọc sách tốt nhất tại đây.</p>

                    <a href="/register" class="btn-auth-main text-decoration-none" style="border-radius: 8px;">Đăng ký tài khoản mới</a>
                </div>
            </section>
        </div>  
    </div>
</div>
