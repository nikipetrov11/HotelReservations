package com.hotel.presentation.reports.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.room.dal.RoomDao;

public class ButtonRoomsReportAction implements ActionListener {
	JTable table;
	JRadioButton hotelRB;
	JRadioButton roomTypeRB;
	JTextField filterTF;
	
	public ButtonRoomsReportAction(
			JTable table, 
			JRadioButton hotelRB, 
			JRadioButton roomTypeRB, 
			JTextField filterTF) {
		this.table = table;
		this.hotelRB = hotelRB;
		this.roomTypeRB = roomTypeRB;
		this.filterTF = filterTF;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RoomDao dao = new RoomDao();
		int filterType;
		if (hotelRB.isSelected()) {
			filterType = 1;
		} else {
			filterType = 2;
		}
		table.setModel(dao.getRooms(filterTF.getText(), filterType));
	}

}
