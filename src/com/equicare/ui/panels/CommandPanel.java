package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;

import com.equicare.event.action.AddHorseAction;
import com.equicare.event.action.DeleteHorseAction;
import com.equicare.event.action.EditHorseAction;
import com.equicare.event.action.NewJournalAction;
import com.equicare.ui.windows.MainWindow;

public class CommandPanel extends JPanel {

	private MainWindow mWindow;
	
	private Action actionAdd;
	private Action actionEdit;
	private Action actionDelete;
	public Action actionJournal;
	
	private JButton btnAddHorse;
	private JButton btnEditHorse;
	private JButton btnDeleteHorse;
	private JButton btnJournal;
	
	public CommandPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
				
	}
	
	private void initComponents() {
		
		this.actionAdd = new AddHorseAction(mWindow);
		this.actionEdit = new EditHorseAction(mWindow);
		this.actionDelete = new DeleteHorseAction(mWindow);
		this.actionJournal = new NewJournalAction(mWindow);
		
		this.btnAddHorse = createJButton(actionAdd);
		this.btnEditHorse = createJButton(actionEdit);
		this.btnDeleteHorse = createJButton(actionDelete);
		this.btnJournal = createJButton(actionJournal);
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,3,0,3);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnAddHorse, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnEditHorse, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnDeleteHorse, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(btnJournal, gbc);
		
	}
	
	private JButton createJButton(Action action) {
		
		Dimension dim = new Dimension(43,43);
		JButton button = new JButton();
		
		button.setFont(new Font("Times New Roman",Font.BOLD,16));
		button.setHorizontalAlignment(JButton.CENTER);
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		button.setAction(action);
		
		return button;
		
	}
	
	@Override 
	public Insets getInsets() { return new Insets(3,3,3,3); }
	
}
