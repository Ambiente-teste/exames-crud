<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Lista de Paciente</title>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/css/report-style.css"/>" />
</head>
<body>
	<h2>Lista de Pacientes</h2>
	<a href="/exames-crud"><button class="button-new" type="button">Cadastrar
			novo Paciente</button></a>
	<div>
		<table>
			<thead>
				<tr class="title">
					<th>No.</th>
					<th>Nome</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Data de Nascimento</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>CPF</th>
					<th>Ação</th>
				</tr>
			</thead>
			<s:iterator value="beanList">
				<tr>
					<td><s:property value="srNo" /></td>
					<td><s:property value="nome" /></td>
					<td><s:property value="idade" /></td>
					<td><s:property value="sexo" /></td>
					<td><s:property value="dataNascimento" /></td>
					<td><s:property value="email" /></td>
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