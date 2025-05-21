<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-6-md offset-md-3">
				<div class="card">
					<div class="card-body">
						
						<h1 class="text-center mb-3">Update Product Detail</h1>
					
						<form action="${pageContext.request.contextPath }/handle-product" method="post">
						
							<input type="hidden" value="${product.id }" name="id" />
						
							<div class="form-group">
									<label for="name">Product Name</label><input type="text" value="${product.name }"
									 class="form-control" id="name" name="name" placeholder="Enter Product Name Here"/>
							</div>
							
							<div class="form-group">
									 <label for="description">Product Description</label><textarea rows="5" class="form-control" 
									 name="description"  id="description" placeholder="Enter Product Description">${product.description }</textarea>
							</div>
							
							<div class="form-group">
								<label for="price">Product Price</label><input type="text" class="form-control" name="price" value="${product.price }"
								 placeholder="Enter Product Price" />
							</div>
					
							<div class="container text-center">
								<a href="${pageContext.request.contextPath }/" class="btn btn-outline-warning">
								 Back </a>
								<button class="btn btn-outline-primary" type="submit">Update</button>
							</div>
					
						</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
