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
			background: #cb0808;
			padding: 10px;
			text-align: center;
			border-radius: 5px;
			color: #d5d0d4;
			font-weight: bold;
			line-height: 25px;
			margin: 10px;
		}
		.button1 {
			display: block;
			width: 115px;
			height: 25px;
			background: #2e474b;
			padding: 10px;
			text-align: center;
			border-radius: 5px;
			color: #dad4d4;
			font-weight: bold;
			line-height: 25px;
			margin: 10px;
		}
		table, th, td {
			border: 1px solid;
			font-size: 23px;
		}
	</style>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

</head>

<body>
<div class="container">
	<div class="row"><hr>
<%--		<center> <h2 >Welcome ${loginForm.userName}</h2> </center>--%>
		<div class="col-md-4">
			<div>
                <br><a style="font-size: 22px" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/">log out</a>
<%--				<br><a style="font-size: 22px" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Matches/u-list">List Of Matches</a>--%>
<%--                <br><a style="font-size: 22px" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Guess/list">my Predictions list</a>--%>
<%--				--%>
                <br>
				<%--	user table--%>
				<table >
					<tr>
						<td>
							UserName:
						</td>
						<td>
							${loginForm.userName}
						</td>
					</tr>
					<tr>
						<td>
							User Id:
						</td>
						<td>
							${userInfo.id}
						</td>
					</tr>
                    <tr>
                        <td>
                            Score:
                        </td>
                        <td>
<%--                            ${userInfo.id}--%>
                        </td>
                    </tr>
				</table>
			</div>
		</div>
		<div class="col-md-8">
			<%--add matches to loginSuccess--%>
			<div >
                <div >
						<div class="panel panel-info">
							<div class="panel-heading">
                                <div class="panel-title"><strong>List of Matches</strong></div>
							</div>
							<div class="panel-body">
								<table class="table table-striped table-bordered">
									<tr>
										<th>homeTeam</th>
										<th>awayTeam</th>
										<th>homeGoal</th>
										<th>awayGoal</th>
										<th>status</th>
									</tr>

									<!-- loop over and print our  -->
									<c:forEach var="tempMatches" items="${matches}">

										<!-- construct an "update" link with  id -->
										<c:url var="updateLink" value="/Matches/updateForm">
											<c:param name="customerId" value="${tempMatches.id}" />
										</c:url>

										<!-- construct an "delete" link with  id -->
										<c:url var="deleteLink" value="/Matches/delete">
											<c:param name="customerId" value="${tempMatches.id}" />
										</c:url>

										<c:url var="addResul" value="/Guess/showForm2">
											<c:param name="userId" value="${userInfo.id}" />
											<c:param name="matchId" value="${tempMatches.id}" />
										</c:url>
										<tr>
											<td>${tempMatches.homeTeam}</td>
											<td>${tempMatches.awayTeam}</td>
											<td>${tempMatches.homeGoal}</td>
											<td>${tempMatches.awayGoal}</td>
											<td>${tempMatches.status}</td>
											<td>
												<c:if test="${tempMatches.status==0}">
													<a style="color: red" href="#">End Match</a>
												</c:if>

												<c:if test="${tempMatches.status!=0}">
													<a style="color: #09176c" href="${addResul}">add resul</a>
												</c:if>
											</td>
										</tr>
									</c:forEach>

								</table>

							</div>
						</div>
					</div>
			</div><br>
			<%-- list of my guesses--%>
			<div >
<%--				<input type="button" value="Add Guess"--%>
<%--					   onclick="window.location.href='showForm'; return false;"--%>
<%--					   class="btn btn-primary" />--%>
<%--				<br/><br/>--%>
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title"><strong>List of Guess</strong></div>
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


							<c:if test = "${tempGuess.userId ==userInfo.id}">

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
								</tr>


							</c:if>

							</c:forEach>

						</table>

					</div>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>
























<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--		 pageEncoding="ISO-8859-1"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<html>--%>
<%--<head><%@ page isELIgnored="false" %>--%>
<%--	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--	<title>login success</title>--%>

