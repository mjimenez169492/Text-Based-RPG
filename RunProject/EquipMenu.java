package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;
import Generic_Character.*;
import Generic_Object.OutfitMethods;
import Generic_Object.*;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JInternalFrame;

public class EquipMenu 
{
    // stores reference to inventory of player for easy access 
    private Inventory referenceInventory;
    
    // stores reference to player entity object for easy access 
    private PlayerEntity referencePlayerEntity;
    
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    private Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    
    private int buttonVerticalPadding = 55;
    
    private int jListVerticalPadding = 240;
    
    private JButton mainMenu;
    
    private JButton outfitOverview, outfitDescription, actionTakenText;
    
    
    
    private JList partyMemberJList, canChangeOutfits, currentTotalStatsJList,
        newTotalStatsJList, inventoryObjectsJList;
    
    
    
    
    private JButton equippedWeapon, equippedAccessoryOne, equippedAccessoryTwo,
        equippedBodyArmor, equippedLegArmor, equippedFootArmor;

    // buttons and text area used to updated external frame character panel
    private JButton characterName = new JButton();
    private JButton characterHealth = new JButton();
    private JButton characterStamina = new JButton();
    private JButton characterNano = new JButton();
    private JTextArea characterStatusEffects = new JTextArea();
    
    
    
    
    
    // START: ADDING BUTTON COMPONENTS TO FRAME
    /*******************************************************************************/

    public void addButtonComponent(JButton button, int gridy, int gridx, double
        weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = weighty;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = weightx;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    // END: ADDING BUTTON COMPONENTS TO FRAME
    /*******************************************************************************/
    
    
    
    // START: USABLE FRAME BUTTONS 
    /*******************************************************************************/
    
    public JButton newUsableButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void usableButtonPlacement(JButton button, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, 0, 0, 0.11, 0.33, 1, 0, frame);
    }
    
