package ppori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"ppori"})
public class Application {

	public static void main(String[] args) {
		Environments.init(args);
		SpringApplication.run(Application.class, args);
	}

}
