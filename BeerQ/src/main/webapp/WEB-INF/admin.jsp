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
		</c:forEach>
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