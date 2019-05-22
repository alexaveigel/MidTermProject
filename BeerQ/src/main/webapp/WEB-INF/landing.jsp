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
<video autoplay muted loop id="beerVideo">
  <source src="/img/beer.mp4" type="video/mp4">
</video>

<script>
// Get the video
var video = document.getElementById("beerVideo");
</script>
<!-- 

	<form action="login.do" method="GET">
		<input type="email" name="username" Email>
		<input type="password" name="password" Password>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	<br>
	
	<form action="goToSignup.do" method="GET">
		<input type="submit" value="Register">
	</form>
	
	 -->
	
	
	
	
	<div class="box">
  <h2>Welcome to BeerQ</h2>
  <h4>${message }</h4>
  <form action="login.do" method="POST">
    <div class="inputBox">
      <input type="email" name="username" required onkeyup="this.setAttribute('value', this.value);" value="">
      <label>Email</label>
    </div>
    <div class="inputBox">
      <input type="password" name="password" required value="" >
         <!--     onkeyup="this.setAttribute('value', this.value);"
             pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
             title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"> -->
      <label>Password</label>
    </div>
    
    <div class="container">
  <div class="row">
    <div class="col">
        <input type="submit" name="sign-in" value="Login">
  </form>
    </div>
    <div class="col">
       <form action="goToSignup.do" method="GET">
		<input type="submit" value="Register">
	</form>
    </div>
  </div>

  

  
</div>
	
	
	
	
	
	
	

</body>
</html>