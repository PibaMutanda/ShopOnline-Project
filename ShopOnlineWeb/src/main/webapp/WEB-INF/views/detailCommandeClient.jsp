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
				<th>Montant Total</th>
			</tr>
			<c:forEach items="${commandes}" var="commande">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/detailAchatsClient.do?id=${commande.id}">${commande.totalCommande }</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>