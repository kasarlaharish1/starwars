package com.starwars.service.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.service.services.StarWarsService;
import com.starwars.service.validations.Validations;

@RestController
@RequestMapping("/starwars/")
public class StarWarsController {

	@Autowired
	StarWarsService starWarsService;
	
	@Autowired
	Validations validator;
	
	/*
	 * Endpoint to fetch details for any star wars related object
	 */
	@GetMapping(value="/fetch/data/", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<?> fetchStarWarsData(
			@RequestParam(value = "type", required = true) String type,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) throws Exception{

		validator.validateType(type);
		return new ResponseEntity<>(starWarsService.getDetails(type, name), HttpStatus.OK);
	}
	
}
