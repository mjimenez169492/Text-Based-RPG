package GUI_Collection;

import GUI_Collection.CommonGUIMethods;
import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Commonly_Used_Methods.StaticMethods;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;
import Generic_Object.Outfit;
import Generic_Object.*;

import javax.swing.DefaultListCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;

import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

public class SubmenuEquipment extends CommonGUIMethods
{
    // frame meant to store components in a desired layout 
    private JFrame frame = new JFrame("Capstone RPG");

    // store JFrame that originally called frame of this class to return to it later 
    private JFrame callingFrame = new JFrame();
    
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
    
    // vertical padding in pixels for given components 
    private int buttonVerticalPadding = 55;
    private int jListVerticalPadding = 240;
    
    // button allowing player to return to main menu 
    private JButton mainMenu;
    
    // buttons providing some information about outfit selected 
    private JButton outfitOverview, outfitDescription;
    
    // JLists used to present players with different aspects related to outfit equip 
    private JList partyMemberJList, canChangeOutfits, currentNewTotalStatsJList, 
        inventoryOutfitsJList;
    
    // buttons denoting currently equipped outfits 
    private JButton equippedWeapon, equippedAccessoryOne, equippedAccessoryTwo,
        equippedBodyArmor, equippedLegArmor, equippedFootArmor;

    // stores reference to button which has outfit player wishes to change or view 
    private JButton equippedOutfitReference;
    
    // buttons and text area used to updated external frame character panel
    private JButton characterName = new JButton();
    private JButton characterHealth = new JButton();
    private JButton characterStamina = new JButton();
    private JButton characterNano = new JButton();
    
    // external frame used to present outfit equip or view functions 
    private JFrame externalFrame = new JFrame();
    
    // denotes whether a certain external frame layout is active or not 
    private boolean viewFrameActive, equipFrameActive;
    
    // buttons used in external frame to present some outfit information to player 
    private JButton externalOutfitName = new JButton();
    private JButton externalExperienceMultiplier = new JButton();
    private JButton externalDurabilityInfo = new JButton();
    private JButton externalSlotCoreInfo = new JButton();
    
    // button for equip action button
    private JButton externalEquip = new JButton();
    
    // external frame JLists present information tied to selected outfit 
    private JList externalOutfitNamesJList = new JList();
    private JList externalEquippedCores = new JList();
    private JList externalOutfitStats = new JList();
    
    // store character in focus for equip function so equip affects that character only 
    private GenericCharacter characterForOutfitEquip;
    
    // Note: outfit in focus can only be an equipped outfit 
    private Outfit outfitTiedToOutfitButton;
    
    // popup menus that appear upon selecting certain components 
    private JPopupMenu inventoryOutfitsJPopupMenu = new JPopupMenu(); 
    private JPopupMenu alterableEquippedOutfitsJPopupMenu = new JPopupMenu();
    private JPopupMenu unalterableEquippedOutfitsJPopupMenu = new JPopupMenu();

    
    
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
        
        // specified column length component takes up 
        gridBagConstraints.weighty = weighty;
        
        // specified row length component takes up 
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
    
    public void addUsableButtons(JFrame frame)
    {
        mainMenu = newUsableButton("Main Menu");
            mainMenu.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // dispose of Equips Menu frame and external frame
                        frame.dispose();
                        externalFrame.dispose();

                        // return focus to frame that orginally called Main Menu 
                        displayFrameWindow(callingFrame);
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
        
        String partyMemberInfoJPanelTitle = String.format("%s", "Party Member & Accessory");
            addTitleButton(partyMemberInfoJPanelTitle, 1, 1, 1, frame);
        
        String equippedOutfitsButtonTitle = String.format("%s", "More Equipped Outfits");
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
        
        // specified column length component takes up 
        gridBagConstraints.weighty = weighty;
        
        // specified row length component takes up 
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
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.10;
        
        // specified row length component takes up 
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
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.10;
        
        // specified row length component takes up 
        gridBagConstraints.weightx = 0.10;
        
        gridBagConstraints.gridheight= 2;
        
        gridBagConstraints.gridwidth = 1;

        frame.add(changeOutfitsScroll, gridBagConstraints);
    }
    
    // CAN CHANGE OUTFITS JLIST
    
    
    
    // GET PARTY MEMBER
    
