FROM openjdk:11
EXPOSE 8080
ADD target/star-wars.jar star-wars.jar
ENTRYPOINT ["java", "-jar", "star-wars.jar"]