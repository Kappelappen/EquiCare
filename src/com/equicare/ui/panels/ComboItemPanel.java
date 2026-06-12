package com.equicare.ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;

import javax.swing.*;

import com.equicare.enums.TableName;
import com.equicare.model.ComboItem;
import com.equicare.model.HorseNode;
import com.equicare.ui.windows.ComboDataDialog;
import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewHorseDialog;
import com.equicare.ui.components.ItemComboBox;
import com.equicare.ui.renderers.ItemComboRenderer;

public class ComboItemPanel extends JPanel {
	
	public MainWindow mWindow;
	public TableName name;
	
	public ItemComboBox jcbSelectedItem;
	private JButton btnOpener;
	
	public ComboItemPanel(TableName name, 
		MainWindow mWindow) {
		
		this.name = name;
		this.mWindow = mWindow;
				
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.jcbSelectedItem = new ItemComboBox();
		this.btnOpener = createJButton();
		
	}
	
	private void configJPanel() {
		
		this.configJComboBox();
		this.populateJComboBox();
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void configJComboBox() {
		
		this.jcbSelectedItem.setRenderer(new ItemComboRenderer(3,3));
		
	}
	
	private void populateJComboBox() {
		
		this.jcbSelectedItem.addItem(null);
		this.fetchTableData();
			
	}
	
	private void fetchTableData() {
		
		String tableName = name.name();
		java.util.List<ComboItem> list = mWindow.service.fetchComboItems(tableName);
				
		for (int i = 0; i < list.size(); i++) {
			
			ComboItem item = list.get(i);
			this.jcbSelectedItem.addItem(item);
			
		}
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,0,0,2);
		this.add(jcbSelectedItem, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,0,0,0);
		this.add(btnOpener, gbc);
		
				
	}
	
	private void btnOpenerPressed() {
		
		this.btnOpener.setEnabled(false);
		
		ComboDataDialog dialog = new ComboDataDialog(this);
		dialog.setVisible(true);
		
		this.btnOpener.setEnabled(true);
		
	}
	
	private JButton createJButton() {
		
		URL url = super.getClass().getResource("/images/plus.gif");
		ImageIcon icon = new ImageIcon(url);
		
		Dimension dim = new Dimension(33,25);
		JButton button = new JButton();
		
		button.setHorizontalAlignment(JButton.CENTER);
		button.setIcon(icon);
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnOpenerPressed();
				
			}			
		});
		
		return button;
		
	}

}
