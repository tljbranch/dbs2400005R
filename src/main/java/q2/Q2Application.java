package q2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Q2Application {
	public static void main(String[] args) {
		SpringApplication.run(Q2Application.class, args);
		/*-
		 * Should be replace with a Logger library like log4j. 
		 * If so class name will prepend, similar message can be use accord different layers and logging Level can be managed
		 */
		System.out.println("Q2Application::started");
	}
}
