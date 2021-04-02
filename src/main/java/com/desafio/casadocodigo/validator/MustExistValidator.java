package com.desafio.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import com.desafio.casadocodigo.base.Validatable;

public class MustExistValidator  implements ConstraintValidator<MustExistId, Validatable> {

	@PersistenceContext
	private EntityManager manager;
	
	private String domainAttribute;
	private Class<?> clazz;
	
	@Override
	public void initialize(MustExistId constraintAnnotation) {
		this.domainAttribute = constraintAnnotation.fieldName();
		this.clazz = constraintAnnotation.domainClass();
	}
	
	@Override
	public boolean isValid(Validatable value, ConstraintValidatorContext context) {
		return this.doCheckIsValid(value);
	}
	
	private boolean doCheckIsValid(Validatable value) {
		var query = manager.createQuery("Select 1 from "+clazz.getName()+ " where "+domainAttribute+" = :value");
		query.setParameter("value", value.getId());
		var result = query.getResultList();
		Assert.isTrue(!result.isEmpty(), "Dependencia não foi encontrada: "+clazz.getName()+" com o atributo: "+domainAttribute+" = "+value);
		return !result.isEmpty();
	}

}
