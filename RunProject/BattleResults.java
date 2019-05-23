package RunProject;

import Generic_Character.*;
import java.security.SecureRandom;
import java.util.PriorityQueue;	
import Player_Entity.Party;
import java.util.ArrayList;
import Battle_Feature.LevelMechanics;
import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;
import Player_Entity.Party;
import Battle_Feature.LevelMechanics;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;

public class BattleResults extends CommonGUIMethods
{
    // frame meant to store components in a desired layout 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    private Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    // vertical and horizontal padding for button and JList components 
    private int buttonVerticalPadding = 75;
    private int jListVerticalPadding = 0;
    
    // JLists showing characters that received experience and objects dropped by foes 
    private JList charactersThatReceivedExperience, objectsDropped;
    
    // allows player to exit battle results by disposing of battle results frame 
    private JButton exitBattleResults;
    
    
    
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

    
    
    // START: UNUSABLE MENU TITLE BUTTON AND EXPERIENCE/MONEY GAINED BUTTONS
    /*******************************************************************************/

    public JButton newUnusableMenuTitleButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addUnusableMenuTitleButton(String buttonName, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        addButtonComponent(newUnusableMenuTitleButton(buttonName), gridy, gridx, 0.11, 0.25, 
            1, gridwidth, frame);
    }
    
    public void addBattleResultsMenuButton(JFrame frame)
    {
        addUnusableMenuTitleButton("Battle Results Menu", 0, 0, 0, frame);
    }
    
    // END: UNUSABLE MENU TITLE BUTTON AND EXPERIENCE/MONEY GAINED BUTTONS
    /*******************************************************************************/

    
    
    // START: EXPERIENCE GAINED AND MONEY GAINED BUTTON 
    /*******************************************************************************/

    public JButton newUnusableInfoButtons(String text)
    {
        JButton button = new JButton(text);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        // gun metal blue color in hexadecimal 
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addUnusableInfoButton(String buttonName, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        addButtonComponent(newUnusableInfoButtons(buttonName), gridy, gridx, 0.11, 0.25, 
            1, gridwidth, frame);
    }
    
    public int totalExpGained(ArrayList<GenericCharacter> defeatedEnemies)
    {
        int exp = 0;
        
        for(GenericCharacter element : defeatedEnemies)
        {
            exp += element.getOppositionMethods().getDefeatExp();
        }
        
        return exp;
    }
    
    public double moneyGained(ArrayList<GenericCharacter> defeatedEnemies)
    {
        double money = 0;
        
        for(GenericCharacter element : defeatedEnemies)
        {
            money += element.getOppositionMethods().getDefeatMoney();
        }
        
        return money;
    }
    
    public void addGainedButtons(ArrayList<GenericCharacter> defeatedEnemies, JFrame frame)
    {
        String expGainedText = String.format("%-14s: %-16s", "EXP Gained", String.valueOf(
            totalExpGained(defeatedEnemies)));
                addUnusableInfoButton(expGainedText, 1, 0, 1, frame);
        
        String moneyGainedText = String.format("%-14s: %-16s", "Money Gained", String.valueOf(
            moneyGained(defeatedEnemies)));
                addUnusableInfoButton(moneyGainedText, 1, 1, 1, frame);
    }
    
    public ArrayList<GenericCharacter> nonKoPartyMembers(Party party)
    {
        ArrayList<GenericCharacter> partyMembers = new ArrayList<>();
        
        for(GenericCharacter character : party.getPartyMembers())
        {
            if(!character.getGeneralFeatures().knockedOut())
            {
                partyMembers.add(character);
            }
        }
        
        return partyMembers;
    }
    
    // NEED TO ADD EXP AND MONEY TO WALLET 
    public void addGainedResults(PlayerEntity entity, ArrayList<GenericCharacter> defeatedEnemies)
    {
        // add experience to all non KO characters 
        for(GenericCharacter element : nonKoPartyMembers(entity.getParty()))
        {
            element.getGeneralFeatures().setExperience(totalExpGained(defeatedEnemies));
        }
        
        // add money to party wallet 
        entity.getPartyWallet().setCurrentMoney(entity.getPartyWallet().getCurrentMoney() + 
            moneyGained(defeatedEnemies));
    }
    
    // END: EXPERIENCE GAINED AND MONEY GAINED BUTTON
    /*******************************************************************************/

    
    
    // START: CHARACTERS GAINING EXP AND OBJECTS DROPPED JLIST TITLES 
    /*******************************************************************************/

    public JButton newUnusableTitleButtons(String text)
    {
        JButton button = new JButton(text);
        
        // gun metal blue color in hexadecimal 
        button.setBackground(Color.decode("#4d5461"));
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addUnusableTitleButton(String buttonName, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        addButtonComponent(newUnusableTitleButtons(buttonName), gridy, gridx, 0.11, 0.25, 
            1, gridwidth, frame);
    }
    
    public void addJListTitleButtons(JFrame frame)
    {
        addUnusableTitleButton("Characters Gaining EXP", 2, 0, 1, frame);
        
        addUnusableTitleButton("Defeated Enemy Drops", 2, 1, 1, frame);
    }
    
    // END: CHARACTERS GAINING EXP AND OBJECTS DROPPED JLIST TITLES 
    /*******************************************************************************/

    
    
    // START: ADDING CHARACTERS RECEIVING EXP AND OBJECTS DROPPED JLISTS
    /*******************************************************************************/

    public void addCharacterJListComponent(JList jList, int gridy, int gridx, int gridwidth, 
        JFrame frame)
    {
        jList.setFont(JListFont);
        
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
        
        // specified column length component takes up in frame height
        gridBagConstraints.weighty = 0.20;
        
        // specified row length component takes up in frame width
        gridBagConstraints.weightx = 0.20;
        
        // height of component in given column 
        gridBagConstraints.gridheight = 4;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = gridwidth;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 350;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add button to frame with positioning 
        frame.add(statsScroll, gridBagConstraints);
    }
    
    public void addBattleResultsJLists(JFrame frame)
    {
        charactersThatReceivedExperience = new JList();
            addCharacterJListComponent(charactersThatReceivedExperience, 3, 0, 1, frame);
        
        objectsDropped = new JList();
            addCharacterJListComponent(objectsDropped, 3, 1, 1, frame);
    }
    
    // END: ADDING CHARACTERS RECEIVING EXP AND OBJECTS DROPPED JLISTS
    /*******************************************************************************/

    
    
    // START: ADDING CHARACTERS TO CHARACTERS RECEIVING EXP JLIST
    /*******************************************************************************/
    
    public String name(GenericCharacter character, int counter)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s %s %s: %-2s", character.getGeneralFeatures().getName(),
            desiredSpaces(5), "Member", String.valueOf(counter));
                return formatName;
    }
    
