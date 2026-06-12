package com.equicare.threads;

import java.awt.Component;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.equicare.ui.panels.BasicGeneralPanel;
import com.equicare.ui.windows.MainWindow;

public class HorseInfoEraser extends Thread {

	private MainWindow mWindow;
	
	public HorseInfoEraser(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
	}
	
	@Override
	public void run() {
		
		Runnable rbl = new Runnable() {
			
			@Override
			public void run() {
				
				cleanInfoPanels();
				
			}			
		};
		
		SwingUtilities.invokeLater(rbl);
		
	}
	
	private void cleanInfoPanels() {
		
		fetchGeneralPanel(mWindow.jplHorseInfo.jplGeneral);
				
	}
	
	private void fetchGeneralPanel(BasicGeneralPanel panel) {
		
		int index = panel.getComponentCount();
		
		for (int i = 0; i < index; i++) {
			
			Component formComp = panel.getComponent(i);
			
			if (formComp instanceof JTextComponent) {
				
				JTextComponent txtComp = (JTextComponent) formComp;
				txtComp.setText(null);
				
			}			
		}	
	}
}
