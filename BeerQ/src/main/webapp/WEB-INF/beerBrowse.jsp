<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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