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
	<form class="form-inline"
		action="${pageContext.request.contextPath}/updateServletArticle.do"
		method="post">
		<input type="hidden" name="id" value="${article.id }">
		<div class="form-group">
			<label for="inputDenomination">Nom</label> <input type="text"
				name="denomination" class="form-control"
				id="exampleInputDenomination" value="${article.denomination }">
		</div>
		<div class="form-group">
			<label for="inputQteTotale">Quantit&eacute; Totale</label> <input type="number" name="qteTotale"
				class="form-control" id="inputQteTotale" value="${article.qteTotale }">
		</div>
		<div class="form-group">
			<label for="inputPrix">Prix</label> <input type="number" name="prix"
				class="form-control" id="inputPrix" value="${article.prix }">
		</div>
		Mettre en Vente
		<div class="radio">
			<label> <input type="radio" name="enVente"
				id="optionsRadios1" value="0" checked> Nom
			</label>
		</div>
		<div class="radio">
			<label> <input type="radio" name="enVente"
				id="optionsRadios1" value="1"> Oui
			</label>
		</div>
		<button type="submit" class="btn btn-primary">Enregistrer</button>
	</form>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>