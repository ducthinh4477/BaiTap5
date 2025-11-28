<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Video List</h2>

<a href="/admin/videos/add">Add Video</a>
<br><br>

<table border="1" cellpadding="8">
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Poster</th>
    <th>Category</th>
    <th>Actions</th>
</tr>

<c:forEach items="${items}" var="v">
<tr>
    <td>${v.id}</td>
    <td>${v.title}</td>
    <td><img src="${v.poster}" width="80"></td>
    <td>${v.category.name}</td>
    <td>
        <a href="/admin/videos/edit/${v.id}">Edit</a> |
        <a href="/admin/videos/delete/${v.id}" onclick="return confirm('Delete?')">Delete</a>
    </td>
</tr>
</c:forEach>

</table>
