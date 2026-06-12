package com.equicare.event.action;

import java.awt.event.ActionEvent;
import javax.swing.*;

import com.equicare.model.FeedInfo;
import com.equicare.model.Health;
import com.equicare.model.Horse;
import com.equicare.model.Identification;
import com.equicare.model.Stable;
import com.equicare.model.TrainingInfo;
import com.equicare.model.UserComments;
import com.equicare.ui.windows.NewHorseDialog;

public class UpdateHorseAction extends AbstractAction {

	private NewHorseDialog nhDialog;
	
	public UpdateHorseAction(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;		
		this.configAction();
		
	}	
	
	private void configAction() {
				
		super.putValue(Action.NAME, "Update");
		super.putValue(Action.SHORT_DESCRIPTION, "Update");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int currentRow = nhDialog.tableId;
		if (currentRow == -1) return;
		
		Horse formHorse = nhDialog.jplGeneral.getHorse();
		Identification formId = nhDialog.jplIdentification.getIdentification();
        Stable stable = nhDialog.jplStable.getStable();
        Health health = nhDialog.jplHealth.getHealth();
        FeedInfo feeding = nhDialog.jplFeeding.getFeedInfo();
        TrainingInfo training = nhDialog.jplTraining.getTrainingInfo();
        UserComments comments = nhDialog.jplComments.getComments();
        
        this.nhDialog.mWindow.service.updateHorseInfo(currentRow, 
        formHorse, formId, stable, health, feeding, training, comments);
		
        this.nhDialog.mWindow.jplHorseInfo.populateJTable();
        this.nhDialog.dispose();
        
	}
}
