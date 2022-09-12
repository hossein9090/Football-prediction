<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>AdminLoginForm</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center"> </h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Admin Login Form</div>
            </div>
            <div class="panel-body">
                <form:form action="adminLoginForm.html"  modelAttribute="adminLoginForm">

                    <div class="form-group">
<%--                        <FONT color="red"><form:errors path="userName" /></FONT>--%>
                        <label for="userName" class="col-md-3 control-label">userName</label>
                        <div class="col-md-9">
                            <form:input path="userName"  />
                        </div>
                    </div>
                    <div class="form-group">
<%--                        <FONT color="red"><form:errors path="password" /></FONT>--%>
                        <label for="password" class="col-md-3 control-label">password</label>
                        <div class="col-md-9">
                            <form:password path="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>














<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1"%>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--    <title>Spring 4 Example</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>Login Form</h3>--%>
<%--<FONT color="blue">--%>
<%--    User Name="UserName" and password="password"--%>
<%--</FONT>--%>
<%--<form:form action="adminLoginForm.html"  modelAttribute="adminLoginForm">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>User Name:--%>
<%--&lt;%&ndash;                <FONT color="red"><form:errors path="userName" /></FONT>&ndash;%&gt;--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:input path="userName" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Password:--%>
<%--&lt;%&ndash;                <FONT color="red"><form:errors path="password" /></FONT>&ndash;%&gt;--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><form:password path="password" /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Submit" /></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>