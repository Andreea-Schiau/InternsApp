package com.DB.creation;

import java.sql.Connection;
import java.sql.DriverManager;

public class DescriptionDB {

	public String jdbc_driver = "com.mysql.jdbc.Driver";
	public String db_url = "jdbc:mysql://localhost/Internship";

	public String user = "root";
	public String pass = "root";

	public Connection conn;
	
	public void connection() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(db_url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
