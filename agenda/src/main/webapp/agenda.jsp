<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head> 
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="assets/icon.svg">
<link rel="stylesheet" href="style.css" href="style.css?v=1.0">
</head>
<body class="page-list">
<div class="container">
    <h1>Agenda de Contatos</h1>
    <p>
        <a href="novo.html" class="button">Novo contato</a>
        <a href="report" class="button">Relatório</a>
        <a href=></a>
    </p>
    
    <!-- Envolver a tabela em um div com a classe contact-table-wrapper -->
    <div class="contact-table-wrapper">
        <table class="contact-table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Fone</th>
                    <th>Email</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <% for (JavaBeans bean : lista) { %>
                <tr>
                    <td><%=bean.getId()%></td>
                    <td><%=bean.getNome()%></td>
                    <td><%=bean.getFone()%></td>
                    <td><%=bean.getEmail()%></td>
                    <td>
                        <a class="button" href="select?id=<%=bean.getId()%>">Editar</a>
                        <a style="background-color: red;" class="button" href="javascript:confirmar(<%=bean.getId()%>)">Excluir</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

	<script src="scripts/confirmador.js"></script>
</body>

</html>