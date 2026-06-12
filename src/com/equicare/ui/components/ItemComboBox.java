package com.equicare.ui.components;

import java.awt.*;
import javax.swing.*;
import com.equicare.ui.renderers.ItemComboRenderer;

public class ItemComboBox extends JComboBox<Object> {
	
	public ItemComboBox() {
		
		this.configJComboBox();		
		
	}
	
	private void configJComboBox() {
		
		super.setRenderer(new ItemComboRenderer(3,3));
		
	}
}
