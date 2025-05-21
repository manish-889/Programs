<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Student Name is ${student.name }</h1>
	<h1>Student Id is ${stduent.id }</h1>
	<h1>Student DOB is ${student.dob }</h1>
	<h1>Courses is ${stuednt.courses }</h1>
	<h1>Student gender is ${student.gender }</h1>
	<h1>Student type is ${student.type }</h1>
	<hr>
	<h1>Address street is ${student.address.street }</h1>
	<h1>Address city is ${student.address.city }</h1>

</body>
</html>