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
     <table class="table table-striped">
     <tr><th>D&eacute;nomination</th><th>Prix</th><th>Date achat</th><th>Quantité</th><th>Total</th></tr>
     <c:forEach items="${achats }" var="achat">
     <tr>
     <c:set  value="articles">${achat.commande.articles }</c:set>
     <c:forEach items="${articles }" var="article">
     <td>${article.denomination }</td><td>${article.prix }<c:set var="total" value="0.0"><c:out value="${total+article.prix }"></c:out> </c:set>  </td>
     </c:forEach>
     <td>${achat.dateAchat }</td><td>${achat.commande.quantite }</td>
     <td>${total }</td></tr>
     
     </c:forEach>
     </table>
</body>
<script src="${request.contextPath }resources/js/jquery.js"></script>
<script src="${request.contextPath }resources/js/jquery-ui.min.js"></script>
<script src="${request.contextPath }resources/js/bootstrap.min.js"></script>
</html>