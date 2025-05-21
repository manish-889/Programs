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
	
	function getData(value){
		$.post("postData",{value},function(res){
			
		})
	}
	
</script>

</head>
<body>
	
	<label>Enter your Product:</label>
	<input type="text" name="product" onkeyup="getData(value)"/>
	<span id="data"></span>
</body>
</html>