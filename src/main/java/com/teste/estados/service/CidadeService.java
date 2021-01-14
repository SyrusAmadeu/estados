package com.teste.estados.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.estados.entity.Cidade;
import com.teste.estados.exceptions.CidadeNotFoundException;
import com.teste.estados.repository.CidadeRepository;
import com.teste.estados.repository.EstadoRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Autowired
	private EstadoRepository estRepository;

	public Collection<Cidade> findAll(Long id) {
		log.info("Listando Cidades");

		return estRepository.findAllCidades(id);
	}

	public Cidade addCidade(Cidade newCidade) {
		log.info("Adicionando " + newCidade.getNome() + " ao estado " + newCidade.getEstado().getNome());
		return repository.save(newCidade);
	}

	public Cidade findCidade(Long id) {
		log.info("Retornando cidade de id " + id);
		return repository.findById(id).orElseThrow(() -> new CidadeNotFoundException());
	}

	public void deleteCidade(Long idEstado, Long idCidade) throws CidadeNotFoundException {
		Cidade cidade = findCidade(idCidade);
		if (idEstado == null) {
			log.error("Cidade " + idCidade + " não encontrada");
			throw new CidadeNotFoundException();
		} else if (idEstado == 1) {
			System.out.println("Não é possível remover cidades do Rio Grande do Sul");
		} else {
			repository.deleteById(idCidade);
			log.info(cidade.getNome() + " deletada com sucesso");
		}

	}
}
