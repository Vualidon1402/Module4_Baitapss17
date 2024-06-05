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
<h1>Chỉnh sửa sản phẩm</h1>
<a href="/" class="btn btn-danger">Quay lại</a>
<form action="/edit" method="post" >
  <div class="mb-3">
    <label for="category_id" class="form-label">Category Id</label>
    <input type="text" class="form-control" value="${category.category_id}" id="category_id" name="category_id" readonly>
  </div>
  <div class="mb-3">
    <label for="category_name" class="form-label">Category Name</label>
    <input type="text" class="form-control" value="${category.category_name}" id="category_name" name="category_name" placeholder="product name...">
  </div>
  <div class="mb-3">
    <label for="category_status" class="form-label">Category Status</label>
    <input type="text" class="form-control" value="${category.category_status}" name="category_status" id="category_status">
  </div>

  <input type="submit"  class="btn btn-primary"/>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>
