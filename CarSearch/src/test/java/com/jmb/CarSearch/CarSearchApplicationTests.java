package com.jmb.CarSearch;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jmb.carsearch.model.Car;
import com.jmb.carsearch.service.CarService;
import com.jmb.carsearch.utility.SearchUtilities;

@SpringBootTest
class CarSearchApplicationTests {
	
	@Autowired
	CarService service;

	@Test
	void testIsNumericUtil() {
		String notNumeric = "NotNumeric";
		String numeric = "1";
		Assertions.assertFalse(SearchUtilities.isNumeric(notNumeric));
		Assertions.assertTrue(SearchUtilities.isNumeric(numeric));
	}
	
	@Test
	void testFindCarsByNameColor() {
		String searchTerm = "RED";
		List<Car> listAll = service.getCars();
		long searchCount = listAll.stream().filter(c -> c.getName().toUpperCase().contains(searchTerm) || 
														c.getColor().toUpperCase().contains(searchTerm))
											.count();
		List<Car> listSearch = service.findCarsByNameColor(searchTerm);
		Assertions.assertTrue(searchCount == listSearch.size());
	}
	
	@Test
	void testFindCarsByLenghtWeightVelocity() {
		String searchTerm = "20";
		List<Car> listAll = service.getCars();
		long searchCount = listAll.stream().filter(c -> String.valueOf(c.getLength()).contains(searchTerm) || 
														String.valueOf(c.getWeight()).contains(searchTerm) || 
														String.valueOf(c.getVelocity()).contains(searchTerm))
											.count();
		List<Car> listSearch = service.findCarsByLenghtWeightVelocity(searchTerm);
		Assertions.assertTrue(searchCount == listSearch.size());
	}

}
