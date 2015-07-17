<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/style.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<title><decorator:title>Schop OnLine</decorator:title></title>
<decorator:head></decorator:head>
</head>
<body>
<div>
<header>
<%@include file="/WEB-INF/includes/header.jsp"%>
</header>
</div>
<div>
<article>
<menu>
<%@include file="/WEB-INF/includes/menu.jsp"  %>
</menu>
<decorator:body />
</article>
</div>
<div>
<footer>
	<%@include file="/WEB-INF/includes/footer.jsp" %>
</footer>
</div>
</body>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script
	src="resources/js/bootstrap.min.js"></script>
</html>