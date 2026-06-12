package com.equicare.ui.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.equicare.model.HorseNode;
import com.equicare.ui.components.NavigationLabel;
import com.equicare.ui.windows.MainWindow;

public class NavigationPanel extends JPanel {
	
	private MainWindow mWindow;
	private CardLayout card;
	
	public DefaultTreeModel dtModel;
	
	public DefaultMutableTreeNode registryNode;
	public DefaultMutableTreeNode profileNode;
	public DefaultMutableTreeNode stableNode;
	public DefaultMutableTreeNode equipmentNode;
	
	public DefaultMutableTreeNode horseNode;
	public DefaultMutableTreeNode mainNode;
	public JTree jtrNavigation;
	private JScrollPane jspNavigation;
	
	public NavigationPanel(MainWindow mWindow) {
		
		this.mWindow = mWindow;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.card = (CardLayout) mWindow.jplCardLayout.getLayout();
		
		this.horseNode = new DefaultMutableTreeNode();
		this.profileNode = new DefaultMutableTreeNode();
		this.registryNode = new DefaultMutableTreeNode();
		this.stableNode = new DefaultMutableTreeNode();
		this.equipmentNode = new DefaultMutableTreeNode();
		
		this.mainNode = new DefaultMutableTreeNode("EquiCare");
		this.dtModel = new DefaultTreeModel(mainNode);
		this.jtrNavigation = new JTree(dtModel);
		this.jspNavigation = new JScrollPane(jtrNavigation);
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());
		
	}
	
	private void createLayout() {
		
		this.configJTree();
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(3,3,3,3);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = GridBagConstraints.BOTH;
		gbc.weighty = GridBagConstraints.BOTH;
		this.add(jspNavigation, gbc);		
		
	}	
	
	private void configJTree() {
		
		this.buildJTree();
		
		int mode = ListSelectionModel.SINGLE_SELECTION;
		
		this.jtrNavigation.setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
		this.jtrNavigation.setShowsRootHandles(true);
		this.jtrNavigation.getSelectionModel().setSelectionMode(mode);
		
		this.keepTreeExpanded(jtrNavigation);
		
	}
	
	private void buildJTree() {
		
		this.horseNode.setUserObject("Horses");
		this.mainNode.add(horseNode);
		
		this.registryNode.setUserObject(new 
		HorseNode("Horse Registry", "registry"));
		this.horseNode.add(registryNode);
		
		this.profileNode.setUserObject(new 
		HorseNode("Horse Profile", "profile"));
		this.horseNode.add(profileNode);
		
		this.stableNode.setUserObject(new 
		HorseNode("Stable Management","stable"));;
		this.horseNode.add(stableNode);
		
		this.equipmentNode.setUserObject(new 
		HorseNode("Equipment","equipment"));
		this.horseNode.add(equipmentNode);
		
		this.handleSelection();
		
	}
	
	public void keepTreeExpanded(JTree tree) {

		expandAllNodes(tree);

	    tree.addTreeWillExpandListener(new TreeWillExpandListener() {

	    @Override
	    public void treeWillExpand(TreeExpansionEvent event) {}

	    	@Override
	            public void treeWillCollapse(TreeExpansionEvent event)
	          	throws ExpandVetoException {
	             throw new ExpandVetoException(event);
	            
	        }
	    });
	 }

	 private void expandAllNodes(JTree tree) {

	     TreeNode root =
	    	(TreeNode) tree.getModel().getRoot();

	     expandNode(tree, new TreePath(root));
	        
	}
	    
	private void expandNode(JTree tree, 
	    TreePath path) {

	    TreeNode node =
	    	(TreeNode) path.getLastPathComponent();

	    for (int i = 0; i < node.getChildCount(); i++) {

		    TreeNode child = node.getChildAt(i);
	
		    TreePath childPath =
		    	path.pathByAddingChild(child);
	
		    expandNode(tree, childPath);
	        
	    }

	    tree.expandPath(path);
	}
	
	private void handleSelection() {
		
		this.jtrNavigation.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
							
				TreePath path = e.getPath();
				
				DefaultMutableTreeNode node = 
					(DefaultMutableTreeNode) path.getLastPathComponent();
					
				Object obj = node.getUserObject();					
								
				if (obj instanceof HorseNode) {
					
					HorseNode horse = (HorseNode) obj;
					
					String key = horse.getKey();
					
					card.show(mWindow.jplCardLayout, key);
					dtModel.reload(node);
					
				}				
			}
		});			
	}
}
