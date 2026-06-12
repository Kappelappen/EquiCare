package com.equicare.ui.renderers;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemComboRenderer extends DefaultListCellRenderer {

    private final int paddingLeft;
    private final int paddingRight;

    public ItemComboRenderer(int paddingLeft, int paddingRight) {
        
    	this.paddingLeft = paddingLeft;
        this.paddingRight = paddingRight;
        
    }

    @Override
    public Component getListCellRendererComponent(
        JList<?> list, Object value,
        int index,boolean isSelected,
        boolean cellHasFocus) {

    	Dimension dim = new Dimension(0,27);
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus
        );

        label.setFont(new Font("Arial",Font.PLAIN,16));
        label.setBorder(new EmptyBorder(0, paddingLeft, 0, paddingRight));
        label.setMinimumSize(dim);
        label.setPreferredSize(dim);
        label.setMaximumSize(dim);
        
        if (value == null) {
            label.setText("");
        } else {
            label.setText(value.toString());
        }

        return label;
    }
    
    @Override
    public Font getFont() {
    	
    	return new Font("Arial",Font.PLAIN,16);
    	
    }
    
    @Override
    public Dimension getPreferredSize() {
    	
    	return new Dimension(0,27);
    }    
}