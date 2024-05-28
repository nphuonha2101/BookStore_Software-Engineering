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
        <c:if test="${not empty message}">
            <div class="alert alert-${alertType} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${not empty sessionScope.loginUser}">
                <div class="row">
                    <div class="col-md-12">
                        <c:choose>
                            <c:when test="${not empty cartDetails}">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Sách</th>
                                            <th>Đơn giá</th>
                                            <th>Số lượng</th>
                                            <th>Tổng</th>
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
                                                    <form action="/cart/action" method="POST">
                                                        <input type="hidden" name="_method" value="DELETE">
                                                        <input type="hidden" name="bookId" value="${cartDetail.getBookId()}">
                                                        <button type="submit" class="btn btn-danger">Remove</button>
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row">
                                    <div class="col-md-12">
                                        <h3 class="text-danger">Total: <fmt:formatNumber
                                            value="${total}"
                                            type="currency"
                                            currencySymbol="₫"
                                            currencyCode="VND"/></h3>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <form action="/checkout/cash" method="POST">
                                            <input type="hidden" name="total" value="${total}">
                                            <button type="submit" class="btn btn-primary">Thanh toán bằng tiền mặt</button>
                                        </form>

                                        <form action="/checkout/vnpay" method="POST" class="mt-3">
                                            <input type="hidden" name="total" value="${total}">
                                            <button type="submit" class="btn btn-warning">Thanh toán với VNPAY</button>
                                        </form>
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
