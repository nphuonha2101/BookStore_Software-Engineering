<%-- 
    Document   : home
    Created on : May 19, 2024, 2:55:50 AM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <section class="popular-book">
        <div class="row">
            <div class="col">
                <div class="bg-main-outline d-inline-block p-3">
                    <span>Các tác giả trong tháng này</span>
                </div>

                <h1 class="mt-3">Eric-Emanuel Schmitt</h1>
                <p class="mt-3">Eric-Emmanuel Schmitt has been awarded more than 20 literary prizes and distinctions, and in 2001 he received the title of Chevalier des Arts et des Lettres. His books have been translated into over 40 languages.</p>
                <div class="bg-main d-inline-block p-3 mt-3">
                    <a href="/products" class="text-decoration-none text-white">Xem sách</a>
                </div>                
            </div>
            <div class="col">
                <img src="/public/imgs/backgrounds/home-banner.png" alt="" class="w-100" height="600px">
            </div>
        </div>
    </section>

    <section class="slogans">
        <div class="row">
            <div class="col">
                <h4 class="d-flex align-items-center gap-2">
                    <i class="fa-solid fa-truck"></i>
                    <div>Miễn phí vận chuyển</div>
                </h4>
            </div>
            <div class="col">
                <h4 class="d-flex align-items-center gap-2">
                    <i class="fa-solid fa-star"></i>
                    <div>Tích điểm khách hàng thân thiết</div>
                </h4>
            </div>
            <div class="col">
                <h4 class="d-flex align-items-center gap-2">
                    <i class="fa-solid fa-book"></i>
                    <div>Luôn cập nhật các đầu sách mới</div>
                </h4>
            </div>
        </div>
    </section>

    <section class="selected my-5">
        <h3>Sự lựa chọn dành cho bạn</h3>
        <div class="row row-cols-xl-4 row-cols-md-2 row-cols-1">
            <c:forEach items="${selectedBooks}" var="book">
                <div class="col">
                    <div class="shadow">
                        <div class="book-image">
                            <img src="${book.getImg()}" alt="Book Image" class="w-100" height="300px">
                        </div>
                        <div class="book-info p-3">
                            <h4>${book.getTitle()}</h4>
                            <p>${book.getAuthor()}</p>
                            <p><strong>${book.getPrice()}đ</strong></p>
                            <a href="/product/${book.getId()}" class="text-decoration-none bg-main px-3 py-2 text-center">Xem chi tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>

    <section class="must-buy mt-3">
        <h3>Nhất định phải mua</h3>
        <div class="row row-cols-xl-4 row-cols-md-2 row-cols-1">
            <c:forEach items="${mustBuyBooks}" var="book">
                <div class="col">
                    <div class="shadow">
                        <div class="book-image">
                            <img src="${book.getImg()}" alt="Book Image" class="w-100" height="300px">
                        </div>
                        <div class="book-info p-3">
                            <h4>${book.getTitle()}</h4>
                            <p>${book.getAuthor()}</p>
                            <p><strong>${book.getPrice()}đ</strong></p>
                            <a href="/product/${book.getId()}" class="text-decoration-none bg-main px-3 py-2 text-center">Xem chi tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>

    <section class="contact my-5">
        <h2>Liên hệ với chúng tôi</h2>
        <c:if test="${not empty pageContext.response.getHeader('sendMailStatus')}">
            <div class="alert alert-success mt-3" role="alert">
                Email sent successfully!
            </div>
        </c:if>
        <div class="row">
            <div class="col">
                <form method="POST">
                    <div class="mb-3">
                        <label for="emailInput" class="form-label">Email</label>
                        <input type="email" class="form-control" id="emailInput" name="customerEmail" placeholder="Nhập email của bạn" required>
                    </div>
                    <div class="mb-3">
                        <label for="messageTextarea" class="form-label">Nội dung</label>
                        <textarea class="form-control" id="messageTextarea" rows="5" name="content" placeholder="Nhập nội dung" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Gửi</button>
                </form>
            </div>
            <div class="col">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.1234567890123!2d106.12345678901234!3d10.123456789012345!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMTPCsDU2JzEwLjQiTiAxMDbCsDAwJzUwLjAiRQ!5e0!3m2!1sen!2sus!4v1629876543210!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </div>
        </div>
    </section>
</div>
