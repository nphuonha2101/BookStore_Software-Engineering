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
                <h1 class="my-5">${sectionTitle}</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <form action="${pageContext.request.contextPath}/products" method="get">
                    <div class="input-group mb-3">
                        <select class="form-select" name="category" id="category">
                            <option value="0">Tất cả</option>
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}" ${category.id == param.category ? 'selected' : ''}>
                                        ${category.name}
                                </option>
                            </c:forEach>
                        </select>

                        <input type="search" class="form-control" name="q"
                               placeholder="Tìm kiếm các loại sách..." value="${param.q}">
                    </div>
                    <button type="submit" class="btn btn-primary">Lọc</button>
                </form>
            </div>
        </div>
        <div class="row product-grid">
            <c:forEach var="product" items="${products}">
                <div class="container">
                    <c:set var="firstCategory" value="${product.categories[0]}"/>
                    <div class="card h-100 w-100 my-3 mx-2 product-card">
                        <div class="category-tag">
                            <span class="badge bg-primary">${firstCategory.name}</span>
                        </div>
                        <img src="${product.img}" class="card-img-top" alt="Bìa sách">
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

                            <a class="btn btn-primary card-button"
                               href="${pageContext.request.contextPath}/product/${product.id}">Xem chi tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <%--        Pagination--%>
        <jsp:include page="/views/client/partials/pagination.jsp"/>
        <%--        End of Pagination--%>
    </div>
</div>
