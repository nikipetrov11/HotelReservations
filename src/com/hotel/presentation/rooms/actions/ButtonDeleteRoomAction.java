package com.hotel.presentation.rooms.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.room.dal.RoomDao;


public class ButtonDeleteRoomAction implements ActionListener {
	JTable table;
	public ButtonDeleteRoomAction(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		RoomDao dao = new RoomDao();
		dao.deleteRoom(id);
	}

}
