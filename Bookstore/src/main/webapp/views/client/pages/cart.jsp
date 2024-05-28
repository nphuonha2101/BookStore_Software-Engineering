<%-- 
    Document   : cart
    Created on : May 28, 2024, 8:38:15 PM
    Author     : thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="cartPage">
    <div class="container">
        <c:choose>
            <c:when test="${not empty sessionScope.loginUser}">
                <div class="row">
                    <div class="col-md-12">
                        <c:choose>
                            <c:when test="${not empty cartDetails}">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Product</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${cartDetails}" var="cartDetail">
                                            <tr>
                                                <td>${cartDetail.getBook().getTitle()}</td>
                                                <td><fmt:formatNumber
                                                    value="${cartDetail.getPrice()}"
                                                    type="currency"
                                                    currencySymbol="₫"
                                                    currencyCode="VND"/></td>
                                                <td>${cartDetail.getQuantity()}</td>
                                                <td>
                                                    <fmt:formatNumber
                                                    value="${cartDetail.getPrice() * cartDetail.getQuantity()}"
                                                    type="currency"
                                                    currencySymbol="₫"
                                                    currencyCode="VND"/>
                                                </td>
                                                <td>
                                                    <a href="<c:url value='/cart/remove/${cartItem.getBookId()}'/>" class="btn btn-danger">Remove</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-md-12">
                                        <h3>Total: <fmt:formatNumber
                                            value="${total}"
                                            type="currency"
                                            currencySymbol="₫"
                                            currencyCode="VND"/></h3>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <a href="<c:url value='/checkout'/>" class="btn btn-primary">Thanh toán</a>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <p>Giỏ hàng trống <a href="/products">Mua hàng tại đây</a></p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h3>Vui lòng đăng nhập để xem giỏ hàng của bạn.</h3>
                    <a href="<c:url value='/login'/>" class="btn btn-primary">Đăng nhập</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
