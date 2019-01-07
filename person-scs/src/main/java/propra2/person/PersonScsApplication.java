package propra2.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@SpringBootApplication

public class PersonScsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonScsApplication.class, args);
	}
}