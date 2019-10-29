package com.DB.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Holidays {
	
	public void getAll(Connection conn) throws SQLException {

		String sql = "SELECT * FROM Holidays";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			int id = result.getInt("id");
			String start_date = result.getString("start_date");
			String end_date = result.getString("end_date");
			String InternId = result.getString("InternId");

			String output = "Holiday #%d: %s - %s - %s";
			System.out.println(String.format(output, ++count,id, start_date, end_date, InternId));
		}
	}
}
