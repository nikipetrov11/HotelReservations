package com.hotel.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import com.hotel.model.Hotel;

public class HotelDao extends AbstractDao {
	public TableModel getHotels() {
		try {
			Connection con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from hotels");
			return ResultSetToTableModel(stmt.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addHotel(String name, int stars) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into hotels (name, stars) values (?, ?)");
			stmt.setString(1, name);
			stmt.setInt(2, stars);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteHotel(int id) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from hotels where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editHotel(int id, String name, int stars) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("update hotels set name = ?, stars = ? where id = ?");
			stmt.setString(1, name);
			stmt.setInt(2, stars);
			stmt.setInt(3, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Hotel> getHotelsToList(){
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from hotels");
			ResultSet rst;
		    rst = stmt.executeQuery();
		    
		    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		    
		    while(rst.next()) {
		    	hotels.add( new Hotel(
		    			rst.getInt("id"),
		    			rst.getString("name"),
		    			rst.getInt("stars")
		    			));
		    }
		    return hotels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
