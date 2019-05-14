package br.com.gt.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.gt.bean.ExameBean;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ExameServer {

	@WebMethod
	ExameBean obterExamePorCpf(String cpf);

}
