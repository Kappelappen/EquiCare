package com.equicare.ui.windows;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import com.equicare.event.action.CancelRegisterAction;
import com.equicare.event.action.RegisterHorseAction;
import com.equicare.event.action.UpdateHorseAction;
import com.equicare.threads.HorseInfoAuthor;
import com.equicare.threads.HorseInfoEraser;
import com.equicare.ui.panels.NewCommentsPanel;
import com.equicare.ui.panels.NewFeedingPanel;
import com.equicare.ui.panels.NewGeneralPanel;
import com.equicare.ui.panels.NewHealthPanel;
import com.equicare.ui.panels.NewIdentificationPanel;
import com.equicare.ui.panels.NewStablePanel;
import com.equicare.ui.panels.NewTrainingPanel;

public class NewHorseDialog extends JDialog {

	public MainWindow mWindow;
	public int tableId;
	private String title;
	
	public NewGeneralPanel jplGeneral;
	public NewIdentificationPanel jplIdentification;
	public NewStablePanel jplStable;
	public NewHealthPanel jplHealth;
	public NewFeedingPanel jplFeeding;
	public NewTrainingPanel jplTraining;
	public NewCommentsPanel jplComments;
	
	private JScrollPane jspGeneral;
	private JScrollPane jspIdentification;
	private JScrollPane jspStable;
	private JScrollPane jspHealth;
	private JScrollPane jspFeeding;
	private JScrollPane jspTraining;
	
	private JTabbedPane jtpMainView;
	
	private Action actionCancel;
	private Action actionRegister;
	private Action actionUpdate;
	private Action selectedAction;
	
	private JButton btnCancel;
	private JButton btnRegister;
	
	private JPanel jplCommand;
	private JPanel jplContainer;
	
	public NewHorseDialog(MainWindow mWindow, 
		int tableId, String title) {
		
		super(mWindow);
		
		this.mWindow = mWindow;
		this.tableId = tableId;
		this.title = title;
		
		this.initComponents();
		this.configJDialog();
		this.createLayout();
		this.registerEvents();
		
	}
	
	private void initComponents() {
				
		this.jplGeneral = new NewGeneralPanel(this);
		this.jplIdentification = new NewIdentificationPanel(this);
		this.jplStable = new NewStablePanel(this);
		this.jplHealth = new NewHealthPanel(this);
		this.jplFeeding = new NewFeedingPanel(this);
		this.jplTraining = new NewTrainingPanel(this);
		this.jplComments = new NewCommentsPanel();
		
		this.jspGeneral = new JScrollPane(jplGeneral);
		this.jspIdentification = new JScrollPane(jplIdentification);
		this.jspStable = new JScrollPane(jplStable);
		this.jspHealth = new JScrollPane(jplHealth);
		this.jspFeeding = new JScrollPane(jplFeeding);
		this.jspTraining = new JScrollPane(jplTraining);
		
		this.jtpMainView = new JTabbedPane(JTabbedPane.TOP);
		
		this.actionCancel = new CancelRegisterAction(this);
		this.actionRegister = new RegisterHorseAction(this);
		this.actionUpdate = new UpdateHorseAction(this);
		
		this.selectedAction = (tableId != 0) ? 
		actionUpdate : actionRegister;
		
		this.btnCancel = createJButton(actionCancel);
		this.btnRegister = createJButton(selectedAction);
		
		this.jplCommand = new JPanel(new GridBagLayout());
		this.jplContainer = new JPanel(new GridBagLayout());
		
	}
	
	private void configJDialog() {
		
		this.populateJTabbedPane();
		
		this.setTitle(title);
		this.setSize(700,500);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setContentPane(jplContainer);
		
	}
	
	private void createLayout() {
		
		this.buildJPanelCommand();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		this.jplContainer.add(jtpMainView, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		this.jplContainer.add(jplCommand, gbc);
		
	}
	
	private void populateJTabbedPane() {
		
		this.jtpMainView.addTab("General", jspGeneral);
		this.jtpMainView.addTab("Identification", jspIdentification);
		this.jtpMainView.addTab("Stable", jspStable);
		this.jtpMainView.addTab("Health", jspHealth);
		this.jtpMainView.addTab("Feeding", jspFeeding);
		this.jtpMainView.addTab("Training", jspTraining);
		this.jtpMainView.addTab("Comments", jplComments);
		
	}
	
	private void buildJPanelCommand() {
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		this.jplCommand.add(btnCancel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(3,0,3,0);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.BOTH;
		this.jplCommand.add(btnRegister, gbc);
		
	}
	
	private void registerEvents() {
		
		this.addWindowListener(new WindowAdapter() {
							
			@Override
			public void windowOpened(WindowEvent e) {
				
				jDialogOpened();
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				jDialogClosing();
				
			}			
		});		
	}
	
	private void jDialogOpened() {
		
		HorseInfoAuthor author = new HorseInfoAuthor(this);
		author.start();
		
	}
	
	private void jDialogClosing() {
		
		HorseInfoEraser eraser = new HorseInfoEraser(mWindow);
		
		eraser.start();
		eraser = null;
		super.dispose();
		
	}
	
	private JButton createJButton(Action action) {
		
		Dimension dim = new Dimension(113,45);
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
}
