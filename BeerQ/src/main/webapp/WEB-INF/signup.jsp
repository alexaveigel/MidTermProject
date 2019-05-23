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
<video autoplay muted loop id="beerVideo2">
  <source src="/img/drinkingBeer.mp4" type="video/mp4">
</video>

<script>
// Get the video
var video = document.getElementById("beerVideo2");
</script>




	<c:if test = "${empty form }">
	
	
		<div class="box">
  <h1>Choose your username and password</h1>
	<c:if test = "${not empty message }">
	<h3> ${message }</h3>
	</c:if>
	<form action = "signup.do" method = "post">
	<div class="inputBox">
	<input type="hidden" value="user" name = "role">
		Select a Username: <input type="text" name="username"><br>
		Create a Password: <input type="password" name="password"><br>
		<input type="submit" value= "Submit">
		</div>
	</form>
	</div>
	</c:if>
	
	
	
	
	
	<c:if test = "${form == 'drinker' }">
	
	
		<div class="box">
	<h1>Tell us about yourself</h1>
	<form action = "drinker.do" method = "post">
		<div class="inputBox">
			First Name: <input type="text" name="firstName" ><br>
			Last Name: <input type="text" name="lastName" ><br>
			Date Of Birth: <input type="date" name="dob" /><br>
			Gender: <select name="gender">
			<option value="Undeclared">--Select an option--</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
			<option value="Undeclared">Prefer not to say</option>
			</select><br><br>
		<!-- 	Beer Style: <input type="text" name="beerStyle" /><br> -->
			
			
			
			
			<div id="container-scroll">
Beer Style: <select size="5" name="beerStyle" >

<c:forEach var="style" items="${styles}">
  <option value="${style}">${style}</option>

</c:forEach>
</select> 
</div>
			
			
			<!-- Link to profile pic: <input type="text" name="picUrl" /><br> -->
			<input type="hidden" value = "${user.id}" name = "userId">
		<input type="submit" value = "Submit">
	</div>
	
	</form>
	</div>
	</c:if>
	
	
	
	
		<c:if test = "${form == 'address' }">
		<div class="box">
		
		
		
		<h1>Tell us where you're at,</h1>
		<h2> so we can tell you what's close</h2>
	<form action = "address.do" method = "post">
		<div class="inputBox">
			Street: <input type="text" name="street" ><br>
			City: <input type="text" name="city" ><br>
			Zip: <input type="text" name="zip" /><br>
			State: <input type="text" name="state" /><br>
			
		<input type="submit" value = "Submit">
</div>


	</form>
	</div>
	</c:if>
	



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