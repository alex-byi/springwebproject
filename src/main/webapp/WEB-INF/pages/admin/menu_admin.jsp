<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns:fmt="http://www.w3.org/1999/XSL/Transform">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>

<body>
<div>
    <ul>
        <li><a href="/spring-web-project">Главная</a></li>
        <li><a href="/spring-web-project/admin/profile">Кабинет пользователя</a></li>
        <li><a href="/spring-web-project/admin/control_car">Управление автомобилями</a></li>
        <li><a href="/spring-web-project/admin/control_user">Управление пользователями</a></li>
        <li><a href="/spring-web-project/admin/control_orders">Управление заказами</a></li>
        <li><a href="/spring-web-project/admin/control_crashs">Доп. счета</a></li>
        <li><a href="<c:url value='/logout'/>"> Выйти</a></li>
    </ul>
</div>