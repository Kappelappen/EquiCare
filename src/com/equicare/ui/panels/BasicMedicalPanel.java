package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.ui.windows.MainWindow;

public class BasicMedicalPanel extends JPanel {
	
	private MainWindow mWindow;
	
	public BasicMedicalPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
	}
}
