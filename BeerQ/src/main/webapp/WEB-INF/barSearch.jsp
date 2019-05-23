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
  border-radius: 5px;
}

img {
  border-radius: 5px 5px 0 0;
}





</style>

</head>
<body>

<jsp:include page="navBar.jsp"/>

	
       
 <div class="container">  
<div class="geoSucks">
<c:forEach var="bar" items="${list}">
  <div class="item"><div class="barCard">
 <a href="goToBarProfile.do?barId=${bar.id}"> <img src="${bar.logoUrl}" alt="Avatar" style="width:100%"></a>
  <div class="container">
   
  </div>
</div></div>
  </c:forEach>
</div>
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