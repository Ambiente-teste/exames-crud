<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro de Exames</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/cadastro-exame-estilo.css"/>" />
</head>
<body>
	<h2>Cadastro de Exames</h2>

	<div class="center-form">
		<a href="reportall"><button type="button">Listar Exames</button></a>
		<s:form action="registeruser.action" method="post" cssClass="width-full">
			<s:textfield label="Nome Exame" name="nomeDoExame" cssClass="width-full" />
			
			<s:textfield label="Data Do Exame" name="dataDoExame" cssClass="width-full" />
			
			<s:textfield label="Hora do Exame" name="horaDoExame" cssClass="width-full" />
			
			<s:textfield label="Nome Completo" name="nome" cssClass="width-full" />
			
			<s:textfield label="CPF" name="cpf" cssClass="width-full" />

			<s:textfield label="Idade" name="idade" cssClass="width-full" />

			<s:textfield label="Sexo" name="sexo" cssClass="width-full" />

			<s:textfield label="Data de Nasc." name="dataNascimento"
				cssClass="width-full" />

			<s:textfield label="Telefone" name="telefone" cssClass="width-full" />

			<s:submit cssClass="button-register" value="Cadastrar" />
		</s:form>
	</div>

	<s:if test="ctr>0">
		<span class="success-message"><s:property value="msg" /></span>
	</s:if>
	<s:if test="ctr==0">
		<span class="error-message"><s:property value="msg" /></span>
	</s:if>
</body>
</html>