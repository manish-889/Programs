 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Country Selection</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function() {
		getCountry();
	});

	//function for getting the country name
	function getCountry() {
		$.post('country', function(res1) {
			$("#country").html(res1);
		})
	}
	
	//function for getting the state  name
	function getState(cid) {
		$.post('state',{cid},function(res1) {
			$("#state").html(res1);
		})
	}
	//function for getting the city  name
	function getCity(sid) {
		$.post('city',{sid},function(res1) {
			$("#city").html(res1);
		})
	}
</script>
</head>
<body>
	<select id="country" onchange="getState(value)">
	</select>

	<select id="state" onchange="getCity(value)">
	</select>

	<select id="city">
	</select>
</body>
</html>