
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


</head>
<body>
		<%
		
		HashMap<String, Object> dataMap = (HashMap<String, Object>) request.getAttribute("data");
		%>
	<div class="container">

		<div class="row mt-5 d-flex justify-content-center">

			<!-- For Form -->
			<div class="col-5 card p-4">

				<h5 class="text-center text-primary">Modification Page</h5>

				<form action="update" method="post">
				
					<input type="hidden" class="form-control" id="id" name="id" value="<%=dataMap.get("id").toString()%>">

					<div class="mb-2 mt-3">
						<label class="form-label">User name</label> <input type="text"
							class="form-control" id="name" name="name"
							value="<%=dataMap.get("name").toString()  %>"
							placeholder="Manish Giri"> <span
							class="text-danger" id="errUname"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" name="email"
							value="<%=dataMap.get("email")  %>"
							placeholder="name@gmail.com" > <span
							class="text-danger" id="errEmail"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Contact</label> <input type="number"
						value="<%=dataMap.get("contact") %>"
							class="form-control" id="contact" name="contact" placeholder=""
							> <span class="text-danger"
							id="errContact"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Password</label> <input type="password"
						value="<%=dataMap.get("password")  %>"
							class="form-control" id="password" name="password" placeholder=""
							> <span class="text-danger"
							id="errPassword"></span>
					</div>

					

					<div class="d-flex justify-content-center">
						<input type="submit" value="Update" class="btn btn-success"
							id="submit" > 
					</div>

				</form>

			</div>

			
			
		</div>

	</div>
</body>
</html>