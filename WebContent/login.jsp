<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<%
	String mensagem = (String) session.getAttribute("mensagem_sessao");
	if (mensagem == null)
		mensagem = "";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
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

	<div class="container">

		<div class="row">
			<div class="col-md-8">
				<font class="texto_logo">OpenCalls</font> &nbsp; <font class="">free</font>

			</div>
		</div>

		<div class="row" style="margin-top: 50px;">
			<form method="post" action="Login" class="form-inline">
				<div class="col-md-2">
					<div class="form-group">
						<label class="sr-only" for="exampleInputEmail3">Email </label> <input
							type="email" class="form-control" id="exampleInputEmail3"
							name="txt_email" placeholder="Email">
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label class="sr-only" for="exampleInputPassword3">Password</label>
						<input type="password" class="form-control"
							id="exampleInputPassword3" name="txt_senha"
							placeholder="Password">
					</div>
				</div>
				
				<div class="col-md-3">
					<button type="submit" class="btn btn-default">Entre</button>
					<a href="#">Esqueceu a conta?</a>
				</div>
			</form>
		</div>
	</div>

	<div class="row">
		<div class="col-md-6">
			<font style="color: red; font-size: 16px;"><%=mensagem%></font>
		</div>
	</div>

	<div class="row" style="margin-top: 60px;">

		<div class="col-md-6">
			<font class="font2">Criar uma nova conta Free</font>
			<form>
				<div class="form-group">
					<input type="text" class="form-control" id="inputNome"
						placeholder="Nome">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id="inputSobrenome"
						placeholder="Sobrenome">
				</div>

				<div class="form-group">
					<input type="email" class="form-control" id="inputEmail"
						placeholder="Celular ou email">
				</div>

				<div class="form-group">
					<input type="password" class="form-control" id="InputPassword"
						placeholder="Digite sua senha">
				</div>
				<div class="form-group">
					<input type="password" class="form-control"
						id="InputRepeatPassword" placeholder="repita sua senha">
				</div>
				<div class="form-group">
					<font class="termos"> Ao clicar em Criar conta, você
						concorda com nossos Termos e que leu nossa Política de Dados,
						incluindo nosso Uso de Cookies. Você pode receber notificações por
						SMS do OpenCalls e pode cancelar o recebimento a qualquer momento.
					</font>
				</div>


				<button type="submit" class="btn btn-default"
					style="background-color: #69a74e;">Criar conta</button>
			</form>

		</div>
	</div>

	<div class="row" style="margin-top: 50px;">
		<div class="col-md-6">
			<font class="font2">O que é o OpenCalls?</font>
			<p>OpenCalls é um sistema simples de abertura de chamados para
				autonomos ou pequenas empresas totalmente free online e sem
				burocracia!</p>
		</div>
	</div>
	
</body>
</html>