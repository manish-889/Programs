
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

		<div class="row mt-5 d-flex justify-content-center">

			<!-- For Form -->
			<div class="col-5 card p-4">

				<h5 class="text-center text-primary">Registration Form</h5>

				<form action="reg" method="post">

					<div class="mb-2 mt-3">
						<label class="form-label">User name</label> <input type="text"
							class="form-control" id="name" name="uname" value="<%if(request.getParameter("uname")!=null){ %><%=request.getParameter("uname") %><%} %>"
							placeholder="Manish Giri"> <span class="text-danger"
							id="nameErr">${nameErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Email Address</label> <input
							type="text" class="form-control" id="email" name="email" value="<%if(request.getParameter("email")!=null){ %><%=request.getParameter("email") %><%} %>"
							placeholder="name@gmail.com"> <span class="text-danger"
							id="nameErr">${emailErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Password</label> <input type="password" value="<%if(request.getParameter("pass")!=null){ %><%=request.getParameter("pass") %><%} %>"
							class="form-control" id="password" name="pass"> <span
							class="text-danger" id="nameErr">${passErr}</span>
					</div>

					<div class="mb-2">
						<label class="form-label">Confirm Password</label> <input
							type="password" class="form-control" id="password" name="cpass"value="<%if(request.getParameter("cpass")!=null){ %><%=request.getParameter("cpass") %><%} %>">
						<span class="text-danger" id="nameErr">${cpassErr}</span>
					</div>

					<div class="d-flex justify-content-center">
						<input type="submit" value="Submit" class="btn btn-success"
							id="submit"> <input type="reset" value="Reset"
							class="btn btn-primary ms-3">
					</div>

				</form>

			</div>

		</div>

	</div>
</body>
</html>