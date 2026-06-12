package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.equicare.event.action.AddHorseAction;
import com.equicare.ui.windows.MainWindow;

public class BasicRegistryPanel extends JPanel {
	
	private MainWindow mWindow;
		
	public DefaultTableModel dtModel;
	public JTable jtbHorseIndex;
	private JScrollPane jspTableView;
	private JPanel jplMainView;
	private JTabbedPane jtpHorseInfo;
	private JSplitPane jspMainView;
	
	public BasicRegistryPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
				
		this.dtModel = new DefaultTableModel();
		this.jtbHorseIndex = new JTable(dtModel);
		this.jspTableView = new JScrollPane(jtbHorseIndex);
		this.jplMainView = new JPanel(new GridBagLayout());
		this.jtpHorseInfo = new JTabbedPane(JTabbedPane.TOP);
		this.jspMainView = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());		
		
	}
	
	private void createLayout() {
								
		this.configJTable();
		this.configJSplitPaneMain();
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0,3,6,3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(jspMainView, gbc);
		
	}
	
	private void configJTable() {
		
		JTableHeader header = jtbHorseIndex.getTableHeader();
		header.setReorderingAllowed(false);
		
		this.dtModel.addColumn("Name");
		this.dtModel.addColumn("Breed");
		this.dtModel.addColumn("Age");
		this.dtModel.addColumn("Gender");
		this.dtModel.addColumn("Status");
		this.dtModel.addColumn("Box");		
		
		int mode = ListSelectionModel.SINGLE_SELECTION;
		
		this.jtbHorseIndex.getSelectionModel().setSelectionMode(mode);
		this.jtbHorseIndex.setDefaultEditor(Object.class, null);
		this.jtbHorseIndex.setRowHeight(25);
		
		
	}
	
	private void configJSplitPaneMain() {
		
		this.jspTableView.setBorder(null);
		this.jspTableView.setViewportBorder(null);
		
		this.jspMainView.setDividerLocation(200);
		this.jspMainView.setDividerSize(10);
		this.jspMainView.setContinuousLayout(true);
		this.jspMainView.setBorder(null);
		this.jspMainView.setOneTouchExpandable(true);
		this.jspMainView.setTopComponent(jspTableView);
		this.jspMainView.setBottomComponent(jtpHorseInfo);
	
	}	
}
