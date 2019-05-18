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
<%@ include file ="css/style.css"%>
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="newUser">
		<form action="signup.do" method="post">

			<table style="width: 50%">

				<tr>
					<td>First Name</td>
					<td input type="text" name="first_name" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td input type="text" name="last_name" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" /></td>
				</tr>

				<tr>
					<td>Street Address</td>
					<td><input type="text" name="address" /></td>
				</tr>

				<tr>
					<td>City</td>
					<td><input type="text" name="city" /></td>
				</tr>

				<tr>
					<td>State</td>
					<td><input type="text" name="state" /></td>
				</tr>

				<tr>
					<td>Zip Code</td>
					<td><input type="text" name="zip" /></td>
				</tr>


				<tr>
					<td>Date Of Birth</td>
					<td><input type="text" name="dob" /></td>
				</tr>
				
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" /></td>
				</tr>

				<tr>
					<td>Beer Style</td>
					<td><input type="text" name="beerStyle" /></td>
				</tr>

				<tr>
					<td>Pic URL</td>
					<td><input type="text" name="picURL" /></td>
				</tr>

			</table>
			<input type="submit" value="register" />

		</form>
	</div>

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