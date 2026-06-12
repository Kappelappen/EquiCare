package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.enums.TableName;
import com.equicare.model.FeedInfo;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.components.TextInputPanel;
import com.equicare.ui.windows.NewHorseDialog;

public class NewFeedingPanel extends JPanel {

	private NewHorseDialog nhDialog;
	
	private JLabel lblFeedType;
	private JLabel lblAmount;
	
	public JTextField txtFeedType;
	public JTextField txtAmount;
	
	public TextInputPanel jplSupplements;
	public TextInputPanel jplNotes;
	
	private Box horizontalBox;
	
	public NewFeedingPanel(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.lblFeedType = new JLabel("Feed Type");
		this.lblAmount = new JLabel("Daily Hay Amount");
		
		this.txtFeedType = new BasicTextField(30);
		this.txtAmount = new BasicTextField(30);
			
		this.jplSupplements = new TextInputPanel(true,"Supplements", 145);
		this.jplNotes = new TextInputPanel(true,"Feeding Notes",145);
		
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
		this.add(lblFeedType, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtFeedType, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,0);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblAmount, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtAmount, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		gbc.insets = new Insets(6,8,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplSupplements, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		gbc.insets = new Insets(0,8,6,6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(jplNotes, gbc);
		
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
	
	public FeedInfo getFeedInfo() {
		
		String type = txtFeedType.getText().trim();
		String amount = txtAmount.getText().trim();
		String supplmements = jplSupplements.txtMainView.getText();
		String notes = jplNotes.txtMainView.getText();
		
		FeedInfo info = new FeedInfo();
		
		info.setFeedType(type);
		info.setAmount(amount);
		info.setSupplements(supplmements);
		info.setNotes(notes);
		
		return info;
		
	}
	
}
