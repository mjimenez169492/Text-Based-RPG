package RunProject;


import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;
import Generic_Object.Item;
import Move_Creation.Moves;
import Move_Creation.MoveCalculations;
import Player_Entity.Party;
import Object_Factories.MovesFactory;

import java.util.PriorityQueue;
import java.security.SecureRandom;
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



public class BattleMenu 
{
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    private Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    private int buttonVerticalPadding = 0;
    
    private int jListVerticalPadding = 0;
    
    private JList currentRoundJList, nextRoundJList, escapedCharactersJList;
    
    private JButton attack, skills, items;
    
    private JList partyOneBottom, partyTwoTop;
    
    private JTextArea battleLog;
    
    private Party referencePartyOne, referencePartyTwo;
    
    
    
    
    
    private JFrame externalFrame = new JFrame();
    
    private boolean attackFrameActive, skillsFrameActive, itemsFrameActive;
    
    
    
    
    private JButton attackName, attackOverview, attackDescription;
    
    private JList allAvailableNonKoCombatantsJList;
    
    private JButton attackChoice;
    
    
    
    private JButton overview, description;
    
    private JList controlledMove, uncontrolledMove;
    
    private JList controlledItemMove, uncontrolledItemMove;
    
    private JList controlledMoveTargets, uncontrolledMoveTargets;
    
    private JButton useControlledMove, useUncontrolledMove;
    
    
    
    
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

    
    
    // START: UNUSABLE LAYOUT BUTTONS 
    /*******************************************************************************/

    public JButton buttonUsedForLayout()
    {
        JButton button = new JButton(" ");
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void topLayoutButtons(JFrame frame)
    {
        for(int i = 0; i < 6; i++)
        {
            addButtonComponent(buttonUsedForLayout(), 0, i, 0.11, 0.33, 1, 1, frame);
        }
    }
    
    public void bottomLayoutButtons(JFrame frame)
    {
        for(int i = 3; i < 7; i++)
        {
            addButtonComponent(buttonUsedForLayout(), 15, i, 0.11, 0.33, 1, 1, frame);
        }
    }
    
    
    // END: UNUSABLE LAYOUT BUTTONS 
    /*******************************************************************************/

    
    // START: USABLE BUTTONS
    /*******************************************************************************/
    
    public JButton newUsableButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void usableButtonPlacement(JButton button, int gridy, int gridx, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, gridy, gridx, 0.11, 0.33, 1, 1, frame);
    }
    
    public void addUsableButtons(JFrame frame)
    {
        attack = newUsableButton("Attack");
            usableButtonPlacement(attack, 15, 0, frame);
        
        skills = newUsableButton("Skills");
            usableButtonPlacement(skills, 15, 1, frame);
        
        items = newUsableButton("Items");
            usableButtonPlacement(items, 15, 2, frame);
    }
    
    // END: USABLE BUTTONS
    /*******************************************************************************/

    

    // START: PARTY ONE AND PARTY TWO JLISTS 
    /*******************************************************************************/

