package br.com.gt.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.gt.bean.ExameBean;
import br.com.gt.dao.Admin;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private ResultSet rs = null;
	private ExameBean bean = null;
	private List<ExameBean> beanList = null;
	private Admin admin = new Admin();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<ExameBean>();
			rs = admin.listarExames();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new ExameBean();
					bean.setSrNo(i);
					bean.setNome(rs.getString("nome"));
					bean.setIdade(rs.getInt("idade"));
					bean.setSexo(rs.getString("sexo"));
					bean.setDataNascimento(rs.getString("dataNascimento"));
					bean.setTelefone(rs.getString("telefone"));
					bean.setCpf(rs.getString("cpf"));
					bean.setNomeDoExame(rs.getString("nomeDoExame"));
					bean.setDataDoExame(rs.getString("dataDoExame"));
					bean.setHoraDoExame(rs.getString("horaDoExame"));
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

	public List<ExameBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<ExameBean> beanList) {
		this.beanList = beanList;
	}
}
