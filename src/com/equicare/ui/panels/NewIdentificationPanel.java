package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.model.Identification;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.windows.NewHorseDialog;

public class NewIdentificationPanel extends JPanel {

	private NewHorseDialog nhDialog;
	
	private JLabel lblChipNumber;
	private JLabel lblPassportNumber;
	private JLabel lblRegistrationNumber;
	private JLabel lblInsuranceNumber;
	private JLabel lblImage;
	
	public JTextField txtChipNumber;
	public JTextField txtPassportNumber;
	public JTextField txtRegistrationNumber;
	public JTextField txtInsuranceNumber;
	
	public ImageFilePanel jplImageFile;
	
	private Box horizontalBox;
	
	public NewIdentificationPanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.lblChipNumber = new JLabel("Chip number");
		this.lblPassportNumber = new JLabel("Passport number");
		this.lblRegistrationNumber = new JLabel("Registration number");
		this.lblInsuranceNumber = new JLabel("Insurande number");
		this.lblImage = new JLabel("Image");
		
		this.txtChipNumber = new BasicTextField(30);
		this.txtPassportNumber = new BasicTextField(30);		
		this.txtRegistrationNumber = new BasicTextField(30);
		this.txtInsuranceNumber = new BasicTextField(30);
		
		this.jplImageFile = new ImageFilePanel(true);
		
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
		this.add(lblChipNumber, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtChipNumber, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblPassportNumber, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtPassportNumber, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblRegistrationNumber, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtRegistrationNumber, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblInsuranceNumber, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtInsuranceNumber, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblImage, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplImageFile, gbc);
		
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
	
	public Identification getIdentification() {
		
		String chipNumber = txtChipNumber.getText().trim();
		String passportNumber = txtPassportNumber.getText().trim();
		String registrationNumber = txtRegistrationNumber.getText().trim();
		String insuranceNumber = txtInsuranceNumber.getText().trim();
		String imagePath = jplImageFile.txtFilePath.getText().trim();
		
		Identification id = new Identification();
		id.setChipNumber(chipNumber);
		id.setPassportNumber(passportNumber);
		id.setRegistrationNumber(registrationNumber);
		id.setInsuranceNumber(insuranceNumber);
		id.setImagePath(imagePath);
		
		return id;
		
	}
}
