<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
			<div class="col-4 card">

				<h1>Image Updating</h1>

				<form action="update" method="post" enctype="multipart/form-data">
					
					<input type="hidden" name="id" value="${imgData.getId() }">
					
					<div class="form-group mt-4">
						<label for="uname">Enter Name</label> <input type="text"
							name="uname" id="uname" placeholder="Enter name"
							class="form-control" value="${imgData.getName()}" required>
					</div>

					<div class="form-group mt-2">
						<label for="img">Add Image</label> <input type="file" name="file"
							id="img" class="form-control">
					</div>

					<div class="form-group mt-2" align="center">
						<input type="submit" value="Update" class="btn btn-success">
					</div>
				</form>

			</div>



		</div>





	</div>


</body>
</html>