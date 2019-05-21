package RunProject;

import Player_Entity.PlayerEntity;
import Generic_Character.GenericCharacter;
import Battle_Feature.LevelMechanics;
import Object_Factories.PlayerEntityFactory;
import Player_Entity.PartyWallet;
import Move_Creation.StatusEffect;
import Generic_Object.GenericObject;
import Player_Entity.Inventory;

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
    private JButton mainMenu, sort;
    
    private JButton itemDescription, buttonGroupTitle, inventoryJListTitle;
    
    private JButton mainClass, category, superType, subType, useSpeed, buyPrice, 
        sellPrice, dropRate;
    
    private JButton itemGroupMaxSize, coreGroupMaxSize, weaponGroupMaxSize, 
        armorGroupMaxSize, accessoryGroupMaxSize;
    
    int buttonVerticalPadding = 55;
    
    private JList<String> inventoryObjectsJList;
    
    private JScrollPane inventoryScroll;
    
    private Inventory referenceInventory;
    
    // frame is made this way since internal frame cannot be done in GridBagLayout
    private JFrame useFrame = new JFrame();
    
    // menu that shows up upon clicking an item or non-item object (key item or other)
    private JPopupMenu usableItemPopupMenu = new JPopupMenu();
    
    private JPopupMenu keyItemPopupMenu = new JPopupMenu();
    
    private JPopupMenu nonItemPopupMenu = new JPopupMenu();
    
    // indicates whether customize ption is on or off 
    private boolean customizeOn = false;
    
        private GenericObject objectGroupForSwapping = null;
        private GenericObject swapWithObjectGroup = null;
    
    
    
    private JMenuBar menuBar;
    
    private JMenu sortMenu, specificSort, generalSort;
    
    private JMenu item, core, weapon, armor, accessory;
    private String[] menuItemNames = {"Name", "Main Class", "Category", "Super Type", 
        "Sub Type", "Use Speed", "Buy Price", "Sell Price", "Steal Rate", 
        "Pilfer Rate", "Drop Rate", "Highest Quantity", "Lowest Quantity"};
        private JMenuItem sortByName = new JMenuItem();
        private JMenuItem sortByMainClass = new JMenuItem();
        private JMenuItem sortByCategory = new JMenuItem();
        private JMenuItem sortBySuperType = new JMenuItem();
        private JMenuItem sortBySubType = new JMenuItem();
        private JMenuItem sortByUseSpeed = new JMenuItem();
        private JMenuItem sortByBuyPrice = new JMenuItem();
        private JMenuItem sortBySellPrice = new JMenuItem();
        private JMenuItem sortByStealRate = new JMenuItem(); 
        private JMenuItem sortByPilferRate = new JMenuItem();
        private JMenuItem sortByDropRate = new JMenuItem(); 
        private JMenuItem sortByHighestQuantity = new JMenuItem();
        private JMenuItem sortByLowestQuantity = new JMenuItem();
        
        JMenuItem[] menuItems = {sortByName, sortByMainClass, sortByCategory, 
            sortBySuperType, sortBySubType, sortByUseSpeed, sortByBuyPrice, 
            sortBySellPrice, sortByStealRate, sortByPilferRate, sortByDropRate, 
            sortByHighestQuantity, sortByLowestQuantity};
        
        JMenuItem menuItem;
    
    
    
    // START: ADDING BUTTON COMPONENTS 
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
    
    // END: ADDING BUTTON COMPONENTS 
    /*******************************************************************************/

    
    
    // START: USABLE BUTTONS 
    /*******************************************************************************/
    
    public JButton newUsableButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        return button;
    }
    
    public void usableButtonPlacement(JButton button, int loopCount, JFrame frame)
    {
        addButtonComponent(button, 0, loopCount, 0.11, 0.33, 1, 1, frame);
    }
    
    public void addUsableButtons(JFrame frame)
    {
        mainMenu = newUsableButton("Main Menu");
            usableButtonPlacement(mainMenu, 0, frame);
        sort = newUsableButton("Sort");
            usableButtonPlacement(sort, 2, frame);
        
        //usableButtonsActionsListeners(mainMenu, use, sort);
    }
    
    // END: USABLE BUTTONS 
    /*******************************************************************************/

    
    
    // START: ACTION LISTENERS FOR USABLE BUTTONS 
    /*******************************************************************************/

    public void usableButtonsActionsListeners(JButton mainMenu, JButton use,
        JButton sort)
    {
        mainMenu.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        sort.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //
            }
        }); 
        
        
    }
    
    // END: ACTION LISTENERS FOR USABLE BUTTONS 
    /*******************************************************************************/

    
    
    // START: SORTING INVENTORY FUNCTIONALITY 
    /*******************************************************************************/

    public JMenuItem[] newJMenuItems(String[] menuItemNames, JMenuItem...array)
    {
        JMenuItem[] newArray = new JMenuItem[array.length];
        
        for(int i = 0; i < array.length; i++)
        {
            array[i] = new JMenuItem(menuItemNames[i]);
                newArray[i] = array[i];
        }
        
        return newArray;
    }
    
    public void addSpecificSortJMenuItems(JMenu mainMenu, JMenuItem[] newJMenuItems, 
        Inventory inventory, String[] sortingTypesStringArray)
    {
        for(int i = 0; i < newJMenuItems.length; i++)
        {
            // add line separator for menu item in submenu itself 
            mainMenu.addSeparator();
            
            // since local variables referenced from inner class action listener
            // (in this case the array below) are not final, the assignment done 
            // outside using a local variable that will pass reference inside 
            String sortType = sortingTypesStringArray[i];
            
            // add action listener for each JMenuItem
            newJMenuItems[i].addActionListener(
                new ActionListener() 
                {
                    String classForSorting = mainMenu.getText();

                    String specificSortType = sortType;

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // sort inventory 
                        inventory.specificSort(classForSorting, specificSortType);
                            inventoryObjectsJList.setModel(inventoryInJListFormat(inventory));
                    }
                }); 
            
            mainMenu.add(newJMenuItems[i]);
        }
    }
    
    public void addGeneralSortJMenuItems(JMenu mainMenu, JMenuItem[] newJMenuItems, 
        Inventory inventory, String[] sortingTypesStringArray)
    {
        for(int i = 0; i < newJMenuItems.length; i++)
        {
            // add line separator for menu item in submenu itself 
            mainMenu.addSeparator();
            
            // since local variables referenced from inner class action listener
            // (in this case the array below) are not final, the assignment done 
            // outside using a local variable that will pass reference inside 
            String sortType = sortingTypesStringArray[i];
            
            // add action listener for each JMenuItem
            newJMenuItems[i].addActionListener(
                new ActionListener() 
                {
                    String generalSortType = sortType;

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // sort inventory 
                        inventory.generalSort(generalSortType);
                            inventoryObjectsJList.setModel(inventoryInJListFormat(inventory));
                    }
                }); 
            
            mainMenu.add(newJMenuItems[i]);
        }
    }
    
    public void initializeSort(Inventory inventory, JFrame frame)
    {
        //Create the menu bar that will be displayed on northern border of frame 
        menuBar = new JMenuBar();

            // build central menu holding sorting options 
            sortMenu = new JMenu("Sort");
            
            // set length of menu in pixels  
            sortMenu.setIconTextGap(20);
            menuBar.add(sortMenu);
            
            // specific sort option with line separating options 
            sortMenu.addSeparator();
            specificSort = new JMenu("Specific Sort");

                item = new JMenu("Item");
                    addSpecificSortJMenuItems(item, newJMenuItems(menuItemNames, menuItems), 
                        inventory, inventory.sortingTypesStrings());
                            specificSort.add(item);
                
                core = new JMenu("Core");
                    addSpecificSortJMenuItems(core, newJMenuItems(menuItemNames, menuItems), 
                        inventory, inventory.sortingTypesStrings());
                            specificSort.add(core);
                    
                weapon = new JMenu("Weapon");
                    addSpecificSortJMenuItems(weapon, newJMenuItems(menuItemNames, menuItems), 
                        inventory, inventory.sortingTypesStrings());
                            specificSort.add(weapon);
                
                armor = new JMenu("Armor");
                    addSpecificSortJMenuItems(armor, newJMenuItems(menuItemNames, menuItems), 
                        inventory, inventory.sortingTypesStrings());
                            specificSort.add(armor);
                
                accessory = new JMenu("Accessory");
                    addSpecificSortJMenuItems(accessory, newJMenuItems(menuItemNames, menuItems), 
                        inventory, inventory.sortingTypesStrings());
                            specificSort.add(accessory);
        
            // add menu for sorting objects by class in a specific way 
            sortMenu.add(specificSort);
            
            // General sort option with line separating options 
            sortMenu.addSeparator();
            generalSort = new JMenu("General Sort");
                addGeneralSortJMenuItems(generalSort, newJMenuItems(menuItemNames, menuItems), 
                    inventory, inventory.sortingTypesStrings());
                        sortMenu.add(generalSort);
                
        frame.setJMenuBar(menuBar);
    }
    
    // END: SORTING INVENTORY FUNCTIONALITY 
    /*******************************************************************************/

    
    
    // START: UNUSABLE BUTTONS 
    /*******************************************************************************/

    public JButton newUnusableStandardButton(String text)
    {
        JButton button = new JButton(text);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        return button;
    }
    
    public JButton newUnusableObjectDescriptionButton(String text, String appendText)
    {
        String formattedText = String.format("%-11s: %s", text, appendText);
        
        JButton button = new JButton(formattedText);
        
        button.setBackground(Color.BLACK);
        
        button.setForeground(Color.WHITE);
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        // The text is not messed up, it's just using a non-monospaced font so 
        // not all characters have the same width.
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
        return button;
    }
        
    // END: UNUSABLE BUTTONS 
    /*******************************************************************************/

    
    
    // START: DESCRIPTION AND FRAME AREA TITLES 
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
    
    // END: DESCRIPTION AND FRAME AREA TITLES 
    /*******************************************************************************/

    
    
    // START: OBJECT DETAILS 
    /*******************************************************************************/

    public void addObjectDetailsButton(JButton button, int gridy, JFrame frame)
    {
        addButtonComponent(button, gridy, 1, 0.11, 0.11, 1, 2, frame);
    }
    
    
    
    
    
    
    // NEED TO RESET DESCRIPTION AND DETAILS TO DEFAULT IF INVENTORY IS EMPTY
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
    
    // END: OBJECT DETAILS 
    /*******************************************************************************/

    
    
    // START: INVENTORY AS JLIST 
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
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        gridBagConstraints.ipady = 125;
        
        // add a JScrollPane containing JList to frame 
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
        addJListInventoryUpdateListener(inventory, inventoryObjectsJList);
        
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
    
    // perform event upon change in JList entry focus 
    public void inventoryObjectsJListValueChanged(Inventory inventory, ListSelectionEvent evt) 
    {
        if (!inventoryObjectsJList.getValueIsAdjusting()) 
        {
            // prevents null being passed upon sort completion
            if(inventoryObjectsJList.getSelectedValue() != null)
            {
                // use String of object name currently highlighted in JList to 
                // update object description and object details 
                updateObjectDescriptionAndDetails(getInventoryObject(inventory, trimString(
                    (String)inventoryObjectsJList.getSelectedValue(), 10)));
            }
        }
    }
    
    public void addJListItemOptionsListener(Inventory inventory, JList jList, JPopupMenu 
        usableItem, JPopupMenu keyItem, JPopupMenu nonItem)
    {
        // allows for events to occur upon change in JList entry focus  
        jList.addMouseListener(
            new MouseAdapter() 
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    // if evt object is item, show pop menu for item else do nothing 
                    // if right mouse button clicked and list selection is not empty
                    // and clicked point is inside selected item bounds
                    if (SwingUtilities.isLeftMouseButton(me) && !jList.isSelectionEmpty()
                        && jList.locationToIndex(me.getPoint()) == jList.getSelectedIndex()) 
                    {
                        GenericObject object = getInventoryObject(inventory, trimString((String)jList.
                            getSelectedValue(), 10));
                        
            // MUST NOT BE ABLE TO TOSS KEY ITEMS
                        // pop up menu for Item object ONLY
                        // if evt object is item, show pop menu for item else do nothing 
                        if(object.getClass() == Generic_Object.Item.class)
                        {
                            Generic_Object.Item item = (Generic_Object.Item)object;
                            
                            if(item.getItemSuperTypeEnum() != Generic_Object.Item.ItemSuperTypes.KEY_ITEM)
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
    
    public void addJListInventoryUpdateListener(Inventory inventory, JList jList)
    {
        // allows for events to occur upon change in JList entry focus  
        jList.addListSelectionListener(
            new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent evt) 
                {
                    // update object information upon JList selection change 
                    inventoryObjectsJListValueChanged(inventory, evt);
                }
            }
        );
    }
    
    // MouseAdapter extended to avoid overriding unused methods 
    private class MouseHandler extends MouseAdapter 
    {
        // handle event when mouse exits area
        @Override
        public void mouseExited(MouseEvent event)
        {
            useFrame.dispose();
            
            // sets original frame back into focus without closing as well
            // since dispose closes program if no window comes after 
            frame.setVisible(true);
            frame.toFront();
            frame.requestFocus();
            frame.requestFocus();
        }
    }
    
    // END: INVENTORY AS JLIST 
    /*******************************************************************************/

    
    // START: OPTIONS MENU FOR JLIST ENTRY ON CLICK
    /*******************************************************************************/

    public void useActionListener(JMenuItem menuItem, JFrame characterDisplayFrame)
    {
        menuItem.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    characterDisplayFrame.addMouseListener(new MouseHandler());
                    
                    Rectangle bounds = frame.getBounds();
                    
                    // calculation makes frame have location starting from bottom left of outer frame 
                    // with y-axis position based on bounds.y multiplier (in this case 1.75) and outer 
                    // multiplier (in this case 0.58); 
                    characterDisplayFrame.setLocation(bounds.x, (int)((bounds.y * 1.75 + frame.getHeight()) * 0.58));
                    
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
                            trimString((String)inventoryObjectsJList.getSelectedValue(), 10));
                                customizeOn = true;
                    }
                    else
                    {
                        swapWithObjectGroup = getInventoryObject(referenceInventory, 
                            trimString((String)inventoryObjectsJList.getSelectedValue(), 10));

                        // if first object group still exists in inventory 
                        if(objectGroupForSwapping != null && referenceInventory.getInventory().containsKey(objectGroupForSwapping))
                        {
                            int objectGroupOne = referenceInventory.objectGroupPosition(objectGroupForSwapping);
                            int objectGroupTwo = referenceInventory.objectGroupPosition(swapWithObjectGroup);

                            objectGroupForSwapping = null;
                            swapWithObjectGroup = null;

                            referenceInventory.customize(objectGroupOne, objectGroupTwo);

                            inventoryObjectsJList.setModel(inventoryInJListFormat(referenceInventory));

                            customizeOn = false;
                        }
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
    
    public void setUpItemMenu(JFrame characterDisplayFrame)
    {
        // each popup menu needs its own object because if each popup menu
        // refers to same object, the last popup menu to add the object is
        // the only popup menu that will have the object 
        JMenuItem useItem = new JMenuItem("Use");
            useActionListener(useItem, characterDisplayFrame);
                usableItemPopupMenu.add(useItem);
        
        JMenuItem tossItem = new JMenuItem("Toss");
            tossActionListener(tossItem);
                usableItemPopupMenu.add(tossItem);
        JMenuItem tossNonItem = new JMenuItem("Toss");
            tossActionListener(tossNonItem);
                nonItemPopupMenu.add(tossNonItem);
        
        JMenuItem removeAllItems = new JMenuItem("Remove All");
            removeAllActionListener(removeAllItems);
                usableItemPopupMenu.add(removeAllItems);
        JMenuItem removeAllNonItems = new JMenuItem("Remove All");
            removeAllActionListener(removeAllNonItems);
                nonItemPopupMenu.add(removeAllNonItems);
        
        // if private instance variable customizeOn did not exist then each
        // popup menu would have their own versions of boolean customizeOn
        // meaning customize feature amongst objects would function weirdly 
        JMenuItem customizeItemPlacement  = new JMenuItem("Customize");
            customizeActionListener(customizeItemPlacement);
                usableItemPopupMenu.add(customizeItemPlacement);
        JMenuItem customizeKeyItemPlacement = new JMenuItem("Customize");
            customizeActionListener(customizeKeyItemPlacement);
                keyItemPopupMenu.add(customizeKeyItemPlacement);
        JMenuItem customizeNonItemPlacement = new JMenuItem("Customize");
            customizeActionListener(customizeNonItemPlacement);
                nonItemPopupMenu.add(customizeNonItemPlacement);
    }
        
    // END: OPTIONS MENU FOR JLIST ENTRY ON CLICK
    /*******************************************************************************/

    
    
    
    // START: OBJECT INFORMATION USING JLIST STRING 
    /*******************************************************************************/
    
    /* idea: handshakes 
        use string returned from set JList focus thing to get object from inventory 
            from string, parse out name of object, and use enhanced for loop to go 
            through keys of inventory (TreeMap) until a key has the same name
                when match is found, return that object and use it to fill in the 
                slots for object details INCLUDING description button
    */
    
    public String formatDescriptionDetailsString(String text, String appendText)
    {
        // trim String based on character length of String as precaution 
        StringBuilder builder = new StringBuilder();
        
        if(appendText.length() > 45)
        {
            builder.append(trimString(appendText, 45));
        }
        else
        {
            builder.append(appendText);
        }
        
        String formattedText = String.format("%-11s: %s", text, builder.toString());
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
    
    public GenericObject getInventoryObject(Inventory inventory, String jListObjectName)
    {
        GenericObject object = null;
        
        for(Map.Entry<GenericObject, ArrayList<GenericObject>> entry : inventory.
            getInventory().entrySet())
        {
            if(jListObjectName.equals(entry.getKey().getName()))
            {
                object = entry.getKey();
            }
        }
        
        return object;
    }
    
    public String trimString(String argument, int startingPosition)
    {
        // convert String to character array 
        char[] array = argument.toCharArray();
        
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
        
        

        addUsableButtons(frame);
        
        
        
        addObjectDescriptionButton(frame);
        
        // party as list (display)
        PlayerEntityFactory entity = new PlayerEntityFactory();
        
        referenceInventory = entity.getPlayerEntityExample().getInventory();
        
        newAreaTitle(referenceInventory, frame);
        
        objectDetailButtons(frame);
        
        
        /* idea for inventory display ONLY (itemName x#)
            show stuff using stringBuilder 
                selection will refer to party inventory stuff using String to 
                match namr of key object 
        */
        
        setUpItemMenu(useFrame);
        
        displayInventoryContents(referenceInventory, frame);
        
        inventoryDetailsButtons(referenceInventory, frame);
        
        addJListItemOptionsListener(referenceInventory, inventoryObjectsJList, 
            usableItemPopupMenu, keyItemPopupMenu, nonItemPopupMenu);
        
        
        initializeSort(referenceInventory, frame);
        
        // set object details so they are shown immediately for first element 
        inventoryObjectsJList.setSelectedIndex(1);
        inventoryObjectsJList.setSelectedIndex(0);
        
        displayFrameWindow();
    }
    
    
    
}
