package com.starwars.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	
	@Bean
	   public Docket api() {
	      return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.starwars.service.controller"))
	        .build();
	   }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Star Wars Service")
				.description("Documentation Generateed Using SWAGGER for our Star Wars Rest API")
				.termsOfServiceUrl("https://swapi.dev/")
				.version("1.0")
				.build();
	}
}
