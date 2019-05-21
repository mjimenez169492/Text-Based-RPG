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




public class ItemsMenu 
{
    private JButton mainMenu, use, sort;
    
    private JButton itemDescription, buttonGroupTitle, inventoryJListTitle;
    
    private JButton mainClass, category, superType, subType, useSpeed, buyPrice, 
        sellPrice, dropRate;
    
    private JButton itemGroupMaxSize, coreGroupMaxSize, weaponGroupMaxSize, 
        armorGroupMaxSize, accessoryGroupMaxSize;
    
    int buttonVerticalPadding = 55;
    
    private JList<String> invetoryObjectsJList;
    
    
    
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
        use = newUsableButton("Use");
            usableButtonPlacement(use, 1, frame);
        sort = newUsableButton("Sort");
            usableButtonPlacement(sort, 2, frame);
        
        usableButtonsActionsListeners(mainMenu, use, sort);
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
        
        use.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // combo box?
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
    
    public void newAreaTitle(Inventory inventory)
    {
        buttonGroupTitle = newUnusableStandardButton("Object Details");
            addButtonComponent(buttonGroupTitle, 2, 0, 0.11, 1, 1, 2, frame);
        
        String inventoryTitle = String.format("Inventory (Object Groups Limit: %s", String.
            valueOf(inventory.getObjectGroupsLimit()) + ")");
        
        inventoryJListTitle = newUnusableStandardButton(inventoryTitle);
            addButtonComponent(inventoryJListTitle, 2, 2, 0.11, 1, 1, 1, frame);
    }
    
    // END: DESCRIPTION AND FRAME AREA TITLES 
    /*******************************************************************************/

    
    
    // START: OBJECT DETAILS 
    /*******************************************************************************/

    public void addObjectDetailsButton(JButton button, int gridy, int gridx, JFrame frame)
    {
        addButtonComponent(button, gridy, gridx, 0.11, 1, 1, 2, frame);
    }
    
    public void objectDetailButtons(JFrame frame)
    {
        mainClass = newUnusableObjectDescriptionButton("Main Class", " ");
            addObjectDetailsButton(mainClass, 3, 0, frame);

        category = newUnusableObjectDescriptionButton("Category", " ");
            addObjectDetailsButton(category, 4, 0, frame);
        
        superType = newUnusableObjectDescriptionButton("Super Type", " ");
            addObjectDetailsButton(superType, 5, 0, frame);
        
        subType = newUnusableObjectDescriptionButton("Sub Type", " ");
            addObjectDetailsButton(subType, 6, 0, frame);
    
        useSpeed = newUnusableObjectDescriptionButton("Use Speed", " ");
            addObjectDetailsButton(useSpeed, 7, 0, frame);
        
        buyPrice = newUnusableObjectDescriptionButton("Buy Price", " ");
            addObjectDetailsButton(buyPrice, 8, 0, frame);
        
        sellPrice = newUnusableObjectDescriptionButton("Sell Price", " ");
            addObjectDetailsButton(sellPrice, 9, 0, frame);
        
        dropRate = newUnusableObjectDescriptionButton("Drop Rate", " ");
            addObjectDetailsButton(dropRate, 10, 0, frame);
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.10;
        gridBagConstraints.weightx = 0.10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.gridwidth = 1;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        
        // add a JScrollPane containing JList to frame 
        frame.add(inventoryScroll, gridBagConstraints);
    }
    
    public void createInventoryJList(Inventory inventory, DefaultListModel<String> 
        invetoryObjects)
    {
        // fill JList with contents of supplied DefaultListModel<> 
        invetoryObjectsJList = new JList<>(invetoryObjects);
        
        // The text is not messed up, it's just using a non-monospaced font so 
        // not all characters have the same width.
        invetoryObjectsJList.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        invetoryObjectsJList.setVisibleRowCount(-1); // display as many rows as can be shown 
        
        // do not allow multiple selection
        invetoryObjectsJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        
        //invetoryObjectsJList.ensureIndexIsVisible(-1);
        //invetoryObjectsJList.setSelectedIndex(0);  <- consider this...
        
        JScrollPane inventoryScroll = new JScrollPane(invetoryObjectsJList, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        addInventoryJList(inventoryScroll, frame);
    }
    
    public void displayInventoryContents(Inventory inventory, JFrame frame)
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
        
        createInventoryJList(inventory, invetoryObjects);
    }
    
    // perform event upon change in JList entry focus 
    public void invetoryObjectsJListValueChanged(Inventory inventory, ListSelectionEvent evt) 
    {
        if (!invetoryObjectsJList.getValueIsAdjusting()) 
        {
            // CHANGE
            getObjectName(inventory, (String)invetoryObjectsJList.getSelectedValue());
            System.out.println(((String)invetoryObjectsJList.getSelectedValue()));
            
        }
    }
    
    public void addJListListener(Inventory inventory, JList jList)
    {
        // INVENTORY SHENANGIANS BELOW...
        // allows for events to occur upon change in JList entry focus  
        invetoryObjectsJList.addListSelectionListener(
            new ListSelectionListener() 
            {
                public void valueChanged(ListSelectionEvent evt) 
                {
                    invetoryObjectsJListValueChanged(inventory, evt);
                }
            }
        );
    }
    
    // END: INVENTORY AS JLIST 
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
    
    pu
    
    public void getObjectName(Inventory inventory, String jListObjectName)
    {
        char[] array = jListObjectName.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        
        // i is n - 1 so instead of 9 (space), must put 10 to start at first character 
        for(int i = 10; i < array.length; i++)
        {
            // append characters to builder to return as String later 
            builder.append(array[i]);
        }
        
        getInventoryObject(inventory, builder.toString());
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
        addButtonComponent(button, gridy, 2, 0.11, 1, 1, 1, frame);
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
        
        newAreaTitle(entity.getPlayerEntityExample().getInventory());
        
        objectDetailButtons(frame);
        
        
        /* idea for inventory display ONLY (itemName x#)
            show stuff using stringBuilder 
                selection will refer to party inventory stuff using String to 
                match namr of key object 
        */
        
        displayInventoryContents(entity.getPlayerEntityExample().getInventory(), frame);
        
        inventoryDetailsButtons(entity.getPlayerEntityExample().getInventory(), frame);
        
        addJListListener(entity.getPlayerEntityExample().getInventory(), invetoryObjectsJList);
        
        
        displayFrameWindow();
    }
    
    
    
    
}

