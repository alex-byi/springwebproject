<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>Car rent</title>
</head>
<body>
<h1>This is REGISTRATION</h1>
<!--<h2><a href = "/spring-web-project/">Go to index</a></h2>-->


<spring:form method="post"  modelAttribute="user" action="addUser">

    Name: <spring:input path="login"/> <br/>
    Password: <spring:input path="password"/>   <br/>
    Passport number: <spring:input path="passportNumber"/>   <br/>
    Full Name: <spring:input path="fullName"/>   <br/>
    Address: <spring:input path="address"/>   <br/>
    E-mail: <spring:input path="email"/>   <br/>
    <spring:button>Next Page</spring:button>

</spring:form>



</body>
</html>