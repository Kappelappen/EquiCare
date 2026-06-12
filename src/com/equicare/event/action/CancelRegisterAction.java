package com.equicare.event.action;

import java.awt.event.ActionEvent;
import javax.swing.*;
import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;

public class CancelRegisterAction extends AbstractAction {

	private NewHorseDialog nhDialog;
	
	public CancelRegisterAction(NewHorseDialog nhDialog) {
		
		this.nhDialog = nhDialog;		
		this.configAction();
		
	}	
	
	private void configAction() {
		
		super.putValue(Action.NAME, "Cancel");
		super.putValue(Action.SHORT_DESCRIPTION, "Close Dialog");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.nhDialog.dispose();
		
	}
}
