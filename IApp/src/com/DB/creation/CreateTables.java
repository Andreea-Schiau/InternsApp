package com.DB.creation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	DescriptionDB description = new DescriptionDB();
	Statement stmt = null;

	public void User(Connection conn) {
		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists User " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " email VARCHAR(255), " + " password VARCHAR(255), PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Person(Connection conn) {

		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Person " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " firstname VARCHAR(255), " + " lastname VARCHAR(255)," + " mentor BOOLEAN,"
					+ "UserId INTEGER not NULL REFERENCES User(id) ON DELETE CASCADE, PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Intern(Connection conn) {

		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Intern " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " git VARCHAR(255), "
					+ "PersonId INTEGER not NULL REFERENCES Person(id) ON DELETE CASCADE, PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Holidays(Connection conn) {
		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Holidays " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " start_date DATE, " + " end_date DATE,"
					+ "InternId INTEGER not NULL REFERENCES Intern(id) ON DELETE CASCADE, PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Submodule(Connection conn) {
		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Submodule " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " description VARCHAR(255), "
					+ "InternId INTEGER not NULL REFERENCES Intern(id) ON DELETE CASCADE, PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Module(Connection conn) {
		description.connection();

		try {
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Module " + "(id INTEGER not NULL AUTO_INCREMENT, "
					+ " description VARCHAR(255), "
					+ "SubmoduleId INTEGER not NULL REFERENCES Submodule(id) ON DELETE CASCADE, PRIMARY KEY (id))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
