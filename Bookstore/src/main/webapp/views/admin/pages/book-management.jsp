<%--
  Created by IntelliJ IDEA.
  User: nphuo
  Date: 5/29/2024
  Time: 5:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/product-detail.css">
</head>

<div id="bookManagement">
    <div class="container mt-5">
        <h1>Quản lý sách</h1>
        <button class="btn btn-primary mt-3 add-button">Thêm sách</button>
        <div class="container mt-5">
            <table id="booksTable" class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Tác giả</th>
                    <th>Nhà xuất bản</th>
                    <th>Thể loại</th>
                    <th>Giá</th>
                    <th>ISBN</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Modal Edit Book -->
    <div class="modal fade" id="bookModal" tabindex="-1" aria-labelledby="bookModalLabel" aria-hidden="true">
        <div class="modal-dialog mw-75">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bookModalLabel"></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="book-form">
                        <div class="row">
                            <div class="col-4">
                                <div class="book-img_container-lg pe-5">
                                    <img src="${book.img}" id="img-preview" alt="img preview"/>
                                </div>
                            </div>
                            <div class="col-4">
                                <input type="hidden" id="id" name="id">
                                <input type="hidden" id="method" name="method" value="POST">
                                <div class="mb-3">
                                    <label for="title" class="form-label">Tên sách</label>
                                    <input type="text" class="form-control" id="title" name="title">
                                </div>
                                <div class="mb-3">
                                    <label for="author" class="form-label">Tác giả</label>
                                    <input type="text" class="form-control" id="author" name="author">
                                </div>
                                <div class="mb-3">
                                    <label for="publisher" class="form-label">Nhà xuất bản</label>
                                    <input type="text" class="form-control" id="publisher" name="publisher">
                                </div>
                                <div class="mb-3">
                                    <label for="categories" class="form-label">Thể loại</label>
                                    <select class="form-select" id="categories" name="categories" multiple>
                                        <c:forEach var="category" items="${categories}">
                                            <option class="my-2 p-2 rounded bg-primary text-white"
                                                    value="${category.id}">${category.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="price" class="form-label">Giá</label>
                                    <input type="number" class="form-control" id="price" name="price">
                                </div>
                                <div class="mb-3">
                                    <label for="img" class="form-label">Link ảnh</label>
                                    <input type="url" class="form-control" id="img" name="img">
                                </div>
                                <div class="mb-3">
                                    <label for="isbn" class="form-label">ISBN</label>
                                    <input type="text" class="form-control" id="isbn" name="isbn">
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="mb-3">
                                    <label for="summary" class="form-label">Mô tả</label>
                                    <textarea class="form-control" id="summary" name="summary"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-primary submit-form-btn">Lưu thay đổi</button>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/book-management.js"></script>