package UTILS;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionUtil {
	static String hostName = "localhost";
	static String dbName = "LoginDB";
	static String Username= "root";
	static String Password ="";
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection conn = (Connection) DriverManager.getConnection(connectionURL,Username,Password);
		return conn;
	}
}
