<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
<%@ include file ="css/style.css"%>
</style>

<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>







	<c:if test = "${empty form }">
	<h1>Select your username and password</h1>
	<c:if test = "${not empty message }">
	<h3> ${message }</h3>
	</c:if>
	<form action = "signup.do" method = "post">
	<input type="hidden" value="user" name = "role">
		Username: <input type="text" name="username"><br>
		Password: <input type="password" name="password"><br>
		<input type="submit" value= "Submit">
	</form>
	</c:if>
	<c:if test = "${form == 'drinker' }">
	<h1>Tell us about yourself</h1>
	<form action = "drinker.do" method = "post">
			First Name: <input type="text" name="firstName" ><br>
			Last Name: <input type="text" name="lastName" ><br>
			Date Of Birth: <input type="text" name="dob" /><br>
			Gender: <input type="text" name="gender" /><br>
			Beer Style: <input type="text" name="beerStyle" /><br>
			Link to profile pic: <input type="text" name="picUrl" /><br>
			<input type="hidden" value = "${user.id}" name = "userId">
		<input type="submit" value = "Submit">
	</form>
	
	</c:if>
		<c:if test = "${form == 'address' }">
		<h1>Tell us where you're at</h1>
		<h2> so we can tell you what's close</h2>
	<form action = "address.do" method = "post">
			Street: <input type="text" name="street" ><br>
			City: <input type="text" name="city" ><br>
			Zip: <input type="text" name="zip" /><br>
			
		<input type="submit" value = "Submit">
	</form>
	
	</c:if>
	

		<!-- <form action="signup.do" method="post">


					First Name
					<input type="text" name="first_name" >

					Last Name
					<input type="text" name="last_name" >

					Password
					<input type="password" name="pass" />

					Street Address
					<input type="text" name="address" />

					City
					<input type="text" name="city" />

					State
					<input type="text" name="state" />

					Zip Code
					<input type="text" name="zip" />


					Date Of Birth
					<input type="text" name="dob" />
				
					Gender
					<input type="text" name="gender" />

					Beer Style
					<input type="text" name="beerStyle" />

					Pic URL
					<input type="text" name="picURL" />

			<input type="submit" value="register" >

		</form> -->

	<script src="js/scripts.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>