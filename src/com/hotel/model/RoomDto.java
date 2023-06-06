package com.hotel.model;

public class RoomDto {
	int id;
	String HotelName;
	int number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public RoomDto(int id, String hotelName, int number) {
		super();
		this.id = id;
		HotelName = hotelName;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return this.HotelName + this.number;
	}
	
}
