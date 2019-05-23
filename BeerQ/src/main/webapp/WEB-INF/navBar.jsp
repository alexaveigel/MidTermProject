<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- NAVBAR -->

<div class="pos-f-t">
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="toggleArea">
      <h5 class=>BeerQ</h5>
      <span class="text-muted2"><ul id="navlist"> 
            <li><a id="navlist" href="goToHome.do">Home</a></li>
            <li><a id="navlist" href="goToProfile.do">Profile</a></li>
            <li><a id="navlist" href="logOut.do">Log Out</a></li>
            <c:if test= "${user.role == 'admin' }">
            <li><a id="navlist" href="goToAdmin.do">Admin</a></li>
            </c:if>
            </ul> </span>
    </div>
  </div>

 
  <nav class="navbar navbar-dark" style="background-color: #173e43">
<a  href="goToHome.do" class="pull-right "><img src="/img/logo.jpg" class="nav-logo" height="42" width="42"></a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>

<!-- NAVBAR End -->
