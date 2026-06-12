package com.equicare.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * NavLabel
 *
 * En klickbar navigation-label med:
 * - ikon till vänster
 * - text i mitten
 * - hover-effekt (länk-känsla)
 */
public class NavigationLabel extends JLabel {

    private final Color normalColor = Color.blue.darker();
    private final Color hoverColor = Color.orange.darker();

    private URL url;
    private ImageIcon icon;
    private Runnable onClick;

    public NavigationLabel(String text, String fileName) {

    	this.url = super.getClass().getResource("/images/" + fileName);
    	this.icon = new ImageIcon(url);
    	
    	setIcon(icon);
        setForeground(normalColor);
        setHorizontalAlignment(JLabel.LEFT);
        setFont(new Font("Arial", Font.BOLD, 16));
        setIconTextGap(12);
        setText(text);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBorder(BorderFactory.createEmptyBorder(10, 10, 6, 3));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(normalColor);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (onClick != null) {
                    onClick.run();
                }
            }
        });
    }

    /**
     * Koppla navigation-action (t.ex. CardLayout switch)
     */
    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }
}