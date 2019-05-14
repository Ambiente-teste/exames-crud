package br.com.gt.action;

import java.sql.ResultSet;

import br.com.gt.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = -1905974197186620917L;

	private String nome;
	private int idade;
	private String sexo;
	private String dataNascimento;
	private String email;
	private String telefone;
	private String cpf;
	private String cpfhidden;
	private String msg = "";
	private int ctr = 0;

	ResultSet rs = null;
	Admin dao = new Admin();
	String submitType;

	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.obterPacientePorCpf(cpf.trim());
				if (rs != null) {
					while (rs.next()) {
						nome = rs.getString("nome");
						idade = rs.getInt("idade");
						sexo = rs.getString("sexo");
						dataNascimento = rs.getString("dataNascimento");
						email = rs.getString("email");
						telefone = rs.getString("telefone");
						cpf = rs.getString("cpf");
					}
				}
			} else {
				ctr = dao.atualizarPaciente(nome, idade, sexo, dataNascimento,
						email, telefone, cpf, cpfhidden);
				if (ctr > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpfhidden() {
		return cpfhidden;
	}

	public void setCpfhidden(String cpfhidden) {
		this.cpfhidden = cpfhidden;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
}
