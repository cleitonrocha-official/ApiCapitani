package com.capitani.teste.bussines;

import com.capitani.teste.entities.Pedido;

public class DescontoCincoPorCento extends RegraDeDesconto {

	public DescontoCincoPorCento(Pedido pedido) {
		super(pedido);

	}

	@Override
	public boolean temDesconto() {
		return pedido.getQuantidade() > 5 && pedido.getQuantidade() < 10;

	}

	@Override
	double valorDesconto() {
		return 0.05;
	}

}
