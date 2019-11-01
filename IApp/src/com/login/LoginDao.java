package com.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DB.CRUD.User;
import com.DB.creation.DescriptionDB;
import com.DB.user.model.User;
import com.mysql.jdbc.Connection;

public class LoginDao {

	DescriptionDB description = new DescriptionDB();
	String sql = "SELECT * FROM user WHERE email = ? and password = ?";

	public boolean check(String email, String password) {

		try {
			description.connection();
			PreparedStatement st = description.conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	public boolean insertUser(String email, String password) {

		DescriptionDB description = new DescriptionDB();
		String sql = "INSERT INTO user (email, password) VALUES (?, ?)";
		
    try {
			description.connection();
			PreparedStatement st = description.conn.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);

			int rowsInserted = st.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
				return true;
			}
		} catch (Exception ex) {
		}
  	return false;
	}
}
