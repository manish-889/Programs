<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>This is home page</h1>
	<h1>Called by home controller</h1>
	
	<%
	/*String name =(String) request.getAttribute("name");
	int id = (int) request.getAttribute("number");
	List<String> list = (List<String>) request.getAttribute("l");*/
	%>
	
	<%-- <h1><%=name %> </h1>
	<h1> <%=id %> </h1> --%>
	
	<%
	/* for(String s : list){ */
	%>
	
	<%-- <h1> <%=s %> </h1> --%>

	
	
	<c:forEach var="item" items="${name}">
		<h1>${item }</h1>
	</c:forEach>

</body>
</html>