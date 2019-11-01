package com.DB.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	public void getAll(Connection conn) throws SQLException {

		String sql = "SELECT * FROM User";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			int id = result.getInt("id");
			String email = result.getString("email");
			String password = result.getString("password");

			String output = "User #%d: %s - %s - %s";
			System.out.println(String.format(output, ++count,id,  email, password));
		}
	}
}
