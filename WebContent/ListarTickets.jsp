<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%
	String username = (String) session.getAttribute("usuario_nome_sessao");

	if (username == null)
		username = "";
%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Central de atendimento</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<font class="texto_logo_telaprincipal">OpenCalls</font> <font
					class="">free</font>

			</div>
			
		</div>
		
		<div class="row">
			<div class="col-md-4">
				<b>Canal da Empresa: </b>&nbsp;&nbsp;&nbsp;MicroCompany
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<b>Bem vindo:</b>&nbsp;&nbsp;&nbsp;<%=username%> 
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">

				<tr>
					<td><a href="NovoTicket.jsp">|Novo</a></td>
					<td><a href="ListaTicket">|Abertos</a></td>
					<td><a href="#x">|Histórico</a></td>
					<td><a href="SairServlet">|Logout|</a></td>
				</tr>
			</div>
		</div>
		
		
		<h3 >CHAMADOS EM ABERTO</h3>
		<div class="row" id="p2row3">

			<c:forEach var="t" items="${lista}">
				<div class=" col-md-4 col-xs-12" id="p2colpesq">
					
						<b>Numero do chamado:</b>&nbsp;${t.idTicket}
						<br />
						<b>Problema:</b>&nbsp;&nbsp;${t.assunto}<br />			
						<b>Data:</b>&nbsp;&nbsp;<fmt:formatDate pattern="dd/MM/yyyy"
								value="${t.dataCriacao.time}" /><br />

						<b>Situação: </b>&nbsp;&nbsp;&nbsp;&nbsp; Aguardando sua resposta
						<br />
						<a href="#"
							onclick="window.open('AbrirTicketServlet?idTicketRow=${t.idTicket}', '_blank','menubar=no')" style="float: right;">Abrir</a>
						
				</div>
			</c:forEach>
		</div>
		
		</div>
		
</body>
</html>