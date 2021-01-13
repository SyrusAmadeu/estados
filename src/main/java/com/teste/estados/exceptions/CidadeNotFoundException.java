package com.teste.estados.exceptions;

public class CidadeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8621218720799949162L;

	public CidadeNotFoundException() {
		super("Cidade não encontrada");
	}
}
