package com.teste.estados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.estados.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
