<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>

<body>
<h2>Все пользователи</h2>
<table>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
        <th>active</th>
        <th>passportnumber</th>
        <th>fullname</th>
        <th>address</th>
        <th>email</th>
        <th>cash</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>${user.active}</td>
            <td>${user.passportNumber}</td>
            <td>${user.fullName}</td>
            <td>${user.address}</td>
            <td>${user.email}</td>
            <td>${user.cash}</td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/admin/control_user" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>


<h2><a href="/spring-web-project/admin/control_car">На страницу со всеми автомобилями</a></h2>
<h2><a href="/spring-web-project/">На главную</a></h2>
</body>
</html>
