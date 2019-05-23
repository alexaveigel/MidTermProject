<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">

<style type="text/css">
    <%@
    include file ="css/style.css" %>
    </style>
    
<title>Beer Browse</title>
</head>
<body>


<video autoplay muted loop id="beerVideo3">
  <source src="/img/barCounter.mp4" type="video/mp4">
</video>

<script>
// Get the video
var video = document.getElementById("beerVideo3");
</script>


<jsp:include page="navBar.jsp"/>



<h3>6-Pack</h3>
<div class="container">
  <div class="row">
 
     
   
<c:forEach var = "beer" items="${sixPack }">
<!-- beer cards and carousel -->


<div class="col">

<div class="six-pack">
    	<img src="/img/bottle.gif" alt="6-pack" height="90%" width="90%">
    	<div class="beerLabelLogo">
    	<c:choose>
    	<c:when test="${empty beer.brewery.logoUrl  }">
            <img class="labelLogo" src="/img/logo.jpg" > 
            </c:when>
            
            <c:otherwise>
            <img class="labelLogo" src="${beer.brewery.logoUrl}"> 
            </c:otherwise>
            </c:choose>
            
           
        </div>
        <div class="beerLabel">
            <h4 class="labelText">${beer.name }</h4>
        </div>
        <h6 class="labelText"><fmt:formatNumber type="number" minFractionDigits="1" maxFractionDigits="1" value="${beer.abv}"/> %</h6>
        <div class="beerLabelABV">
        
        </div>
        
        
        
    </div>
 </div>
</c:forEach>

</div>
</div>



<h3>by Style</h3>
<c:forEach var = "style" items="${styles }">
<!-- style cards and carousel -->
${style }<br>
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