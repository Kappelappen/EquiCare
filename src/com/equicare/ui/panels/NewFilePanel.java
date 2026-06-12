package com.equicare.ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.windows.NewHorseDialog;

public class NewFilePanel extends JPanel {

	private NewHorseDialog dialog;
	
	public JTextField txtFilePath;
	private JButton btnBrowseHandle;
		
	public NewFilePanel(NewHorseDialog dialog) {
		
		this.dialog = dialog;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		this.registerEvents();
		
	}	
	
	private void initComponents() {
		
		this.txtFilePath = new BasicTextField(30);
		this.btnBrowseHandle = createJButton("/images/camera.png");
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = GridBagConstraints.BOTH;
		this.add(txtFilePath, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		this.add(btnBrowseHandle, gbc);
		
		
	}
	
	private void registerEvents() {
		
		this.btnBrowseHandle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				browseActionEvent();
				
			}			
		});		
	}
	
	private void browseActionEvent() {
		
		this.btnBrowseHandle.setEnabled(false);
		
		FileNameExtensionFilter bildFilter = new FileNameExtensionFilter(
		"Imagefiles (*.jpg, *.jpeg, *.png, *.gif, *.bmp)",
	    "jpg", "jpeg", "png", "gif", "bmp");
		
		JFileChooser fileChooser = new JFileChooser();

	    // Sätt filtret
	    fileChooser.setFileFilter(bildFilter);
	    fileChooser.setAcceptAllFileFilterUsed(false);
	    
	    int result = fileChooser.showOpenDialog(dialog);
	    
	    if (result == JFileChooser.APPROVE_OPTION) {
	    	
	    	File file = fileChooser.getSelectedFile();
	    	String path = file.getAbsolutePath();
	    	this.txtFilePath.setText(path);
	    	
	    }
	    
	    this.btnBrowseHandle.setEnabled(true);
	    
	}
	
	private JButton createJButton(String path) {
		
		URL url = super.getClass().getResource(path);
		ImageIcon icon = new ImageIcon(url);
		
		Dimension dim = new Dimension(30,30);
		JButton button = new JButton();
		
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		button.setIcon(icon);
		
		return button;
		
	}
}
