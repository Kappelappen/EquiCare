package com.equicare.ui.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.equicare.ui.components.BasicTextField;

public class ImageFilePanel extends JPanel {

	private boolean isActive;;
	
	public JTextField txtFilePath;
	public JButton btnOpenImage;
	public JButton btnSelectImage;
	
	public ImageFilePanel(boolean isActive) {
		
		this.isActive = isActive;
		
		this.initComponents();
		this.configJPanel();
		this.createLayout();
		this.registerEvents();
		
	}
	
	private void initComponents() {
		
		this.txtFilePath = new BasicTextField(30);
		this.btnOpenImage = createJButton("/images/open_image.png");
		this.btnSelectImage = createJButton("/images/select_image.png");
		
	}
	
	private void configJPanel() {
		
		this.setBorder(null);
		this.setLayout(new GridBagLayout());;
		
	}
	
	private void createLayout() {
		
		this.configJButton();
		this.configJTextField();
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0; 
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.BOTH;
		this.add(txtFilePath, gbc);
		
		gbc.gridx = 1; 
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.NONE;
		this.add(btnOpenImage, gbc);
		
		gbc.gridx = 2; 
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0,0,0,3);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = GridBagConstraints.NONE;
		this.add(btnSelectImage, gbc);
		
	}
	
	private void configJButton() {
				
		if (!isActive) {
			
			this.btnSelectImage.setEnabled(false);
			
		}
	}
	
	private void configJTextField() {
		
		this.txtFilePath.setEnabled(isActive);
		this.txtFilePath.setDisabledTextColor(SystemColor.textText);
		
	}
	
	private void registerEvents() {
		
		this.btnOpenImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showImage();
				
			}			
		});
		
		this.btnSelectImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				openFileChooser();
				
			}			
		});		
	}
	
	private void openFileChooser() {
		
		this.btnSelectImage.setEnabled(false);

        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(
            new FileNameExtensionFilter(
                "Image Files","jpg", "jpeg", 
                "png", "gif", "bmp", "webp"
            )
        );

        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File selectedFile = chooser.getSelectedFile();
            txtFilePath.setText(selectedFile.getAbsolutePath());
            
        }
        
        this.btnSelectImage.setEnabled(true);
        
    }
	
	private void showImage() {

	    String path = txtFilePath.getText().trim();

	    if (path.isEmpty()) {
	    	
	    	this.btnOpenImage.setEnabled(false);	    	
	        JOptionPane.showMessageDialog(this, "No image selected.");
	        this.btnOpenImage.setEnabled(true);
	        
	        return;
	    }

	    File file = new File(path);

	    if (!file.exists()) {
	        JOptionPane.showMessageDialog(this, "File not found.");
	        return;
	    }

	    ImageIcon icon = new ImageIcon(path);

	    JDialog dialog = new JDialog();
	    dialog.setUndecorated(true);
	    dialog.setModal(true);

	    Dimension screen =
	        Toolkit.getDefaultToolkit().getScreenSize();

	    ImagePanel imagePanel =
	        new ImagePanel(icon.getImage());

	    imagePanel.addMouseListener(
	        new java.awt.event.MouseAdapter() {
	            @Override
	            public void mouseClicked(
	                    java.awt.event.MouseEvent e) {

	                dialog.dispose();
	            }
	        });

	    dialog.setContentPane(imagePanel);

	    dialog.setBounds(0,0,
	        screen.width,
	        screen.height
	    );

	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	
	}

    public String getSelectedPath() {

        return txtFilePath.getText();
    }

    public void setSelectedPath(String path) {

        txtFilePath.setText(path);
    }
	
	private JButton createJButton(String path) {
		
		URL url = super.getClass().getResource(path);
		ImageIcon icon = new ImageIcon(url);
		
		Dimension dim = new Dimension(30,30);
		JButton button = new JButton();
		
		button.setFocusable(false);
		button.setMinimumSize(dim);
		button.setPreferredSize(dim);
		button.setMaximumSize(dim);
		button.setIcon(icon);		
		
		return button;
		
	}
	
	private static class ImagePanel extends JPanel {

        private final Image image;

        public ImagePanel(Image image) {

            this.image = image;
    
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            g.drawImage(
                image,
                0,
                0,
                getWidth(),
                getHeight(),
                this
            );
        }
    }
}
