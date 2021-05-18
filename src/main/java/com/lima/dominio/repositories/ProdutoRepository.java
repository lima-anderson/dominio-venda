package com.lima.dominio.repositories;

import com.lima.dominio.model.entidades.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
