package com.equicare.threads;

import java.sql.*;

import javax.swing.SwingUtilities;

import com.equicare.model.ComboItem;
import com.equicare.ui.panels.NewCommentsPanel;
import com.equicare.ui.panels.NewFeedingPanel;
import com.equicare.ui.panels.NewGeneralPanel;
import com.equicare.ui.panels.NewHealthPanel;
import com.equicare.ui.panels.NewIdentificationPanel;
import com.equicare.ui.panels.NewStablePanel;
import com.equicare.ui.panels.NewTrainingPanel;
import com.equicare.ui.windows.NewHorseDialog;

public class HorseInfoAuthor extends Thread {

	private NewHorseDialog nhDialog;
	
	public HorseInfoAuthor(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
	}
	
	@Override
	public void run() {
		
		int selectedId = nhDialog.tableId;
		
		Runnable rbl = new Runnable() {
			
			@Override
			public void run() {
				
				Connection conn = nhDialog.mWindow.service.getConnection();
				
				try {
										
				writeGeneralInfo(nhDialog.jplGeneral,conn, selectedId);
				writeIdentificationInfo(nhDialog.jplIdentification,conn,selectedId);
				writeStableInfo(nhDialog.jplStable,conn,selectedId);			
				writeHealthInfo(nhDialog.jplHealth,conn,selectedId);
				writeFeedingInfo(nhDialog.jplFeeding,conn,selectedId);
				writeTrainingInfo(nhDialog.jplTraining,conn,selectedId);
				writeComments(nhDialog.jplComments,conn,selectedId);
				
				} catch (SQLException ex) { ex.printStackTrace(); }
				
			}			
		};
		
		SwingUtilities.invokeLater(rbl);
		
	}
	
	private void writeGeneralInfo(NewGeneralPanel panel, 
		Connection conn, int selectedId) throws SQLException {
				
		String sql = "SELECT * FROM horses WHERE id = ?";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString("name");
			String breed = rs.getString("breed");
			String gender = rs.getString("gender");
			String birthdate = rs.getString("birth_date");
			String color = rs.getString("color");
			String height = rs.getString("height");
			String weight = rs.getString("weight");
			String status = rs.getString("status");
			
			ComboItem breedItem = new ComboItem();
			breedItem.setId(id);
			breedItem.setName(breed);
			
			ComboItem genderItem = new ComboItem();
			genderItem.setId(id);
			genderItem.setName(gender);
		
			ComboItem statusItem = new ComboItem();
			statusItem.setId(id);
			statusItem.setName(status);
			panel.txtName.setText(name);
			panel.jplBreeds.jcbSelectedItem.setSelectedItem(breedItem);		
			panel.jplGender.jcbSelectedItem.setSelectedItem(genderItem);
			
			panel.jcbBirthdate.addItem(birthdate);
			panel.txtColor.setText(color);
			panel.txtHeight.setText(height);
			panel.txtWeight.setText(weight);
			panel.jplStatus.jcbSelectedItem.setSelectedItem(statusItem);
			
		}		
		
