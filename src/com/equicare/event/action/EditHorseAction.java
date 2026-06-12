package com.equicare.event.action;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.*;

import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;

public class EditHorseAction extends AbstractAction {

	private MainWindow mWindow;
	
	public EditHorseAction(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.configAction();
		
	}	
	
	private void configAction() {
		
		URL url = super.getClass().getResource("/images/edit_horse.png");
		ImageIcon icon = new ImageIcon(url);
		
		super.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "Edit a horse");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTable table = mWindow.jplHorseInfo.jtbHorseIndex;
		
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) return;
		
		int modelRow = table.convertRowIndexToModel(selectedRow);		
		int idColumn = (int) table.getValueAt(modelRow, 0);
		
		super.setEnabled(false);
		
		NewHorseDialog dialog = 
			new NewHorseDialog(mWindow,idColumn,"Edit horse");
		
		dialog.setVisible(true);		
		super.setEnabled(true);
		
		
		
		
	}
}
