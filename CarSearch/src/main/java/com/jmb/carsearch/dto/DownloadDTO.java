package com.jmb.carsearch.dto;

import java.util.ArrayList;
import java.util.List;

import com.jmb.carsearch.model.Car;

public class DownloadDTO {
	
	private List<Car> cars = new ArrayList<Car>();

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	

}
