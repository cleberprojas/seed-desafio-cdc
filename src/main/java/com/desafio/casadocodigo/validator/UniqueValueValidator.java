package com.desafio.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String domainAttribute;
	private Class<?> clazz;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		this.domainAttribute = constraintAnnotation.fieldName();
		this.clazz = constraintAnnotation.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var query = manager.createQuery("Select 1 from "+clazz.getName()+ " where "+domainAttribute+" = :value");
		query.setParameter("value", value);
		var result = query.getResultList();
		Assert.isTrue(result.isEmpty(), "Foi Encontrado mais de um "+clazz.getName()+" com o mesmo atributo: "+domainAttribute+" = "+value);
		return result.isEmpty();
	}

}
