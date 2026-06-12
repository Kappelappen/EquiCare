package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.enums.TableName;
import com.equicare.event.action.AddHorseAction;
import com.equicare.model.ComboItem;
import com.equicare.model.Horse;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;

public class NewGeneralPanel extends JPanel {
	
	private NewHorseDialog nhDialog;
	
	private JLabel lblName;
	private JLabel lblBreed;
	private JLabel lblGender;
	private JLabel lblBirthdate;
	private JLabel lblColor;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JLabel lblStatus;
	
	public JTextField txtName;
	public ComboItemPanel jplBreeds;
	public ComboItemPanel jplGender;
	public JTextField txtColor;
	public JTextField txtHeight;
	public JTextField txtWeight;
	public ComboItemPanel jplStatus;
	
	public JComboBox<String> jcbBirthdate;
		
	private Box horizontalBox;
	
	public NewGeneralPanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
				
		this.lblName = new JLabel("Name");
		this.lblBreed = new JLabel("Breed");
		this.lblGender = new JLabel("Gender");
		this.lblBirthdate = new JLabel("Birthdate");
		this.lblColor = new JLabel("Color");
		this.lblHeight = new JLabel("Height");
		this.lblWeight = new JLabel("Weight");
		this.lblStatus = new JLabel("Status");
				
		this.txtName = new BasicTextField(30);
		this.txtWeight = new BasicTextField(30);
		
		this.jplBreeds = new 
			ComboItemPanel(TableName.horse_breed, 
			nhDialog.mWindow);		
		
		this.jplGender = new 
			ComboItemPanel(TableName.horse_gender, 
			nhDialog.mWindow);		
		
		this.jcbBirthdate = new ComboBoxCalendar();
		
		this.txtColor = new BasicTextField(30);
		this.txtHeight = new BasicTextField(30);
		
		this.jplStatus = new 
			ComboItemPanel(TableName.horse_status, 
			nhDialog.mWindow);
				
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
		this.add(lblName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblBreed, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplBreeds, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblGender, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplGender, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblBirthdate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(jcbBirthdate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblColor, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtColor, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblHeight, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtHeight, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblWeight, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtWeight, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblStatus, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplStatus, gbc);
				
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
	
	public Horse getHorse()  {
		
		String name = txtName.getText().trim();
		
		int breedIndex = jplBreeds.jcbSelectedItem.getSelectedIndex();
		Object breedObject = jplBreeds.jcbSelectedItem.getItemAt(breedIndex);
		ComboItem breedItem = (ComboItem)  jplBreeds.jcbSelectedItem.getItemAt(breedIndex);
		String selectedBreed = (breedItem == null) ? null : breedItem.getName();
		
		int genderIndex = jplGender.jcbSelectedItem.getSelectedIndex();
		ComboItem genderItem = (ComboItem) jplGender.jcbSelectedItem.getItemAt(genderIndex);
		String selectedGender = (genderItem == null) ? null : genderItem.getName();
		
		int dateIndex = jcbBirthdate.getSelectedIndex();
		String birthdate = jcbBirthdate.getItemAt(dateIndex);
		
		String color = txtColor.getText().trim();
		String height = txtHeight.getText().trim();
		String weight = txtWeight.getText().trim();
		
		int statusIndex = jplStatus.jcbSelectedItem.getSelectedIndex();
		ComboItem statusItem = (ComboItem) jplStatus.jcbSelectedItem.getItemAt(statusIndex);
		String selectedStatus = (statusItem == null) ? null : statusItem.getName();		
		
		Horse horse = new Horse();
		horse.setName(name);
		horse.setBreed(selectedBreed);
		horse.setGender(selectedGender);
		horse.setBirthdate(birthdate);
		horse.setColor(color);
		horse.setHeight(height);
		horse.setWeight(weight);
		horse.setStatus(selectedStatus);
		
		return horse;
		
	}
}
