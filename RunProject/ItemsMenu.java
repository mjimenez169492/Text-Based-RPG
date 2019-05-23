package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Move_Creation.StatusEffect;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;
import Generic_Object.Item;
import Move_Creation.Moves;
import Move_Creation.MoveCalculations;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.security.SecureRandom;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class ItemsMenu extends CommonGUIMethods
{
    // frame meant to store components in a desired layout 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // store JFrame that originally called frame of this class to return to it later 
    private JFrame callingFrame = new JFrame();
    
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    private Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    
    // usable button meant to bring player back to main menu 
    private JButton mainMenu;
    
    // different parts of the frame 
    private JButton objectDescription, buttonGroupTitle, inventoryJListTitle;
    
    // inventory information about current and max number of specified groups 
    private JButton itemGroupInfo, coreGroupInfo, weaponGroupInfo, armorGroupInfo, 
        accessoryGroupInfo;
    
    // buttons used for presenting object details to player 
    private JButton mainClass, category, superType, subType, useSpeed, buyPrice, 
        sellPrice, dropRate;
    
    // vertical padding used to make components larger to avoid gaps upon frame stretch
    int buttonVerticalPadding = 55;
    
    // store object player wants to use on party 
    private GenericObject objectSelectedForUseFrame;
    
    // JList GUI component used to present objects stored in player inventory 
    private JList<String> inventoryObjectsJList;
    
    // popup menus meant to appear based on class of selected GenericObject and 
    // other requirements such as SuperType() 
    private JPopupMenu usableItemPopupMenu = new JPopupMenu();
    private JPopupMenu unusableItemPopupMenu = new JPopupMenu();
    private JPopupMenu keyItemPopupMenu = new JPopupMenu();
    private JPopupMenu nonItemPopupMenu = new JPopupMenu();
    
    // stores reference to inventory of player for easy access 
    private Inventory referenceInventory;
    
    // stores reference to player entity object for easy access 
    private PlayerEntity referencePlayerEntity;
    
    // external frame used to allow player to use an item on a character or party 
    // Note: external frame is used over an internal frame since an internal frame
    //       cannot be properly displayed in a frame/panel using GridBagLayout for
    //       the components already in place may obscure it 
    private JFrame useFrame = new JFrame();

    // indicates whether customize option is on or off 
    // Note: if private instance variable customizeOn did not exist, each popup 
    //       menu would have to have their own versions of boolean customizeOn 
    //       to enable the customization feature which would not work properly
    //       since player would have to track which customizeOn was on or off 
    private boolean customizeOn = false;
    
    // stores objects used to swap object groups in inventory 
    private GenericObject objectGroupForSwapping, swapWithObjectGroup;
    
    // keeps track of whether external use frame is active or not 
    private boolean useFrameActive = false;
    
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
                        // dispose of Items Menu frame and external frame
                        frame.dispose();
                        useFrame.dispose();

                        // return focus to frame that orginally called Main Menu 
                        displayFrameWindow(callingFrame);
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

    public JButton newUnusableStandardButton(JButton button, String text)
    {
        button = new JButton(text);
        
        // gun metal blue color in hexadecimal 
        button.setBackground(Color.decode("#4d5461"));
        
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

    public String formatCurrentMaxValues(int currentValue, int maximumValue,
        String specialCharacter)
    {
        String curValue = String.valueOf(currentValue);
        
        String maxValue = String.valueOf(maximumValue);
        
        StringBuilder builder = new StringBuilder();
        
        // spaces are used to make current value Strings appear alligned 
        if(currentValue < 10)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(curValue).append(specialCharacter);
        
        // spaces are used to make max value Strings appear alligned 
        if(maximumValue < 10)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(maxValue);
        
        return builder.toString();
    }
    
    public void addObjectDescriptionButton(JFrame frame)
    {
        objectDescription = newUnusableObjectDescriptionButton("Description", " ");
            addButtonComponent(objectDescription, 1, 0, 0.11, 1, 1, 0, frame);
    }
    
    public void newAreaTitle(Inventory inventory, JFrame frame)
    {
        String inventoryTitle = String.format("%-16s (%s)", "Inventory", 
            formatCurrentMaxValues(inventory.getInventory().size(), 
            inventory.getObjectGroupsLimit(), " / "));
        
        inventoryJListTitle = newUnusableStandardButton(inventoryJListTitle, inventoryTitle);
            addButtonComponent(inventoryJListTitle, 2, 0, 0.11, 1, 1, 2, frame);

        buttonGroupTitle = newUnusableStandardButton(buttonGroupTitle, "General Details of Selected Object");
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
    
    public void resetObjectDescriptionDetailsButtons()
    {
        objectDescription = newUnusableObjectDescriptionButton("Description", " ");
        
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
    
    public void displayInventoryAsJList(Inventory inventory, JFrame frame)
    {
        // fill JList with contents of DefaultListModel<String> object
        inventoryObjectsJList = new JList<>(inventoryInJListFormat(inventory));
        
        // make JList use monospaced font so all characters have the same width
        inventoryObjectsJList.setFont(JListFont);

        // do not allow for multiple selection (i.e. selecting more than 1 row)
        inventoryObjectsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        // since JList selection value has not been set (which means object 
        // description/details are not set yet either), set information for
        // first object by selecting index 1 (if index exists) then index 0
        // since just setting JList index 0 does not update object details  
        inventoryObjectsJList.setSelectedIndex(1);
        inventoryObjectsJList.setSelectedIndex(0);
        
        // listener fills in object description/details upon object selection
        addJListUpdateObjectDetailsListener(inventory, inventoryObjectsJList);
        
        // add JScrollPane to frame to enable vertical scrolling for JList  
        JScrollPane inventoryScroll = new JScrollPane(inventoryObjectsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        addInventoryJList(inventoryScroll, frame);
    }
    
    // returns model that JList will use to display inventory objects 
    public DefaultListModel<String> inventoryInJListFormat(Inventory inventory)
    {
        DefaultListModel<String> inventoryObjectsModel = new DefaultListModel<>();
        
        int counter = 1;
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            // String contains inventory position of object, size of object group,
            // and name of object starting at character 10
            // Note: position and size are formatted to account for double digits 
            String positionSizeAndName = String.format("%-2d) x[%-2d] %s", counter, 
                entry.getValue().size(), entry.getKey().getName());
            
            inventoryObjectsModel.addElement(positionSizeAndName);
            
            counter++;
        }
        
        // update inventory details as inventory JList is reloaded 
        updateInventoryInformation(inventory);
        
        return inventoryObjectsModel;
    }
    
    // END: DISPLAY INVENTORY USING JLIST 
    /*******************************************************************************/
    
    
    
    // START: UPDATING OBJECT DESCRIPTION AND DETAILS USING JLIST
    /*******************************************************************************/
    
    public String formatDescriptionDetailsString(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
            return formattedText;
    }
    
    public void updateObjectDescriptionAndDetails(GenericObject object)
    {
        objectDescription.setText(formatDescriptionDetailsString("Description", 
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

    
    
    // START: INVENTORY DETAILS 
    /*******************************************************************************/
    
    public JButton newUnusableInventoryDescriptionButton()
    {
        JButton button = new JButton();
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setFont(buttonFont);
        
        return button;
    }
    
    public void addInventoryDetailsButton(JButton button, int gridy, JFrame frame)
    {
        addButtonComponent(button, gridy, 0, 0.11, 1, 1, 1, frame);
    }
    
    public void inventoryDetailsButtons(Inventory inventory, JFrame frame)
    {
        itemGroupInfo = newUnusableInventoryDescriptionButton();
            addInventoryDetailsButton(itemGroupInfo, 6, frame);

        coreGroupInfo = newUnusableInventoryDescriptionButton();
            addInventoryDetailsButton(coreGroupInfo, 7, frame);
        
        weaponGroupInfo = newUnusableInventoryDescriptionButton();
            addInventoryDetailsButton(weaponGroupInfo, 8, frame);
        
        armorGroupInfo = newUnusableInventoryDescriptionButton();
            addInventoryDetailsButton(armorGroupInfo, 9, frame);
    
        accessoryGroupInfo = newUnusableInventoryDescriptionButton();
            addInventoryDetailsButton(accessoryGroupInfo, 10, frame);
    }
    
    // need to update inventory stuff on model reload 
    public void updateInventoryInformation(Inventory inventory)
    {
        // update title for area
        inventoryJListTitle.setText(String.format("%-8s (%s)", "Inventory", 
            formatCurrentMaxValues(inventory.getInventory().size(), 
            inventory.getObjectGroupsLimit(), "/")));
        
        // Note: distance from first " to ( is 9 characters for consistency
        
        // set item group info 
        itemGroupInfo.setText(String.format("%-9s %s: %s", "Item", "(TTL - STK LMT)", 
            formatCurrentMaxValues(inventory.getTotalNumberOfItemObjects(), 
            inventory.getItemGroupMaxSize(), " - ")));
        
        // set core group info 
        coreGroupInfo.setText(String.format("%-9s %s: %s", "Core", "(TTL - STK LMT)", 
            formatCurrentMaxValues(inventory.getTotalNumberOfCoreObjects(), 
            inventory.getCoreGroupMaxSize(), " - ")));
        
        // set weapon group info 
        weaponGroupInfo.setText(String.format("%-9s %s: %s", "Weapon", "(TTL - STK LMT)", 
            formatCurrentMaxValues(inventory.getTotalNumberOfWeaponObjects(), 
            inventory.getWeaponGroupMaxSize(), " - ")));
        
        // set armor group info 
        armorGroupInfo.setText(String.format("%-9s %s: %s", "Armor", "(TTL - STK LMT)", 
            formatCurrentMaxValues(inventory.getTotalNumberOfArmorObjects(), 
            inventory.getArmorGroupMaxSize(), " - ")));
        
        // set accessory group info 
        accessoryGroupInfo.setText(String.format("%-9s %s: %s", "Accessory", "(TTL - STK LMT)", 
            formatCurrentMaxValues(inventory.getTotalNumberOfAccessoryObjects(), 
            inventory.getAccessoryGroupMaxSize(), " - ")));
    }
    
    // END: INVENTORY DETAILS 
    /*******************************************************************************/

    
    
        // START: OPTIONS MENU FOR JLIST SELECTED VALUE ON CLICK
    /*******************************************************************************/
    
    // ACTIONLISTENERS FOR POPUPMENU OPTIONS 
    
    // update object description/details and inventory object group count upon toss 
    public void shiftToNextExistingObject(JList inventoryJList, int lastObjectGroupPosition)
    {
        // account for when no object exists first
        if(inventoryJList.getModel().getSize() == 0)
        {
            resetObjectDescriptionDetailsButtons();
        }
        // move forward or backward until another object is found FROM position last
        // occupied by tossed object group (if possible)
        else
        {
            // if attempts to update object info using object at supplied position
            if(lastObjectGroupPosition < inventoryJList.getModel().getSize())
            {
                // get object at designated location and update object information
                updateObjectDescriptionAndDetails(getInventoryObject(referenceInventory,
                    inventoryJList.getModel().getElementAt(lastObjectGroupPosition)));
                
                // set selected index to be position of last object group - 1 since 
                // inventory positions range from 0 to (inventory.size() - 1)
                inventoryJList.setSelectedIndex(lastObjectGroupPosition - 1);
            }
            // move backward to position (inventoryJList.getModel().getSize() - 1) to 
            // display next object that exists to account for when an object at position 
            // inventoryJList.getModel().getSize() is removed 
            else
            {
                // get object at designated location and update object information
                updateObjectDescriptionAndDetails(getInventoryObject(referenceInventory,
                    inventoryJList.getModel().getElementAt(inventoryJList.getModel().getSize() - 1)));
                
                // set selected index to be position of inventoryJList.getModel().getSize() - 1 since 
                // inventory positions range from 0 to (inventory.size() - 1)
                inventoryJList.setSelectedIndex(inventoryJList.getModel().getSize() - 1);
            }
        }
    }
    
    public void useActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Note: if statement prevents creation of infinite use frames 
                    // dispose of external frame if it is active before creating new one
                    // and reset indicator useFrameActive 
                    if(useFrameActive)
                    {
                        useFrame.dispose();
                        useFrameActive = false;
                    }
                    
                    // use frame is reset each time use option is selected (this is
                    // better than creating new JFrames each time "Use" is selected)
                    useFrame = new JFrame();
                    
                    // indicate that new use frame is active
                    useFrameActive = true;
                    
                    // use location properties of first frame to position use frame
                    Rectangle bounds = frame.getBounds();
                    
                    // calculation makes frame have location starting from bottom left 
                    // of outer frame with y-axis position based on bounds.y multiplier 
                    // (in this case 1.75) and outer multiplier (in this case 0.58); 
                    useFrame.setLocation(bounds.x, (int)((bounds.y * 1.75 + frame.
                        getHeight()) * 0.58));
                    
                    // set up components for use frame so player can use it 
                    setUpUseFrame(referencePlayerEntity, useFrame);
                    
                    // use frame width equal to width of original frame and while height 
                    // is calculated using original frame height as point of reference 
                    useFrame.setSize(frame.getWidth(), (int)(0.42 * frame.getHeight()));
                    useFrame.setVisible(true);
                    
                    // Note: useFrame is NOT set to exit on close since doing so will 
                    //       cause the program to terminate early (disposing original
                    //       frame will dispose of this frame as well (Maybe?))
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
                    // store inventory size before item is removed 
                    int inventorySizePreRemoval = referenceInventory.getInventory()
                        .size();
                    
                    // store object to impove readability later on 
                    GenericObject object = getInventoryObject(referenceInventory, 
                        inventoryObjectsJList.getSelectedValue());
                    
                    // store position of object group within inventory
                    int lastObjectGroupPosition = referenceInventory.objectGroupPosition(object);
                    
                    // remove single instance of object player selected via inventory display JList
                    referenceInventory.removeObject(object);
                    
                    // reload contents of JList using inventory 
                    inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));
                    
                    // account for object information display buttons upon object toss 
                    // if object group is removed upon use shift to next object 
                    if(inventorySizePreRemoval != referenceInventory.getInventory()
                        .size())
                    {
                        shiftToNextExistingObject(inventoryObjectsJList, 
                            lastObjectGroupPosition);
                    }
                }
            }); 
    }
    
    public void removeAllActionListener(JMenuItem menuItem)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // store inventory size before item is removed 
                    int inventorySizePreRemoval = referenceInventory.getInventory()
                        .size();
                    
                    // store object to impove readability later on 
                    GenericObject object = getInventoryObject(referenceInventory, 
                        inventoryObjectsJList.getSelectedValue());
                    
                    // store position of object group within inventory
                    int lastObjectGroupPosition = referenceInventory.objectGroupPosition(object);
                    
                    // remove object group player selected via inventory display JList
                    referenceInventory.removeObjectGroup(object);
                    
                    // reload contents of JList using inventory 
                    inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));
                    
                    // account for object information display buttons upon object group
                    // removal if object group is removed upon use shift to next object 
                    if(inventorySizePreRemoval != referenceInventory.getInventory()
                        .size())
                    {
                        shiftToNextExistingObject(inventoryObjectsJList, 
                            lastObjectGroupPosition);
                    }
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
                    // if customize option is false (as in not chosen), then make it
                    // true and store object group meant for swapping 
                    if(!customizeOn)
                    {
                        objectGroupForSwapping = getInventoryObject(referenceInventory, 
                            inventoryObjectsJList.getSelectedValue());
                                customizeOn = true;
                    }
                    // else customize option is true and swap operation with second 
                    // object group is made alongside instance variable reset 
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
    
    // ACTIONLISTENERS FOR POPUPMENU OPTIONS 
    
    
    
    // ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU 
    
    // holds types of action listeners JMenuItems can have for popupMenu
    public enum ActionListeners
    {
        USE_ITEM, TOSS, REMOVE_ALL, CUSTOMIZE;
    }
    
    // switch case is used to add appropriate action listener to JMenuItem 
    public void addActionListenerToJMenuItem(ActionListeners choice, JMenuItem menuItem)
    {
        switch(choice)
        {
            case USE_ITEM:
                useActionListener(menuItem);
                    break;
            case TOSS:
                tossActionListener(menuItem);
                    break;
            case REMOVE_ALL:
                removeAllActionListener(menuItem);
                    break;
            case CUSTOMIZE:
                customizeActionListener(menuItem);
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
    
    // add same option to mulitple popup menus at once using var args 
    public void addPopupMenuJMenuItem(ActionListeners choice, String jMenuItemName,
        JPopupMenu...popupMenus)
    {
        for(JPopupMenu element : popupMenus)
        {
            addPopupMenuJMenuItem(element, jMenuItemName, choice);
        }
    }
    
    // Note: each popup menu needs its own object because if each popup menu
    //       refers to same object, last popup menu to add object is the only 
    //       popup menu that will have access to object 
    public void setUpPopupMenusByObject(JPopupMenu usableItem, JPopupMenu unusableItem,
        JPopupMenu keyItem, JPopupMenu nonItem)
    {
        // using item functionality 
        addPopupMenuJMenuItem(ActionListeners.USE_ITEM, "Use", usableItem);
        
        // tossing object functionality
        addPopupMenuJMenuItem(ActionListeners.TOSS, "Toss", usableItem, unusableItem,
            nonItem);
        
        // removing all objects at once functionality 
        addPopupMenuJMenuItem(ActionListeners.REMOVE_ALL, "Remove All", usableItem, 
            unusableItem, nonItem);
        
        // personally customizing position of object groups in inventory 
        addPopupMenuJMenuItem(ActionListeners.CUSTOMIZE, "Customize", usableItem, 
            unusableItem, keyItem, nonItem);
    }
    
    // shows a different popup menu filled with choices for object based on its class 
    // upon left clicking JList value with mouse 
    public void addJListObjectOptionsListener(Inventory inventory, JList jList, JPopupMenu 
        usableItem, JPopupMenu unusableItem, JPopupMenu keyItem, JPopupMenu nonItem)
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
                        GenericObject object = getInventoryObject(inventory, jList.getSelectedValue());
                        
                        // differen popup menus appear depending on class of object 
                        if(object.getClass() == Generic_Object.Item.class)
                        {
                            // cast GenericObject as an Item object since it is one  
                            Generic_Object.Item item = (Generic_Object.Item)object;
                            
                            // different popup menu appears based on key item state 
                            if(item.getItemSuperTypeEnum() != Generic_Object.Item.
                                ItemSuperTypes.KEY_ITEM && item.getItemSuperTypeEnum() 
                                != Generic_Object.Item.ItemSuperTypes.MISCELLANEOUS)
                            {
                                usableItem.show(jList, me.getX(), me.getY());
                            }
                            else if(item.getItemSuperTypeEnum() == Generic_Object.Item.
                                ItemSuperTypes.KEY_ITEM)
                            {
                                keyItem.show(jList, me.getX(), me.getY());
                            }
                            else
                            {
                                // miscellaneous objects are unusable 
                                unusableItem.show(jList, me.getX(), me.getY());
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
    
    // ADDING JMENUITEM OBJECTS REPRESENTING OBJECT OPTIONS TO POPUPMENU 
    
    // END: OPTIONS MENU FOR JLIST SELECTED VALUE ON CLICK
    /*******************************************************************************/

    
    
    // START: OPTIONS MENU FOR JLIST ENTRY ON CLICK
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
    
    public void addPartyMemberJList(JList partyMemberJList, int gridy, int gridx, 
        JFrame frame)
    {
        // set JList text font 
        partyMemberJList.setFont(JListFont);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = gridx;
        
        // specified column length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.25;
        
        // specified row length component takes up (2/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.25;
        
        // width is 1 column 
        gridBagConstraints.gridwidth = 1;

        frame.add(partyMemberJList, gridBagConstraints);
    }
    
    // PARTY MEMBER JLIST WITH JSCROLLPANE FUNCTIONALITY
    
    
    
    // UPDATE CHARACTER PANEL FOR EXTERNAL FRAME USING JLIST VALUE
    
    public void updateCharacterPanel(GenericCharacter character)
    {
        // format so all names up to 26 characters are correctly structured 
        String formatName = String.format("%-26s", character.getGeneralFeatures().getName());
            characterName.setText(formatName);
        
        // add Health Points (HP) and current/max points 
        String health = String.format("%-6s: %s", "HP", formatCurrentMaxGauges(character.
            getGeneralFeatures().getCurrentHealth(), character.getTotalStats().getTotalMaxHealth()));
                characterHealth.setText(health);

        // add Stamina Points (SP) and current/max points 
        String stamina = String.format("%-6s: %s", "SP", formatCurrentMaxGauges(character.
            getGeneralFeatures().getCurrentStamina(), character.getTotalStats().getTotalMaxStamina()));
                characterStamina.setText(stamina);
           
        // add Nanomachine Points (NP) and current/max points
        String nano = String.format("%-6s: %s", "NP", formatCurrentMaxGauges(character.
            getGeneralFeatures().getCurrentNano(), character.getTotalStats().getTotalMaxNano()));
                characterNano.setText(nano);
        
        // add text area meant for showing status effects tied to character 
        characterStatusEffects.setText(statusEffectTextAreaString(character));
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
    
    // UPDATE CHARACTER PANEL FOR EXTERNAL FRAME USING JLIST VALUE
    
    
    
    // USE SINGLE TARGET ITEM POPUP MENU FOR CHARACTER JLIST
    
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
                    // if object exists in inventory then proceed else dispose of external frame 
                    if(referenceInventory.getInventory().containsKey(objectSelectedForUseFrame))
                    {
                        // store inventory size before item is removed 
                        int inventorySizePreRemoval = referenceInventory.getInventory()
                            .size();
                        
                        // store position of object group within inventory
                        int lastObjectGroupPosition = referenceInventory.objectGroupPosition
                            (objectSelectedForUseFrame);
                        
                        // cast GenericObject object as the Item object it is
                        Item item = (Item)objectSelectedForUseFrame;
                        
                        // create user and target character references for item move
                        GenericCharacter user = getPartyMember(characterJList.
                            getSelectedValue());
                        GenericCharacter target = getPartyMember(characterJList.
                            getSelectedValue());

                        // perform item move on target by supplying item move info 
                        new MoveCalculations().singleTargetMoveLogic(user, target, item.getMove());
                        
                        // remove object from inventory using instance variable 
                        referenceInventory.removeObject(objectSelectedForUseFrame);
                        
                        // update inventory JList using inventory post object removal
                        inventoryObjectsJList.setModel(inventoryInJListFormat
                            (referenceInventory));

                        // if object group is removed upon use shift to next object 
                        if(inventorySizePreRemoval != referenceInventory.getInventory()
                            .size())
                        {
                            shiftToNextExistingObject(inventoryObjectsJList, 
                                lastObjectGroupPosition);
                        }
                        
                        // dispose of external frame and shift focus to original frame 
                        externalFrame.dispose();
                        
                        // Note: dispose closes program if no window frame comes after 
                        frame.requestFocus();
                    }
                    else
                    {
                        // dispose of external frame and shift focus to original frame 
                        externalFrame.dispose();
                        
                        // Note: dispose closes program if no window frame comes after 
                        frame.requestFocus();
                    }
                }
            }); 
    }
    
    public void addCharacterJListUseItemListener(JList jList, JPopupMenu usableItem)
    {
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
    
    // USE SINGLE TARGET ITEM POPUP MENU FOR CHARACTER JLIST

    
    
    // CHARACTER JLIST LISTENERS UPDATE PANEL AND DISPLAY POPUP MENU
    
    // update character panel in external frame using JList selected value 
    public void characterJListValueChanged(JFrame externalFrame, PlayerEntity 
        entity, JList jList, ListSelectionEvent evt) 
    {
        if (!evt.getValueIsAdjusting()) 
        {
            updateCharacterPanel(getPartyMember(jList.getSelectedValue()));
        }
    }
    
    // listener used for single target items ONLY
    public void addCharacterJListUpdatePopupListener(JFrame externalFrame, PlayerEntity 
        entity, JList jList)
    {
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update character information displayed on JList selection change 
                    characterJListValueChanged(externalFrame, entity, jList, evt);
                    
                    // get popup menu for character with use item option 
                    addCharacterJListUseItemListener(jList, setUpUseItemPopupMenu
                        (jList, externalFrame));
                }
            }
        );
    }
    
    // listener used for multiple target items ONLY (use item via button)
    public void addCharacterJListUpdateListener(JFrame externalFrame, PlayerEntity 
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
    
    // CHARACTER JLIST LISTENERS UPDATE PANEL AND DISPLAY POPUP MENU
    
    
    
    // INTERNAL PANEL COMPONENT HELPERS 
    
    public JButton unusablePanelButton(String buttonText)
    {
        // create new button to attach to internal panel 
        JButton button = new JButton(buttonText);
        
        // text will be displayed starting at furthest left of button text area 
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        // set button font 
        button.setFont(buttonFont);
        
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
        
        gridBagConstraints.ipady = 110;
        
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

    public JTextArea newUnusablePanelTextArea()
    {
        JTextArea textArea = new JTextArea();
        
        textArea.setBackground(Color.BLACK);
        
        textArea.setForeground(Color.WHITE);
        
        textArea.setEditable(false);
        
        textArea.setFont(buttonFont);
        
        return textArea;
    }
    
    public void statusEffectTextAreaPlacement(JTextArea textArea, int gridy, 
        int gridx, JPanel panel)
    {
        // add text area with horizontal scroll capability only 
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
        gridBagConstraints.ipady = 125;
        
        panel.add(scroll, gridBagConstraints);
    }
    
    // INTERNAL PANEL COMPONENT HELPERS 
    
    
    
    // ADDING PANEL TO EXTERNAL FRAME TO DISPLAY CHARACTER INFO
    
    // DEFAULT values for new buttons meant to be placed in panel 
    public JPanel addSingleTargetPanelForCharacterInfo()
    {
        // panel will hold several buttons 
        JPanel panel = new JPanel();
        
        // set layout for internal panel as GridBagLayout 
        panel.setLayout(new GridBagLayout());
        
        characterName = unusablePanelButton("Name: ");
            buttonPanelPlacement(characterName, 0, 0, panel);
        
        characterHealth = unusablePanelButton("Health: ");
            buttonPanelPlacement(characterHealth, 1, 0, panel);
        
        characterStamina = unusablePanelButton("Stamina: ");
            buttonPanelPlacement(characterStamina, 2, 0, panel);
        
        characterNano = unusablePanelButton("Nano: ");
            buttonPanelPlacement(characterNano, 3, 0, panel);
        
        characterStatusEffects = newUnusablePanelTextArea();
            statusEffectTextAreaPlacement(characterStatusEffects, 4, 0, panel);
        
        return panel;
    }
    
    public void panelPlacementInExternalFrame(JFrame frame, JPanel internalPanel)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = 1;
        
        // specified column length component takes up (7/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.70;
        
        // specified row length component takes up (7/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.70;
        
        frame.add(internalPanel, gridBagConstraints);
    }
    
    // ADDING PANEL TO EXTERNAL FRAME TO DISPLAY CHARACTER INFO
    
    
    
    // DICTATING PANEL TYPE SHOWN USING MOVE TARGET PROPERTY 
    
    // single target moves or moves where player can pick who is affected (popup)
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
    
    // multiple target moves and random moves where target cannot be chosen (button)
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
    
    // DICTATING PANEL TYPE SHOWN USING MOVE TARGET PROPERTY 
    
    
    
    // USING ITEM ON MULTIPLE TARGETS 
    
    public void affectAllTargets(Moves move)
    {
        for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
        {
            new MoveCalculations().singleTargetMoveLogic(character, character, move);
        }
    }
    
    public void affectRandomTarget(int counter, int randomNumber, Moves move)
    {
        for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
        {
            if(counter == randomNumber)
            {
                new MoveCalculations().singleTargetMoveLogic(character, character, move);
            }

            counter++;
        }
    }
    
    public void affectAllRandomly(Moves move)
    {
        SecureRandom rand = new SecureRandom();
        
        for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
        {
            if((rand.nextInt(100) + 1) > 50)
            {
                new MoveCalculations().singleTargetMoveLogic(character, character, move);
            }
        }
    }
    
    public void affectAllExceptUser(int counter, int randomNumber, Moves move)
    {
        for(GenericCharacter character : referencePlayerEntity.getParty().getPartyMembers())
        {
            if(counter != randomNumber)
            {
                new MoveCalculations().singleTargetMoveLogic(character, character, move);
            }
            
            counter++;
        }
    }
    
    public void performItemMove(JList characterJList, Item item)
    {
        Moves move = item.getMove();
        
        SecureRandom rand = new SecureRandom();
        
        int randomNumber = rand.nextInt(characterJList.getModel().getSize());

        int counter = 0;
        
        switch(move.getTargetEnum())
        {
            // Note: use single move method and for loops if needed 

            // since one party (player party), supply all characters 
            case ANY_PARTY:
                affectAllTargets(move);
                    break;
            case USER_PARTY:
                affectAllTargets(move);
                    break;
            case OPPOSING_PARTY:
                affectAllTargets(move);
                    break;
            // from 0 to character JList size, pick character at random and
            // perform single move on character 
            case RANDOM_ANY:
                affectRandomTarget(counter, randomNumber, move);
                    break;
            case RANDOM_ANY_EXCEPT_USER:
                affectRandomTarget(counter, randomNumber, move);
                    break;
            case RANDOM_ANY_PARTY_MEMBER:
                affectRandomTarget(counter, randomNumber, move);
                    break;
            case RANDOM_ANY_OPPOSING_PARTY_MEMBER:
                affectRandomTarget(counter, randomNumber, move);
                    break;
            // target player party since it is the only party 
            case RANDOM_ANY_PARTY:
                affectAllTargets(move);
                    break;
            // target characters with move that has 50% chance of landing 
            case RANDOM_ALL:
                affectAllRandomly(move);
                    break;
            // target player party since only characters available 
            case ALL:
                affectAllTargets(move);
                    break;
            // target all characters except for one of them 
            case ALL_EXCEPT_USER:
                affectAllExceptUser(counter, randomNumber, move);
                    break;
        }
    }
    
    public void addMultipleTargetsUseItemActionListener(JButton button, JList characterJList,
        JFrame externalFrame)
    {
        button.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // if object for use frame exists then proceed else dispose of use frame
                    if(referenceInventory.getInventory().containsKey(objectSelectedForUseFrame))
                    {
                        // store inventory size before item is removed 
                        int inventorySizePreRemoval = referenceInventory.getInventory()
                            .size();
                        
                        // store position of object group within inventory
                        int lastObjectGroupPosition = referenceInventory.objectGroupPosition
                            (objectSelectedForUseFrame);
                        
                        // cast GenericObject object as the Item object it is
                        Item item = (Item)objectSelectedForUseFrame;

                        // perform the item move on multiple characters 
                        performItemMove(characterJList, item);

                        // remove object from inventory using instance variable 
                        referenceInventory.removeObject(objectSelectedForUseFrame);
                        
                        // update inventory JList using inventory post object removal
                        inventoryObjectsJList.setModel(inventoryInJListFormat
                            (referenceInventory));

                        // if object group is removed upon use shift to next object 
                        if(inventorySizePreRemoval != referenceInventory.getInventory()
                            .size())
                        {
                            shiftToNextExistingObject(inventoryObjectsJList, 
                                lastObjectGroupPosition);
                        }
                        
                        // dispose of external frame and shift focus to original frame 
                        externalFrame.dispose();

                        // Note: dispose closes program if no window frame comes after 
                        frame.setVisible(true);
                        frame.toFront();
                        frame.requestFocus();
                    }
                    else
                    {
                        // dispose of external frame and shift focus to original frame 
                        externalFrame.dispose();
                        
                        // Note: dispose closes program if no window frame comes after 
                        frame.requestFocus();
                    }
                }
            }
        );
        
    }
    
    // USING ITEM ON MULTIPLE TARGETS 

    
    
    // USE ITEM ON MULTIPLE TARGETS BUTTON 
    
    public void addMultipleTargetsUseItemButton(JList characterJList, JFrame externalFrame)
    {
        JButton button = new JButton("Use Item");
        
        // set button font 
        button.setFont(buttonFont);
        
        // add use item on multiple targets functionality for button 
        addMultipleTargetsUseItemActionListener(button, characterJList, externalFrame);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 0;
        
        // column of specified row position
        gridBagConstraints.gridx = 2;
        
        // specified column length component takes up (3/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.3;
        
        // specified row length component takes up (3/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.3;
        
        externalFrame.add(button, gridBagConstraints);
    }
    
    // frame created upon clicking option "Use" from item popup menu which 
    // features party member information and item usage capability  
    public void setUpUseFrame(PlayerEntity entity, JFrame externalFrame)
    {
        // external layout has same layout as original frame for consistency
        externalFrame.setLayout(new GridBagLayout());
        
        // store object selected to be used via use option in popup menu 
        objectSelectedForUseFrame = getInventoryObject(referenceInventory, 
            inventoryObjectsJList.getSelectedValue());
        
        // cast GenericObject object as the Item object it is 
        Item item = (Item)objectSelectedForUseFrame;
        
        // store party members as values for character displaying JList
        JList partyMemberJList = new JList(partyMembersInJListFormat(entity));
        
        // add JList to external frame
        addPartyMemberJList(partyMemberJList, 0, 0, externalFrame);
        
        panelPlacementInExternalFrame(externalFrame, addSingleTargetPanelForCharacterInfo());
        
        // if item is single target, account for multiple targets 
        if(controlledTargetMove(item.getMove()))
        {
            // listener updates panel and has a popup menu display on click
            addCharacterJListUpdatePopupListener(externalFrame, entity, partyMemberJList);
            
            // make panel display information about character in first slot
            partyMemberJList.setSelectedIndex(1);
            partyMemberJList.setSelectedIndex(0);
        }
        else
        {
            // listener updates panel but does not have a popup menu display on click
            addCharacterJListUpdateListener(externalFrame, entity, partyMemberJList);
            
            // make panel display information about character in first slot
            partyMemberJList.setSelectedIndex(1);
            partyMemberJList.setSelectedIndex(0);
            
            // add button signifying use item (NO POPUP MENU)
            addMultipleTargetsUseItemButton(partyMemberJList, externalFrame);
        }
    }
    
    // USE ITEM ON MULTIPLE TARGETS BUTTON 
    
    // END: OPTIONS MENU FOR JLIST ENTRY ON CLICK
    /*******************************************************************************/

    
    
    public ItemsMenu(JFrame mainMenuFrame, PlayerEntity entity)
    {
        // store main menu frame to call it later 
        callingFrame = mainMenuFrame;
        
        // designate layout used for Items menu frame 
        frame.setLayout(new GridBagLayout());
        
        // use party entity to store references to player entity and inventory
        referencePlayerEntity = entity;
        referenceInventory = entity.getInventory();
        
        // buttons that do something upon click (go to main menu)
        addUsableButtons(frame);
        
        // button for object description
        addObjectDescriptionButton(frame);
        
        // add button with text signifying column theme
        newAreaTitle(referenceInventory, frame);
        
        // buttons that show information relating to inventory itself 
        inventoryDetailsButtons(referenceInventory, frame);
        
        // buttons containing details tied to object selected 
        objectDetailButtons(frame);
        
        // popup menus meant to appear upon clicking an inventory object 
        setUpPopupMenusByObject(usableItemPopupMenu, unusableItemPopupMenu, 
            keyItemPopupMenu, nonItemPopupMenu);
        
        // JList meant to show object contained in player inventory 
        displayInventoryAsJList(referenceInventory, frame);
        
        // updates object information related buttons and shows popup menus 
        addJListObjectOptionsListener(referenceInventory, inventoryObjectsJList, 
            usableItemPopupMenu, unusableItemPopupMenu, keyItemPopupMenu, 
            nonItemPopupMenu);
        
        // drop down menu can sort player inventory in a predefined way 
        sortObjectsFrameAttachment(referenceInventory, frame);
        
        // since JList selection value has not been set (which means object 
        // description/details are not set yet either), set information for
        // first object by selecting index 1 (if index exists) then index 0
        // since just setting JList index 0 does not update object details  
        inventoryObjectsJList.setSelectedIndex(1);
        inventoryObjectsJList.setSelectedIndex(0);
        
        // display frame window accordingly 
        displayFrameWindow(frame);
    }
}
