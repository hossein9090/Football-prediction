<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>matchesForm</title>
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
        <h2 class="text-center">Guess Form</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Guess</div>
            </div>
            <div class="panel-body">
                <form:form action="saveGuess" cssClass="form-horizontal"
                           method="post" modelAttribute="guess">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="userId" class="col-md-3 control-label">userId</label>
                        <div class="col-md-9">
                            <form:input path="userId" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="matchId" class="col-md-3 control-label">matchId</label>
                        <div class="col-md-9">
                            <form:input path="matchId" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="guessHomeGoal" class="col-md-3 control-label">guessHomeGoal</label>
                        <div class="col-md-9">
                            <form:input path="guessHomeGoal" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="guessAwayGoal" class="col-md-3 control-label">guessAwayGoal</label>
                        <div class="col-md-9">
                            <form:input path="guessAwayGoal" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="score" class="col-md-3 control-label">score</label>
                        <div class="col-md-9">
                            <form:input path="score" cssClass="form-control" />
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