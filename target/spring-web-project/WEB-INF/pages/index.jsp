<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>

<div>
    <sec:authorize access="!isAuthenticated()">
        <p>
        <h2><a href="<c:url value="/login" />">Войти</a></h2></p>
        <h2><a href="/spring-web-project/register">Зарегистрироваться</a></h2>
    </sec:authorize>

    <sec:authorize access="hasAuthority('ADMIN')">
        <p>
        <h2> Ваш логин:
            <sec:authentication property="principal.username"/>
        </h2>
        </p>
        <p>
        <h2><a href="/spring-web-project/control_car">Управление Автомобилями</a></h2>  </p>
        <p>
        <h2><a href="/spring-web-project/control_user">Управление пользователями</a></h2></p>
        <p>
        <h2><a href="<c:url value="/logout" />">Выйти</a></h2></p>
        <br>
        <br>
        <h2>Поиск пользователя по ЛОГИНУ</h2>
        <form method="post" action="getUser">

            Login: <input type="text" name="userLogin"/> <br/>
            <input type="submit">

        </form>

        <c:if test="${userLogin != null }">
            <h2>
                имя: ${userLogin.login};
                <br/>
                Passport: ${userLogin.passportNumber};
                <br/>
                FULLNAME: ${userLogin.fullName};
                <br/>
                Address: ${userLogin.address};
                <br/>
                E-mail: ${userLogin.email};
                <br/>
                role: ${userLogin.role};
                <br/>
            </h2>
            <br>
        </c:if>
    </sec:authorize>

    <sec:authorize access="hasAuthority('USER')">
        <p>
        <h2> Ваш логин:
            <sec:authentication property="principal.username"/>
        </h2>
        </p>
        <p>
        <h2><a href="/spring-web-project/cars">Go to cars</a></h2>  </p>
        <p>
        <p>
        <h2><a href="<c:url value="/logout" />">Выйти</a></h2></p>
    </sec:authorize>
</div>
</body>
</html>