<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
<script type="text/javascript">

	function getData(){
		
		const value = $("#product").val()
		
		$.post("postData",{value}, function(res){
			$('#data').html(res);
		})
	}

</script>

</head>
<body>

	<label>Enter your product:</label>
	<input type="text" id="product" onkeyup="getData()" />
	<span id="data"></span>

</body>
</html>