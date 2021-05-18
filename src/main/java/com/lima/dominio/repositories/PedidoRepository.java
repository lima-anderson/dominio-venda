package com.lima.dominio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lima.dominio.model.entidades.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
