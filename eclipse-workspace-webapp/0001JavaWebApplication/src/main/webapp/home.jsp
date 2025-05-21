
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

<script type="text/javascript">
	function validateForm() {

		var uname = document.getElementById("uname").value;
		var email = document.getElementById("email").value;
		var contact = document.getElementById("contact").value;
		var password = document.getElementById("password").value;
		var cpassword = document.getElementById("cpassword").value;

		var errUname = document.getElementById("errUname");
		var errEmail = document.getElementById("errEmail");
		var errContact = document.getElementById("errContact");
		var errPassword = document.getElementById("errPassword");
		var errCpassword = document.getElementById("errCpassword");

		var btnSubmit = document.getElementById("submit");

		// user field validation
		var nameReg = /^[A-Za-z\s]+$/;

		if (uname == null || uname == '') {
			errUname.innerHTML = 'User name should not be blank';
			btnSubmit.disabled = true;
		} else if (!nameReg.test(uname)) {
			errUname.innerHTML = 'User name contains characters only';
			btnSubmit.disabled = true;
		} else {
			errUname.innerHTML = '';
			btnSubmit.disabled = false;
		}

		// Valdiation for email

		var emailReg = /^[A-Za-z0-9-_.]+@[A-Za-z]+\.[A-Za-z]{2,4}$/;
		if (email == null || email == "") {
			errEmail.innerHTML = "Email should not be blank";
			btnSubmit.disabled = true;
		} else if (!emailReg.test(email)) {
			errEmail.innerHTML = "Invalid email address";
			btnSubmit.disabled = true;
		} else {
			errEmail.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// Valdiation for contact
		var contactReg = /^[0-9]+$/;
		if (contact == null || contact == "") {
			errContact.innerHTML = "Contact should not be blank";
			btnSubmit.disabled = true;
		} else if (!contactReg.test(contact)) {
			errContact.innerHTML = "Contact should be of 10 digits";
			btnSubmit.disabled = true;
		} else {
			errContact.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// Validation for password
		var passwordReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#?.])(?!.*\\s)[A-Za-z\d@#?.]{8,20}$/;
		if (password == null || password == "") {
			errPassword.innerHTML = "Password should not be blank";
			btnSubmit.disabled = true;
		} else if (!passwordReg.test(password)) {
			errPassword.innerHTML = "Must contains atleast one uppercase, lowercase, digit and length up to 16 characters";
			btnSubmit.disabled = true;
		} else {
			errPassword.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// Validation for confrim password
		if (cpassword == null || cpassword == "") {
			errCpassword.innerHTML = "Please confirm your password";
			btnSubmit.disabled = true;
		} else if (cpassword != password) {
			errCpassword.innerHTML = "Password mismatch";
			btnSubmit.disabled = true;
		} else {
			errCpassword.innerHTML = "";
			btnSubmit.disabled = false;
		}

	}
</script>

</head>
<body>

	<div class="container">

		<div class="row mt-5">

			<!-- For Form -->
			<div class="col-4 card p-4">

				<h5 class="text-center text-primary">Registration Form</h5>

				<form action="RegisterController" method="post">

					<div class="mb-2 mt-3">
						<label class="form-label">User name</label> <input type="text"
							class="form-control" id="uname" name="uname"
							placeholder="Manish Giri" onkeyup="validateForm()"> <span
							class="text-danger" id="errUname"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="name@gmail.com" onkeyup="validateForm()"> <span
							class="text-danger" id="errEmail"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Contact</label> <input type="number"
							class="form-control" id="contact" name="contact" placeholder=""
							onkeyup="validateForm()"> <span class="text-danger"
							id="errContact"></span>
					</div>

					<div class="mb-2">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" id="password" name="password" placeholder=""
							onkeyup="validateForm()"> <span class="text-danger"
							id="errPassword"></span>
					</div>

					<div class="mb-4">
						<label class="form-label">Confirm password</label> <input
							type="password" class="form-control" id="cpassword"
							name="cpassword" placeholder="" onkeyup="validateForm()">
						<span class="text-danger" id="errCpassword"></span>
					</div>

					<div class="d-flex justify-content-center">
						<input type="submit" value="Submit" class="btn btn-success"
							id="submit" disabled> <input type="reset" value="Reset"
							class="btn btn-primary ms-3">
					</div>

				</form>

			</div>

			<div class="col-1"></div>

			<!-- For table  -->
			<div class="col-7 card p-4">
				<h5 class="text-center text-primary">User Details</h5>

				<div class="md-2 mt-3">

					<%
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletPage", "root", "manishgiri");
					
					String sql = "SELECT * FROM user";

					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					%>
					<table class="table table-dark table-striped">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Contact</th>
								<th scope="col" colspan="2">Edit</th>
							</tr>
						</thead>
						<tbody>
							<%
								while(rs.next()){
							%>
							<tr>
								<th scope="row"><%=rs.getInt("id") %></th>
								<td><%=rs.getString("name") %></td>
								<td><%=rs.getString("email") %></td>
								<td><%=rs.getString("contact") %></td>
								<td><a class="btn btn-danger" href="delete?id=<%=rs.getInt("id")%>">Delete</a></td>
								<td><a class="btn btn-primary" href="edit?id=<%=rs.getInt("id")%>">Update</a></td>
							</tr>
							<%
							} 
							%>
						</tbody>
					</table>
				</div>
			</div>

		</div>

	</div>
</body>
</html>