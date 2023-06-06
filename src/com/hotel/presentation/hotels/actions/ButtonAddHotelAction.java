package com.hotel.presentation.hotels.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.hotel.dal.HotelDao;


public class ButtonAddHotelAction implements ActionListener {
	JTextField name;
	JTextField stars;
	
	public ButtonAddHotelAction(JTextField name, JTextField stars) {
		this.name = name;
		this.stars = stars;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		HotelDao dao = new HotelDao();
		dao.addHotel(name.getText(), Integer.parseInt(stars.getText()));
	}

}
