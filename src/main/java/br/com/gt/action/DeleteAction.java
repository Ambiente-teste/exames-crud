package br.com.gt.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.gt.dao.Admin;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String cpf; 
	private Admin dao = new Admin();

	@Override
	public String execute() throws Exception {
		try {
			dao.removerExame(cpf);
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
}