package com.lima.dominio.controllers;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lima.dominio.model.dto.ClienteDTO;
import com.lima.dominio.model.dto.PedidoDTO;
import com.lima.dominio.model.entidades.Cliente;
import com.lima.dominio.model.entidades.Pedido;
import com.lima.dominio.repositories.ClienteRepository;
import com.lima.dominio.repositories.PedidoRepository;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

	ClienteRepository clienteRepository;
	PedidoRepository pedidoRepository;

	public ClienteController(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
		this.clienteRepository = clienteRepository;
		this.pedidoRepository = pedidoRepository;
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> adicionarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {

		Cliente cliente = new Cliente(clienteDTO);

		clienteRepository.save(cliente);

		return new ResponseEntity<>(new ClienteDTO(cliente), HttpStatus.CREATED);
	}

	@GetMapping("{idCliente}")
	public ResponseEntity<?> buscarCliente(@PathVariable Long idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		if (cliente.isEmpty()) {
			return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new ClienteDTO(cliente.get()), HttpStatus.FOUND);
	}

	@Transactional
	@PostMapping("{idCliente}/pedido")
	public ResponseEntity<?> atribuirPedidoAPessoa(@PathVariable Long idCliente,
			@RequestBody @Valid PedidoDTO pedidoDTO) {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		if (cliente.isEmpty()) {
			return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
		}

		Pedido pedido = new Pedido(pedidoDTO);

		pedido.setCliente(cliente.get());
		cliente.get().adicionarPedido(pedido);

		clienteRepository.save(cliente.get());

		return new ResponseEntity<>(new ClienteDTO(cliente.get()), HttpStatus.CREATED);
	}

}
