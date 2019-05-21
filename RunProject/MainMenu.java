package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;

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


public class MainMenu 
{
    private JButton items, equip, moves, stats, status, settings, datalog, exitMenu;

    // font size used for text of all componenets 
    private Font font = new Font("Serif", Font.PLAIN, 18);
    
    private int buttonVerticalPadding = 45;
    
    
    
    // START: CREATING USABLE BUTTONS
    /*******************************************************************************/
    
    private JButton newButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(font);
        
        return button;
    }
    
    public void buttonComponentPlacement(JButton button, int loopCount, 
        JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = 0 + loopCount;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.11;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.10;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    public void addButtonComponents(JFrame frame, JButton[] buttons, String[] buttonNames)
    {
        for(int i = 0; i < buttons.length; i++)
        {
            buttons[i] = newButton(buttonNames[i]);
                buttonComponentPlacement(buttons[i], i, frame);
        }
    }
    
    // END: CREATING USABLE BUTTONS
    /*******************************************************************************/

    
    
    // START: USABLE BUTTON NAVIGATION AND ACTION LISTENERS 
    /*******************************************************************************/

    // allow for text to resize (somewhat) upon change in frame size...
    public void textResizesUponButtonResize(JButton...array)
    {
        for(JButton element : array)
        {
            if(element != null)
            {
                CommonGUIMethods.resizeButtonTextUsingFrameSize(frame, element);
            }
        }
    }
    
    public void usableButtonColumnNavigation(JFrame frame, JButton[] buttons)
    {
        // add button column functionality for keyboard and mouse wheel 
        CommonGUIMethods.buttonColumnKeyboardNavigation(buttons);
        CommonGUIMethods.frameMouseWheel(frame, buttons);
        
        // add ability for text to resize upon frame resize 
        textResizesUponButtonResize(buttons);
    }
    
    public void usableButtonsActionsListeners()
    {
        items.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        equip.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        moves.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        stats.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        status.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        settings.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        datalog.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        exitMenu.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }); 
    }
    
    
    // END: USABLE BUTTON NAVIGATION AND ACTION LISTENERS
    /*******************************************************************************/

    
    
    // START: PARTY WALLET INFORMATION 
    /*******************************************************************************/

    public String spacesBetweenWords(int desiredSpaces)
    {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < desiredSpaces; i++)
        {
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
    public String walletDescription(PartyWallet wallet)
    {
        String spacesBetweenWords = spacesBetweenWords(8);
        
        // money portion of wallet 
        StringBuilder money = new StringBuilder();
        money.append("Wallet Money: ").append(String.valueOf(wallet.getCurrentMoney())).
            append(" / ").append(String.valueOf(wallet.getWalletCapacity()));
        
        // money portion of wallet 
        StringBuilder size = new StringBuilder();
        size.append("Wallet Size: ").append(wallet.getSizeString());

        // money portion of wallet 
        StringBuilder tier = new StringBuilder();
        tier.append("Wallet Tier: ").append(wallet.getTierString());
        
        StringBuilder walletDescription = new StringBuilder();
        walletDescription.append(money.toString()).append(spacesBetweenWords).
            append(size.toString()).append(spacesBetweenWords).append(tier.toString());
                return walletDescription.toString();
    }
    
    public void addWalletInformationButton(JFrame frame, PartyWallet wallet)
    {
        JButton button = new JButton(walletDescription(wallet));
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(font);
        
        textResizesUponButtonResize(button);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = 8;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.11;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.20;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 4;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    // END: PARTY WALLET INFORMATION 
    /*******************************************************************************/

    
    
    // START: PANEL DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/
    
    public void addJPanelForCharacterDisplay(JPanel panel, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = 1;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.50;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.70;
        
        // extend downward 8 rows from gridy placement 
        gridBagConstraints.gridheight = 8;
        
        // extend component width 2 columns 
        gridBagConstraints.gridwidth = 2;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(0, 5, 5, 0);
        
        frame.add(panel, gridBagConstraints);
    }
    
    // END: PANEL DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/

    
    
    // START: INTERNAL PANELS FOR DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/

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
        
        textResizesUponButtonResize(button);
        
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
    
    public JPanel internalJPanelCharacterInformation(GenericCharacter character)
    {
        // panel will hold several buttons 
        JPanel internalPanel = new JPanel();
        
        // set layout for internal panel as GridBagLayout 
        internalPanel.setLayout(new GridBagLayout());
        
        // StringBuilder object used for creating text passed to button 
        StringBuilder builder = new StringBuilder();
        
        // add name of character  
        buttonForInternalPanelPlacement(character.getGeneralFeatures().getName(), 
            0, 0, internalPanel);
        
        // add level of character 
        builder.append("LV: ").append(String.valueOf(character.getGeneralFeatures().
            getLevel()));
        
        buttonForInternalPanelPlacement(builder.toString(), 0, 1, internalPanel);
        
        // add stress value of character 
        builder = new StringBuilder();
        
        builder.append("Stress: ").append(String.valueOf(character.getStress().
            getCurrentStress())).append(" / ").append(String.valueOf(character.
            getStress().getMaxStress()));
        
        buttonForInternalPanelPlacement(builder.toString(), 1, 0, internalPanel);
        
        // add "Current EXP:" label
        buttonForInternalPanelPlacement("Current EXP:", 1, 1, internalPanel);
        
        // add Health Points (HP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("HP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentHealth())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxHealth()));
        
        buttonForInternalPanelPlacement(builder.toString(), 2, 0, internalPanel);
        
        // add experience value accrued by character 
        builder = new StringBuilder();
        
        builder.append("      ").append(String.valueOf(character.getGeneralFeatures().
            getExperience()));
        
        buttonForInternalPanelPlacement(builder.toString(), 2, 1, internalPanel);
        
        // add Stamina Points (SP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("SP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentStamina())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxStamina()));
        
        buttonForInternalPanelPlacement(builder.toString(), 3, 0, internalPanel);
        
        // add "Next Level:" label
        buttonForInternalPanelPlacement("Next Level:", 3, 1, internalPanel);
        
        // add Nanomachine Points (NP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("NP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentNano())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxNano()));
        
        buttonForInternalPanelPlacement(builder.toString(), 4, 0, internalPanel);
        
        // add value needed for next level for character 
        LevelMechanics level = new LevelMechanics();
        
        builder = new StringBuilder();
        
        builder.append("      ").append(String.valueOf(level.nextLevelExp(character)));
        
        buttonForInternalPanelPlacement(builder.toString(), 4, 1, internalPanel);
        
        return internalPanel;
    }
    
    public void internalJPanelPlacement(JPanel panel, JPanel internalPanel,
        int loopCount)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = loopCount;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.20;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) Insets(0, -225, 0, -125);
        gridBagConstraints.insets = new Insets(5, 25, 5, 25);
        
        panel.add(internalPanel, gridBagConstraints);
    }
    
    public void addPanelsForCharacterInformation(PlayerEntity playerEntity, JFrame frame)
    {
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.BLACK);
        
        panel.setLayout(new GridBagLayout());
        
        int counter = 0;
        
        for(GenericCharacter character : playerEntity.getParty().getPartyMembers())
        {
            internalJPanelPlacement(panel, internalJPanelCharacterInformation(character), 
                counter);
            counter++;
                    if(counter ==3){break;}
                    //break;
        }
        
        addJPanelForCharacterDisplay(panel, frame);
    }
    
    // END: INTERNAL PANELS FOR DISPLAYING CHARACTER PARTY INFORMATION
    /*******************************************************************************/

    
    
    // START: DISPLAY FRAME WINDOW 
    /*******************************************************************************/

    public void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // END: DISPLAY FRAME WINDOW 
    /*******************************************************************************/

    
    private JFrame frame = new JFrame("Capstone RPG");
    
    public MainMenu()
    {
        frame.getContentPane().setBackground(Color.WHITE);
        
        frame.getContentPane().setLayout(new GridBagLayout());
        
        JButton[] privateButtons = {items, equip, moves, stats, status, settings, 
            datalog, exitMenu};
        
        String[] buttonNames = {"Items", "Equipment", "Moves", "Stats", "Status", 
            "Settings", "Datalogs", "Exit Menu"};

        addButtonComponents(frame, privateButtons, buttonNames);
        
        // enable mouse wheel and keyboard navigation for usable buttons 
        usableButtonColumnNavigation(frame, privateButtons);
        
        // get fake player entity 
        PlayerEntityFactory factory = new PlayerEntityFactory();
        addWalletInformationButton(frame, factory.getPlayerEntityExample().getPartyWallet());
        
        // panel stuff 
        addPanelsForCharacterInformation(factory.getPlayerEntityExample(), frame);

        displayFrameWindow();
    }
}