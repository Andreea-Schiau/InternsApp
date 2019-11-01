package com.DB.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.DB.creation.DescriptionDB;
import com.DB.dao.UserDAOService;
import com.DB.model.User;
import com.mysql.fabric.xmlrpc.base.Array;

public class UserDaoServiceImpl implements UserDAOService {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean insert(User user) {

		Connection conn = null;

		DescriptionDB description = new DescriptionDB();
		String sql = "INSERT INTO user (email, password) VALUES (?, ?)";

		try {
			description.connection();
			PreparedStatement st = description.conn.prepareStatement(sql);
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());

			int rowsInserted = st.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
				return true;
			}
			return true;
		} catch (Exception ex) {
		}

		return false;
	}

	public User findById(int id) {

		String sql = "Select * FROM User WHERE id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("email"), rs.getString("password"));
			}

			rs.close();
			ps.close();
			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<User> getAll(){
		
		List<User> users = new ArrayList<>();

		//ceva din enu
		
		return users;
	}
}
