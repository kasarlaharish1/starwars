package com.starwars.service.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Component;


/*
 * Handling http request
 * API used : https://swapi.dev/api/
 */
@Component
public class HttpHandler extends Constants {

	
	private static final Logger logger = Logger.getLogger(HttpHandler.class.getName());
	private static HttpClient httpClient = null;
	
	/*
	 * non parameterized constructor
	 */
	public HttpHandler() {
		
		httpClient = HttpClient.newBuilder().build();
	}
	
	
	/*
	 * making GET call
	 */
	public HttpResponse<String> get(String type, String name) throws Exception {
		
		return httpClient.send(getRequest(type, name), 
				BodyHandlers.ofString());
	}
	
	/*
	 * fetching get request
	 */
	public HttpRequest getRequest(String type, String name) throws Exception {
		
		return HttpRequest.newBuilder()
			     .uri(uriBuilder(type, name))
			     .GET()
			     .build();
	}
	
	/*
	 * building URI based on name parameter 
	 */
	public URI uriBuilder(String type, String name) throws Exception {
		
		UriBuilder uri = UriBuilder.fromUri(new URI(BASE_URI + type));
		if(name != null && !name.contentEquals(""))
			uri.queryParam(NAME, name);
		return 	uri.build();
	}
	
}
