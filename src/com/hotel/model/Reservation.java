package com.hotel.model;

import java.time.LocalDate;

public class Reservation extends BaseModel {
	LocalDate from;
	LocalDate to;
	String guestName;
	
	public Reservation() {
		
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Reservation(int id, LocalDate from, LocalDate to, String guestName) {
		super(id);
		this.from = from;
		this.to = to;
		this.guestName = guestName;
	}
	
	
}
