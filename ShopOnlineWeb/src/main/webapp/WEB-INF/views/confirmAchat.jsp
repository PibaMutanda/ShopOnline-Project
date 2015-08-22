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

	<form action="${pageContext.request.contextPath}/confirmAchat.do"
		method="post">
		<table class="table table-striped">
			<tr>
				<th>D&eacute;nomination</th>
				<th>Quantit&eacute;</th>
				<th>Prix Unit</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${commandes }" var="commande" varStatus="statut">
				<c:forEach items="${articles }" var="article"
					begin="${statut.index }" end="${statut.index }">
					<tr>
						<td>${article.denomination }</td>
						<td><input type="text" value="${commande.quantite }"
							readonly="readonly" name="quantite"></td>
						<td>${article.prix }</td>
						<td><input type="text" value="${commande.totalCommande }"
							name="total" readonly="readonly"></td>
						<td><input type="hidden" name="id" value="${commande.id }"></td>
					</tr>
				</c:forEach>
			</c:forEach>
			<tr>
				<td><button type="submit" class="btn btn-primary">Acheter</button></td>
				<td><a>Annuler</a></td>
			</tr>
		</table>
	</form>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>