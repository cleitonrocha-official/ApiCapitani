package com.capitani.teste.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.capitani.teste.util.JsonLocalDateDeserializer;
import com.capitani.teste.util.JsonLocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pedido {

	@Id
	private long numeroControle;

	@JsonSerialize(using = JsonLocalDateSerializer.class)
	@JsonDeserialize(using = JsonLocalDateDeserializer.class)
	private LocalDate dataCadastro = LocalDate.now();

	private String nome;

	private double valor;

	private long quantidade = 1;

	private long codigoCliente;

	private double valorTotal;

	public Pedido() {

	}

	public Pedido(long numeroControle, String nome, double valor, long codigoCliente) {
		this.numeroControle = numeroControle;
		this.nome = nome;
		this.valor = valor;
		this.codigoCliente = codigoCliente;
	}

	public long getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(long numeroControle) {
		this.numeroControle = numeroControle;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
