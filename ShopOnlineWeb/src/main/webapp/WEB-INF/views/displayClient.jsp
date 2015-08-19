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
	<c:if test="${not empty client }">
		<table class="table table-condensed">
			<tr class="info">
				<th>Pr&eacute;nom</th>
				<th>Nom</th>
				<th>E-mail</th>
				<th>Rue</th>
				<th>Code postal</th>
				<th>Localit&eacute;</th>
				<th>Date inscription</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr class="info">
				<td>${client.prenom }</td>
				<td>${client.nom }</td>
				<td>${client.email }</td>
				<td>${client.rue }</td>
				<td>${client.cp }</td>
				<td>${client.localite }</td>
				<td>${client.dateInscription }</td>
				<td><a
					href="${pageContext.request.contextPath}/updateClient.do?id=${client.id}"><span
						class="glyphicon glyphicon-pencil" title="Modifier l'utilisateur"></span></a></td>
				<td><a
					href="${pageContext.request.contextPath}/deleteClient.do?id=${client.id}"
					onclick="return(confirm('Voulez-vous vraiment supprimer le client sélectionné ?'))"><span
						class="glyphicon glyphicon-remove" title="Supprimer l'utilisateur"></span></a></td>
				<td><a
					href="${pageContext.request.contextPath}/showAchatClient.do?id=${client.id}"
					title="Voir ses achats"><span
						class="glyphicon glyphicon-eye-open  glyphicon glyphicon-shopping-cart"></span>
				</a></td>
			</tr>
		</table>
	</c:if>
	<c:if test="${not empty clientModif }">
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/updateClient.do">
			<div class="form-group">
				<input type="text" class="form-control" name="nom"
					value="${clientModif.nom }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="prenom"
					value="${clientModif.prenom }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="email"
					value="${clientModif.email }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="rue"
					value="${clientModif.rue }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="cp"
					value="${clientModif.cp }">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="localite"
					value="${clientModif.localite }">
			</div>
			<div>
			Bloquer
			</div>
			<label class="radio-inline"> <input type="radio"
				name="indesiderable" id="inlineRadio3" value="true"> Oui
			</label> <label class="radio-inline"> <input type="radio"
				name="indesiderable" id="inlineRadio3" value="false"> Non
			</label><br> <br> <input type="hidden" name="id"
				value="${clientModif.id }">
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</c:if>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>