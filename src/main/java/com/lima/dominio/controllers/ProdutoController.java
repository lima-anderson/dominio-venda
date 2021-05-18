package com.lima.dominio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lima.dominio.model.entidades.Produto;
import com.lima.dominio.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoController {

	ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@PostMapping
	public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
		produtoRepository.save(produto);
		
		return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}

}
