<html>
<head>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12">

				<h1 class="text-center">Welcome To Product App</h1>

				<table class="table table-hover table-dark">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${product }" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td class="font-weight-bold">&#x20B9;${p.price }</td>
								<td>
									<a href="delete/${p.id }"><i class="fas fa-trash-alt text-danger" style="font-size:25px"></i></a>
									<a class="ml-2" href="update/${p.id }"><i class="fas fa-edit text-primary" style="font-size:25px"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>
				</div>

			</div>

		</div>

	</div>

</body>
</html>
