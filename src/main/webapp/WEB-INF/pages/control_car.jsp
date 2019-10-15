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
            <td>
                <c:if test="${car.active == true}">
                    <form method="post" action="deactivateCar">
                        <input type="hidden" name= idCar value="${car.id}"/>
                        <input type="hidden" name= pageNum value="page"/>
                        <input type="submit" value="DEACTIVATE" onclick="return confirm('are u shure?')">
                    </form>
                </c:if>
                <c:if test="${car.active == false}">
                    <form method="post" action="activateCar">
                        <input type="hidden" name= idCar value="${car.id}"/>
                        <input type="submit" value="ACTIVATE" onclick="return confirm('are u shure?')">
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/control_car" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<h2><a href="/spring-web-project/add_car">Добавить автомобиль</a></h2>
<br>
<h2><a href="/spring-web-project/control_user">Управление пользователями</a></h2>

<h2><a href="/spring-web-project/">На главную</a></h2>
</body>
</html>