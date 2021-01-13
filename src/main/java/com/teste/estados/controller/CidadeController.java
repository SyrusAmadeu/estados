package com.teste.estados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.estados.service.CidadeService;

@RestController
@RequestMapping(value = "/employees")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
}
