package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.enums.TableName;
import com.equicare.model.ComboItem;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.components.ItemComboBox;
import com.equicare.ui.windows.NewJournalDialog;

public class NewJournalPanel extends JPanel {

	private NewJournalDialog dialog;
	
	private JLabel lblHorses;
	private JLabel lblDate;
	private JLabel lblCategory;
	private JLabel lblHeadline;
	private JLabel lblNotes;
	
	public ItemComboBox jcbHorses;
	public JComboBox<String> jcbDate;
	public ComboItemPanel jplCategories;
	
	public JTextField txtHeadline;
	
	public JTextArea txtNotes;
	private JScrollPane jspNotes;
	
	public NewJournalPanel(NewJournalDialog dialog) {
		
		this.dialog = dialog;
		
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
		
		this.jcbHorses  = new ItemComboBox();
		this.jcbDate = new ComboBoxCalendar();
		
		this.jplCategories = new 
			ComboItemPanel(TableName.categories, dialog.mWindow);
		
		this.txtHeadline = new BasicTextField(30);
		
		this.txtNotes = new JTextArea();
		this.jspNotes = new JScrollPane(txtNotes);
		
	}
	
	private void configJPanel() {
	
		this.configJComboBoxHorses();
		this.configJTextArea();
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,6,6,0);
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
		this.add(jcbHorses, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,6,6,0);
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
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(jcbDate, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,6,6,0);
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
		this.add(jplCategories, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,6,6,0);
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
		gbc.insets = new Insets(6,6,0,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.VERTICAL;
		this.add(lblNotes, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(6,6,6,6);
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
	
	private void configJComboBoxHorses() {
		
		this.jcbHorses.addItem(null);
		
		java.util.List<Horse> list = dialog.mWindow.service.fetchAllHorses();
		
		for (int i = 0; i < list.size(); i++) {
			
			Horse horse = list.get(i);
			this.jcbHorses.addItem(horse);
			
		}		
	}
	
	public void createFormData() {
		
		int selectedRow = dialog.mWindow.jplJournal.jtbEntries.getSelectedRow();
		if (selectedRow == -1) return;
		
		int entryId = (int) dialog.mWindow.jplJournal.jtbEntries.getValueAt(selectedRow, 0);	
		System.out.println("tabell id " + entryId);
		
		JournalEntry entry = dialog.mWindow.service.findJournal(entryId);	
		
		Horse horse = dialog.mWindow.service.findJournalHorse(entryId);
		this.jcbHorses.setSelectedItem(horse);	
		
		String name = entry.getName();
		String date = entry.getDate();
		String categoryValue = entry.getCategory();
		String headline = entry.getHeadline();
		String notes = entry.getNotes();		
		
		ComboItem categoryItem = new ComboItem();
		categoryItem.setId(entryId);;
		categoryItem.setName(categoryValue);
		
		horse.setName(name);
		this.jcbDate.addItem(date);
		
		this.jplCategories.jcbSelectedItem.setSelectedItem(categoryItem);
		this.txtHeadline.setText(headline);
		this.txtNotes.setText(notes);
		
	}
	
	public JournalEntry getEntry() {

	    JournalEntry entry = new JournalEntry();

	    Horse horse = (Horse) jcbHorses.getSelectedItem();
	    if (horse == null) {
	        return null;
	    }

	    entry.setHorseId(horse.getId());
	    entry.setName(horse.getName());

	    String dateValue =
	        (String) jcbDate.getSelectedItem();
	    entry.setDate(dateValue);

	    ComboItem categoryItem =
	        (ComboItem) jplCategories.jcbSelectedItem.getSelectedItem();

	    if (categoryItem != null) {
	        entry.setCategory(categoryItem.getName());
	    } else {
	        entry.setCategory("");
	    }

	    entry.setHeadline(txtHeadline.getText().trim());
	    entry.setNotes(txtNotes.getText().trim());

	    return entry;
	
	}
}
