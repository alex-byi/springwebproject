<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <title>Orders</title>
</head>

<body>

<h2>ORDER PAGE</h2>
<table>
    <tr>
        <th>idorders</th>
        <th>dateorder</th>
        <th>startdate</th>
        <th>enddate</th>
        <th>ispaid</th>
        <th>iscrash</th>
        <th>cars_idcars</th>
        <th>crashbill_idcrashbill</th>
        <th>users_iduser</th>
        <th>amount</th>
        <th>dayCol</th>
        <th>iscanceled</th>
        <th>iscomplete</th>
        <th>reject_reason</th>

    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.dateOrder}</td>
            <td>${order.startDate}</td>
            <td>${order.endDate}</td>
            <td>${order.paid}</td>
            <td>${order.crash}</td>
            <td>${order.idCar}</td>
            <td>${order.crashBill}</td>
            <td>${order.idUser}</td>
            <td>${order.amount}</td>
            <td>${order.dayCol}</td>
            <td>${order.canceled}</td>
            <td>${order.complete}</td>
            <td>${order.rejectReason}</td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/admin/control_orders" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<br>
<h2><a href="/spring-web-project/admin/control_user">Управление пользователями</a></h2>

<h2><a href="/spring-web-project/">На главную</a></h2>
</body>
</html>