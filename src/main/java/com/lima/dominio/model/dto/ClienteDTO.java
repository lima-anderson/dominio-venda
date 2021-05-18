package com.lima.dominio.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.lima.dominio.model.entidades.Cliente;
import com.lima.dominio.model.entidades.Pedido;

public class ClienteDTO {

	private String nome;
	private String email;
	List<Pedido> pedidos = new ArrayList<Pedido>();

	public ClienteDTO() {

	}

	public ClienteDTO(String nome, String email, List<Pedido> pedidos) {
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
	}

	public ClienteDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.pedidos = cliente.getPedidos();
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

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
