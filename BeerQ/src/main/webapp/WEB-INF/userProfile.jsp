<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
<%@includefile="css/style.css"%>
</style>

<meta charset="UTF-8">
<title>User</title>
<style type="text/css">
html, 
body {
width: 100%;
height: 100%;
}

body {
background-image: url(/img/beerResult.jpg);
background-repeat: no-repeat;
background-size: cover;
background-position: center;

}
</style>

</head>
<body >

	<jsp:include page="navBar.jsp"/>

	
	<c:if test="${empty type }">
	<div class="box">
		<div>
			<h5 class="result">Name: ${drinker.firstName} ${drinker.lastName}</h5>
			<input type="hidden" path="id" value="${drinker.id }" />
			<p class="result">D.O.B.: <fmt:formatDate value="${drinker.dob}" pattern="MM/dd/yyyy"/> </p>
			<p class="result">Gender: ${drinker.gender}</p>
			<p class="result">Beer Style: ${drinker.beerStyle}</p>
			<p class="result">Profile Picture: ${drinker.picUrl}</p>
			<h5 class="result">Address</h5>
			<p class="result">Street: ${drinker.address.street}</p>
			<p class="result">City : ${drinker.address.city}</p>
			<p class="result">State: ${drinker.address.state}</p>
			<p class="result">Zip: ${drinker.address.zip}</p>
		</div>

		<form action="goToEditProfile.do" method="get">
			<input class="rbt" type="submit" value="Edit Profile">
		</form>
		<br>
		<form action="getFavorite.do" method="get">
			<input class="rbt" type="submit" value="Favorite Beers">
		</form>
		<br>
		<form action="goToBeerRequest.do" method="get">
			<input  class="rbt" type="submit" value="Request to add a new beer">
		</form>
		</div>
	</c:if>

	<c:if test="${type == 'edit'}">
	<div class="box">
		<div>
		<form action = "editProfile.do" method = "post">
			<h5 class="result">Name: <input type= "text" name = "firstName" value = "${drinker.firstName}"> <input type="text" name="lastName" value = "${drinker.lastName}"> </h5>
			<p class="result">D.O.B.: <input type= "Date" name = "dob" value = "${drinker.dob}"></p>
			<p class="result">Gender: <select name="gender">
			<option value="${drinker.gender }">--Select an option--</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
			<option value="Undeclared">Prefer not to say</option>
			</select></p>
			<p class="result">
				Beer Style: <select  name="beerStyle" >
							<option value= "${drinker.beerStyle }">--Select an option--</option>
							<c:forEach var="style" items="${styles}">
  							<option value="${style}">${style}</option>

							</c:forEach>
							</select> 
							</p>
			<p class="result">Profile Picture: <input type= "text" name = "picUrl" value = "${drinker.picUrl}"></p>
			<input type="submit" value ="Confirm Changes">
			</form>
			
		<form action = "editAddress.do" method = "post">
			<h5 class="result">Address</h5>
			<p class="result">Street: <input type= "text" name = "street" value = "${drinker.address.street}"></p>
			<p class="result">City : <input type= "text" name = "city" value = "${drinker.address.city}"></p>
			<p class="result">State: <input type= "text" name = "state" value = "${drinker.address.state}"></p>
			<p class="result">Zip: <input type= "text" name = "zip" value = "${drinker.address.zip}"></p>
			<input type="submit" value="Confirm Changes">
		</form>
		</div>
		</div>
	</c:if>
	<c:if test="${type == 'request'}">
	<div class="box">
		<div>
		<form action = "addBeerRequest.do" method = "post">
			<p class="result">Name: <input type= "text" name = "name" value = "${beer.name}"></p>
			<p class="result">Style: <input type= "text" name = "style" value = "${beer.style}"></p>
			<p class="result">ABV: <input type= "text" name = "abv" value = "${beer.abv}"></p>
			<p class="result">Description: <input type= "text" name = "description" value = "${beer.description}"></p>
			<p class="result"><input type= "hidden" name = "approved" value = "0"></p>
			<input type="submit" value ="Confirm Changes">
			</form>
		</div>
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