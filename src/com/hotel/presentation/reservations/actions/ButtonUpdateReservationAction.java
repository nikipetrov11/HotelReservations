package com.hotel.presentation.reservations.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.reservation.dal.ReservationDao;

public class ButtonUpdateReservationAction implements ActionListener {
	JTable table;
	
	public ButtonUpdateReservationAction(JTable table) {
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		String from_date = table.getValueAt(row, 1).toString();
		String to_date = table.getValueAt(row, 2).toString();
		String guest_name = table.getValueAt(row, 3).toString();
		int hotel_id = Integer.parseInt(table.getValueAt(row, 4).toString());
		
		ReservationDao dao = new ReservationDao();
		
		dao.editReservation(id, from_date, to_date, guest_name, hotel_id);
	}

}
