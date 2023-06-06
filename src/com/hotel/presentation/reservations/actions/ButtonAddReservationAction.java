package com.hotel.presentation.reservations.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.hotel.model.RoomDto;
import com.reservation.dal.ReservationDao;

public class ButtonAddReservationAction implements ActionListener {
	JTextField fromDateTF = new JTextField();
	JTextField toDateTF = new JTextField();
	JTextField guestTF = new JTextField();
	JComboBox roomsCB = new JComboBox();
	
	public ButtonAddReservationAction(
			JTextField fromDateTF,
			JTextField toDateTF,
			JTextField guestTF,
			JComboBox roomsCB) {
		this.fromDateTF = fromDateTF;
		this.toDateTF = toDateTF;
		this.guestTF = guestTF;
		this.roomsCB = roomsCB;		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ReservationDao dao = new ReservationDao();
		dao.addReservation(
				fromDateTF.getText(), 
				toDateTF.getText(), guestTF.getText(), 
				((RoomDto)roomsCB.getSelectedItem()).getId());
	}

}
