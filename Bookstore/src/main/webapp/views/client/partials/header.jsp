<%-- Document : header Created on : May 19, 2024, 2:36:08 AM Author : thang --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<head>
    <link rel="stylesheet" href="/public/css/header.css">
</head>

<header id="#header" class="py-3">
    <div class="header-top">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-2 col-md-3 col-3">
                    <div class="logo">
                        <a href="/">
                            <object class="w-100" data="/public/imgs/logo/logo.svg"
                                    type="image/svg+xml"></object>
                        </a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-1 col-1">
                    <div class="search">
                        <form id="searchForm" action="/search" method="get">
                            <div class="form-group d-lg-block d-none">
                                <input class="form-control" type="text" name="q"
                                       placeholder="Tìm kiếm các loại sách...">
                                <button class="need-absolute" type="submit"><i class="fas fa-search"></i></button>
                            </div>

                            <div class="d-lg-none d-block">
                                <button type="button" class="open-search">
                                    <i class="fas fa-search"></i>
                                    <input class="form-control search-absolute" type="text" name="q" placeholder="Tìm kiếm các loại sách..."/>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 col-md-5 col-5 top-navbar">
                    <div class="d-md-flex d-none justify-content-start align-items-center">
                        <a href="" class="text-navbar text-decoration-none me-3">Mới nhất</a>
                        <a href="" class="text-navbar text-decoration-none me-3">Bán chạy nhất</a>
                        <a href="" class="text-navbar text-decoration-none me-3">Khuyến mãi</a>
                    </div>

                    <div class="d-md-none d-block">
                        <div class="phone-number">
                            <i class="text-main fas fa-phone-alt"></i>
                            <span>+84 879 603 547</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-3">
                    <div class="row">
                        <div class="col-md-2 col-5">
                            <div class="cart">
                                <a href="/cart" class="text-decoration-none text-main cart-link">
                                    <i class="fas fa-shopping-cart text-main"></i>
                                    <span class="cart-count">0</span>
                                </a>
                            </div>
                        </div>

                        <div class="col-md-10 col-4">
                            <div class="user d-lg-block d-none">
                                <div class="d-flex justify-content-end align-items-center">
                                    <a class="ms-3 text-decoration-none text-main" href="/login">Đăng nhập</a>
                                    <a class="ms-3 text-decoration-none text-main" href="/register">Đăng ký</a>
                                </div>
                            </div>

                            <div class="user-relative ms-md-3 d-lg-none d-block">
                                <div class="icon text-center">
                                    <button id="headerToggleAuthAction" class="border-0 bg-white">
                                        <i class="fa-solid fa-user text-main"></i>
                                    </button>
                                    <div class="auth-action justify-content-between">
                                        <a class="text-decoration-none text-secondary" href="/login">Đăng nhập</a>
                                        <a class="text-decoration-none text-secondary" href="/register">Đăng ký</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="d-md-none d-block col-1">
                            <button id="openSideMenuBtn" class="bg-white border-0">
                                <i class="fas fa-bars text-main"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="header-bottom py-3 d-none d-md-block">
        <div class="container">
            <div class="d-md-flex d-none justify-content-between align-items-center">
                <ul class="header-bottom-nav list-unstyled d-flex gap-3 align-items-center m-0">
                    <li><a href="/home" class="text-decoration-none text-dark">Trang chủ</a></li>
                    <li><a href="" class="text-decoration-none text-dark">Giới thiệu</a></li>
                    <li><a href="/products" class="text-decoration-none text-dark">Thư viện</a></li>
                    <li><a href="" class="text-decoration-none text-dark">Liên hệ</a></li>
                </ul>
    
                <div class="header-bottom-contact d-flex gap-5 align-items-center">
                    <div class="phone-number">
                        <i class="text-main fas fa-phone-alt"></i>
                        <span>+84 879 603 547</span>
                    </div>
    
                    <button class="contact-btn bg-main-outline px-3 py-2">
                        <span>Liên hệ với chúng tôi</span>
                    </button>
                </div>
            </div>
        </div>
    </div>

    <aside id="headerAside">
        <button id="closeSideMenuBtn" class="bg-white border-0 p-3" style="margin-left: auto; display: block;">
            <i class="fas fa-times text-main"></i>
        </button>
        <ul class="list-unstyled bg-white">
            <li><a href="/" class="text-decoration-none text-dark">Trang chủ</a></li>
            <li><a href="" class="text-decoration-none text-dark">Giới thiệu</a></li>
            <li><a href="" class="text-decoration-none text-dark">Thư viện</a></li>
            <li><a href="" class="text-decoration-none text-dark">Liên hệ</a></li>
        </ul>
    </aside>
</header>

<script src="/public/js/header.js"></script>