package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;
import Generic_Object.GenericObject;

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
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.GridBagLayout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.Point; 
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter; 
import java.util.ArrayList;
import javax.swing.JPanel; 
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;







public class ItemsMenu 
{
    private JButton mainMenu, use, sort;
    
    private Font font = new Font("Serif", Font.PLAIN, 18);
    
    public void buttonForInternalPanelPlacement(String buttonText, int gridy, int gridx, 
        JPanel panel)
    {
        // create new button to attach to internal panel 
        JButton button = new JButton(buttonText);
        
        // text will be displayed starting at furthest left of button text area 
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        // set button font 
        button.setFont(font);
        
        //textResizesUponButtonResize(button);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.10;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.10;
        
        panel.add(button, gridBagConstraints);
    }
    
    public String characterStringsForJList(GenericCharacter character)
    {
        // StringBuilder object used for creating text passed to button 
        StringBuilder builder = new StringBuilder();
        
        // add name of character  
        builder.append(character.getGeneralFeatures().getName());
        
        // add stress value of character 
        builder.append("\nStress: ").append(String.valueOf(character.getStress().
            getCurrentStress())).append(" / ").append(String.valueOf(character.
            getStress().getMaxStress()));
        System.out.println(builder.toString());
        /*
        // add Health Points (HP) and current/max points 
        builder.append("\nHP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentHealth())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxHealth()));
        
        // add Stamina Points (SP) and current/max points 
        builder.append("\nSP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentStamina())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxStamina()));
        
        // add Nanomachine Points (NP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("\nNP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentNano())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxNano()));
        */
        return builder.toString();
    }
    
    public void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JFrame frame = new JFrame();
    
    public ItemsMenu()
    {
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton topButton1 = new JButton("a");
        
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.33;
        //gridBagConstraints.gridwidth = 1;
        
        frame.add(topButton1, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton topButton2 = new JButton("s");
        
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.33;
        //gridBagConstraints.gridwidth = 1;
        
        frame.add(topButton2, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton topButton3 = new JButton("f");
        
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.33;
        //gridBagConstraints.gridwidth = 1;
        
        frame.add(topButton3, gridBagConstraints);
        
        
        // button with name and description 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton nameAndDescription = new JButton("k");
        
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 3;
        
        frame.add(nameAndDescription, gridBagConstraints);
        
            // info on buttons
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton buttonsBelow = new JButton("buttons below");

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(buttonsBelow, gridBagConstraints);
        
                // item list
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton itemButton = new JButton("Items below as list");

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(itemButton, gridBagConstraints);
        
            // party list
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton partyButton = new JButton("party members below as list");

        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(partyButton, gridBagConstraints);
        
        
        /* idea for inventory display ONLY (itemName x#)
            show stuff using stringBuilder 
                selection will refer to party inventory stuff using String to 
                match namr of key object 
        */
        
        // describing items buttons (10)
        for(int i = 0; i < 8; i++)
        {
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            JButton d1Button = new JButton("s");

            gridBagConstraints.gridy = 3 + i;
            gridBagConstraints.gridx = 0;
            gridBagConstraints.weighty = 0.11;
            gridBagConstraints.weightx = 0.15;
            gridBagConstraints.gridwidth = 1;

            frame.add(d1Button, gridBagConstraints);
        }
        
        //StringBuilder builder = new StringBuilder();
        
        // party as list (display)
        PlayerEntityFactory entity = new PlayerEntityFactory();
        
        DefaultListModel<String> invetoryObjects = new DefaultListModel<>();
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : entity.
            getPlayerEntityExample().getInventory().getInventory().entrySet())
        {
            String elementAndSize = String.format("-26%s\t%d", entry.getKey().getName(), 
                entry.getValue().size());
                    invetoryObjects.addElement(elementAndSize);
        }
        
        JList<String> invetoryObjectsJList = new JList<>(invetoryObjects);
        
        invetoryObjectsJList.setFont(new Font("Serif", Font.PLAIN, 18));
        
        invetoryObjectsJList.setVisibleRowCount(8);// display 10 rows at once 
        
        // do not allow multiple selection
        invetoryObjectsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        JScrollPane inventoryScroll = new JScrollPane(invetoryObjectsJList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weighty = 0.40;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridheight = 8;
        //gridBagConstraints.ipady = 75;
        gridBagConstraints.gridwidth = 1;
        
        // add a JScrollPane containing JList to frame 
        frame.add(inventoryScroll, gridBagConstraints);
        
        
        // inventory description 
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id1 = new JButton("Object Groups Limit");

        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id1, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id2 = new JButton("Item Group Max Size");

        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id2, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id3 = new JButton("Core Group Max Size");

        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id3, gridBagConstraints);
        
        // next set of 3
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id4 = new JButton("Weapon Group Max Size");

        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id4, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id5 = new JButton("Armor Group Max Size");

        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id5, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        JButton id6 = new JButton("Accessory Group Max Size");

        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.11;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridwidth = 1;

        frame.add(id6, gridBagConstraints);
        
        
        
        // JPanel Lists party members 
        
        DefaultListModel<String> partyMembers = new DefaultListModel<>();
        
        for(GenericCharacter character : entity.getPlayerEntityExample().getParty().getPartyMembers())
        {
            partyMembers.addElement(characterStringsForJList(character));
        }
        
        JList<String> partyMembersJList = new JList<>(partyMembers);
        
        //invetoryObjectsJList.setFont(new Font("Serif", Font.PLAIN, 18));
        
        partyMembersJList.setVisibleRowCount(8);// display 10 rows at once 
        
        // do not allow multiple selection
        partyMembersJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        JScrollPane partyMembersScroll = new JScrollPane(partyMembersJList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.40;
        gridBagConstraints.weightx = 0.15;
        gridBagConstraints.gridheight = 8;
        //gridBagConstraints.ipady = 75;
        gridBagConstraints.gridwidth = 1;
        
        // add a JScrollPane containing JList to frame 
        frame.add(partyMembersScroll, gridBagConstraints);
        
        
        // inventory as list (use)
        // GenericObject>(entity.getPlayerEntityExample().getInventory().getInventory()
        // TreeMap<GenericObject, ArrayList<GenericObject>>
        
        
        // party as list (display)
        //PlayerEntityFactory entity = new PlayerEntityFactory();
        
        //JList partyNames = new JList();
        
        
        //System.out.println(entity.getPlayerEntityExample().getInventory().getInventory().toString());
        
        
        
        displayFrameWindow();
        
    }
    
    
    
    
}
