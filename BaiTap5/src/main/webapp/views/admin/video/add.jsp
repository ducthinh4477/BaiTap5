<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Add Video</h2>

<form method="post">

Title:<br>
<input name="title"><br><br>

Description:<br>
<textarea name="description"></textarea><br><br>

Poster URL:<br>
<input name="poster"><br><br>

Category:<br>
<select name="cateId">
    <c:forEach items="${categories}" var="c">
        <option value="${c.id}">${c.name}</option>
    </c:forEach>
</select><br><br>

<button type="submit">Save</button>

</form>
