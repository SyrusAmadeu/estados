package com.teste.estados.exceptions;

public class EstadoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1383945561597899491L;

	public EstadoNotFoundException() {
		super("Estado não encontrado");
	}
}
