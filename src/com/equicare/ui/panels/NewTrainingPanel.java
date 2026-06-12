package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.enums.TableName;
import com.equicare.model.ComboItem;
import com.equicare.model.TrainingInfo;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.components.TextInputPanel;
import com.equicare.ui.windows.NewHorseDialog;

public class NewTrainingPanel extends JPanel {

	private NewHorseDialog nhDialog;
	
	private JLabel lblLocation;
	private JLabel lblDiscipline;
	private JLabel lblActivityLevel;
	private JLabel lblTrainer;
	
	public ComboItemPanel jplDiscipline;
	public ComboItemPanel jplActivityLevel;	
	
	public JTextField txtLocation;
	public JTextField txtTrainer;
	
	private Box horizontalBox;
	
	public NewTrainingPanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.lblLocation = new JLabel("Location");
		this.lblDiscipline = new JLabel("Discipline");
		this.lblActivityLevel = new JLabel("Activity Level");
		this.lblTrainer = new JLabel("Trainer");
		
		this.jplDiscipline = new 
			ComboItemPanel(TableName.discipline_type, 
			nhDialog.mWindow);
		
		this.jplActivityLevel = new 
			ComboItemPanel(TableName.activity_level, 
			nhDialog.mWindow);
		
		this.txtLocation = new BasicTextField(30);
		this.txtTrainer = new BasicTextField(30);
				
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
		this.add(lblLocation, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtLocation, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblDiscipline, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplDiscipline, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblActivityLevel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplActivityLevel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblTrainer, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtTrainer, gbc);
		
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
	
	public TrainingInfo getTrainingInfo() {
		
		String location = txtLocation.getText().trim();
		
		int disciplineIndex = jplDiscipline.jcbSelectedItem.getSelectedIndex();
		ComboItem disciplineItem = (ComboItem) jplDiscipline.jcbSelectedItem.getItemAt(disciplineIndex);
		String selectedDiscipline = (disciplineItem != null) ? disciplineItem.getName() : null;
		
		int activityIndex = jplActivityLevel.jcbSelectedItem.getSelectedIndex();
		ComboItem activeItem = (ComboItem) jplActivityLevel.jcbSelectedItem.getItemAt(activityIndex);
		String selectedLevel = (activeItem != null) ? activeItem.getName() : null;
		
		String trainer = txtTrainer.getText().trim();
		
		TrainingInfo info = new TrainingInfo();
		
		info.setLocation(location);
		info.setDiscipline(selectedDiscipline);
		info.setLevel(selectedLevel);
		info.setTrainer(trainer);
		
		return info;
		
	}
}
