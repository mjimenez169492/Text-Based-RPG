









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


public class ItemsMenu 
{
    private JButton mainMenu;
    
    private JButton itemDescription, buttonGroupTitle, inventoryJListTitle;
    
    private JButton mainClass, category, superType, subType, useSpeed, buyPrice, 
        sellPrice, dropRate;
    
    private JButton itemGroupMaxSize, coreGroupMaxSize, weaponGroupMaxSize, 
        armorGroupMaxSize, accessoryGroupMaxSize;
    
    int buttonVerticalPadding = 55;
    
    private GenericObject objectInFocus;
    
    private JList<String> inventoryObjectsJList;
    
    private JScrollPane inventoryScroll;
    
    // popup menus meant to appear based on class of selected GenericObject 
    private JPopupMenu usableItemPopupMenu = new JPopupMenu();
    private JPopupMenu keyItemPopupMenu = new JPopupMenu();
    private JPopupMenu nonItemPopupMenu = new JPopupMenu();
    
        
    
    private Inventory referenceInventory;
    
    private PlayerEntity referencePlayerEntity;
    
    // frame is made this way since internal frame cannot be done in GridBagLayout
    private JFrame useFrame = new JFrame();
    

    // indicates whether customize ption is on or off 
    private boolean customizeOn = false;
    private GenericObject objectGroupForSwapping, swapWithObjectGroup;
    
    // triggers once when user enter external frame and resets after exit 
    private boolean externalFrameExit = false;
    
    
    
    // needed in order to alter button values 
    JPanel internalCharacterInfoPanel = null;
    
    // buttons AND text area need to be updated 
    JButton characterName = new JButton();
    JButton characterHealth = new JButton();
    JButton characterStamina = new JButton();
    JButton characterNano = new JButton();
    
    JTextArea characterStatusEffects = new JTextArea();
    
    JFrame characterDisplayFrame;
    
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    
    
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


    
    // START: SORTING INVENTORY FUNCTIONALITY FOR FRAME MENU ATTACHMENT 
    /*******************************************************************************/
    
    // ensures that each submenu has its own version of JMenuItem objects 
    public JMenuItem[] newJMenuItems(String[] menuItemNames, JMenuItem[] array)
    {
        JMenuItem[] newArray = new JMenuItem[array.length];
        
        for(int i = 0; i < array.length; i++)
        {
            // existing JItemMenu object is reset using new JItemMenu object 
            array[i] = new JMenuItem(menuItemNames[i]);
            
            // set horizontal length of menu option in pixels  
            array[i].setIconTextGap(60);
            
            // store "new" JMenuItem object in array
            newArray[i] = array[i];
        }
        
        return newArray;
    }
    
