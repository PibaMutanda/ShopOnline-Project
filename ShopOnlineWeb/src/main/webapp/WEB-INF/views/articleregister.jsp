<%@page import="java.util.ArrayList"%>
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

	<div id="msgError">
		<c:forEach items="${messageErrors }" var="message">
   ${message } <br>
		</c:forEach>
	</div>
	<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/articleServletRegister.do">
		<div class="form-group">
			<label for="inputCateg" class="col-sm-2 control-label">Cat&eacute;gorie
				*</label>
			<div class="col-sm-10">
				<select name="categ" class="form-control" id="inputCateg"
					required="required">
					<option value="">Choix</option>
					<c:forEach items="${categories }" var="categ">
						<option value="${categ.id }">${categ.nom }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputNom" class="col-sm-2 control-label">Nom
				article *</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="inputNom"
					placeholder="Nom article" name="article" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPrix" class="col-sm-2 control-label">Prix </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="inputPrix"
					 name="prix">
			</div>
		</div>
		<div class="form-group">
			<label for="inputQteTotale" class="col-sm-2 control-label">Quantit&eacute; Totale</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="inputQteTotale"
					 name="qteTotale">
			</div>
		</div>
		<div class="form-group">
			<label for="inputVente" class="col-sm-2 control-label">Mettre
				En Vente</label>
			<div class="col-sm-10">
				<input type="radio" class="form-control" id="inputVente"
					name="enVente" value="1"> Oui <input type="radio"
					class="form-control" id="inputVente" name="enVente" value="0"> Non
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