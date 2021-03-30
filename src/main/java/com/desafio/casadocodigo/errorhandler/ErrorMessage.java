package com.desafio.casadocodigo.errorhandler;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ErrorMessage {
	private String message;
	private String description;
	private int statusCode;
	private Date timestamp;
}
