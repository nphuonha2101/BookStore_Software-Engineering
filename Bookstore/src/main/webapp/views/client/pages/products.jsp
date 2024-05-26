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
                <h1 class="text-center my-5">Danh sách sản phẩm</h1>
            </div>
        </div>
        <div class="row justify-content-between">
            <c:forEach var="product" items="${products}">
                <c:set var="firstCategory" value="${product.categories[0]}"/>
                <div class="card h-100 col-lg-2 col-md-5 col-sm-11 my-3 mx-2 product-card">
                    <div class="category-tag">
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

<%--        Pagination--%>
        <jsp:include page="/views/client/partials/pagination.jsp"/>
<%--        End of Pagination--%>
    </div>
</div>
