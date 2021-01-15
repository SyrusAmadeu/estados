package com.teste.estados.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.estados.entity.Cidade;
import com.teste.estados.entity.Estado;
import com.teste.estados.exceptions.CidadeNotFoundException;
import com.teste.estados.exceptions.NullFieldsException;
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

	@Autowired
	private EstadoService estService;

	public Collection<Cidade> findAll(Long id) {
		log.info("Listando Cidades");

		return estRepository.findAllCidades(id);
	}

	public Cidade addCidade(Cidade newCidade, Long idEstado) {
		try {
			boolean igual = false;
			Estado estado = estService.findEstado(idEstado);
			if (estado.getCidades().size() > 0) {
				List<Cidade> cidades = estado.getCidades();
				for (Cidade cidade : cidades) {
					if (cidade.getNome().contains(cidade.getNome())) {
						igual = true;
					}
				}
			}
			if (!igual) {
				if (newCidade.getNome() == null || newCidade.getPopulacao() == null) {
					throw new NullFieldsException("Nenhum campo pode estar vazio");
				} else {
					log.info("\n-------------------\nAdicionando: " + newCidade.getNome() + "\n-------------------");

					newCidade.setEstado(estado);
					return repository.save(newCidade);
				}
			}else {
				log.error("Erro: já existe uma cidade com este nome neste estado");
				throw new NullFieldsException("Não pode haver duas cidades com o mesmo nome em um estado");
			}
		} catch (NullFieldsException nfe) {
			throw nfe;
		} catch (Exception e) {
			log.error("Mensagem desconhecida: " + e.getMessage());
			throw new RuntimeException("RuntimeException: " + e.getMessage());
		}

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
