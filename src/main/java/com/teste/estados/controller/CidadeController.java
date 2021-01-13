package com.teste.estados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.estados.entity.Cidade;
import com.teste.estados.service.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/employees")
public class CidadeController {

	@Autowired
	private CidadeService service;
	
	@ApiOperation("List all employees from database.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Employees returned successfuly."),
			@ApiResponse(code = 403, message = "Access Forbidden.") })

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> findAll = service.findAll();
		return new ResponseEntity<List<Cidade>>(findAll, HttpStatus.OK);
	}
}
