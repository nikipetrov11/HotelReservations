package com.hotel.presentation.rooms;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hotel.dal.HotelDao;
import com.hotel.model.Hotel;
import com.hotel.presentation.AbstractCrudPanel;
import com.hotel.presentation.hotels.actions.ButtonUpdateHotelAction;
import com.hotel.presentation.rooms.actions.ButtonAddRoomAction;
import com.hotel.presentation.rooms.actions.ButtonDeleteRoomAction;
import com.hotel.presentation.rooms.actions.ButtonUpdateRoomAction;
import com.room.dal.RoomDao;

public class Rooms extends AbstractCrudPanel {
	JLabel hotelNameL = new JLabel("Хотел:");
	JLabel roomTypeL = new JLabel("Тип стая:");
	JLabel roomNumberL = new JLabel("Номер на стая:");
	
	JComboBox hotelNameCB=new JComboBox();
	JTextField roomTypeTF=new JTextField(20);
	JTextField roomNumberTF = new JTextField(4);
	
	public Rooms() {
		super();
		
		// set layout
		panelCreate.setLayout(new GridLayout(4,2));
		
		// add create elements
		panelCreate.add(hotelNameL);
		panelCreate.add(hotelNameCB);
		panelCreate.add(roomTypeL);
		panelCreate.add(roomTypeTF);
		panelCreate.add(roomNumberL);
		panelCreate.add(roomNumberTF);
		panelCreate.add(buttonAdd);
		
		// add elements to combobox
		HotelDao hotelsDao = new HotelDao();
		
		for (Hotel h : hotelsDao.getHotelsToList()) {
			hotelNameCB.addItem(h);
		}
		
		// add create button
		buttonAdd.addActionListener(new ButtonAddRoomAction(hotelNameCB, roomTypeTF, roomNumberTF));
		
		// add filter
		//filter1L.setText("Име на хотел");
		//filter2L.setText("Брой звезди");
		
		// delete room
		buttonDel.addActionListener(new ButtonDeleteRoomAction(table));
		
		// update room
		buttonUpdate.addActionListener(new ButtonUpdateRoomAction(table));
		
		// fill table
		RoomDao roomsDao = new RoomDao();
		table.setModel(roomsDao.getRooms());
		
		this.setVisible(true);
	}
}
