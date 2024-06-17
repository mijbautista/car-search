package com.jmb.carsearch.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmb.carsearch.model.Car;

@RestController
public class DownloadController {
	
	@GetMapping(value = "/download", produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Car>> produceXML(List<Car> cars) {
		return ResponseEntity.ok(cars);
	}

}
