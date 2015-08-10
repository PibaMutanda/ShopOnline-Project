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
	<div id="msgError">
		<c:forEach items="${messageErrors }" var="message">
   ${message } <br>
		</c:forEach>
	</div>
	<form class="form-horizontal" method="post"
		action="${pageContext.request.contextPath}/clientServletRegister.do">
		<div class="form-group">
			<label for="inputNom" class="col-sm-2 control-label">Nom *</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputNom"
					placeholder="Nom" name="nom">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPrenom" class="col-sm-2 control-label">Pr&eacute;nom
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputPrenom"
					placeholder="Prénom" name="prenom">
			</div>
		</div>
		<div class="form-group">
				<label for="inputRue" class="col-sm-2 control-label">Rue *</label>
					<div class="col-sm-10">
				<input type="text" class="form-control" id="inputRue"
					placeholder="Rue" name="rue">
			</div>
			</div>
			<div class="form-group">
				<label for="inputLocalite" class="col-sm-2 control-label">Localit&eacute; *</label>
				<div class="col-sm-10">
				<input type="text" class="form-control" id="inputLocalite"
					placeholder="Localité" name="localite">
			</div>
			</div>
			<div class="form-group">
				<label for="inputCp" class="col-sm-2 control-label">Code Postal *</label> <div class="col-sm-10">
				<input type="number" class="form-control" id="inputCp"
					 name="cp">
			</div>
			</div>
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Email
				*</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email" name="email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password
				*</label>
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
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>