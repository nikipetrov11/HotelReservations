package com.hotel.presentation;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class AbstractCrudPanel extends JFrame {
	protected JPanel panelCreate = new JPanel();
	protected JPanel panelFilter = new JPanel();
	protected JPanel panelRead = new JPanel();
	protected JPanel panelDelUpdate = new JPanel();
	
	protected JButton buttonAdd = new JButton("Добави");
	protected JButton buttonDel = new JButton("Изтрий");
	protected JButton buttonUpdate = new JButton("Запази промените");
	
	protected JTable table=new JTable();
	
	//protected JLabel filter1L = new JLabel();
	//protected JLabel filter2L = new JLabel();
	//protected JTextField filter1TF = new JTextField();
	//protected JTextField filter2TF = new JTextField();
	//protected JButton buttonFilter = new JButton("Филтрирай"); 
	public AbstractCrudPanel() {
		// set Frame
		this.setSize(500, 500);
		this.setLayout(new GridLayout(3,1));
		
		// add Panels
		this.add(panelCreate);
		//this.add(panelFilter);
		//panelFilter.setLayout(new GridLayout(3, 2));
		this.add(panelRead);
		this.add(panelDelUpdate);
		
		// add table
		panelRead.add(table);
		
		// add bottom panel
		panelDelUpdate.add(buttonUpdate);
		panelDelUpdate.add(buttonDel);
		
		// add filter
		//panelFilter.add(filter1L);
		//panelFilter.add(filter1TF);
		//panelFilter.add(filter2L);
		//panelFilter.add(filter2TF);
		//panelFilter.add(buttonFilter);
	}
}