    // add specific sort options to submenus concerning specific sort by object class 
    public void addSpecificSortJMenuItems(JMenu subMenu, JMenuItem[] newJMenuItems, 
        Inventory inventory, String[] sortingTypesStringArray)
    {
        // loop through all JMenuItem objects meant to be added to submenu 
        for(int i = 0; i < newJMenuItems.length; i++)
        {
            // add line separator for menu item in submenu itself 
            subMenu.addSeparator();
            
            // set horizontal length of menu option in pixels  
            newJMenuItems[i].setIconTextGap(60);
            
            // since local variables referenced from inner class action listener
            // (in this case the array below) are not final, the assignment done 
            // outside using a local variable that will pass reference inside 
            String sortType = sortingTypesStringArray[i];
            
            // add action listener for each JMenuItem
            newJMenuItems[i].addActionListener(
                new ActionListener() 
                {
                    // variables used to activate specific sort on click
                    String classForSorting = subMenu.getText();

                    String specificSortType = sortType;

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // sort inventory according to sorting style desired 
                        inventory.specificSort(classForSorting, specificSortType);
                        
                        // update inventory objects JList to display results post sort 
                        inventoryObjectsJList.setModel(inventoryInJListFormat(inventory));
                    }
                }); 
            
            // add JMenuItem to submenu after it is set up 
            subMenu.add(newJMenuItems[i]);
        }
    }
    
    // add general sort options to submenu concerning general sort by Generic Object trait 
    public void addGeneralSortJMenuItems(JMenu subMenu, JMenuItem[] newJMenuItems, 
        Inventory inventory, String[] sortingTypesStringArray)
    {
        // loop through all JMenuItem objects meant to be added to submenu 
        for(int i = 0; i < newJMenuItems.length; i++)
        {
            // add line separator for menu item in submenu itself 
            subMenu.addSeparator();
            
            // since local variables referenced from inner class action listener
            // (in this case the array below) are not final, the assignment done 
            // outside using a local variable that will pass reference inside 
            String sortType = sortingTypesStringArray[i];
            
            // add action listener for each JMenuItem
            newJMenuItems[i].addActionListener(
                new ActionListener() 
                {
                    // variables used to activate general sort on click
                    String generalSortType = sortType;

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // sort inventory according to sorting style desired 
                        inventory.generalSort(generalSortType);
                        
                        // update inventory objects JList to display results post sort 
                        inventoryObjectsJList.setModel(inventoryInJListFormat(inventory));
                    }
                }); 
            
            // add JMenuItem to submenu after it is set up 
            subMenu.add(newJMenuItems[i]);
        }
    }
    
    // create submenu with JMenuItem options attacthed 
    public void addJMenuItemsToSubMenu(JMenu superMenu, String subMenuName, String[] 
        optionNames, JMenuItem[] options, Inventory inventory)
    {
        JMenu submenu = new JMenu(subMenuName);
        
        submenu.setIconTextGap(25);
        
        addSpecificSortJMenuItems(submenu, newJMenuItems(optionNames, options), 
            inventory, inventory.sortingTypesStrings());
        
        superMenu.add(submenu);
    }
    
    // set up specific sort with sorting options based on object class
    public void specificSortByObjectClass(JMenu superMenu, JMenu subMenu, String[] 
        optionNames, JMenuItem[] options, Inventory inventory)
    {
        String[] objectClasses = {"Item", "Core", "Weapon", "Armor", "Accessory"};
        
        for(String element : objectClasses)
        {
            addJMenuItemsToSubMenu(subMenu, element, optionNames, options, inventory);
        }
        
        superMenu.add(subMenu);
    }
    
    // menu located on top left of frame allowing for inventory sorting 
    public void sortObjectsFrameAttachment(Inventory inventory, JFrame frame)
    {
        // names for JMenuItems below representing sorting options per sorting style 
        String[] menuItemNames = {"Name", "Main Class", "Category", "Super Type", 
            "Sub Type", "Use Speed", "Buy Price", "Sell Price", "Steal Rate", 
            "Pilfer Rate", "Drop Rate", "Highest Quantity", "Lowest Quantity"};
        
        // JMenuItem objects created before methods using JMenuItem are used 
        JMenuItem sortByName = new JMenuItem();
        JMenuItem sortByMainClass = new JMenuItem();
        JMenuItem sortByCategory = new JMenuItem();
        JMenuItem sortBySuperType = new JMenuItem();
        JMenuItem sortBySubType = new JMenuItem();
        JMenuItem sortByUseSpeed = new JMenuItem();
        JMenuItem sortByBuyPrice = new JMenuItem();
        JMenuItem sortBySellPrice = new JMenuItem();
        JMenuItem sortByStealRate = new JMenuItem(); 
        JMenuItem sortByPilferRate = new JMenuItem();
        JMenuItem sortByDropRate = new JMenuItem(); 
        JMenuItem sortByHighestQuantity = new JMenuItem();
        JMenuItem sortByLowestQuantity = new JMenuItem();
        
        // JMenuItem objects placed into array to easilt use them for methods 
        JMenuItem[] menuItems = {sortByName, sortByMainClass, sortByCategory, 
            sortBySuperType, sortBySubType, sortByUseSpeed, sortByBuyPrice, 
            sortBySellPrice, sortByStealRate, sortByPilferRate, sortByDropRate, 
            sortByHighestQuantity, sortByLowestQuantity};
        
        //Create the menu bar that will be displayed on northern border of frame 
        JMenuBar menuBar = new JMenuBar();

        // build central menu holding sorting options 
        JMenu sortMenu = new JMenu("Sort");

        // set length of menu in pixels  
        sortMenu.setIconTextGap(25);
        menuBar.add(sortMenu);

        // specific sort menu with line separating option
        sortMenu.addSeparator();
        JMenu specificSort = new JMenu("Specific Sort");
        specificSort.setIconTextGap(25);
        
        // set up specific sort with options for sorting by object class 
        specificSortByObjectClass(sortMenu, specificSort, menuItemNames, menuItems, 
            inventory);
        
        // General sort option with line separating options 
        sortMenu.addSeparator();
        JMenu generalSort = new JMenu("General Sort");
        generalSort.setIconTextGap(25);
        
        // add general sort options for inventory objects 
        addGeneralSortJMenuItems(generalSort, newJMenuItems(menuItemNames, menuItems), 
            inventory, inventory.sortingTypesStrings());
        
        // add general sort option to sortMenu
        sortMenu.add(generalSort);
        
        // add menu bar for sort options to frame 
        frame.setJMenuBar(menuBar);
    }
    
    // END: SORTING INVENTORY FUNCTIONALITY FOR FRAME MENU ATTACHMENT 
    /*******************************************************************************/

    
    
    // START: UNUSABLE BUTTONS 
    /*******************************************************************************/

    public JButton newUnusableStandardButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public JButton newUnusableObjectDescriptionButton(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
        
        JButton button = new JButton(formattedText);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(buttonFont);
        
        return button;
    }
        
    // END: UNUSABLE BUTTONS 
    /*******************************************************************************/

    
    
    // START: DESCRIPTION AND FRAME AREA TITLE COMPONENTS (DEFAULT VALUES)
    /*******************************************************************************/

    public void addObjectDescriptionButton(JFrame frame)
    {
        itemDescription = newUnusableObjectDescriptionButton("Description", " ");
            addButtonComponent(itemDescription, 1, 0, 0.11, 1, 1, 0, frame);
    }
    
    public void newAreaTitle(Inventory inventory, JFrame frame)
    {
        String inventoryTitle = String.format("Inventory (Object Group Limit: %s", String.
            valueOf(inventory.getObjectGroupsLimit()) + ")");
        
        inventoryJListTitle = newUnusableStandardButton(inventoryTitle);
            addButtonComponent(inventoryJListTitle, 2, 0, 0.11, 1, 1, 2, frame);

        buttonGroupTitle = newUnusableStandardButton("General Details of Selected Object");
            addButtonComponent(buttonGroupTitle, 2, 2, 0.11, 1, 1, 1, frame);
    }
    
    // END: DESCRIPTION AND FRAME AREA TITLE COMPONENTS (DEFAULT VALUES)
    /*******************************************************************************/

    
    
    // START: OBJECT DETAILS (DEFAULT VALUES)
    /*******************************************************************************/

    public void addObjectDetailsButton(JButton button, int gridy, JFrame frame)
    {
        addButtonComponent(button, gridy, 1, 0.11, 0.11, 1, 2, frame);
    }
    
    public void objectDetailButtons(JFrame frame)
    {
        mainClass = newUnusableObjectDescriptionButton("Main Class", " ");
            addObjectDetailsButton(mainClass, 3, frame);

        category = newUnusableObjectDescriptionButton("Category", " ");
            addObjectDetailsButton(category, 4, frame);
        
        superType = newUnusableObjectDescriptionButton("Super Type", " ");
            addObjectDetailsButton(superType, 5, frame);
        
        subType = newUnusableObjectDescriptionButton("Sub Type", " ");
            addObjectDetailsButton(subType, 6, frame);
    
        useSpeed = newUnusableObjectDescriptionButton("Use Speed", " ");
            addObjectDetailsButton(useSpeed, 7, frame);
        
        buyPrice = newUnusableObjectDescriptionButton("Buy Price", " ");
            addObjectDetailsButton(buyPrice, 8, frame);
        
        sellPrice = newUnusableObjectDescriptionButton("Sell Price", " ");
            addObjectDetailsButton(sellPrice, 9, frame);
        
        dropRate = newUnusableObjectDescriptionButton("Drop Rate", " ");
            addObjectDetailsButton(dropRate, 10, frame);
    }
    
    public void resetObjectInformationButtons()
    {
        itemDescription = newUnusableObjectDescriptionButton("Description", " ");
        
        String inventoryTitle = String.format("Inventory (Object Group Limit: %s", String.
            valueOf(referenceInventory.getObjectGroupsLimit()) + ")");
        
        inventoryJListTitle = newUnusableStandardButton(inventoryTitle);
        
        mainClass = newUnusableObjectDescriptionButton("Main Class", " ");

        category = newUnusableObjectDescriptionButton("Category", " ");
        
        superType = newUnusableObjectDescriptionButton("Super Type", " ");
        
        subType = newUnusableObjectDescriptionButton("Sub Type", " ");
    
        useSpeed = newUnusableObjectDescriptionButton("Use Speed", " ");
        
        buyPrice = newUnusableObjectDescriptionButton("Buy Price", " ");
        
        sellPrice = newUnusableObjectDescriptionButton("Sell Price", " ");
        
        dropRate = newUnusableObjectDescriptionButton("Drop Rate", " ");
    }
    
    // END: OBJECT DETAILS (DEFAULT VALUES)
    /*******************************************************************************/

    
    
    // START: DISPLAY INVENTORY USING JLIST 
    /*******************************************************************************/
    
    public void addInventoryJList(JScrollPane inventoryScroll, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.10;
        gridBagConstraints.weightx = 0.10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.ipady = 125;
        
        frame.add(inventoryScroll, gridBagConstraints);
    }
    
    public void createInventoryJList(Inventory inventory, DefaultListModel<String> 
        inventoryObjects, JFrame frame)
    {
        // fill JList with contents of supplied DefaultListModel<> 
        inventoryObjectsJList = new JList<>(inventoryObjects);
        
        // The text is not messed up, it's just using a non-monospaced font so 
        // not all characters have the same width.
        inventoryObjectsJList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        inventoryObjectsJList.setVisibleRowCount(-1); // display as many rows as can be shown 
        
        // do not allow multiple selection
        inventoryObjectsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        //invetoryObjectsJList.ensureIndexIsVisible(-1);
        inventoryObjectsJList.setSelectedIndex(0); 
        
        // listener fills in object description/details upon object selection
        addJListUpdateObjectDetailsListener(inventory, inventoryObjectsJList);
        
                // add a JScrollPane enabling vertical scrolling for JList to frame 

        inventoryScroll = new JScrollPane(inventoryObjectsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        addInventoryJList(inventoryScroll, frame);
    }
    
    public DefaultListModel<String> inventoryInJListFormat(Inventory inventory)
    {
        DefaultListModel<String> invetoryObjects = new DefaultListModel<>();
        
        int counter = 1;
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            String elementAndSize = String.format("%-2d) x[%-2d] %s", counter, 
                entry.getValue().size(), entry.getKey().getName());
                    invetoryObjects.addElement(elementAndSize);
                        counter++;
        }
        
        return invetoryObjects;
    }
    
    public void displayInventoryContents(Inventory inventory, JFrame frame)
    {
        createInventoryJList(inventory, inventoryInJListFormat(inventory), frame);
    }
    
    
    
    
    
    // START: UPDATING OBJECT DESCRIPTION AND DETAILS USING JLIST
    /*******************************************************************************/
    
    public String formatDescriptionDetailsString(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
            return formattedText;
    }
    
    public void updateObjectDescriptionAndDetails(GenericObject object)
    {
        itemDescription.setText(formatDescriptionDetailsString("Description", 
            object.getBriefDescription()));
        
        mainClass.setText(formatDescriptionDetailsString("Main Class", 
            object.getMainClassString()));

        category.setText(formatDescriptionDetailsString("Category", 
            object.getCategory()));
        
        superType.setText(formatDescriptionDetailsString("Super Type", 
            object.getSuperType()));
        
        subType.setText(formatDescriptionDetailsString("Sub Type", 
            object.getSubType()));
    
        useSpeed.setText(formatDescriptionDetailsString("Use Speed", 
            String.valueOf(object.getUseSpeed())));
        
        buyPrice.setText(formatDescriptionDetailsString("Buy Price ", 
            String.valueOf(object.getBuyPrice())));
        
        sellPrice.setText(formatDescriptionDetailsString("Sell Price", 
            String.valueOf(object.getSellPrice())));
        
        dropRate.setText(formatDescriptionDetailsString("Drop Rate", 
            String.valueOf(object.getDropRate())));
    }
    
    public GenericObject getInventoryObject(Inventory inventory, Object jListObjectName)
    {
        GenericObject object = null;
        
        // Note: to get inventory name, start trimming String from character 
        //       10 since first 9 characters are not part of object's name 
        String trimmedToName = trimJListStringToName((String)jListObjectName);
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            if(trimmedToName.equals(entry.getKey().getName()))
            {
                object = entry.getKey();
            }
        }
        
        return object;
    }
    
    public String trimJListStringToName(String argument)
    {
        // convert String to character array 
        char[] array = argument.toCharArray();
        
        // create StringBuilder object meant for storing name of String 
        StringBuilder builder = new StringBuilder();
        
        // since first 9 characters are not useful for finding object name, 
        // supply 10 since we know first character of object name is there 
        for(int i = 10; i < array.length; i++)
        {
            // append characters to builder to return as String later 
            builder.append(array[i]);
        }
        
        return builder.toString();
    }
    
    // update object description/details upon change in selected value of JList 
    public void addJListUpdateObjectDetailsListener(Inventory inventory, JList jList)
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
                        // purpose of null check is to prevent null from being passed
                        // as object for info update which occurs when sorting choice
                        // is selected (sorting causes selection value of JList to be
                        // null since JList attempts to find object info from object
                        // that doesnot exist since JList info is reset and refilled 
                        // post-inventory sort)
                        if(jList.getSelectedValue() != null)
                        {
                            // use selected value of JList to get object in order to
                            // update object description/details 
                            updateObjectDescriptionAndDetails(getInventoryObject(inventory, 
                                jList.getSelectedValue()));
                        }
                    }
                }
            }
        );
    }
    
    // END: UPDATING OBJECT DESCRIPTION AND DETAILS USING JLIST
    /*******************************************************************************/

    
    
    // START: OPTIONS MENU FOR JLIST SELECTED VALUE ON CLICK
    /*******************************************************************************/

        // FOR OTHER JLIST 
    public void useActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    characterDisplayFrame = new JFrame();
                    
                    // Note: external frame may have access to already used item (item x0)
