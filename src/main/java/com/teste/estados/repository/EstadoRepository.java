package com.teste.estados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.estados.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
