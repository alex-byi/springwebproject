<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <title>Orders</title>
</head>

<body>

<div>
    <c:import url="menu_user.jsp" charEncoding="utf-8"/>
</div>

<h2>ORDERS PAGE</h2>

<div>
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
            <th>amount</th>
            <th>dayCol</th>
            <th>iscanceled</th>
            <th>iscomplete</th>
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
                <td>${order.amount}</td>
                <td>${order.dayCol}</td>
                <td>${order.canceled}</td>
                <td>${order.complete}</td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/user/orders" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:forEach>

</div>

</body>
</html>