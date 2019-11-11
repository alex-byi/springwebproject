<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <title>Cars</title>
</head>

<body>

<h2>CAR PAGE</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>fuel</th>
        <th>color</th>
        <th>body</th>
        <th>transmission</th>
        <th>active</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.id}</td>
            <td>${car.name}</td>
            <td>${car.price}</td>
            <td>${car.fuel}</td>
            <td>${car.color}</td>
            <td>${car.body}</td>
            <td>${car.transmissionType}</td>
            <td>${car.active}</td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/user/cars" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2><a href="/spring-web-project/">Go to main</a> </h2>
</body>
</html>