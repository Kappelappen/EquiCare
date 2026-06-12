package com.equicare.ui.windows;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.equicare.event.listener.MainTableListener;
import com.equicare.model.Horse;
import com.equicare.service.EquiService;
import com.equicare.ui.panels.CommandPanel;
import com.equicare.ui.panels.DashboardPanel;
import com.equicare.ui.panels.HorseInfoPanel;
import com.equicare.ui.panels.BasicCommentsPanel;
import com.equicare.ui.panels.BasicEquipmentPanel;
import com.equicare.ui.panels.BasicFeedingPanel;
import com.equicare.ui.panels.BasicGeneralPanel;
import com.equicare.ui.panels.BasicHealthPanel;
import com.equicare.ui.panels.BasicIdentificationPanel;
import com.equicare.ui.panels.HorseJournalPanel;
import com.equicare.ui.panels.BasicRegistryPanel;
import com.equicare.ui.panels.BasicProfilePanel;
import com.equicare.ui.panels.BasicStablePanel;
import com.equicare.ui.panels.BasicTrainingPanel;
import com.equicare.ui.panels.BasicMedicalPanel;
import com.equicare.ui.panels.NavigationPanel;
import com.equicare.ui.panels.SearchPanel;

public class MainWindow extends JFrame {

	public EquiService service;
	
	private JPanel jplLeftView;	
	private JPanel jplRightView;
	private JPanel jplMainView;
	public JPanel jplCardLayout;	
	
	public SearchPanel jplSearch;
	
	public HorseInfoPanel jplHorseInfo;
	public HorseJournalPanel jplJournal;
	
	public JTabbedPane jtpHorseInfo;
	public CommandPanel jplCommand;
	private JTabbedPane jtpMainView;
	private JPanel jplContainer;
	
	public MainWindow(EquiService service) {
		
		this.service = service;
		
		this.initComponents();
		this.configJFrame();
		this.createLayout();
		this.registerEvents();
		
	}
	
	private void initComponents() {
	
		this.jplSearch = new SearchPanel(this);		
		this.jplHorseInfo = new HorseInfoPanel(this);
		this.jplJournal = new HorseJournalPanel(this);
				
		this.jtpHorseInfo = new JTabbedPane(JTabbedPane.TOP);
		
		this.jplLeftView = new JPanel(new GridBagLayout());
		this.jplRightView = new JPanel(new GridBagLayout());
		this.jplMainView = new JPanel(new GridBagLayout());		
		
		this.jplCommand = new CommandPanel(this);		
		this.jtpMainView = new JTabbedPane(JTabbedPane.BOTTOM);
		this.jplContainer = new JPanel(new GridBagLayout());		
		
	}
	
	private void configJFrame() {
				
		this.setTitle("EquiCare");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setContentPane(jplContainer);
		
	}	
	
	private void createLayout() {
		
		this.configJTpMainView();	
						
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.jplContainer.add(jplCommand, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.jplContainer.add(jplSearch, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		this.jplContainer.add(jtpMainView, gbc);
				
	}
	
	private void configJTpMainView() {
						
		this.jtpMainView.addTab("Horses", jplHorseInfo);
		this.jtpMainView.addTab("Journal", jplJournal);
		
	}
	
	private void registerEvents() {
		
		this.jplHorseInfo.jtbHorseIndex.getSelectionModel().addListSelectionListener(new 
		MainTableListener(this));
		
		this.jplHorseInfo.jtbHorseIndex.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {
				
				int tableRow = jplHorseInfo.jtbHorseIndex.getSelectedRow();
				if (tableRow == -1) return;
				
					int tableId = (int) jplHorseInfo.jtbHorseIndex.getValueAt(tableRow, 0);
				
					NewHorseDialog dialog = 
						new NewHorseDialog(MainWindow.this, tableId, "Selected Horse");
				
					dialog.setVisible(true);				
				
				}
			}			
		});
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				jFrameClosing();
				
			}			
		});		
	}
	
	public void jFrameClosing() {
		
		this.dispose();
		System.exit(0);
		
	}	
}
