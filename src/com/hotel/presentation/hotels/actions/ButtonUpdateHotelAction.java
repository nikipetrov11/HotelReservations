package com.hotel.presentation.hotels.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.hotel.dal.HotelDao;

public class ButtonUpdateHotelAction implements ActionListener {
	JTable table;
	
	public ButtonUpdateHotelAction(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		String name = table.getValueAt(row, 1).toString();
		int stars = Integer.parseInt(table.getValueAt(row, 2).toString());
		
		HotelDao dao = new HotelDao();
		dao.editHotel(id, name, stars);
	}

}
