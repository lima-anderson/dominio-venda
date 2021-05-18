package com.lima.dominio.model.dto;

import java.time.Instant;

import com.lima.dominio.model.entidades.Pedido;
import com.lima.dominio.model.entidades.StatusPedido;

public class PedidoDTO {

	private Instant momento = Instant.now();
	private StatusPedido status;

	private ClienteDTO clienteDTO;

	public PedidoDTO() {

	}

	public PedidoDTO(Instant momento, StatusPedido status, ClienteDTO clienteDTO) {
		this.momento = momento;
		this.status = status;
		this.clienteDTO = clienteDTO;
	}

	public PedidoDTO(Pedido pedido) {
		this.momento = pedido.getMomento();
		this.status = pedido.getStatus();
		this.clienteDTO = new ClienteDTO(pedido.getCliente());
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

}
