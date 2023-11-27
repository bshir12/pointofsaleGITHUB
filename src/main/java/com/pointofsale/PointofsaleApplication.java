package com.pointofsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pointofsale")
public class PointofsaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointofsaleApplication.class, args);
	}

}
