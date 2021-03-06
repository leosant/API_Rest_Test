package com.apirest.cliente.escola.gradecurricular.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apirest.cliente.escola.gradecurricular.exception.MateriaException;
import com.apirest.cliente.escola.gradecurricular.model.ErrorResponse;
import com.apirest.cliente.escola.gradecurricular.model.ErrorResponse.ErrorResponseBuilder;

@ControllerAdvice
public class ResourceHandler {
	
	@ExceptionHandler(MateriaException.class)
	public ResponseEntity<ErrorResponse> handlerMateriaException(MateriaException m) {
		ErrorResponseBuilder erro = ErrorResponse.builder();
		erro.httpStatus(m.getHttpStatus().value());
		erro.mensagem(m.getMessage());
		erro.timeStamp(System.currentTimeMillis());
		return ResponseEntity.status(m.getHttpStatus()).body(erro.build());
	}

}
