package com.equicare.event.action;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.equicare.threads.HorseInfoPublisher;
import com.equicare.ui.windows.MainWindow;

public class DeleteHorseAction extends AbstractAction {

	private MainWindow mWindow;
	
	public DeleteHorseAction(MainWindow mWindow) {
		
		this.mWindow = mWindow;		
		this.configAction();
				
	}	
	
	private void configAction() {
		
		URL url = super.getClass().getResource("/images/delete_horse.png");
		ImageIcon icon = new ImageIcon(url);
		
		super.putValue(Action.SMALL_ICON, icon);
		super.putValue(Action.SHORT_DESCRIPTION, "Delete");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		JTable table = mWindow.jplHorseInfo.jtbHorseIndex;
		
		int tableRow = table.getSelectedRow();
		if (tableRow == -1) return;
		
		super.setEnabled(false);
		
		String msg = "<html><center>Do you wish to<br />" + 
		"delete the selected entry?</center></html>";
		
		int option = JOptionPane.showConfirmDialog(mWindow, msg);
		
		if (option == JOptionPane.YES_OPTION) {
									
			int horseId = (int) table.getValueAt(tableRow, 0);
			if (horseId == -1) return;
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			this.mWindow.service.doDeleteHorse(horseId);
			model.fireTableDataChanged();
			
			model.removeRow(tableRow);
			table.revalidate();
			
			this.selectFirstRow(table);
						
		}
		
		super.setEnabled(true);
		
	}
	
	public void selectFirstRow(final JTable table) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	        	
	            if (table.getRowCount() > 0) {
	            	
	                table.setRowSelectionInterval(0, 0);

	                Rectangle rect = table.getCellRect(0, 0, true);
	                table.scrollRectToVisible(rect);
	                
	                int selectedRow = table.getSelectedRow();
	                if (selectedRow == -1) return;
	                
	                int tableId = (int) table.getValueAt(selectedRow, 0);
	                if (tableId == 0) return;
	                
	                HorseInfoPublisher publisher = 
	                	new HorseInfoPublisher(tableId, mWindow);
	            
	                publisher.start();	                
	                
	            }
	        }
	    });
	}
}
