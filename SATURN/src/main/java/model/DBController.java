package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {
	
	private static DBController instance = null;
	
	private final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DATABASE = "jdbc:mysql://localhost/SaturnDB";
	private final String DATABASE_USR = "root";
	private final String DATABASE_PASS = "password";
	
	
	private Connection dbConnection;
	
	protected DBController() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DBController instance() {
		if(instance == null)
				instance = new DBController();
		return instance;
	}
	
	private void makeConnection() throws SQLException {
		dbConnection = DriverManager.getConnection(DATABASE, DATABASE_USR, DATABASE_PASS);
		
	}
	
	private void closeConnection() throws SQLException {
		if(dbConnection != null)
			dbConnection.close();
	}
}
