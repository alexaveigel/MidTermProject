<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login.do" method="GET">
		<input type="email" value="Username">
	</form>
	<form action="login.do" method="GET">
		<input type="password" value="Password">
	</form>
	<button type="submit" class="btn btn-primary">Submit</button>
	<form action="goToSignup.do" method="GET">
		<input type="submit" value="Signup">
	</form>

</body>
</html>