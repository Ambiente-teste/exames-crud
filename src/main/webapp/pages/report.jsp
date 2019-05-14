<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Lista de Exame</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/listagem-exame-estilo.css"/>" />
</head>
<body>
	<h2>Lista de Exame</h2>
	<a href="/exames-crud"><button class="button-new" type="button">Cadastrar
			novo Exame</button></a>
	<div>
		<table>
			<thead>
				<tr class="title">
					<th>No.</th>
					<th>Exame</th>
					<th>Data do Exame</th>
					<th>Hora do Exame</th>
					<th>Nome</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Data de Nasc</th>
					<th>Telefone</th>
					<th>CPF</th>
					<th>Ação</th>
				</tr>
			</thead>
			<s:iterator value="beanList">
				<tr>
					<td><s:property value="srNo" /></td>
					<td><s:property value="nomeDoExame" /></td>
					<td><s:property value="dataDoExame" /></td>
					<td><s:property value="horaDoExame" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="idade" /></td>
					<td><s:property value="sexo" /></td>
					<td><s:property value="dataNascimento" /></td>
					<td><s:property value="telefone" /></td>
					<td><s:property value="cpf" /></td>
					<td><a
						href="updatedetails.action?submitType=updatedata&cpf=<s:property value="cpf"/>">
							<button class="button-update">Update</button>
					</a> <a href="deleterecord.action?cpf=<s:property value="cpf"/>">
							<button class="button-delete">Delete</button>
					</a></td>
				</tr>
			</s:iterator>
		</table>

		<s:if test="noData==false">
			<div class="noData">Nenhum dado encontrado</div>
		</s:if>
	</div>
</body>
</html>