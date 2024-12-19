package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.Car;
import com.app.repository.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public List<Car> searchCars(String name, String model, Integer year, String color, String fuelType) {
        return repository.searchCars(
            (name != null && !name.isEmpty()) ? name : null,
            (model != null && !model.isEmpty()) ? model : null,
            year,
            (color != null && !color.isEmpty()) ? color : null,
            (fuelType != null && !fuelType.isEmpty()) ? fuelType : null
        );
    }

    public Car saveCar(Car car) {
        return repository.save(car);
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car car = repository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        car.setName(updatedCar.getName());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setPrice(updatedCar.getPrice());
        car.setColor(updatedCar.getColor());
        car.setFuelType(updatedCar.getFuelType());
        return repository.save(car);
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}
