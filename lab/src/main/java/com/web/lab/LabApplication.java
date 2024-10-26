package com.web.lab;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LabApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Mundo");
	}

	public class Car {

		@Autowired
    	private Owner owner;

    	@Autowired
    	private CarRepository CarRepository; 

    	public Car() {
        	owner = new Owner();
    	}

    	public Car(Owner owner) {
        	this.owner = owner;
    	}

    	public Owner getOwner() {
        	return owner;
    	}

    	public void setOwner(Owner owner) {
        	this.owner = owner;
    	}

    	@GetMapping("/cars")
    	public List<Car> fetchAllCars() {
        	return CarRepository.findAll();
    	}

	}

	public class Owner {

	}

	@Repository
	public interface CarRepository extends JpaRepository<Car, Long> {
	
	}

	@Configuration
	public class ConfigFileResource {
		@Bean(name = "configFile")
    	public File configFile() {
        	return new File("configFile.xml");
    	}
	}

	@RestController
	public class CarController {

    	@Autowired
    	private CarRepository carRepository;

    	@GetMapping("/cars")
    	public List<Car> fetchAllCars() {
        	return carRepository.findAll();
    	}
	}

}

