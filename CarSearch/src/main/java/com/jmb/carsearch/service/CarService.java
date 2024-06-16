package com.jmb.carsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmb.carsearch.model.Car;
import com.jmb.carsearch.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repo;
	
	public Car save(Car car) {
		return repo.save(car);
	}
	
	public List<Car> getCars() {
		return repo.findAll();
	}
	
	public List<Car> findCarsByNameColor(String val) {
		return repo.findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(val, val);
	}
	
	public List<Car> findCarsByLenghtWeightVelocity(String val) {
		return repo.findByLengthOrWeightOrVelocity(val, val, val);
	}

}
