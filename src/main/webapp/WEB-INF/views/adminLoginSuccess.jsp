<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>login success</title>

    <style type="text/css">
        .button {
            display: block;
            width: 115px;
            height: 25px;
            background: #ab8080;
            padding: 10px;
            text-align: center;
            border-radius: 5px;
            color: #1c0319;
            font-weight: bold;
            line-height: 25px;
            margin: 10px;
        }
        .button1 {
            display: block;
            width: 115px;
            height: 25px;
            background: #8b9da1;
            padding: 10px;
            text-align: center;
            border-radius: 5px;
            color: #460c3d;
            font-weight: bold;
            line-height: 25px;
            margin: 10px;
        }
    </style>

</head>
<body>
<a style="margin-left: 100px" class="button" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/">log out</a>

<center>
    <h2>Welcome ${adminLoginForm.userName}</h2>

    <a class="button1" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Matches/list">List Of Matches</a>
<%--    <a class="button1" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Matches/showForm">Add New Match</a>--%>

</center>

</body>
</html>
