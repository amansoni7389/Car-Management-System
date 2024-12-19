package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
	    @Query("SELECT c FROM Car c WHERE " +
	           "(:name IS NULL OR c.name LIKE %:name%) AND " +
	           "(:model IS NULL OR c.model LIKE %:model%) AND " +
	           "(:year IS NULL OR c.year = :year) AND " +
	           "(:color IS NULL OR c.color LIKE %:color%) AND " +
	           "(:fuelType IS NULL OR c.fuelType LIKE %:fuelType%)")
	    List<Car> searchCars(
	        @Param("name") String name,
	        @Param("model") String model,
	        @Param("year") Integer year,
	        @Param("color") String color,
	        @Param("fuelType") String fuelType
	    );
	}






