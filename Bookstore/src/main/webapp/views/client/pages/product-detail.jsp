<%--
  Created by IntelliJ IDEA.
  User: nphuo
  Date: 5/27/2024
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/products.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/product-detail.css">
</head>
<div id="productDetail">
    <div class="container">
        <c:if test="${not empty message}">
            <div class="alert alert-${alertType} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <div class="row">
            <div class="row justify-content-center">
                <div class="col-4 d-flex justify-content-end">
                    <div class="book-img_container-lg pe-5">
                        <img src="${pageContext.request.contextPath}/R.jpg" alt="Book img"/>
                    </div>

                </div>

                <div class="col-5">
                    <h3 class="mb-4">${book.title}</h3>
                    <p>${book.author}</p>
                    <h4>
                        <fmt:formatNumber
                                value="${book.price}"
                                type="currency"
                                currencySymbol="₫"
                                currencyCode="VND"
                        />
                    </h4>
                    <p class="my-5">${book.summary}</p>
                    <div class="d-flex align-items-center gap-3">
                        <button class="btn btn-primary">Mua ngay</button>
                        <form action="/cart/action" method="POST">
                            <input type="hidden" name="bookId" value="${book.getId()}">
                            <input type="hidden" name="price" value="${book.getPrice()}">
                            <input type="hidden" name="quantity" value="1">
                            <button type="submit" class="btn btn-warning">Thêm vào giỏ hàng</button>
                        </form>
                    </div>

                    <hr>

                    <div class="row">
                        <div class="col-6">
                            <dl>
                                <dt>ISBN:</dt>
                                <dd>${book.isbn}</dd>
                            </dl>
                        </div>

                        <div class="col-6">
                            <dl>
                                <dt>
                                    Thể loại
                                </dt>
                                <dd>
                                    <c:forEach var="category" items="${book.categories}">
                                        <span class="me-3 badge bg-primary">${category.name}</span>
                                    </c:forEach>
                                </dd>

                            </dl>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-12">
                <h2>Bạn có thể thích</h2>
            </div>
            <div id="book-slider" class="col-12 mb-4 p-5 splide">
                <div class="splide__track">
                    <ul class="splide__list">
                        <c:forEach var="book" items="${books}">
                            <c:set var="firstCategory" value="${book.categories[0]}"/>
                            <li class="splide__slide p-2">
                                <div class="card h-100 w-100 product-card">
                                    <div class="category-tag">
                                        <span class="badge bg-primary">${firstCategory.name}</span>
                                    </div>
                                    <img src="${book.img}" class="card-img-top"
                                         alt="Bìa sách">
                                    <div class="card-body">
                                        <h5 class="card-title">${book.title}</h5>
                                        <dl>
                                            <dt>Tác giả:</dt>
                                            <dd>${book.author}</dd>
                                            <dt>Giá:</dt>
                                            <dd>
                                                <fmt:formatNumber
                                                        value="${book.price}"
                                                        type="currency"
                                                        currencySymbol="₫"
                                                        currencyCode="VND"
                                                />
                                            </dd>
                                            <dt>Mô tả:</dt>
                                            <dd>${book.summary}</dd>
                                        </dl>

                                        <a class="btn btn-primary card-button"
                                           href="${pageContext.request.contextPath}/product/${book.id}">Xem
                                            chi tiết</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/public/js/product-detail.js"></script>
