package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.equicare.model.Horse;
import com.equicare.ui.windows.MainWindow;

public class HorseInfoPanel extends JPanel {

	private MainWindow mWindow;
		
	public BasicGeneralPanel jplGeneral;
	public BasicIdentificationPanel jplIdentification;
	public BasicStablePanel jplStable;
	public BasicHealthPanel jplHealth;
	public BasicTrainingPanel jplTraining;
	public BasicFeedingPanel jplFeeding;
	public BasicCommentsPanel jplComments;
	
	private JScrollPane jspGeneral;
	private JScrollPane jspIdentification;
	private JScrollPane jspStable;
	private JScrollPane jspHealth;
	private JScrollPane jspTraining;
	private JScrollPane jspFeeding;
	
	public DefaultTableModel model;
	public JTable jtbHorseIndex;
	private JScrollPane jspHorseIndex;
			
	private JPanel jplLeftView;
	private JPanel jplRightView;
	
	public JSplitPane jspMainView;
	
	public JTabbedPane jtpInfoView;
	
	public HorseInfoPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
				
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}	
	
	private void initComponents() {
		
		this.jplGeneral = new BasicGeneralPanel();
		this.jplIdentification = new BasicIdentificationPanel();
		this.jplStable = new BasicStablePanel();
		this.jplHealth = new BasicHealthPanel();
		this.jplTraining = new BasicTrainingPanel();
		this.jplFeeding = new BasicFeedingPanel();
		this.jplComments = new BasicCommentsPanel();
		
		this.jspGeneral = createJScrollPane(jplGeneral);
		this.jspIdentification = createJScrollPane(jplIdentification);
		this.jspStable = createJScrollPane(jplStable);
		this.jspHealth = createJScrollPane(jplHealth);
		this.jspTraining = createJScrollPane(jplTraining);
		this.jspFeeding = createJScrollPane(jplFeeding);
		
		this.model = new DefaultTableModel();
		this.jtbHorseIndex = new JTable(model);
		this.jspHorseIndex = createJScrollPane(jtbHorseIndex);
				
		this.jtpInfoView = new JTabbedPane(JTabbedPane.TOP);
		
		this.jplLeftView = new JPanel(new GridBagLayout());
		this.jplRightView = new JPanel(new GridBagLayout());
		
		this.jspMainView = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		this.configJTable();
		this.configJSplitPane();
		this.configJTabbedPane();		
		this.buildJPanelLeftView();
		this.buildJPanelRightView();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(jspMainView, gbc);
				
	}
	
	private void configJSplitPane() {
		
		this.jplLeftView.setPreferredSize(jplLeftView.getMinimumSize());
		this.jplRightView.setPreferredSize(jplRightView.getMinimumSize());
		
		this.jspMainView.setPreferredSize(jspMainView.getMinimumSize());
		this.jspMainView.setContinuousLayout(true);
		this.jspMainView.setBorder(null);
		this.jspMainView.setOneTouchExpandable(true);
		this.jspMainView.setDividerLocation(200);
		this.jspMainView.setDividerSize(10);
		this.jspMainView.setLeftComponent(jplLeftView);
		this.jspMainView.setRightComponent(jplRightView);
		
	}
	
	private void configJTabbedPane() {
				
		this.jtpInfoView.addTab("General", jspGeneral);
		this.jtpInfoView.addTab("Identification", jspIdentification);
		this.jtpInfoView.addTab("Stable", jspStable);
		this.jtpInfoView.addTab("Health", jspHealth);
		this.jtpInfoView.addTab("Training", jspTraining);
		this.jtpInfoView.addTab("Feeding", jspFeeding);
		this.jtpInfoView.addTab("Comments", jplComments);
		
	}
	
	private void buildJPanelLeftView() {
				
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		this.jplLeftView.add(jspHorseIndex, gbc);
		
	}
		
	private void buildJPanelRightView() {
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		this.jplRightView.add(jtpInfoView, gbc);
		
	}
	
	private void configJTable() {
		
		this.jspHorseIndex.setBorder(null);
		this.jspHorseIndex.setViewportBorder(null);
		
		int mode = ListSelectionModel.SINGLE_SELECTION;
		JTableHeader header = jtbHorseIndex.getTableHeader();
		header.setReorderingAllowed(false);
		
		this.model.addColumn("ID");
		this.model.addColumn("Name");
		this.model.addColumn("Breed");
		
		TableColumn col = jtbHorseIndex.getColumnModel().getColumn(0);
		
		col.setMinWidth(0);
		col.setPreferredWidth(0);
		col.setMaxWidth(0);
		col.setResizable(false);
		
		this.jtbHorseIndex.setRowHeight(25);
		this.jtbHorseIndex.setDefaultEditor(Object.class, null);
		this.jtbHorseIndex.getSelectionModel().setSelectionMode(mode);
				
		populateJTable();				
			
	}
	
	public void populateJTable() {
		
		this.model.setRowCount(0);
		
		java.util.List<Horse> list = mWindow.service.fetchAllHorses();
		
		if (list.size() != 0) {
		
			for (int i = 0; i < list.size(); i++) {
				
				Horse horse = list.get(i);
				
				int id = horse.getId();
				String name = horse.getName();
				String breed = horse.getBreed();
				
				Object[] obj = new Object[] { id,name,breed };
				this.model.addRow(obj);
				
			}
			
			int rowIndex = model.getRowCount();
			
			Rectangle rect = this.jtbHorseIndex.getCellRect(rowIndex,rowIndex, false);
			this.jtbHorseIndex.scrollRectToVisible(rect);
			
			this.jtbHorseIndex.setRowSelectionInterval(rowIndex -1, rowIndex -1);		
			
		}
		
		this.model.fireTableDataChanged();
		
	}
	
	private JScrollPane createJScrollPane(Component comp) {
		
		JScrollPane scrollPane = new JScrollPane();
		JViewport port = scrollPane.getViewport();
		port.setView(comp);
		
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setPreferredSize(scrollPane.getMinimumSize());
		
		return scrollPane;
		
	}
}
