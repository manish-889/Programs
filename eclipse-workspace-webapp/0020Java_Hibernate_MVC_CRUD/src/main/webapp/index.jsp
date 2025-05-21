<!doctype html>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<title>Registration Page</title>
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="col-7 mx-auto">
				<div class="card mt-3">
					<div class="card-body">
						<h2 class="text-center text-primary">Registration Page</h2>
						<span class="text-success">${doneMsg }</span>
						<form action="reg" method="post" enctype="multipart/form-data">
							<input type="hidden" id="id" name="id" value="${user.getId() }" />
							<div class="form-group">
								<label for="uname">Username</label> <input type="text"
									class="form-control" id="uname" name="uname"
									value="${user.getUname() }" placeholder="Enter Name">
							</div>
							<div class="form-group">
								<label for="email">Email address</label> <input type="email"
									value="${user.getEmail() }" class="form-control" id="email"
									name="email" placeholder="Enter Email">
							</div>
							<div class="form-group">
								<label for="phone">Phone</label> <input type="text"
									value="${user.getPhone() }" class="form-control" id="phone"
									name="phone" placeholder="Enter Phone Number">
							</div>
							<div class="form-group">
								<label for="gender">Gender :- &nbsp</label>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="gender_male"
										<c:if test="${user.getGender() == 'male' }">checked</c:if>
										name="gender" value="male"> <label
										class="form-check-label" for="gender_male">Male</label>
								</div>
								<div class="form-check form-check-inline">
									<input type="radio" class="form-check-input" id="gender_female"
										<c:if test="${user.getGender() == 'female' }">checked</c:if>
										name="gender" value="female"> <label
										class="form-check-label" for="gender_female">Female</label>
								</div>
							</div>

							<div class="form-group">
								<label for="country">Country</label> <select
									class="form-control" id="country" name="country">
									<option value="#">----SELECT COUNTRY-----</option>
									<option value="India"
										<c:if test="${user.getCountry() == 'India' }">selected</c:if>>India</option>
									<option value="Canada"
										<c:if test="${user.getCountry() == 'Canada' }">selected</c:if>>Canada</option>
									<option value="Farnce"
										<c:if test="${user.getCountry() == 'France' }">selected</c:if>>France</option>
									<option value="Germany"
										<c:if test="${user.getCountry() == 'Germany' }">selected</c:if>>Germany</option>
								</select>
							</div>

							<div class="form-group">
								<label for="language">Language:</label>
								<div class="col-sm-10">
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											<c:if test="${fn:contains(user.getLanuguage(),'english') }">checked</c:if>
											id="gridCheck1" value="english" name="lang"> <label
											class="form-check-label" for="gridCheck1">English</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											<c:if test="${fn:contains(user.getLanuguage(),'hindi') }">checked</c:if>
											id="gridCheck2" value="hindi" name="lang"> <label
											class="form-check-label" for="gridCheck2">Hindi</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											<c:if test="${fn:contains(user.getLanuguage(),'punjabi') }">checked</c:if>
											id="gridCheck3" value="punjabi" name="lang"> <label
											class="form-check-label" for="gridCheck3">Punjabi</label>
									</div>
								</div>
							</div>

							<div class="form-group row">
								<label for="fileUpload" class="col-sm-2 col-form-label">File
									:-</label>
								<div class="col-sm-10">
									<input type="file" class="form-control" id="fileUpload"
										value="${user.getImage() }" name="file" required>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">SUBMIT</button>
									<a href="display" class="btn btn-warning">View Users</a>
								</div>
							</div>

						</form>
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