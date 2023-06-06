package com.room.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import com.hotel.dal.AbstractDao;
import com.hotel.dal.DatabaseConnectionSettings;
import com.hotel.model.Hotel;
import com.hotel.model.RoomDto;

public class RoomDao extends AbstractDao {
	public TableModel getRooms() {
		try {
			Connection con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from rooms");
			return ResultSetToTableModel(stmt.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addRoom(int hotelNumber, String description, int number) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into rooms (hotel_id, type_description, number) values (?, ?, ?)");
			stmt.setInt(1, hotelNumber);
			stmt.setString(2, description);
			stmt.setInt(3, number);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteRoom(int id) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from rooms where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editRoom(int id, int hotel_id, String type_desription, int number) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("update rooms set hotel_id = ?, type_description = ?, number = ? where id = ?");
			stmt.setInt(1, hotel_id);
			stmt.setString(2, type_desription);
			stmt.setInt(3, number);
			stmt.setInt(4, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<RoomDto> getRoomsToList(){
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("select r.id as room_id, r.number as room_number, h.name as hotel from rooms as r join hotels as h on r.hotel_id = h.id");
			ResultSet rst;
		    rst = stmt.executeQuery();
		    
		    ArrayList<RoomDto> rooms = new ArrayList<RoomDto>();
		    
		    while(rst.next()) {
		    	rooms.add( new RoomDto(
		    			rst.getInt("room_id"),
		    			rst.getString("hotel"),
		    			rst.getInt("room_number")
		    			));
		    }
		    return rooms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public TableModel getRooms(String filter, int filterType) {
		try {
			Connection con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt;
			if (filterType == 1) {
				stmt = con.prepareStatement("select r.number, h.name, r.type_description from rooms as r join hotels as h on r.hotel_id = h.id where h.name = ?");
			} else {
				stmt = con.prepareStatement("select  r.number, h.name, r.type_description from rooms as r join hotels as h on r.hotel_id = h.id where r.type_description = ?");
			}
			
			stmt.setString(1, filter.trim());
			
			return ResultSetToTableModel(stmt.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
