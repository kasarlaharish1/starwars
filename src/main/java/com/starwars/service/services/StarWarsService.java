package com.starwars.service.services;

public interface StarWarsService {


	Object getDetails(String type, String name) throws Exception;
	
	Object getStarWarsInfo(String object, String type, String name);
	
}
