<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste pulls</title>
</head>
<body>
<div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des pulls
 </div>
 <div class="card-body">

 <table class="table table-striped">
 <tr>
<th>ID</th><th>Nom pull</th><th>Prix</th><th>Date
Fabrication</th><th>Matiere<th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${pulls}" var="p">
 <tr>
 <td>${p.idPull }</td>
 <td>${p.mrquePull }</td>
 <td>${p.prixPull }</td>
 <td>${p.Matiere }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.dateFabrication}" /></td>
 	<td><a onclick="return confirm('Etes-vous s�r ?')"
href="supprimerpull?id=${p.idPull }">Supprimer</a></td>
 	<td><a href="modifierpull?id=${p.idPull }">Edit</a></td>
 	</tr>
 	</c:forEach>
 	</table>
 	</div>
	</div>
	</div>
</body>
</html>