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

	$(document).ready(function(){
	
		loadUser()
	})
	
	function insertUser(){
		var uname = $("#uname").val()
		var email = $("#email").val()
		
		$.post("register",{uname,email},function(resp){
			
		loadUser()
			
		})
	}
	
	function loadUser(){
		
		
		$.get("load",{},function(resp){
			var data = JSON.parse(resp)
	
			
			var row =""
			
			data.map(el=>{
				row +="<tr><td>"+el.id+"</td><td>"+el.uname+"</td><td>"+el.email+"</td><td><button class='btn btn-warning' onclick='deleteUser("+el.id+")'> Delete</button></td><td><button class='btn btn-primary' onclick='editUser("+el.id+")'>Update</button></td></tr>"
			})
		
			$("#body").html(row) 
		})
		
	}

	function deleteUser(id){
		$.get("edit",{id,"action":"delete"},function(resp){
			loadUser()
		})
	}
	
	function editUser(id){
		$.get("edit",{id,"action":"update"},function(resp){
			var data = JSON.parse(resp)
			
			$("#uid").val(data.id)
			$("#uname").val(data.uname)
			$("#email").val(data.email)
			
		})
	}
	
	function updateUser(){
		
		var id = $("#uid").val()
		var uname = $("#uname").val()
		var email = $("#email").val()
		alert()
		
		$.get("update",{id,uname,email},function(resp){
			loadUser()
			
			$("#uid").val("")
			$("#uname").val("")
			$("#email").val("")
		})
	}
	
</script>


</head>  
<body>  

	<div class="container-fluid mt-4">  

		<div class="row">  

			<!-- For Form -->  
			<div class="col-md-6 card p-4">  

				<h5 class="text-center text-primary">Registration Form</h5>  
				
				<input type="hidden" id="uid">

				<div class="mb-2 mt-3">  
					<label class="form-label">User Name</label>   
					<input type="text" class="form-control" id="uname" name="uname">  
				</div>  

				<div class="mb-2">  
					<label class="form-label">Email Address</label>   
					<input type="email" class="form-control" id="email" name="email">  
				</div>  

				<div class="d-flex justify-content-center">  
					<button class="btn btn-primary" id="btnSubmit" onclick="insertUser()">Submit</button>  
					<button class="btn btn-success" id="upbtn" onclick="updateUser()" >Update</button>
				
				</div>  
				  
			</div>  

			<!-- For User Details Table -->  
			<div class="col-md-6 card p-4 ml-3">  

				<h5 class="text-center text-success">User Details</h5>  

				<div class="mb-2 mt-3">  
					<table class="table">  
						<thead class="thead-light">  
							<tr>  
								<th scope="col">Id</th>  
								<th scope="col">Name</th>  
								<th scope="col">Email</th> 
								<th scope="col" colspan="2">Actions</th> 
							</tr>  
						</thead>  
						<tbody id="body">  
							<!-- User details will be populated here -->  
						</tbody>  
					</table>  
				</div>  
			</div>  

		</div>  
	</div>  

</body>  
</html>