package com.apirest.cliente.escola.gradecurricular.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MateriaException extends RuntimeException{

	private static final long serialVersionUID = -816270448715771049L;
	
	private final HttpStatus httpStatus;
	
	public MateriaException(final String mensagem, final HttpStatus httpStatus) {
		super(mensagem);
		this.httpStatus = httpStatus;
	}

}
