package com.office.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author amandeep.singh
 *
 */
@SpringBootApplication   // combination of @configuration + @component scan + @Enable autoconfiguration annotations.
public class SpringAndMongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAndMongoDbDemoApplication.class, args);
	}

}
