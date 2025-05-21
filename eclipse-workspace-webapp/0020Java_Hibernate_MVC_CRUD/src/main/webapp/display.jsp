<!doctype html>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>User Details</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col mx-auto">
				<div class="card mt-3">
					<div class="card-body">
						<table class="table table-hover table-dark">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Gender</th>
									<th scope="col">Country</th>
									<th scope="col">Language</th>
									<th scope="col">Iamge</th>
									<th scope="col" colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList }" var="e">
									<tr>
										<td>${e.getId() }</td>
										<td>${e.getUname() }</td>
										<td>${e.getEmail() }</td>
										<td>${e.getPhone() }</td>
										<td>${e.getGender() }</td>
										<td>${e.getCountry() }</td>
										<td>${e.getLanuguage() }</td>
										<td><img alt="" src="img/${e.getImage() }" width="50px" height="50px"></td>
										<td><a href="edit?id=${e.getId()}&action=edit" class="btn btn-primary">Edit</a></td>
										<td><a href="edit?id=${e.getId()}&action=delete" class="btn btn-danger">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>