    public void addPartyMemberJListComponent(JList jList, int gridy, int gridx, 
        int gridheight, int gridwidth, JFrame frame)
    {
        jList.setFont(JListFont);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane statsScroll = new JScrollPane(jList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.60;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.60;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 4;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 150;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public void addPartyMemberJLists(JFrame frame)
    {
        partyOneBottom = new JList(partyMembersModel(referencePartyOne));
            addPartyMemberJListComponent(partyOneBottom, 11, 0, 4, 6, frame);
        
        partyTwoTop = new JList(partyMembersModel(referencePartyTwo));
            addPartyMemberJListComponent(partyTwoTop, 1, 0, 4, 6, frame);
    }
    
    // END: PARTY ONE AND PARTY TWO JLISTS 
    /*******************************************************************************/

    
    // START: UNUSABLE TURN TRACKING JLIST TITLE BUTTONS 
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
    
    public void addUnusableTurnTrackingJListTitles(JFrame frame)
    {
        String currentRoundTitle = String.format("%26s", "Current Round Turn Order");
            addTitleButton(currentRoundTitle, 0, 6, 1, frame);
        
        String nextRoundTitle = String.format("%26s", "Next Round Turn Order");
            addTitleButton(nextRoundTitle, 5, 6, 1, frame);
        
        String escapedCharactersTitle = String.format("%26s", "Escaped Characters");
            addTitleButton(escapedCharactersTitle, 10, 6, 1, frame);
    }
    
    // END: UNUSABLE TURN TRACKING JLIST TITLE BUTTONS 
    /*******************************************************************************/

    
    
    // START: JLIST JTEXTAREA BUTTON TITLES 
    /*******************************************************************************/

    public void addJListJTextAreaButtonTitles(JFrame frame)
    {
        String opposingPartyFormatted = String.format("%s", "Enemies");
            addTitleButton(opposingPartyFormatted, 5, 0, 1, frame);
        
        String playerPartyFormatted = String.format("%s", "Allies");
            addTitleButton(playerPartyFormatted, 10, 0, 1, frame);
    }
    
    // END: JLIST JTEXTAREA BUTTON TITLES 
    /*******************************************************************************/



    // START: ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/

    public void addTurnTrackingJListComponent(JList jList, int gridy, int gridwidth, 
        JFrame frame)
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
        gridBagConstraints.gridx = 6;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.20;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 4;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 150;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public void addTurnTrackingJLists(JFrame frame)
    {
        currentRoundJList = new JList();
            addTurnTrackingJListComponent(currentRoundJList, 1, 1, frame);
        
        nextRoundJList = new JList();
            addTurnTrackingJListComponent(nextRoundJList, 6, 1, frame);
        
        escapedCharactersJList = new JList();
            addTurnTrackingJListComponent(escapedCharactersJList, 11, 1, frame);
    }
    
    // END: ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/

    
    
    // START: ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/

    public void addBattleLogTextAreaComponent(JTextArea textArea, int gridy, int gridwidth, 
        JFrame frame)
    {
        textArea.setFont(JListFont);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane textAreaScroll = new JScrollPane(textArea, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.20;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 1;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 100;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(18, 0, 18, 0);
        
        // add button to frame with positioning 
        frame.add(textAreaScroll, gridBagConstraints);
    }
    
    public void addBattleLogJTextArea(JFrame frame)
    {
        battleLog = new JTextArea("Battle Log:\n\n");
            addBattleLogTextAreaComponent(battleLog, 9, 6, frame);
    }
    
    // END: ADDING CURRENT AND NEW TOTAL STATS JLIST COMPONENTS
    /*******************************************************************************/


    
    
    // START: UPDATING PARTY MEMBER JLIST BY PARTY
    /*******************************************************************************/
    
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
    
    public String name(GenericCharacter character, int counter)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s %s %s: %-2s", character.getGeneralFeatures().getName(),
            desiredSpaces(13), "Member", String.valueOf(counter));
            return formatName;
    }
    
    public String health(GenericCharacter character)
    {
        // add Health Points (HP) and current/max points 
        String formatHealth = String.format("%-3s: %s", "HP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                return formatHealth;
    }
    
    public String stamina(GenericCharacter character)
    {
        // add Stamina Points (SP) and current/max points 
        String formatStamina = String.format("%-3s: %s", "SP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                return formatStamina;
    }
    
    public String nano(GenericCharacter character)
    {
        // add Nanomachine Points (NP) and current/max points
        String formatNano = String.format("%-3s: %s", "NP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentNano(), character.getTotalStats().getTotalMaxNano()));
                return formatNano;
    }
    
    public String statusEffectString(GenericCharacter character)
    {
        StringBuilder builder = new StringBuilder("Status Effects: ");
        
        int counter = 0;
        
        for(StatusEffect status : character.getStatusEffectContainer().getStatusEffects())
        {
            if(character.getStatusEffectContainer().getStatusEffects().size() == 1)
            {
                builder.append(status.getName());
            }
            else if(counter == (character.getStatusEffectContainer().getStatusEffects().size() - 1))
            {
                builder.append(status.getName());
            }
            else
            {
                builder.append(status.getName());
                    builder.append(", ");
                        counter++;
            }
        }
        
        return builder.toString();
    }
    
    public void addCharacterDetails(DefaultListModel<String> partyMemberModel, 
        GenericCharacter character, int counter)
    {
        partyMemberModel.addElement(name(character, counter));
        partyMemberModel.addElement(health(character));
        partyMemberModel.addElement(stamina(character));
        partyMemberModel.addElement(nano(character));
        partyMemberModel.addElement(statusEffectString(character));
    }
    
    public DefaultListModel<String> partyMembersModel(Party party)
    {
        DefaultListModel<String> partyMembers = new DefaultListModel<>();
       
        int counter = 1;
        
        for(GenericCharacter character : party.getPartyMembers())
        {
            if(party.getPartyMembers().size() == 1)
            {
                addCharacterDetails(partyMembers, character, counter);
            }
            else if(counter == party.getPartyMembers().size())
            {
                addCharacterDetails(partyMembers, character, counter);
            }
            else
            {
                addCharacterDetails(partyMembers, character, counter);
                partyMembers.addElement("\n\n");
            }
            
            counter++;
        }
        
        return partyMembers;
    }
    
    // END: UPDATING PARTY MEMBER JLIST BY PARTY
    /*******************************************************************************/

    
    
    
    
    
    
    // START: EXTERNAL FRAME ACTION BUTTONS 
    /*******************************************************************************/

    public JButton attackDetailButtons(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addExternalFrameButtons(JButton button, int gridy, int gridx, 
        int gridheight, int gridwidth, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, gridy, gridx, 0.11, 0.33, gridheight, gridwidth, frame);
    }
    
    public void addAttackDetailsButtons(JFrame externalFrame)
    {
        attack = attackDetailButtons("Attack");
            addExternalFrameButtons(attack, 0, 0, 1, 1, externalFrame);
        attackOverview = attackDetailButtons("Overview: (Default) (Universal)");
            addExternalFrameButtons(attackOverview, 1, 0, 1, 1, externalFrame);
        attackDescription = attackDetailButtons("Description: inflict damage upon a single target.");
            addExternalFrameButtons(attackDescription, 2, 0, 1, 1, externalFrame);
    }
    
    public void addAllAvailableCombatantsJListComponent(JList jList, int gridy, int gridx, 
        int gridheight, int gridwidth, JFrame frame)
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
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.20;
        
        // height of component in given column 
        gridBagConstraints.gridheight = gridheight;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 150;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    // FOR MODEL, NEED TO MERGE WITH BATTLE CLASS MADE LONG AGO (ASSUME PQ)
    public void addAllAvailableNonKoCombatantsJList(JFrame frame)
    {
        allAvailableNonKoCombatantsJList = new JList();
            addAllAvailableCombatantsJListComponent(allAvailableNonKoCombatantsJList, 
                0, 1, 3, 2, frame);
    }
    
    // 
    public void addAttackChoiceButton(JFrame externalFrame)
    {
        attackChoice = newUsableButton("Choice");
            addExternalFrameButtons(attackChoice, 0, 4, 1, 2, externalFrame);
    }
    
    // INITIALIZE JLIST HOLDING ALL NON KO COMBATANTS AND GETTING CHARACTER 
    
    public DefaultListModel<String> allNonKoCombatantsModel(PriorityQueue
        <GenericCharacter> allPqContents)
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(GenericCharacter element : allPqContents)
        {
            if(!element.getGeneralFeatures().knockedOut())
            {
                model.addElement(element.getGeneralFeatures().getName());
            }
        }
        
        return model;
    }
    
    public GenericCharacter findCharacterInParty(String characterName, Party party)
    {
        GenericCharacter character = null;
        
        for(GenericCharacter element : party.getPartyMembers())
        {
            if(characterName.equals(element.getGeneralFeatures().getName()))
            {
                character = element;
            }
        }
        
        return character;
    }
    
    // designed specifically for damage moves as it targets ONLY non-KO characters 
    public GenericCharacter getActiveCombatant(Object name)
    {
        GenericCharacter character = findCharacterInParty(((String)name), referencePartyOne);
        
        if(character == null)
        {
            character = findCharacterInParty(((String)name), referencePartyTwo);
        }
        
        return character;
    }
    
    // INITIALIZE JLIST HOLDING ALL NON KO COMBATANTS AND GETTING CHARACTER 
    
    
    
    
    
    public void addConfirmAttackActionListener(JButton button)
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    /* idea 
                        get selection value of allAvailableCombatantsJList and 
                        use string to go through both parties in battle until 
                        character to perform move on is found 
                            store character temporarily 
                        perform move such that character performing move is the
                        passed as user (characer at head of current round) and 
                        character retrieved via allAvailableCombatantsJList as 
                        move target 
                    */
                    
                    GenericCharacter user = getActiveCombatant(allAvailableNonKoCombatantsJList.
                        getSelectedValue());
                    
                    GenericCharacter target = getActiveCombatant(currentRoundJList.
                        getSelectedValue());
                    
                    // attack target and reload both party JList just in case 
                    MovesFactory factory = new MovesFactory();
                    
                    MoveCalculations calculation = new MoveCalculations();
                    
                    factory.getStandardAttack().singleTargetMove(user, target, 
                        factory.getStandardAttack());
                    
                    // reload party JLists 
                    partyOneBottom.setModel(partyMembersModel(referencePartyOne));
                    partyTwoTop.setModel(partyMembersModel(referencePartyTwo));
                }
            }); 
    }
    
    
    public void externalFrameByBoolean(JFrame externalFrame)
    {
        if(attackFrameActive)
        {
            // add button for name. overview, and description and JList for 
            // all active characters 
            addAttackDetailsButtons(externalFrame);
            addAllAvailableNonKoCombatantsJList(externalFrame);
            addAttackChoiceButton(externalFrame);
            
            // initialize JList
            //allAvailableNonKoCombatantsJList.setModel(allNonKoCombatantsModel(allPqContents))
        }
        else if(skillsFrameActive)
        {
            
        }
        else if(itemsFrameActive)
        {
            
        }
        
        
    }
    
    public void externalFrameLocation()
    {
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
    
    
    
    
    
    
        // INCOMPLETE 
    // FUNCTIONALITY SHOULD INCLUDE GO BACK FUNCTION 
    public void usableButtonActionListeners()
    {
        attack.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // brings up external frame with all possible characters 
                    // in battle that can be attacked via JList and attack
                    // via JList popup menu with "target" command then show
                    // text of move being used in center JTextArea and results
                    
                    // set other external frame variant to false 
                    skillsFrameActive = false;
                    itemsFrameActive = false;
                    
                    // prevents creation of infinite exteral frames by disposing 
                    // of external frame if it is active before creating new one
                    // and reset appropriate boolean indicators 
                    externalFrame.dispose();
                    
                    // indicate frame style that should be active
                    attackFrameActive = true;
                    
                    // set up new external frame according to view/equip boolean 
                    externalFrameLocation();
                }
            }); 

        skills.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // brings up external frame with all moves available to 
                    // character, and upon move selection show targets for 
                    // move and data about move stuff (output, ect.) and show
                    // result in JTextArea 
                }
            }); 

        items.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // brings up external frame with items usable in battle
                    // with brief info on what item does and item selection 
                    // via popup command "use" brings up items targets in 
                    // battle and allows character to use item 
                }
            }); 
    }
    
    
    
    
    
    
    
    
    
    
    
    public void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JFrame frame = new JFrame();
    
    /* 
        // use party entity to store references to player entity and inventory
        PlayerEntityFactory entity = new PlayerEntityFactory();
            referencePlayerEntity = entity.getPlayerEntityExample();
                referenceInventory = entity.getPlayerEntityExample().getInventory();
    */
    
    public BattleMenu()
    {
        frame.setLayout(new GridBagLayout());
        
        PlayerEntityFactory entityOne = new PlayerEntityFactory();
            referencePartyOne = entityOne.getPlayerEntityExample().getParty();
        
        PlayerEntityFactory entityTwo = new PlayerEntityFactory();
            referencePartyTwo = entityTwo.getPlayerEntityExample().getParty();
        
        // set up frame 
        topLayoutButtons(frame);
        
        bottomLayoutButtons(frame);
        
        addUsableButtons(frame);
        
        addUnusableTurnTrackingJListTitles(frame);
        
        addPartyMemberJLists(frame);
        
        addTurnTrackingJLists(frame);
        
        addBattleLogJTextArea(frame);
        
        addJListJTextAreaButtonTitles(frame);
        
        
        // action stuff with external frames 
        usableButtonActionListeners();
        
        
        
        
        displayFrameWindow();
    }
    
    
    
    
    
    
    
    
    
}
