<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%@ page language="java"%>
<%
	String username = (String) session.getAttribute("usuario_nome_sessao");

	if (username == null)
		username = "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/funcoes.js"></script>

	<script>
		function carregar(pagina) {
			$("#conteudo").load(pagina);
		}
	</script>

	<div class="container-fluid">

		<div class="row">
			<div class="col-md-6">
				<font class="texto_logo_telaprincipal">OpenCalls</font> <font
					class="">free</font>

			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-4">
				<b>Usuário:</b>&nbsp;&nbsp;&nbsp;<%=username%>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-8">
				<b>Solicitando novo chamado para:</b> MicroCompany
			</div>
		</div>
	<br />
	<div class="row">
		<div class="col-md-5">
		
	
		<form id="form2" method="get" action="ContatoServlet">

			<div class="form-group">
				<label for="exampleInputSetor">Para qual departamento da Empresa?</label> <br />
				<select name="setor">
					<option value="2">2 - Centro de Tecnologia da Informação</option>
				</select> &nbsp;&nbsp;&nbsp;&nbsp; 
			</div>
				
			<div class="form-group">
				<label for="exampleInputCategoria">Escolha um tipo de serviço deste departamento?</label><br />
				<select name="categoria">
					<option value="1">1 - Suporte Equipamentos</option>
					<option value="2">2 - Suporte Software</option>

				</select>
			</div>
			
			<div class="form-group">
				<label for="exampleInputAssunto">Titulo do seu problema:</label> <input type="text"
					class="form-control" name="txt_assunto" placeholder="Ex: Não estou conseguindo abrir o word">
			</div>
	
			<div class="form-group">
				<label for="exampleInputMensagem">Qual seu problema?</label>
				<textarea class="form-control" rows="3" name="txt_mensagem"></textarea>
			</div>
			
			<input type="button" onclick="novoTicketFormFunction()"
				value="Salvar"> <input type="reset" value="Limpar">
		</form>
			</div>
	</div>
		
	</div>
</body>
</html>



