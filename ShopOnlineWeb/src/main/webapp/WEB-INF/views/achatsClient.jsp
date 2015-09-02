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
 ${erreur }<br>
 </c:forEach>
<c:if test="${not empty achats }">
	<table class="table table-striped">
		<tr>
			<th>Date achats</th>
			<th>Nombre d'articles achet&eacute;s</th>
			<th>Totaux Achats</th>
		</tr>
		<c:forEach items="${achats }" var="achat">
			<tr>
				<td><a
					href="${pageContext.request.contextPath}/detailCommandesClient.do?id=${achat.id}"
					title="Voir montant  total">${achat.dateAchat }</a></td>
				<td>${achat.quantiteAchat }</td>
				<td>${achat.totalAchat }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>	
	<c:if test="${not empty articles }">
		<table class="table table-hover">
			<tr>
			    
				<th>Cat&eacute;gorie</th>
				<th>Article</th>
				<th>Prix</th>
			</tr>
			<c:forEach items="${articles }" var="article">
				<tr>
					<td>${article.categ.nom}</td>
					<td>${article.denomination }</td>
					<td>${article.prix}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>