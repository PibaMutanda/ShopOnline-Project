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
	<c:forEach items="${messageErrors }" var="erreur">
  ${erreur }<br>
	</c:forEach>
	<form action="${pageContext.request.contextPath}/login.do"
		method="post" class="form-horizontal">
		<div class="form-group">
			<label for="exampleInputEmail1">Addresse email </label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				placeholder="Email" name="email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password" name="password">
		</div>

		<div class="checkbox">
			<label> <input type="checkbox" name="admin"> Admin
			</label>
		</div>
		<button type="submit" class="btn btn-primary">
			<span class="glyphicon glyphicon-log-in"></span>
		</button>
	</form>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>