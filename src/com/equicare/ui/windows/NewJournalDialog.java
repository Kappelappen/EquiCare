package com.equicare.ui.windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.components.ComboBoxCalendar;
import com.equicare.ui.panels.ComboItemPanel;
import com.equicare.ui.panels.HorseJournalPanel;
import com.equicare.ui.panels.NewJournalPanel;
import com.equicare.enums.TableName;
import com.equicare.model.Category;
import com.equicare.model.ComboItem;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;

public class NewJournalDialog extends JDialog
	implements ActionListener {

	private int journalId;
	public MainWindow mWindow;
	
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnWrite;
	
	public NewJournalPanel jplNewJournal;
	private JScrollPane jspNewJournal;
	
	private JPanel jplMainView;
	private JPanel jplCommand;
	
	private Box horizontalBox;
	
	private JPanel jplContainer;
	
	public NewJournalDialog(int journalId, 
		MainWindow mWindow) {
				
		super(mWindow);
		
		this.journalId = journalId;
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJDialog();
		this.createLayout();
		this.registerEvents();
		
	}	
	
	private void initComponents() {
				
		this.btnUpdate = createJButton("Update");
		this.btnCancel = createJButton("Cancel");
		this.btnWrite = createJButton("Write");
				
		this.jplNewJournal = new NewJournalPanel(this);
		this.jspNewJournal = new JScrollPane(jplNewJournal);
		
		this.jplMainView = new JPanel(new GridBagLayout());
		this.jplCommand = new JPanel(new GridBagLayout());
		
		this.horizontalBox = Box.createHorizontalBox();		
		this.jplContainer = new JPanel(new GridBagLayout());
		
	}
	
	private void configJDialog() {
		
		this.setTitle("Journal");
		this.setContentPane(jplContainer);
		this.setModal(true);
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
			
	}
		
	private void createLayout() {
				
		this.configJPanelMainView();
		this.configJPanelCommand();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(6,6,0,6);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.fill = GridBagConstraints.BOTH;
		this.jplContainer.add(jplMainView, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,6,6);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.jplContainer.add(jplCommand, gbc);
		
	}
	
	private void configJPanelMainView() {
				
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.fill = GridBagConstraints.BOTH;
		this.jplMainView.add(jspNewJournal, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10,10,6,6);
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.jplMainView.add(jplCommand, gbc);
		
	}
	
	private void configJPanelCommand() {
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,3,0,3);
		this.jplCommand.add(btnCancel, gbc);
				
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0,0,0,6);
		
		if (journalId == 0) {
			
			this.jplCommand.add(btnWrite, gbc);
		
		}
		
		if (journalId != 0) {			

			this.jplCommand.add(btnUpdate);
			
		}		
	}
	
	private void registerEvents() {
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e)  {
				
				setDefaultItem();
				
				if (journalId != 0) {
					
					jplNewJournal.createFormData();
															
				}				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				jDialogClosing();
				
			}			
		});		
	}	
		
	private void jDialogClosing() {
		
		this.dispose();
				
		
		
	}
	
	private void setDefaultItem() {
		
		if (journalId != 0) {
		
			Horse horse = (Horse) mWindow.jplJournal.jcbSelectHorse.getSelectedItem();
			this.jplNewJournal.jcbHorses.setSelectedItem(horse);
			this.jplNewJournal.jcbHorses.setEnabled(false);
						
		}
	}
	
	private void btnUpdatePressed() {
						
		if (journalId != 0) {

			this.mWindow.jplJournal.model.setRowCount(0);
			
			int index = jplNewJournal.jcbHorses.getSelectedIndex();
			Horse horse = (Horse) jplNewJournal.jcbHorses.getItemAt(index);
			int rowId = horse.getId();
			
			JournalEntry parentEntry = jplNewJournal.getEntry();
			parentEntry.setId(journalId);
						
			this.mWindow.service.journalDAO.updateEntry(journalId, parentEntry);
			java.util.List<JournalEntry> entries = mWindow.service.fetchSelectedEntries(rowId);
						
			for (int i = 0; i < entries.size(); i++) {
				
				JournalEntry listEntry = entries.get(i);
				int currentId = listEntry.getId();
				String date = listEntry.getDate();
				String category = listEntry.getCategory();				
				
				Object[] rowData = 
					new Object[] { currentId, date, category };
				
				this.mWindow.jplJournal.model.addRow(rowData);
								
			}
		
			this.mWindow.jplJournal.model.fireTableDataChanged();
			this.jDialogClosing();						
				
		
		}		
	}

	private void btnCancelPressed() {
		
		this.jDialogClosing();
		
	}
	
	private void btnWritePressed() {

	    Horse selectedHorse =
	        (Horse) jplNewJournal.jcbHorses.getSelectedItem();

	    if (selectedHorse == null) {
	        JOptionPane.showMessageDialog(mWindow, "You must select a horse");
	        return;
	    }

	    JournalEntry entry = jplNewJournal.getEntry();

	    mWindow.service.saveEntry(selectedHorse.getId(), entry);

	    Object[] rowData = new Object[] {
	        entry.getId(),          
	        entry.getDate(),
	        entry.getCategory()
	    };

	    mWindow.jplJournal.model.addRow(rowData);	    
	    this.jDialogClosing();
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		Object obj = e.getSource();
		
		if (obj.equals(btnCancel)) {
			
			this.btnCancelPressed();
			
		}				
		
		if (obj.equals(btnUpdate)) {
			
			this.btnUpdatePressed();
			
		}
		
		if (obj.equals(btnWrite)) {
			
			this.btnWritePressed();
			
		}
	}
		
	private JButton createJButton(String label) {
		
		Dimension dim = new Dimension(96,30);
		JButton button = new JButton();
		
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		button.setText(label);
		button.addActionListener(this);
		
		return button;
		
	}
}
