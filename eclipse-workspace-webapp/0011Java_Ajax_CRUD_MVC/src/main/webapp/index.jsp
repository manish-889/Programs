<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<script type="text/javascript">
	
	//this for loading at the time of page loading
	$(document).ready(function(){
		load()
	})
	
	//this method for display all user on table during the page loading
	function load(){
	
		$.get("Display",{},function(res){
			var data = JSON.parse(res)
			
			var row = ""
			data.map(fo=>{
				row +="<tr><td>"+fo.id+"</td><td>"+fo.uname+"</td><td>"+fo.email+"</td><td>"+fo.phone+"</td><td><button class='btn btn-danger ml-2' onclick='deleteUser("+fo.id+")'>Delete</button><button onclick='editUser("+fo.id+")' class='btn btn-primary'>Edit</button></td></tr>"
			})
			$("#tData").html(row)
		})
	}

	//this is for insert the user into database and that time showing it on page 
	function insertUser(){
		
		var uname = $("#uname").val()
		var email = $("#email").val()
		var phone = $("#phone").val()
		
		$.post("register",{uname,email,phone},function(res){
			$("#msg").html(res)
			load()
			
			$("#uname").val("")
			$("#email").val("")
			$("#phone").val("")
			
		})
	}
	
	//this is for delete user
	function deleteUser(id){
		
		$.get("edit",{id,"action":"delete"},function(res){
			$("#delete").html(res)
			load()
		})
		
	}
	
	//this is for edit user
	function editUser(id){
		
		$.get("edit",{id,"action":"edit"},function(res){
			var data = JSON.parse(res)
			
			$("#userId").val(data.id)
			$("#uname").val(data.uname)
			$("#email").val(data.email)
			$("#phone").val(data.phone)
		})
		
	}
	
	
	//this is for update user details
	function updateUser(){
		
		var uid = $("#userId").val()
		var uname = $("#uname").val()
		var email = $("#email").val()
		var phone = $("#phone").val()
		
		$.post("update",{uid,uname,email,phone},function(res){
			alert(res)
			load()
		})
		
	}
	
</script>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-5 card p-4">
				<h1 class="text-center text-primary">User Registration</h1>

				<span class="text-success" id="msg"></span>
				<span class="text-danger" id="delete"></span>

				<input type="hidden" name="userId" id="userId" />
				
				<div class="form-group mt-4">
					<label for="uname">Enter Name:</label><input type="text"
						name="uname" id="uname" class="form-control" />
				</div>

				<div class="form-group mt-2">
					<label for="email">Email Address:</label><input type="text"
						name="email" id="email" class="form-control" />
				</div>

				<div class="form-group mt-2">
					<label for="phone">Phone Number:</label><input type="text"
						name="phone" id="phone" class="form-control" />
				</div>

				<div class="form-group mt-2">
					<button class="btn btn-success" onclick="insertUser()">Submit</button>
					<button class="btn btn-primary" id="upbtn" onclick="updateUser()">Update</button>
				</div>
			</div>



			<div class="col-7 card p-4">
				<h1 class="text-center text-primary">User Details</h1>
				<table class="table table-hover table-dark mt-2">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody id="tData">

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>