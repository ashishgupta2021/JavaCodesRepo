FROM openjdk:9
ADD target/spring-boot-test.jar docker-spring-test.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-spring-test.jar"]
