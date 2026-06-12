package com.equicare.application;

import java.awt.Color;
import java.awt.SystemColor;
import java.nio.file.Path;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.equicare.databasse.DataBank;
import com.equicare.service.EquiService;
import com.equicare.ui.windows.MainWindow;

public class Engine {

	public static void main(String[] args) {
		
		Runnable rbl = new Runnable() {
			
			@Override
			public void run() {
				
				Engine.config();
				Engine.start();
				
			}			
		};	
		
		SwingUtilities.invokeLater(rbl);
	
	}
	
	private static void config() {
		
		UIManager.put("ComboBox.disabledForeground", SystemColor.textText);
		UIManager.put("ComboBox.disabledBackground", Color.WHITE);
		
	}
	
	private static void start() {
				
		DataBank db = new DataBank();
		EquiService service = new EquiService(db);		
		
		db.connect();
		db.runMigrationOnce(Path.of("src/com/equicare/resources/sql/create_v01.sql"));
		db.runMigrationOnce(Path.of("src/com/equicare/resources/sql/insert_v01.sql"));
				
		MainWindow mWindow = new MainWindow(service);
		mWindow.setVisible(true);
		
	}	
}
