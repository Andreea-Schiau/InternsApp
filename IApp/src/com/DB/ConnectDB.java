package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.DB.creation.CreateTables;

public class ConnectDB {

	public static void main(String[] args) {

		ConnectDB connDB = new ConnectDB();
		connDB.createConnection();
	}

	void createConnection() {

		String jdbc_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost/internship";

		String user = "root";
		String pass = "root";

		try {
			Class.forName(jdbc_driver);
			try {
				Connection conn = DriverManager.getConnection(db_url, user, pass);
				
//--------------DB creation-----------------------
//				CreateDB createDB = new CreateDB();
//				createDB.createDB(conn);

//--------------Tables creation in DB--------------
				CreateTables table = new CreateTables();
//				table.User(conn);
//				table.Person(conn);
//				table.Holidays(conn);
				table.Intern(conn);
//				table.Submodule(conn);
//				table.Module(conn);
				
//--------------Tables creation in DB--------------
//				Holidays holidays = new Holidays();
//				holidays.getAll(conn);
				
//--------------crud-------------------------------
//				Intern intern = new Intern();
//				intern.getAll(conn);
//				User userInternship = new User();
//				userInternship.getAll(conn);
				
				System.out.println("Database connection success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}