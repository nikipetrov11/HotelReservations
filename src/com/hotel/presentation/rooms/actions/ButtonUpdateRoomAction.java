package com.hotel.presentation.rooms.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.hotel.dal.HotelDao;
import com.room.dal.RoomDao;

public class ButtonUpdateRoomAction implements ActionListener {
	JTable table;
	
	public ButtonUpdateRoomAction(JTable table) {
		this.table = table;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		int hotel_id = Integer.parseInt(table.getValueAt(row, 1).toString());
		String type_description = table.getValueAt(row, 2).toString();
		int number = Integer.parseInt(table.getValueAt(row, 3).toString());
		
		RoomDao dao = new RoomDao();
		dao.editRoom(id, hotel_id, type_description, number);
	}

}
