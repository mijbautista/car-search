package com.jmb.carsearch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars", indexes = {
		  @Index(columnList = "name"),
		  @Index(columnList = "length"),
		  @Index(columnList = "weight"),
		  @Index(columnList = "velocity"),
		  @Index(columnList = "color")})
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private int length;

	@Column
	private int weight;

	@Column
	private int velocity;

	@Column
	private String color;
	
	public Car() {
		
	}

	public Car(Long id, String name, int length, int weight, int velocity, String color) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.weight = weight;
		this.velocity = velocity;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
