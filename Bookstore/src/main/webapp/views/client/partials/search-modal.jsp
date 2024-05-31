<%--
  Created by IntelliJ IDEA.
  User: nphuo
  Date: 5/30/2024
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="modal fade" id="searchModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <form id="searchModalForm" class="w-100 mx-2">
                    <div class="form-group d-lg-block d-none">
                        <input class="form-control" type="text" name="q" id="searchInput"
                               placeholder="Tìm kiếm các loại sách...">
                        <button class="need-absolute" id="searchButton"><i class="fas fa-search"></i></button>
                    </div>
                </form>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h6 class="my-3" id="staticBackdropLabel">Kết quả tìm kiếm cho: <span id="searchKeyWord"></span></h6>
                <div class="container-fluid" id="searchDataContainer"></div>
            </div>
            <div class="modal-footer">
                <button id="showMoreSearchResult" class="btn btn-primary">Xem thêm kết quả</button>
            </div>
        </div>
    </div>
</div>
<script defer type="text/javascript" src="${pageContext.request.contextPath}/public/js/handleSearch.js"></script>