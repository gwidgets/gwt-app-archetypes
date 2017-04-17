package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot${module}Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot${module}Application.class, args);
	}
}
