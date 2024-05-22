<%-- 
    Document   : register
    Created on : May 22, 2024, 11:37:21 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link rel="stylesheet" href="/public/css/auth.css">
</head>
<div id="registerPage">
    <div class="row g-0" style="height: 100vh;">
        <div class="col-md col-12 h-100">
            <div class="d-flex h-100 justify-content-center align-items-center">
                <section id="registerPageLeft">
                    <div class="text-center">
                        <h1>B-World</h1>
                        <p class="fs-3">Đăng ký tài khoản mới</p>
                    </div>

                    <form action="/auth/register" id="registerForm" method="POST">
                        <div class="form-group my-3">
                            <input type="email" class="form-register-control" id="email" name="email" placeholder="Email" required>
                        </div>
                        <div class="form-group my-3">
                            <input type="password" class="form-register-control" id="password" name="password" placeholder="Mật khẩu" required>
                        </div>
                        <div class="form-group my-3">
                            <input type="text" class="form-register-control" id="fullname" name="fullname" placeholder="Họ và tên" required>
                        </div>
                        <div class="form-group my-3">
                            <input type="text" class="form-register-control" id="address" name="address" placeholder="Địa chỉ" required>
                        </div>
                        <div class="form-group my-3">
                            <label for="#birtdate">Ngày sinh</label>
                            <input type="date" class="form-register-control mt-2" id="birthday" name="birthday" placeholder="Ngày sinh" required>
                        </div>
                        <button type="submit" class="d-block w-100 btn-auth-main">Đăng ký</button>
                    </form>
                </section>
            </div>
        </div>
        <div class="col-md d-none d-md-block">
            <section id="registerPageRight">
                <a href="/home" class="back-to-home d-none d-md-block bg-secondary">Quay lại trang chủ</a>
                <div id="registerPageRightContent">
                    <h1 class="text-uppercase fw-bold fs-1 page-title">
                        <span class="text-white">Chào mừng đã đến với</span>
                        <span class="text-auth-main">B-world</span>
                    </h1>
    
                    <p class="description text-white">Nếu bạn đã có tài khoản, xin vui lòng đăng nhập tại đây</p>

                    <a href="/login" class="btn-auth-main text-decoration-none" style="border-radius: 8px;">Đăng nhập</a>
                </div>
            </section>
        </div>  
    </div>
</div>