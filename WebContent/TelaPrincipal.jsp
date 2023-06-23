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
<link href="https://fonts.googleapis.com/css?family=Pacifico|VT323"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
</head>
<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>

	<script>
		function carregar(pagina) {
			$("#conteudo").load(pagina);
		}

		String
		sValue = (String)
		request.getAttribute("chave");
		int
		iValue = Integer.parseInt(sValue);
	</script>

	<div class="container-fluid">

		<div class="row">
			<div class="col-sm-2" style="background-color: red; height: 300px;"></div>
			<div class="col-sm-8">

				<div class="row">
					<div class="col-sm-8 col-sm-offset-4">
						<font class="texto_logo_telaprincipal">OpenCalls</font> <font
							class="">free</font>

					</div>

				</div>

				<div class="row">
					<div class="col-sm-8 col-sm-offset-4">
						<b>Empresa:</b>MicroCompany &nbsp; &nbsp; <b>Cliente:</b><%=username%>
						<a href="SairServlet">|Sair|</a>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-8 col-sm-offset-4">

						<tr>
							<td><a href="NovoTicket.jsp">|Novo|</a></td>
							<td><a href="ListaTicket">|Chamados Abertos|</a></td>
							
						</tr>
					</div>
				</div>
			</div>
			<div class="col-sm-2" style="background-color: red; height: 300px;"></div>
		</div>




	</div>

</body>
</html>