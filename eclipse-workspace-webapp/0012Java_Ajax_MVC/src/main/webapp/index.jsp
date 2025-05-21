<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Details</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<script type="text/javascript">

    $(document).ready(function() {  
    	loadUser();  
	});
	
	function insertUser(){
		var uname = $("#uname").val();
		var email = $("#email").val();
		var contact = $("#contact").val();
		var password = $("#password").val();
		
		$.post("register",{uname, email, contact, password}, function(res){
			
			loadUser();
			
			$("#uname").val("");
			$("#email").val("");
			$("#contact").val("");
			$("#password").val("");
		})  
	}
	
	function loadUser(){
		$.get("userList" , function(res){
			
const array = JSON.parse(res);
			
			var row = "";
			
			for(let i = 0; i<array.length; i++){
				
				row = row + "<tr><td>"+array[i].id+"</td><td>"+array[i].name+"</td><td>"+array[i].email+"</td><td>"+array[i].contact+"</td><td><button class='btn btn-warning' onclick='editUser("+array[i].id+");'>Edit</button></td> <td><button class='btn btn-danger' onclick='deleteUser("+array[i].id+");'>Delete</button></td></tr>";
				
			}
			
			$("#body").html(row);
		})
	}
	
	function deleteUser(id){
		$.get("delete",{id},function(res){
			loadUser();
		});
	}
	
	function editUser(id){
		
		$.get("edit",{id}, function(res){
			
			const user = JSON.parse(res); 
			
			$("#uname").val(user.name);
			$("#email").val(user.email);
			$("#contact").val(user.contact);
			$("#password").val(user.password);
			$("#hid").val(user.id);
			$("#btnUpdate").show();
			
		});
	}
	
	function updateUser(id){
		
		var uname = $("#uname").val();
		var email = $("#email").val();
		var contact = $("#contact").val();
		var password = $("#password").val();
		

		$.post("update",{id, uname, email, contact, password}, function(res){
			loadUser(); 

			$("#uname").val("");
			$("#email").val("");
			$("#contact").val("");
			$("#password").val("");
			
			 $("#btnSubmit").show();
			 $("#btnUpdate").hide();
		});
	}

</script>
</head>
<body>
	<div class="container-fluid">

		<div class="row">

			<!-- For Form -->
			<div class="col-4 card p-4">

				<h5 class="text-center text-success">Registration Form</h5>

				<input type="hidden" id="hid">

				<div class="mb-2 mt-3">
					<label class="form-label">User name</label> <input type="text"
						class="form-control" id="uname" name="uname" placeholder=""
						onkeyup="validateForm()">
				</div>

				<div class="mb-2">
					<label class="form-label">Email Address</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="name@gmail.com" onkeyup="validateForm()">
				</div>

				<div class="mb-2">
					<label class="form-label">Contact</label> <input type="number"
						class="form-control" id="contact" name="contact" placeholder=""
						onkeyup="validateForm()">
				</div>

				<div class="mb-2">
					<label class="form-label">Password</label> <input type="password"
						class="form-control" id="password" name="password" placeholder=""
						onkeyup="validateForm()">
				</div>


				<div class="d-flex justify-content-center">

					<button class="btn btn-success" onclick="insertUser()"
						id="btnSubmit">Submit</button>
					<button class="btn btn-info ml-3"
						onclick="updateUser(document.getElementById('hid').value)"
						id="btnUpdate" style="display: none;">Update</button>
				</div>

			</div>

			<!-- For table  -->
			<div class="col-8 card p-4">

				<h5 class="text-center text-success">User Details</h5>

				<div class="mb-2 mt-3">

					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Contact</th>
								<th scope="col" colspan="2">Actions</th>
							</tr	>
						</thead>

						<tbody id="body">

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>