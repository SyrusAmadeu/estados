package com.teste.estados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.estados.entity.Estado;
import com.teste.estados.exceptions.EstadoNotFoundException;
import com.teste.estados.repository.EstadoRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class EstadoService {
	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAll() {
		log.info("Listando Estados");
		return repository.findAll();
	}
	
	public Estado findEstado(Long id) {
		log.info("Retornando cidade de id " + id);
		return repository.findById(id).orElseThrow(() -> new EstadoNotFoundException());
	}
}