    public String trimCharacterName(String name)
    {
        // split name into words using white space as delimiter 
        String[] words = name.split(" ");
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < words.length; i++)
        {
            // add word if ther is only one word
            if(words.length == 1)
            {
                builder.append(words[i]);
            }
            // add word since last word so no space after 
            else if(i < words.length - 1)
            {
                builder.append(words[i]);
            }
            // add space between words for proper name structure
            else
            {
                builder.append(words[i]);
                    builder.append(" ");
            }
        }
        
        return builder.toString();
    }
    
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
    
    // GET PARTY MEMBER
    
    
    
    // UPDATE CHARACTER AND EQUIPPED OUTFIT INFO FOR FRAME USING JLIST VALUE
    
    public void updateCharacterInfo(GenericCharacter character)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s", character.getGeneralFeatures().getName());
            characterName.setText(formatName);
        
        // add Health Points (HP) and current/max points 
        String health = String.format("%-2s: %s", "HP", formatCurrentMaxGauges(character.
            getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                characterHealth.setText(health);

        // add Stamina Points (SP) and current/max points 
        String stamina = String.format("%-2s: %s", "SP", formatCurrentMaxGauges(character.
            getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                characterStamina.setText(stamina);
           
        // add Nanomachine Points (NP) and current/max points
        String nano = String.format("%-2s: %s", "NP", formatCurrentMaxGauges(character.
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
    
    // Note: 14 characters per outfit name due to space limitations 
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
    
    public String equipText(String defaultText, Outfit object)
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
    public void addPartyMemberJListUpdateInformation(JList jList)
    {
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update character information displayed on JList selection change 
                    if (!evt.getValueIsAdjusting()) 
                    {
                        GenericCharacter partyMember = getPartyMember(jList.getSelectedValue());

                        // update JLists and buttons using character in focus 
                        updateCharacterInfo(partyMember);
                        updateEquippedOutfitsButtons(partyMember);
                        canChangeOutfits.setModel(canChangeOutfitsInJListFormat(partyMember));

                        // update new total stats JList using character in focus 
                        // to prevent info from previous character being shown 
                        if(inventoryOutfitsJList.getSelectedValue() != null)
                        {
                            currentNewTotalStatsJList.setModel(currentNewTotalStatsModelWithOutfit(
                                partyMember, getInventoryOutfit(referenceInventory, 
                                inventoryOutfitsJList.getSelectedValue())));
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
        
        button.setForeground(Color.YELLOW);
        
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        
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
        inventoryOutfitsJList = new JList<>(inventoryOutfitsInJListFormat(inventory));
        
        // make JList use monospaced font so all characters have the same width
        inventoryOutfitsJList.setFont(JListFont);
        
        // do not allow for multiple selection (i.e. selecting more than 1 row)
        inventoryOutfitsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane inventoryScroll = new JScrollPane(inventoryOutfitsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        addInventoryJList(inventoryScroll, frame);
    }
    
    // only objects that can equipped are considered valid 
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
    
    // GETTING NEW VALUE THAT ACCOUNTS FOR SELECTED OUTFIT
    
    public Outfit getEquippedOutfitUsingSelectedOutfit(Outfit outfit, 
        GenericCharacter character)
    {
        Outfit equippedOutfit = null;
        
        if(outfit.getClass() == Weapon.class)
        {
            if(character.getEquippableOutfits().getWeapon() != null)
            {
                equippedOutfit = character.getEquippableOutfits().getWeapon();
                    character.getEquippableOutfits().setWeapon(null);
            }
        }
        else if(outfit.getClass() == Accessory.class)
        {
            switch(((Accessory)outfit).getAccessoryCategoryEnum())
            {
                case SLOT_ONE:
                    if(character.getEquippableOutfits().getAccessoryOne() != null)
                    {
                        equippedOutfit = character.getEquippableOutfits().getAccessoryOne();
                        character.getEquippableOutfits().setAccessoryOne(null);
                    }
                        break;
                case SLOT_TWO:
                    if(character.getEquippableOutfits().getAccessoryTwo() != null)
                    {
                        equippedOutfit = character.getEquippableOutfits().getAccessoryTwo();
                        character.getEquippableOutfits().setAccessoryTwo(null);
                    }
                        break;
            }
        }
        else if(outfit.getClass() == Armor.class)
        {
            switch(((Armor)outfit).getArmorCategoryEnum())
            {
                case BODY_ARMOR:
                    if(character.getEquippableOutfits().getBodyArmor() != null)
                    {
                        equippedOutfit = character.getEquippableOutfits().getBodyArmor();
                        character.getEquippableOutfits().setBodyArmor(null);
                    }
                        break;
                case LEG_ARMOR:
                    if(character.getEquippableOutfits().getLegArmor() != null)
                    {
                        equippedOutfit = character.getEquippableOutfits().getLegArmor();
                        character.getEquippableOutfits().setLegArmor(null);
                    }
                        break;
                case FOOT_ARMOR:
                    if(character.getEquippableOutfits().getFootArmor() != null)
                    {
                        equippedOutfit = character.getEquippableOutfits().getFootArmor();
                        character.getEquippableOutfits().setFootArmor(null);
                    }
                        break;
            }
        }
        
        return equippedOutfit;
    }
    
    public void equipOutfit(Outfit outfit, GenericCharacter character)
    {
        if(outfit.getClass() == Weapon.class)
        {
            character.getEquippableOutfits().setWeapon((Weapon)outfit);
        }
        else if(outfit.getClass() == Accessory.class)
        {
            switch(((Accessory)outfit).getAccessoryCategoryEnum())
            {
                case SLOT_ONE:
                    character.getEquippableOutfits().setAccessoryOne((Accessory)outfit);
                        break;
                case SLOT_TWO:
                    character.getEquippableOutfits().setAccessoryTwo((Accessory)outfit);
                        break;
            }
        }
        else if(outfit.getClass() == Armor.class)
        {
            switch(((Armor)outfit).getArmorCategoryEnum())
            {
                case BODY_ARMOR:
                    character.getEquippableOutfits().setBodyArmor((Armor)outfit);
                        break;
                case LEG_ARMOR:
                    character.getEquippableOutfits().setLegArmor((Armor)outfit);
                        break;
                case FOOT_ARMOR:
                    character.getEquippableOutfits().setFootArmor((Armor)outfit);
                        break;
            }
        }
    }
    
    public void removeOutfit(Outfit outfit, GenericCharacter character)
    {
        if(outfit.getClass() == Weapon.class)
        {
            character.getEquippableOutfits().setWeapon(null);
        }
        else if(outfit.getClass() == Accessory.class)
        {
            switch(((Accessory)outfit).getAccessoryCategoryEnum())
            {
                case SLOT_ONE:
                    character.getEquippableOutfits().setAccessoryOne(null);
                        break;
                case SLOT_TWO:
                    character.getEquippableOutfits().setAccessoryTwo(null);
                        break;
            }
        }
        else if(outfit.getClass() == Armor.class)
        {
            switch(((Armor)outfit).getArmorCategoryEnum())
            {
                case BODY_ARMOR:
                    character.getEquippableOutfits().setBodyArmor(null);
                        break;
                case LEG_ARMOR:
                    character.getEquippableOutfits().setLegArmor(null);
                        break;
                case FOOT_ARMOR:
                    character.getEquippableOutfits().setFootArmor(null);
                        break;
            }
        }
    }
    
    public enum StatType
    {
        ATTRIBUTE, ENCHANTMENT_RESISTANCE, STATUS_EFFECT_RESISTANCE;
    }
    
    public double getDesiredStatValue(StatType statType, int loopCount, GenericCharacter character)
    {
        double result = 0;
        
        switch(statType)
        {
            case ATTRIBUTE:
                result = (double)character.getTotalStats().getAllTotalAttributesWithNames()
                    [loopCount + 1];
                    break;
            case ENCHANTMENT_RESISTANCE:
                result = (double)character.getTotalStats().getAllTotalEnchantmentResistancesWithNames()
                    [loopCount + 1];
                    break;
            case STATUS_EFFECT_RESISTANCE:
                Object[] array = character.getTotalStats().getAllTotalStatusEffectResistances().toArray(new Object[0]);
                    result = (double)array[loopCount + 1];
                    break;
        }
        
        return result;
    }
    
    public double newValueWithSelectedOutfit(StatType statType, int loopCount, 
        Outfit selectedOutfit, GenericCharacter character)
    {
        // attempt to store outfit specified by selected outfit if it exists 
        Outfit equippedOutfit = getEquippedOutfitUsingSelectedOutfit(selectedOutfit, 
            character);
        
        double result = 0;
        
        // if character had an outfit equipped then proceed with "hot swap"
        if(equippedOutfit != null)
        {
            equipOutfit(selectedOutfit, character);
            result = getDesiredStatValue(statType, loopCount, character);
            removeOutfit(selectedOutfit, character);
            equipOutfit(equippedOutfit, character);
        }
        // else return value for character with outfit equipped at location 
        // specified by loopCount  
        else
        {
            equipOutfit(selectedOutfit, character);
            result = getDesiredStatValue(statType, loopCount, character);
            removeOutfit(selectedOutfit, character);
        }
        
        return result;
    }
    
    // GETTING NEW VALUE THAT ACCOUNTS FOR SELECTED OUTFIT
    
    
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
        Outfit outfit, DefaultListModel<String> model)
    {
        Object[] characterAttributes = character.getTotalStats().getAllTotalAttributesWithNames();
        
        model.addElement("Attributes");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterAttributes.length; i+=2)
        {
            double currentValue = (double)characterAttributes[i + 1];
            
            // method with hot swap here!
            double newValue = newValueWithSelectedOutfit(StatType.ATTRIBUTE, 
                i, outfit, character);
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)
                characterAttributes[i], checkAttribute(currentValue), 
                checkAttribute(newValue)));

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
    
    // outfit is casted as armor later on 
    public void addCurrentNewEnchantmentResistanceObjectsWithArmor(GenericCharacter character, 
        Outfit outfit, DefaultListModel<String> model)
    {
        Object[] characterEnchantmentResistancesWithArmor = character.getTotalStats().
            getAllTotalEnchantmentResistancesWithNames();
        
        model.addElement(" ");
        
        model.addElement("Enchantment Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterEnchantmentResistancesWithArmor.length; i+=2)
        {
            double currentValue = (double)characterEnchantmentResistancesWithArmor[i + 1];
            
            double newValue = newValueWithSelectedOutfit(StatType.ENCHANTMENT_RESISTANCE, 
                i, outfit, character);
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)
                characterEnchantmentResistancesWithArmor[i], checkResistance(currentValue), 
                checkResistance(newValue)));

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
    
    public void addCurrentNewStatusEffectResistanceObjectsWithArmor(GenericCharacter character, 
        Outfit outfit, DefaultListModel<String> model)
    {
        Object[] characterStatusEffectResistancesWithArmor = character.getTotalStats().
            getAllTotalStatusEffectResistances().toArray( new Object[0]);
        
        model.addElement(" ");
        
        model.addElement("Status Effect Resistances");
        
        model.addElement(" ");
        
        int counter = 1;
        
        for(int i = 0; i < characterStatusEffectResistancesWithArmor.length; i+=2)
        {
            double currentValue = (double)characterStatusEffectResistancesWithArmor[i + 1];
            
            double newValue = newValueWithSelectedOutfit(StatType.STATUS_EFFECT_RESISTANCE, 
                i, outfit, character);
            
            model.addElement(currentNewTotalStatWithOutfit(counter, (String)
                characterStatusEffectResistancesWithArmor[i], checkResistance(
                currentValue), checkResistance(newValue)));

            counter++;
        }
    }
    
    public void addCurrentNewStatusEffectResistanceObjectsWithoutArmor(GenericCharacter character, 
        DefaultListModel<String> model)
    {
        Object[] characterResistances = character.getTotalStats().getAllTotalStatusEffectResistances().toArray( new Object[0]);
        
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
        Outfit outfit)
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
    
    public void updateOutfitOverviewAndDescription(Outfit object)
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
    
    public Outfit getInventoryOutfit(Inventory inventory, Object jListObjectName)
    {
        Outfit object = null;
        
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
                    object = (Outfit)entry.getKey();
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
        jList.addListSelectionListener(new ListSelectionListener() 
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
                            Outfit outfit = getInventoryOutfit(inventory, 
                                jList.getSelectedValue());

                            // update outfit description 
                            updateOutfitOverviewAndDescription(outfit);

    // ERROR!
    // if no outfit equipped at location specified by outfit then JList only
    // displays same stats as character on other side
    // IT should display <NA>
                            
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

    // METHODS FOR ADDING COMPONENTS TO EXTERNAL FRAME 
    
    public void addJListToExternalFrame(JList jList, int gridx, JFrame externalFrame)
    {
        // set JList text font 
        jList.setFont(JListFont);
        
        // allign view of JList such that text is displayed at its center 
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) jList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
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
        
// padding is wrong!
        // vertical and horizontal padding in pixels 
        gridBagConstraints.ipady = 50;
        gridBagConstraints.ipadx = 230;
        
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
    
    // unused for external frame size constraints 
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
    
    public String outfitLocation(Outfit outfit)
    {
        String location = null;
        
        // different ways to retrieve location based on weapon, armor, or accessory 
        if(outfit.getClass() == Weapon.class)
        {
            // Note: differs from Armor/Accessory objects since Weapon objects are 
            //       created using a different cetegorization scheme 
            location = outfit.getMainClassString();
        }
        // account for Armor which can be placed on body, legs, or feet and
        // Accessory which can be placed in slot one or slot two of character 
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
    
    public Outfit getOutfitAtLocation(String location, GenericCharacter character)
    {
        Outfit outfit = null;
        
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
    
    public void equipOutfitAtLocation(String location, Outfit outfit, GenericCharacter 
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
        Outfit jListOutfit)
    {
        updateCharacterInfo(characterForOutfitEquip);
        
	updateEquippedOutfitsButtons(characterForOutfitEquip);
        
        referenceInventory.removeObject(jListOutfit);
                                
        inventoryOutfitsJList.setModel(inventoryOutfitsInJListFormat
            (referenceInventory));

        shiftToNextExistingObject(inventoryOutfitsJList, jListOutfitPosition);
    }
    
    public void addEquipActionListener(JButton button, JList outfitArrayListJList,
        JFrame externalFrame)
    {
        button.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // get selected outfit from list of outfits displayed in JList of
                    // external frame based on its position within JList
                    Outfit jListOutfit = (Outfit)outfitArrayList().get(
                        positionOfOutfitInJList(externalOutfitNamesJList, (String)
                        externalOutfitNamesJList.getSelectedValue()));
                    
                    // store equipped outfit at specified location of character if it exists 
                    Outfit equippedOutfit = getOutfitAtLocation(outfitLocation(
                        jListOutfit), characterForOutfitEquip);

                    // store last position of outfit selected for equip 
                    int jListOutfitPosition = positionOfOutfitInJList(inventoryOutfitsJList, 
                        jListOutfit.getName());

                    // if location that outfit must be equipped at has an outfit in
                    // place, then attempt to "swap" it with equipped outfit 
                    if(equippedOutfit != null)
                    {
                        // proceed if inventory can hold instance of equipped outfit 
                        if(referenceInventory.canAddObject(equippedOutfit))
                        {
                            // remove equipped outfit from character 
                            removeEquippedOutfit(outfitLocation(equippedOutfit), 
                                characterForOutfitEquip);

                            // add outfit selected for equip to character 
                            equipOutfitAtLocation(outfitLocation(jListOutfit), 
                                jListOutfit, characterForOutfitEquip);

                            // add previously equipped outfit into inventory 
                            referenceInventory.addObject(equippedOutfit);

                            // account for removing object selected for equip from
                            // inventory and reload appropriate JLists 
                            outfitRemovalAndInventoryJListReload(jListOutfitPosition, 
                                jListOutfit);
                        }
                    }
                    // else equip outfit to character at appropriate location 
                    else
                    {
                        // add outfit selected for equip to character 
                        equipOutfitAtLocation(outfitLocation(jListOutfit), 
                            jListOutfit, characterForOutfitEquip);

                        // account for removing object selected for equip from
                        // inventory and reload appropriate JLists 
                        outfitRemovalAndInventoryJListReload(jListOutfitPosition, 
                            jListOutfit);
                    }

                    externalFrame.dispose();
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

    
    
    // INITIALIZING EXTERNAL FRAME COMPONENTS
    
    // gets ArrayList of outfit objects for inventory object in focus 
    public ArrayList<GenericObject> outfitArrayList()
    {
        ArrayList<GenericObject> outfitArrayList = new ArrayList<>();
        
        GenericObject outfit = getInventoryOutfit(referenceInventory, 
            inventoryOutfitsJList.getSelectedValue());
        
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

    public DefaultListModel<String> equipFrameOutfitNamesJListModel(ArrayList<GenericObject> arrayList)
    {
        DefaultListModel<String> outfits = new DefaultListModel<>();
        
        for(GenericObject object : arrayList)
        {
            outfits.addElement(object.getName());
        }
        
        return outfits;
    }
    
    public void updateExternalButtonsForOutfitInFocus(Outfit outfit)
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
            counter, core.getCoreType(), core.getCoreSizeString(), core.getCoreTierString().
            charAt(core.getCoreTierString().length() - 1));
        
        return coreFormat;
    }
    
    public DefaultListModel<String> equipFrameEquippedCoresModel(Outfit outfit)
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
    
    public void addOutfitAttributes(Outfit outfit, DefaultListModel<String> model)
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
    
    public DefaultListModel<String> outfitStatsModel(Outfit outfit)
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
    
    // listener used for updating information displayed on external frame 
    public void addOutfitArrayListJListUpdateInfoListener(JList jList, JFrame externalFrame)
    {
        jList.addListSelectionListener(new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    if(jList.getSelectedValue() != null)
                    {
                        // proceed if JList selection is no longer moving 
                        if(!evt.getValueIsAdjusting())
                        {
                            // proceed if there is focus in external JList 
                            if(inventoryOutfitsJList.getSelectedValue() != null)
                            {
                                // add listener for externalOutfitNamesJList that updates 
                                // button info, equipped cores, and outfit stats 
                                Outfit outfit = (Outfit)outfitArrayList().get(
                                    positionOfOutfitInJList(jList, (String)jList.getSelectedValue()));

                                updateExternalButtonsForOutfitInFocus(outfit);

                                externalEquippedCores.setModel(equipFrameEquippedCoresModel(outfit));

                                externalOutfitStats.setModel(outfitStatsModel(outfit));
                           }
                        }
                    }
                }
            }
        );
    }
    
    // OUTFIT ARRAYLIST JLIST LISTENER FOR UPDATING EXTERNAL FRAME INFO 
    
    
    
    // EXTERNAL FRAME COMPONENT LAYOUT BASED ON DESIRED EXTERNAL FRAME 
    
    // boolean instance variables viewFrameActive and equipFrameActive determine
    // how external frame is set up as well as functionality it provides 
    public void externalFrameByBoolean(JFrame externalFrame)
    {
        // if concerns view frame suited only for equipped outfits  
        if(viewFrameActive)
        {
            // update external frame components using selected outfit before they are added 
            updateExternalButtonsForOutfitInFocus(outfitTiedToOutfitButton);
            externalEquippedCores.setModel(equipFrameEquippedCoresModel(outfitTiedToOutfitButton));
            externalOutfitStats.setModel(outfitStatsModel(outfitTiedToOutfitButton));
            
            // components: col 0 -> equipped cores, col 1 -> all outfit stats
            addJListToExternalFrame(externalEquippedCores, 0, externalFrame);
            addJListToExternalFrame(externalOutfitStats, 1, externalFrame);
            
            // default selection is first element which prevents null from being
            // passed when "equip" button is pressed immediately after external 
            // frame creation 
            externalOutfitNamesJList.setSelectedIndex(0);
        }
        else if(equipFrameActive)
        {
            // to avoid "stacking" listeners, preemptively reset externalOutfitNamesJList
            externalOutfitNamesJList = new JList();
            
            // update external frame components using selected outfit before they are added 
            externalOutfitNamesJList.setModel(equipFrameOutfitNamesJListModel(outfitArrayList()));
            externalOutfitStats.setModel(outfitStatsModel((Outfit)outfitArrayList().get(0)));
            
            // display info for first object in outfit ArrayList using buttons 
            updateExternalButtonsForOutfitInFocus((Outfit)outfitArrayList().get(0));
            
            // add listener for externalOutfitNamesJList that updates button info
            // equipped cores, and outfit stats 
            addOutfitArrayListJListUpdateInfoListener(externalOutfitNamesJList, externalFrame);
            
            // components: col 0 -> outfitArrayList     col 1 -> all outfit stats, 
            //             col 2 -> equipped cores,     col 3 -> equip button 
            addJListToExternalFrame(externalOutfitNamesJList, 0, externalFrame);
            addJListToExternalFrame(externalOutfitStats, 1, externalFrame);
            addEquipButton(externalOutfitNamesJList, 2, externalFrame);
            
            // default selection is first element which prevents null from being
            // passed when "equip" button is pressed immediately after external 
            // frame creation 
            externalOutfitNamesJList.setSelectedIndex(0);
        }
    }
    
    // denotes where external frame will appear upon creation 
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
    
    // EXTERNAL FRAME COMPONENT LAYOUT BASED ON DESIRED EXTERNAL FRAME 
    
    
    
    // action listener for button denoting equipped outfit which allows outfit
    // information to be viewed at player's convenience via popup menu 
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
    
    // equip action for inventory JList outfit in focus 
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
                    externalFrameLocation();                
                }
            }); 
    }
    
    // END: VIEW AND EQUIP ACTIONLISTENERS FOR POPUPMENU OPTIONS 
    /*******************************************************************************/

    
    
    // START: UNEQUIP ACTIONLISTENER FOR EQUIPPED OUTFITS BUTTONS 
    /*******************************************************************************/

    // method needs equippedOutfitReference reference set upon buttoon click
    public Outfit getEquippedOutfit()
    {
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        // meant to store object of Outfit subclass after implicit casting 
        Outfit outfit = null;
        
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
        // add outfit tied to button reference to inventory 
        referenceInventory.addObject(getEquippedOutfit());
        
        // remove outfit equipped at location dictated by button reference
        removeEquippedOutfit();
        
        // get character in focus to update character information 
        GenericCharacter character = getPartyMember(partyMemberJList.getSelectedValue());
        
        updateCharacterInfo(character);
        
	updateEquippedOutfitsButtons(character);
        
        resetOutfitOverviewAndDescription();
        
        // reload inventory outfits JList after outfit is unequipped from character 
        inventoryOutfitsJList.setModel(inventoryOutfitsInJListFormat(referenceInventory));
        
        // current stats model for character with current outfits 	
	currentNewTotalStatsJList.setModel(currentNewTotalStatsModelWithoutOutfit(
            character));
    }
    
    // popup menu option for button displaying an equipped outfit only  
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
        changeableOutfitJPopupMenu, JPopupMenu unchangeableOutfitJPopupMenu)
    {
        addPopupMenuJMenuItem(inventoryJListJPopupMenu, "Equip", ActionListeners.EQUIP);
        
        addPopupMenuJMenuItem(changeableOutfitJPopupMenu, "View", ActionListeners.VIEW);
        addPopupMenuJMenuItem(changeableOutfitJPopupMenu, "Unequip", ActionListeners.UNEQUIP);
        
        addPopupMenuJMenuItem(unchangeableOutfitJPopupMenu, "View", ActionListeners.VIEW);
    }
    
    // shows a different popup menu filled with choices for object based on its class 
    // upon left clicking JList value with mouse 
    public void addInventoryOutfitsJListOptionsListener(JList jList, JPopupMenu 
        inventoryJListJPopupMenu)
    {
        jList.addMouseListener(new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    // proceed only if left mouse button clicked, list selection is 
                    // not empty, and clicked point is inside selected object bounds 
                    if (SwingUtilities.isLeftMouseButton(me) && !jList.isSelectionEmpty()
                        && jList.locationToIndex(me.getPoint()) == jList.getSelectedIndex()) 
                    {
                        // proceed if selection in JList focus is not null
                        if(inventoryOutfitsJList.getSelectedValue() != null)
                        {
                            Outfit inventoryOutfit = getInventoryOutfit(referenceInventory, 
                            inventoryOutfitsJList.getSelectedValue());
                            
                            // account for whether or not character can change outfit at location 
                            if(canEquipOutfitAtLocation(outfitLocation(inventoryOutfit), getPartyMember(
                                partyMemberJList.getSelectedValue())))
                            {
                                // popup menu for equip outfit option
                                inventoryJListJPopupMenu.show(jList, me.getX(), me.getY());
                            }
                        }
                    }
                }
            }
        );
    }
    
    // ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU
    
    // END: INVENTORY JLIST (OUTFITS ONLY), OBJECT DESCRIPTION, AND NEW JLISTS     
    // ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU
    
    // END: INVENTORY JLIST (OUTFITS ONLY), OBJECT DESCRIPTION, AND NEW JLISTS 
    /*******************************************************************************/

    
    
    // START: OUTFIT BUTTON POPUP MENU 
    /*******************************************************************************/

    public void addButtonJPopupMenuActionListener(JButton button, String outfitLocation)
    {
        button.addActionListener(new ActionListener() 
            {
                String location = outfitLocation;
                
                @Override
                public void actionPerformed(ActionEvent ev) 
                {
                    Outfit outfit = getOutfitAtLocation(location, getPartyMember(
                        partyMemberJList.getSelectedValue()));
                    
                    // proceed if outfit at location of party member is not null
                    if(outfit != null)
                    {
                        // update overview and description buttons using outfit
                        updateOutfitOverviewAndDescription(outfit);
                        
                        // state which outfit belongs to button for unequip action
                        outfitTiedToOutfitButton = outfit;

                        // store reference to button of specified outfit for unequip choice 
                        equippedOutfitReference = button;
                        
                        // account for whether or not character can change outfit at location 
                        if(canEquipOutfitAtLocation(outfitLocation(outfit), getPartyMember(
                            partyMemberJList.getSelectedValue())))
                        {
                            // popup menu is displayed on bottom left of butotn 
                            alterableEquippedOutfitsJPopupMenu.show(button, 0, button.getBounds().height);
                        }
                        else
                        {
                            unalterableEquippedOutfitsJPopupMenu.show(button, 0, button.getBounds().height);
                        }
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

    

    // START: CONSTRUCTOR 
    /*******************************************************************************/

    public SubmenuEquipment(JFrame mainMenuFrame, PlayerEntity entity)
    {
        // store main menu frame to call it later 
        callingFrame = mainMenuFrame;
        
        // set layout frame will use to organize components 
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // use variables to store references to player entity and inventory
        referencePlayerEntity = entity;
        referenceInventory = entity.getInventory();
        
        // adding components to frame 
        addUsableButtons(frame);
        
        addUnusableTopTitles(frame);
        
        // store party members names in party member JList and add it to frame 
        partyMemberJList = new JList(partyMembersInJListFormat(referencePlayerEntity));
        addPartyMemberJList(partyMemberJList, frame);
        
        // store outfit change states for party member in JList and add it to frame 
        canChangeOutfits = new JList();
        addCanChangeOutfitsJList(canChangeOutfits, frame);
        
        // buttons meant to display character information 
        addCharacterInfoButtons(frame);
        addEquippedOutfitsButtons(frame);
        
        // buttons used to described an outfit in focus 
        addOutfitOverviewAndDescription(frame);
        
        // buttons meant to serve as titles for a given frame section 
        addUnusableBottomTitles(frame);
        
        // JList meant to show attributes and resistances tied to a party member 
        addCharacterAttributeAndResistancesJLists(frame);
        
        // only outfits contained in player inventory are displayed in JList 
        displayInventoryOutfitsAsJList(referenceInventory, frame);
        
        // listener updates party member information upon change in JList selection value 
        addPartyMemberJListUpdateInformation(partyMemberJList);

        // listener fills in object description/details upon object selection
        addUpdateOutfitInformationJListListener(referenceInventory, inventoryOutfitsJList);
        
        // make party member JList display information about party member in first slot
        partyMemberJList.setSelectedIndex(1);
        partyMemberJList.setSelectedIndex(0);
        
        // make inventory outfits JList display information about outfit in first slot 
        inventoryOutfitsJList.setSelectedIndex(1);
        inventoryOutfitsJList.setSelectedIndex(0);
        
        // initialize popup menus meant to appear upon button or JList selection 
        setUpPopupMenusByObject(inventoryOutfitsJPopupMenu, alterableEquippedOutfitsJPopupMenu,
            unalterableEquippedOutfitsJPopupMenu);
        
        // popup menu showing options for player upon outfit selection 
        addInventoryOutfitsJListOptionsListener(inventoryOutfitsJList, inventoryOutfitsJPopupMenu);
        
        // add popup menu functionality for equipped outfit buttons 
        equippedOutfitButtonsJPopupMenu();
        
        displayFrameWindow(frame);
    }
    
    // END: CONSTRUCTOR 
    /*******************************************************************************/
}
