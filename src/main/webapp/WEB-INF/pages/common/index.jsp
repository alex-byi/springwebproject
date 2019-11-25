<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>

<div>
    <sec:authorize access="!isAuthenticated()">
        <p>
        <h2><a href="<c:url value='/common/login'/>">Войти</a></h2>
        <p>
        <h2><a href="/spring-web-project/common/register">Зарегистрироваться</a></h2>
    </sec:authorize>

    <sec:authorize access="hasAuthority('ADMIN')">
        <div>
            <c:import url="../admin/menu_admin.jsp" charEncoding="utf-8"/>
        </div>
        <br>
        <h2> Ваш логин:
            <sec:authentication property="principal.username"/>
        </h2>
    </sec:authorize>

    <sec:authorize access="hasAuthority('USER')">
        <div>
            <c:import url="../user/menu_user.jsp" charEncoding="utf-8"/>
        </div>
        <p>
        <h2> Ваш логин:
            <sec:authentication property="principal.username"/>
        </h2>
    </sec:authorize>
</div>
</body>
</html>