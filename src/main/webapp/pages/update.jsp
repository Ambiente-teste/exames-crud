<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Lista de Paciente</title>
	<link rel="stylesheet" type="text/css" href="<s:url value="/css/cadastro-paciente-estilo.css"/>" />
</head>
<body>
	<h2>Atualização de Paciêntes</h2>
	<form action=updatedetails method="post">
		<pre>
			<b>Nome:</b>
			<input type="text" name="nome" value='<s:property value="nome"/>'>
			<b>Idade:</b>
			<input type="text" name="idade" value='<s:property value="idade"/>'>
			<b>Sexo:</b>
			<input type="text" name="sexo" value='<s:property value="sexo"/>'>
			<b>Data de Nascimento:</b>
			<input type="text" name="dataNascimento" value='<s:property value="dataNascimento"/>'>
			<b>Email:</b>
			<input type="email" name="email" value='<s:property value="email"/>'>
			<b>Telefone:</b>
			<input type="text" name="telefone" value='<s:property value="telefone"/>'>
			<b>CPF:</b>
			<input type="text" name="cpf" value='<s:property value="cpf"/>'>
		    <input type="hidden" name="cpfhidden" value='<s:property value="cpf"/>'>
		
			<button name="submitType" value="update" type="submit">Update</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>