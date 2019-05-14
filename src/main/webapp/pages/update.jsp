<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Atualização de Paciente</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/atualizacao-paciente-estilo.css"/>" />
</head>
</head>
<body>
	<h2>Atualização de Pacientes</h2>
	<form action=updatedetails method="post" class="center-form">

		<div class="margin-full">
			<b>Nome Completo:</b> <input type="text" name="nome"
				value='<s:property value="nome"/>'><br>
		</div>

		<div class="margin-full">
			<b>Idade:</b> <input type="text" name="idade"
				value='<s:property value="idade"/>'><br>
		</div>

		<div class="margin-full">
			<b>Sexo:</b> <input type="text" name="sexo"
				value='<s:property value="sexo"/>'><br>
		</div>

		<div class="margin-full">
			<b>Data de Nasc.:</b>
			<input type="text" name="dataNascimento" value='<s:property value="dataNascimento"/>'><br>
		</div>

		<div class="margin-full">
			<b>Email:</b>
			<input type="email" name="email" value='<s:property value="email"/>'><br>
		</div>

		<div class="margin-full">
			<b>Telefone:</b>
			<input type="text" name="telefone" value='<s:property value="telefone"/>'><br>
		</div>

		<div class="margin-full">
			<b>CPF:</b>
			<input type="text" name="cpf" value='<s:property value="cpf"/>'><br>
	    	<input type="hidden" name="cpfhidden" value='<s:property value="cpf"/>'><br>
		</div>
		
		<button name="submitType" class="button-update" value="update" type="submit">Update</button>
	</form>
	
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: green;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>