package br.com.gt.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.gt.dao.Admin;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String nome;
	private int idade;
	private String sexo;
	private String telefone;
	private String cpf;
	private String dataNascimento;
	private String nomeDoExame;
	private String dataDoExame;
	private String horaDoExame;
	private String msg = "";
	private Admin admin = null;
	private int ctr = -1;

	@Override
	public String execute() throws Exception {
		admin = new Admin();

		try {
			ctr = admin.registrarExame(nome, idade, sexo, telefone, cpf, dataNascimento, nomeDoExame, dataDoExame,
					horaDoExame);
			if (ctr > 0) {
				msg = "Exame cadastrado com sucesso";
			} else {
				ctr = 0;
				msg = "Não foi possível cadastrar o exame";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

}