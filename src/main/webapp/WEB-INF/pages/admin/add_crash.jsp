<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns:spring="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>
<h1>This is ADD_CRash_PAGE</h1>

<form method="post" action="addCrash">
    <input type="hidden" name=idUser value="${idUser}"/>
    <input type="hidden" name=idCar value="${idCar}"/>
    <input type="hidden" name=idOrder value="${idOrder}"/>
    <input type="text" name=description value=""/>
    <input type="number" name=amount value=""/>
    <input type="submit" value="Добавить счет" onclick="return confirm('are u shure?')">
</form>


<a href="javascript:history.back()">Назад</a>

</body>
</html>