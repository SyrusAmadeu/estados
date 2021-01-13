package com.teste.estados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value = "/estados/cidades")
public class CidadeController {

	@Autowired
	private CidadeService service;

	@ApiOperation("Lista todas as cidades.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidades retornadas com sucesso.") })

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> findAll = service.findAll();
		return new ResponseEntity<List<Cidade>>(findAll, HttpStatus.OK);
	}

	@ApiOperation("Insere uma cidade.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade inserida.") })

	@PostMapping
	public ResponseEntity<Cidade> addEmployee(@RequestBody Cidade newCidade) throws NullFieldsException {
		Cidade addCidade = service.addCidade(newCidade);
		return new ResponseEntity<Cidade>(addCidade, HttpStatus.CREATED);
	}

	@ApiOperation("Recupera uma cidade pelo seu id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade recuperada."),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findEmployee(@PathVariable Long id) {
		Cidade findCidade = service.findCidade(id);
		return new ResponseEntity<Cidade>(findCidade, HttpStatus.OK);
	}

	@ApiOperation("Atualiza cidade pelo seu id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Cidade atualizada."),
			@ApiResponse(code = 400, message = "BAD_REQUEST Campos necessários estão vazios."),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@PutMapping("/{id}")
	public ResponseEntity<Cidade> updateEmployee(@RequestBody Cidade newCidade, @PathVariable Long id) {
		Cidade updateCidade = service.updateCidade(newCidade, id);
		return new ResponseEntity<Cidade>(updateCidade, HttpStatus.CREATED);
	}

	@ApiOperation("Remove cidade pelo id")
	@ApiResponses({ @ApiResponse(code = 204, message = "Cidade remoida com sucesso"),
			@ApiResponse(code = 404, message = "Cidade não encontrada.") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCidade(@PathVariable Long id) {
		service.deleteCidade(id);
		return ResponseEntity.noContent().build();
	}
}
