<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns:spring="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>
<h1>This is ADD_CAR_PAGE</h1>

<spring:form method="post" modelAttribute="car" action="addCar">

    Car Name:
    <spring:input path="name"/>
    <br/>
    Price:
    <spring:input path="price"/>
    <br/>
    Fuel type:
    <spring:select path="fuel">
        <spring:option value="Бензин"/>
        <spring:option value="Дизель"/>
        <spring:option value="Электричество"/>
    </spring:select>
    <br/>
    Color:
    <spring:input path="color"/>
    <br/>
    Body:
    <spring:select path="body">
        <spring:option value="Универсал"/>
        <spring:option value="Седан"/>
        <spring:option value="Купе"/>
        <spring:option value="Минивэн"/>
        <spring:option value="Хэтчбэк"/>
        <spring:option value="Кабриолет"/>
        </spring:select>
    <br/>
    Transmission:
    <spring:select path="transmissionType">
        <spring:option value="AUTOMATIC"/>
        <spring:option value="MANUAL"/>
    </spring:select>
    <br/>
    <spring:button>Add Car</spring:button>

</spring:form>


<a href="javascript:history.back()">Назад</a>

</body>
</html>