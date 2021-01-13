package com.teste.estados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.estados.entity.Cidade;
import com.teste.estados.repository.CidadeRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findAll() {
		log.info("Listing all employees");
		return repository.findAll();
	}
}