<%--	<style type="text/css">--%>
<%--		.button {--%>
<%--			display: block;--%>
<%--			width: 115px;--%>
<%--			height: 25px;--%>
<%--			background: #cb0808;--%>
<%--			padding: 10px;--%>
<%--			text-align: center;--%>
<%--			border-radius: 5px;--%>
<%--			color: #d5d0d4;--%>
<%--			font-weight: bold;--%>
<%--			line-height: 25px;--%>
<%--			margin: 10px;--%>
<%--		}--%>
<%--		.button1 {--%>
<%--			display: block;--%>
<%--			width: 115px;--%>
<%--			height: 25px;--%>
<%--			background: #2e474b;--%>
<%--			padding: 10px;--%>
<%--			text-align: center;--%>
<%--			border-radius: 5px;--%>
<%--			color: #dad4d4;--%>
<%--			font-weight: bold;--%>
<%--			line-height: 25px;--%>
<%--			margin: 10px;--%>
<%--		}--%>
<%--		 table, th, td {--%>
<%--			 border: 1px solid;--%>
<%--			 font-size: 23px;--%>
<%--		 }--%>
<%--	</style>--%>

<%--	<!-- Latest compiled and minified CSS -->--%>
<%--	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">--%>

<%--	<!-- Optional theme -->--%>
<%--	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">--%>

<%--	<!-- Latest compiled and minified JavaScript -->--%>
<%--	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>--%>

<%--</head>--%>

<%--<body>--%>
<%--<div class="container">--%>
<%--	<div class="row">--%>
<%--		<center> <h2 >Welcome ${loginForm.userName}</h2> </center>--%>
<%--		<div class="col-md-4">--%>
<%--			<div>--%>
<%--				<a  class="button" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/">log out</a>--%>
<%--				<a  class="button1" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Matches/u-list">List Of Matches</a>--%>
<%--				<a  style="width: 140px" class="button1" href="http://localhost:8080/springmvc5-hibernate5-jsp-mysql-example/Guess/list">my Predictions list</a>--%>
<%--				<br>--%>
<%--				&lt;%&ndash;	user table&ndash;%&gt;--%>
<%--				<table >--%>
<%--					<tr>--%>
<%--						<td>--%>
<%--							UserName:--%>
<%--						</td>--%>
<%--						<td>--%>
<%--							${loginForm.userName}--%>
<%--						</td>--%>
<%--					</tr>--%>
<%--					<tr>--%>
<%--						<td>--%>
<%--							User Id:--%>
<%--						</td>--%>
<%--						<td>--%>
<%--							${userInfo.id}--%>
<%--						</td>--%>
<%--					</tr>--%>
<%--				</table>--%>
<%--			</div>--%>
<%--		</div>--%>
<%--		<div class="col-md-8">--%>
<%--			&lt;%&ndash;add matches to loginSuccess&ndash;%&gt;--%>
<%--			<div >--%>
<%--				<center>--%>
<%--					<div >--%>
<%--						<h2>List Of Matches</h2>--%>
<%--						<hr />--%>

<%--						<br/><br/>--%>
<%--						<div class="panel panel-info">--%>
<%--							<div class="panel-heading">--%>
<%--							</div>--%>
<%--							<div class="panel-body">--%>
<%--								<table class="table table-striped table-bordered">--%>
<%--									<tr>--%>
<%--										<th>homeTeam</th>--%>
<%--										<th>awayTeam</th>--%>
<%--										<th>homeGoal</th>--%>
<%--										<th>awayGoal</th>--%>
<%--										<th>status</th>--%>
<%--									</tr>--%>

<%--									<!-- loop over and print our  -->--%>
<%--									<c:forEach var="tempMatches" items="${matches}">--%>

<%--										<!-- construct an "update" link with  id -->--%>
<%--										<c:url var="updateLink" value="/Matches/updateForm">--%>
<%--											<c:param name="customerId" value="${tempMatches.id}" />--%>
<%--										</c:url>--%>

