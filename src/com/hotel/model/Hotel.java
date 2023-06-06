package com.hotel.model;

public class Hotel extends BaseModel {
	String name;
	int stars;
	
	public Hotel() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Hotel(int id, String name, int stars) {
		super(id);
		this.name = name;
		this.stars = stars;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
