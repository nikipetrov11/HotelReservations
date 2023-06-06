package com.hotel.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSettings {
static Connection conn=null;
	
	public static Connection getConnection() throws SQLException {
			//Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection("jdbc:sqlserver://194.141.98.98\\MSSQL15.MSSQLSERVER:1433;databaseName=db1901262012;user=stu1901262012;password=6N6i6k6i!");
		
		
		return conn;
	}
}
