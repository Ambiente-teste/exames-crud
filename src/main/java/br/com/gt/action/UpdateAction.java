package br.com.gt.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import br.com.gt.dao.Admin;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = -1905974197186620917L;

	private String nome;
	private int idade;
	private String sexo;
	private String dataNascimento;
	private String telefone;
	private String cpf;
	private String cpfhidden;
	private String nomeDoExame;
	private String dataDoExame;
	private String horaDoExame;
	private String msg = "";
	private int ctr = -1;

	ResultSet rs = null;
	Admin dao = new Admin();
	String submitType;

	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.obterExamePorCpf(cpf.trim());
				if (rs != null) {
					while (rs.next()) {
						nome = rs.getString("nome");
						idade = rs.getInt("idade");
						sexo = rs.getString("sexo");
						dataNascimento = rs.getString("dataNascimento");
						telefone = rs.getString("telefone");
						cpf = rs.getString("cpf");
						nomeDoExame = rs.getString("nomeDoExame");
						dataDoExame = rs.getString("dataDoExame");
						horaDoExame = rs.getString("horaDoExame");
					}
				}
			} else {
				ctr = dao.atualizarExame(nome, idade, sexo, dataNascimento, telefone, cpf, cpfhidden, nomeDoExame,
						dataDoExame, horaDoExame);
				if (ctr > 0) {
					msg = "Atualizado com sucesso";
				} else {
					ctr = 0;
					msg = "Não foi possível atualizar";
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

	public String getNomeDoExame() {
		return nomeDoExame;
	}

	public void setNomeDoExame(String nomeDoExame) {
		this.nomeDoExame = nomeDoExame;
	}

	public String getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(String dataDoExame) {
		this.dataDoExame = dataDoExame;
	}

	public String getHoraDoExame() {
		return horaDoExame;
	}

	public void setHoraDoExame(String horaDoExame) {
		this.horaDoExame = horaDoExame;
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
