# Star Wars Service
Docmentation Star Wars API {https://swapi.dev/api/}

Application can be used to fetch details for the characters, vehicles, films and
other associated things with respect to Star Wars.

Command to build in local : mvn clean install
Command to run the SpringBootApplication: java -jar star-wars.jar

It is an Spring based Web Application which is exposed using a micro-service which accepts parameters like type and name:

-On deploying application on local systems endpoints can be accessed in the following manner :

	-To access swagger/Documentation : http://localhost:8080/swagger-ui/#/
	-Sample GET request : http://localhost:8080/starwars/fetch/data/?name=Sand%20Crawler&type=vehicles
		-Request accepts following request parameters :
			-type (required) : denotes the type of object one wants to list (eg: planets, people, films etc)
			-name (optional) : In order to look for a specific item, name can be provided to search from the list