<%--										<!-- construct an "delete" link with  id -->--%>
<%--										<c:url var="deleteLink" value="/Matches/delete">--%>
<%--											<c:param name="customerId" value="${tempMatches.id}" />--%>
<%--										</c:url>--%>

<%--										<c:url var="addResul" value="/Guess/showForm2">--%>
<%--											<c:param name="userId" value="${userInfo.id}" />--%>
<%--											<c:param name="matchId" value="${tempMatches.id}" />--%>
<%--										</c:url>--%>
<%--										<tr>--%>
<%--											<td>${tempMatches.homeTeam}</td>--%>
<%--											<td>${tempMatches.awayTeam}</td>--%>
<%--											<td>${tempMatches.homeGoal}</td>--%>
<%--											<td>${tempMatches.awayGoal}</td>--%>
<%--											<td>${tempMatches.status}</td>--%>
<%--											<td>--%>
<%--												<c:if test="${tempMatches.status==0}">--%>
<%--													<a style="color: red" href="#">End Match</a>--%>
<%--												</c:if>--%>

<%--												<c:if test="${tempMatches.status!=0}">--%>
<%--													<a style="color: #09176c" href="${addResul}">add resul</a>--%>
<%--												</c:if>--%>
<%--											</td>--%>
<%--										</tr>--%>
<%--									</c:forEach>--%>

<%--								</table>--%>

<%--							</div>--%>
<%--						</div>--%>
<%--					</div>--%>
<%--				</center>--%>

<%--			</div>--%>

<%--			&lt;%&ndash; list of my guesses&ndash;%&gt;--%>
<%--			<div >--%>
<%--				<h2>List Of Guess</h2>--%>
<%--				<hr />--%>

<%--				<input type="button" value="Add Guess"--%>
<%--					   onclick="window.location.href='showForm'; return false;"--%>
<%--					   class="btn btn-primary" />--%>
<%--				<br/><br/>--%>
<%--				<div class="panel panel-info">--%>
<%--					<div class="panel-heading">--%>
<%--						<div class="panel-title">List of Guess!</div>--%>
<%--					</div>--%>
<%--					<div class="panel-body">--%>
<%--						<table class="table table-striped table-bordered">--%>
<%--							<tr>--%>
<%--								<th>userId</th>--%>
<%--								<th>matchId</th>--%>
<%--								<th>guessHomeGoal</th>--%>
<%--								<th>guessAwayGoal</th>--%>
<%--								<th>score</th>--%>
<%--							</tr>--%>

<%--							<!-- loop over and print our customers -->--%>
<%--							<c:forEach var="tempGuess" items="${guess}">--%>


<%--							<c:if test = "${tempGuess.userId ==2}">--%>
<%--							<p>My salary is:  <p>--%>
<%--							</c:if>--%>


<%--							<!-- construct an "update" link with customer id -->--%>
<%--							<c:url var="updateLink" value="/Guess/updateForm">--%>
<%--								<c:param name="guessId" value="${tempGuess.id}" />--%>
<%--							</c:url>--%>

<%--							<!-- construct an "delete" link with customer id -->--%>
<%--							<c:url var="deleteLink" value="/Guess/delete">--%>
<%--								<c:param name="guessId" value="${tempGuess.id}" />--%>
<%--							</c:url>--%>

<%--							<tr>--%>
<%--								<td>${tempGuess.userId}</td>--%>
<%--								<td>${tempGuess.matchId}</td>--%>
<%--								<td>${tempGuess.guessHomeGoal}</td>--%>
<%--								<td>${tempGuess.guessAwayGoal}</td>--%>
<%--								<td>${tempGuess.score}</td>--%>

<%--								<td>--%>
<%--									<!-- display the update link --> <a href="${updateLink}">Update</a>--%>
<%--									| <a href="${deleteLink}"--%>
<%--										 onclick="if (!(confirm('Are you sure you want to delete this ?'))) return false">Delete</a>--%>
<%--								</td>--%>

<%--							</tr>--%>

<%--							</c:forEach>--%>

<%--						</table>--%>

<%--					</div>--%>
<%--				</div>--%>
<%--			</div>--%>
<%--		</div>--%>
<%--	</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

