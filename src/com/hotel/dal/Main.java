package com.hotel.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hotel.presentation.menu.MainMenu;


public class Main {
//	static Connection con = null;
//	static PreparedStatement state=null;
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			con = DatabaseConnectionSettings.getConnection();
//			System.out.println(con.getSchema());
//			state = con.prepareStatement("insert into hotels (name, stars) values (?, ?)");
//			//state.setInt(1, 1);
//			state.setString(1, "Plovdiv");
//			state.setInt(2, 5);
//			state.execute();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		MainMenu menu = new MainMenu();
	}
}
