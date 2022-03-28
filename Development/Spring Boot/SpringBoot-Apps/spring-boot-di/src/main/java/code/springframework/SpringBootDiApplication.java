package code.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import code.springframework.controller.HelloController;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootDiApplication.class, args);
		
		HelloController helloController = (HelloController) ctx.getBean("helloController");
		helloController.hello();
	}

}
