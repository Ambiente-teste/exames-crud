<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro de Paciente</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/cadastro-paciente-estilo.css"/>" />
</head>
<body>
	<h2>Cadastro de Pacientes</h2>

	<div class="center-form">
		<a href="reportall"><button type="button">Listar
				Pacientes</button></a>
		<s:form action="registeruser.action" method="post" cssClass="width-full">
			<s:textfield label="Nome Completo" name="nome" cssClass="width-full" />

			<s:textfield label="Idade" name="idade" cssClass="width-full" />

			<s:textfield label="Sexo" name="sexo" cssClass="width-full" />

			<s:textfield label="Data de Nasc." name="dataNascimento"
				cssClass="width-full" />

			<s:textfield label="Email" name="email" cssClass="width-full" />

			<s:textfield label="Telefone" name="telefone" cssClass="width-full" />

			<s:textfield label="CPF" name="cpf" cssClass="width-full" />
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