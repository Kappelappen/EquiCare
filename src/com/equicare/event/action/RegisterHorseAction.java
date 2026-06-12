package com.equicare.event.action;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.*;

import com.equicare.model.ComboItem;
import com.equicare.model.FeedInfo;
import com.equicare.model.Health;
import com.equicare.model.Horse;
import com.equicare.model.Identification;
import com.equicare.model.Stable;
import com.equicare.model.TrainingInfo;
import com.equicare.model.UserComments;
import com.equicare.threads.HorseInfoPublisher;
import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;

public class RegisterHorseAction extends AbstractAction {

	private NewHorseDialog nhDialog;
	
	public RegisterHorseAction(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;		
		this.configAction();
				
	}	
	
	private void configAction() {
		
		super.putValue(Action.NAME, "Add");
		super.putValue(Action.SHORT_DESCRIPTION, "Add");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		super.setEnabled(false);
		
		Horse formHorse = nhDialog.jplGeneral.getHorse();
		boolean result = nhDialog.mWindow.service.validateHorse(formHorse);	
				
		if (!result) {
		
			super.setEnabled(true);
		
		}
		
		if (result) {
						
			Horse savedHorse = nhDialog.mWindow.service.createHorse(formHorse);
			Identification formId = nhDialog.jplIdentification.getIdentification();
			Stable stable = nhDialog.jplStable.getStable();
			Health health = nhDialog.jplHealth.getHealth();
			FeedInfo feeding = nhDialog.jplFeeding.getFeedInfo();
			TrainingInfo training = nhDialog.jplTraining.getTrainingInfo();
			UserComments comments = nhDialog.jplComments.getComments();
			
			this.nhDialog.mWindow.service.saveHorseInfo(savedHorse, 
			formId, stable, health, feeding, training, comments);
			
			SwingUtilities.invokeLater(new Runnable() {
		        @Override
		        public void run() {
		        	
		        	JTable table = nhDialog.mWindow.jplHorseInfo.jtbHorseIndex;
		        	
		        	if (table.getRowCount() != 0) {
		        				        		
		        		int rowIndex = table.getRowCount();
		        		
		        		table.setRowSelectionInterval(0,0);
		        		
		                Rectangle rect = table.getCellRect(0, 0, true);
		                table.scrollRectToVisible(rect);
		                
		                int selectedRow = table.getSelectedRow();
		                int tableId = (int) table.getValueAt(selectedRow, 0);
		                
		                HorseInfoPublisher publisher = 
		                	new HorseInfoPublisher(tableId, nhDialog.mWindow);
		            
		                publisher.start();
		                
		                nhDialog.mWindow.jplJournal.jcbSelectHorsePressed();
		                		                		                
		            }
		        }
		    });			
			
			if (result) {
			
				nhDialog.mWindow.jplHorseInfo.populateJTable();
				nhDialog.dispose();
							
			}
		}
	}	
}
