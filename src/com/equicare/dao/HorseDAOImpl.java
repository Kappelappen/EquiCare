package com.equicare.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.equicare.model.FeedInfo;
import com.equicare.model.Health;
import com.equicare.model.Horse;
import com.equicare.model.Identification;
import com.equicare.model.Stable;
import com.equicare.model.TrainingInfo;
import com.equicare.model.UserComments;

public class HorseDAOImpl implements HorseDAO {

	private Connection conn;
	
	public HorseDAOImpl(Connection conn) {
		
		this.conn = conn;
		
	}

	@Override
	public Horse saveHorse(Horse horse) {

	    String sql = "INSERT INTO horses " +
	    "(name, breed, gender, birth_date, " +
	    "color, height, weight, status) " +
	    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	    
	    PreparedStatement stat = conn.prepareStatement(sql,
	    	Statement.RETURN_GENERATED_KEYS);

	        stat.setString(1, horse.getName());
	        stat.setString(2, horse.getBreed());
	        stat.setString(3, horse.getGender());
	        stat.setString(4, horse.getBirthdate());
	        stat.setString(5, horse.getColor());
	        stat.setString(6, horse.getHeight());
	        stat.setString(7, horse.getWeight());
	        stat.setString(8, horse.getStatus());

	        int affectedRows = stat.executeUpdate();

	        if (affectedRows == 0) {

	            throw new SQLException(
	                    "Creating horse failed, no rows affected."
	            );
	        }

	        ResultSet generatedKeys =
	        	stat.getGeneratedKeys();
	        
	        if (generatedKeys.next()) {

	        	int generatedId = generatedKeys.getInt(1);
	        	horse.setId(generatedId);

	            } else {

	                throw new SQLException(
	                        "Creating horse failed, no ID obtained."
	                );
	            }
	        
	        stat.close();
	        generatedKeys.close();

	    	} catch (SQLException ex) {
	    	
	    		ex.printStackTrace();
	    	
	    }	    