		rs.close();
		stat.close();
		
	}
	
	private void writeIdentificationInfo(NewIdentificationPanel panel, 
		Connection conn, int selectedId) throws SQLException {
		
		String sql = "SELECT * FROM identification WHERE horse_id = ?";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
			
			String chipNumber = rs.getString("chip_number");
			String passportNumber = rs.getString("passport_number");
			String registrationNumber = rs.getString("registration_number");
			String insuranceNumber = rs.getString("insurance_number");
			String image = rs.getString("image_path");
			
			panel.txtChipNumber.setText(chipNumber);
			panel.txtPassportNumber.setText(passportNumber);
			panel.txtRegistrationNumber.setText(registrationNumber);
			panel.txtInsuranceNumber.setText(insuranceNumber);
			panel.jplImageFile.txtFilePath.setText(image);
			
		}	
				
		rs.close();
		stat.close();
		
	}
	
	private void writeStableInfo(NewStablePanel panel, 
		Connection conn, int selectedId) throws SQLException {
		
		String sql = "SELECT * FROM stable WHERE horse_id = ?";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
		
		ResultSet rs = stat.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString("stable_name");
			String stableBox = rs.getString("stable_box");
			String arrivalDate = rs.getString("arrival_date");
			String owner = rs.getString("owner");
			String emergencyContact = rs.getString("emergency_contact");
			
			panel.txtStableName.setText(name);
			panel.txtStableBox.setText(stableBox);
			panel.jcbArrivalDate.addItem(arrivalDate);
			panel.txtOwner.setText(owner);
			panel.txtEmergencyContact.setText(emergencyContact);
			
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void writeHealthInfo(NewHealthPanel panel, 
		Connection conn, int selectedId) throws SQLException {
			
		String sql = "SELECT * FROM health WHERE horse_id = ?";
			
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
			
		ResultSet rs = stat.executeQuery();
			
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String veterinarian = rs.getString("veterinarian");
			String allergies = rs.getString("allergies");
			String conditions = rs.getString("medical_conditions");
			String vaccination = rs.getString("vaccination_status");
			String lastCheckup = rs.getString("last_checkup");
			
			ComboItem statusItem = new ComboItem();
			statusItem.setId(id);
			statusItem.setName(vaccination);
			
			panel.txtVeterinarian.setText(veterinarian);
			panel.jplAllergies.txtMainView.setText(allergies);
			panel.jplMedical.txtMainView.setText(conditions);
			panel.jplVaccination.jcbSelectedItem.setSelectedItem(statusItem);
	
			panel.jcbLastCheckup.addItem(lastCheckup);
				
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void writeFeedingInfo(NewFeedingPanel panel, 
		Connection conn, int selectedId) throws SQLException {
				
		String sql = "SELECT * FROM feeding WHERE horse_id = ?";
				
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
				
		ResultSet rs = stat.executeQuery();
				
		if (rs.next()) {
		
			String feedType = rs.getString("feed_type");
			String amount = rs.getString("daily_amount");
			String supplements = rs.getString("supplements");
			String notes = rs.getString("feeding_notes");
			
			panel.txtFeedType.setText(feedType);
			panel.txtAmount.setText(amount);
			panel.jplSupplements.txtMainView.setText(supplements);
			panel.jplNotes.txtMainView.setText(notes);
			
		}
		
		rs.close();
		stat.close();
		
	}
	
	private void writeTrainingInfo(NewTrainingPanel panel, 
		Connection conn, int selectedId) throws SQLException {
			
		String sql = "SELECT * FROM training WHERE horse_id = ?";
			
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
			
		ResultSet rs = stat.executeQuery();
			
		while (rs.next()) {
				
			int id = rs.getInt(1);
			String location = rs.getString("location");
			String discipline = rs.getString("discipline");
			String level = rs.getString("activity_level");
			String trainer = rs.getString("trainer");
			
			ComboItem disciplineItem = new ComboItem();
			disciplineItem.setId(id);
			disciplineItem.setName(discipline);
			
			ComboItem levelItem = new ComboItem();
			levelItem.setId(id);
			levelItem.setName(level);
			
			panel.txtLocation.setText(location);
			panel.jplDiscipline.jcbSelectedItem.setSelectedItem(disciplineItem);
			panel.jplActivityLevel.jcbSelectedItem.setSelectedItem(levelItem);
			panel.txtTrainer.setText(trainer);
						
		}
	}
	
	private void writeComments(NewCommentsPanel panel, 
		Connection conn, int selectedId) throws SQLException {
				
		String sql = "SELECT * FROM comments WHERE horse_id = ?";
				
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, selectedId);
				
		ResultSet rs = stat.executeQuery();
				
		if (rs.next()) {
			
			String content = rs.getString("content");
			panel.txtComments.setText(content);
			
		}
		
		rs.close();
		stat.close();
		
	}
}
