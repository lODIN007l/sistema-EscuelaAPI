package com.escuela.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolManagementSystemApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
		System.out.println("Ejecutando - puerto :8080 e ingrese credenciales...");
	}

}
