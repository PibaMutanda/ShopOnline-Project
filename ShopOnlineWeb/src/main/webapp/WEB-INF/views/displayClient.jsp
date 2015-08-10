<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">

<title></title>
</head>
<body>
	<c:forEach items="${messageErrors }" var="erreur">
${erreur } <br>
	</c:forEach>
	<form class="navbar-form navbar-left" role="search" method="post"
		action="${pageContext.request.contextPath}/searchClientServlet.do">
		<div class="form-group">
			<input type="email" class="form-control"
				placeholder="Search By Email" name="email">
		</div>
		<button type="submit" class="btn btn-default">
			<span class="glyphicon glyphicon-search"></span>
		</button>
	</form>
</body>
<c:if test="${not empty client }">
	<table class="table table-condensed">
		<tr class="info">
			<th>Pr&eacut;nom</th>
			<th>Nom</th>
			<th>E-mail</th>
			<th>Rue</th>
			<th>Code postal</th>
			<th>Localit&eacut;</th>
			<th>Date inscription</th>
		</tr>
		<tr class="info">
			<td>${client.prenom }</td>
			<td>${client.nom }</td>
			<td>${client.email }</td>
			<td>${client.rue }</td>
			<td>${client.cp }</td>
			<td>${client.localite }</td>
			<td>${client.dateInscription }</td>
		</tr>
	</table>
</c:if>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>