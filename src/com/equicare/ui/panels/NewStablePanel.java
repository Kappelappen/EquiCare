package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.model.Stable;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.windows.NewHorseDialog;

public class NewStablePanel extends JPanel {

	private NewHorseDialog nhDialog;
	
	private JLabel lblStableName;
	private JLabel lblStableBox;
	private JLabel lblArrivalDate;
	private JLabel lblOwner;
	private JLabel lblEmergencyContact;
	
	public JTextField txtStableName;
	public JTextField txtStableBox;	
	public JComboBox<String> jcbArrivalDate;
	public JTextField txtOwner;
	public JTextField txtEmergencyContact;
	
	private Box horizontalBox;
	
	public NewStablePanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.lblStableName = new JLabel("Stable Name");
		this.lblStableBox = new JLabel("Stable Box");
		this.lblArrivalDate = new JLabel("Arrival Date");
		this.lblOwner = new JLabel("Owner");
		this.lblEmergencyContact = new JLabel("Emergency Contact");
		
		this.txtStableName = new BasicTextField(30);
		this.txtStableBox = new BasicTextField(30);
		
		this.jcbArrivalDate = new ComboBoxCalendar();
		
		this.txtOwner = new BasicTextField(30);
		this.txtEmergencyContact = new BasicTextField(30);
		
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
		this.add(lblStableName, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtStableName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblStableBox, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtStableBox, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblArrivalDate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(jcbArrivalDate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblOwner, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtOwner, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblEmergencyContact, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtEmergencyContact, gbc);
				
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
	
	public Stable getStable() {
		
		String name = txtStableName.getText().trim();
		String box = txtStableBox.getText().trim();
		
		int arrivalIndex = jcbArrivalDate.getSelectedIndex();
		String arrivalDate = jcbArrivalDate.getItemAt(arrivalIndex);		
		String owner = txtOwner.getText().trim();		
		String emergencyContact = txtEmergencyContact.getText().trim();
		
		Stable stable = new Stable();
		
		stable.setName(name);
		stable.setStableBox(box);
		stable.setArrivalDate(arrivalDate);
		stable.setOwner(owner);
		stable.setEmergencyContact(emergencyContact);
		
		return stable;
		
	}	
}
