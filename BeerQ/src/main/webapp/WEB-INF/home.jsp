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
</head>
<body>


<jsp:include page="navBar.jsp"/>


    <form action="search.do" method="GET">
        <label for="search-select">Search Select:</label>
        <select name = "type" id="search-select">
            <option value="">--Please choose an option--</option>
            <option value="beer">Beer Name</option>
            <option value="bar">Bar Name</option>
            <option value="beercity">Beer By City</option>
            <option value="barcity">Bar By City</option>
        </select>
        <input name="keyword"> <input type="submit" value="search">
    </form>

    <form action="barBrowse.do">
        <input type="submit" value="browseBars">
    </form>

    <form action="beerBrowse.do">
        <input type="submit" value="browseBeers">
    </form>



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
