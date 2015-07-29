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
	<div class="table-responsive">
		<table class="table table-hover">
			<tr>
				<th>Nom</th>
				<th>Prix</th>
				<th>En Vente</th>
			</tr>
			<c:forEach items="${articles }" var="article">
				<tr>
					<td>${article.denomination }</td>
					<td>${article.prix }</td>
					<td><c:choose>
							<c:when test="${article.enVente eq 0 }">Nom</c:when>
							<c:when test="${article.enVente eq 1 }">Oui</c:when>
						</c:choose></td>
					<td><a
						href="${pageContext.request.contextPath}/updateServletArticle.do?id=${article.id}"><span
							class="glyphicon glyphicon-pencil" title="Modifier l'article"></span></a></td>
					<td><a
						href="javascript:deleteArticleFunction(${pageContext.request.contextPath}/deleteServletArticle.do?id=${article.id})"><span
							class="glyphicon glyphicon-remove" title="Supprimer l'article"></span></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script type="text/javascript">
	function deleteArticleFunction(delUrl) {
		if (confirm("Voulez-vous supprimer l'article sélectionné ?")) {
			document.location = delUrl;
		}
	}
</script>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>