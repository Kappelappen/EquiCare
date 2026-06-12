package com.equicare.threads;

import java.sql.*;
import javax.swing.*;

import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;

import com.equicare.ui.panels.HorseJournalPanel;

public class JournalEntryPublisher extends Thread {
	
	private int tableId;
	private HorseJournalPanel jplJournal;
	
	public JournalEntryPublisher(int tableId, 
		HorseJournalPanel jplJournal) {
		
		this.tableId = tableId;
		this.jplJournal = jplJournal;
		
	}
	
	@Override
	public void run() {
		
		if (jplJournal.jtbEntries.getRowCount() != 0) {
			
			Runnable rbl = new Runnable() {
				
				@Override
				public void run() {
					
					cleanForm();
					publishFormData(tableId);
					
				}			
			};
			
			SwingUtilities.invokeLater(rbl);
		
		}		
	}
	
	private void cleanForm() {
		
		
		
	}
	
	private void publishFormData(int journalId) {
					
		JournalEntry entry = jplJournal.mWindow.service.findJournal(journalId);		
		
		String name = entry.getName();
		String date = entry.getDate();
		String category = entry.getCategory();
		String headline = entry.getHeadline();
		String notes = entry.getNotes();
		
		this.jplJournal.jplJournal.txtHorse.setText(name);				
		this.jplJournal.jplJournal.txtDate.setText(date);
		this.jplJournal.jplJournal.txtCategory.setText(category);
		this.jplJournal.jplJournal.txtHeadline.setText(headline);
		this.jplJournal.jplJournal.txtNotes.setText(notes);
		
	}
}
