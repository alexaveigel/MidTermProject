<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beer Browse</title>
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



<h2>Brows beers</h2><br>
<h3>6-Pack</h3>
<c:forEach var = "beer" items="${sixPack }">
<!-- beer cards and carousel -->
${beer }
</c:forEach>

<h3>by Style</h3>
<c:forEach var = "style" items="${styles }">
<!-- style cards and carousel -->
${style }
</c:forEach>

<h3>by ABV</h3>
<!--carousel  with abv ranges -->
0%
.5% - 4%<br>
4% - 6%<br>
6% - 8%<br>
8% - 10%<br>
> 10%

<h3>by Brewery</h3>
<c:forEach var = "brewery" items="${listBrewery }">
<!-- brewery cards and carousel -->
${brewery }
</c:forEach>
</body>
</html>