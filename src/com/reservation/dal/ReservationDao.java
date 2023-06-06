package com.reservation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import com.hotel.dal.AbstractDao;
import com.hotel.dal.DatabaseConnectionSettings;
import com.hotel.model.Hotel;

public class ReservationDao extends AbstractDao {
	public TableModel getReservations() {
		try {
			Connection con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from Reservation");
			return ResultSetToTableModel(stmt.executeQuery());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addReservation(String fromDate, String toDate, String guest, int hotelId) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into reservation (from_date, to_date, guest_name, hotel_id) values (?, ?, ?, ?)");
			stmt.setString(1, fromDate);
			stmt.setString(2, toDate);
			stmt.setString(3, guest);
			stmt.setInt(4, hotelId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteReservation(int id) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("delete from reservation where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editReservation(int id, String from_date, String to_date, String guest_name, int hotel_id) {
		Connection con;
		try {
			con = DatabaseConnectionSettings.getConnection();
			PreparedStatement stmt = con.prepareStatement("update reservation set from_date = ?, to_date = ?, guest_name = ?, hotel_id = ? where id = ?");
			stmt.setString(1, from_date);
			stmt.setString(2, to_date);
			stmt.setString(3, guest_name);
			stmt.setInt(4, hotel_id);
			stmt.setInt(5, id);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
