package com.equicare.ui.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class BasicTextField extends JTextField {

	private int height;
	
	public BasicTextField(int height) {
		
		this.height = height;
		this.configJTextField();
		
	}
	
	private void configJTextField() {
		
		Border emptyBorder = BorderFactory.createEmptyBorder(0,4,0,4);
		Border lineBorder = BorderFactory.createLineBorder(SystemColor.controlDkShadow);
		Border mainBorder = new CompoundBorder(lineBorder,emptyBorder);
		
		this.setBorder(mainBorder);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setDisabledTextColor(SystemColor.textText);
		
		
	}
	
	@Override
	public Dimension getMinimumSize() {
		
		return new Dimension(0,height);
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(0,height);
		
	}
	
	@Override
	public Dimension getMaximumSize() {
		
		return new Dimension(0,height);
		
	}	
}
