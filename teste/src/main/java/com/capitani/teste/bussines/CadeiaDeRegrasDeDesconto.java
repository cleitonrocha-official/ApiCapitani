package com.capitani.teste.bussines;

import java.util.ArrayList;
import java.util.List;

import com.capitani.teste.entities.Pedido;

public class CadeiaDeRegrasDeDesconto {

	//Padrão de Projeto Chain Responsibility
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	public CadeiaDeRegrasDeDesconto(List<Pedido> pedidos) {
		pedidos.forEach(this::construirRegra);
	
	}

	private void construirRegra(Pedido pedido) {
		DescontoCincoPorCento d1 = new DescontoCincoPorCento(pedido);
		DescontoDezPorCento d2 = new DescontoDezPorCento(pedido);
		DescontoZero d3 = new DescontoZero(pedido);
		
		d1.setProximaRegra(d2);
		d2.setProximaRegra(d3);
		d1.verificaRegra();
		
		this.pedidos.add(pedido);
	}
	
	public List<Pedido> getReuslt(){
		return this.pedidos;
	}
	
}
