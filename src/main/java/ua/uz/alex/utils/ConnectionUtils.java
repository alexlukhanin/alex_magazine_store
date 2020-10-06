package ua.uz.alex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static String USER_NAME = "test";
	private static String USER_PASSWORD = "pass";
	private static String URL = "jdbc:mysql://localhost/m_shop";
	
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName ("com.mysql.cj.jdbc.Driver").newInstance (); // not necessary for Java 6 and above
		return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
	}
}
