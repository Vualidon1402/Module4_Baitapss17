<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/22/2024
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<a href="/product" class="btn btn-danger">Quay lại</a>
<form action="/addProduct" method="post" >
    <div class="mb-3">
        <label for="category_id" class="form-label">Category Name</label>
        <select class="form-select" name="category_id" id="category_id">
            <c:forEach items="${categories}" var="category">
                <option value="${category.category_id}">${category.category_name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="product_name" class="form-label">Product Name</label>
        <input type="text" class="form-control" id="product_name" name="product_name" placeholder="product name...">
    </div>
    <div class="mb-3">
        <label for="product_price" class="form-label">Product Price</label>
        <input type="text" class="form-control" name="product_price" id="product_price" placeholder="Product Price...">
    </div>
    <div class="mb-3">
        <label for="yearCreate" class="form-label">Create Day</label>
        <input type="date" class="form-control" name="yearCreate" id="yearCreate" placeholder="Create Day...">
    </div>
    <div class="mb-3">
        <label for="totalPages" class="form-label">Total pages</label>
        <input type="text" class="form-control" name="totalPages" id="totalPages" placeholder="Total pages...">
    </div>
    <div class="mb-3">
        <label for="product_author" class="form-label">Author</label>
        <textarea class="form-control" id="product_author" name="product_author" rows="3"></textarea>
    </div>
    <div class="mb-3">
        <label for="product_status" class="form-label">Status</label>
        <textarea class="form-control" id="product_status" name="product_status" rows="3"></textarea>
    </div>
    <input type="submit"  class="btn btn-primary"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