    // INCOMPLETE 
    public void addUsableButtons(JFrame frame)
    {
        mainMenu = newUsableButton("Main Menu");
            mainMenu.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // return to main menu (may need method to hold frame before disposal)
                    }
                }); 
        
        usableButtonPlacement(mainMenu, frame);
    }
    
    // END: USABLE FRAME BUTTONS 
    /*******************************************************************************/

    
    
    // START: UNUSABLE TITLE BUTTONS 
    /*******************************************************************************/

    public JButton newUnusableTitleButton(String text)
    {
        JButton button = new JButton(text);
        
        // gun metal blue color in hexadecimal 
        button.setBackground(Color.decode("#4d5461"));
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addTitleButton(String buttonName, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        addButtonComponent(newUnusableTitleButton(buttonName), gridy, gridx, 0.11, 0.25, 
            2, gridwidth, frame);
    }
    
    public void addUnusableTopTitles(JFrame frame)
    {
        String partyMemberJListTitle = String.format("%s", "All Party Members");
            addTitleButton(partyMemberJListTitle, 1, 0, 1, frame);
        
        String partyMemberInfoJPanelTitle = String.format("%s", "Party Member Info");
            addTitleButton(partyMemberInfoJPanelTitle, 1, 1, 1, frame);
        
        String equippedOutfitsButtonTitle = String.format("%s", "All Equipped Outfits");
            addTitleButton(equippedOutfitsButtonTitle, 1, 2, 1, frame);
        
        String unequipStatesButtonTitle = String.format("%s", "Can Change Outfits");
            addTitleButton(unequipStatesButtonTitle, 4, 0, 1, frame);
    }
    
    // END: UNUSABLE TITLE BUTTONS 
    /*******************************************************************************/

    
    
    // ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/

    public void addJListComponent(JList jList, int gridy, int gridx, double
        weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
    {
        jList.setFont(JListFont);
        
        // allign view of JList such that text is displayed at its center 
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane statsScroll = new JScrollPane(jList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = weighty;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = weightx;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = jListVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public void addTotalStatsJList(JList jList, int gridy, int gridx, JFrame frame)
    {
        addJListComponent(jList, gridy, gridx, 0.33, 0.33, 2, 1, frame);
    }
    
    public void addCharacterAttributeAndResistancesJLists(JFrame frame)
    {
        currentTotalStatsJList = new JList();
            addTotalStatsJList(currentTotalStatsJList, 8, 1, frame);
        newTotalStatsJList = new JList();
            addTotalStatsJList(newTotalStatsJList, 8, 2, frame);
    }
    
    // ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/

    
    
    // START: PARTY MEMBER JLIST, JPANEL, OUTFIT BUTTONS, AND CURRENT JLISTS
    /*******************************************************************************/

    // PARTY MEMBER JLIST WITH JSCROLLPANE FUNCTIONALITY
    
    public DefaultListModel<String> partyMembersInJListFormat(PlayerEntity entity)
    {
        DefaultListModel<String> partyMemberNames = new DefaultListModel<>();
        
        for(GenericCharacter element : entity.getParty().getPartyMembers())
        {
            String elementAndSize = String.format("%-26s", element.getGeneralFeatures().getName());
                partyMemberNames.addElement(elementAndSize);
        }
        
        return partyMemberNames;
    }
    
    public void addPartyMemberJList(JList partyMemberJList, JFrame frame)
    {
        // set JList text font 
        partyMemberJList.setFont(JListFont);
        
        // allign view of JList such that text is displayed at its center 
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) partyMemberJList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane partyMemberScroll = new JScrollPane(partyMemberJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 2;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.10;
        
        // specified row length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.10;
        
        gridBagConstraints.gridheight= 2;
        
        gridBagConstraints.gridwidth = 1;

        frame.add(partyMemberScroll, gridBagConstraints);
    }
    
    // PARTY MEMBER JLIST WITH JSCROLLPANE FUNCTIONALITY
    
    
    
    // CAN CHANGE OUTFITS JLIST
    
    public DefaultListModel<String> canChangeOutfitsInJListFormat(GenericCharacter character)
    {
        DefaultListModel<String> canChangeOutfits = new DefaultListModel<>();
        
        Object[] array = character.getEquippableOutfits().getOutfitChangeStates();
        
        for(int i = 0; i < array.length; i += 2)
        {
            String outfitAndChangeState = String.format("%-12s: %s", array[i], array[i + 1]);
                canChangeOutfits.addElement(outfitAndChangeState);
        }
        
        return canChangeOutfits;
    }
    
    public void addCanChangeOutfitsJList(JList changeOutfitsJList, JFrame frame)
    {
        // set JList text font 
        changeOutfitsJList.setFont(JListFont);
        
        // allign view of JList such that text is displayed at its center 
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) changeOutfitsJList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane changeOutfitsScroll = new JScrollPane(changeOutfitsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 5;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.10;
        
        // specified row length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.10;
        
        gridBagConstraints.gridheight= 2;
        
        gridBagConstraints.gridwidth = 1;

        frame.add(changeOutfitsScroll, gridBagConstraints);
    }
    
    // CAN CHANGE OUTFITS JLIST
    
    
    
    // GET PARTY MEMBER
    
    public GenericCharacter getPartyMember(Object JListPartyMemberName)
    {
        GenericCharacter character = new GenericCharacter();
        
        String partyMemberName = trimCharacterName((String)JListPartyMemberName);
        
        for(GenericCharacter element : referencePlayerEntity.getParty().getPartyMembers())
        {
            if(partyMemberName.equals(element.getGeneralFeatures().getName()))
            {
                character = element;
            }
        }
        
        return character;
    }
    
    public String trimCharacterName(String name)
    {
        String[] words = name.split(" ");
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < words.length; i++)
        {
            if(words.length == 1)
            {
                builder.append(words[i]);
            }
            else if(i < words.length - 1)
            {
                // add word since last word so no space after 
                builder.append(words[i]);
            }
            else
            {
                builder.append(words[i]);
                    builder.append(" ");
            }
        }
        
        return builder.toString();
    }
    
    // GET PARTY MEMBER
    
    
    
    // UPDATE CHARACTER AND EQUIPPED OUTFIT INFO FOR FRAME USING JLIST VALUE
    
    public String desiredSpaces(int spaces)
    {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < spaces; i++)
        {
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
    public String formatCurrentMaxValues(double currentValue, double maximumValue)
    {
        String curValue = String.valueOf(currentValue);
        
        String maxValue = String.valueOf(maximumValue);
        
        StringBuilder builder = new StringBuilder();
        
        // spaces are used to make current value Strings appear alligned 
        if(currentValue < 10)
        {
            builder.append(desiredSpaces(3));
        }
        else if(currentValue < 100)
        {
            builder.append(desiredSpaces(2));
        }
        else if(currentValue < 1000)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(curValue).append(" / ");
        
        // spaces are used to make max value Strings appear alligned 
        if(maximumValue < 10)
        {
            builder.append(desiredSpaces(3));
        }
        else if(maximumValue < 100)
        {
            builder.append(desiredSpaces(2));
        }
        else if(maximumValue < 1000)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(maxValue);
        
        return builder.toString();
    }
    
    public void updateCharacterInfo(GenericCharacter character)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s", character.getGeneralFeatures().getName());
            characterName.setText(formatName);
        
        // add Health Points (HP) and current/max points 
        String health = String.format("%-6s: %s", "HP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                characterHealth.setText(health);

        // add Stamina Points (SP) and current/max points 
        String stamina = String.format("%-6s: %s", "SP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                characterStamina.setText(stamina);
           
        // add Nanomachine Points (NP) and current/max points
        String nano = String.format("%-6s: %s", "NP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentNano(), character.getTotalStats().getTotalMaxNano()));
                characterNano.setText(nano);
    }
    
    public JButton newUnusableStandardButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void unusableButtonPlacement(JButton button, int gridy, int gridx, 
        int gridwidth, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, gridy, gridx, 0.11, 0.33, 1, gridwidth, frame);
    }
    
    // Note: 14 characters oer name!!!
    public void addEquippedOutfitsButtons(JFrame frame)
    {
        equippedWeapon = newUnusableStandardButton("WPN: 12345678901234");
            unusableButtonPlacement(equippedWeapon, 2, 2, 1, frame);
        
        equippedBodyArmor = newUnusableStandardButton("BDA:");
            unusableButtonPlacement(equippedBodyArmor, 3, 2, 1, frame);
            
        equippedLegArmor = newUnusableStandardButton("LGA:");
            unusableButtonPlacement(equippedLegArmor, 4, 2, 1, frame);
            
        equippedFootArmor = newUnusableStandardButton("FTA:");
            unusableButtonPlacement(equippedFootArmor, 5, 2, 1, frame);
            
        equippedAccessoryOne = newUnusableStandardButton("AC1:");
            unusableButtonPlacement(equippedAccessoryOne, 6, 1, 1, frame);
            
        equippedAccessoryTwo = newUnusableStandardButton("AC2:");
            unusableButtonPlacement(equippedAccessoryTwo, 6, 2, 1, frame);
    }
    
    public String equipText(String defaultText, OutfitMethods object)
    {
        StringBuilder builder = new StringBuilder(defaultText);
        
        if(object != null)
        {
            builder.append(object.getName());
        }
        else
        {
            builder.append(desiredSpaces(5)).append("<NA>");
        }
        
        return builder.toString();
    }
    
    public void updateEquippedOutfitsButtons(GenericCharacter character)
    {
        equippedWeapon.setText(equipText("WPN: ", character.getEquippableOutfits()
            .getWeapon()));
        
        equippedBodyArmor.setText(equipText("BDA: ", character.getEquippableOutfits()
            .getBodyArmor()));
            
        equippedLegArmor.setText(equipText("LGA: ", character.getEquippableOutfits()
            .getLegArmor()));
            
        equippedFootArmor.setText(equipText("FTA: ", character.getEquippableOutfits()
            .getFootArmor()));
            
        equippedAccessoryOne.setText(equipText("AC1: ", character.getEquippableOutfits()
            .getAccessoryOne()));
            
        equippedAccessoryTwo.setText(equipText("AC2: ", character.getEquippableOutfits()
            .getAccessoryTwo()));
    }

    // update character buttons and stat JLists using selected value 
    public void addCharacterJListUpdatePopupListener(JList jList)
    {
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // prevent passing null upon JList initialization phase 
                    if(evt != null)
                    {
                        // update character information displayed on JList selection change 
                        if (!evt.getValueIsAdjusting()) 
                        {
                            GenericCharacter partyMember = getPartyMember(jList.getSelectedValue());

                            updateCharacterInfo(partyMember);
                            updateEquippedOutfitsButtons(partyMember);

                            canChangeOutfits.setModel(canChangeOutfitsInJListFormat(partyMember));
                            
                            // current stats model for character with current outfits 	
                            currentTotalStatsJList.setModel(currentTotalStatsModel(partyMember));

                            if(inventoryObjectsJList.getSelectedValue() != null)
                            {
                                // update new total stats JList using character in focus 
                                // to prevent info from previous character being shown 
                                newTotalStatsJList.setModel(newTotalStatsModel(partyMember, 
                                    getInventoryOutfit(referenceInventory, inventoryObjectsJList.getSelectedValue())));
                            }
                        }
                    }
                }
            }
        );
    }

    // UPDATE CHARACTER AND EQUIPPED OUTFIT INFO FOR FRAME USING JLIST VALUE

    
    
    // ADDING CHARACTER DISPLAY BUTTONS TO FRAME TO DISPLAY CHARACTER INFO
    
    public JButton unusableCharacterFrameButtons()
    {
        JButton button = new JButton();
        
        // text will be displayed starting at furthest left of button text area 
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        // set button font 
        button.setFont(buttonFont);
        
        //textResizesUponButtonResize(button);
        
        return button;
    }
    
    public void characterFrameButtonPlacement(JButton button, int gridy, int gridx, 
        JFrame frame)
    {
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
        
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        frame.add(button, gridBagConstraints);
    }
    
    // DEFAULT values for new buttons meant to be placed in panel 
    public void addCharacterInfoButtons(JFrame frame)
    {
        characterName = unusableCharacterFrameButtons();
            characterFrameButtonPlacement(characterName, 2, 1, frame);
        
        characterHealth = unusableCharacterFrameButtons();
            characterFrameButtonPlacement(characterHealth, 3, 1, frame);
        
        characterStamina = unusableCharacterFrameButtons();
            characterFrameButtonPlacement(characterStamina, 4, 1, frame);
        
        characterNano = unusableCharacterFrameButtons();
            characterFrameButtonPlacement(characterNano, 5, 1, frame);
    }
    
    // ADDING CHARACTER DISPLAY BUTTONS TO FRAME TO DISPLAY CHARACTER INFO

    

    // METHODS USED IN TOTAL STAT DISPLAY JLISTS 
    
    public double checkAttribute(double value)
    {
        if(value < 0)
        {
            value = 0;
        }
        else if(value > 999)
        {
            value = 999;
        }
        
        return value;
    }
    
    public double checkResistance(double value)
    {
        if(value < -100)
        {
            value = -100;
        }
        else if(value > 100)
        {
            value = 100;
        }
        
        return value;
    }
    
    public String statValueSpacing(String value)
    {
        StringBuilder builder = new StringBuilder();
        
        // spaces are used to make current value Strings appear alligned 
        if(Double.parseDouble(value) < -10)
        {
            builder.append(desiredSpaces(1));
        }
        else if(Double.parseDouble(value) < 0)
        {
            builder.append(desiredSpaces(2));
        }
        else if(Double.parseDouble(value) < 10)
        {
            builder.append(desiredSpaces(2));
        }
        else if(Double.parseDouble(value) < 100)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(value);
        
        return builder.toString();
    }
    
    // METHODS USED IN TOTAL STAT DISPLAY JLISTS 
    
    
    
    // CURRENT TOTAL STATS MODEL
    
    public void addCurrentAttributeObjects(Object[] array, DefaultListModel<String> model)
    {
        for(int i = 0; i < array.length; i+=2)
        {
            String elementAndValue = String.format("%-18s: %s", String.valueOf(array[i]), 
                statValueSpacing(String.valueOf(checkAttribute((double)array[i + 1]))));
            
            model.addElement(elementAndValue);
        }
    }
    
    public void addCurrentResistanceObjects(Object[] array, DefaultListModel<String> model)
    {
        for(int i = 0; i < array.length; i+=2)
        {
            String elementAndValue = String.format("%-18s: %s", String.valueOf(array[i]), 
                statValueSpacing(String.valueOf(checkResistance((double)array[i + 1]))));

            model.addElement(elementAndValue);
        }
    }
    
    public DefaultListModel<String> currentTotalStatsModel(GenericCharacter character)
    {
        DefaultListModel<String> currentTotalStats = new DefaultListModel<>();
        
        addCurrentAttributeObjects(character.getTotalStats().getAllTotalAttributesWithNames(), 
            currentTotalStats);
        addCurrentResistanceObjects(character.getTotalStats().getAllTotalResistances().toArray( new Object[0]), 
            currentTotalStats);
        
        return currentTotalStats;
    }
    
    // CURRENT TOTAL STATS MODEL
    
    // END: PARTY MEMBER JLIST, JPANEL, OUTFIT BUTTONS, AND CURRENT JLISTS
    /*******************************************************************************/

    
    
    // START: OBJECT DESCRITPION BUTTON 
    /*******************************************************************************/

    public JButton newUnusableOutfitDescriptionButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    // description button has width of 0 to allow button to cover whole row 
    public void addObjectDescriptionAndActionTakenButtons(JFrame frame)
    {
        outfitOverview = newUnusableOutfitDescriptionButton("Overview:");
            addButtonComponent(outfitOverview, 10, 0, 0.11, 1, 1, 0, frame);
        
        outfitDescription = newUnusableOutfitDescriptionButton("Description:");
            addButtonComponent(outfitDescription, 11, 0, 0.11, 1, 1, 0, frame);
    }
    
    public void addUnusableBottomTitles(JFrame frame)
    {
        String inventoryJListTitle = String.format("%s", "Inventory Outfits");
            addTitleButton(inventoryJListTitle, 7, 0, 1, frame);
        
        String currentStatsTitle = String.format("%-26s", "Current And New Total Stats");
            addTitleButton(currentStatsTitle, 7, 1, 2, frame);
            
        //String newStatsWithOutfitJListTitle = String.format("%s", "New Stats");
          //  addTitleButton(newStatsWithOutfitJListTitle, 7, 2, 1, frame);
    }
    
    // END: OBJECT DESCRITPION BUTTON 
    /*******************************************************************************/

    
    
    // START: DISPLAY INVENTORY USING JLIST 
    /*******************************************************************************/
    
    public void addInventoryJList(JScrollPane inventoryScroll, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.30;
        gridBagConstraints.weightx = 0.10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.ipady = jListVerticalPadding;
        
        frame.add(inventoryScroll, gridBagConstraints);
    }
    
    public void displayInventoryOutfitsAsJList(Inventory inventory, JFrame frame)
    {
        // fill JList with contents of DefaultListModel<String> object
        inventoryObjectsJList = new JList<>(inventoryOutfitsInJListFormat(inventory));
        
        // make JList use monospaced font so all characters have the same width
        inventoryObjectsJList.setFont(JListFont);

        // allign view of JList such that text is displayed at its center 
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) inventoryObjectsJList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // do not allow for multiple selection (i.e. selecting more than 1 row)
        inventoryObjectsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane inventoryScroll = new JScrollPane(inventoryObjectsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        addInventoryJList(inventoryScroll, frame);
    }
    
    public boolean validOutfit(GenericObject object)
    {
        boolean result = false;
        
        if(object.getClass() != Item.class && object.getClass() != Core.class)
        {
            result = true;
        }
        
        return result;
    }
    
    // returns model that JList will use to display inventory objects 
    public DefaultListModel<String> inventoryOutfitsInJListFormat(Inventory inventory)
    {
        DefaultListModel<String> inventoryObjectsModel = new DefaultListModel<>();
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            // 
            if(validOutfit(entry.getKey()))
            {
                // String contains size of outfit group and name of outfit 
                // Note: size is formatted to account for double digits 
                String sizeAndName = String.format("x[%-2d] %s", 
                    entry.getValue().size(), entry.getKey().getName());

                inventoryObjectsModel.addElement(sizeAndName);
            }
        }
        
        return inventoryObjectsModel;
    }
    
    // END: DISPLAY INVENTORY USING JLIST 
    /*******************************************************************************/

    
    
    // START: UPDATING OUTFIT DESCRIPTION AND NEW STATS JLIST
    /*******************************************************************************/
    
    // NEW TOTAL STATS USING CURRENT TOTAL STATS AND OUTFIT (AND ARMOR) MODEL
    
    public void addNewAttributeObjects(Object[] characterAttributes, Object[] outfitAttributes, 
        DefaultListModel<String> model)
    {
        for(int i = 0; i < characterAttributes.length; i+=2)
        {
            double result = (double)characterAttributes[i + 1] + (double)outfitAttributes[i + 1];
            
            String elementAndValue = String.format("%-18s: %s", String.valueOf(characterAttributes[i]), 
                statValueSpacing(String.valueOf(checkAttribute(result))));
            
            model.addElement(elementAndValue);
        }
    }
    
    public void addNewResistanceObjects(GenericCharacter character, Armor outfit, 
        DefaultListModel<String> model)
    {
        Object[] characterResistances = character.getTotalStats().getAllTotalResistances().toArray( new Object[0]);
        
        Object[] outfitResistance = outfit.getAllResistances().toArray(new Object[0]);
        
        for(int i = 0; i < characterResistances.length; i+=2)
        {
            double result = (double)characterResistances[i + 1] + (double)outfitResistance[i + 1];
            
            String elementAndValue = String.format("%-18s: %s", String.valueOf(characterResistances[i]), 
                statValueSpacing(String.valueOf(checkResistance(result))));
            
            model.addElement(elementAndValue);
        }
    }
    
    public DefaultListModel<String> newTotalStatsModel(GenericCharacter character,
        OutfitMethods outfit)
    {
        DefaultListModel<String> newTotalStats = new DefaultListModel<>();
        
        // add character and outfit attributes for attribute portion of model
        addNewAttributeObjects(character.getTotalStats().getAllTotalAttributesWithNames(), 
            outfit.getAllTotalAttributesWithNames(), newTotalStats);
        
        // if outfit is not a piece of armor, keep resistances the same 
        if(outfit.getClass() != Armor.class)
        {
            addCurrentResistanceObjects(character.getTotalStats().getAllTotalEnchantmentResistancesWithNames(), 
                newTotalStats);
            addCurrentResistanceObjects(character.getTotalStats().getAllTotalResistances().toArray( new Object[0]), 
                newTotalStats);
        }
        // else accound for resistances of armor piece on current stats of character 
        else
        {
            addNewResistanceObjects(character, (Armor)outfit, newTotalStats);
        }
        
        return newTotalStats;
    }
    
    // NEW TOTAL STATS USING CURRENT TOTAL STATS AND OUTFIT (AND ARMOR) MODEL

    
    
    // RETRIEVING OUTFITS AND UPDATING NEW TOTAL STATS JLIST 
    
    public String formatDescriptionString(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
            return formattedText;
    }
    
    public void updateOutfitOverviewAndDescription(OutfitMethods object)
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append("(Category: ").append(object.getCategory()).append(")");
        
        builder.append(desiredSpaces(3));
        
        builder.append("(Super Type: ").append(object.getSuperType()).append(")");
        
        builder.append(desiredSpaces(3));
        
        outfitOverview.setText(formatDescriptionString("Overview", 
            builder.toString()));
        
        outfitDescription.setText(formatDescriptionString("Description", 
            object.getBriefDescription()));
    }
    
    public OutfitMethods getInventoryOutfit(Inventory inventory, Object jListObjectName)
    {
        OutfitMethods object = null;
        
        // Note: to get inventory name, start trimming String from character 
        //       6 since first 5 characters are not part of object's name 
        String trimmedToName = trimInventoryJListStringToName((String)jListObjectName);
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            if(validOutfit(entry.getKey()))
            {
                if(trimmedToName.equals(entry.getKey().getName()))
                {
                    object = (OutfitMethods)entry.getKey();
                }
            }
        }
        
        return object;
    }
    
    public String trimInventoryJListStringToName(String argument)
    {
        // convert String to character array 
        char[] array = argument.toCharArray();
        
        // create StringBuilder object meant for storing name of String 
        StringBuilder builder = new StringBuilder();
        
        // since first 5 characters are not useful for finding object name, 
        // supply 6 since we know first character of object name is there 
        for(int i = 6; i < array.length; i++)
        {
            // append characters to builder to return as String later 
            builder.append(array[i]);
        }
        
        return builder.toString();
    }
    
    // update object description/details upon change in selected value of JList 
    public void addUpdateOutfitInformationJListListener(Inventory inventory, JList jList)
    {
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update object information upon JList selection change 
                    if(!evt.getValueIsAdjusting()) 
                    {
                        // use selected value of JList to get desired outfit
                        OutfitMethods outfit = getInventoryOutfit(inventory, 
                            jList.getSelectedValue());

                        // update outfit description 
                        updateOutfitOverviewAndDescription(outfit);

                        // update new toal stats JList using character in focus 
                        newTotalStatsJList.setModel((newTotalStatsModel(getPartyMember(
                            partyMemberJList.getSelectedValue()), outfit)));
                    }
                }
            }
        );
    }
    
    // RETRIEVING OUTFITS AND UPDATING NEW TOTAL STATS JLIST 
    
    // END: UPDATING OBJECT DESCRIPTION AND DETAILS USING JLIST
    /*******************************************************************************/

    
    // do not do core stuff, ONLY equip stuff
    
    
    
    
    
    
    public void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JFrame frame = new JFrame();
    
    public EquipMenu()
    {
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // use party entity to store references to player entity and inventory
        PlayerEntityFactory entity = new PlayerEntityFactory();
            referencePlayerEntity = entity.getPlayerEntityExample();
                referenceInventory = entity.getPlayerEntityExample().getInventory();
        
        addUsableButtons(frame);
        
        addUnusableTopTitles(frame);
        
        // store party members as values for character displaying JList
        partyMemberJList = new JList(partyMembersInJListFormat(referencePlayerEntity));
        
        // add party member JList to frame
        addPartyMemberJList(partyMemberJList, frame);
        
        canChangeOutfits = new JList();
        
        addCanChangeOutfitsJList(canChangeOutfits, frame);
        
        addCharacterInfoButtons(frame);
        
        addEquippedOutfitsButtons(frame);
        
        addObjectDescriptionAndActionTakenButtons(frame);
        
        addUnusableBottomTitles(frame);
        
        addCharacterAttributeAndResistancesJLists(frame);
        
        displayInventoryOutfitsAsJList(referenceInventory, frame);
        
        // listener updates panel and has a popup menu display on click
        addCharacterJListUpdatePopupListener(partyMemberJList);

        // listener fills in object description/details upon object selection
        addUpdateOutfitInformationJListListener(referenceInventory, inventoryObjectsJList);
        
        // make panel display information about character in first slot
        partyMemberJList.setSelectedIndex(1);
        partyMemberJList.setSelectedIndex(0);
        
        inventoryObjectsJList.setSelectedIndex(1);
        inventoryObjectsJList.setSelectedIndex(0);
        
        
        
        
        
        
        displayFrameWindow();
        
    }
    
}
