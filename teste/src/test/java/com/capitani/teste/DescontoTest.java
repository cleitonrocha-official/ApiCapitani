package com.capitani.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capitani.teste.bussines.DescontoCincoPorCento;
import com.capitani.teste.bussines.DescontoDezPorCento;
import com.capitani.teste.bussines.DescontoZero;
import com.capitani.teste.entities.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DescontoTest {

	final double valor = 1000;
	
	@Before
	public void preparaEntidade() {
		
	}
	
	private Pedido populaPedido() {
		return new Pedido(10, "XBox", valor,15);
	}
	
	@Test
	public void tenqueDevolverCincoPorCentoDeDesconto() {
		
		Pedido pedido = populaPedido();
		pedido.setQuantidade(6);
		DescontoCincoPorCento desconto = new DescontoCincoPorCento(pedido);
		desconto.verificaRegra();
		assertEquals(calculoDesconto(0.05),desconto.getPedido().getValorTotal(),0.001);
		
		
	}
	
	@Test
	public void tenqueDevolverDezPorCentoDeDesconto() {
		
		Pedido pedido = populaPedido();
		pedido.setQuantidade(10);
		DescontoDezPorCento desconto = new DescontoDezPorCento(pedido);
		desconto.verificaRegra();
		assertEquals(calculoDesconto(0.1),desconto.getPedido().getValorTotal(),0.001);
		
		
	}
	
	@Test
	public void naoPoedeDevolverNenhumDeDesconto() {
		
		DescontoZero desconto = new DescontoZero(populaPedido());
		desconto.verificaRegra();
		assertEquals(valor,desconto.getPedido().getValorTotal(),0.001);
		assertNotEquals(calculoDesconto(0.1),desconto.getPedido().getValorTotal(),0.001);
		assertNotEquals(calculoDesconto(0.05),desconto.getPedido().getValorTotal(),0.001);
		
	}


	private double calculoDesconto(double desconto) {
		return valor - (valor*desconto);
	}
	
	
}
