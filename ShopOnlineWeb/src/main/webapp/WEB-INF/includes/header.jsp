<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li><a class="navbar-brand"
						href="${pageContext.request.contextPath}/home.do"><span
							class="glyphicon glyphicon-home"></span> Shop Online</a></li>
					<li><a
						href="${pageContext.request.contextPath}/showCategories.do">Boutique</a></li>
				</ul>
			</div>

			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty sessionIdClient }">
							<li><a href="${pageContext.request.contextPath}/login.do"
								class="glyphicon glyphicon-log-in"></a></li>
						</c:when>
						<c:otherwise>
							<li><img src="${client.image }" alt="" class="img-circle"></li>
							<li>${client.prenom }</li>
							<li><a href="${pageContext.request.contextPath}/logout.do"
								class="glyphicon glyphicon-log-out"></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>

		</div>
	</nav>
	<br>
	<br>
	<br>
	<br>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>