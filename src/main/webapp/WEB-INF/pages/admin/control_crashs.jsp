<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <title>Crashes</title>
</head>

<body>

<div>
    <c:import url="menu_admin.jsp" charEncoding="utf-8"/>
</div>

<h2>ALL CRASHES PAGE</h2>

<div>
    <table>
        <tr>
            <th>idcrashbill</th>
            <th>description</th>
            <th>amount</th>
            <th>idcar</th>
            <th>iduser</th>
            <th>iscomplete</th>

        </tr>
        <c:forEach var="crash" items="${crashs}">
            <tr>
                <td>${crash.id}</td>
                <td>${crash.description}</td>
                <td>${crash.amount}</td>
                <td>${crash.idCar}</td>
                <td>${crash.idUser}</td>
                <td>${crash.complete}</td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/admin/control_crashs" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:forEach>
</div>
</body>
</html>