package com.desafio.casadocodigo.errorhandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorMessage validationErrorException(BindException exception) {
		Map<String, List<?>> errorsMap = buildErrorDescription(exception);
		return new ErrorMessage("Validation Failed", errorsMap.toString(), HttpStatus.BAD_REQUEST.value(), new Date());
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ErrorMessage illegalArgumentErrorException(Exception exception) {
		return new ErrorMessage("Validation Failed ",
				exception.getCause().getMessage(),
				HttpStatus.BAD_REQUEST.value(), new Date());
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalStateException.class)
	public ErrorMessage illegalStateErrorException(Exception exception) {
		return new ErrorMessage("Validation Failed", exception.getCause().getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());
	}

	private Map<String, List<?>> buildErrorDescription(BindException exception) {
		Map<String, List<?>> errorsMap = new HashMap<>();
		errorsMap.put("Field Errors",  buildFieldErrors(exception));
		errorsMap.put("Global Errors", buildGlobalErrors(exception));
		return errorsMap;
	}

	private List<String> buildGlobalErrors(BindException exception) {
		return exception.getBindingResult().getGlobalErrors().stream()
				.map(err -> err.getObjectName() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
	}

	private List<String> buildFieldErrors(BindException exception) {
		return exception.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
	}
}
