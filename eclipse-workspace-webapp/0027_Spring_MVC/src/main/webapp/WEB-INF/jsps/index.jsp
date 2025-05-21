<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>\
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
 

	<f:form action="addUser" method="post" modelAttribute="user">
		<f:hidden path="id"/>
		<f:label path="name">UserName</f:label>
		<f:input path="name" />
		<f:label path="email">Email</f:label>
		<f:input path="email" />

		<input type="submit" />
	</f:form>


	<table class="table table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">UserName</th>
				<th scope="col">Email</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${view }" var="e">
			<tr>
				<th scope="row">${e.getId() }</th>
				<td>${e.getName() }</td>
				<td>${e.getEmail() }</td>
				<td><a href="delete?did=${e.getId() }" class="btn btn-danger">DELETE</a></td>
				<td><a href="edit?uid=${e.getId() }" class="btn btn-primary">UPDATE</a></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>

</body>
</html>