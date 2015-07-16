<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css">
<title></title>
</head>
<body>
	<form class="form-horizontal" method="post" action="ClientServlet">
		<div class="form-group">
			<label for="inputNom" class="col-sm-2 control-label">Nom *</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputNom"
					placeholder="Nom" name="nom">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPrenom" class="col-sm-2 control-label">Pr&eacute;nom </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputPrenom"
					placeholder="Prénom" name="prenom">
			</div>
		</div>

		<div class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="inputRue">Rue *</label> <input type="text"
					class="form-control" id="inputRue" placeholder="Rue et Numéro"
					name="rue">
			</div>
			<div class="form-group">
				<label class="sr-only" for="inputLocalite">Localit&eacute; *</label> <input
					type="text" class="form-control" id="inputLocalite"
					placeholder="Localité" name="localite">
			</div>
			<div class="form-group">
				<label class="sr-only" for="inputCp">Code Postal *</label> <input
					type="text" class="form-control" id="inputCp"
					placeholder="Code Postal" name="cp">
			</div>

		</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Email *</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email" name="email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password *</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password" name="password">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassConf" class="col-sm-2 control-label">Confirmez
				le Password *</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassConf"
					placeholder="Confirmez le mot de passe" name="passwordConf">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Enregistrer</button>
			</div>
		</div>
	</form>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</html>