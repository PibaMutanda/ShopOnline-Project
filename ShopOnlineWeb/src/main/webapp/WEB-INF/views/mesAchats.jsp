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
	<c:choose>
		<c:when test="${not empty mesAchats }">
			<table class="table table-striped">
				<tr>
					<th>D&eacute;nomination</th>
					<th>Prix</th>
					<th>Quantit&eacute;</th>
					<th>Total</th>
				</tr>
				<c:forEach items="${mesCommandes }" var="cmd" varStatus="status">
					<c:forEach items="${cmd.articles }" var="article"
						begin="${status.index }" end="${status.index }">
						<tr>
							<td>${article.denomination }</td>
							<td>${article.prix }</td>
					</c:forEach>
					<td>${cmd.quantite }</td>
					<td>${cmd.totalCommande }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>