<%-- 
    Document   : register
    Created on : May 22, 2024, 11:37:21 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link rel="stylesheet" href="/public/css/auth.css">
</head>
<div id="forgotPage">
    <div class="row g-0" style="height: 100vh;">
        <div class="col-md col-12 h-100">
            <div class="d-flex h-100 justify-content-center align-items-center">
                <section id="forgotPageLeft">
                    <div class="text-center">
                        <h1>B-World</h1>
                        <p class="fs-3">Lấy lại mật khẩu của bạn</p>
                    </div>

                    <form action="/auth/forgot" id="forgotForm" method="POST">
                        <div class="form-group my-3">
                            <input type="email" class="form-forgot-control" id="email" name="email" placeholder="Email">
                        </div>
                        <button type="submit" class="d-block w-100 btn-auth-main">Đăng nhập</button>
                    </form>
                </section>
            </div>
        </div>
        <div class="col-md d-none d-md-block">
            <section id="forgotPageRight">
                <a href="/home" class="back-to-home d-none d-md-block bg-secondary">Quay lại trang chủ</a>
                <div id="forgotPageRightContent">
                    <h1 class="text-uppercase fw-bold fs-1 page-title">
                        <span class="text-white">Chào mừng đã đến với</span>
                        <span class="text-auth-main">B-world</span>
                    </h1>
    
                    <p class="description text-white">Nếu bạn không có nhu cầu lấy lại mật khẩu, vui lòng đăng nhập tại đây</p>

                    <a href="/login" class="btn-auth-main text-decoration-none" style="border-radius: 8px;">Đăng nhập</a>
                </div>
            </section>
        </div>  
    </div>
</div>