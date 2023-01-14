package com.shapes.app.Shapify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("com.shapes.app.Shapify.config")
public class ShapifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShapifyApplication.class, args);
	}

}
