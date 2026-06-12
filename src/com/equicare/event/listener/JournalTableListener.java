package com.equicare.event.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.equicare.model.Horse;
import com.equicare.threads.JournalEntryPublisher;
import com.equicare.ui.panels.BasicJournalPanel;
import com.equicare.ui.panels.HorseJournalPanel;

public class JournalTableListener implements ListSelectionListener {
	
	private HorseJournalPanel jplJournal;
	
	public JournalTableListener(HorseJournalPanel jplJournal) {
		
		this.jplJournal = jplJournal;
				
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
									
		if (e.getValueIsAdjusting()) return;
						
		int selRow = jplJournal.jtbEntries.getSelectedRow();
		if (selRow == -1) return;
		
		int tableId = (int) jplJournal.jtbEntries.getValueAt(selRow, 0);
				
		JournalEntryPublisher publisher = 
			new JournalEntryPublisher(tableId, jplJournal);
		
		publisher.start();
		
	}
}
