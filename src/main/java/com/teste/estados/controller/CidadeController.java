package com.teste.estados.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.estados.entity.Cidade;
import com.teste.estados.exceptions.NullFieldsException;
import com.teste.estados.service.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/estados/{id}/cidades")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@ApiOperation("Lista todas as cidades.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidades retornadas com sucesso.") })

	@GetMapping
	public ResponseEntity<Collection<Cidade>> findAll(@PathVariable(name = "id", required = true) Long id) {
		Collection<Cidade> findAll = service.findAll(id);
		return new ResponseEntity<Collection<Cidade>>(findAll, HttpStatus.OK);
	}

	@ApiOperation("Insere uma cidade.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade inserida.") })

	@PostMapping
	public ResponseEntity<Cidade> addCidade(@RequestBody Cidade newCidade, @PathVariable(name = "id", required = true) Long idEstado) throws NullFieldsException {
		Cidade addCidade = service.addCidade(newCidade, idEstado);
		return new ResponseEntity<Cidade>(addCidade, HttpStatus.CREATED);
	}

	@ApiOperation("Recupera uma cidade pelo seu id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade recuperada."),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@GetMapping("/{id1}")
	public ResponseEntity<Cidade> findCidade(@PathVariable Long id) {
		Cidade findCidade = service.findCidade(id);
		return new ResponseEntity<Cidade>(findCidade, HttpStatus.OK);
	}

	@ApiOperation("Remove cidade pelo id")
	@ApiResponses({ @ApiResponse(code = 204, message = "Cidade remoida com sucesso"),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@DeleteMapping("/{id1}")
	public ResponseEntity<Void> deleteCidade(@PathVariable(name = "id", required = true) Long idEstado ,@PathVariable(name = "id1", required = true) Long idCidade) {
		service.deleteCidade(idEstado, idCidade);
		return ResponseEntity.noContent().build();
	}
}
