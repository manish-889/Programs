<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="register" method="post">
	<input type="text" value="${user.getId() }" name="id">
		<input type="text" name="uname" value="${user.getUname() }"/>
		<input type="email" name="email" value="${user.getEmail() }">
		<button>Submit</button>
		<a href="display">View</a>
	</form>

</body>
</html>