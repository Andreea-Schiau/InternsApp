package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DB.CRUD.Holidays;
import com.DB.CRUD.Intern;
import com.DB.creation.CreateDB;
import com.DB.creation.CreateTables;
import com.DB.dao.UserDAOService;
import com.DB.model.User;

public class ConnectDB {

	public static void main(String[] args) {

		ConnectDB connDB = new ConnectDB();
		connDB.createConnection();
		
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("Spring-Module.xml");
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

				createAll(conn);

				System.out.println("Database connection success");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void createAll(Connection conn) {
		try {
//--------------DB creation-----------------------
			CreateDB createDB = new CreateDB();
			createDB.createDB(conn);

//--------------Tables creation in DB--------------
			CreateTables table = new CreateTables();
			table.User(conn);
			table.Person(conn);
			table.Holidays(conn);
			table.Intern(conn);
			table.Submodule(conn);
			table.Module(conn);

//--------------Tables creation in DB--------------
			Holidays holidays = new Holidays();
			holidays.getAll(conn);

//--------------crud-------------------------------
			Intern intern = new Intern();
			intern.getAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}