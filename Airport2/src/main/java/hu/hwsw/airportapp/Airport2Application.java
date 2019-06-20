package hu.hwsw.airportapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Airport2Application {

	public static void main(String[] args) {
		SpringApplication.run(Airport2Application.class, args);
	}

}
