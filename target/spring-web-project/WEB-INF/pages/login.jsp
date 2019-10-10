<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>

<div>


    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form action="${loginUrl}" method="post">
        <h2>Please sign in</h2>
        <input type="text" name="j_username" placeholder="Login" required autofocus value="">
        <input type="password" name="j_password" placeholder="Password" required value="">
        <button type="submit">Войти</button>
    </form>

</div>

</body>
</html>