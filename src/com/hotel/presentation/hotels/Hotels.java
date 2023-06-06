package com.hotel.presentation.hotels;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hotel.dal.HotelDao;
import com.hotel.presentation.AbstractCrudPanel;
import com.hotel.presentation.hotels.actions.ButtonAddHotelAction;
import com.hotel.presentation.hotels.actions.ButtonDeleteHotelAction;
import com.hotel.presentation.hotels.actions.ButtonUpdateHotelAction;

public class Hotels extends AbstractCrudPanel {
	
	JLabel hotelNameL=new JLabel("Хотел:");
	JLabel starsL=new JLabel("Брой звезди:");
	
	JTextField hotelNameTF=new JTextField(20);
	JTextField starsTF=new JTextField(20);
	
	public Hotels() {
		super();
		
		// set create
		panelCreate.setLayout(new GridLayout(3,2));
		panelCreate.add(hotelNameL);
		panelCreate.add(hotelNameTF);
		panelCreate.add(starsL);
		panelCreate.add(starsTF);
		panelCreate.add(buttonAdd);
		
		buttonAdd.addActionListener(new ButtonAddHotelAction(hotelNameTF, starsTF));
		
		// add filter
		//filter1L.setText("Име на хотел");
		//filter2L.setText("Брой звезди");
		
		// fill table
		HotelDao dao = new HotelDao();
		table.setModel(dao.getHotels());
		
		// delete hotel
		buttonDel.addActionListener(new ButtonDeleteHotelAction(table));
		
		// update hotel
		buttonUpdate.addActionListener(new ButtonUpdateHotelAction(table));
		
		this.setVisible(true);
	}
}
