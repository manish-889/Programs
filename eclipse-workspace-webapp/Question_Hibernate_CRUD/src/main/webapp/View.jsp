<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First</th>
				<th scope="col">email</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="e">
			<tr>
				<th scope="row">${e.getId()}</th>
				<td>${e.getUname()}</td>
				<td>${ e.getEmail()}</td>
				<td><a href="update?id=${e.getId() }&action=delete">Delete</a></td>
				<td><a href="update?id=${e.getId() }&action=update">Update</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>