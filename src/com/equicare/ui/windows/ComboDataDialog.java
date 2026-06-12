package com.equicare.ui.windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

import com.equicare.model.ComboItem;
import com.equicare.ui.components.BasicTextField;
import com.equicare.ui.panels.ComboItemPanel;

public class ComboDataDialog extends JDialog {
	
	private ComboItemPanel jplComboItem;
	
	private JLabel lblNewItem;
	private JTextField txtNewItem;
	
	private java.util.List<String> sortedList;
	
	private DefaultListModel<ComboItem> model;
	private JList<ComboItem> jltDataVault;
	private JScrollPane jspDataVault;
	
	private JButton btnNewItem;
	private JButton btnSaveItem;
	private JButton btnSortItem;
	private JButton btnDeleteItem;
	
	private JButton btnCancelAction;
	private JButton btnOkAction;
	
	private JPanel jplCommand;
	private JPanel jplContainer;
	
	public ComboDataDialog(ComboItemPanel jplComboItem) {
		
		this.jplComboItem = jplComboItem;
						
		this.initComponents();
		this.configJDialog();
		this.createLayout();
		this.registerEvents();
		
	}
	
	private void initComponents() {
		
		this.lblNewItem = new JLabel("Value");
		
		this.txtNewItem = new BasicTextField(30);
		
		this.model = new DefaultListModel<ComboItem>();
		this.jltDataVault = new JList<ComboItem>(model);
		this.jspDataVault = new JScrollPane(jltDataVault);
		
		this.btnNewItem = createJButton("New");
		this.btnSaveItem = createJButton("Save");
		this.btnSortItem = createJButton("Sort");
		this.btnDeleteItem = createJButton("Delete");
		
		this.btnCancelAction = createJButton("Cancel");
		this.btnOkAction = createJButton("Ok");
		
		this.jplCommand = new JPanel(new GridBagLayout());
		this.jplContainer = new JPanel(new GridBagLayout());
		
	}
	
	private void configJDialog() {
		
		this.configJList();
		this.populateJPanelCommand();
		
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setContentPane(jplContainer);
		this.setModal(true);
				
	}
	
	private void configJList() {
		
		String name = jplComboItem.name.name();
		
		java.util.List<ComboItem> list = 
				jplComboItem.mWindow.service.fetchComboItems(name);
		
		if (list.size() != 0) {
			
			this.populateListModel(list);
			
		}		
	}
	
	private void populateListModel(java.util.List<ComboItem> list) {
		
		for (int i = 0; i < list.size(); i++) {
			
			ComboItem item = list.get(i);
			this.model.addElement(item);
			
		}		
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(6,10,6,0);
		this.jplContainer.add(lblNewItem, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 10;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(6,10,6,6);
		this.jplContainer.add(txtNewItem, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,6,6,0);
		this.jplContainer.add(jspDataVault, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,6,6,6);
		this.jplContainer.add(btnNewItem, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,6,6,6);
		this.jplContainer.add(btnSaveItem, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,6,6,6);
		this.jplContainer.add(btnSortItem, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,6,6,6);
		this.jplContainer.add(btnDeleteItem, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 15;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(0,6,6,6);
		this.jplContainer.add(jplCommand, gbc);
		
	}
	
	private void populateJPanelCommand() {
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,0);
		this.jplCommand.add(btnCancelAction, gbc);
		
		gbc.gridx = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,3,3,0);
		this.jplCommand.add(btnOkAction, gbc);
		
	}
	
	private void btnNewPressed() {
		
		String text = this.txtNewItem.getText().trim();
		if (text.isBlank() || text.isEmpty()) return;	
		
		ComboItem item = new ComboItem();
		item.setName(text);
		
		this.model.addElement(item);
		this.txtNewItem.setText(null);
		
	}
	
	private void btnSavePressed() {
		
		String name = jplComboItem.name.name(); 
		this.jplComboItem.mWindow.service.insertComboItems(model, name);
				
		if (model.getSize() != 0) {
					
			this.jplComboItem.jcbSelectedItem.removeAllItems();
			this.jplComboItem.jcbSelectedItem.addItem(null);
			
			for (int i = 0; i < model.getSize(); i++) {
				
				ComboItem item = model.getElementAt(i);
				this.jplComboItem.jcbSelectedItem.addItem(item);
				
			}			
		}		
	}
	
	public void btnSortPressed() {

	    java.util.List<ComboItem> items = new ArrayList<>();

	    for (int i = 0; i < model.size(); i++) {
	 
	    	items.add(model.get(i));
	    
	    }

	    Collections.sort(items);
	    model.clear();

	    for (int i = 0; i < items.size(); i++) {
	    	
	    	ComboItem item = items.get(i);
	    	model.addElement(item);
	    	
	    }
	}
	
	private void btnDeletePressed() {
		
		int index = jltDataVault.getSelectedIndex();
		if (index == -1) return;
		
		this.model.removeElementAt(index);
		this.jltDataVault.revalidate();
		this.jltDataVault.requestFocusInWindow();
		
	}
	
	private void btnCancelPressed() {
		
		this.jDialogClosing();
		
	}
	
	private void btnOkPressed() {
		
		this.btnSavePressed();
		this.jDialogClosing();
		
	}
	
	private void registerEvents() {
		
		this.btnNewItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnNewPressed();
				
			}			
		});
		
		this.btnDeleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnDeletePressed();
				
			}			
		});
		
		this.btnSaveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnSavePressed();
				
			}			
		});
		
		this.btnSortItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnSortPressed();
				
			}			
		});
		
		this.btnCancelAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnCancelPressed();
				
			}			
		});
		
		this.btnOkAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnOkPressed();
				
			}			
		});
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				jDialogClosing();
				
			}			
		});		
	}	
	
	private void jDialogClosing() {
		
		this.dispose();
		
	}
	
	private JButton createJButton(String label) {
		
		Dimension dim = new Dimension(96,30);
		JButton button = new JButton();
		
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		button.setText(label);
		
		return button;
		
	}
}
