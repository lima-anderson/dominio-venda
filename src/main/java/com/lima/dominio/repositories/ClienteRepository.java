package com.lima.dominio.repositories;

import com.lima.dominio.model.entidades.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
