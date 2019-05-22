<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>Admin</title>
</head>
<body>

<!-- NAVBAR -->

<div class="pos-f-t">
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="toggleArea">
      <h5 class=>BeerQ Home</h5>
      <span class="text-muted2"><ul id="navlist"> 
			<li><a href="goToHome.do">Home</a></li>
			<li><a href="goToProfile.do">Profile</a></li>
			<li><a href="logOut.do">Log Out</a></li>
			<li><a href="goToAdmin.do">Admin</a></li></ul> </span>
    </div>
  </div>


  <nav class="navbar navbar-dark" style="background-color: #173e43">
<a href="goToHome.do" class="pull-right "><img src="/img/logo.jpg" class="nav-logo" height="42" width="42"></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>



<!-- NAVBAR End -->

	<form action="adminSearchUser.do">
		<input name="keyword"> <input type="submit"
			value="Search Users">
	</form>
	<form action="adminSearchBar.do">
		<input name="keyword"> <input type="submit"
			value="Search Bars">
	</form>
	<form action="adminSearchBeer.do">
		<input name="keyword"> <input type="submit"
			value="Search Beers">
	</form>
	<form action="adminConfirmBeerWaitList.do">
		<input type="submit" value="Beers Waiting Approval">
	</form>


	<c:if test="${type == 'Search Users' }">

		<c:forEach var="user" items="${userByKeyword }">
			<!-- create cards here with beer fields -->
			${user.username }
			<form action="goToProfile.do" method="get">
				<input type= "submit" value="Go to profile">
			
			</form>
		</c:forEach>
	</c:if>
	<c:if test="${type == 'Search Beers' }">

		<c:forEach var="beer" items="${listOfBeers }">
			<!-- create cards here with beer fields -->
			${beer.name }
			<form action="getBeer.do" method="get">
				<input type= "submit" value="Go to profile">
			</form>
			
		</c:forEach>
	</c:if>
	<c:if test="${type == 'Search Bars' }">

		<c:forEach var="bar" items="${listOfBars }">
			<!-- create cards here with bar fields -->
			${bar.name }
			<form action="getBar.do" method="get">
				<input type= "submit" value="Go to profile">
			</form>
		</c:forEach>
	</c:if>
	<c:if test="${type == 'unapproved' }">

		<c:forEach var="beer" items="${unapprovedBeerList }">
			<!-- create cards here with bar fields -->
			${beer.name }
			<form action="getBeer.do" method="get">
				<input type= "submit" value="Go to profile">
			</form>
			<form action="adminConfirmBeerAdd.do" method="post">
			<input type= "hidden" name= "beer" value= "${beer.id }">
				<input type= "submit" value="Approve">
			</form>
			<form action="denyBeerRequest.do" method="post">
			<input type= "hidden" name= "beer" value= "${beer.id }">
				<input type= "submit" value="Deny">
			</form>
		</c:forEach>
	</c:if>


		
		<form action="addBeerToBar.do" method="POST">
		Bar ID<input type="text" name="barId">
		Beer ID<input type="text" name="beerId">
		<input type="submit" value="Add a beer to bar">
		</form>
	


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