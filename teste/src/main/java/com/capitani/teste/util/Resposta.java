package com.capitani.teste.util;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Resposta {

	@JacksonXmlElementWrapper(localName = "sucessos")
	@JacksonXmlProperty(localName = "sucesso")
	private List<Object> sucessos = new ArrayList<Object>();

	@JacksonXmlElementWrapper(localName = "erros")
	@JacksonXmlProperty(localName = "erro")
	private List<Object> erros = new ArrayList<Object>();

	public Resposta addSucesso(Object object) {
		sucessos.add(object);
		return this;

	}

	public Resposta addErro(Object object) {
		erros.add(object);
		return this;
		
	}

	public List<Object> getSucessos() {
		return sucessos;
	}

	public void setSucessos(List<Object> sucessos) {
		this.sucessos = sucessos;
	}

	public List<Object> getErros() {
		return erros;
	}

	public void setErros(List<Object> erros) {
		this.erros = erros;
	}

}
