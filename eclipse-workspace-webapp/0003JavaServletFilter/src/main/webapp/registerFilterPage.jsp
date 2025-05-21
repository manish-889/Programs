<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>


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

	<div class="container">

		<div class="row d-flex justify-content-center">

			<!-- For Form -->
			<div class="col-4 card p-4">

				<h5 class="text-center text-success">Registration Form</h5>

				<form action="register" method="post">

					<div class="mb-2 mt-3">
						<label class="form-label">User name</label> <input type="text"
							class="form-control" id="uname" name="uname" placeholder="" value="<% if(request.getParameter("uname")!=null) {%><%=request.getParameter("uname")%><%} %>"
							onkeyup="validateForm()"> <span class="text-danger"
							id="nameErr">${nameErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" name="email" value="<% if(request.getParameter("email")!=null) {%><%=request.getParameter("email")%><%} %>"
							placeholder="name@gmail.com" onkeyup="validateForm()"> <span
							class="text-danger" id="emailErr">${emailErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Contact</label> <input type="number"
							class="form-control" id="contact" name="contact" placeholder="" value="<% if(request.getParameter("contact")!=null) {%><%=request.getParameter("contact")%><%} %>"
							onkeyup="validateForm()"> <span class="text-danger"
							id="contactErr">${contactErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder="" value="<% if(request.getParameter("password")!=null) {%><%=request.getParameter("password")%><%} %>"
							onkeyup="validateForm()"> <span class="text-danger"
							id="passwordErr">${passwordErr}</span>
					</div>

					<div class="mb-4">
						<label class="form-label">Confirm password</label> <input
							type="password" class="form-control" id="cpassword" value="<% if(request.getParameter("cpassword")!=null) {%><%=request.getParameter("cpassword")%><%} %>"
							name="cpassword" placeholder="" onkeyup="validateForm()">
						<span class="text-danger" id="cpasswordErr">${cpasswordErr}</span>
					</div>

					<div class="d-flex justify-content-center">
						<input type="submit" value="Register Now" class="btn btn-success"
							id="submit"> <!-- <input type="reset" value="Reset"
							class="btn btn-primary ms-3"> --><!-- <a class="btn btn-warning ms-3" href="userlist">View Users</a> -->
					</div>
				
				</form>

			</div>



			<!-- For table  -->

		</div>

	</div>

</body>
</html>