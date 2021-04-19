<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Perfiles</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/perfiles.css"/>">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/aaf6652f81.js"></script>
    <script src="<c:url value="/resources/js/perfil.js"/>"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
	<main class="container mt-5">
		<c:choose>
			<c:when test="${empty perfiles}">
				<p class="alert alert-danger">No se encontraron perfiles</p>
			</c:when>
			<c:when test="${perfiles.size() eq 1}">
				<div class="container col-md-10 col-lg-8">
					<h1>Pareja Perfecta!</h1>
					<%@ include file="/WEB-INF/jspf/perfilcard.jspf" %>
				</div>
			</c:when>
			<c:otherwise>
				<h1 class="text-center mb-4">${perfiles.size()} Perfiles</h1>
				<div class="card-columns">
					<%@ include file="/WEB-INF/jspf/perfilcard.jspf" %>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="d-flex justify-content-center mt-5">
			<a href="<c:url value="/buscarPerfil"/>" class="btn btn-primary mr-2">Volver a buscar</a>
			<a href="<c:url value="/"/>" class="btn btn-primary">Ir a inicio</a>
		</div>
	</main>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>