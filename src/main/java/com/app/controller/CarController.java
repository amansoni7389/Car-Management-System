package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Car;
import com.app.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // Create a new car
    @PostMapping("/create")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car savedCar = carService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    // Update an existing car
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car car = carService.updateCar(id, updatedCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    // Get all cars
    @GetMapping("/getAllCars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.searchCars("", "", null, "", ""); // Empty strings fetch all
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    // Search cars by parameters
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String model,
        @RequestParam(required = false) Integer year,
        @RequestParam(required = false) String color,
        @RequestParam(required = false) String fuelType
    ) {
        List<Car> cars = carService.searchCars(name, model, year, color, fuelType);
        return ResponseEntity.ok(cars);
    }

    // Delete a car
    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

