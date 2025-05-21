
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-4 card mt-5 offset-4">
				<h2 class="text-center mt-3 text-primary">Login</h2>
				<span>${msg}</span>
				<div class="form">
					<!-- Create form  -->
					<form action="login" method="post">
						<div class="form-group mt-2">
							<label for="uname">User name</label> <input type="text"
								class="form-control" id="uname" name="uname">
						</div>


						<div class="form-group mt-2">
							<label for="pass">Password</label> <input type="password"
								class="form-control" id="pass" name="pass">
						</div>


						<div class="d-flex justify-content-center mt-3 mb-3 ">
							<button type="submit" class="btn btn-primary ">Login</button>

						</div>
						<div class="d-flex justify-content-center mt-3 mb-3">
							<a href="Signup.jsp">New User First Register</a>
						</div>
					</form>


				</div>


			</div>


		</div>



	</div>

</body>
</html>