package com.hotel.model;

public class Room extends BaseModel {
	Hotel belongsToHotel;
	String typeDescription;
	int number;
	
	public Room() {
		
	}

	public Hotel getBelongsToHotel() {
		return belongsToHotel;
	}

	public void setBelongsToHotel(Hotel belongsToHotel) {
		this.belongsToHotel = belongsToHotel;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Room(int id, Hotel belongsToHotel, String typeDescription, int number) {
		super(id);
		this.belongsToHotel = belongsToHotel;
		this.typeDescription = typeDescription;
		this.number = number;
	}
	
	
}
