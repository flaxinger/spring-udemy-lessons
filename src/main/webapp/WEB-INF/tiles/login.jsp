<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-09-04
  Time: PM 3:20
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: FLAXINGER
  Date: 2021-08-26
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="loginUrl" value="/login"/>

<div class="row">
    <fmt:setLocale value="en"/>
    <div class="col-md-4 offset-md-8">
        <div class="card card-login">
            <div class="card-header">
                <strong>User Login</strong>
            </div>
            <div class="card-body">
                <img src="/img/spring.png" alt="Logo" class="login-logo"/>
                <c:if test="${param.error != null}">
                    <div class="login-error"> USERNAME OR PASSWORD IS INCORRECT </div>
                </c:if>
                <div class="form-group">
                    <form method="post" action="${loginUrl}" class="login-form">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <div class="input-group">
                            <input type="text" name="username" placeholder="Username" class="form-control">
                        </div>
                        <div class="input-group">
                            <input type="password" name="password" placeholder="Password" class="form-control"/>
                        </div>
                        <div class="submit-button">
                            <input type="submit" name="submit" value="Sign In" class="btn btn-dark"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>