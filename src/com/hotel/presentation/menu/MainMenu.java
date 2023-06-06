package com.hotel.presentation.menu;

import java.awt.GridLayout;

import javax.swing.*;

import com.hotel.presentation.menu.actions.ButtonHotelAction;
import com.hotel.presentation.menu.actions.ButtonReportAction;
import com.hotel.presentation.menu.actions.ButtonReservationAction;
import com.hotel.presentation.menu.actions.ButtonRoomAction;

public class MainMenu extends JFrame {
	JPanel panel = new JPanel();
	JButton buttonHotel = new JButton("Хотели");
	JButton buttonRoom = new JButton("Стаи");
	JButton buttonReservation = new JButton("Резервации");
	JButton buttonReport = new JButton("Справка стаи");
	
	public MainMenu() {
		this.setSize(300, 500);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panel);
		this.setLayout(new GridLayout(4,1));
		
		// add buttons
		panel.add(buttonHotel);
		panel.add(buttonRoom);
		panel.add(buttonReservation);
		panel.add(buttonReport);
		
		// set buttons' size
		buttonHotel.setSize(250, 200);
		buttonRoom.setSize(250, 200);
		buttonReservation.setSize(250, 200);
		buttonReport.setSize(250, 200);
		
		// add button events
		buttonHotel.addActionListener(new ButtonHotelAction());
		buttonRoom.addActionListener(new ButtonRoomAction());
		buttonReservation.addActionListener(new ButtonReservationAction());
		buttonReport.addActionListener(new ButtonReportAction());
		
		this.setVisible(true);
	}
}
