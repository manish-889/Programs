<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help</title>
</head>
<body>

	<%
	String name = (String)request.getAttribute("name");
	int id = (int)request.getAttribute("id");
	LocalDateTime now = (LocalDateTime)request.getAttribute("now");
	%>

	<h1><%=name %></h1>
	<h1><%=id %></h1>
	<h1><%=now %></h1>
</body>
</html>