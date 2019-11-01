package com.user.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.DB.CRUD.User;
import com.DB.creation.DescriptionDB;
import com.DB.user.model.User;
import com.mysql.jdbc.Connection;

public class UserManager {

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
}
