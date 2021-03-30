package com.desafio.casadocodigo.validator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({FIELD})
@Constraint(validatedBy = {UniqueValueValidator.class})
public @interface UniqueValue {
	
	String message() default "{com.desafio.casadocodigo.validator.uniqueValue}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	String fieldName();
	
	Class<?> domainClass();

}
