<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Preferencias</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/preferencias.css"/>">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
	<main class="container my-5">
		<div class="card shadow col-md-10 col-lg-8 mx-auto">
			<div class="card-header">
				<h3>Preferencias</h3>
			</div>
			<div class="card-body">
				<c:url value="/buscarPerfil" var="action"/>
				<form:form action="${action}" method="post" modelAttribute="preferencias">
					<div class="form-inline mb-3">
						<form:label path="razaIds" cssClass="mr-2">Raza:</form:label>
						<form:select path="razaIds" multiple="true" cssClass="custom-select">
							<form:option label="Seleccione raza" value="0"/>
							<form:options items="${razas}" itemLabel="nombre" itemValue="id" />
						</form:select>
					</div>
					<div class="form-inline mb-3">
						<form:label path="edades" cssClass="mr-2">Edad:</form:label>
						<form:input path="edades" type="number" min="1" max="${edadMaxima}" placeholder="Años" cssClass="form-control"/>
					</div>
					<div class="form-inline mb-3">
						<form:label path="generos" cssClass="mr-1">Género:</form:label>
						<div class="genero">
							<form:radiobuttons path="generos" items="${generos}"/>
						</div>
					</div>
					<div class="form-row mb-3 justify-content-center">
						<div class="w-100">
							<form:label id="ccasLabel" path="ccaIds" >Caracteristicas:</form:label>
						</div>
						<div class="column-container">
							<form:checkboxes path="ccaIds" items="${caracteristicas}" itemLabel="nombre" itemValue="id" element="small"/>
						</div>
					</div>
					<div class="form-row justify-content-end">
						<input type="reset" value="Limpiar" class="btn btn-danger mr-2"/>
						<input type="submit" value="Buscar pareja" class="btn btn-success mr-5"/>
					</div>
				</form:form>
			</div>
			<div class="card-footer d-flex justify-content-center">
				<a href="<c:url value="/"/>" class="btn btn-primary mr-3">Ir a Inicio</a>
				<a href="<c:url value="/perfiles"/>" class="btn btn-primary">Ver todos los perfiles</a>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>