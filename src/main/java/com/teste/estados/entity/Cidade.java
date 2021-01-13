package com.teste.estados.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cid_nome")
	private String nome;
	
	@Column(name = "cid_populacao")
	private int populacao;
	
	@Column(name = "cid_estado")
	private Estado estado;
}
