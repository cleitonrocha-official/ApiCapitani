package com.capitani.teste.bussines;

import com.capitani.teste.entities.Pedido;

public abstract class RegraDeDesconto {

	protected Pedido pedido;
	
	private RegraDeDesconto proximaDesconto;

	public RegraDeDesconto(Pedido pedido) {
		this.pedido = pedido;
	}

	public void verificaRegra() {
		if (temDesconto())
			executaEstaRegra();
		else
			executaRegraDoProximoDesconto(proximaDesconto);

	}
	
	public void setProximaRegra(RegraDeDesconto proximaRegra) {
		this.proximaDesconto = proximaRegra;
	}
	
	
	private void executaEstaRegra() {
		pedido.setValorTotal(calculoDesconto());
	}
	
	private double calculoDesconto() {
		return pedido.getValor() - (pedido.getValor() * valorDesconto());
	};
	
	private void executaRegraDoProximoDesconto(RegraDeDesconto proximDesconto) {
		proximDesconto.verificaRegra();
	}
	
	abstract boolean temDesconto();	
	
	abstract double valorDesconto();

	public Pedido getPedido() {
		return pedido;
	}
	
	
	
	

}
