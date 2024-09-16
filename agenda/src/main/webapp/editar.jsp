<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%
JavaBeans contato = (JavaBeans) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link rel="icon" href="assets/icon.svg">
<link rel="stylesheet" href="style.css?v=1.0">
</head>
<body class="page-form">
	<div class="container">
		<form name="formContato" action="update" class="contact-form">
			<h2>Editar Contato</h2>

			<div class="form-group">
				<input type="hidden" name="id" value="<%=contato.getId()%>">
			</div>

			<div class="form-group">
				<input type="text" name="nome" value="<%=contato.getNome()%>">
				<span class="error-message" id="nomeError"></span>
			</div>

			<div class="form-group">
				<input type="text" name="fone" value="<%=contato.getFone()%>">
				<span class="error-message" id="foneError"></span>
			</div>

			<div class="form-group">
				<input type="text" name="email" value="<%=contato.getEmail()%>">
				<span class="error-message" id="emailError"></span>
			</div>

			<div class="form-actions">
				<input type="button" value="Editar" onclick="validar()"
					class="button"> <a href="main" class="link">Voltar</a>
			</div>
		</form>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>
