package com.teste.estados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.estados.entity.Estado;
import com.teste.estados.service.EstadoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	@Autowired
	private EstadoService service;

	@ApiOperation("Lista todoss os estados.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Estados retornados com sucesso.") })
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> findAll = service.findAll();
		return new ResponseEntity<List<Estado>>(findAll, HttpStatus.OK);
	}
	
	@ApiOperation("Recupera uma cidade pelo seu id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade recuperada."),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@GetMapping("/{id}")
	public ResponseEntity<Estado> findEstado(@PathVariable Long id) {
		Estado findEstado = service.findEstado(id);
		return new ResponseEntity<Estado>(findEstado, HttpStatus.OK);
	}
}
