<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
<%@
include file ="css/style.css" %>
</style>
<meta charset="UTF-8">
<title>BeerQ</title>
</head>
<body>

	<form action="login.do" method="GET">
		<input type="email" name="username" Email>
		<input type="password" name="password" Password>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	<br>
	
	<form action="goToSignup.do" method="GET">
		<input type="submit" value="Signup">
	</form>

</body>
</html>