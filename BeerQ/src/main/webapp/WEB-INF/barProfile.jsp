  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Bar Profile</title>
</head>
<body class="barProfile">

	<!-- NAVBAR -->

	<div class="pos-f-t">
		<div class="collapse" id="navbarToggleExternalContent">
			<div class="toggleArea">
				<h5 class=>BeerQ Home</h5>
				<span class="text-muted2"><ul id="navlist">
						<li><a class="navbar" href="goToHome.do">Home</a></li>
						<li><a class="navbar" href="goToProfile.do">Profile</a></li>
						<li><a class="navbar" href="logOut.do">Log Out</a></li>
						<li><a class="navbar" href="goToAdmin.do">Admin</a></li>
					</ul> </span>
			</div>
		</div>


		<nav class="navbar navbar-dark" style="background-color: #173e43">
			<a href="goToHome.do" class="pull-right "><img
				src="/img/logo.jpg" class="nav-logo" height="42" width="42"></a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarToggleExternalContent"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</nav>
	</div>



	<!-- NAVBAR End -->






	<div id="section">

		<div class="barProfile">

			<div class="container">
				<div class="row">
					<div class="col">BAR IMAGE<br>
					<%-- <img src="${bar.address.logoUrl}"> --%>
					</div>
					<div class="col-6">
						<h1 class="barTitle">  <a class="barTitle" href="${bar.webUrl }">${bar.name} </a></h1>
						<ol class="barTitle">
							<li class="barDetail">
							<div class="shadow-lg p-3 mb-5  rounded">
							<h2>
							${bar.address.street}<br>
							${bar.address.city} ${bar.address.state} ${bar.address.zip}<br>
							<br>
							<br>

							Message from ${bar.name}:</h2>
							<h3>${bar.message}</h3>

							</div>


							</li>
						</ol>
					</div>
					<div class="col">
						BAR STATS

						<!--The div element for the map -->
<div id="map"></div>


<script>
// Initialize and add the map
function initMap() {
  // The location of Uluru
  var uluru = {lat: 32.81963247846479, lng: -96.87711525076286};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 15, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
}
    </script>

<!-- Replace the value of the key parameter with your own API key. -->
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCkUOdZ5y7hMm0yrcCQoCvLwzdM6M8s5qk&callback=initMap">
</script>

					</div>
				</div>
			</div> <!-- end container -->

		</div>
	</div>









	<h2>Beers that we carry</h2>

<ol>
<div class="flexcontainer2">



<!--Carousel Wrapper-->
<div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails" data-ride="carousel">
  <!--Slides-->
  <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
<div class="row">



<c:forEach var="beer" items="${bar.beers}">
   <!--  <div class="carousel-item"> -->
<!--Test Carousel Add-->



        <li class="beerDetail">

        <section class="cards">
          <!-- Heart feature -->
        <article class="card card--1">

        <div class="card__info-hover">
          <svg class="card__like"  viewBox="0 0 24 24">
          <path fill="#000000" d="M12.1,18.55L12,18.65L11.89,18.55C7.14,14.24 4,11.39 4,8.5C4,6.5 5.5,5 7.5,5C9.04,5 10.54,6 11.07,7.36H12.93C13.46,6 14.96,5 16.5,5C18.5,5 20,6.5 20,8.5C20,11.39 16.86,14.24 12.1,18.55M16.5,3C14.76,3 13.09,3.81 12,5.08C10.91,3.81 9.24,3 7.5,3C4.42,3 2,5.41 2,8.5C2,12.27 5.4,15.36 10.55,20.03L12,21.35L13.45,20.03C18.6,15.36 22,12.27 22,8.5C22,5.41 19.58,3 16.5,3Z" />
        </svg>
        <br>
        ABV: ${beer.abv} <br>
        Style: ${beer.style} <br>
        </div>


          <div class="card__img"></div>
          <a href="goToBeerProfile.do?beerId=${beer.id}" class="card_link">
             <div class="card__img--hover"></div>
           </a>
          <div class="card__info">
            <span class="card__category">${beer.brewery.name}</span>
            <h3 class="card__title">${beer.name}</h3>

          </div>
        </article>

        </section>
        </li>

        </c:forEach>
</div>


      </div>
<!--     
      Controls
      <a class="carousel-control-prev" href="#carousel-thumb" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel-thumb" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
 
 -->
</div>
      </div>
      <!--/.Carousel Wrapper-->

	</div> <!-- container end -->
</ol>







	<div class="bg-image"></div>

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
