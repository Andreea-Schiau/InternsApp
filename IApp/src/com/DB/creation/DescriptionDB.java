package com.DB.creation;

public class DescriptionDB {

	String jdbc_driver = "com.mysql.jdbc.Driver";
	String db_url = "jdbc:mysql://localhost/Internship";

	String user = "root";
	String pass = "root";

	public void connection() {
		try {
			Class.forName(jdbc_driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
