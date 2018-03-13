package com.capitani.teste.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capitani.teste.entities.Pedido;
import com.capitani.teste.entities.Resposta;
import com.capitani.teste.repository.ClienteRepository;
import com.capitani.teste.repository.PedidoRepository;
import com.capitani.teste.util.LocalDateFormatter;

@Controller
@RequestMapping(value = "pedidos", produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }, consumes = {
		MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
public class CapitaniController {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@PostMapping
	@ResponseBody
	public Resposta addPedidos(@RequestBody List<Pedido> pedidos) {
		Resposta resposta = new Resposta();
		try {
		pedidos = clienteRepository.validaCliente(pedidos, resposta);
		
		if (pedidos.size() < 1)
			return resposta;

		return pedidos.size() > 10 ? resposta.addErro("Não pode ultrapassar 10 pedidos por requisição")
				: pedidoRepository.salvarPedidosComRegrassDeDesconto(pedidos, resposta);
		}catch (Exception e) {
			return resposta.addErro("Verifique os dados enviados na requisição");
		}

	}

	@GetMapping(value = "doCliente/{codigoCliente}")
	@ResponseBody
	public List<Pedido> consultaPorIdCliente(@PathVariable("codigoCliente") Long codigoCliente) {
		return pedidoRepository.findbyCodClient(codigoCliente);

	}

	@GetMapping(value = "{numeroPedido}")
	@ResponseBody
	public Pedido consulta(@PathVariable("numeroPedido") Long numPedido) {
		return pedidoRepository.findOne(numPedido);
	}

	@GetMapping("porData")
	@ResponseBody
	public List<Pedido> consulta(@RequestParam(value = "de", required = false) String dataDe,
			@RequestParam(value = "ate", required = false) String dataAte) {
		if (dataAte == null)
			dataAte = LocalDateFormatter.maxDate();

		if (dataDe == null)
			dataDe = LocalDateFormatter.minDate();
		return pedidoRepository.consultaPorIntervaloDeDatas(dataDe, dataAte);

	}

	@GetMapping("criadoEm")
	@ResponseBody
	public List<Pedido> consulta(@RequestParam(value = "dataDeCadastro") String dataDeCadastro) {
		return pedidoRepository.findByData(LocalDateFormatter.parseData(dataDeCadastro));

	}

	@GetMapping
	@ResponseBody
	public Iterable<Pedido> consulta() {
		return pedidoRepository.findAll();
	}

}
