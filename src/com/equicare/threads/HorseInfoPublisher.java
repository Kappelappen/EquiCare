package com.equicare.threads;

import java.sql.*;
import javax.swing.SwingUtilities;

import com.equicare.ui.windows.MainWindow;

public class HorseInfoPublisher extends Thread {

	private int row;
	private MainWindow mWindow;
	
	public HorseInfoPublisher(int row, 
		MainWindow mWindow) {
		
		this.row = row;
		this.mWindow = mWindow;
				
	}
	
	@Override
	public void run() {
		
		Runnable rbl = new Runnable() {
			
			@Override
			public void run() {
		
				manageTabs();
				
			}			
		};
		
		SwingUtilities.invokeLater(rbl);
		
	}	
	
	private void manageTabs() {
		
		Connection conn = mWindow.service.getConnection();
			
		try {
		
		fetchGeneralInfo(conn);
		fetchIdentificationInfo(conn);
		fetchStableInfo(conn);
		fetchHealthInfo(conn);
		fetchTrainingInfo(conn);
		fetchFeedingInfo(conn);
		fetchComments(conn);
				
		} catch (SQLException ex) { ex.printStackTrace(); }
	}
	
	private void fetchGeneralInfo(Connection conn) 
		throws SQLException {
		
		String sql = "SELECT * FROM horses WHERE id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
			
			String name = rs.getString("name");
			String breed = rs.getString("breed");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birth_date");
			String color = rs.getString("color");
			String height = rs.getString("height");
			String weight = rs.getString("weight");
			String status = rs.getString("status");
			
			this.mWindow.jplHorseInfo.jplGeneral.txtName.setText(name);
			this.mWindow.jplHorseInfo.jplGeneral.txtBreeds.setText(breed);
			this.mWindow.jplHorseInfo.jplGeneral.txtGender.setText(gender);
			this.mWindow.jplHorseInfo.jplGeneral.txtBirthdate.setText(birthdate);
			this.mWindow.jplHorseInfo.jplGeneral.txtColor.setText(color);
			this.mWindow.jplHorseInfo.jplGeneral.txtHeight.setText(height);
			this.mWindow.jplHorseInfo.jplGeneral.txtWeight.setText(weight);
			this.mWindow.jplHorseInfo.jplGeneral.txtStatus.setText(status);
						
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void fetchIdentificationInfo(Connection conn) 
		throws SQLException {
		
		String sql = "SELECT * FROM identification WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
			
			String chipNumber = rs.getString("chip_number");
			String passportNumber = rs.getString("passport_number");
			String regNumber = rs.getString("registration_number");
			String insuranceNumber = rs.getString("insurance_number");
			String imagePath = rs.getString("image_path");
			
			this.mWindow.jplHorseInfo.jplIdentification.txtChipNumber.setText(chipNumber);
			this.mWindow.jplHorseInfo.jplIdentification.txtPassportNumber.setText(passportNumber);
			this.mWindow.jplHorseInfo.jplIdentification.txtRegistrationNumber.setText(regNumber);
			this.mWindow.jplHorseInfo.jplIdentification.txtInsuranceNumber.setText(insuranceNumber);
			this.mWindow.jplHorseInfo.jplIdentification.jplImageFile.txtFilePath.setText(imagePath);
			
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void fetchStableInfo(Connection conn) 
		throws SQLException {
			
		String sql = "SELECT * FROM stable WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
			
		ResultSet rs = stat.executeQuery();
			
		if (rs.next()) {
			
			String stableName = rs.getString("stable_name");
			String stableBox = rs.getString("stable_box");
			String arrivalDate = rs.getString("arrival_date");
			String owner = rs.getString("owner");
			String emergency = rs.getString("emergency_contact");
			
			this.mWindow.jplHorseInfo.jplStable.txtStableName.setText(stableName);
			this.mWindow.jplHorseInfo.jplStable.txtStableBox.setText(stableBox);
			this.mWindow.jplHorseInfo.jplStable.txtArrivalDate.setText(arrivalDate);
			this.mWindow.jplHorseInfo.jplStable.txtOwner.setText(owner);
			this.mWindow.jplHorseInfo.jplStable.txtEmergencyContact.setText(emergency);
		
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void fetchHealthInfo(Connection conn) 
		throws SQLException {
			
		String sql = "SELECT * FROM health WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
			
		ResultSet rs = stat.executeQuery();
			
		if (rs.next()) {
				
			String veterinarian = rs.getString("veterinarian");
			String allergies = rs.getString("allergies");
			String conditions = rs.getString("medical_conditions");
			String vaccination = rs.getString("vaccination_status");
			String lastCheckup = rs.getString("last_checkup");
				
			this.mWindow.jplHorseInfo.jplHealth.txtVeterinarian.setText(veterinarian);
			this.mWindow.jplHorseInfo.jplHealth.jplAllergies.txtMainView.setText(allergies);
			this.mWindow.jplHorseInfo.jplHealth.jplMedical.txtMainView.setText(conditions);
			this.mWindow.jplHorseInfo.jplHealth.txtVaccination.setText(vaccination);
			this.mWindow.jplHorseInfo.jplHealth.txtLastCheckup.setText(lastCheckup);
			
		}
		
		rs.close();
		stat.close();
		
	}	
	
	private void fetchTrainingInfo(Connection conn) 
		throws SQLException {
				
		String sql = "SELECT * FROM training WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
				
		ResultSet rs = stat.executeQuery();
				
		if (rs.next()) {
				
			String location = rs.getString("location");
			String discipline = rs.getString("discipline");
			String level = rs.getString("activity_level");
			String trainer = rs.getString("trainer");
			
			this.mWindow.jplHorseInfo.jplTraining.txtLocation.setText(location);
			this.mWindow.jplHorseInfo.jplTraining.txtDiscipline.setText(discipline);
			this.mWindow.jplHorseInfo.jplTraining.txtActivityLevel.setText(level);
			this.mWindow.jplHorseInfo.jplTraining.txtTrainer.setText(trainer);			
			
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void fetchFeedingInfo(Connection conn) 
		throws SQLException {
					
		String sql = "SELECT * FROM feeding WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
					
		ResultSet rs = stat.executeQuery();
					
		if (rs.next()) {
				
			String type = rs.getString("feed_type");
			String amount = rs.getString("daily_amount");
			String supplements = rs.getString("supplements");
			String notes = rs.getString("feeding_notes");
			
			this.mWindow.jplHorseInfo.jplFeeding.txtFeedType.setText(type);
			this.mWindow.jplHorseInfo.jplFeeding.txtAmount.setText(amount);
			this.mWindow.jplHorseInfo.jplFeeding.jplSupplements.txtMainView.setText(supplements);
			this.mWindow.jplHorseInfo.jplFeeding.jplNotes.txtMainView.setText(notes);
			
		}
	}
	
	private void fetchComments(Connection conn) 
		throws SQLException {
						
		String sql = "SELECT * FROM comments WHERE horse_id = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, row);
						
		ResultSet rs = stat.executeQuery();
						
		if (rs.next()) {
				
			String content = rs.getString("content");
			this.mWindow.jplHorseInfo.jplComments.txtComments.setText(content);
			
		}		
		
		rs.close();
		stat.close();
		
	}	
}
