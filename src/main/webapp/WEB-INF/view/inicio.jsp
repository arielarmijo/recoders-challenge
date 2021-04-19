<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Amores Caninos</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/tarjetas.css"/>">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/aaf6652f81.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf"%>
	<main class="jumbotron">
		<div class="bg-image">
			<div class="mask">
				<div>
					<h1>Amores Caninos</h1>
					<p>El tinder para perritos</p>
					<div class="contenedor-tarjetas">
						<a href="<c:url value="/buscarPerfil"/>" class="tarjeta">
							<i class='fas fa-heart'></i>
							<span>Buscar Pareja</span>
							<i class='fas fa-angle-right'></i>
						</a>
						<a href="<c:url value="/perfiles"/>" class="tarjeta">
							<i class='fas fa-dog'></i>
							<span>Ver Perfiles</span>
							<i class='fas fa-angle-right'></i>
						</a>
					</div>
				</div>

			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>