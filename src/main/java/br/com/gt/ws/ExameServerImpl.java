package br.com.gt.ws;

import java.sql.ResultSet;

import javax.jws.WebService;

import br.com.gt.bean.ExameBean;
import br.com.gt.dao.Admin;

@WebService(endpointInterface = "br.com.gt.ws.Exame.Server")
public class ExameServerImpl implements ExameServer {

	@Override
	public ExameBean obterExamePorCpf(String cpf) {

		Admin dao = new Admin();
		ExameBean exameBean = new ExameBean();

		ResultSet rs;
		try {
			rs = dao.obterExamePorCpf(cpf.trim());

			if (rs != null) {
				while (rs.next()) {
					exameBean.setNome(rs.getString("nome"));
					exameBean.setIdade(rs.getInt("idade"));
					exameBean.setSexo(rs.getString("sexo"));
					exameBean.setDataNascimento(rs.getString("dataNascimento"));
					exameBean.setTelefone(rs.getString("telefone"));
					exameBean.setCpf(rs.getString("cpf"));
					exameBean.setNomeDoExame(rs.getString("nomeDoExame"));
					exameBean.setDataDoExame(rs.getString("dataDoExame"));
					exameBean.setHoraDoExame(rs.getString("horaDoExame"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exameBean;

	}

}
