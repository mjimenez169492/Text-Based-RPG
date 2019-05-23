package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Commonly_Used_Methods.StaticMethods;
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
    
    
    
    private JList partyMemberJList, canChangeOutfits, currentNewTotalStatsJList, 
        inventoryObjectsJList;
    
    
    
    
    private JButton equippedWeapon, equippedAccessoryOne, equippedAccessoryTwo,
        equippedBodyArmor, equippedLegArmor, equippedFootArmor;

    private JButton equippedOutfitReference;
    
    
    
    // buttons and text area used to updated external frame character panel
    private JButton characterName = new JButton();
    private JButton characterHealth = new JButton();
    private JButton characterStamina = new JButton();
    private JButton characterNano = new JButton();
    
    
    private JFrame externalFrame = new JFrame();
    
    private boolean viewFrameActive, equipFrameActive;
    
    private JButton externalOutfitName = new JButton();
    private JButton externalExperienceMultiplier = new JButton();
    private JButton externalDurabilityInfo = new JButton();
    private JButton externalSlotCoreInfo = new JButton();
    
    // button for equip action button
    private JButton externalEquip = new JButton();
        
    private JList externalOutfitNamesJList = new JList();
    private JList externalEquippedCores = new JList();
    private JList externalOutfitStats = new JList();
    
    // upon selecting equip 
    private GenericCharacter characterForOutfitEquip;
    
    // Note: outfit in focus can only be an equipped outfit 
    private OutfitMethods outfitTiedToOutfitButton;
    
    private JPopupMenu inventoryOutfitsJPopupMenu = new JPopupMenu(); 
    private JPopupMenu equippedOutfitsJPopupMenu = new JPopupMenu();
    
    
    
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
    
    public void addCurrentNewTotalStatsJList(JList jList, int gridy, int gridx, JFrame frame)
    {
        addJListComponent(jList, gridy, gridx, 0.33, 0.33, 2, 2, frame);
    }
    
    public void addCharacterAttributeAndResistancesJLists(JFrame frame)
    {
        currentNewTotalStatsJList = new JList();
            addCurrentNewTotalStatsJList(currentNewTotalStatsJList, 8, 1, frame);
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
                            
                            // update new total stats JList using character in focus 
                            // to prevent info from previous character being shown 
                            if(inventoryObjectsJList.getSelectedValue() != null)
                            {
                                currentNewTotalStatsJList.setModel(currentNewTotalStatsModelWithOutfit(
                                    partyMember, getInventoryOutfit(referenceInventory, 
                                    inventoryObjectsJList.getSelectedValue())));
                            }
                            else
                            {
                                // current stats model for character with current outfits 	
                                currentNewTotalStatsJList.setModel(currentNewTotalStatsModelWithoutOutfit(
                                    partyMember));
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
    public void addOutfitOverviewAndDescription(JFrame frame)
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
    
    // NEW CURRENT NEW TOTAL STATS MODEL USING CHARACTER, OUTFIT (AND ARMOR) 
    
    public String currentNewTotalStatWithOutfit(int counter, String statName, double 
        checkedCurrentValue, double checkedNewValue)
    {
        String currentNewValue = String.format("%-2d) %-18s: (CUR) %-10s (NEW) %-10s", counter, 
            statName, statValueSpacing(String.valueOf(checkedCurrentValue)), 
            statValueSpacing(String.valueOf(checkedNewValue)));
                return currentNewValue;
    }
    
    public String currentNewTotalStatWithoutOutfit(int counter, String statName, double 
        checkedCurrentValue)
    {
        String currentNewValue = String.format("%-2d) %-18s: (CUR) %-10s (NEW) %-10s", counter, 
            statName, statValueSpacing(String.valueOf(checkedCurrentValue)), (desiredSpaces(1) + "<NA>"));
                return currentNewValue;
    }
    
    public void addCurrentNewAttributeObjectsWithOutfit(GenericCharacter character, 
        OutfitMethods outfit, DefaultListModel<String> model)
    {
        Object[] characterAttributes = character.getTotalStats().getAllTotalAttributesWithNames();
        
        Object[] outfitAttributes = outfit.getAllTotalAttributesWithNames();
        
        model.addElement("Attributes");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterAttributes.length; i+=2)
        {
            double currentValue = (double)characterAttributes[i + 1];
            
            double newValue = currentValue + (double)outfitAttributes[i + 1];
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)characterAttributes[i],  
                checkAttribute(currentValue), checkAttribute(newValue)));

            counter++;
        }
    }
    
    public void addCurrentNewAttributeObjectsWithoutOutfit(GenericCharacter character, 
        DefaultListModel<String> model)
    {
        Object[] characterAttributes = character.getTotalStats().getAllTotalAttributesWithNames();
        
        model.addElement("Attributes");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterAttributes.length; i+=2)
        {
            double currentValue = (double)characterAttributes[i + 1];
            
            model.addElement(currentNewTotalStatWithoutOutfit(counter, (String)characterAttributes[i],  
                checkAttribute(currentValue)));
            
            counter++;
        }
    }
    
    public void addCurrentNewEnchantmentResistanceObjectsWithArmor(GenericCharacter character, 
        Armor armor, DefaultListModel<String> model)
    {
        Object[] characterEnchantmentResistances = character.getTotalStats().
            getAllTotalEnchantmentResistancesWithNames();
        
        Object[] armorEnchantmentResistances = armor.
            getAllTotalEnchantmentResistancesWithNames();
        
        model.addElement(" ");
        
        model.addElement("Enchantment Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterEnchantmentResistances.length; i+=2)
        {
            double currentValue = (double)characterEnchantmentResistances[i + 1];
            
            // double newValue = currentValue + (double)armorEnchantmentResistances[i + 1];
            
            double newValue = 0;
            
            // FIX UNEQUIP
            // if armor is equipped, subtract armor value from current value before 
            // value from new armor is added 
            //if()
            //{
                
           // }
            //x
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)characterEnchantmentResistances[i],  
                checkResistance(currentValue), checkResistance(newValue)));

            counter++;
        }
    }
    
    public void addCurrentNewEnchantmentResistanceObjectsWithoutArmor(GenericCharacter character, 
        DefaultListModel<String> model)
    {
        Object[] characterEnchantmentResistances = character.getTotalStats().
            getAllTotalEnchantmentResistancesWithNames();
        
        model.addElement(" ");
        
        model.addElement("Enchantment Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterEnchantmentResistances.length; i+=2)
        {
            double currentValue = (double)characterEnchantmentResistances[i + 1];
            
            model.addElement(currentNewTotalStatWithoutOutfit(counter, (String)characterEnchantmentResistances[i],  
                checkResistance(currentValue)));

            counter++;
        }
    }
    
    public void addCurrentNewStatusEffectResistanceObjectsWithArmor(GenericCharacter character, Armor armor, 
        DefaultListModel<String> model)
    {
        Object[] characterResistances = character.getTotalStats().getAllTotalResistances().toArray( new Object[0]);
        
        Object[] armorResistances = armor.getAllStatusEffectResistances().toArray(new Object[0]);
        
        model.addElement(" ");
        
        model.addElement("Status Effect Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterResistances.length; i+=2)
        {
            double currentValue = (double)characterResistances[i + 1];
            
            double newValue = currentValue + (double)armorResistances[i + 1];
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)characterResistances[i],  
                checkResistance(currentValue), checkResistance(newValue)));

            counter++;
        }
    }
    
    public void addCurrentNewStatusEffectResistanceObjectsWithoutArmor(GenericCharacter character, 
        DefaultListModel<String> model)
    {
        Object[] characterResistances = character.getTotalStats().getAllTotalResistances().toArray( new Object[0]);
        
        model.addElement(" ");
        
        model.addElement("Status Effect Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterResistances.length; i+=2)
        {
            double currentValue = (double)characterResistances[i + 1];
            
            model.addElement(currentNewTotalStatWithoutOutfit(counter, (String)characterResistances[i],  
                checkResistance(currentValue)));

            counter++;
        }
    }
    
    public DefaultListModel<String> currentNewTotalStatsModelWithOutfit(GenericCharacter character,
        OutfitMethods outfit)
    {
        DefaultListModel<String> currentNewTotalStats = new DefaultListModel<>();
        
        // add character and outfit attributes for attribute portion of model
        addCurrentNewAttributeObjectsWithOutfit(character, outfit, currentNewTotalStats);
        
        // if outfit is not a piece of armor, keep resistances the same 
        if(outfit.getClass() != Armor.class)
        {
            addCurrentNewEnchantmentResistanceObjectsWithoutArmor(character, 
                currentNewTotalStats);
            
            addCurrentNewStatusEffectResistanceObjectsWithoutArmor(character, 
                currentNewTotalStats);
        }
        // else account for resistances of armor piece on current stats of character 
        else
        {
            Armor armor = (Armor)outfit;
            
            addCurrentNewEnchantmentResistanceObjectsWithArmor(character, armor, 
                currentNewTotalStats);
            
            addCurrentNewStatusEffectResistanceObjectsWithArmor(character, armor, 
                currentNewTotalStats);
        }
        
        return currentNewTotalStats;
    }
    
    public DefaultListModel<String> currentNewTotalStatsModelWithoutOutfit(GenericCharacter character)
    {
        DefaultListModel<String> currentNewTotalStats = new DefaultListModel<>();
        
        // add character and outfit attributes for attribute portion of model
        addCurrentNewAttributeObjectsWithoutOutfit(character, currentNewTotalStats);
        
        addCurrentNewEnchantmentResistanceObjectsWithoutArmor(character, 
            currentNewTotalStats);

        addCurrentNewStatusEffectResistanceObjectsWithoutArmor(character, 
            currentNewTotalStats);
        
        return currentNewTotalStats;
    }
    
    // NEW CURRENT NEW TOTAL STATS MODEL USING CHARACTER, OUTFIT (AND ARMOR) 

    
    
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
    
    public void resetOutfitOverviewAndDescription()
    {
        outfitOverview.setText("Overview:");
        
        outfitDescription.setText("Description:");
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
                        // prevent passing null upon inventory jlist reload 
                        if(jList.getSelectedValue() != null)
                        {
                            // use selected value of JList to get desired outfit
                            OutfitMethods outfit = getInventoryOutfit(inventory, 
                                jList.getSelectedValue());

                            // update outfit description 
                            updateOutfitOverviewAndDescription(outfit);

                            // update new toal stats JList using character in focus 
                            currentNewTotalStatsJList.setModel((currentNewTotalStatsModelWithOutfit(
                                getPartyMember(partyMemberJList.getSelectedValue()), outfit)));
                        }
                    }
                }
            }
        );
    }
    
    // RETRIEVING OUTFITS AND UPDATING NEW TOTAL STATS JLIST 
    
    // END: UPDATING OBJECT DESCRIPTION AND DETAILS USING JLIST
    /*******************************************************************************/

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // START: VIEW AND EQUIP ACTIONLISTENERS FOR POPUPMENU OPTIONS 
    /*******************************************************************************/

    // SELECTED OBJECT JLIST WITH JSCROLLPANE FUNCTIONALITY
    
    /* idea
        find objectin treemap inventory and get its VALUE (ArrayList<GenericObject>)
        for loop through ArrayList retreived (0 to n)
        info displayed:
            Buttons (col 2)
                name
                cur/max durability
                number of filled slots / number of slots
            JLists 
                outfits displayed via JList (col 1)
                equipped core types with core info (size and tier ONLY) (col 3)
                stats (col 4)
                    Weapon, Accessory 
                        Attributes JList
                    Armor
                        Attributes JList, 
                        Enchantment Resistance JList, 
                        Status Effect Resistance JList
    */
    
    // METHODS FOR ADDING COMPONENTS TO EXTERNAL FRAME 
    
    public void addJListToExternalFrame(JList jList, int gridx, JFrame externalFrame)
    {
        // set JList text font 
        jList.setFont(JListFont);
        
        // add text area with horizontal scroll capability only 
        JScrollPane jListScroll = new JScrollPane(jList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.25;
        
        // specified row length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.25;
        
        // height is 4 column 
        gridBagConstraints.gridheight = 4;
        
        // width is 1 column 
        gridBagConstraints.gridwidth = 1;

        externalFrame.add(jListScroll, gridBagConstraints);
    }
    
    public JButton newExternalButton(JButton button)
    {
        button = new JButton();
        
        // text will be displayed starting at furthest left of button text area 
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addButtonToExternalFrame(JButton button, int gridy, int gridx, 
        JFrame externalFrame)
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
        gridBagConstraints.weighty = 0.11;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.11;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        externalFrame.add(button, gridBagConstraints);
    }
    
    public void addOutfitInfoButtonsToExternalFrame(int gridx, JFrame externalFrame)
    {
        addButtonToExternalFrame(externalOutfitName, 0, gridx, externalFrame);
        
        addButtonToExternalFrame(externalExperienceMultiplier, 1, gridx, externalFrame);
        
        addButtonToExternalFrame(externalDurabilityInfo, 2, gridx, externalFrame);
        
        addButtonToExternalFrame(externalSlotCoreInfo, 3, gridx, externalFrame);
    }
    
    // METHODS FOR ADDING COMPONENTS TO EXTERNAL FRAME 
    
    
    
    // EQUIP BUTTON ACTION FOR EQUIP EXTERNAL FRAME 
    
    public enum OutfitLocations
    { 
        WEAPON("Weapon"), BODY_ARMOR("Body Armor"), LEG_ARMOR("Leg Armor"), 
            FOOT_ARMOR("Foot Armor"), ACCESSORY_ONE("Accessory One"), 
            ACCESSORY_TWO("Accessory Two");
        
        private String outfitLocation;
        
        OutfitLocations(String outfitLocation)
        {
            this.outfitLocation = outfitLocation;
        }
        
        public String getEnumAsString()
        {
            return outfitLocation;
        }
    } 
    
    public String outfitLocation(OutfitMethods outfit)
    {
        String location = null;
        
        // different ways to retrieve location based on weapon, armor, or accessory 
        if(outfit.getClass() == Weapon.class || outfit.getClass() == Accessory.class)
        {
            // Note: differs from Armor objects since Weapon/Accessory objects are 
            //       created according to a different naming scheme 
            location = outfit.getMainClassString();
        }
        // account for armor which can be placed on body, legs, or feet
        else
        {
            location = outfit.getCategory();
        }
        
        return location;
    }
    
    public boolean canEquipOutfitAtLocation(String location, GenericCharacter character)
    {
        boolean result = false;
        
        switch(OutfitLocations.valueOf(StaticMethods.stringToEnum(location)))
        {
            case WEAPON:
                result = character.getEquippableOutfits().getWeaponChangeState();
                    break;
            case BODY_ARMOR:
                result = character.getEquippableOutfits().getBodyArmorChangeState();
                    break;
            case LEG_ARMOR:
                result = character.getEquippableOutfits().getLegArmorChangeState();
                    break;
            case FOOT_ARMOR:
                result = character.getEquippableOutfits().getFootArmorChangeState();
                    break;
            case ACCESSORY_ONE:
                result = character.getEquippableOutfits().getAccessoryOneChangeState();
                    break;
            case ACCESSORY_TWO:
                result = character.getEquippableOutfits().getAccessoryTwoChangeState();
                    break;
        }
        
        return result;
    }
    
    public OutfitMethods getOutfitAtLocation(String location, GenericCharacter character)
    {
        OutfitMethods outfit = null;
        
        switch(OutfitLocations.valueOf(StaticMethods.stringToEnum(location)))
        {
            case WEAPON:
                outfit = character.getEquippableOutfits().getWeapon();
                    break;
            case BODY_ARMOR:
                outfit = character.getEquippableOutfits().getBodyArmor();
                    break;
            case LEG_ARMOR:
                outfit = character.getEquippableOutfits().getLegArmor();
                    break;
            case FOOT_ARMOR:
                outfit = character.getEquippableOutfits().getFootArmor();
                    break;
            case ACCESSORY_ONE:
                outfit = character.getEquippableOutfits().getAccessoryOne();
                    break;
            case ACCESSORY_TWO:
                outfit = character.getEquippableOutfits().getAccessoryTwo();
                    break;
        }
        
        return outfit;
    }
    
    public void removeEquippedOutfit(String location, GenericCharacter character)
    {
        switch(OutfitLocations.valueOf(StaticMethods.stringToEnum(location)))
        {
            case WEAPON:
                character.getEquippableOutfits().setWeapon(null);
                    break;
            case BODY_ARMOR:
                character.getEquippableOutfits().setBodyArmor(null);
                    break;
            case LEG_ARMOR:
                character.getEquippableOutfits().setLegArmor(null);
                    break;
            case FOOT_ARMOR:
                character.getEquippableOutfits().setFootArmor(null);
                    break;
            case ACCESSORY_ONE:
                character.getEquippableOutfits().setAccessoryOne(null);
                    break;
            case ACCESSORY_TWO:
                character.getEquippableOutfits().setAccessoryTwo(null);
                    break;
        }
    }
    
    public void equipOutfitAtLocation(String location, OutfitMethods outfit, GenericCharacter 
        character)
    {
        switch(OutfitLocations.valueOf(StaticMethods.stringToEnum(location)))
        {
            case WEAPON:
                character.getEquippableOutfits().setWeapon((Weapon)outfit);
                    break;
            case BODY_ARMOR:
                character.getEquippableOutfits().setBodyArmor((Armor)outfit);
                    break;
            case LEG_ARMOR:
                character.getEquippableOutfits().setLegArmor((Armor)outfit);
                    break;
            case FOOT_ARMOR:
                character.getEquippableOutfits().setFootArmor((Armor)outfit);
                    break;
            case ACCESSORY_ONE:
                character.getEquippableOutfits().setAccessoryOne((Accessory)outfit);
                    break;
            case ACCESSORY_TWO:
                character.getEquippableOutfits().setAccessoryTwo((Accessory)outfit);
                    break;
        }
    }
    
    public int positionOfOutfitInJList(JList inventoryJList, String outfitName)
    {
        int counter = 0;
        
        for(int i = 0; i < inventoryJList.getModel().getSize(); i++)
        {
            if(outfitName.equals(inventoryJList.getModel().getElementAt(i)))
            {
                break;
            }
            else
            {
                counter++;
            }
        }
        
        return counter;
    }
    
    public void outfitRemovalAndInventoryJListReload(int jListOutfitPosition, 
        OutfitMethods jListOutfit)
    {
        updateCharacterInfo(characterForOutfitEquip);
        
	updateEquippedOutfitsButtons(characterForOutfitEquip);
        
        referenceInventory.removeObject(jListOutfit);
                                
        inventoryObjectsJList.setModel(inventoryOutfitsInJListFormat
            (referenceInventory));

        shiftToNextExistingObject(inventoryObjectsJList, 
            jListOutfitPosition);
    }
    
    public void addEquipActionListener(JButton button, JList outfitArrayListJList,
        JFrame externalFrame)
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    OutfitMethods jListOutfit = (OutfitMethods)outfitArrayList().get(
                        positionOfOutfitInJList(externalOutfitNamesJList, (String)
                        externalOutfitNamesJList.getSelectedValue()));
                    
                    // proceed if outfit can be placed at character's outfit location
                    if(canEquipOutfitAtLocation(outfitLocation(jListOutfit), characterForOutfitEquip))
                    {
                        OutfitMethods equippedOutfit = getOutfitAtLocation(outfitLocation(
                            jListOutfit), characterForOutfitEquip);
                        
                        int jListOutfitPosition = positionOfOutfitInJList(inventoryObjectsJList, 
                            jListOutfit.getName());
                        
                        // if location that outfit must be equipped at has an outfit in
                        // place, then attempt to "swap" it with equipped outfit 
                        if(equippedOutfit != null)
                        {
                            // proceed if inventory can hold instance of equipped outfit 
                            if(referenceInventory.canAddObject(equippedOutfit))
                            {
                                removeEquippedOutfit(outfitLocation(equippedOutfit), 
                                    characterForOutfitEquip);
                                
                                equipOutfitAtLocation(outfitLocation(jListOutfit), 
                                    jListOutfit, characterForOutfitEquip);
                                
                                referenceInventory.addObject(equippedOutfit);
                                
                                outfitRemovalAndInventoryJListReload(jListOutfitPosition, 
                                    jListOutfit);
                            }
                        }
                        // else equip outfit to character at appropriate location 
                        else
                        {
                            equipOutfitAtLocation(outfitLocation(jListOutfit), 
                                jListOutfit, characterForOutfitEquip);
                            
                            outfitRemovalAndInventoryJListReload(jListOutfitPosition, 
                                jListOutfit);
                        }
                    }
                }
            }
        );
        
    }
    
    public void addEquipButton(JList outfitArrayListJList, int gridx, JFrame externalFrame)
    {
        JButton button = new JButton("Equip");
        
        // set button font 
        button.setFont(buttonFont);
        
        // add use item on multiple targets functionality for button 
        addEquipActionListener(button, outfitArrayListJList, externalFrame);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (3/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.3;
        
        // specified row length component takes up (3/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.3;
        
        // height is 4 column 
        gridBagConstraints.gridheight = 4;
        
        // width is 1 column 
        gridBagConstraints.gridwidth = 1;
        
        externalFrame.add(button, gridBagConstraints);
    }
    
    // EQUIP BUTTON ACTION FOR EQUIP EXTERNAL FRAME 

    
    
    // INITIALIZING EXTERNL FRAME COMPONENTS
    
    public ArrayList<GenericObject> outfitArrayList()
    {
        ArrayList<GenericObject> outfitArrayList = new ArrayList<>();
        
        GenericObject outfit = getInventoryOutfit(referenceInventory, 
            inventoryObjectsJList.getSelectedValue());
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : referenceInventory.
            getInventory().entrySet())
        {
            if(outfit.equals(entry.getKey()))
            {
                outfitArrayList = entry.getValue();
                    break;
            }
        }
        
        return outfitArrayList;
    }

    public DefaultListModel<String> equipFrameOutfitModel(ArrayList<GenericObject> arrayList)
    {
        DefaultListModel<String> outfits = new DefaultListModel<>();
        
        for(GenericObject object : arrayList)
        {
            outfits.addElement(object.getName());
        }
        
        return outfits;
    }
    
    // Note: if 1 outfit, supply outfit immediately in external frame set up 
    public void updateExternalButtonsForOutfitInFocus(OutfitMethods outfit)
    {
        String formattedName = String.format("%-26s", outfit.getName());
            externalOutfitName.setText(formattedName);
        
        String formattedExpMultiplier = String.format("%-14s: %-3s", "EXP Multiplier",
            statValueSpacing(String.valueOf(outfit.getExpMultiplier())));
            externalExperienceMultiplier.setText(formattedExpMultiplier);
        
        String formattedDurability = String.format("%-12s: %s / %s", "Durability",
            statValueSpacing(String.valueOf(outfit.getCurrentDurability())), 
            statValueSpacing(String.valueOf(outfit.getMaxDurability())));
            externalDurabilityInfo.setText(formattedDurability);
        
        String formattedSlotCoreInfo = String.format("%-12s: %s / %s", "Core / Slot",
            statValueSpacing(String.valueOf(outfit.getNumberOfExistingCores())), 
            statValueSpacing(String.valueOf(outfit.getMaxNumberOfOutfitSlots())));
            externalSlotCoreInfo.setText(formattedSlotCoreInfo);
    }
    
    public String coreInformationFormat(int counter, Core core)
    {
        String coreFormat = String.format("%d Core -> Type:%-14s\tSize: %-12s\t Tier: %-6s",
            counter, core.getCoreType(), core.getCoreSizeString(), core.getCoreTierString());
        
        return coreFormat;
    }
    
    public DefaultListModel<String> equipFrameEquippedCoresModel(OutfitMethods outfit)
    {
        DefaultListModel<String> equippedCoresModel = new DefaultListModel<>();
        
        Core[] cores = outfit.getExistingCores();
        
        equippedCoresModel.addElement("Equipped Cores");
        
        equippedCoresModel.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < cores.length; i++)
        {
            if(cores[i] != null)
            {
                equippedCoresModel.addElement(coreInformationFormat(counter, cores[i]));
            }
        }
        
        return equippedCoresModel;
    }
    
    public String totalOutfitStats(int counter, String statName, double checkedCurrentValue)
    {
        String currentNewValue = String.format("%-2d) %-18s: %-5s", counter, 
            statName, statValueSpacing(String.valueOf(checkedCurrentValue)));
                return currentNewValue;
    }
    
    public void addOutfitAttributes(OutfitMethods outfit, DefaultListModel<String> model)
    {
        Object[] outfitAttributes = outfit.getAllTotalAttributesWithNames();
        
        model.addElement("Attributes");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < outfitAttributes.length; i+=2)
        {
            double currentValue = (double)outfitAttributes[i + 1];
            
            model.addElement(totalOutfitStats(counter, (String)outfitAttributes[i], 
                checkAttribute(currentValue)));
            
            counter++;
        }
    }
    
    public void addArmorEnchantmentResistance(Armor armor, DefaultListModel<String> model)
    {
        Object[] armorEnchantmentResistances = armor.getAllTotalEnchantmentResistancesWithNames();
        
        model.addElement(" ");
        
        model.addElement("Enchantment Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < armorEnchantmentResistances.length; i+=2)
        {
            double currentValue = (double)armorEnchantmentResistances[i + 1];
            
            model.addElement(totalOutfitStats(counter, (String)armorEnchantmentResistances[i],  
                checkResistance(currentValue)));

            counter++;
        }
    }
    
    public void addArmorStatusEffectResistance(Armor armor, DefaultListModel<String> model)
    {
        Object[] armorStatusEffectResistances = armor.getAllStatusEffectResistances().toArray(new Object[0]);
        
        model.addElement(" ");
        
        model.addElement("Status Effect Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < armorStatusEffectResistances.length; i+=2)
        {
            double currentValue = (double)armorStatusEffectResistances[i + 1];
            
            model.addElement(totalOutfitStats(counter, (String)armorStatusEffectResistances[i],  
                checkResistance(currentValue)));

            counter++;
        }
    }
    
    public DefaultListModel<String> outfitStatsModel(OutfitMethods outfit)
    {
        DefaultListModel<String> outfitStats = new DefaultListModel<>();
        
        // add character and outfit attributes for attribute portion of model
        addOutfitAttributes(outfit, outfitStats);
        
        // if outfit is a piece of armor, add resistances to model 
        if(outfit.getClass() == Armor.class)
        {
            addArmorEnchantmentResistance((Armor)outfit, outfitStats);
            
            addArmorStatusEffectResistance((Armor)outfit, outfitStats);
        }
        
        return outfitStats;
    }
    
    // INITIALIZING EXTERNL FRAME COMPONENTS
    
    
    
    // OUTFIT ARRAYLIST JLIST LISTENER FOR UPDATING EXTERNAL FRAME INFO 
    
// int jListOutfitPosition = positionOfOutfitInJList(inventoryObjectsJList, jListOutfit);
    // outfitArrayList().get(positionOfOutfitInJList(jList, jListOutfit))
        // outfitArrayList
    
    // listener used for updating information displayed on external frame 
    public void addOutfitArrayListJListUpdateInfoListener(JList jList, JFrame externalFrame)
    {
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    if(jList.getSelectedValue() != null)
                    {
                        // add listener for externalOutfitNamesJList that updates 
                        // button info equipped cores, and outfit stats 

                        OutfitMethods outfit = (OutfitMethods)outfitArrayList().get(
                            positionOfOutfitInJList(jList, (String)jList.getSelectedValue()));

                        updateExternalButtonsForOutfitInFocus(outfit);

                        externalEquippedCores.setModel(equipFrameEquippedCoresModel(outfit));

                        externalOutfitStats.setModel(outfitStatsModel(outfit));
                    }
                }
            }
        );
    }
    
    // OUTFIT ARRAYLIST JLIST LISTENER FOR UPDATING EXTERNAL FRAME INFO 
    
    
    // boolean instance variables viewFrameActive and equipFrameActive determine
    // how external frame is set up as well as functionality it provides 
    public void externalFrameByBoolean(JFrame externalFrame)
    {
        // if concerns view frame suited only for equipped outfits  
        if(viewFrameActive)
        {
            // initialize components 
            
                // NEED TO DETERMINE OUTFIT FROM OUTFIT BUTTON!!!
            updateExternalButtonsForOutfitInFocus(outfitTiedToOutfitButton);
            externalEquippedCores.setModel(equipFrameEquippedCoresModel(outfitTiedToOutfitButton));
            externalOutfitStats.setModel(outfitStatsModel(outfitTiedToOutfitButton));
            
            // components: col 0 -> info buttons, col 1 -> equipped cores, 
            //             col 2 -> all outfit stats 
            addOutfitInfoButtonsToExternalFrame(0, externalFrame);
            addJListToExternalFrame(externalEquippedCores, 1, externalFrame);
            addJListToExternalFrame(externalOutfitStats, 2, externalFrame);
            
            externalOutfitNamesJList.setSelectedIndex(0);
        }
        else if(equipFrameActive)
        {
            externalOutfitNamesJList.setModel(equipFrameOutfitModel(outfitArrayList()));
            externalOutfitStats.setModel(outfitStatsModel((OutfitMethods)outfitArrayList().get(0)));
            
            // display info for first object in outfit ArrayList using buttons 
            updateExternalButtonsForOutfitInFocus((OutfitMethods)outfitArrayList().get(0));
            
            // add listener for externalOutfitNamesJList that updates button info
            // equipped cores, and outfit stats 
            addOutfitArrayListJListUpdateInfoListener(externalOutfitNamesJList, externalFrame);
            
            // components: col 0 -> outfitArrayList     col 1 -> info buttons, 
            //             col 2 -> equipped cores,     col 3 -> all outfit stats 
            //             col 4 -> equip button 
            addJListToExternalFrame(externalOutfitNamesJList, 0, externalFrame);
            addOutfitInfoButtonsToExternalFrame(1, externalFrame);
            addJListToExternalFrame(externalOutfitStats, 2, externalFrame);
            addEquipButton(externalOutfitNamesJList, 3, externalFrame);
            
            externalOutfitNamesJList.setSelectedIndex(0);
        }
    }
    
    
    
    
    
    
    
    
    // update object overview/description and inventory object group count upon equip 
    public void shiftToNextExistingObject(JList inventoryJList, int outfitPositionInJList)
    {
        // account for when no object exists first
        if(inventoryJList.getModel().getSize() == 0)
        {
            resetOutfitOverviewAndDescription();
        }
        // move forward or backward until another object is found FROM position last
        // occupied by outfit that was equipped (if possible)
        else
        {
            // if attempts to update outfit info using supplied position
            if(outfitPositionInJList < inventoryJList.getModel().getSize())
            {
                // get object at designated location and update object information
                updateOutfitOverviewAndDescription(getInventoryOutfit(referenceInventory,
                    inventoryJList.getModel().getElementAt(outfitPositionInJList)));
                
                // set selected index to be position of last object group - 1 since 
                // positions range from 0 to (inventoryJList.getModel().size() - 1)
                inventoryJList.setSelectedIndex(outfitPositionInJList - 1);
            }
            // move backward to position (inventoryJList.getModel().getSize() - 1) to 
            // display next object that exists to account for when an object at position 
            // inventoryJList.getModel().getSize() is removed 
            else
            {
                // get object at designated location and update object information
                updateOutfitOverviewAndDescription(getInventoryOutfit(referenceInventory,
                    inventoryJList.getModel().getElementAt(inventoryJList.getModel().getSize() - 1)));
                
                // set selected index to be position of inventoryJList.getModel().getSize() - 1 since 
                // positions range from 0 to (inventoryJList.getModel().size() - 1)
                inventoryJList.setSelectedIndex(inventoryJList.getModel().getSize() - 1);
            }
        }
    }
    
    public void externalFrameLocation()
    {
        // store character selected to have outfit equipped 
        characterForOutfitEquip = getPartyMember((String)partyMemberJList.
            getSelectedValue());
        
        // external frame is reset each time option is selected (better than 
        // creating new JFrames each time option is selected)
        externalFrame = new JFrame();

        // frame has components set up according to GridBagLayout scheme 
        externalFrame.getContentPane().setLayout(new GridBagLayout());
        
        // use location properties of original frame to position use frame
        Rectangle bounds = frame.getBounds();

        // calculation makes frame have location starting from bottom left 
        // of outer frame with y-axis position based on bounds.y multiplier 
        // (in this case 1.75) and outer multiplier (in this case 0.58); 
        externalFrame.setLocation(bounds.x, (int)((bounds.y * 1.75 + frame.
            getHeight()) * 0.58));

        // set up components for external frame so player can use it 
        externalFrameByBoolean(externalFrame);

        // external frame width equal to width of original frame and while height 
        // is calculated using original frame height as point of reference 
        externalFrame.setSize(frame.getWidth(), (int)(0.42 * frame.getHeight()));
        externalFrame.setVisible(true);

        // Note: externalFrame is NOT set to exit on close since doing so will 
        //       cause program to terminate early (disposing original frame 
        //       will dispose of this frame as well (Maybe?))
    }
    
    // FOR BUTTON THAT DISPLAYS EQUIPPED OUTFITS POPUP MENU  
    public void addViewActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // set other external frame variant to false 
                    equipFrameActive = false;
                    
                    // prevents creation of infinite exteral frames by disposing 
                    // of external frame if it is active before creating new one
                    // and reset appropriate boolean indicators 
                    externalFrame.dispose();
                    
                    // indicate frame style that should be active
                    viewFrameActive = true;
                    
                    // set up new external frame according to view/equip boolean 
                    externalFrameLocation();
                }
            }); 
    }
    
    // FOR INVENTORY JLIST POPUP MENU 
    public void addEquipActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // set other external frame variant to false 
                    viewFrameActive = false;
                    
                    // prevents creation of infinite exteral frames by disposing 
                    // of external frame if it is active before creating new one
                    // and reset appropriate boolean indicators 
                    externalFrame.dispose();
                    
                    // indicate frame style that should be active
                    equipFrameActive = true;
                    
                    // set up new external frame according to view/equip boolean 
                    externalFrameLocation();                }
            }); 
    }
    
    // END: VIEW AND EQUIP ACTIONLISTENERS FOR POPUPMENU OPTIONS 
    /*******************************************************************************/

    
    
    // START: UNEQUIP ACTIONLISTENER FOR EQUIPPED OUTFITS BUTTONS 
    /*******************************************************************************/

    // method needs equippedOutfitReference reference set upon buttoon click
    public OutfitMethods getEquippedOutfit()
    {
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        // meant to store object of OutfitMethods subclass after implicit casting 
        OutfitMethods outfit = null;
        
        // equippedOutfitReference uses JButton reference to retrive certain outfit 
        if(equippedOutfitReference == equippedWeapon)
        {
            outfit = character.getEquippableOutfits().getWeapon();
        }
        else if(equippedOutfitReference == equippedBodyArmor)
        {
            outfit = character.getEquippableOutfits().getBodyArmor();
        }
        else if(equippedOutfitReference == equippedLegArmor)
        {
            outfit = character.getEquippableOutfits().getLegArmor();
        }
        else if(equippedOutfitReference == equippedFootArmor)
        {
            outfit = character.getEquippableOutfits().getFootArmor();
        }
        else if(equippedOutfitReference == equippedAccessoryOne)
        {
            outfit = character.getEquippableOutfits().getAccessoryOne();
        }
        else if(equippedOutfitReference == equippedAccessoryTwo)
        {
            outfit = character.getEquippableOutfits().getAccessoryTwo();
        }
        
        return outfit;
    }
    
    // determines whether outfit can be equipped or unequipped
    public boolean canAlterOutfitLocation()
    {
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        boolean result = false;
        
        // equippedOutfitReference uses JButton reference to retrive certain outfit 
        if(equippedOutfitReference == equippedWeapon)
        {
            result = character.getEquippableOutfits().getWeaponChangeState();
        }
        else if(equippedOutfitReference == equippedBodyArmor)
        {
            result = character.getEquippableOutfits().getBodyArmorChangeState();
        }
        else if(equippedOutfitReference == equippedLegArmor)
        {
            result = character.getEquippableOutfits().getLegArmorChangeState();
        }
        else if(equippedOutfitReference == equippedFootArmor)
        {
            result = character.getEquippableOutfits().getFootArmorChangeState();
        }
        else if(equippedOutfitReference == equippedAccessoryOne)
        {
            result = character.getEquippableOutfits().getAccessoryOneChangeState();
        }
        else if(equippedOutfitReference == equippedAccessoryTwo)
        {
            result = character.getEquippableOutfits().getAccessoryTwoChangeState();
        }
        
        return result;
    }
    
    public void removeEquippedOutfit()
    {
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        // equippedOutfitReference uses JButton reference to retrive certain outfit 
        if(equippedOutfitReference == equippedWeapon)
        {
            character.getEquippableOutfits().setWeapon(null);
        }
        else if(equippedOutfitReference == equippedBodyArmor)
        {
            character.getEquippableOutfits().setBodyArmor(null);
        }
        else if(equippedOutfitReference == equippedLegArmor)
        {
            character.getEquippableOutfits().setLegArmor(null);
        }
        else if(equippedOutfitReference == equippedFootArmor)
        {
            character.getEquippableOutfits().setFootArmor(null);
        }
        else if(equippedOutfitReference == equippedAccessoryOne)
        {
            character.getEquippableOutfits().setAccessoryOne(null);
        }
        else if(equippedOutfitReference == equippedAccessoryTwo)
        {
            character.getEquippableOutfits().setAccessoryTwo(null);
        }
    }
    
    public void postUnequipTasks()
    {
        referenceInventory.addObject(getEquippedOutfit());
        
        removeEquippedOutfit();
        
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        updateCharacterInfo(character);
        
	updateEquippedOutfitsButtons(character);
        
        resetOutfitOverviewAndDescription();
        
        inventoryObjectsJList.setModel(inventoryOutfitsInJListFormat(referenceInventory));
    }
    
    // FOR BUTTON THAT DISPLAYS EQUIPPED OUTFITS POPUP MENU ONLY 
    public void addUnequipActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(getEquippedOutfit() != null)
                    {
                        if(canAlterOutfitLocation())
                        {
                            if(referenceInventory.canAddObject(getEquippedOutfit()))
                            {
                                postUnequipTasks();
                            }
                        }
                    }
                }
            }); 
    }
    
    // END: UNEQUIP ACTIONLISTENER FOR EQUIPPED OUTFITS BUTTONS 
    /*******************************************************************************/

    
    
    
    // START: ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU 
    /*******************************************************************************/
    
    // holds types of action listeners JMenuItems can have for popupMenu
    public enum ActionListeners
    {
        VIEW, EQUIP, UNEQUIP;
    }
    
    // switch case is used to add appropriate action listener to JMenuItem 
    public void addActionListenerToJMenuItem(ActionListeners choice, JMenuItem menuItem)
    {
        switch(choice)
        {
            case VIEW:
                addViewActionListener(menuItem);
                    break;
            case EQUIP:
                addEquipActionListener(menuItem);
                    break;
            case UNEQUIP:
                addUnequipActionListener(menuItem);
                    break;
        }
    }
    
    // add JMenuItem to popup menu 
    public void addPopupMenuJMenuItem(JPopupMenu popupMenu, String jMenuItemName,
        ActionListeners choice)
    {
        JMenuItem option = new JMenuItem(jMenuItemName);
        
        addActionListenerToJMenuItem(choice, option);
        
        popupMenu.add(option);
    }
    
    // Note: each popup menu needs its own object because if each popup menu
    //       refers to same object, last popup menu to add object is the only 
    //       popup menu that will have access to object 
    public void setUpPopupMenusByObject(JPopupMenu inventoryJListJPopupMenu, JPopupMenu
        equipsJPopupMenu)
    {
        addPopupMenuJMenuItem(inventoryJListJPopupMenu, "Equip", ActionListeners.EQUIP);
        
        addPopupMenuJMenuItem(equipsJPopupMenu, "View", ActionListeners.VIEW);
        addPopupMenuJMenuItem(equipsJPopupMenu, "Unequip", ActionListeners.UNEQUIP);
    }
    
    // shows a different popup menu filled with choices for object based on its class 
    // upon left clicking JList value with mouse 
    public void addinventoryOutfitsJListOptionsListener(JList jList, JPopupMenu 
        inventoryJListJPopupMenu)
    {
        jList.addMouseListener(
            new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    // proceed only if left mouse button clicked, list selection is 
                    // not empty, and clicked point is inside selected object bounds 
                    if (SwingUtilities.isLeftMouseButton(me) && !jList.isSelectionEmpty()
                        && jList.locationToIndex(me.getPoint()) == jList.getSelectedIndex()) 
                    {
                        inventoryJListJPopupMenu.show(jList, me.getX(), me.getY());
                    }
                }
            }
        );
    }
    
    // ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU
    
    // END: INVENTORY JLIST (OUTFITS ONLY), OBJECT DESCRIPTION, AND NEW JLISTS 
    /*******************************************************************************/

    
    
    // START: OUTFIT BUTTON POPUP MENU 
    /*******************************************************************************/

    public void addButtonJPopupMenuActionListener(JButton button, String outfitLocation)
    {
        button.addActionListener(
            new ActionListener() 
            {
                String location = outfitLocation;
                
                @Override
                public void actionPerformed(ActionEvent ev) 
                {
                    OutfitMethods outfit = getOutfitAtLocation(location, getPartyMember(
                        partyMemberJList.getSelectedValue()));
                    
                    // proceed if outfit at location of party member is not null
                    if(outfit != null)
                    {
                        outfitTiedToOutfitButton = outfit;
                        
                        // popup menu is displayed on bottom left of butotn 
                        equippedOutfitsJPopupMenu.show(button, 0, button.getBounds().height);
                    }
                }
            });
    }
    
    public void equippedOutfitButtonsJPopupMenu()
    {
        JButton[] buttonArray = {equippedWeapon, equippedBodyArmor, equippedLegArmor, 
            equippedFootArmor, equippedAccessoryOne, equippedAccessoryTwo,};
        
        String[] locationArray = {"Weapon", "Body Armor", "Leg Armor", "Foot Armor", 
            "Accessory One", "Accessory Two"};
        
        for(int i = 0; i < buttonArray.length; i++)
        {
            addButtonJPopupMenuActionListener(buttonArray[i], locationArray[i]);
        }        
    }
    
    // END: OUTFIT BUTTON POPUP MENU 
    /*******************************************************************************/

    
    
    
    
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
        
        addOutfitOverviewAndDescription(frame);
        
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
        
        
        // initialize popup menus 
        setUpPopupMenusByObject(inventoryOutfitsJPopupMenu, equippedOutfitsJPopupMenu);
        
        // popup menu showing options for player upon outfit selection 
        addinventoryOutfitsJListOptionsListener(inventoryObjectsJList, inventoryOutfitsJPopupMenu);
        
        // add popup menu functionality for equipped outfit buttons 
        equippedOutfitButtonsJPopupMenu();
        
        
        
        
        
        
        displayFrameWindow();
        
    }
    
}
