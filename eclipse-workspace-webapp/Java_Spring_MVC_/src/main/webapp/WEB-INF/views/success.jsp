<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>

	<h1>Hello ${user.uname} ..</h1>
	<h1>Your email is ${user.email}</h1>
	<h1>and Your password is ${user.pass}</h1>
	<hr>
	<h1 class="text-center">${Header }</h1>
	<p class="text-center">${Desc }</p>
</body>
</html>