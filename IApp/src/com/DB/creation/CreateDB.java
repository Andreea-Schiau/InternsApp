package com.DB.creation;

import java.sql.*;

public class CreateDB {

	Statement stmt = null;
	DescriptionDB description = new DescriptionDB();

	public void createDB(Connection conn) {

		try {

			System.out.println("Creating database...");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE if not exists Internship";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
			}
		}
	}


	public void createMentorTable() throws ClassNotFoundException {

		try {
			try {
				Class.forName(description.jdbc_driver);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(description.db_url, description.user, description.pass);
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Mentor " + "(id INTEGER not NULL, " + " firstname VARCHAR(255), "
					+ " lastname VARCHAR(255), " + " email VARCHAR(255), " + " password VARCHAR(255), "
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}


//	public void createHolidaysTable() {
//
//		try {
//			try {
//				Class.forName(description.jdbc_driver);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			Connection conn = DriverManager.getConnection(description.db_url, description.user, description.pass);
//			System.out.println("Creating table in given database...");
//			stmt = conn.createStatement();
//
//			String sql = "CREATE TABLE if not exists Holidays " + "(start_date DATE, " + " due_date DATE)";
//
//			stmt.executeUpdate(sql);
//			System.out.println("Created table in given database...");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void createInternTable() {

		try {
			try {
				Class.forName(description.jdbc_driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Connection conn = DriverManager.getConnection(description.db_url, description.user, description.pass);
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE if not exists Intern " + "(start_date DATE, " + " due_date DATE)";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
