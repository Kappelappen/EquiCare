package com.equicare.event.action;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.*;

import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;
import com.equicare.ui.windows.NewJournalDialog;

public class NewJournalAction extends AbstractAction {

	private MainWindow mWindow;
	
	public NewJournalAction(MainWindow mWindow) {
				
		this.mWindow = mWindow;
		
		this.configAction();
						
	}	
	
	private void configAction() {
		
		URL url = super.getClass().getResource("/images/journal.png");
		ImageIcon icon = new ImageIcon(url);
		
		super.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "Journal");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		super.setEnabled(false);
				
		NewJournalDialog dialog = new NewJournalDialog(0, mWindow);
		dialog.setVisible(true);
		
		super.setEnabled(true);
		
	}
}
