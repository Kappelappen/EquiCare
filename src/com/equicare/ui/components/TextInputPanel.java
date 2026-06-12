package com.equicare.ui.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class TextInputPanel extends JPanel {
	
	private boolean state;
	private String borderTitle;
	private int height;
	
	private TitledBorder titledBorder;
	private EmptyBorder emptyBorder;
	
	private CompoundBorder compBorder;
	
	public JTextArea txtMainView;
	private JScrollPane jspMainView;
	
	public TextInputPanel(boolean state, 
		String borderTitle,  int height) {
		
		this.state = state;
		this.borderTitle = borderTitle;
		this.height = height;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		
	}
	
	private void initComponents() {
		
		this.titledBorder = new TitledBorder(borderTitle);		
		this.emptyBorder = new EmptyBorder(3,3,3,3);		
		this.compBorder = new CompoundBorder(titledBorder,emptyBorder);
		
		this.txtMainView = new JTextArea();
		this.jspMainView = new JScrollPane(txtMainView);
		
	}
	
	private void configJPanel() {
		
		this.configJTextArea();
		
		this.titledBorder.setBorder(BorderFactory.createEtchedBorder());
		this.jspMainView.setViewportBorder(BorderFactory.createEtchedBorder());
		this.jspMainView.setBorder(compBorder);
		this.setLayout(new BorderLayout());
			
	}
	
	private void configJTextArea() {
		
		this.txtMainView.setLineWrap(true);
		this.txtMainView.setMargin(new Insets(6,6,6,6));
		this.txtMainView.setTabSize(1);
		this.txtMainView.setWrapStyleWord(true);
		this.txtMainView.setEnabled(state);
		this.txtMainView.setDisabledTextColor(SystemColor.textText);
		this.txtMainView.setFont(new Font("Arial",Font.PLAIN,16));
		
	}
	
	private void createLayout() {
				
		this.add(BorderLayout.CENTER, jspMainView);
		
	}
	
	@Override
	public Dimension getMinimumSize() {
		
		Dimension dim = new Dimension();
		dim.width = 0;
		dim.height = height;
		
		return dim;
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		
		Dimension dim = new Dimension();
		dim.width = 0;
		dim.height = height;
		
		return dim;
		
	}
	
	@Override
	public Dimension getMaximumSize() {
		
		Dimension dim = new Dimension();
		dim.width = 0;
		dim.height = height;
		
		return dim;
		
	}
}
