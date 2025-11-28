<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Category List</h2>

<a href="/admin/categories/add">➕ Add Category</a>
<br><br>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Images</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${items}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.images}</td>
            <td>
                <a href="/admin/categories/edit/${c.id}">Edit</a>
                |
                <a href="/admin/categories/delete/${c.id}"
                   onclick="return confirm('Delete?')">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
