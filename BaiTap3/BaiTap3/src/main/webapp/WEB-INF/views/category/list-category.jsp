<%--
  Created by IntelliJ IDEA.
  User: dinht
  Date: 5/28/2024
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<h1>Danh mục</h1>
<a href="/product" class="btn btn-danger">Xem sản phẩm</a>
<a href="/add" class="btn btn-danger">Thêm mới danh mục</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Status</th>
        <th scope="col">List book</th>
        <th scope="col" colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${category.category_name}</td>
            <td>${category.category_status}</td>
            <td><a href="/list-product-of-category/${category.category_id }" class="btn btn-success">List Product</a></td>
            <td><a href="/edit/${category.category_id}" class="btn btn-warning">Edit</a></td>
            <td><a href="/delete/${category.category_id}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoa ko')">Delete</a></td>
        </tr>
    </c:forEach>


    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
