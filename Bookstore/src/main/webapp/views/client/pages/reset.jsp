<%-- 
    Document   : reset
    Created on : May 29, 2024, 2:47:32 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="/public/css/auth.css">
</head>
<div id="resetPage">
    <div class="row g-0" style="height: 100vh;">
        <div class="col-md col-12 h-100">
            <div class="d-flex h-100 justify-content-center align-items-center">
                <section id="resetPageLeft">
                    <div class="text-center">
                        <h1>B-World</h1>
                        <p class="fs-3">Đặt mật khẩu mới</p>
                    </div>

                    <c:choose>
                        <c:when test="${not isExpired}">
                            <form id="resetForm" method="POST">
                                <div class="form-group my-3">
                                    <input type="password" class="form-reset-control" id="password" name="password" placeholder="Mật khẩu mới" required>
                                </div>
                                <div class="form-group my-3">
                                    <input type="password" class="form-reset-control" id="passwordConfirm" name="passwordConfirm" placeholder="Xác nhận mật khẩu mới" required>
                                </div>
                                <input type="hidden" name="token" value="${token}">
                                <button type="submit" class="d-block w-100 btn-auth-main">Đặt lại mật khẩu</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-danger" role="alert">
                                Token đã hết hạn. Vui lòng gửi mail lại
                            </div>
                        </c:otherwise>
                    </c:choose>


                </section>
            </div>
        </div>
        <div class="col-md d-none d-md-block">
            <section id="resetPageRight">
                <a href="/home" class="back-to-home d-none d-md-block bg-secondary">Quay lại trang chủ</a>
                <div id="resetPageRightContent">
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
