<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<ul class="nav nav-pills nav-stacked">
		<li role="presentation"><a
			href="${pageContext.request.contextPath}/clientServletRegister.do">S'inscrire</a></li>
		<li role="presentation"><a
			href="${pageContext.request.contextPath}/articleServletRegister.do">Ajout
				Article</a></li>
		<li role="presentation"><a
			href="${pageContext.request.contextPath}/categorieServletRegister.do">Ajout
				Cat&eacute;gorie</a></li>
		<li role="presentation"><a
			href="${pageContext.request.contextPath}/displayListCateg.do">Modifier
				ou Supprimer un article</a></li>
	  <li role="presentation"><a
			href="${pageContext.request.contextPath}/searchClientServlet.do">Clients</a></li>		
	 <li><a href="${pageContext.request.contextPath}/commandeEnAttente.do">Liste des commandes en attentes</a></li>		
	</ul>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>