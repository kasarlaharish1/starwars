package com.starwars.service.validations;

import javax.validation.ValidationException;

import org.springframework.stereotype.Controller;

import com.starwars.service.util.Constants;

@Controller
public class Validations extends Constants {

	/*
	 * validating for TYPE provided 
	 */
	public void validateType(String type) {
		if(!TYPES.contains(type))
			throw new ValidationException("Invalid type provided, available types : " + TYPES);
	}
}
