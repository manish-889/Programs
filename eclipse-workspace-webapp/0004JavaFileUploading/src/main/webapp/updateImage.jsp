
<%@page import="com.model.ImageModel"%>
<%@page import="com.util.DbConncter"%>
<%@page import="com.dao.UploadingDao"%>
<%@page import="java.util.HashMap"%>
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

				<h5 class="text-center text-primary">Modification Page</h5>

				<form action="update" method="get">
					<%
					int cid = Integer.parseInt(request.getParameter("id"));
					Connection con = DbConncter.getCon();
					UploadingDao dao = new UploadingDao(con);
					ImageModel im = dao.getImageById(cid);
					%>

					<input type="hidden" class="form-control" id="id" value="<%=cid%>"
						name="id">

					<div class="mb-2 mt-3">
						<label class="form-label">Name</label> <input type="text"
							class="form-control" id="name" name="name"
							value="<%=im.getName()%>" placeholder="Manish Giri">
					</div>

					<div class="mb-2 mt-3">
						<label>Image</label> <input type="file" name="upFile"
							value="<%=im.getFilename() %>" class="form-control">
					</div>


					<div class="d-flex justify-content-center">
						<input type="submit" value="Update" class="btn btn-success"
							id="submit">
					</div>



				</form>

			</div>

		</div>
	</div>
</body>
</html>