package com.hotel.presentation.reservations;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.hotel.dal.HotelDao;
import com.hotel.model.Hotel;
import com.hotel.model.RoomDto;
import com.hotel.presentation.AbstractCrudPanel;
import com.hotel.presentation.hotels.actions.ButtonAddHotelAction;
import com.hotel.presentation.hotels.actions.ButtonUpdateHotelAction;
import com.hotel.presentation.reservations.actions.ButtonAddReservationAction;
import com.hotel.presentation.reservations.actions.ButtonDeleteReservationAction;
import com.hotel.presentation.reservations.actions.ButtonUpdateReservationAction;
import com.hotel.presentation.rooms.actions.ButtonDeleteRoomAction;
import com.reservation.dal.ReservationDao;
import com.room.dal.RoomDao;

public class Reservations extends AbstractCrudPanel {
	JLabel fromDateL = new JLabel("Настаняване [yyyy-MM-dd]:");
	JLabel toDateL = new JLabel("Напускане [yyyy-MM-dd]:");
	JLabel guestNameL = new JLabel("Име на госта:");
	JLabel roomsL = new JLabel("Стая:");
	
	JTextField fromDateTF = new JTextField();
	JTextField toDateTF = new JTextField();
	JTextField guestTF = new JTextField();
	JComboBox roomsCB = new JComboBox();
	
	public Reservations() {
		super();
		
		// set create
		panelCreate.setLayout(new GridLayout(5,2));
		panelCreate.add(fromDateL);
		panelCreate.add(fromDateTF);
		panelCreate.add(toDateL);
		panelCreate.add(toDateTF);
		panelCreate.add(guestNameL);
		panelCreate.add(guestTF);
		panelCreate.add(roomsL);
		panelCreate.add(roomsCB);
		panelCreate.add(buttonAdd);
		
		// add elements to combobox
		RoomDao roomDao = new RoomDao();
				
		for (RoomDto r : roomDao.getRoomsToList()) {
			roomsCB.addItem(r);
		}
		
		buttonAdd.addActionListener(
				new ButtonAddReservationAction(
						fromDateTF, 
						toDateTF,
						guestTF,
						roomsCB));
		
		// fill table
		ReservationDao dao = new ReservationDao();
		table.setModel(dao.getReservations());
		
		// delete reservation
		buttonDel.addActionListener(new ButtonDeleteReservationAction(table));
		
		// update hotel
		buttonUpdate.addActionListener(new ButtonUpdateReservationAction(table));
		
		this.setVisible(true);
	}
}
