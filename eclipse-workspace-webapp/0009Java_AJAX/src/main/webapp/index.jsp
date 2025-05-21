<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	
	function test(value) {
		$.get("servlet1",{value},function(res1){
			$('#data').html(res1)
		}
		)
	}

</script>

</head>
<body>
	<label>Enter Products Name :</label>
	<input type="text" name="product" id="product" onkeyup="test(value)">
	<span id="data"></span>
</body>
</html>