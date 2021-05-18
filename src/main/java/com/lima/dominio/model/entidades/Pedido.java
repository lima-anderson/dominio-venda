package com.lima.dominio.model.entidades;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lima.dominio.model.dto.PedidoDTO;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento = Instant.now();
	private StatusPedido status;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Pedido() {

	}

	public Pedido(StatusPedido status, Cliente cliente) {
		this.status = status;
		this.cliente = cliente;
	}

	public Pedido(PedidoDTO pedidoDTO) {
		this.status = pedidoDTO.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
