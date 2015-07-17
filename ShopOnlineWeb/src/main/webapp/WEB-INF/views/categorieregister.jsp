<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
<div id="msgError">
	<c:forEach items="${messageErrors }" var="message">
   ${message } <br>
	</c:forEach>
</div>	
	<form action="CategorieServlet" method="post" class="form-inline">
		<div class="form-group">
			<label for="exampleInputName2">Nom Catégorie</label> <input
				type="text" class="form-control" id="exampleInputName2"
				placeholder="Catégorie" name="categ" required="required">
		</div>
		<button type="submit" class="btn btn-primary">Enregistrer</button>
	</form>
</body>
<script src="resources/js/jquery.js"></script>
<script
	src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>