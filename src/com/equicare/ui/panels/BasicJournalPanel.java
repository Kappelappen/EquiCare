package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.equicare.enums.TableName;
import com.equicare.model.ComboItem;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.windows.MainWindow;

public class BasicJournalPanel extends JPanel {

	private MainWindow mWindow;
	
	private JLabel lblHorses;
	private JLabel lblDate;
	private JLabel lblCategory;
	private JLabel lblHeadline;
	private JLabel lblNotes;
			
	public JTextField txtHorse;
	public JTextField txtDate;
	public JTextField txtCategory;
	public JTextField txtHeadline;
	
	public JTextArea txtNotes;
	private JScrollPane jspNotes;
	
	public BasicJournalPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}	
	
	private void initComponents() {
		
		this.lblHorses = new JLabel("Horses");
		this.lblDate = new JLabel("Date");
		this.lblCategory = new JLabel("Category");
		this.lblHeadline = new JLabel("Headline");
		this.lblNotes = new JLabel("Notes");
		
		this.txtHorse = new BasicTextField(30);
		this.txtDate = new BasicTextField(30);
		this.txtCategory = new BasicTextField(30);
		this.txtHeadline = new BasicTextField(30);
		
		this.txtNotes = new JTextArea();
		this.jspNotes = new JScrollPane(txtNotes);
		
	}
	
	private void configJPanel() {
			
		this.configAll();
		this.configJTextArea();
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void configAll() {
		
		this.txtHorse.setEnabled(false);
		this.txtDate.setEnabled(false);
		this.txtCategory.setEnabled(false);
		this.txtHeadline.setEnabled(false);
		this.txtNotes.setEnabled(false);
		
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,0,6,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblHorses, gbc);
				
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,6,6);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtHorse, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,0,6,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblDate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,10,6,6);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtDate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,0,6,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblCategory, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,10,6,6);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtCategory, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,0,6,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblHeadline, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,10,6,6);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(txtHeadline, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(6,0,0,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblNotes, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(6,0,6,6);
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(jspNotes, gbc);
		
	}
	
	private void configJTextArea() {
		
		this.txtNotes.setLineWrap(true);
		this.txtNotes.setWrapStyleWord(true);
		this.txtNotes.setTabSize(1);
		this.txtNotes.setMargin(new Insets(6,6,6,6));
		this.txtNotes.setFont(new Font("Arial",Font.PLAIN,16));
		this.txtNotes.setDisabledTextColor(SystemColor.textText);
		
	}
	
	@Override
	public Insets getInsets() { return new Insets(0,10,6,6); }
	
}
