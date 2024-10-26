package com.web.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.expression.Arrays;

import com.web.lab.dominio.Car;
import com.web.lab.dominio.CarRepository;

@SpringBootApplication
public class LabApplication implements CommandLineRunner {

	@Autowired
	private CarRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Car("Ford", "Mustang", "Red", 
		"ADF-1121", 2021, 59000));
		repository.save(new Car("Nissan", "Leaf", "White", 
		"SSJ-3002", 2019, 29000));
		repository.save(new Car("Toyota", "Prius", "Silver", 
		"KKO-0212", 2020, 39000));
		
	}

}

