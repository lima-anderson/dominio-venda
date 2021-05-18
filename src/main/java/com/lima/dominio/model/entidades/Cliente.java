package com.lima.dominio.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.lima.dominio.model.dto.ClienteDTO;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	List<Pedido> pedidos = new ArrayList<Pedido>();

	public Cliente() {

	}

	public Cliente(String nome, String email, List<Pedido> pedidos) {
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
	}

	public Cliente(ClienteDTO clienteDTO) {
		this.nome = clienteDTO.getNome();
		this.email = clienteDTO.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

}
