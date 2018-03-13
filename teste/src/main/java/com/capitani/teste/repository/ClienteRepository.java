package com.capitani.teste.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.repository.CrudRepository;
import com.capitani.teste.entities.Cliente;
import com.capitani.teste.entities.Pedido;
import com.capitani.teste.entities.Resposta;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	default List<Pedido> validaCliente(List<Pedido> pedidos, Resposta resposta) {

		pedidos.forEach(p -> {
			if(p.getCliente() == null)
				resposta.addErro("Erro ao salvar 'Pedido' Num. " + p.getNumeroControle() + " - Cliente nulo ou indefinido");
				else {
			if (existCliente(p))
				p.setCliente(this.findOne(p.getCliente().getCodigoCliente()));
			else
				resposta.addErro("Erro ao salvar 'Pedido' Num " + p.getNumeroControle() + " - Cliente ["
						+ p.getCliente().getCodigoCliente() + "] não esta cadastrado no Banco De Dados");
		}

		});
		pedidos = pedidos.stream().filter(this::existCliente).collect(Collectors.toList());
		pedidos.forEach(p -> save(p.getCliente()));

		return pedidos;
	}

	default boolean existCliente(Pedido p) {
		
		return exists(p.getCliente().getCodigoCliente());
	}

}
