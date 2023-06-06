package com.hotel.presentation.reports;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hotel.presentation.reports.actions.ButtonRoomsReportAction;

public class RoomsReport extends JFrame {
	JPanel panelLabel = new JPanel();
	JPanel panelFilter = new JPanel();
	JPanel panelReport = new JPanel();
	
	JLabel panelL = new JLabel("Справка стаи");
	JRadioButton hotelRB = new JRadioButton("Филтрирай по име на хотел");
	JRadioButton roomTypeRB = new JRadioButton("Филтрирай по тип стая");
	JLabel filterL = new JLabel("Филтър");
	JTextField filterTF= new JTextField();
	JButton reportB = new JButton("Направи справка");
	
	JTable table = new JTable();
	
	public RoomsReport() {
		this.setSize(500, 500);
		this.setLayout(new GridLayout(3, 1));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(panelLabel);
		this.add(panelFilter);
		this.add(panelReport);
		
		panelLabel.add(panelL);
		panelLabel.setSize(500, 100);
		panelFilter.setLayout(new GridLayout(2, 3));
		panelFilter.add(hotelRB);
		panelFilter.add(roomTypeRB);
		panelFilter.add(filterL);
		panelFilter.add(filterTF);
		panelFilter.add(reportB);
		panelFilter.setSize(500, 150);
		panelReport.add(table);
		
		reportB.addActionListener(new ButtonRoomsReportAction(table, hotelRB, roomTypeRB, filterTF));
		
		
		this.setVisible(true);
	}
}
