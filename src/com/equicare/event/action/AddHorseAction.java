package com.equicare.event.action;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.*;

import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;

public class AddHorseAction extends AbstractAction {

	private MainWindow mWindow;
	
	public AddHorseAction(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.configAction();
		
	}	
	
	private void configAction() {
		
		URL url = super.getClass().getResource("/images/add_horse.png");
		ImageIcon icon = new ImageIcon(url);
		
		super.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "Add a horse");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		super.setEnabled(false);		
		this.mWindow.jplHorseInfo.jtbHorseIndex.clearSelection();
				
		NewHorseDialog dialog = new NewHorseDialog(mWindow,0,"Add a horse");
		dialog.setVisible(true);
		
		super.setEnabled(true);
	
	}
}
