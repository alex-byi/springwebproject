<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:c="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>

    <script>
    function disp(form) {
        if (form.style.display == "none") {
            form.style.display = "block";
        } else {
            form.style.display = "none";
        }
    }

    </script>

</head>
<body>
<div>
    <c:import url="menu_admin.jsp" charEncoding="utf-8"/>
</div>
<h1>This is PROFILE_PAGE</h1>
<br>
<br>
<br>

<table>
    <tr>
        <td>
            Имя пользователя
        </td>
        <td>
            ${user.login}
        </td>
        <td>
            <form method="post" action="changePassword" id="form1" style="display: none;">
                Введите старый пароль <input type="password" name=oldPassword value="">
                <br>
                Введите новый пароль <input type="password" name=newPassword value="">
                <input type="hidden" name=idUser value="${user.id}">
                <input type="submit" value="Подтвердить" onclick="return confirm('are u shure?')">
            </form>
            <input type="button" value="Сменить пароль" onclick="disp(document.getElementById('form1'))"/>
        </td>
    </tr>
    <tr>
        <td>
            FULLNAME
        </td>
        <td>
            ${user.fullName}
        </td>
    </tr>
    <tr>
        <td>
            Адрес
        </td>
        <td>
            ${user.address}
        </td>
    </tr>
    <tr>
        <td>
            E-mail
        </td>
        <td>
            ${user.email}
        </td>
        <td>
            <form method="post" action="changeEmail" id="form2" style="display: none;">
                Введите новый адрес почты <input type="email" name=email value="">
                <input type="hidden" name=idUser value="${user.id}">
                <input type="submit" value="Подтвердить" onclick="return confirm('are u shure?')">
            </form>
            <input type="button" value="Сменить почту" onclick="disp(document.getElementById('form2'))"/>
        </td>
    </tr>
    <tr>
        <td>
            Role
        </td>
        <td>
            ${user.role};
        </td>
    </tr>
</table>

</body>
</html>