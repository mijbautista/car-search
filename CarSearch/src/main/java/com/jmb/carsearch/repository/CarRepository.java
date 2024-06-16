package com.jmb.carsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jmb.carsearch.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(String name, String color);
	
	@Query(value = "SELECT c FROM Car c WHERE (CAST( c.length AS string ) LIKE %?1) OR (CAST( c.weight AS string ) LIKE %?2) OR (CAST( c.velocity AS string ) LIKE %?3)")
	List<Car> findByLengthOrWeightOrVelocity(String length, String weight, String velocity);

}
