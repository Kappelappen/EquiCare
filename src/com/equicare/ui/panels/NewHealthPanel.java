package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.enums.TableName;
import com.equicare.model.ComboItem;
import com.equicare.model.Health;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.components.TextInputPanel;
import com.equicare.ui.windows.NewHorseDialog;

public class NewHealthPanel extends JPanel {

	private NewHorseDialog nhDialog;
	
	private JLabel lblVeterinarian;
	private JLabel lblVaccination;
	private JLabel lblLastCheckup;
	
	public JTextField txtVeterinarian;
	
	public TextInputPanel jplAllergies;
	public TextInputPanel jplMedical;
		
	public ComboItemPanel jplVaccination;
	
	public JComboBox<String> jcbLastCheckup;
	
	private Box horizontalBox;
	
	public NewHealthPanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.lblVeterinarian = new JLabel("Veterinarian");
		this.lblVaccination = new JLabel("Vaccination Status");
		this.lblLastCheckup = new JLabel("Last Checkup");
		
		this.txtVeterinarian = new BasicTextField(30);
			
		this.jplAllergies = new TextInputPanel(true,"Allergies", 145);
		this.jplMedical = new TextInputPanel(true,"Medical Conditions",145);
		
		this.jplVaccination = new 
			ComboItemPanel(TableName.vaccination_status, 
			nhDialog.mWindow);
		
		this.jcbLastCheckup = new ComboBoxCalendar();
		
		this.horizontalBox = Box.createHorizontalBox();
			
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
				
		GridBagConstraints gbc = new GridBagConstraints();
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblVeterinarian, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtVeterinarian, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.insets = new Insets(6,8,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplAllergies, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		gbc.insets = new Insets(0,8,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplMedical, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblVaccination, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,8);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplVaccination, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,15,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblLastCheckup, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,15,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(jcbLastCheckup, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 50;
		gbc.gridwidth = 50;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(horizontalBox, gbc);
	
	}	
	
	public Health getHealth() {
		
		String veterinarian = txtVeterinarian.getText().trim();
		String allergies = jplAllergies.txtMainView.getText();
		String conditions = jplMedical.txtMainView.getText();
		
		int vaccinationIndex = jplVaccination.jcbSelectedItem.getSelectedIndex();		
		ComboItem vaccinationItem = (ComboItem) jplVaccination.jcbSelectedItem.getItemAt(vaccinationIndex);
		String selectedVaccination = (vaccinationItem == null) ? null : vaccinationItem.getName();
				
		int checkupIndex = jcbLastCheckup.getSelectedIndex();
		String checkup = jcbLastCheckup.getItemAt(checkupIndex);
		
		Health health = new Health();
		health.setVeterinarian(veterinarian);
		health.setAllergies(allergies);
		health.setConditions(conditions);
		health.setVaccinationStatus(selectedVaccination);
		health.setLastCheckup(checkup);
		
		return health;		
		
	}
	
}
