package com.capitani.teste.bussines;

import com.capitani.teste.entities.Pedido;

public class DescontoZero extends RegraDeDesconto {

	
	
	public DescontoZero(Pedido pedido) {
		super(pedido);
	}


	@Override
	public
	boolean temDesconto() {
		return true;
		
	}

	@Override
	double valorDesconto() {
		return 0;
	}
	
	

}
