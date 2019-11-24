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
        <th>Добавить доп.счет</th>

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
            <td>
                <c:if test="${order.canceled == false && order.complete == false}">
                    <form method="post" action="cancelOrder">
                        <input type="hidden" name=idOrder value="${order.id}"/>
                        <input type="text" name=reason value=""/>
                        <input type="submit" value="Отменить" onclick="return confirm('are u shure?')">
                    </form>
                </c:if>
                <c:if test="${order.canceled == true}"> Отменен с причиной: ${order.rejectReason}</c:if>
            </td>
            <td>
                <c:if test="${order.canceled == false && order.complete == false}">
                    <form method="post" action="completeOrder">
                        <input type="hidden" name=idOrder value="${order.id}"/>
                        <input type="submit" value="Завершить" onclick="return confirm('are u shure?')">
                    </form>
                </c:if>
                <c:if test="${order.complete == true}"> Завершен</c:if>
            </td>
            <td>
                <form method="post" action="addCrashPage">
                    <input type="hidden" name=idUser value="${order.idUser}"/>
                    <input type="hidden" name=idCar value="${order.idCar}"/>
                    <input type="hidden" name=idOrder value="${order.id}"/>
                    <input type="submit" value="Добавить счет" onclick="return confirm('are u shure?')">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/admin/control_orders" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<p>
<h2><a href="/spring-web-project/admin/control_car">Управление Автомобилями</a></h2>  </p>
<p>
<h2><a href="/spring-web-project/admin/control_user">Управление пользователями</a></h2></p>
<p>
<h2><a href="/spring-web-project/admin/control_crashs">Управление дополнительными счетами</a></h2></p>
<p>
<h2><a href="<c:url value="/logout" />">Выйти</a></h2></p>
<br>
<h2><a href="/spring-web-project/">На главную</a></h2>
</body>
</html>