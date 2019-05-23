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
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="navBar.jsp"/>
	
	<c:if test="${empty type }">
		<div>
			<h5>Name: ${drinker.firstName} ${drinker.lastName}</h5>
			<input type="hidden" path="id" value="${drinker.id }" />
			<p>D.O.B.: <fmt:formatDate value="${drinker.dob}" pattern="MM/dd/yyyy"/> </p>
			<p>Gender: ${drinker.gender}</p>
			<p>Beer Style: ${drinker.beerStyle}</p>
			<p>Profile Picture: ${drinker.picUrl}</p>
			<h5 class=>Address</h5>
			<p>Street: ${drinker.address.street}</p>
			<p>City : ${drinker.address.city}</p>
			<p>State: ${drinker.address.state}</p>
			<p>Zip: ${drinker.address.zip}</p>
		</div>

		<form action="goToEditProfile.do" method="get">
			<input type="submit" value="Edit Profile">
		</form>
		<form action="getFavorite.do" method="get">
			<input type="submit" value="Favorite Beers">
		</form>
		<form action="goToBeerRequest.do" method="get">
			<input type="submit" value="Request to add a new beer">
		</form>
	</c:if>

	<c:if test="${type == 'edit'}">
		<div>
		<form action = "editProfile.do" method = "post">
			<h5>Name: <input type= "text" name = "firstName" value = "${drinker.firstName}"> <input type="text" name="lastName" value = "${drinker.lastName}"> </h5>
			<p>D.O.B.: <input type= "Date" name = "dob" value = "${drinker.dob}"></p>
			<p>Gender: <select name="gender">
			<option value="${drinker.gender }">--Select an option--</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
			<option value="Undeclared">Prefer not to say</option>
			</select></p>
			<p>
				Beer Style: <select  name="beerStyle" >
							<option value= "${drinker.beerStyle }">--Select an option--</option>
							<c:forEach var="style" items="${styles}">
  							<option value="${style}">${style}</option>

							</c:forEach>
							</select> 
							</p>
			<p>Profile Picture: <input type= "text" name = "picUrl" value = "${drinker.picUrl}"></p>
			<input type="submit" value ="Confirm Changes">
			</form>
			
		<form action = "editAddress.do" method = "post">
			<h5 class=>Address</h5>
			<p>Street: <input type= "text" name = "street" value = "${drinker.address.street}"></p>
			<p>City : <input type= "text" name = "city" value = "${drinker.address.city}"></p>
			<p>State: <input type= "text" name = "state" value = "${drinker.address.state}"></p>
			<p>Zip: <input type= "text" name = "zip" value = "${drinker.address.zip}"></p>
			<input type="submit" value="Confirm Changes">
		</form>
		</div>
		
	</c:if>
	<c:if test="${type == 'request'}">
		<div>
		<form action = "addBeerRequest.do" method = "post">
			<p>Name: <input type= "text" name = "name" value = "${beer.name}"></p>
			<p>Style: <input type= "text" name = "style" value = "${beer.style}"></p>
			<p>ABV: <input type= "text" name = "abv" value = "${beer.abv}"></p>
			<p>Description: <input type= "text" name = "description" value = "${beer.description}"></p>
			<p><input type= "hidden" name = "approved" value = "0"></p>
			<input type="submit" value ="Confirm Changes">
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