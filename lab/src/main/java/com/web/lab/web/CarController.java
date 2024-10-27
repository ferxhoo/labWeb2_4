package com.web.lab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.web.lab.dominio.Car;
import com.web.lab.dominio.CarRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }

}
