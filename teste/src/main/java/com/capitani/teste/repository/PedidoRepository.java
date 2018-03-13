package com.capitani.teste.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capitani.teste.bussines.CadeiaDeRegrasDeDesconto;
import com.capitani.teste.entities.Pedido;
import com.capitani.teste.entities.Resposta;
import com.capitani.teste.util.LocalDateFormatter;


public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	@Query("SELECT p FROM Pedido p where p.dataCadastro = :data")
	List<Pedido> findByData(@Param("data") LocalDate data);

	@Query("SELECT p FROM Pedido p where p.cliente.codigoCliente = :codigo")
	List<Pedido> findbyCodClient(@Param("codigo") long codigoCliente);

	default void trySave(Resposta resposta, Pedido pedido) {
		if (this.exists(pedido.getNumeroControle()))
			resposta.addErro("ja existe um pedido cadastrado com o ID: " + pedido.getNumeroControle());
		else {
			this.save(pedido);
			resposta.addSucesso(pedido);

		}

	}

	default Resposta salvarPedidosComRegrassDeDesconto(List<Pedido> pedidos, Resposta resposta) {
		new CadeiaDeRegrasDeDesconto(pedidos).getReuslt().forEach(p -> this.trySave(resposta, p));
		return resposta;
	}

	default List<Pedido> consultaPorIntervaloDeDatas(String dataDe, String dataAte) {

		List<Pedido> pedidos = new ArrayList<Pedido>();
		this.findAll().forEach(pedidos::add);
		return pedidos.stream()
				.filter(p -> p.getDataCadastro().isBefore(LocalDateFormatter.parseData(dataAte).plusDays(1))
						&& p.getDataCadastro().isAfter(LocalDateFormatter.parseData(dataDe).minusDays(1)))
				.collect(Collectors.toList());

	}

}