    public String level(int storedLevel, GenericCharacter character)
    {
        StringBuilder builder = new StringBuilder();
        
        // account for no level up and level up scenarios
        if(storedLevel == character.getGeneralFeatures().getLevel())
        {
            String formatLevel = String.format("%-13s: %s", "Lv:", formatExperience(character.
                getGeneralFeatures().getLevel()));
                    builder.append(formatLevel);
        }
        else
        {
            String formatLevel = String.format("%-13s: %s", "New Lv:", formatExperience(character.
                getGeneralFeatures().getLevel()));
                    builder.append(formatLevel);
        }
        
        return builder.toString();
    }
    
    public String expPostBattle(GenericCharacter character)
    {
        String formatCurrentExpPostBattle = String.format("%-13s: %s", "Current EXP", 
            formatExperience(character.getGeneralFeatures().getExperience()));
                return formatCurrentExpPostBattle;
    }
    
    public String nextLevel(GenericCharacter character)
    {
        String formatNano = String.format("%-13s: %s", "To Next Level", formatExperience(
            new LevelMechanics().nextLevelExp(character)));
                return formatNano;
    }
    
    // Note: new line is called AFTER element is added to model 
    public void addPartyMemberDetails(DefaultListModel<String> nonKopartyMemberModel, 
        GenericCharacter character, int counter)
    {
        double storedLevel = character.getGeneralFeatures().getLevel();
            new LevelMechanics().levelUp(character);
        
        nonKopartyMemberModel.addElement(name(character, counter));
        nonKopartyMemberModel.addElement(level((int)storedLevel, character));
        nonKopartyMemberModel.addElement(expPostBattle(character));
        nonKopartyMemberModel.addElement(nextLevel(character));
    }
    
    public DefaultListModel<String> partyMembersModel(Party party)
    {
        DefaultListModel<String> partyMembers = new DefaultListModel<>();
       
        ArrayList<GenericCharacter> nonKoPartyMembers = nonKoPartyMembers(party);
        
        int counter = 1;
        
        for(GenericCharacter character : nonKoPartyMembers)
        {
            if(nonKoPartyMembers.size() == 1)
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else if(counter == nonKoPartyMembers.size())
            {
                addPartyMemberDetails(partyMembers, character, counter);
            }
            else
            {
                addPartyMemberDetails(partyMembers, character, counter);
                    partyMembers.addElement(" ");
                        partyMembers.addElement(" ");
            }
            
            counter++;
        }
        
        return partyMembers;
    }
    
    // END: ADDING CHARACTERS TO CHARACTERS RECEIVING EXP JLIST
    /*******************************************************************************/

    
    
