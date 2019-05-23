<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
    <%@
    include file ="css/style.css" %>
    </style>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">


<meta charset="UTF-8">
<title>BeerQ</title>

<style type="text/css">
html, 
body {
width: 100%;
height: 100%;
}

body {
background-image: url(/img/HomePage.jpg);
background-repeat: no-repeat;
background-size: cover;
background-position: center;
}
</style>



</head>
<body>

<jsp:include page="navBar.jsp"/>



<div class="box2">
<div class="inputBox2">



    <form action="search.do" method="GET">
    <c:if test="${not empty message }">${message }</c:if>
        <label for="search-select">Search Select:</label>
        <select name = "type" id="search-select-home">
            <option value="">--Please select an option--</option>
            <option value="beer">Beer Name</option>
            <option value="bar">Bar Name</option>
            <option value="beercity">Beer By City</option>
            <option value="barcity">Bar By City</option>
        </select><br>
        <input name="keyword"> <input type="submit" value="Search">
    </form>

    <form action="barBrowse.do">
        <input type="submit" value="Browse Bars">
    </form>

    <form action="beerBrowse.do">
        <input type="submit" value="Browse Beers">
    </form>

</div>
</div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
