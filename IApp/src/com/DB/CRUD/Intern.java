package com.DB.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Intern {
	
	public void getAll(Connection conn) throws SQLException {

		String sql = "SELECT * FROM Intern";

		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			int id = result.getInt("id");
			String git = result.getString("git");
			String personId = result.getString("personId");
			String image = result.getString("image");

			String output = "Intern #%d: %s - %s - %s";
			System.out.println(String.format(output, ++count,id,  git, personId, image));
		}
	}
}
