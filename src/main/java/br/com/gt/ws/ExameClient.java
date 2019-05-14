package br.com.gt.ws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

public class ExameClient {
	public static void main(String args[]) throws Exception {
		Endpoint.publish("http://127.0.0.1:8080/exames-crud/exame", new ExameServerImpl());
		
		URL url = new URL("http://127.0.0.1:8080/exames-crud/exame?wsdl");
		QName qname = new QName("http://ws.gt.com.br/", "CalculadoraServerImplService");
		Service ws = Service.create(url, qname);
		ExameServer calc = ws.getPort(ExameServer.class);

		System.out.println(calc.obterExamePorCpf("11641379642"));
	}
}
