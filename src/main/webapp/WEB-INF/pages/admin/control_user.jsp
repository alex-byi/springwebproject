<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>

<body>

<div>
    <c:import url="menu_admin.jsp" charEncoding="utf-8"/>
</div>

<h2>Все пользователи</h2>

<div>

    <table>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>role</th>
            <th>active</th>
            <th>passportnumber</th>
            <th>fullname</th>
            <th>address</th>
            <th>email</th>
            <th>cash</th>
            <th>Пополнить счет</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>
                    <form method="post" action="changeRole">
                        <input type="hidden" name=idUser value="${user.id}"/>
                        <input type="submit" value="${user.role}" onclick="return confirm('are u shure?')">
                    </form>
                </td>
                <td>
                    <form method="post" action="changeActivity">
                        <input type="hidden" name=idUser value="${user.id}"/>
                        <input type="submit" value="${user.active}" onclick="return confirm('are u shure?')">
                    </form>
                </td>
                <td>${user.passportNumber}</td>
                <td>${user.fullName}</td>
                <td>${user.address}</td>
                <td>${user.email}</td>
                <td>${user.cash}</td>
                <td>
                    <form method="post" action="addCash">
                        <input type="hidden" name=idUser value="${user.id}"/>
                        <input type="number" name=cash value=""/>
                        <input type="submit" value="Пополнить" onclick="return confirm('are u shure?')">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/admin/control_user" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:forEach>
</div>

<div>
    <h2>Поиск пользователя по ЛОГИНУ</h2>
    <form method="post" action="getUser">
        Login: <input type="text" name="userLogin"/> <br/>
        <input type="submit" value="Поиск">
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
</div>

</body>
</html>
