<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DbConncter"%>
<%@page import="java.sql.Connection"%>
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
						
						<!--for passing message that image is uploaded  -->
						<%
						String msg = (String) session.getAttribute("msg");
						if (msg != null) {
						%>
						<h3 class="text-center"><%=msg%></h3>
						<%
						session.removeAttribute("msg");
						}
						%>
						<form action="upload" method="post" enctype="multipart/form-data">
						
							<!--label for Name  -->
							<div class="mb-3">
								<label>Name</label> <input type="tel" name="name"
									class="form-control">
							</div>
							
							<!--label for Image  -->
							<div class="mb-3">
								<label>Image</label> <input type="file" name="upFile"
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
		
		<!--table for showing image and there name & for modification also  -->
		<table class="table  mt-4">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col" colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				
				<!--retivering all the records from database into table  -->
				<%
				Connection con = DbConncter.getCon();
				PreparedStatement ps = con.prepareStatement("select * from imgUpload");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
				%>
				<tr>
				<!--Setting all the data into row  -->
					<th scope="row"><img alt=""
						src="img/<%=rs.getString("filename")%>" width="70px" height="50px"></th>
					<td><%=rs.getString("name")%></td>
					<td><a class="btn btn-danger" href="delete?id=<%=rs.getInt("id")%>">Delete</a></td>
					<td><a class="btn btn-primary" href="updateImage.jsp?id=<%=rs.getInt("id")%>">Update</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>



</body>
</html>