package com.equicare.ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.equicare.event.listener.JournalTableListener;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;
import com.equicare.ui.components.ItemComboBox;
import com.equicare.ui.windows.MainWindow;
import com.equicare.ui.windows.NewJournalDialog;

public class HorseJournalPanel extends JPanel {

	public MainWindow mWindow;
	
	public DefaultTableModel model;
	public JTable jtbEntries;
	private JScrollPane jspEntries;
	
	private JButton btnNewEntry;
	private JButton btnEditEntry;
	private JButton btnDeleteEntry;
		
	private JPanel jplCommandView;
	
	private JLabel lblSelectHorse;
	public ItemComboBox jcbSelectHorse;
	
	private JPanel jplLeftView;
	public BasicJournalPanel jplJournal;
	private JScrollPane jspJournal;
	
	private JSplitPane jspContentView;
	
	public HorseJournalPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		this.registerEvents();
		
	}
	
	private void initComponents() {
		
		this.jplCommandView = new JPanel(new GridBagLayout());
		
		this.model = new DefaultTableModel();
		this.jtbEntries = new JTable(model);
		this.jspEntries = new JScrollPane(jtbEntries);
		
		this.btnNewEntry = createJButton("/images/new_entry.png","New");
		this.btnEditEntry = createJButton("/images/edit_entry.png", "Edit");
		this.btnDeleteEntry = createJButton("/images/delete_entry.png", "Delete");
		
		this.lblSelectHorse = new JLabel("Horses");
		this.jcbSelectHorse = new ItemComboBox();
		
		this.jplLeftView = new JPanel(new GridBagLayout());
		
		this.jplJournal = new BasicJournalPanel(mWindow);
		this.jspJournal = new JScrollPane(jplJournal);
		
		this.jspContentView = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		this.buildJPlCommandView();
		this.configJButton();
		this.configJTable();
		this.buildJPanelLeftView();
		this.configJSplitPane();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,3,3,3);
		this.add(jplCommandView, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);
		this.add(jspContentView, gbc);
		
	}
	
	private void buildJPanelLeftView() {
				
		this.configJCbSelectHorse();	
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,3,3,0);
		this.jplLeftView.add(lblSelectHorse, gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,10,3,3);
		this.jplLeftView.add(jcbSelectHorse, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		gbc.insets = new Insets(3,3,3,3);		
		this.jplLeftView.add(jspEntries, gbc);
				
	}
	
	private void buildJPlCommandView() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,3,0,0);		
		this.jplCommandView.add(btnNewEntry, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.NONE;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,3,0,3);		
		this.jplCommandView.add(btnEditEntry, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.NONE;
		gbc.insets = new Insets(3,0,0,3);		
		this.jplCommandView.add(btnDeleteEntry, gbc);
						
	}
	
	private void registerEvents() {
				
		this.btnNewEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				btnNewEntry.setEnabled(false);
				
				NewJournalDialog dialog = new NewJournalDialog(0, mWindow);
				dialog.setVisible(true);
								
				btnNewEntry.setEnabled(true);
												
			}			
		});
		
		this.btnEditEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				int tableRow = jtbEntries.getSelectedRow();
				
				if (tableRow == -1) {
					
					btnEditEntry.setEnabled(false);
					
					String entryMsg = "No entry selected";
					JOptionPane.showMessageDialog(mWindow, entryMsg);					
					btnEditEntry.setEnabled(true);
				
				}
				
				else if (tableRow != -1) {
				
					int tableId = (int) jtbEntries.getValueAt(tableRow, 0);
					btnEditEntry.setEnabled(false);
					
					NewJournalDialog dialog = 
						new NewJournalDialog(tableId, mWindow);
				
					dialog.setVisible(true);
					btnEditEntry.setEnabled(true);
				
				}				
			}			
		});
		
		this.btnDeleteEntry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (jtbEntries.getSelectedRow() != -1) {

				    int tableRow = jtbEntries.getSelectedRow();
				    int tableId = (Integer) jtbEntries.getValueAt(tableRow, 0);

				    mWindow.service.deleteJournal(tableId);
				    model.removeRow(tableRow);
				    model.fireTableDataChanged();
								
				}				
			}			
		});
		
		this.jcbSelectHorse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				cleanHorseForm();
				jcbSelectHorsePressed();
				
			}							
		});
		
		this.jtbEntries.getSelectionModel().addListSelectionListener(new 
		JournalTableListener(this));				
		
	}
	
	private void cleanHorseForm() {
		
		this.jplJournal.txtHorse.setText(null);
		this.jplJournal.txtDate.setText(null);
		this.jplJournal.txtCategory.setText(null);
		this.jplJournal.txtHeadline.setText(null);
		this.jplJournal.txtNotes.setText(null);
		
		
	}
	
	public void jcbSelectHorsePressed() {
				
		model.setRowCount(0);
		
		if (jcbSelectHorse.getSelectedItem() == null) {
			
			this.btnNewEntry.setEnabled(false);
			this.btnEditEntry.setEnabled(false);
			this.btnDeleteEntry.setEnabled(false);
			
		}
		
		Horse selectedHorse = (Horse) jcbSelectHorse.getSelectedItem();
		if (selectedHorse == null) return;
		
		int id = selectedHorse.getId();					
		java.util.List<JournalEntry> list = mWindow.service.findEntries(id);
		
		for (int i = 0; i < list.size(); i++) {
			
			JournalEntry tempJournal = list.get(i);
			tempJournal.setHorseId(id);
			
			int journalId = tempJournal.getId();
			String date = tempJournal.getDate();
			String category = tempJournal.getCategory();
			
			Object[] rowData = 
				new Object[] { journalId,date,	category };
			
			model.addRow(rowData);
								
		}
		
		model.fireTableDataChanged();	
				
		if (jcbSelectHorse.getSelectedIndex() != 0) {
		
			this.btnNewEntry.setEnabled(true);
			this.btnEditEntry.setEnabled(true);
			this.btnDeleteEntry.setEnabled(true);
			
		}
	}
	
	private void configJCbSelectHorse() {
		
		this.jcbSelectHorse.addItem(null);
		
		java.util.List<Horse> list = mWindow.service.fetchAllHorses();
		
		for (int i = 0; i < list.size(); i++) {
			
			Horse horse = list.get(i);
			this.jcbSelectHorse.addItem(horse);
			
		}				
	}
	
	private void configJSplitPane() {
				
		this.jspContentView.setBorder(null);
		this.jspContentView.setContinuousLayout(true);
		this.jspContentView.setDividerLocation(200);
		this.jspContentView.setDividerSize(10);
		this.jspContentView.setLeftComponent(jplLeftView);
		this.jspContentView.setRightComponent(jspJournal);
		
	}	
	
	private void configJTable() {
		
		JTableHeader header = jtbEntries.getTableHeader();
		header.setReorderingAllowed(false);;
		
		this.configTableModel();
		
		int mode = ListSelectionModel.SINGLE_SELECTION;
		
		this.jtbEntries.getSelectionModel().setSelectionMode(mode);
		this.jtbEntries.setDefaultEditor(Object.class, null);
		this.jtbEntries.setRowHeight(25);
		
		this.closeTableColumn();
		
	}
	
	private void configTableModel() {
		
		this.model.addColumn("ID");
		this.model.addColumn("Date");
		this.model.addColumn("Category");
			
	}
	
	private void configJButton() {
		
		this.btnNewEntry.setEnabled(false);
		this.btnEditEntry.setEnabled(false);
		this.btnDeleteEntry.setEnabled(false);
		
	}
	
	private void closeTableColumn() {
		
		TableColumn column = jtbEntries.getColumnModel().getColumn(0);
		
		column.setMinWidth(0);
		column.setPreferredWidth(0);
		column.setMaxWidth(0);
		column.setResizable(false);
		
	}
	
	public void fetchEntries(int id) {
		
		model.setRowCount(0);
		this.mWindow.service.deleteJournal(id);
		
		java.util.List<JournalEntry> list = mWindow.service.fetchSelectedEntries(id);
				
		for (int i = 0; i < list.size(); i++) {
			
			JournalEntry entry = list.get(i);
						
			String date = entry.getDate();
			String category = entry.getCategory();
				
			Object[] row = new Object[] { id,date,category };
			this.model.addRow(row);			
			
		}
						
		this.model.removeRow(id);
		this.model.fireTableDataChanged();
				
		this.jtbEntries.revalidate();
		this.jtbEntries.repaint();
		this.jtbEntries.updateUI();
		
	}
	
	private JButton createJButton(String path, String label) {
		
		URL url = super.getClass().getResource(path);
		ImageIcon icon = new ImageIcon(url);
		
		Dimension dim = new Dimension(116,40);
		JButton button = new JButton();
		
		button.setHorizontalAlignment(JButton.LEFT);
		button.setIconTextGap(16);
		button.setIcon(icon);
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setFocusable(false);
		button.setText(label);
		
		return button;
		
	}
}
