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
	<h3>Choisir la catégorie de l'article</h3>
    <c:if test="${not empty categories }">
	<ul class="nav nav-pills nav-stacked">
		<c:forEach items="${categories }" var="categ">
			<li role="presentation"><a
				href="displayShopArticle.do?id=${categ.id }">${categ.nom }</a></li>
		</c:forEach>
	</ul>
	</c:if>
	<c:forEach items="${messageErrors }" var="erreur">
	${erreur } <br>
	</c:forEach>
	<c:if test="${not empty articles }">
		<form action="${pageContext.request.contextPath}/commandeArticle.do">
			<table class="table table-striped">
				<tr>
					<th>Quantit&eacute;s</th>
					<th>Articles</th>
					<th>Prix Unit</th>
				</tr>
				<c:forEach items="${articles }" var="article">
					<tr>
						<td><select name="quantite"><option value="0"
									selected="selected">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option></select></td>
						<td>${article.denomination }</td>
						<td>${article.prix }</td>
						<td><input type="hidden" name="id" value="${article.id }">
						</td>
					</tr>
				</c:forEach>
				<c:if test="${not empty sessionIdClient }">
					<tr>
						<td><button type="submit" class="btn btn-primary">Acheter</button></td>
					</tr>
				</c:if>
			</table>
		</form>
	</c:if>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>