package br.com.gt.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.gt.dao.Admin;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private String msg;
	private Admin dao = new Admin();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.removerExame(cpf);
			if (isDeleted > 0) {
				msg = "Exame removido com sucesso";
			} else {
				msg = "Não foi possível remover o exame";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}