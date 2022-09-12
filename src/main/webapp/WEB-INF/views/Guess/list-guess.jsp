<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>javaguides.net</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <center>
        <div class="col-md-offset-1 col-md-10">
            <h2>List Of Guess</h2>
            <hr />

            <input type="button" value="Add Guess"
                   onclick="window.location.href='showForm'; return false;"
                   class="btn btn-primary" />
            <br/><br/>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">List of Guess!</div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>userId</th>
                            <th>matchId</th>
                            <th>guessHomeGoal</th>
                            <th>guessAwayGoal</th>
                            <th>score</th>
                        </tr>

                        <!-- loop over and print our customers -->
                        <c:forEach var="tempGuess" items="${guess}">


<%--                        <c:if test = "${tempGuess.userId ==2}">--%>
<%--                        <p>My salary is:  <p>--%>
<%--                        </c:if>--%>


                            <!-- construct an "update" link with customer id -->
                            <c:url var="updateLink" value="/Guess/updateForm">
                                <c:param name="guessId" value="${tempGuess.id}" />
                            </c:url>

                            <!-- construct an "delete" link with customer id -->
                            <c:url var="deleteLink" value="/Guess/delete">
                                <c:param name="guessId" value="${tempGuess.id}" />
                            </c:url>

                            <tr>
                                <td>${tempGuess.userId}</td>
                                <td>${tempGuess.matchId}</td>
                                <td>${tempGuess.guessHomeGoal}</td>
                                <td>${tempGuess.guessAwayGoal}</td>
                                <td>${tempGuess.score}</td>

                                <td>
                                     <a href="${updateLink}">Update</a>
                                    | <a href="${deleteLink}"
                                         onclick="if (!(confirm('Are you sure you want to delete this ?'))) return false">Delete</a>
                                </td>

                            </tr>

                        </c:forEach>

                    </table>

                </div>
            </div>
        </div>
    </center>

</div>
</body>
</html>