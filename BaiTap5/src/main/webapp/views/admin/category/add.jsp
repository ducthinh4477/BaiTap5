<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h2>Add Category</h2>

<form action="/admin/categories/add" method="post">

    Name: <br>
    <input type="text" name="name" required><br><br>

    Image URL: <br>
    <input type="text" name="images"><br><br>

    <button type="submit">Save</button>
</form>
