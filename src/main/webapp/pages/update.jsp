<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Atualização de Exame</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/atualizacao-exame-estilo.css"/>" />
</head>
</head>
<body>
	<h2>Atualização de Exame</h2>
	<form action=updatedetails method="post" class="center-form">

		<div class="margin-full">
			<b>Nome do Exame:</b> <input type="text" name="nomeDoExame"
				value='<s:property value="nomeDoExame"/>'><br>
		</div>
		
		<div class="margin-full">
			<b>Data do Exame:</b> <input type="text" name="dataDoExame"
				value='<s:property value="dataDoExame"/>'><br>
		</div>
		
		<div class="margin-full">
			<b>Hora do Exame:</b> <input type="text" name="horaDoExame"
				value='<s:property value="horaDoExame"/>'><br>
		</div>

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
			<b>Telefone:</b>
			<input type="text" name="telefone" value='<s:property value="telefone"/>'><br>
		</div>

		<div class="margin-full">
			<b>CPF:</b>
			<input type="text" name="cpf" value='<s:property value="cpf"/>'><br>
	    	<input type="hidden" name="cpfhidden" value='<s:property value="cpf"/>'><br>
		</div>
		
		<a href="reportall"><button class="button-listage" type="button">Listar Exames</button></a>
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