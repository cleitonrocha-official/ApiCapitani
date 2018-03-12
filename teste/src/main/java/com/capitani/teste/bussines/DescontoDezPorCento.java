package com.capitani.teste.bussines;

import com.capitani.teste.entities.Pedido;

public class DescontoDezPorCento extends RegraDeDesconto {

	public DescontoDezPorCento(Pedido pedido) {
		super(pedido);
	}

	@Override
	public boolean temDesconto() {
		return pedido.getQuantidade() >= 10;

	}

	@Override
	double valorDesconto() {
		return 0.1;
	}

}
