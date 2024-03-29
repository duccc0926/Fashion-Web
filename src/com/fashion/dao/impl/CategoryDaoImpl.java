package com.fashion.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fashion.dao.CategoryDao;
import com.fashion.jdbc.JDBCConnection;
import com.fashion.model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

	@Override
	public void insert(Category category) {
		String sql = "INSERT INTO category(name, description) VALUES (?,?)";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Category category) {
		String sql = "UPDATE category SET name = ? , description = ? WHERE idcate = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			ps.setInt(3, category.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE idcate = ?";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Category get(String username) {
		String sql = "SELECT * FROM category WHERE name = ? ";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("idcate"));
				category.setName(rs.getString("name"));
				category.setDescription((rs.getString("description")));
				return category;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Category get(int id) {
		String sql = "SELECT * FROM category WHERE idcate = ? ";
		Connection con = super.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("idcate"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("idcate"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));

				categories.add(category);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public List<Category> search(String keyword) {
		List<Category> categories = new ArrayList<Category>();
		String sql = "SELECT * FROM category WHERE name LIKE ? ";
		Connection conn = super.getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();

				category.setId(rs.getInt("idcate"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));

				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;
	}

}
