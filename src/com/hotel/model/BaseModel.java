package com.hotel.model;

public abstract class BaseModel {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BaseModel(int id) {
		super();
		this.id = id;
	}
	public BaseModel() {
		
	}
}
