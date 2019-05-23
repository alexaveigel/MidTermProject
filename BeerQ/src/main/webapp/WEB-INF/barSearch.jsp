 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Search Results</title>

<style type="text/css">
html, 
body {
width: 100%;
height: 100%;
}

body {
background-image: url(/img/barBrowse.jpg);
background-repeat: no-repeat;
background-size: cover;
background-position: center;
} 

.geoSucks {
  display: grid;
  grid-gap: 5px; 
  overflow: hidden;
/*   grid-template-columns: repeat(auto-fill, 200px); */
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
/*   grid-template-columns: repeat(auto-fit, minmax(300px, 1fr) 150px); */
  grid-auto-flow: dense;
}

.item:nth-of-type(3n) {
  grid-column: span 2;  
}

.item:nth-of-type(5n) {
  grid-row: span 2;  
}

.barCard {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 5px; /* 5px rounded corners */
}

/* Add rounded corners to the top left and the top right corner of the image */
img {
  border-radius: 5px 5px 0 0;
}





</style>

</head>
<body>

<jsp:include page="navBar.jsp"/>

	<%-- <h2>Here are your Bar results</h2>


    <c:forEach var="bar" items="${bars}">
        <li>
        <a class="listr" href="goToBarProfile.do?barId=${bar.id}"> ${bar.name}</a> 
        </li>
        </c:forEach> 
	
	<c:forEach var="bar" items="${list}">
        <li>
        <a class="listr" href="goToBarProfile.do?barId=${bar.id}"> ${bar.name}</a> 
        </li>
        </c:forEach> 
        
         --%>
        
        	<h2>All Bars</h2><br>
<%-- <br>
<ol>
<div class="flexcontainer">
<br>


<!--Carousel Wrapper-->
<div id="carousel-thumb" class="carousel slide carousel-fade carousel-thumbnails" data-ride="carousel">
  <!--Slides-->
  <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
<div class="row">

<br>

<c:forEach var="bar" items="${bars}">


<br>
        <li class="beerDetail">

        <section class="cards">
          <!-- Heart feature -->
        <article class="card card--1">

        <div class="card__info-hover">
          <svg class="card__like"  viewBox="0 0 24 24">
          <path fill="#000000" d="M12.1,18.55L12,18.65L11.89,18.55C7.14,14.24 4,11.39 4,8.5C4,6.5 5.5,5 7.5,5C9.04,5 10.54,6 11.07,7.36H12.93C13.46,6 14.96,5 16.5,5C18.5,5 20,6.5 20,8.5C20,11.39 16.86,14.24 12.1,18.55M16.5,3C14.76,3 13.09,3.81 12,5.08C10.91,3.81 9.24,3 7.5,3C4.42,3 2,5.41 2,8.5C2,12.27 5.4,15.36 10.55,20.03L12,21.35L13.45,20.03C18.6,15.36 22,12.27 22,8.5C22,5.41 19.58,3 16.5,3Z" />
        </svg>
        <br>
        Name: ${bar.name} <br>
        Website: ${bar.website} <br>
        </div>


          <div class="card__img"></div>
          <a href="goToBarProfile.do?barId=${bar.id}" class="card_link">
             <div class="card__img--hover"></div>
           </a>
          <div class="card__info">
            <span class="card__category">${beer.name}</span>
            <h3 class="card__title">${beer.name}</h3>

          </div>
        </article>

        </section>
        </li>

        </c:forEach>
</div>


      </div>
     --%>    
       
       
        
<div class="geoSucks">
<c:forEach var="bar" items="${bars}">
  <div class="item"><div class="barCard">
  <img src="${bar.logoUrl}" alt="Avatar" style="width:100%">
  <div class="container">
    <h4><b>${bar.name}</b></h4> 
   
  </div>
</div></div>
  </c:forEach>
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