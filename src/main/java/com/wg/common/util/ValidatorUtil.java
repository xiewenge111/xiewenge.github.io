package com.wg.common.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author HuangJun
 * @version 1.0
 * @date 2016-11-09 15:49
 */
public final class ValidatorUtil {

	private ValidatorUtil(){}

	public static <T> String valid(T obj){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Set<ConstraintViolation<T>> constraintViolations = factory.getValidator().validate(obj);

		for (ConstraintViolation constraintViolation : constraintViolations) {
			return constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage();
		}
		return "";
	}


}
