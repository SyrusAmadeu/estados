package com.teste.estados.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.estados.entity.Cidade;
import com.teste.estados.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	@Query("SELECT cidades FROM Estado a where a.id = ?1")
	public Collection<Cidade> findAllCidades(Long id);
}