// MUST CHECK IF ITEM EXISTS (NOT NULL) IN USE ITEM METHODS 
                    Rectangle bounds = frame.getBounds();
                    
                    // calculation makes frame have location starting from bottom left of outer frame 
                    // with y-axis position based on bounds.y multiplier (in this case 1.75) and outer 
                    // multiplier (in this case 0.58); 
                    characterDisplayFrame.setLocation(bounds.x, (int)((bounds.y * 1.75 + frame.getHeight()) * 0.58));
                    
                    setUpFauxCharacterInternalFrame(referencePlayerEntity, characterDisplayFrame);
                    
                    // frame width equal to width of outer frame and height based on coder menu preference 
                    characterDisplayFrame.setSize(frame.getWidth(), (int)(0.42 * frame.getHeight()));
                    characterDisplayFrame.setVisible(true);
                }
            }); 
    }
    
    public void tossActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    referenceInventory.removeObject(getInventoryObject(referenceInventory, 
                        trimString((String)inventoryObjectsJList.getSelectedValue(), 10)));
                            inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));
                }
            }); 
    }
    
    // left off here
    public void removeAllActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    referenceInventory.removeObjectGroup(getInventoryObject(referenceInventory, 
                        trimString((String)inventoryObjectsJList.getSelectedValue(), 10)));
                            inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));
                }
            }); 
    }
    
    public void customizeActionListener(JMenuItem customize)
    {
        customize.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(!customizeOn)
                    {
                        objectGroupForSwapping = getInventoryObject(referenceInventory, 
                            inventoryObjectsJList.getSelectedValue());
                                customizeOn = true;
                    }
                    else
                    {
                        swapWithObjectGroup = getInventoryObject(referenceInventory, 
                            inventoryObjectsJList.getSelectedValue());

                        // if first object group exists in inventory then customize  
                        if(objectGroupForSwapping != null && referenceInventory.
                            getInventory().containsKey(objectGroupForSwapping))
                        {
                            // store position in inventory and reset objectGroupForSwapping
                            int objectGroupOne = referenceInventory.objectGroupPosition
                                (objectGroupForSwapping);
                                    objectGroupForSwapping = null;
                            
                            // store position in inventory and reset swapWithObjectGroup
                            int objectGroupTwo = referenceInventory.objectGroupPosition
                                (swapWithObjectGroup);
                                    swapWithObjectGroup = null;
                            
                            // customize positions of object groups within inventory 
                            referenceInventory.customize(objectGroupOne, objectGroupTwo);
                            
                            // update JList meant for displaying inventory objects 
                            inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));

                            // reset customizeOn
                            customizeOn = false;
                        }
                        // else rest instance variables used for customization 
                        else
                        {
                            objectGroupForSwapping = null;
                            swapWithObjectGroup = null;
                            customizeOn = false;
                        }
                    }
                }
            }); 
    }
    
    // Note: each popup menu needs its own object because if each popup menu
    //       refers to same object, last popup menu to add object is the only 
    //       popup menu that will have access to object 
    public void setUpPopupMenusByObject(JPopupMenu usableItem, JPopupMenu keyItem, 
        JPopupMenu nonItem)
    {
        // using item functionality 
        JMenuItem useItem = new JMenuItem("Use");
            useActionListener(useItem);
                usableItem.add(useItem);
        
        // tossing object functionality
        JMenuItem tossItem = new JMenuItem("Toss");
            tossActionListener(tossItem);
                usableItem.add(tossItem);
        
        JMenuItem tossNonItem = new JMenuItem("Toss");
            tossActionListener(tossNonItem);
                nonItem.add(tossNonItem);
        
        // removing all objects at once functionality 
        JMenuItem removeAllItems = new JMenuItem("Remove All");
            removeAllActionListener(removeAllItems);
                usableItem.add(removeAllItems);
        
        JMenuItem removeAllNonItems = new JMenuItem("Remove All");
            removeAllActionListener(removeAllNonItems);
                nonItem.add(removeAllNonItems);
        
        // if private instance variable customizeOn did not exist then each
        // popup menu would have their own versions of boolean customizeOn
        // meaning customize feature amongst objects would function weirdly 
        JMenuItem customizeItemPlacement  = new JMenuItem("Customize");
            customizeActionListener(customizeItemPlacement);
                usableItem.add(customizeItemPlacement);
        
        JMenuItem customizeKeyItemPlacement = new JMenuItem("Customize");
            customizeActionListener(customizeKeyItemPlacement);
                keyItem.add(customizeKeyItemPlacement);
        
        JMenuItem customizeNonItemPlacement = new JMenuItem("Customize");
            customizeActionListener(customizeNonItemPlacement);
                nonItem.add(customizeNonItemPlacement);
    }
    
    // shows a different popup menu filled with choices for object based on its class 
    // upon left clicking JList value with mouse 
    public void addJListObjectOptionsListener(Inventory inventory, JList jList, JPopupMenu 
        usableItem, JPopupMenu keyItem, JPopupMenu nonItem)
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
                        // store inventory object selected via JList as object in focus 
                        objectInFocus = getInventoryObject(inventory, jList.getSelectedValue());
                        
                        // differen popup menus appear depending on class of object 
                        if(objectInFocus.getClass() == Generic_Object.Item.class)
                        {
                            // cast GenericObject as an Item object since it is one  
                            Generic_Object.Item item = (Generic_Object.Item)objectInFocus;
                            
                            // different popup menu appears based on key item state 
                            if(item.getItemSuperTypeEnum() != Generic_Object.Item.
                                ItemSuperTypes.KEY_ITEM)
                            {
                                usableItem.show(jList, me.getX(), me.getY());
                            }
                            else
                            {
                                keyItem.show(jList, me.getX(), me.getY());
                            }
                        }
                        else
                        {
                            nonItem.show(jList, me.getX(), me.getY());
                        }
                    }
                }
            }
        );
    }
    
    // END: OPTIONS MENU FOR JLIST SELECTED VALUE ON CLICK
    /*******************************************************************************/

    
    
    
    
    // START: OPTIONS MENU FOR JLIST ENTRY ON CLICK
    /*******************************************************************************/
    
    // JLIST STUFF
    
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
    
    public void addPartyMemberJList(JFrame frame, JList<String> characterJList,
        int gridy, int gridx)
    {
        // set button font 
        characterJList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
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
        
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.gridwidth = 1;

        frame.add(characterJList, gridBagConstraints);
    }
    
    // JLIST STUFF
    
    
    // UPDATE CHARACTER PANEL USING JLIST VALUE
    
    public void updateCharacterPanel(GenericCharacter character)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s", character.getGeneralFeatures().getName());
            characterName.setText(formatName);
        
        // StringBuilder object used for creating text passed to button 
        StringBuilder builder = new StringBuilder();
        
        // add Health Points (HP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("HP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentHealth())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxHealth()));
        
        String formatHealth = String.format("%-26s", builder.toString());
            characterHealth.setText(formatHealth);

        // add Stamina Points (SP) and current/max points 
        builder = new StringBuilder();
        
        builder.append("SP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentStamina())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxStamina()));
        
        String formatStamina = String.format("%-26s", builder.toString());
            characterStamina.setText(formatStamina);
        
        // add Nanomachine Points (NP) and current/max points 
        builder = new StringBuilder();
        
        // NOTE: if gauge is 0, need 6 spaces else 5 spaces MAYBE
        builder.append("NP:     ").append(String.valueOf(character.getGeneralFeatures().
            getCurrentNano())).append(" / ").append(String.valueOf(character.
            getTotalStats().getTotalMaxNano()));
        
        String formatNano = String.format("%-26s", builder.toString());
            characterNano.setText(formatNano);
        
        // add text area meant for showing status effects tied to character 
        characterStatusEffects.setText(statusEffectTextAreaString(character));
    }
    
    // perform event upon change in character JList entry focus 
    public void characterJListValueChanged(JFrame externalFrame, PlayerEntity 
        entity, JList jList, ListSelectionEvent evt) 
    {
        if (!evt.getValueIsAdjusting()) 
        {
            // show chaacter infor based on String selection value
            // need to get character and pass to panel creation for frame
            // need to be able to replace center frame each time 
            
            GenericCharacter character = getPartyMember(trimCharacterName((String)
                jList.getSelectedValue()));
            
            // NEED to update panel buttons, NOT add new panels 
            updateCharacterPanel(character);
        }
    }
    
    // UPDATE CHARACTER PANEL USING JLIST VALUE
    
    
    // USE SINGLE TARGET ITEM POPUP MENU 
    
    public JPopupMenu setUpUseItemPopupMenu(JList characterJList, JFrame externalFrame)
    {
        JPopupMenu useItemPopupMenu = new JPopupMenu();
            JMenuItem useItem = new JMenuItem("Use Item");
                useItemActionListener(useItem, characterJList, externalFrame);
                    useItemPopupMenu.add(useItem);
                        return useItemPopupMenu;
    }
    
    public void useItemActionListener(JMenuItem menuItem, JList characterJList, 
        JFrame externalFrame)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    /* idea
                        create popup menu on creation time (not instance)
                        action gets item, performs item move, removes item and closes external frame 
                    */
                    
                    Item item = (Item)getInventoryObject(referenceInventory,
                        trimString((String)inventoryObjectsJList.getSelectedValue(), 10));
                    
                    GenericCharacter user = getPartyMember(trimCharacterName((String)
                        (String)characterJList.getSelectedValue()));
                    
                    GenericCharacter target = getPartyMember(trimCharacterName((String)
                        (String)characterJList.getSelectedValue()));
                    
                    item.getMove().singleTargetMove(user, target, item.getMove());
                    
                    // update inventory JList
                    referenceInventory.removeObject(item);
                        inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));
                    
                    // dispose of external frame and shift focus to frame 
                    externalFrame.dispose();
            
                    // sets original frame back into focus without closing as well
                    // since dispose closes program if no window comes after 
                    frame.setVisible(true);
                    frame.toFront();
                    frame.requestFocus();
                }
            }); 
    }
    
    public void addJListUseItemOnCharacterListener(JList jList, JPopupMenu usableItem)
    {
        // allows for events to occur upon change in JList entry focus  
        jList.addMouseListener(
            new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    // if character is clicked, show popup menu for use item 
                    if (SwingUtilities.isLeftMouseButton(me) && !jList.isSelectionEmpty()
                        && jList.locationToIndex(me.getPoint()) == jList.getSelectedIndex()) 
                    {
                        usableItem.show(jList, me.getX(), me.getY());
                    }
                }
            }
        );
    }
    
    // USE SINGLE TARGET ITEM POPUP MENU 
    
    
    public void addJListCharacterUpdatePopupListener(JFrame externalFrame, PlayerEntity 
        entity, JList jList)
    {
        // allows for events to occur upon change in JList entry focus  
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update character information displayed on JList selection change 
                    characterJListValueChanged(externalFrame, entity, jList, evt);
                    
                    // get popup menu for character with use option 
                    addJListUseItemOnCharacterListener(jList, setUpUseItemPopupMenu
                        (jList, externalFrame));
                }
            }
        );
    }
    
    public void addJListCharacterUpdateListener(JFrame externalFrame, PlayerEntity 
        entity, JList jList)
    {
        // allows for events to occur upon change in JList entry focus  
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update character information displayed on JList selection change 
                    characterJListValueChanged(externalFrame, entity, jList, evt);
                }
            }
        );
    }
    
    // JLIST STUFF
    
    
    // CHARACTER RETRIEVAL
    
    public GenericCharacter getPartyMember(String partyMemberName)
    {
        GenericCharacter character = new GenericCharacter();
        
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
    
    // CHARACTER RETRIEVAL
    
    
    // INTERNAL PANEL BUTTON SET UP 
    
    public JButton newButton(String buttonText)
    {
        // create new button to attach to internal panel 
        JButton button = new JButton(buttonText);
        
        // text will be displayed starting at furthest left of button text area 
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        // set button font 
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        //textResizesUponButtonResize(button);
        
        return button;
    }
    
    public void buttonPanelPlacement(JButton button, int gridy, int gridx, 
        JPanel panel)
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
        
        gridBagConstraints.ipady = 70;
        
        panel.add(button, gridBagConstraints);
    }
    
    public String statusEffectTextAreaString(GenericCharacter character)
    {
        StringBuilder builder = new StringBuilder("  Status Effects: ");
        
        int counter = 0;
        
        for(StatusEffect status : character.getStatusEffectContainer().getStatusEffects())
        {
            if(1 == character.getStatusEffectContainer().getStatusEffects().size())
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

    public JTextArea newTextArea()
    {
        JTextArea textArea = new JTextArea();
        
        textArea.setBackground(Color.BLACK);
        
        textArea.setForeground(Color.WHITE);
        
        textArea.setEditable(false);
        
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        return textArea;
    }
    
    public void statusEffectTextAreaPlacement(JTextArea textArea, int gridy, 
        int gridx, JPanel panel)
    {
        // add first text area 
        JScrollPane scroll = new JScrollPane(textArea, 
            JScrollPane.VERTICAL_SCROLLBAR_NEVER,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.ipady = 95;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) (- value incrases border)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        panel.add(scroll, gridBagConstraints);
    }
    
    // INTERNAL PANEL BUTTON SET UP 
    
    
    // ADDING INTERNAL PANEL TO DISPLAY CHARACTER INFO
    
    //SINGLE target items ONLY (need diff panel for multiple)
    public JPanel addInternalJPanelForCharacterInfo()
    {
        // panel will hold several buttons 
        JPanel internalPanel = new JPanel();
        
        // set layout for internal panel as GridBagLayout 
        internalPanel.setLayout(new GridBagLayout());
        
        characterName = newButton("Name: ");
            buttonPanelPlacement(characterName, 0, 0, internalPanel);
        
        characterHealth = newButton("Health: ");
            buttonPanelPlacement(characterHealth, 1, 0, internalPanel);
        
        characterStamina = newButton("Stamina: ");
            buttonPanelPlacement(characterStamina, 2, 0, internalPanel);
        
        characterNano = newButton("Nano: ");
            buttonPanelPlacement(characterNano, 3, 0, internalPanel);
        
        characterStatusEffects = newTextArea();
            statusEffectTextAreaPlacement(characterStatusEffects, 4, 0, internalPanel);
        
        return internalPanel;
    }
    
    public void internalJPanelPlacement(JFrame frame, JPanel internalPanel)
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
        gridBagConstraints.weighty = 0.8;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.8;
        
        frame.add(internalPanel, gridBagConstraints);
    }
    
    // ADDING INTERNAL PANEL TO DISPLAY CHARACTER INFO
    
    
    
    
    // single target moves or moves where player can pick who is affected 
    public boolean controlledTargetMove(Moves move)
    {
        Moves.Targets[] array = {Moves.Targets.ANY, Moves.Targets.ANY_EXCEPT_USER,
            Moves.Targets.ANY_PARTY_MEMBER, Moves.Targets.ANY_OPPOSING_PARTY_MEMBER};
        
        boolean result = false;
        
        for(Moves.Targets element : array)
        {
            if(move.getTargetEnum() == element)
            {
                result = true;
            }
        }
        
        return result;
    }
    
    // includes multiple target moves and random moves performed via button
    public boolean uncontrolledTargetsMove(Moves move)
    {
        Moves.Targets[] array = {Moves.Targets.ANY_PARTY, Moves.Targets.USER_PARTY,
            Moves.Targets.OPPOSING_PARTY, Moves.Targets.RANDOM_ANY, Moves.Targets.RANDOM_ANY_EXCEPT_USER,
            Moves.Targets.RANDOM_ANY_PARTY_MEMBER, Moves.Targets.RANDOM_ANY_OPPOSING_PARTY_MEMBER,
            Moves.Targets.RANDOM_ANY_PARTY, Moves.Targets.RANDOM_ALL, Moves.Targets.ALL,
            Moves.Targets.ALL_EXCEPT_USER};
        
        boolean result = false;
        
        for(Moves.Targets element : array)
        {
            if(move.getTargetEnum() == element)
            {
                result = true;
            }
        }
        
        return result;
    }
    
    public void addUseItemOnMultipleTargetsListener(JButton button, JList characterJList,
        JFrame externalFrame)
    {
        // allows for events to occur upon change in JList entry focus  
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    /* idea (unique no stipulation unlike non item moves)
                        need to obtain item cuurrently selected in object jList
                        and store item as item
                        use item target type to perform action using switch case
                            if this, then do this...
                        after move is performed, remove item and refresh object JList
                    */
                    
                    Item item = (Item)getInventoryObject(referenceInventory,
                        trimString((String)inventoryObjectsJList.getSelectedValue(), 10));

                    SecureRandom rand = new SecureRandom();
                    
                    int randomNumber = rand.nextInt(characterJList.getModel().getSize());
                    
                    int counter = 0;
                    
                    switch(item.getMove().getTargetEnum())
                    {
                        // Note: use single move method and for loops if needed 
                        
                        // since one party (player party), supply all characters 
                        case ANY_PARTY:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        // since one party (player party), supply all characters 
                        case USER_PARTY:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        // since one party (player party), supply all characters 
                        case OPPOSING_PARTY:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        // from 0 to size of character JList length, pick character at random
                        // and perform single move on character 
                        case RANDOM_ANY:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                if(counter == randomNumber)
                                {
                                    item.getMove().singleTargetMove(character, character, item.getMove());
                                }
                                
                                counter++;
                            }
                                break;
                        case RANDOM_ANY_EXCEPT_USER:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                if(counter == randomNumber)
                                {
                                    item.getMove().singleTargetMove(character, character, item.getMove());
                                }
                                
                                counter++;
                            }
                                break;
                        case RANDOM_ANY_PARTY_MEMBER:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                if(counter == randomNumber)
                                {
                                    item.getMove().singleTargetMove(character, character, item.getMove());
                                }
                                
                                counter++;
                            }
                                break;
                        case RANDOM_ANY_OPPOSING_PARTY_MEMBER:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                if(counter == randomNumber)
                                {
                                    item.getMove().singleTargetMove(character, character, item.getMove());
                                }
                                
                                counter++;
                            }
                                break;
                        case RANDOM_ANY_PARTY:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        case RANDOM_ALL:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        case ALL:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                item.getMove().singleTargetMove(character, character, item.getMove());
                            }
                                break;
                        case ALL_EXCEPT_USER:
                            for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
                            {
                                if(counter != randomNumber)
                                {
                                    item.getMove().singleTargetMove(character, character, item.getMove());
                                }
                                
                                counter++;
                            }
                                break;
                    }
                    
                    // update inventory JList
                    referenceInventory.removeObject(item);
                        inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));

                    // dispose of external frame and shift focus to frame 
                    externalFrame.dispose();

                    // sets original frame back into focus without closing as well
                    // since dispose closes program if no window comes after 
                    frame.setVisible(true);
                    frame.toFront();
                    frame.requestFocus();
                }
            }
        );
        
    }
    
    public void addUseItemOnMultipleTargetsButton(JList characterJList, JFrame externalFrame)
    {
        JButton button = new JButton("Use Item");
        
        // set button font 
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        addUseItemOnMultipleTargetsListener(button, characterJList, externalFrame);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = 2;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.3;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.3;
        
        externalFrame.add(button, gridBagConstraints);
    }
    
    // external frame made to look like internal frame for displaying characters 
    public void setUpFauxCharacterInternalFrame(PlayerEntity entity, JFrame externalFrame)
    {
        /* idea: jlist of characters on left and info on right (like on main menu)
            ability to update character stuff after item is used so player can see results 
            stuff: jlist, jpanel, border layout 
        */
        
        externalFrame.setLayout(new GridBagLayout());
        
        Item item = (Item)getInventoryObject(referenceInventory,
            trimString((String)inventoryObjectsJList.getSelectedValue(), 10));
        
        JList partyMemberJList = new JList(partyMembersInJListFormat(entity));
        
        addPartyMemberJList(externalFrame, partyMemberJList, 0, 0);
        
        internalJPanelPlacement(externalFrame, addInternalJPanelForCharacterInfo());
        
        // if item is single target, account for multiple targets 
        if(controlledTargetMove(item.getMove()))
        {
            addJListCharacterUpdatePopupListener(externalFrame, entity, partyMemberJList);
            
            // initialize list and panel in frame
                partyMemberJList.setSelectedIndex(1);
                partyMemberJList.setSelectedIndex(0);
        }
        else
        {
            addJListCharacterUpdateListener(externalFrame, entity, partyMemberJList);
            
            // initialize list and panel in frame
                partyMemberJList.setSelectedIndex(1);
                partyMemberJList.setSelectedIndex(0);
            
            // add button signifying use item (NO POPUP MENU)
            addUseItemOnMultipleTargetsButton(partyMemberJList, externalFrame);
        }
    }
    
    
