<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Image Uploading</h3>
					
						<form action="uplaod" method="post" enctype="multipart/form-data">
						
							<!--label for Name  -->
							<div class="mb-3">
								<label>Name</label> <input type="tel" name="uname"
									class="form-control">
							</div>
							
							<!--label for Image  -->
							<div class="mb-3">
								<label>Image</label> <input type="file" name="file"
									class="form-control">
							</div>
							
							<!-- button for upload -->
							<div class="text-center">
								<button class="btn btn-primary">Upload</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>	

</body>
</html>