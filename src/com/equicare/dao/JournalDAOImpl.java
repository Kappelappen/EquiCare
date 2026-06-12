package com.equicare.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.equicare.model.Category;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;

public class JournalDAOImpl 
	implements JournalDAO {

	private Connection conn;
	
	public JournalDAOImpl(Connection conn) {
		
		this.conn = conn;
		
	}
	
	@Override
	public List<Category> findCategories() {
		
		List list = new ArrayList<>();
		
		String sql = "SELECT * FROM categories";
		
		try {
			
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString("name");
			Category category = new Category();
			
			category.setId(id);
			category.setName(name);
			list.add(category);			
			
		}
		
		rs.close();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }
				
		return list;
	}

	@Override
	public void writeEntry(int horseId, JournalEntry entry) {

	    String sql =
	        "INSERT INTO journal (horse_id, date, category, headline, notes) " +
	        "VALUES (?, ?, ?, ?, ?)";

	    try {

	        PreparedStatement stat = conn.prepareStatement(
	            sql,
	            Statement.RETURN_GENERATED_KEYS
	        );

	        stat.setInt(1, horseId);
	        stat.setString(2, entry.getDate());
	        stat.setString(3, entry.getCategory());
	        stat.setString(4, entry.getHeadline());
	        stat.setString(5, entry.getNotes());

	        stat.executeUpdate();

	        ResultSet rs = stat.getGeneratedKeys();

	        if (rs.next()) {
	        
	        	int generatedId = rs.getInt(1);
	            entry.setId(generatedId);   // 🔥 HÄR sker magin
	        
	        }

	        rs.close();
	        stat.close();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	@Override
	public List<JournalEntry> findAll(int id) {
		
		List<JournalEntry> list = new ArrayList<>();
		
		try {
			
		String sql = "SELECT * FROM journal t1 " + 
		"LEFT JOIN horses t2 ON t1.horse_id = t2.id " + 
		"WHERE t2.id = ?";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet rs = stat.executeQuery();
		
		int tempId = 0;
		
		while (rs.next()) {
						
			int selectedId = rs.getInt(1);
			String name = rs.getString("name");
			String date = rs.getString("date");
			String category = rs.getString("category");
			String headline = rs.getString("headline");
			String notes = rs.getString("notes");			
			
			JournalEntry entry = new JournalEntry();			
			entry.setId(selectedId);						
			
			entry.setName(name);
			entry.setDate(date);
			entry.setCategory(category);
			entry.setHeadline(headline);
			entry.setNotes(notes);
			list.add(entry);
									
		}
		
		rs.close();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }
		
		return list;
	}

	@Override
	public JournalEntry findById(int id) {
			
		JournalEntry journalEntry = new JournalEntry();
		journalEntry.setId(id);
				
		try {
					
		String sql = "SELECT * FROM journal t1 " + 
		"JOIN horses t2 ON t1.horse_id = t2.id " + 
		"WHERE t1.id = ?";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
									
			int numValue = rs.getInt(1);
			String name = rs.getString("name");
			String date = rs.getString("date");
			String category = rs.getString("category");
			String headline = rs.getString("headline");
			String notes = rs.getString("notes");
						
			journalEntry.setId(numValue);
			journalEntry.setHorseId(numValue);
			journalEntry.setName(name);
			journalEntry.setDate(date);
			journalEntry.setCategory(category);
			journalEntry.setHeadline(headline);
			journalEntry.setNotes(notes);
						
		}
		
		rs.close();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }
		
		return journalEntry;
		
	}

	@Override
	public void updateEntry(int id, JournalEntry entry) {
		
		try {
						
		String sql = "UPDATE journal SET " + 
		"date = ?,category = ?,headline = ?,notes = ? " + 
		"WHERE id = ?";
	
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, entry.getDate());
		stat.setString(2, entry.getCategory());
		stat.setString(3, entry.getHeadline());
		stat.setString(4, entry.getNotes());
		stat.setInt(5, id);
		
		stat.executeUpdate();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }		
	}

	@Override
	public List<JournalEntry> findEntries() {
		
		java.util.List<JournalEntry> list = new ArrayList<>();
		
		try {
			
		String sql = "SELECT * FROM journal";
		Statement stat = conn.createStatement();
		ResultSet  rs = stat.executeQuery(sql);
				
		while (rs.next()) {
		
			int id = rs.getInt(1);			
			String name = rs.getString("horse");
			String date = rs.getString("date");
			String category = rs.getString("category");
			String headline = rs.getString("headline");
			String notes = rs.getString("notes");
			
			Category categoryEntry = new Category();
			categoryEntry.setId(id);
			categoryEntry.setName(category);
			
			JournalEntry entry = new JournalEntry();
			Horse horse = new Horse();
			
			entry.setId(id);			
			horse.setName(name);
			entry.setDate(date);
			entry.setCategory(category);
			entry.setHeadline(headline);
			entry.setNotes(notes);
			list.add(entry);	
			
		}
		
		rs.close();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }
		
		return list;
	}

	@Override
	public Horse findHorse(int journalId) {
			
		Horse horse = new Horse();
				
		try {
			
		String sql = "SELECT * FROM journal t1 " + 
		"LEFT JOIN horses t2 ON t2.id = t1.horse_id " + 
		"WHERE t1.id = ?";;
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, journalId);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
		
			int entryId = rs.getInt(1);
			String name = rs.getString("name");
			String breed = rs.getString("breed");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birth_date");
			String color = rs.getString("color");
			String height = rs.getString("height");
			String weight = rs.getString("weight");
			String status = rs.getString("status");
				
			horse.setId(entryId);
			horse.setName(name);
			horse.setBreed(breed);
			horse.setGender(gender);
			horse.setBirthdate(birthdate);
			horse.setColor(color);
			horse.setHeight(height);
			horse.setWeight(weight);
			horse.setStatus(status);
			
		}
		
		stat.close();
		rs.close();
		
		} catch (SQLException ex) { ex.printStackTrace(); }
		
		return horse;
	}

	@Override
	public void deleteJournal(int id) {
		
		try {
		
		String sql = "DELETE FROM journal WHERE id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, id);
		
		stat.executeUpdate();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
}