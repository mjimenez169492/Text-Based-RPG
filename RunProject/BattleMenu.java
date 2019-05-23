package RunProject;

/*
        Battle concerns creating objects/methods relating to the concept of battle 
        commonly found in various RPGs (Role Playing Games). Battles occur between
        AT MOST two parties consisting of characters which may be under AI control
        (low level AI script based on certain conditions) or under player control. 
        A battle between two parties has a success state and a fail state with the
        criteria for meeting each varying based on the type of battle initiated.
    */

    import Generic_Character.*;
    import java.security.SecureRandom;
    import java.util.PriorityQueue;	
    import Player_Entity.Party;
    import java.util.ArrayList;

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
    private static Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private static Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    private static int buttonVerticalPadding = 0;
    
    private static int jListVerticalPadding = 0;
    
    private static JList currentRoundJList, nextRoundJList, escapedCharactersJList;
    
    private static JButton attack, skills, items;
    
    private static JList partyOneBottom;
    private static JList partyTwoTop;
    
    private static JTextArea battleLog;
    
    private static Party referencePartyOne;
    private static Party referencePartyTwo;
    
    
    
    
    
    private static JFrame externalFrame = new JFrame();
    
    private static boolean attackFrameActive;
    private static boolean skillsFrameActive;
    private static boolean itemsFrameActive;
    
    
    
    
    private static JButton attackName; 
    private static JButton attackOverview;
    private static JButton attackDescription;
    
    private static JList allAvailableNonKoCombatantsJList;
    
    private static JButton attackChoice;
    
    // signify in Battle inner class whether turn has been complete 
    private static boolean turnComplete = false;
    
    
    
    /*
    private JButton overview, description;
    
    private JList controlledMove, uncontrolledMove;
    
    private JList controlledItemMove, uncontrolledItemMove;
    
    private JList controlledMoveTargets, uncontrolledMoveTargets;
    
    private JButton useControlledMove, useUncontrolledMove;
    */
    
    
    
    // START: ADDING BUTTON COMPONENTS TO FRAME
    /*******************************************************************************/

    public static void addButtonComponent(JButton button, int gridy, int gridx, double
        weighty, double weightx, int gridheight, int gridwidth, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up in frame height
        gridBagConstraints.weighty = weighty;
        
        // specified row length component takes up in frame width
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

    
    
    // START: UNUSABLE BUTTONS USED TO PARSE OUT CURRENT LAYOUT 
    /*******************************************************************************/

    public static JButton buttonUsedForLayout()
    {
        JButton button = new JButton(" ");
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public static void topLayoutButtons(JFrame frame)
    {
        for(int i = 0; i < 6; i++)
        {
            addButtonComponent(buttonUsedForLayout(), 0, i, 0.11, 0.33, 1, 1, frame);
        }
    }
    
    public static void bottomLayoutButtons(JFrame frame)
    {
        for(int i = 3; i < 7; i++)
        {
            addButtonComponent(buttonUsedForLayout(), 15, i, 0.11, 0.33, 1, 1, frame);
        }
    }
    
    // END: UNUSABLE BUTTONS USED TO PARSE OUT CURRENT LAYOUT 
    /*******************************************************************************/

    
    // START: ADD USABLE BUTTONS TO BOTTOM LEFT OF FRAME LAYOUT 
    /*******************************************************************************/
    
    public static JButton newUsableButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public static void usableButtonPlacement(JButton button, int gridy, int gridx, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, gridy, gridx, 0.11, 0.33, 1, 1, frame);
    }
    
    public static void addUsableButtons(JFrame frame)
    {
        attack = newUsableButton("Attack");
            usableButtonPlacement(attack, 15, 0, frame);
        
        skills = newUsableButton("Skills");
            usableButtonPlacement(skills, 15, 1, frame);
        
        items = newUsableButton("Items");
            usableButtonPlacement(items, 15, 2, frame);
    }
    
    public static void enableUsableButtons()
    {
        attack.setEnabled(true);
        skills.setEnabled(true);
        items.setEnabled(true);
    }
    
    public static void disableUsableButtons()
    {
        attack.setEnabled(false);
        skills.setEnabled(false);
        items.setEnabled(false);
    }
    
    // END: ADD USABLE BUTTONS TO BOTTOM LEFT OF FRAME LAYOUT 
    /*******************************************************************************/

    

    // START: PARTY ONE AND PARTY TWO JLISTS 
    /*******************************************************************************/

    public static void addPartyMemberJListComponent(JList jList, int gridy, int gridx, 
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
        
        // specified column length component takes up of frame height
        gridBagConstraints.weighty = 0.60;
        
        // specified row length component takes up of frame width
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
    
    public static void addPartyMemberJLists(JFrame frame)
    {
        partyOneBottom = new JList(partyMembersModel(referencePartyOne));
            addPartyMemberJListComponent(partyOneBottom, 11, 0, 4, 6, frame);
        
        partyTwoTop = new JList(partyMembersModel(referencePartyTwo));
            addPartyMemberJListComponent(partyTwoTop, 1, 0, 4, 6, frame);
    }
    
    // END: PARTY ONE AND PARTY TWO JLISTS 
    /*******************************************************************************/

    
    // START: UNUSABLE TITLE BUTTONS FOR TURN TRACKING JLISTS 
    /*******************************************************************************/

    public static JButton newUnusableTitleButton(String text)
    {
        JButton button = new JButton(text);
        
        // gun metal blue color in hexadecimal 
        button.setBackground(Color.decode("#4d5461"));
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public static void addUnusableTitleButton(String buttonName, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        addButtonComponent(newUnusableTitleButton(buttonName), gridy, gridx, 0.11, 0.25, 
            2, gridwidth, frame);
    }
    
    public static void addUnusableTurnTrackingJListTitles(JFrame frame)
    {
        String currentRoundTitle = String.format("%26s", "Current Round Turn Order");
            addUnusableTitleButton(currentRoundTitle, 0, 6, 1, frame);
        
        String nextRoundTitle = String.format("%26s", "Next Round Turn Order");
            addUnusableTitleButton(nextRoundTitle, 5, 6, 1, frame);
        
        String escapedCharactersTitle = String.format("%26s", "Escaped Characters");
            addUnusableTitleButton(escapedCharactersTitle, 10, 6, 1, frame);
    }
    
    // END: UNUSABLE TITLE BUTTONS FOR TURN TRACKING JLISTS 
    /*******************************************************************************/

    
    
    // START: JLIST JTEXTAREA BUTTON TITLES 
    /*******************************************************************************/

    public static void addJListJTextAreaButtonTitles(JFrame frame)
    {
        String opposingPartyFormatted = String.format("%s", "Enemies");
            addUnusableTitleButton(opposingPartyFormatted, 5, 0, 1, frame);
        
        String playerPartyFormatted = String.format("%s", "Allies");
            addUnusableTitleButton(playerPartyFormatted, 10, 0, 1, frame);
    }
    
    // END: JLIST JTEXTAREA BUTTON TITLES 
    /*******************************************************************************/



    // START: ADDING JLISTS MEANT FOR TRACKING TURN BEHAVIOR 
    /*******************************************************************************/

    public static void addTurnTrackingJListComponent(JList jList, int gridy, int gridwidth, 
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
        
        // specified column length component takes up in frame height
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up in frame width
        gridBagConstraints.weightx = 0.20;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 4;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 150;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public static void addTurnTrackingJLists(JFrame frame)
    {
        currentRoundJList = new JList();
            addTurnTrackingJListComponent(currentRoundJList, 1, 1, frame);
        
        nextRoundJList = new JList();
            addTurnTrackingJListComponent(nextRoundJList, 6, 1, frame);
        
        escapedCharactersJList = new JList();
            addTurnTrackingJListComponent(escapedCharactersJList, 11, 1, frame);
    }
    
    // END: ADDING JLISTS MEANT FOR TRACKING TURN BEHAVIOR 
    /*******************************************************************************/

    
    
    // START: ADDING JTEXTAREA AS BATTLE LOG FOR ALL BATTLE ACTIONS 
    /*******************************************************************************/

    public static void addBattleLogTextAreaComponent(JTextArea textArea, int gridy, int gridwidth, 
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
        
        // specified column length component takes up in frame height
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up in frame width
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
    
    public static void addBattleLogJTextArea(JFrame frame)
    {
        battleLog = new JTextArea("Battle Log:\n\n");
            addBattleLogTextAreaComponent(battleLog, 9, 6, frame);
    }
    
    // END: ADDING JTEXTAREA AS BATTLE LOG FOR ALL BATTLE ACTIONS 
    /*******************************************************************************/


    
    
    // START: UPDATING PARTY MEMBER JLIST BY PARTY
    /*******************************************************************************/
    
    public static String desiredSpaces(int spaces)
    {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < spaces; i++)
        {
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
    public static String formatCurrentMaxValues(double currentValue, double maximumValue)
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
    
    public static String name(GenericCharacter character, int counter)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s %s %s: %-2s", character.getGeneralFeatures().getName(),
            desiredSpaces(13), "Member", String.valueOf(counter));
            return formatName;
    }
    
    public static String health(GenericCharacter character)
    {
        // add Health Points (HP) and current/max points 
        String formatHealth = String.format("%-3s: %s", "HP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                return formatHealth;
    }
    
    public static String stamina(GenericCharacter character)
    {
        // add Stamina Points (SP) and current/max points 
        String formatStamina = String.format("%-3s: %s", "SP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                return formatStamina;
    }
    
    public static String nano(GenericCharacter character)
    {
        // add Nanomachine Points (NP) and current/max points
        String formatNano = String.format("%-3s: %s", "NP", formatCurrentMaxValues(character.
            getGeneralFeatures().getCurrentNano(), character.getTotalStats().getTotalMaxNano()));
                return formatNano;
    }
    
    public static String statusEffectString(GenericCharacter character)
    {
        StringBuilder builder = new StringBuilder("Status Effects: ");
        
        int counter = 0;
        
        for(StatusEffect status : character.getStatusEffectContainer().getStatusEffects())
        {
            // account for when one status effect exists (no , after it)
            if(character.getStatusEffectContainer().getStatusEffects().size() == 1)
            {
                builder.append(status.getName());
            }
            // account for last status effect (no , after it)
            else if(counter == (character.getStatusEffectContainer().getStatusEffects().size() - 1))
            {
                builder.append(status.getName());
            }
            // account for next status effect (, after it)
            else
            {
                builder.append(status.getName());
                    builder.append(", ");
                        counter++;
            }
        }
        
        return builder.toString();
    }
    
    // Note: new line is called AFTER element is added to model 
    public static void addPartyMemberDetails(DefaultListModel<String> partyMemberModel, 
        GenericCharacter character, int counter)
    {
        // counter is used to identify number of party members in battle
        partyMemberModel.addElement(name(character, counter));
        partyMemberModel.addElement(health(character));
        partyMemberModel.addElement(stamina(character));
        partyMemberModel.addElement(nano(character));
        partyMemberModel.addElement(statusEffectString(character));
    }
    
    public static DefaultListModel<String> partyMembersModel(Party party)
    {
        DefaultListModel<String> partyMembers = new DefaultListModel<>();
       
        int counter = 1;
        
        for(GenericCharacter character : party.getPartyMembers())
        {
            if(party.getPartyMembers().size() == 1)
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else if(counter == party.getPartyMembers().size())
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else
            {
                addPartyMemberDetails(partyMembers, character, counter);
                partyMembers.addElement("\n\n");
            }
            
            counter++;
        }
        
        return partyMembers;
    }
    
    // END: UPDATING PARTY MEMBER JLIST BY PARTY
    /*******************************************************************************/

    
    
    // START: UPDATING TRUN TRACKING JLISTS
    /*******************************************************************************/

    public static DefaultListModel<String> turnTrackingJListModel(PriorityQueue
        <GenericCharacter> priorityQueue)
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(GenericCharacter element : priorityQueue)
        {
            model.addElement(element.getGeneralFeatures().getName());
        }
        
        return model;
    }
    
    public static DefaultListModel<String> escapedCharacterJListModel(ArrayList
        <GenericCharacter> escapedCharacters)
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(GenericCharacter element : escapedCharacters)
        {
            model.addElement(element.getGeneralFeatures().getName());
        }
        
        return model;
    }
    
    // END: UPDATING TRUN TRACKING JLISTS
    /*******************************************************************************/

    
    
    
    
    
    
    
    // START: EXTERNAL FRAME STUF BELOW!!!!
    /*******************************************************************************/

    
    
    // START: EXTERNAL FRAME ATTACK ACTION
    /*******************************************************************************/

    // ATTACK FRAME COMPONENTS 
    
    public static JButton attackDetailButtons(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public static void addExternalFrameButtons(JButton button, int gridy, int gridx, 
        int gridheight, int gridwidth, JFrame frame)
    {
        // Note: if component width is 0, component occupies whole row 
        addButtonComponent(button, gridy, gridx, 0.11, 0.33, gridheight, gridwidth, frame);
    }
    
    public static void addAttackDetailsButtons(JFrame externalFrame)
    {
        attackName = attackDetailButtons("Attack");
            addExternalFrameButtons(attackName, 0, 0, 1, 1, externalFrame);
        
        attackOverview = attackDetailButtons("Overview: (Default) (Universal)");
            addExternalFrameButtons(attackOverview, 1, 0, 1, 1, externalFrame);
        
        attackDescription = attackDetailButtons("Description: inflict damage upon a single target.");
            addExternalFrameButtons(attackDescription, 2, 0, 1, 1, externalFrame);
    }
    
    public static void addAllAvailableCombatantsJListComponent(JList jList, int gridy, int gridx, 
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
    public static void addAllAvailableNonKoCombatantsJList(JFrame frame)
    {
        allAvailableNonKoCombatantsJList = new JList();
            addAllAvailableCombatantsJListComponent(allAvailableNonKoCombatantsJList, 
                0, 1, 3, 2, frame);
    }
    
    public static void addAttackChoiceButton(JFrame externalFrame)
    {
        attackChoice = newUsableButton("Choice");
            addExternalFrameButtons(attackChoice, 0, 4, 1, 2, externalFrame);
    }
    
    // ATTACK FRAME COMPONENTS 
    
    
    
    // GETTING CHARACTER DISPLAYED IN JLIST 
    
    
    
    public static GenericCharacter findCharacterInParty(String characterName, Party party)
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
    
    // Note: gets character REGARDLESS of whether character is KO ior has escaped 
    // make boolean for finding KO and non-KO combatants 
    public static GenericCharacter getCharacter(Object name)
    {
        GenericCharacter character = findCharacterInParty(((String)name), referencePartyOne);
        
        if(character == null)
        {
            character = findCharacterInParty(((String)name), referencePartyTwo);
        }
        
        return character;
    }
    
    // GETTING CHARACTER DISPLAYED IN JLIST 
    
    
    
    // SETTING ATTACK FRAME JLIST MODEL USING ALL NON KO COMBATANTS
    
    // MERGE WITH BATTLE CLASS 
    public static DefaultListModel<String> allNonKoCombatantsModel(PriorityQueue
        <GenericCharacter> allPqContents)
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(GenericCharacter element : allPqContents)
        {
            if(!element.getGeneralFeatures().knockedOut())
            {
                String name = String.format("%-26s", element.getGeneralFeatures().
                    getName());
                
                model.addElement(name);
            }
        }
        
        return model;
    }
    
    // SETTING ATTACK FRAME JLIST MODEL USING ALL NON KO COMBATANTS
    
    
    
    // ACTION LISTENERSAND EXTERNAL FRAME COMPONENT SET UP 
    
    public static void addConfirmAttackActionListener(JButton button)
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
                    
                    // set to head of current round 
                    currentRoundJList.setSelectedIndex(0);
                    
                    GenericCharacter user = getCharacter(currentRoundJList.
                        getSelectedValue());
                    
                    GenericCharacter target = getCharacter(allAvailableNonKoCombatantsJList.
                        getSelectedValue());
                    
                    // attack target and reload both party JList just in case 
                    MovesFactory factory = new MovesFactory();
                    
                    MoveCalculations calculation = new MoveCalculations();
                    
// Note: error due to referencing same character object 
                    
                    calculation.singleTargetMoveLogic(user, target, factory.getStandardAttack());
                    
                    // reload party JLists to display results of action 
                    partyOneBottom.setModel(partyMembersModel(referencePartyOne));
                    partyTwoTop.setModel(partyMembersModel(referencePartyTwo));
   
                    // turn complete upon selecting attack
                    turnComplete = true;
                }
            }); 
    }
    
    
    public static void externalFrameByBoolean(JFrame externalFrame)
    {
        if(attackFrameActive)
        {
            // add button for name. overview, and description and JList for 
            // all active characters 
            addAttackDetailsButtons(externalFrame);
            addAllAvailableNonKoCombatantsJList(externalFrame);
            addAttackChoiceButton(externalFrame);
            addConfirmAttackActionListener(attackChoice);
            
            // initialize JList
            allAvailableNonKoCombatantsJList.setModel(allNonKoCombatantsModel(
                Battle.allPqContents)); 
            
            // turn complete once "choice" is pressed
        }
        else if(skillsFrameActive)
        {
            
        }
        else if(itemsFrameActive)
        {
            
        }
        
        
    }
    
    public static void externalFrameLocation()
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
    public static void usableButtonActionListeners()
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
    
    // ACTION LISTENERSAND EXTERNAL FRAME COMPONENT SET UP 
    
    // END: EXTERNAL FRAME STUF BELOW!!!!
    /*******************************************************************************/

    
    
    
    
    
    
    
    
    
    
    
    
    
    // START: BATTLE NESTED CLASS
    /**/

    // By default (without static), instances of B contain a hidden reference to 
    // an instance of A (may need a different instance of Enum object per scope)
    static class Battle
    {
        // keeps track of the number of rounds that have passed in battle 
        private double round;

        // denotes whether battle is winnable or not from the start
        private boolean unwinnableBattle;

        // variables denoting conditions for party win/loss/escape/ending battle early 
        private boolean playerGameOver, endBattleEarlyTrigger, partiesTied, partyTwoEscape, 
            partyOneEscape, playerPartyEscape, partyTwoLoss, partyOneLoss, 
            playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin;

        // boolean array holds booleans that can end the battle if one of them is true 
        // Note: "final" array references cannot be changed but elements can be modified 
        private final boolean[] endBattleConditions = {playerGameOver, endBattleEarlyTrigger, 
            partiesTied, partyTwoEscape, partyOneEscape, playerPartyEscape, partyTwoLoss, 
            partyOneLoss, playerPartyLoss, partyTwoWin, partyOneWin, playerPartyWin};

        // holds chaarcters that have fled from battle (no post battle reward)
        private final ArrayList<GenericCharacter> escapedCharacters = new ArrayList<>();

        // holds characters defeated in battle (post battle reward if battle is won )
        private final ArrayList<GenericCharacter> defeatedCharacters = new ArrayList<>();

        /* Note: priority queues contain comparator that sorts characters such 
                 that characters with the highest battle dexterity comes first */

        // priority queue representing the current round of a battle which consists 
        // of characters belonging to the party objects supplied to battle method
        private static final PriorityQueue<GenericCharacter> currentRound = new PriorityQueue<>( 
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));

        // priority queue representing the next round of a battle which is filled 
        // with characters from priority queue currentRound as battle progresses 
        private static final PriorityQueue<GenericCharacter> nextRound = new PriorityQueue<>( 
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));

        // priority queue allPqContents is meant to contain all characters stored 
        // in priority queues currentRound and nextRound as battle progresses 
        private static final PriorityQueue<GenericCharacter> allPqContents = new PriorityQueue<>(
            (a, b) -> (b.getGeneralFeatures().getBattleDexterity()) - (a.getGeneralFeatures().
            getBattleDexterity()));		

        public Battle()
        {
            // empty constructor
        }



        // START: COUNTING ROUNDS IN BATTLE 
        /*******************************************************************************/

        public void setRoundCount(double round)
        {
            if(round < 1)
            {
                round = 1;
            }
            else if(round > 128)
            {
                round = 128;
            }

            this.round = round;
        }

        public void incrementRoundCount()
        {
            setRoundCount(getRoundCount() + 1);
        }

        public double getRoundCount()
        {
            return round;
        }

        // END: END BATTLE CONDITIONS
        /*******************************************************************************/



        // START: UNWINNABLE BATTLE BOOLEANS 
        /*******************************************************************************/

        public void unwinnableBattle(boolean unwinnableBattle)
        {
            this.unwinnableBattle = unwinnableBattle;
        }

        public boolean unwinnableBattle()
        {
            return unwinnableBattle;
        }

        // START: UNWINNABLE BATTLE BOOLEANS 
        /*******************************************************************************/



        // START: END BATTLE CONDITIONS 
        /*******************************************************************************/

        public void playerPartyGameOver(boolean playerGameOver)
        {
            this.playerGameOver = playerGameOver;
        }

        public boolean playerPartyGameOver()
        {
            return playerGameOver;
        }

        public void endBattleEarlyTrigger(boolean endBattleEarlyTrigger)
        {
            this.endBattleEarlyTrigger = endBattleEarlyTrigger;
        }

        public boolean endBattleEarlyTrigger()
        {
            return endBattleEarlyTrigger;
        }

        public void partiesTied(boolean partiesTied)
        {
            this.partiesTied = partiesTied;
        }

        public boolean partiesTied()
        {
            return partiesTied;
        }

        public void partyTwoEscape(boolean partyTwoEscape)
        {
            this.partyTwoEscape = partyTwoEscape;
        }

        public boolean partyTwoEscape()
        {
            return partyTwoEscape;
        }

        public void partyOneEscape(boolean partyOneEscape)
        {
            this.partyOneEscape = partyOneEscape;
        }

        public boolean partyOneEscape()
        {
            return partyOneEscape;
        }

        public void playerPartyEscape(boolean playerPartyEscape)
        {
            this.playerPartyEscape = playerPartyEscape;
        }

        public boolean playerPartyEscape()
        {
            return playerPartyEscape;
        }

        public void partyTwoLoss(boolean partyTwoLoss)
        {
            this.partyTwoLoss = partyTwoLoss;
        }

        public boolean partyTwoLoss()
        {
            return partyTwoLoss;
        }

        public void partyOneLoss(boolean partyOneLoss)
        {
            this.partyOneLoss = partyOneLoss;
        }

        public boolean partyOneLoss()
        {
            return partyOneLoss;
        }

        public void playerPartyLoss(boolean playerPartyLoss)
        {
            this.playerPartyLoss = playerPartyLoss;
        }

        public boolean playerPartyLoss()
        {
            return playerPartyLoss;
        }

        public void partyTwoWin(boolean partyTwoWin)
        {
            this.partyTwoWin = partyTwoWin;
        }

        public boolean partyTwoWin()
        {
            return partyTwoWin;
        }

        public void partyOneWin(boolean partyOneWin)
        {
            this.partyOneWin = partyOneWin;
        }

        public boolean partyOneWin()
        {
            return partyOneWin;
        }

        public void playerPartyWin(boolean playerPartyWin)
        {
            this.playerPartyWin = playerPartyWin;
        }

        public boolean playerPartyWin()
        {
            return playerPartyWin;
        }

        // END: END BATTLE CONDITIONS 
        /*******************************************************************************/



        // START: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
        /*******************************************************************************/

        public boolean playerPartyExists(Party partyOne, Party partyTwo)
        {
            // if one party is the player party then return true 
            boolean result = (partyOne.playerParty() || partyTwo.playerParty());
                return result;
        }

        public Party getPlayerParty(Party partyOne, Party partyTwo)
        {
            Party result = null;

            if(partyOne.playerParty())
            {
                result = partyOne;
            }
            else if(partyTwo.playerParty())
            {
                result = partyTwo;
            }

            return result;
        }

        public Party getPartyOpposingPlayer(Party partyOne, Party partyTwo)
        {
            Party result = null;

            if(!partyOne.playerParty())
            {
                result = partyOne;
            }
            else if(!partyTwo.playerParty())
            {
                result = partyTwo;
            }

            return result;
        }

        // END: DETERMINING EXISTENCE OF PLAYER PARTY AND GETTING PARTY OBJECTS 
        /*******************************************************************************/



        // START: BATTLE LOGIC
        /*******************************************************************************/

        // returns whether party is suitable for battle 
        public boolean validParty(Party party)
        {
            boolean result = false;

            if(party != null && !party.getPartyMembers().isEmpty())
            {
                result = true;
            }

            return result;
        }

        public void setUpBattleGUI(JFrame frame, Party partyOne, Party partyTwo)
        {
            frame.setLayout(new GridBagLayout());
        
            // party references used to easily access party 
            referencePartyOne = partyOne;
            referencePartyTwo = partyTwo;
   
            // set up frame for battle GUI
            topLayoutButtons(frame);

            bottomLayoutButtons(frame);

            addUsableButtons(frame);

            addUnusableTurnTrackingJListTitles(frame);

            addPartyMemberJLists(frame);

            // set up party JLists to show parties and their members in battle 
            partyOneBottom.setModel(partyMembersModel(referencePartyOne));
            partyTwoTop.setModel(partyMembersModel(referencePartyTwo));
            
            addTurnTrackingJLists(frame);

            currentRoundJList.setModel(turnTrackingJListModel(currentRound));
            
            addBattleLogJTextArea(frame);

            addJListJTextAreaButtonTitles(frame);

            // action stuff with external frames 
            usableButtonActionListeners();

            displayFrameWindow();
        }
        
        // allows characters from two different parties to battle one another 
        // Note: Battle object is passed to get access to boolean conditions
        public void standardBattle(Battle battle, Party partyOne, Party partyTwo,
            JFrame frame)
        {
            // proceed only if both parties supplied are considered valid 
            if(validParty(partyOne) && validParty(partyTwo))
            {
                // reset end battle triggers, instance variables, and set up current round 
                preBattleSetUp(currentRound, partyOne, partyTwo);

                // set up battle gui
                setUpBattleGUI(frame, partyOne, partyTwo);
                
                
                
                
                
                
                
                
                
                
                // loop until an end battle loop condition is met 
                while(!endBattleLoop())
                {
                    // commence battle between two parties filled with characters 
                    standardBattleLogic(allPqContents, currentRound, nextRound, getRoundCount(), 
                        partyOne, partyTwo);
                } 

                System.out.println("Game Win :)");
                
                // after battle, perform appropriate action based on boolean priority 
                // and whether a party under player control is involved in the battle 
                    // battleResults(battle, partyOne, partyTwo);
            }
        }

        public void standardBattleLogic(PriorityQueue<GenericCharacter> allPqContents, PriorityQueue
            <GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound, double 
            roundCount, Party partyOne, Party partyTwo)
        {
            // proceed if currentRound is not empty else refill currentRound
            if(!currentRound.isEmpty())
            {
                // fill allPqContents with characters that have not escaped battle 
                clearAndFillAllPqContents(allPqContents, currentRound, nextRound);
                
                // execute turn logic for character at head of currentRound 
                characterTurnLogic(allPqContents, currentRound, nextRound, 
                    roundCount, partyOne, partyTwo);
            } 
            else 
            {
                fillCurrentRoundAndClearNextRound(currentRound, nextRound);
            }

            // fill allPqContents with characters that have not escaped battle 
            clearAndFillAllPqContents(allPqContents, currentRound, nextRound);

            // check end battle loop variables to see if a condition was met 
            checkEndBattleLoopVariables(allPqContents, partyOne, partyTwo);

            // increment round count by one 
            incrementRoundCount();
        }

        // END: BATTLE LOGIC
        /*******************************************************************************/



        // START: RESETTING BATTLE LOOP CONDITIONS AND END BATTLE LOOP 
        /*******************************************************************************/

        public void resetBattleLoopConditions()
        {
            unwinnableBattle = false;

            for(boolean element: endBattleConditions)
            {
                element = false;
            }
        }

        public boolean endBattleLoop()
        {
            boolean result = false;

            for(boolean element : endBattleConditions)
            {
                if(element)
                {
                    result = true;
                        break;
                }
            }

            return result;
        }

        // END: RESETTING BATTLE LOOP CONDITIONS AND END BATTLE LOOP 
        /*******************************************************************************/



        // START: PRE-BATTLE SET UP 
        /*******************************************************************************/

        public void resetAllInstanceVariables()
        {
            // reset booleans representing end battle conditions 
            resetBattleLoopConditions();

            // reset priority queues 
            currentRound.clear();
            nextRound.clear();

            // reset ArrayLists 
            escapedCharacters.clear();
            defeatedCharacters.clear();
        }

        public void preparePartiesForBattle(Party partyOne, Party partyTwo)
        {
            partyOne.resetEndBattle();
            partyOne.setBattleDexterity();

            partyTwo.resetEndBattle();
            partyTwo.setBattleDexterity();
        }

        public void putCharactersInCurrentRound(PriorityQueue<GenericCharacter> currentRound, 
            Party partyOne, Party partyTwo)
        {
            for(GenericCharacter element : partyOne.getPartyMembers())
            {
                currentRound.add(element);
            }

            for(GenericCharacter element : partyTwo.getPartyMembers())
            {
                currentRound.add(element);
            }
        }

        public void preBattleSetUp(PriorityQueue<GenericCharacter> currentRound, 
            Party partyOne, Party partyTwo)
        {
            setRoundCount(1);

            resetAllInstanceVariables();

            preparePartiesForBattle(partyOne, partyTwo);

            putCharactersInCurrentRound(currentRound, partyOne, partyTwo);
        }

        // END: SETTING UP BATTLE FOR ROUND ONE AND BEYOND 
        /*******************************************************************************/



        // START: APPLYING START/END OF TURN EFFECTS BY CHARACTER
        /*******************************************************************************/

        public void resetDamagedIfDamaged(GenericCharacter character)
        {
            if(character.getGeneralFeatures().damaged())
            {
                character.getGeneralFeatures().damaged(false);
            }
        }

        public void startOfTurnEffects(GenericCharacter character)
        {
            if(character != null && !character.getGeneralFeatures().knockedOut())
            {
                resetDamagedIfDamaged(character);
                character.getStatusEffectContainer().decrementStartOfTurnStatusEffectTurns();
                character.getStatusEffectContainer().removeStatusEffectIfZeroTurns();
            }
        }

        public void effectOfStatusEffectsOnCurrentGauges(GenericCharacter character)
        {
            character.getGeneralFeatures().setCurrentHealth(character.getGeneralFeatures().
                getCurrentHealth() + (character.getGeneralFeatures().getCurrentHealth() * 
                character.getStatusEffectContainer().sumOfEffects("Current Health")));

            character.getGeneralFeatures().setCurrentStamina(character.getGeneralFeatures().
                getCurrentStamina() + (character.getGeneralFeatures().getCurrentStamina() * 
                character.getStatusEffectContainer().sumOfEffects("Current Stamina")));

            character.getGeneralFeatures().setCurrentNano(character.getGeneralFeatures().
                getCurrentNano() + (character.getGeneralFeatures().getCurrentNano() * 
                character.getStatusEffectContainer().sumOfEffects("Current Nano")));
    }

        public void endOfTurnEffects(GenericCharacter character)
        {
            if(character != null && !character.getGeneralFeatures().knockedOut())
            {
                effectOfStatusEffectsOnCurrentGauges(character);
                character.getStatusEffectContainer().decrementEndOfTurnStatusEffectTurns();
                character.getStatusEffectContainer().removeStatusEffectIfZeroTurns();
                character.getEquippableOutfits().applyCorePenaltyToEquippedOutfits();
            }	
        }

        // END: APPLYING START/END OF TURN EFFECTS BY CHARACTER 
        /*******************************************************************************/



        // START: MANAGING CURRENT/NEXT ROUND PRIORITY QUEUES AND ALLPQCONTENTS
        /*******************************************************************************/

        public void storeSecondPqContentsInFirstPq(PriorityQueue<GenericCharacter> firstPq, 
            PriorityQueue<GenericCharacter> secondPq)
        {
            for(GenericCharacter element : secondPq)
            {
                firstPq.add(element);
            }
        }

        public void fillCurrentRoundAndClearNextRound(PriorityQueue<GenericCharacter> currentRound, 
            PriorityQueue<GenericCharacter> nextRound)
        {
            storeSecondPqContentsInFirstPq(currentRound, nextRound);
            nextRound.clear();
        }

        public void clearAndFillAllPqContents(PriorityQueue<GenericCharacter> allPqContents, 
            PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> nextRound)
        {
            allPqContents.clear();
            storeSecondPqContentsInFirstPq(allPqContents, currentRound);
            storeSecondPqContentsInFirstPq(allPqContents, nextRound);
        }

        // END: MANAGING CURRENT/NEXT ROUND PRIORITY QUEUES AND ALLPQCONTENTS
        /*******************************************************************************/



        // START: CHARACTER TURN LOGIC 
        /*******************************************************************************/

        public void characterTurnLogic(PriorityQueue<GenericCharacter> allPqContents, 
            PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
            nextRound, double roundCount, Party partyOne, Party partyTwo)
        {
            // determine which party character belongs to before character makes move 
            if(partyOne.getPartyMembers().contains(currentRound.peek()))
            {
                // execute turn logic for character by passing character by reference 
                // Note: first party object supplied is considered as character's party
                executeTurnOrStoreForNextRound(allPqContents, currentRound, nextRound, 
                    getRoundCount(), partyOne, partyTwo);
            }
            else
            {
                // execute turn logic for character by passing character by reference 
                // Note: first party object supplied is considered as character's party
                executeTurnOrStoreForNextRound(allPqContents, currentRound, nextRound, 
                    getRoundCount(), partyTwo, partyOne);
            }
        }

        // END: CHARACTER TURN LOGIC 
        /*******************************************************************************/



        // START: SELECTING CHARACTER THAT WILL MAKE MOVE 
        /*******************************************************************************/

        public void executeTurnOrStoreForNextRound(PriorityQueue<GenericCharacter> allPqContents, 
            PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
            nextRound, double roundCount, Party characterParty, Party opposingParty)
        {
            if(!currentRound.peek().getGeneralFeatures().knockedOut())
            {
                startOfTurnEffects(currentRound.peek()); 

                executeCharacterTurn(allPqContents, currentRound, nextRound, roundCount, 
                    characterParty, opposingParty);
            }
            else
            {
                currentRound.peek().getStatusEffectContainer().removeStatusEffectsAfterKnockOut();
                currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
                nextRound.add(currentRound.poll());
            }
        }

            // INCOMPLETE********
        // manage character behavior when it is time to make a turn based on character state 
        public void executeCharacterTurn(PriorityQueue<GenericCharacter> allPqContents, 
            PriorityQueue<GenericCharacter> currentRound, PriorityQueue<GenericCharacter> 
            nextRound, double roundCount, Party characterParty, Party opposingParty) 
        {
            if(currentRound.peek().getStatusEffectContainer().behaviorStatusExists())
            {
                // have code for behavior that takes control away from player/AI script 
                    // CONFUSED("Confused"), ENAMORED("Enamored"), BERSERK("Berserk");
                        // consider switch case or something... 
            }
            else if(currentRound.peek().getStatusEffectContainer().turnBehaviorStatusExists())
            {
                // code checks object's status effects for skip turn status effects 
                    // do nothing since turn is skipped 
            }
            else if(!currentRound.peek().getGeneralFeatures().playerControl())
            {
                // if character is not under player control then execute AI script 
                    // currentRound.peek().getAiScript().executeAiPattern() 
                
                BattleMenu.disableUsableButtons();
            }
            else // object is under player control
            {
                // set battle dexterity for character using character AND move speed 
                // character.setBattleDexterity(currentRound.peek().getCommandList(allPqContents, 
                //      roundCount, characterParty, opposingParty, currentRound.peek()));
                
                /* idea 
                    at this time, character is known to be under player control 
                        therefore, buttons to perform move should be ENABLED
                */
                
                BattleMenu.enableUsableButtons();
                
                
            }

            // setBattleDexterity as last opion BEFORE executing post move behavior 
        }

        // END: SELECTING CHARACTER THAT WILL MAKE MOVE 
        /*******************************************************************************/



        // START: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR  
        /*******************************************************************************/

        public boolean escapePossible(double originalPreventFlee, double reducedPreventFlee)
        {
            SecureRandom rand = new SecureRandom();

            boolean result = false;

            if((rand.nextInt((int)originalPreventFlee) + 1) > (rand.nextInt((int)reducedPreventFlee) + 1))
            {
                result = true;
            }

            return result;
        }

        public boolean escapeOutcome(GenericCharacter character, Party opposingParty)
        {
            boolean result = false;

            double escapeValue = 0.0;

            if(!opposingParty.boss())
            {
                escapeValue = opposingParty.getAverageActiveChanceToPreventEscape(escapedCharacters);

                if(character.getGeneralFeatures().getLevel() > opposingParty.getAverageActiveLevel(escapedCharacters))
                {
                    escapeValue -= (escapeValue / 4);
                }
                else
                {
                    escapeValue += (escapeValue / 5);
                }

                if(character.getTotalStats().getTotalDexterity() > opposingParty.getAverageActiveDexterity(escapedCharacters)){
                    escapeValue -= (escapeValue / 3);
                }
                else
                {
                    escapeValue += (escapeValue / 4);
                }

                result = escapePossible(opposingParty.getAverageActiveChanceToPreventEscape(
                    escapedCharacters), escapeValue);
            }

            return result;
        }

        public void escapeAttemptBehavior(PriorityQueue<GenericCharacter> currentRound, 
            PriorityQueue<GenericCharacter> nextRound, Party opposingParty)
        {
            if(escapeOutcome(currentRound.peek(), opposingParty))
            {
                escapedCharacters.add(currentRound.poll());
            }
            else
            {
                endOfTurnEffects(currentRound.peek());
                currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
                nextRound.add(currentRound.poll());
            } 
        }	

        // account for character escape behavior or general move behavior 
        public void postMoveBehavior(PriorityQueue<GenericCharacter> currentRound, PriorityQueue
            <GenericCharacter> nextRound, Party opposingParty)
        {
            // if accounts for escape attempt and else accounts for non-escape behavior
            if(currentRound.peek().getGeneralFeatures().getBattleDexterity() == Double.MAX_VALUE)
            {
                escapeAttemptBehavior(currentRound, nextRound, opposingParty);
            }
            else
            {
                // apply effects to non-knocked out characters ONLY 
                if(!currentRound.peek().getGeneralFeatures().knockedOut())
                {
                    endOfTurnEffects(currentRound.peek());
                }

                currentRound.peek().getGeneralFeatures().setBattleDexterity(currentRound.peek()); 
                nextRound.add(currentRound.poll());
            }
        }

        // END: POST MOVE BEHAVIOR AND ESCAPE BEHAVIOR 
        /*******************************************************************************/



        // START: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
        /*******************************************************************************/

        // end battle loop condition 
        public void playerGameOverUponDeath(Party partyOne, Party partyTwo)
        {
            if(partyOne.playerParty() || partyTwo.playerParty())
            {
                playerGameOver = (partyOne.partyMemberDead() || partyTwo.partyMemberDead());
            }
        }

        // end battle loop condition 
        public void endBattleEarlyTrigger(Party partyOne, Party partyTwo)
        {
            if(partyOne.endBattle() || partyTwo.endBattle())
            {
                endBattleEarlyTrigger = true;
            }
        }

        // end battle loop condition 
        public void partiesTied(Party partyOne, Party partyTwo)
        {
            if(partyOne.partyKnockedOut() && partyTwo.partyKnockedOut())
            {
                partiesTied = true;
            }
        }

        /* Party Escape Logic (escaping is ONLY way out of priority queue)
            Party with one member conditions:
                must check against party that character belongs to 
                    if all members of a party escape then priority queue must not 
                    have any members of party in it 
                        escape successful!
            Party with many members conditions: 
                must check against party that character belongs too 
                    if all members of a party escape then priority queue must not 
                    have any members of party in it 
                        escape successful!
                number of members for party must at least be 1 less than party size 
                    (1 escaped so for party of 4 there are 3 members still in battle)
                        if at least 1 escaped and rest of active combatants are KO or
                        if all party members manage to escape 
                            escape successful!
        */

        public enum SpecificCombatants
        {
            ALL_CHARACTERS_IN_BATTLE, ALL_NON_KO_CHARACTERS_IN_BATTLE;
        }

        public int countSpecificPartyCombatants(PriorityQueue<GenericCharacter> allPqContents, 
            Party party, SpecificCombatants choice)
        {
            int counter = 0;

            for(GenericCharacter element : allPqContents)
            {
                if(party.partyMemberExists(element))
                {
                    switch(choice)
                    {
                        case ALL_CHARACTERS_IN_BATTLE: 
                            counter++;
                                break; 
                        case ALL_NON_KO_CHARACTERS_IN_BATTLE: 
                            if(!element.getGeneralFeatures().knockedOut())
                            { 
                                counter++;
                            }
                                break;
                    }
                }
            }

            return counter;
        }

        public int countCombatantsInBattle(PriorityQueue<GenericCharacter> allPqContents, Party party)
        {
            return countSpecificPartyCombatants(allPqContents, party, SpecificCombatants.
                ALL_CHARACTERS_IN_BATTLE);
        }

        public int countCombatantsKnockedOut(PriorityQueue<GenericCharacter> allPqContents, Party party)
        {
            return countSpecificPartyCombatants(allPqContents, party, SpecificCombatants.
                ALL_NON_KO_CHARACTERS_IN_BATTLE);
        }

        public boolean remainingCombatantsKnockedOut(PriorityQueue<GenericCharacter> allPqContents, Party party)
        {
            return (countCombatantsInBattle(allPqContents, party) == countCombatantsKnockedOut(allPqContents, party));
        }

        public boolean successfulPartyEscape(PriorityQueue<GenericCharacter> allPqContents, Party party)
        {
            boolean result = false;

            // if statement accounts for when at least one character escaped 
            if(party.getPartyMembers().size() > countCombatantsInBattle(allPqContents, party))
            {
                /* Conditions for successful party escape: 
                    if remaining combatants of party are knocked out in battle 
                    if no more party combatants are in battle (all escaped) */
                if(remainingCombatantsKnockedOut(allPqContents, party))
                {
                    result = true;
                }
            }

            return result;
        }

        // end battle loop condition 
        public void partyTwoEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
        {
            partyTwoEscape = successfulPartyEscape(allPqContents, partyOne);
        }

        // end battle loop condition 
        public void partyOneEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
        {
            partyOneEscape = successfulPartyEscape(allPqContents, partyTwo);
        }

        // end battle loop condition 
        public void playerPartyEscape(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
        {
            if(getPlayerParty(partyOne, partyTwo) != null)
            {
                playerPartyEscape = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
            }
        }

        // Note: in order to determine whether a party wins/loses one needs to know
        //       how many party members are still in battle as well as how many are
        //       not knocked out 

        public void partyLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo,
            boolean condition)
        {
            if(remainingCombatantsKnockedOut(allPqContents, partyTwo))
            {
                condition = true;
            }
        }

        // end battle loop condition 
        public void partyTwoLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyTwo)
        {
            partyLoss(allPqContents, partyTwo, partyTwoLoss);
        }

        // end battle loop condition 
        public void partyOneLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne)
        {
            partyLoss(allPqContents, partyOne, partyOneLoss);
        }

        // end battle loop condition 
        public void playerPartyLoss(PriorityQueue<GenericCharacter> allPqContents, Party partyOne, Party partyTwo)
        {
            if(getPlayerParty(partyOne, partyTwo) != null)
            {
                playerPartyEscape = successfulPartyEscape(allPqContents, getPlayerParty(partyOne, partyTwo));
            }
        }

        // end battle loop condition 
        public void partyTwoWin(boolean partyOneLoss, boolean partyTwoLoss)
        {
            if(partyOneLoss && !partyTwoLoss)
            {
                partyTwoWin = true;
            }
        }

        // end battle loop condition 
        public void partyOneWin(boolean partyOneWin, boolean partyTwoLoss)
        {
            if(!partyOneLoss && partyTwoLoss)
            {
                partyOneWin = true;
            }
        }

        // end battle loop condition 
        public void playerPartyWin(boolean partyOneWin, boolean partyTwoWin, Party partyOne, Party partyTwo)
        {
            if(partyOneWin && partyOne == getPlayerParty(partyOne, partyTwo))
            {
                playerPartyWin = true;
            }
            else if(partyTwoWin && partyTwo == getPlayerParty(partyOne, partyTwo))
            {
                playerPartyWin = true;
            }
        }

        // END: BOOLEANS FOR SPECIAL CONDITIONS DETERMINING BATTLE OUTCOME 
        /*******************************************************************************/



        // START: END BATTLE LOOP BOOLEAN MANAGEMENT 
        /*******************************************************************************/

        public void checkEndBattleLoopVariables(PriorityQueue<GenericCharacter> allPqContents, 
            Party partyOne, Party partyTwo)
        {
            playerGameOverUponDeath(partyOne, partyTwo);
            endBattleEarlyTrigger(partyOne, partyTwo);
            partiesTied(partyOne, partyTwo);
            partyTwoEscape(allPqContents, partyTwo);
            partyOneEscape(allPqContents, partyOne);
            playerPartyEscape(allPqContents, partyOne, partyTwo);
            partyTwoLoss(allPqContents, partyTwo);
            partyOneLoss(allPqContents, partyOne);
            playerPartyLoss(allPqContents, partyOne, partyTwo);
            partyTwoWin(partyOneLoss, partyTwoLoss);
            partyOneWin(partyOneWin, partyTwoLoss);
            playerPartyWin(partyOneWin, partyTwoWin, partyOne, partyTwo);
        }

        // END: END BATTLE LOOP BOOLEAN MANAGEMENT 
        /*******************************************************************************/
    }

































    
    
    
    
    public static void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    static JFrame frame = new JFrame();
    
    public BattleMenu()
    {
        frame.setLayout(new GridBagLayout());
        
        PlayerEntityFactory entityOne = new PlayerEntityFactory();
            referencePartyOne = entityOne.getPlayerEntityExample().getParty();
        
        PlayerEntityFactory entityTwo = new PlayerEntityFactory();
            referencePartyTwo = entityTwo.getPlayerEntityExampleTwo().getParty();
        
        Battle battle = new Battle();
        
        battle.standardBattle(battle, entityOne.getPlayerEntityExample().getParty(), 
            entityTwo.getPlayerEntityExampleTwo().getParty(), frame);
    }
    
    
    
    
    
    
    
    
    
}