s
    
    
    
    // START: OBJECT INFORMATION USING JLIST STRING 
    /*******************************************************************************/
    
    public String formatDescriptionDetailsString(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
            return formattedText;
    }
    
    public void updateObjectDescriptionAndDetails(GenericObject object)
    {
        itemDescription.setText(formatDescriptionDetailsString("Description", 
            object.getBriefDescription()));
        
        mainClass.setText(formatDescriptionDetailsString("Main Class", 
            object.getMainClassString()));

        category.setText(formatDescriptionDetailsString("Category", 
            object.getCategory()));
        
        superType.setText(formatDescriptionDetailsString("Super Type", 
            object.getSuperType()));
        
        subType.setText(formatDescriptionDetailsString("Sub Type", 
            object.getSubType()));
    
        useSpeed.setText(formatDescriptionDetailsString("Use Speed", 
            String.valueOf(object.getUseSpeed())));
        
        buyPrice.setText(formatDescriptionDetailsString("Buy Price ", 
            String.valueOf(object.getBuyPrice())));
        
        sellPrice.setText(formatDescriptionDetailsString("Sell Price", 
            String.valueOf(object.getSellPrice())));
        
        dropRate.setText(formatDescriptionDetailsString("Drop Rate", 
            String.valueOf(object.getDropRate())));
    }
    

    // END: OBJECT INFORMATION USING JLIST STRING 
    /*******************************************************************************/

    
    
    // START: OBJECT DETAILS 
    /*******************************************************************************/

    public JButton newUnusableInventoryDescriptionButton(String text, String appendText)
    {
        String formattedText = String.format("%-24s: %s", text, appendText);
        
        JButton button = new JButton(formattedText);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        // The text is not messed up, it's just using a non-monospaced font so 
        // not all characters have the same width.
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        return button;
    }
    
    public void addInventoryDetailsButton(JButton button, int gridy, JFrame frame)
    {
        addButtonComponent(button, gridy, 0, 0.11, 1, 1, 1, frame);
    }
    
    public void inventoryDetailsButtons(Inventory inventory, JFrame frame)
    {
        itemGroupMaxSize = newUnusableInventoryDescriptionButton("Item Group Max Size", 
            String.valueOf(inventory.getItemGroupMaxSize()));
                addInventoryDetailsButton(itemGroupMaxSize, 6, frame);

        coreGroupMaxSize = newUnusableInventoryDescriptionButton("Core Group Max Size", 
           String.valueOf(inventory.getCoreGroupMaxSize()));
            addInventoryDetailsButton(coreGroupMaxSize, 7, frame);
        
        weaponGroupMaxSize = newUnusableInventoryDescriptionButton("Weapon Group Max Size", 
            String.valueOf(inventory.getWeaponGroupMaxSize()));
            addInventoryDetailsButton(weaponGroupMaxSize, 8, frame);
        
        armorGroupMaxSize = newUnusableInventoryDescriptionButton("Armor Group Max Size", 
            String.valueOf(inventory.getArmorGroupMaxSize()));
            addInventoryDetailsButton(armorGroupMaxSize, 9, frame);
    
        accessoryGroupMaxSize = newUnusableInventoryDescriptionButton("Accesory Group Max Size", 
            String.valueOf(inventory.getAccessoryGroupMaxSize()));
            addInventoryDetailsButton(accessoryGroupMaxSize, 10, frame);
    }
    
    // END: OBJECT DETAILS 
    /*******************************************************************************/

    
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
        
        // use party entity to store references to player entity and inventory
        PlayerEntityFactory entity = new PlayerEntityFactory();
            referencePlayerEntity = entity.getPlayerEntityExample();
                referenceInventory = entity.getPlayerEntityExample().getInventory();
        
        // buttons that do something upon click (go to main menu)
        addUsableButtons(frame);
        
        // button for object description
        addObjectDescriptionButton(frame);
        
        // add button with text signifying column theme
        newAreaTitle(referenceInventory, frame);
        
        // buttons containing details tied to object selected 
        objectDetailButtons(frame);
        
        // popup menus meant to appear upon clicking an inventory object 
        setUpPopupMenusByObject(usableItemPopupMenu, unusableItemPopupMenu,
            nonItemPopupMenu);
        
        // JList meant to show object contained in player inventory 
        displayInventoryContents(referenceInventory, frame);
        
        // buttons that show information relating to inventory itself 
        inventoryDetailsButtons(referenceInventory, frame);
        
        // updates object information related buttons and shows popup menus 
        addJListItemOptionsListener(referenceInventory, inventoryObjectsJList, 
            usableItemPopupMenu, keyItemPopupMenu, nonItemPopupMenu);
        
        // drop down menu can sort player inventory in a predefined way 
        sortObjectsFrameAttachment(referenceInventory, frame);
        
        // since JList selection value has not been set (which means object 
        // description/details are not set yet either), set information for
        // first object by selecting index 1 (if index exists) then index 0
        // since just setting JList index 0 does not update object details  
        inventoryObjectsJList.setSelectedIndex(1);
        inventoryObjectsJList.setSelectedIndex(0);
        
        // display frame window accordingly 
        displayFrameWindow();
    }
}