	    return horse;
	    
	}

	@Override
	public void saveFeeding(FeedInfo info) {
			    	    
	    String sql = "INSERT INTO feeding (horse_id," + 
	    "feed_type,daily_amount,supplements,feeding_notes) " + 
	    "VALUES (?,?,?,?,?)";
	    	    
	    try {
	    	
	    PreparedStatement stat = conn.prepareStatement(sql);
	    stat.setInt(1, info.getHorseId());
	    stat.setString(2, info.getType());
	    stat.setString(3, info.getAmount());
	    stat.setString(4, info.getSupplements());
	    stat.setString(5, info.getNotes());
	    
	    stat.executeUpdate();
	    stat.close();
	    
	    } catch (SQLException ex) { ex.printStackTrace(); }
	}

	@Override
	public void saveTraining(TrainingInfo training) {
				
	    String sql = "INSERT INTO training (horse_id," + 
	    "location,discipline,activity_level,trainer) " + 
	    "VALUES (?,?,?,?,?)";
	    
	    try {
	    	
	    PreparedStatement stat = conn.prepareStatement(sql);
	    stat.setInt(1, training.getHorseId());
	    stat.setString(2, training.getLocation());
	    stat.setString(3, training.getDiscipline());
	    stat.setString(4, training.getLevel());
	    stat.setString(5, training.getTrainer());
	    
	    stat.executeUpdate();
	    stat.close();
	    	
	    } catch (SQLException ex) { ex.printStackTrace(); }
	}

	@Override
	public void saveIdentification(Identification id) {
	
		String sql = "INSERT INTO identification (horse_id," + 
		"chip_number,passport_number,registration_number,insurance_number," + 
		"image_path) VALUES (?,?,?,?,?,?)";

		try {
					
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, id.getHorseId());
			stat.setString(2, id.getChipNumber());
			stat.setString(3, id.getPassportNumber());
			stat.setString(4, id.getRegistrationNumber());
			stat.setString(5, id.getInsuranceNumber());
			stat.setString(6, id.getImagePath());
			
			stat.executeUpdate();
			stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }			    		
	}

	@Override
	public void saveStable(Stable stable) {
			    
	    String sql = "INSERT INTO stable (horse_id," + 
	    "stable_name,stable_box,arrival_date,owner,emergency_contact) " + 
	    "VALUES (?,?,?,?,?,?)";
	    
	    try {
	    	
	    PreparedStatement stat = conn.prepareStatement(sql);
	    stat.setInt(1, stable.getHorseId());
	    stat.setString(2, stable.getName());
	    stat.setString(3, stable.getBox());
	    stat.setString(4, stable.getArrivalDate());
	    stat.setString(5, stable.getOwner());
	    stat.setString(6, stable.getEmergencyContact());
	    
	    stat.executeUpdate();
	    stat.close();
	    	
	    } catch (SQLException ex) { ex.printStackTrace(); }		
	}

	@Override
	public void saveHealth(Health health) {
		    
	    String sql = "INSERT INTO health (horse_id," + 
	    "veterinarian,allergies,medical_conditions," + 
	    "vaccination_status,last_checkup) " + 
	    "VALUES (?,?,?,?,?,?)";
	    
	    try {
	    	
	    PreparedStatement stat = conn.prepareStatement(sql);
	    stat.setInt(1, health.getHorseId());
	    stat.setString(2, health.getVeterinarian());
	    stat.setString(3, health.getAllergies());
	    stat.setString(4, health.getConditions());
	    stat.setString(5, health.getVaccinationStatus());
	    stat.setString(6, health.getLastCheckup());
	    
	    stat.executeUpdate();
	    stat.close();
	    
	    } catch (SQLException ex) { ex.printStackTrace(); }		
	}

	@Override
	public void saveComments(UserComments uc) {
	
		String sql = "INSERT INTO comments (horse_id," + 
		"content) VALUES (?,?)";
		
		try {
			
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, uc.getHorseId());
		stat.setString(2, uc.getComments());
		
		stat.executeUpdate();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }	
	}		
	
	@Override
	public void deleteHorse(int currentRow) {
	
		String sql = "DELETE FROM horses WHERE id = ?";
		
		try {
			
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, currentRow);
		stat.executeUpdate();
		stat.close();
			
		} catch (SQLException ex) { ex.printStackTrace(); }		
	}	
	
	@Override
	public List<Horse> findAll() {
				
		java.util.List<Horse> list = new ArrayList<>();
		
		try {
			
		String sql = "SELECT * FROM horses ORDER BY name ASC";		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString("name");
			String breed = rs.getString("breed");
			
			Horse horse = new Horse();
			
			horse.setId(id);
			horse.setName(name);
			horse.setBreed(breed);
			list.add(horse);
			
		}
		
		rs.close();
		stat.close();
		
		} catch (SQLException ex) { ex.printStackTrace(); }
		
		return list;
	
	}
	
	@Override
	public Horse findById(int horseId) {

	    String sql = "SELECT * FROM horses  WHERE id = ?";

	    try {
	    
	    PreparedStatement stat =
	    	conn.prepareStatement(sql);

	        stat.setInt(1, horseId);

	        ResultSet rs = stat.executeQuery();
	        
	        if (rs.next()) {

	        	Horse horse = new Horse();

	            horse.setId(rs.getInt("id"));
	            horse.setName(rs.getString("name"));
	            horse.setBreed(rs.getString("breed"));
	            horse.setGender(rs.getString("gender"));
	            horse.setBirthdate(rs.getString("birth_date"));
	            horse.setColor(rs.getString("color"));
	            horse.setHeight(rs.getString("height"));
	            horse.setWeight(rs.getString("weight"));
	            horse.setStatus(rs.getString("status"));

	            return horse;
	            
	        }

	    } catch (SQLException ex) {

	        throw new RuntimeException(
	        "Failed to find horse with id: " + horseId,ex);
	    
	    }

	    return null;
	
	}
	
	@Override
	public void updateHorse(int currentRow, Horse horse) {
			
		String sql = "UPDATE horses SET name = ?,breed = ?," + 
		"gender = ?,birth_date = ?,color = ?,height =  ?," + 
		"weight = ?,status = ? WHERE id = ?";
		
		try {
			
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, horse.getName());
        stat.setString(2, horse.getBreed());
        stat.setString(3, horse.getGender());
        stat.setString(4, horse.getBirthdate());
        stat.setString(5, horse.getColor());
        stat.setString(6, horse.getHeight());
        stat.setString(7, horse.getWeight());
        stat.setString(8, horse.getStatus());
        stat.setInt(9, currentRow);
        stat.executeUpdate();
        stat.close();
		
		} catch (SQLException ex) { ex.printStackTrace(); }
		
	}

	@Override
	public void updateIdentification(int currentRow, Identification id) {
		
		String sql = "UPDATE identification SET chip_number = ?," + 
		"passport_number = ?,registration_number = ?,insurance_number = ?," + 
		"image_path = ? WHERE horse_id = ?";
				
		try {
					
		PreparedStatement stat = conn.prepareStatement(sql);
				
		stat.setString(1, id.getChipNumber());
		stat.setString(2, id.getPassportNumber());
		stat.setString(3, id.getRegistrationNumber());
		stat.setString(4, id.getInsuranceNumber());
		stat.setString(5, id.getImagePath());
		stat.setInt(6, currentRow);
		
		stat.executeUpdate();
		stat.close();
				
		} catch (SQLException ex) { ex.printStackTrace(); }		
	}

	@Override
	public void updateStable(int currentRow, Stable stable) {
	
		String sql = "UPDATE stable SET stable_name = ?," + 
		"stable_box = ?,arrival_date = ?,owner = ?," + 
		"emergency_contact = ? WHERE horse_id = ?";
						
		try {
							
		PreparedStatement stat = conn.prepareStatement(sql);
						
		stat.setString(1, stable.getName());
		stat.setString(2, stable.getBox());
		stat.setString(3, stable.getArrivalDate());
		stat.setString(4, stable.getOwner());
		stat.setString(5, stable.getEmergencyContact());
		stat.setInt(6, currentRow);
				
		stat.executeUpdate();
		stat.close();
						
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	
	@Override
	public void updateFeeding(int currentRow, FeedInfo info) {
	
		String sql = "UPDATE feeding SET feed_type = ?," + 
		"daily_amount = ?,supplements = ?,feeding_notes = ? " + 
		"WHERE horse_id = ?";
						
		try {
							
		PreparedStatement stat = conn.prepareStatement(sql);
						
		stat.setString(1, info.getType());
		stat.setString(2, info.getAmount());
		stat.setString(3, info.getSupplements());
		stat.setString(4, info.getNotes());
		stat.setInt(5, currentRow);
				
		stat.executeUpdate();
		stat.close();
						
		} catch (SQLException ex) { ex.printStackTrace(); }
	}

	@Override
	public void updateTraining(int currentRow, TrainingInfo info) {
	
		String sql = "UPDATE training SET location = ?," + 
		"discipline = ?,activity_level = ?,trainer = ? " + 
		"WHERE horse_id = ?";
						
		try {
							
		PreparedStatement stat = conn.prepareStatement(sql);
						
		stat.setString(1, info.getLocation());
		stat.setString(2, info.getDiscipline());
		stat.setString(3, info.getLevel());
		stat.setString(4, info.getTrainer());
		stat.setInt(5, currentRow);
				
		stat.executeUpdate();
		stat.close();
						
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	
	@Override
	public void updateComments(int currentRow, UserComments comments) {
	
		String sql = "UPDATE comments SET content = ? " + 
		"WHERE horse_id = ?";
						
		try {
							
		PreparedStatement stat = conn.prepareStatement(sql);
						
		stat.setString(1, comments.getComments());
		stat.setInt(2, currentRow);
				
		stat.executeUpdate();
		stat.close();
						
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
}
