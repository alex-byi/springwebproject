<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <title>new order</title>

    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>

</head>

<body>

<div>
    <c:import url="menu_user.jsp" charEncoding="utf-8"/>
</div>

<h2>NEW ORDER PAGE</h2>

<div>

    <c:if test="${step == null}">

        <form method="post" action="newOrdersDates">
            <table>
                <tr>
                    <th>Выбор дат</th>
                </tr>
                <tr>
                    <td><input type="text" name="dates" value=""/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Продолжить"/></td>
                </tr>

            </table>
        </form>

        <script>
			$('input[name="dates"]').daterangepicker({ minDate : new Date()});
        </script>
    </c:if>

    <c:if test="${step == 'step2'}">

        <table>
            <tr>
                <th>name</th>
                <th>fuel</th>
                <th>color</th>
                <th>body</th>
                <th>transmission</th>
                <th>Цена для выбранного периода</th>
                <th>Выбрать</th>
            </tr>
            <c:forEach var="car" items="${availableCars}">
                <tr>
                    <td>${car.name}</td>
                    <td>${car.fuel}</td>
                    <td>${car.color}</td>
                    <td>${car.body}</td>
                    <td>${car.transmissionType}</td>
                    <td>${car.price * days}</td>
                    <td>Выбрать</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>