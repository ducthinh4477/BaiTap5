<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Edit User</h2>

<form method="post">

Username:<br>
<input name="username" value="${user.username}"><br><br>

Password:<br>
<input name="password" value="${user.password}"><br><br>

Full name:<br>
<input name="fullname" value="${user.fullname}"><br><br>

Email:<br>
<input name="email" value="${user.email}"><br><br>

<button type="submit">Update</button>
</form>
