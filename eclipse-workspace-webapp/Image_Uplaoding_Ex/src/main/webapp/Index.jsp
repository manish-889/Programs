<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
			<div class="col-4 card mt-2 p-2">


				<h1 class="text-center text-success">Image Uploading</h1>
				<form action="upload" method="post" enctype="multipart/form-data">

					<div class="form-group mt-4">
						<label for="uname">Enter Name</label> <input type="text"
							name="uname" id="uname" placeholder="enter name"
							class="form-control">
					</div>
					<div class="form-group mt-2">
						<label for="img">Add Image</label> <input type="file" name="file"
							id="img" class="form-control">
					</div>
					<div class="form-group mt-2 " align="center">

						<input type="submit">
					</div>


				</form>

			</div>
			<div class="col-1"></div>
			<div class="col-7 card mt-2">

				<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
					url="jdbc:mysql://localhost:3306/uploadimage" user="root"
					password="manishgiri" var="dataSource" />

				<table class="table">

					<tr>

						<th>Id</th>
						<th>name</th>
						<th>Image</th>
						<th colspan="2" >Action</th>

					</tr>

					<sql:query var="data" dataSource="${dataSource }">select * from imageex</sql:query>

					<c:forEach items="${data.rows }" var="dt">
						<tr>
							<td>${dt.id }</td>
							<td>${dt.uname }</td>
							<td><img alt="" src="img/${dt.img }" width="50px" height="50px"></td>
							<td><a href="edit?uid=${dt.id }&action=delete" class="btn btn-warning">Delete</a></td>
							<td><a href="edit?uid=${dt.id }&action=update" class="btn btn-primary">Update</a></td>
						</tr>

					</c:forEach>

				</table>


			</div>

		</div>
	</div>






</body>
</html>