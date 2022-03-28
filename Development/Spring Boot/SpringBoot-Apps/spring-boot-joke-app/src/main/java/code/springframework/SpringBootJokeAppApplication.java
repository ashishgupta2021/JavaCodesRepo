package code.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class SpringBootJokeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJokeAppApplication.class, args);
		System.out.println("Done");
		
	}

}
