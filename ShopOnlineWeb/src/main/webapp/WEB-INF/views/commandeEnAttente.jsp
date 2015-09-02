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
	<table class="table table-striped">
		<tr>
			<th>Nom</th>
			<th>Pr&eacute;nom</th>
			<th>&Eacute;-mail</th>
			<th>Date Commande</th>
			<th>Nombre article</th>
			<th>Prix total</th>
			<th></th>
		</tr>
		<c:forEach items="${commandes }" var="commande">
			<c:if test="${empty commande.achat }"></c:if>
			<tr>
				<td>${commande.client.nom }</td>
				<td>${commande.client.prenom }</td>
				<td>${commande.client.email }</td>
				<td>${commande.dateCommande }</td>
				<td>${commande.quantite }</td>
				<td>${commande.totalCommande }</td>
				<td><a
					href="${pageContext.request.contextPath}/deleteCommandeClient.do?id=${commande.id}"
					onclick="return(confirm('Voulez-vous vraiment supprimer la commande sélectionné ?'))"><span
						class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>