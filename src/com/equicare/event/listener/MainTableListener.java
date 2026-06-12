package com.equicare.event.listener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.equicare.threads.HorseInfoPublisher;
import com.equicare.ui.windows.MainWindow;

public class MainTableListener implements ListSelectionListener {
	
	private MainWindow mWindow;
	
	public MainTableListener(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()) return;
		
		int selectedRow = mWindow.jplHorseInfo.jtbHorseIndex.getSelectedRow();
		boolean state = (selectedRow != -1) ? true : false;
		if (selectedRow == -1) return;
		
		int tableId = (int) mWindow.jplHorseInfo.jtbHorseIndex.getValueAt(selectedRow, 0);
		if (tableId == -1) return;
				
		HorseInfoPublisher publisher = 
			new HorseInfoPublisher(tableId, mWindow);
		
		publisher.start();
			
		
	}	
}
