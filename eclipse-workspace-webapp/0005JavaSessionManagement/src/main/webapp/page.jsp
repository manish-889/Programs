<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String data = (String)session.getAttribute("data");

if(data == null){
	response.sendRedirect("home.jsp");
}
%>

		<h3>This is example of session</h3>
		
		<a class="btn btn-primary">Logout</a>
</body>
</html>