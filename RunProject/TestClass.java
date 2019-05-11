package RunProject;

import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.Box; 
import javax.swing.JFrame; 
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.awt.Component;
import java.awt.GridBagLayout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class TestClass extends JPanel
{
    /* Note on Gridbag Layout:
        First see these links: 
            https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
            https://www.javatpoint.com/java-gridbaglayout
            https://www.decodejava.com/java-gridbaglayout.htm
        
        Second:
            components crated for Gridbag Layout start off at center and gradually
            reach location specified as more components are added since adding any
            components can cause previously made components to shift as components
            are gradually added
    */

    
    
    
    private void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        // space (border) container must leave at each edge from top, left, bottom, right
        //frame.getContentPane().setBorder(new EmptyBorder(new Insets(110, 125, 110, 125)));
        
        //Set up the content panel.
        JButton button;
        
	panel.setLayout(new GridBagLayout());
	
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
        button = new JButton("Button 1");
        
        button.setEnabled(false);
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 62;      //make this component tall
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
	gridBagConstraints.gridx = 2;
        gridBagConstraints.gridwidth = 3;
	gridBagConstraints.gridy = 0;
	panel.add(button, gridBagConstraints);

	button = new JButton("Button 2");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
	gridBagConstraints.gridx = 3;
	gridBagConstraints.gridy = 1;
	panel.add(button, gridBagConstraints);

	button = new JButton("Button 3");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
	gridBagConstraints.gridx = 4;
	gridBagConstraints.gridy = 2;
	panel.add(button, gridBagConstraints);
        
	button = new JButton("Long-Named Button 4");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 75;
	gridBagConstraints.gridwidth = 2;
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 4;
	panel.add(button, gridBagConstraints);

        button = new JButton("Long Button 6");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 1;
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        button = new JButton("Long Button 7");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.gridx = 1;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        button = new JButton("Long Button 8");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.gridx = 2;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        button = new JButton("Long Button 9");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.gridx = 3;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        button = new JButton("Long Button 10");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.gridx = 3;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        button = new JButton("Long Button 10");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.gridx = 4;
	gridBagConstraints.gridy = 7;
	panel.add(button, gridBagConstraints);
        
        
        
        
        
        button = new JButton("Long Button 5");
        
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	gridBagConstraints.ipady = 420;      //make this component tall
        //gridBagConstraints.ipadx = 130;
        // make strecth across whole thing 
	gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.4;
	gridBagConstraints.gridwidth = 6;
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 5;
	panel.add(button, gridBagConstraints);
        

        frame.add(panel);
        
        
        
        
        
        
        
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(640, 480);
        
        Rectangle r = frame.getBounds();
        System.out.print("frame height :"+r.height);
        System.out.print("frame width :"+r.width);
    }

    public TestClass()
    {
        createAndShowGUI();
        
        
        
    }
}
