package br.com.gt.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gt.bean.PacienteBean;
import br.com.gt.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ResultSet rs = null;
	private PacienteBean bean = null;
	private List<PacienteBean> beanList = null;
	private Admin admin = new Admin();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<PacienteBean>();
			rs = admin.listarPacientes();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new PacienteBean();
					bean.setSrNo(i);
					bean.setNome(rs.getString("nome"));
					bean.setIdade(rs.getInt("idade"));
					bean.setSexo(rs.getString("sexo"));
					bean.setDataNascimento(rs.getString("dataNascimento"));
					bean.setEmail(rs.getString("email"));
					bean.setTelefone(rs.getString("telefone"));
					bean.setCpf(rs.getString("cpf"));
					beanList.add(bean);
				}
			}
						
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<PacienteBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PacienteBean> beanList) {
		this.beanList = beanList;
	}
}
