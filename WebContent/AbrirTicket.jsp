<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%
	//String assunto = (String) request.getAttribute("assunto");
	//String setor = (String) request.getAttribute("setor");
	//String categoria = (String) request.getAttribute("categoria");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ticket</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/funcoes.js"></script>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label for="numerochamado">Chamado:</label><br /> <font><b>Número:</b>12334
						<b>Data:</b> 23/01/2016 <b>Hora:</b>13:51 </font>

				</div>
			</div>		
		
			<div class="col-md-3">
				<div class="form-group">
					<label for="nomedaempresa">Solicitação de suporte a
						Empresa: </label> <br /> <font>Microcompany</font>

				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label for="exampleInputAssunto">Departamento responsável:</label>
					<br /> <font>${setor}</font>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label for="exampleInputAssunto">Tipo do serviço:</label> <br /> <font>${categoria}</font>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label for="exampleInputAssunto">Titulo do problema:</label><br />
					<font>${assunto}</font>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label for="exampleInputAssunto">Descrição:</label><br />
					<font>${mensagem}</font>
				</div>
			</div>
		</div>

		<br />
		<div class="row" style="margin-bottom: 10px;">
			<div class="col-md-4 col-md-offset-1">
				<button id="bntmensagem"  type="button" onclick="Mudarestado('minhaDiv')" >mostrar mensagens</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6 col-md-offset-1" id="minhaDiv" style="background-color: white; padding: 20px 20px 20px 20px;">
				<c:forEach var="t" items="${lista}">
					<div class="row">

						<div class="col-md-1 col-xs-2" >
							<img src="images/welton.jpg" class="imagemhistorico">
						</div>

						<div class="col-md-6 col-xs-6" style="font-family: monospace;">
							<font>${t.fkidusuario}</font> <font>${t.textodialogo}</font>
						</div>
					</div>
					<hr />
					<br />
				</c:forEach>
			</div>
		</div>



		<div class="row">
			<div class="col-md-6">
				<form id="myForm" method="post" action="SalvarDialogoTextoServlet"
					onsubmit="return confirmacao()">
					<div class="form-group">
						<label for="exampleInputMensagem">Mensagem:</label>
						<textarea class="form-control" rows="3" name="txt_mensagem"
							required></textarea>
					</div>
				</form>
			</div>
		</div>

		<div id="row">
			<div id="col-md-4 col-md-offset-4">
				<input type="button" onclick="abrirTicketFunction()" value="Salvar">
				<input type="reset" value="Cancelar" /><br />
			</div>

		</div>
	</div>
</body>
</html>