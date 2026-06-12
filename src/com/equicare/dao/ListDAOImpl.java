package com.equicare.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import com.equicare.model.ComboItem;
import com.equicare.model.Horse;

public class ListDAOImpl implements ListDAO {

	private Connection conn;

	public ListDAOImpl(Connection conn) {

		this.conn = conn;

	}

	public void saveAll(DefaultListModel<ComboItem> model, String tableName) {

		String deleteSql = "DELETE FROM " + tableName;

		String insertSql = "INSERT INTO " + tableName + " (name) VALUES (?)";

		try (

				PreparedStatement deletePs = conn.prepareStatement(deleteSql);
				PreparedStatement insertPs = conn.prepareStatement(insertSql, 
					Statement.RETURN_GENERATED_KEYS)) {

			// Remove all existing rows
			deletePs.executeUpdate();

			// Insert all items again
			for (int i = 0; i < model.size(); i++) {

				ComboItem item = model.get(i);

				if (item != null && item.getName() != null && !item.getName().isBlank()) {

					insertPs.setString(1, item.getName());
					insertPs.executeUpdate();

					try (ResultSet rs = insertPs.getGeneratedKeys()) {

						if (rs.next()) {

							int generatedId = rs.getInt(1);
							item.setId(generatedId);

						}
					}
				}
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	public java.util.List<ComboItem> findComboItems(String tableName) {

		java.util.List<ComboItem> list = new ArrayList<>();

		try {

			String sql = "SELECT * FROM " + tableName;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString("name");
				ComboItem item = new ComboItem();
				
				item.setId(id);
				item.setName(name);
				list.add(item);

			}

			stat.close();
			rs.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;

	}
}
