<%--
  Created by IntelliJ IDEA.
  User: nphuo
  Date: 5/26/2024
  Time: 6:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/products.css">
</head>
<div id="productsPage">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1 class="text-center">Danh sách sản phẩm</h1>
            </div>
        </div>
        <div class="row justify-content-between">
            <c:forEach var="product" items="${products}">
                <c:set var="firstCategory" value="${product.categories[0]}"/>
                <div class="card h-100 col-lg-2 col-md-5 col-sm-11 my-3 mx-2 product-card">
                    <div class="title-tag">
                        <span class="badge bg-primary">${firstCategory.name}</span>
                    </div>
                    <img src="${pageContext.request.contextPath}/R.jpg" class="card-img-top" alt="Bìa sách">
                    <div class="card-body">
                        <h5 class="card-title">${product.title}</h5>
                        <dl>
                            <dt>Tác giả:</dt>
                            <dd>${product.author}</dd>
                            <dt>Giá:</dt>
                            <dd>
                                <fmt:formatNumber
                                        value="${product.price}"
                                        type="currency"
                                        currencySymbol="₫"
                                        currencyCode="VND"
                                />
                            </dd>
                            <dt>Mô tả:</dt>
                            <dd>${product.summary}</dd>
                        </dl>

                        <button class="btn btn-primary card-button">Xem chi tiết</button>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-12 d-flex justify-content-center my-4">
                <nav>
                    <ul class="pagination justify-content-end">
                        <c:choose>
                            <c:when test="${currentPage == 1}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Trang trước</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link" href="/products?page=${currentPage - 1}">Trang trước</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                <a class="page-link" href="/products?page=${i}">${i}</a>
                            </li>
                        </c:forEach>

                        <c:choose>
                            <c:when test="${currentPage == totalPages}">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Trang sau</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link" href="/products?page=${currentPage + 1}">Trang sau</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
