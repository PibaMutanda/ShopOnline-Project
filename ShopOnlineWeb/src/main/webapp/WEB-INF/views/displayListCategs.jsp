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
	<ul class="nav nav-pills nav-stacked">
		<c:forEach items="${listCateg }" var="categ">
			<li role="presentation"><a class="navbar-brand"
				href="displayListArticle.do?id=${categ.id }">${categ.nom }</a></li>
		</c:forEach>
	</ul>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>