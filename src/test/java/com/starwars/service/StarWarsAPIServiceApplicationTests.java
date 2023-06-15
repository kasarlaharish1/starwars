package com.starwars.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starwars.service.util.Constants;
import com.starwars.service.controller.StarWarsController;
import com.starwars.service.services.StarWarsService;
import com.starwars.service.validations.Validations;

@SpringBootTest
class StarWarsAPIServiceApplicationTests extends Constants {

	@Autowired
	private Validations validate;
	
	@Autowired
	private StarWarsService service;
	
	@Autowired
	private StarWarsController controller;
	
	@Test
	public void validateTypeNegativeTest() {
		
		try {
			validate.validateType("test");
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void validateTypePositiveTest() {
		try {
			validate.validateType(PEOPLE);
		} catch(Exception e) {
			assertTrue(false);
		}
		assertTrue(true);
	}

	@Test
	public void getDetailsPositiveTest() {
		Object result = null;
		try {
			result = service.getDetails(PEOPLE, "abc");
		} catch (Exception e) {
			assertTrue(false);
		}
		assertTrue(result.toString().contentEquals("{}"));
	}
	
	@Test
	public void validateEndpointNegativeTest() {
		try {
			controller.fetchStarWarsData("abc", "def");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Invalid type provided"));
		}
	}
	
}
