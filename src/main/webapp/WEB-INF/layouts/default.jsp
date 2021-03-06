<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-25
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<html lang="en">
<head>
    <!-- Required meta tags -->

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:insertAttribute name="title"/></title>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <!-- Bootstrap CSS -->
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"/>
    <link href="${contextRoot}/css/main.css" rel="stylesheet"/>
    <link href="${contextRoot}/css/login.css" rel="stylesheet"/>

</head>
<body>

<!-- Static navbar -->
<nav class="navbar navbar-expand-sm navbar-dark" aria-label="Third navbar example">

    <div class="container-fluid">
        <a class="navbar-brand" href="${contextRoot}/">Spring Udemy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03"
                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExample03">
            <ul class="navbar-nav me-auto mb-2 mb-sm-0">
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown"
                           aria-expanded="false">Basic</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdown01">
                            <li><a class="dropdown-item" href="${contextRoot}/">home</a></li>
                            <li><a class="dropdown-item" href="${contextRoot}/about">about</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-bs-toggle="dropdown"
                           aria-expanded="false">User</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdown02">
                            <li><a class="dropdown-item" href="${contextRoot}/addstatus">Add Status</a></li>
                            <li><a class="dropdown-item" href="${contextRoot}/viewstatus">View Status</a></li>
                            <%--                        <li><a class="dropdown-item" href="${contextRoot}/about">about</a></li>--%>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:$('#logoutForm').submit()">Logout</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextRoot}/login">Login</a>
                    </li>
                </sec:authorize>

            </ul>
            <form>
                <input class="form-control" type="text" placeholder="Search" aria-label="Search">
            </form>
        </div>
    </div>
</nav>


<div class="container">
    <tiles:insertAttribute name="content"/>
</div>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>--%>
<script src="${contextRoot}/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>

</body>
</html>
<c:url var="logoutLink" value="/logout"/>
<form id="logoutForm" method="post" action="logoutLink">
    <input type="hidden" name="{_csrf.parameterName}" value="$_csrf.token"/>
</form>
