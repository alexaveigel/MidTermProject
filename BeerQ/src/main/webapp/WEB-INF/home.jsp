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
<%-- <%@ include file = " css/style.css"%> --%>
</style>
<meta charset="UTF-8">
<title>BeerQ</title>
</head>
<body>

	<h2>Home Page</h2>

	<form action="barSearch.do" method="GET">
		<label for="search-select">Search Bars:</label> <select name="type"
			id="search-select">
			<option value="">--Please choose an option--</option>
			<option value="barName">Bar Name</option>
			<option value="barcity">Bar By City</option>
<!-- 			<option value="beerName">Beer Name</option>
			<option value="beercity">Beer By City</option> -->
		</select> <input name="keyword"> <input type="submit" value="search">
	</form>


	<form action="beerSearch.do" method="GET">
		<label for="search-select">Search Beers:</label> <select name="type"
			id="search-select">
			<option value="">--Please choose an option--</option>
			<option value="beerName">Beer Name</option>
			<option value="beercity">Beer By City</option>
		</select> <input name="keyword"> <input type="submit" value="search">
	</form>





	<form action="barBrowse.do">
		<input type="submit" value="browseBars">
	</form>

	<form action="beerBrowse.do">
		<input type="submit" value="browseBeers">
	</form>

	<form></form>

</body>
</html>

