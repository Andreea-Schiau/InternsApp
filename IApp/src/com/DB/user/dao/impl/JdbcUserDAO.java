package com.DB.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.DB.user.dao.UserDAO;
import com.DB.user.model.User;

public class JdbcUserDAO implements UserDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(User user) {

		String sql = "INSERT INTO USER " + "(email, password) VALUES (?, ?)";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ps.close();
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

	public User findByUserId(int id) {

		String sql = "Select * FROM User WHERE id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("email"),
					rs.getString("password")
				);
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
}
