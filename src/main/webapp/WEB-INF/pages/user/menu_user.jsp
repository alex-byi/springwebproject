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
        <li><a href="/spring-web-project/common/profile">Кабинет пользователя</a></li>
        <li><a href="/spring-web-project/user/new_order">Сделать заказ</a></li>
        <li><a href="/spring-web-project/user/orders">Ваши заказы</a></li>
        <li><a href="/spring-web-project/user/crashes">Ваши счета за повреждения</a></li>
        <li><a href="<c:url value='/logout'/>"> Выйти</a></li>
    </ul>
</div>