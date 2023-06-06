package com.hotel.presentation.reservations.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import com.reservation.dal.ReservationDao;

public class ButtonDeleteReservationAction implements ActionListener {
	JTable table;
	public ButtonDeleteReservationAction(JTable table) {
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ReservationDao dao = new ReservationDao();
		int row = table.getSelectedRow();
		int id = Integer.parseInt(table.getValueAt(row, 0).toString());
		dao.deleteReservation(id);
	}

}