    // START: ADDING OBJECTS TO OBJECTS DROPPED JLIST AND INVENTORY 
    /*******************************************************************************/

    // from defeated enemies, loop through drops ArrayList and place objects
    // by character into JList (characters from ArrayList<GenericCharacter>)
    // if objects can be added to inventory then add them and then put names 
    // of objects added to inventory in JList 
    public static DefaultListModel<String> addObjectsToInventoryAndSetJListModel(
        ArrayList<GenericCharacter> defeatedEnemies, Inventory inventory)
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(GenericCharacter element : defeatedEnemies)
        {
            // state name of character dropping objects 
            String formattedName = String.format("%42s", element.getGeneralFeatures().getName());
                model.addElement(formattedName);
            
            for(GenericObject object : element.getOppositionMethods().getDroppableObjects())
            {
                // if object can be added to inventory then state name of object added
                if(inventory.canAddObject(object))
                {
                    inventory.addObject(object);
                    
                    model.addElement(object.getName());
                }
            }
        }
        
        return model;
    }
    
    // END: ADDING OBJECTS TO OBJECTS DROPPED JLIST AND INVENTORY 
    /*******************************************************************************/

    
    
    // START: INVENTORY CAPACITY INFO AND WALLET MONEY INFO 
    /*******************************************************************************/

    public String formatCurrentMaxValues(double currentValue, double maximumValue)
    {
        String curValue = String.valueOf(currentValue);
        
        String maxValue = String.valueOf(maximumValue);
        
        StringBuilder builder = new StringBuilder();
        
        // spaces are used to make current value Strings appear alligned 
        if(currentValue < 10)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(curValue).append(" / ");
        
        // spaces are used to make max value Strings appear alligned 
        if(maximumValue < 10)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(maxValue);
        
        return builder.toString();
    }
    
    public void addInventoryInfoAndWalletInfoButtons(Inventory inventory, PartyWallet wallet, 
        JFrame frame)
    {
        String inventoryInfo = String.format("%-30s: (%s)", "Total Inventory Object Groups", 
            formatCurrentMaxValues(inventory.getInventory().size(), 
            inventory.getObjectGroupsLimit()));
                addUnusableInfoButton(inventoryInfo, 7, 0, 2, frame);
                
        String walletMoney = String.format("%-30s: %s / %s", "Total Party Wallet Money", 
            String.valueOf(wallet.getCurrentMoney()), String.valueOf(wallet.getWalletCapacity()));
                addUnusableInfoButton(walletMoney, 8, 0, 2, frame);
    }
    
    // END: INVENTORY CAPACITY INFO AND WALLET MONEY INFO 
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
        addButtonComponent(button, 9, 0, 0.11, 0.33, 1, 0, frame);
    }
    
    public void addUsableButtons(JFrame frame)
    {
        exitBattleResults = newUsableButton("Exit Battle Results");
            exitBattleResults.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // signify that Gui is complete 
                        guiComplete(true);

                        // release all native screen resources, subcomponents, and all 
                        // of its owned children; in other words, close GUI and allow  
                        // program to continue running IF other windows are available 
                        frame.dispose();
                    }
                }); 
        
        usableButtonPlacement(exitBattleResults, frame);
    }
    
    // END: USABLE FRAME BUTTONS 
    /*******************************************************************************/

    
    
    public BattleResults(PlayerEntity entity, ArrayList<GenericCharacter> suppliedDefeatedEnemies)
    {
        // set layout for frame which is used for component placement 
        frame.setLayout(new GridBagLayout());
        
        // buttons title lets player know what screen is being presented 
        addBattleResultsMenuButton(frame);
        
        // add experience and money gained from all defeated enemies 
	addGainedButtons(suppliedDefeatedEnemies, frame);
	
        // add experience to playable characters and money to party wallet 
        addGainedResults(entity, suppliedDefeatedEnemies);
        
        // add titles for JLists
        addJListTitleButtons(frame);
        
        // add JLists associated with battle results 
	addBattleResultsJLists(frame);
        
        // set up JList model for non KO party members that can receive experience 
        charactersThatReceivedExperience.setModel(partyMembersModel(entity.getParty()));
        
        // set up JList model for enemies and the objects that they drop 
        objectsDropped.setModel(addObjectsToInventoryAndSetJListModel(suppliedDefeatedEnemies, 
            entity.getInventory()));
        
        // add buttons containing info about inventory groups and wallet money 
        addInventoryInfoAndWalletInfoButtons(entity.getInventory(), entity.getPartyWallet(), 
            frame);
	
        // add usable buttons allowing escape from battle results menu 
        addUsableButtons(frame);
        
        displayFrameWindow(frame);
    }
    
}
