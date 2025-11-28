<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>User List</h2>

<a href="/admin/users/add">Add User</a>
<br><br>

<table border="1" cellpadding="8">
<tr>
    <th>ID</th><th>Username</th><th>Fullname</th><th>Email</th><th>Actions</th>
</tr>

<c:forEach items="${items}" var="u">
<tr>
    <td>${u.id}</td>
    <td>${u.username}</td>
    <td>${u.fullname}</td>
    <td>${u.email}</td>
    <td>
        <a href="/admin/users/edit/${u.id}">Edit</a> |
        <a href="/admin/users/delete/${u.id}" onclick="return confirm('Delete?')">Delete</a>
    </td>
</tr>
</c:forEach>
</table>
