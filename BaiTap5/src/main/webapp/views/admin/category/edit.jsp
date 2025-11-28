<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Edit Category</h2>

<form action="/admin/categories/edit/${cate.id}" method="post">

    Name: <br>
    <input type="text" name="name" value="${cate.name}" required><br><br>

    Image URL: <br>
    <input type="text" name="images" value="${cate.images}"><br><br>

    <button type="submit">Update</button>
</form>
