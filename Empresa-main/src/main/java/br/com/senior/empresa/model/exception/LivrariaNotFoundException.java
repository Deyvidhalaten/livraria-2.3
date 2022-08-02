package br.com.senior.empresa.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Livraria não encontrata")
public class LivrariaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivrariaNotFoundException(String msg) {
		super(msg);
	}
}
