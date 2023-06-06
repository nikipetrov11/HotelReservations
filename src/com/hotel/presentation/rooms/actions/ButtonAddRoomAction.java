package com.hotel.presentation.rooms.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.hotel.model.Hotel;

import com.room.dal.RoomDao;

public class ButtonAddRoomAction implements ActionListener {

	JComboBox hotelNameTF;
	JTextField roomTypeTF;
	JTextField roomNumberTF;
	public ButtonAddRoomAction(JComboBox hotelNameTF, JTextField roomTypeTF, JTextField roomNumberTF) {
		this.hotelNameTF = hotelNameTF;
		this.roomTypeTF = roomTypeTF;
		this.roomNumberTF = roomNumberTF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RoomDao dao = new RoomDao();
		Hotel hotel = (Hotel)hotelNameTF.getSelectedItem();
		dao.addRoom(hotel.getId(), roomTypeTF.getText(), Integer.parseInt(roomNumberTF.getText()));
	}

}
