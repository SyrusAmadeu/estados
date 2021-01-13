package com.teste.estados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.estados.entity.Cidade;
import com.teste.estados.exceptions.CidadeNotFoundException;
import com.teste.estados.repository.CidadeRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		log.info("Listando Cidades");
		return repository.findAll();
	}

	public Cidade addCidade(Cidade newCidade) {
		log.info("Adicionando " + newCidade.getNome() + " ao estado " + newCidade.getEstado().getNome());
		return repository.save(newCidade);
	}

	public Cidade findCidade(Long id) {
		log.info("Retornando cidade de id " + id);
		return repository.findById(id).orElseThrow(() -> new CidadeNotFoundException());
	}

	public Cidade updateCidade(Cidade newCidade, Long id) throws CidadeNotFoundException {
		return repository.findById(id).map(Cidade -> {

			return repository.save(Cidade);
		}).orElseThrow(() -> new CidadeNotFoundException());
	}

	public void deleteCidade(Long id) throws CidadeNotFoundException {
		Cidade cidade = findCidade(id);
		if (cidade == null) {
			log.error("Cidade " + id + " não encontrada");
			throw new CidadeNotFoundException();
		} else if (cidade.getEstado().getId() == 1) {
			System.out.println("Não pode");
		} else {
			repository.deleteById(id);
			log.info(cidade.getNome() + " deletada com sucesso");
		}
	}
}
