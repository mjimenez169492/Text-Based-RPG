package RunProject;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
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

public class TraversalBox 
{    
    // font size used for text of all componenets 
    private Font font = new Font("Serif", Font.PLAIN, 18);
    
    private JButton safeZoneNotice, currentLocation, safeZoneState, eventAndEventLine;
    
    private JButton save, load, mainMenu, comms, settings, activities, interactions, exitGame;

    private JPanel map = new JPanel();
    
    private JButton textAreaOneTitle, textAreaTwoTitle;
    
    private JTextArea textAreaOne, textAreaTwo;
    
    private int buttonVerticalPadding = 15;
    
    private int optionChoice = 0;
    
    private int characterLimit = 86;

    
    
    // START: SET AND GET OPTION CHOICE
    /*******************************************************************************/
    
    public void setOptionChoice(int optionChoice)
    {
        this.optionChoice = optionChoice;
    }
    
    public int getOptionChoice()
    {
        return optionChoice;
    }
    
    // START: SET AND GET OPTION CHOICE
    /*******************************************************************************/

    
    
    // START: TOP ORIENTED BUTTON COMPONENTS 
    /*******************************************************************************/

    public void addTopLeftButtonComponent(JButton button, String text, int gridy, 
        JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        button = new JButton(text);
        
        // allow text resize for button text upon frame resize 
        textResizesUponButtonResize(frame, button);
        
        // set font for button text 
        button.setFont(new Font("Serif", Font.BOLD, 18));
        
        // set background color of button to black 
        button.setBackground(Color.BLACK);
        
        // set foreground color (i.e., text color) of button to yellow 
        button.setForeground(Color.YELLOW);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.07;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.2;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        // Note: positive shrinks, negative expands...
        gridBagConstraints.insets = new Insets(0, 0, 0, 225);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    public void addTopRightButtonComponent(JButton button, String text, int gridy, 
        JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        button = new JButton(text);
        
        // allow text resize for button text upon frame resize 
        textResizesUponButtonResize(frame, button);
        
        // set font for button text 
        button.setFont(new Font("Serif", Font.ITALIC, 18));
        
        // set background color of button to black 
        button.setBackground(Color.BLACK);
        
        // set foreground color (i.e., text color) of button to white 
        button.setForeground(Color.WHITE);
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = 1;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.07;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.85;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 3;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, -225, 0, 0);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    // START: TOP ORIENTED BUTTON COMPONENTS 
    /*******************************************************************************/

    
    
    // START: LEFT SIDE USABLE BUTTONS
    /*******************************************************************************/

    public JButton newUsableButton(JButton button, String text)
    {
        button = new JButton(text);
        
        button.setFont(font);
        
        return button;
    }
    
    public void addUsableLeftButtonComponent(JButton button, int loopCount, 
        JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = 2 + loopCount;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weighty = 0.07;
        
        // specified row length component takes up (1/10 of frame if no 
        // other components are in the way)
        gridBagConstraints.weightx = 0.2;
        
        // width of component in given row 
        gridBagConstraints.gridwidth = 1;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 0, 0, 225);
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    public void usableButtonsActionsListeners()
    {
        mainMenu.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        comms.addActionListener(
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
        
        activities.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        interactions.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        save.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        load.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
            }
        }); 
        
        exitGame.addActionListener(
        new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // END: LEFT SIDE USABLE BUTTONS
    /*******************************************************************************/

    
    
    // START: JPANEL FOR DISPLAYING MAP 
    /*******************************************************************************/

    public void addJPanelForMap(JPanel panel, JFrame frame)
    {
        //JPanel map = new JPanel();
        panel.setBackground(Color.WHITE);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally and vertically to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        
        // row position 
        gridBagConstraints.gridy = 2;
        
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
        gridBagConstraints.insets = new Insets(10, -215, 10, -60);
        
        frame.add(map, gridBagConstraints);
    }
    
    // END: JPANEL FOR DISPLAYING MAP 
    /*******************************************************************************/

    
    
    // START: TESTING METHODS STUFF 
    /*******************************************************************************/

    // TESTING STUFF 
    
    public ArrayList<String> testArrayList()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("/Name");
        example.add("I see doggy ha ha and i was like totally omg this cannot "
            + "be happening since i ate french fries and waffkes which are supposed "
            + "ti keep them things far away. Anyways I saw it and it saw me and I "
            + "saw it again and it like growled super weirdly like an alien thing "
            + "on t.v. or something. And that is why I am running for president. Bye "
            + "Now haha!");
        example.add("/Hype");
        example.add("Nuh - -d1! !2e Uh");
        example.add("Out of my way");
        example.add("/Description");
        example.add("like Uh huh!!! why say that \"\\ apple \"\\loser!");
        example.add("I see doggy ha ha and i was like totally omg this cannot "
            + "be happening since i ate french fries and waffkes which are supposed "
            + "ti keep them things far away. Anyways I saw it and it saw me and I "
            + "saw it again and it like growled super weirdly like an alien thing "
            + "on t.v. or something. And that is why I am running for president. Bye "
            + "Now haha!");

        return example;
    }
    
    public ArrayList<String> textForButtons()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("text for button 1");
        example.add("text for button 2");
        example.add("text for button 3");
        //example.add("This is the text for button 4");
        //example.add("This is the text for button 5");
        //example.add("This is the text for button 6");

        return example;
    }
    
    // TESTING STUFF
    
    // END: TESTING METHODS STUFF 
    /*******************************************************************************/

    
    
    // START: MAKING BUTTONS WITH TEXT
    /*******************************************************************************/

    public JButton newVariableButton(String text, int loopCount)
    {
        JButton newButton = new JButton(text);
        
        // parse int into String and add "." and space for appearance: "#. "
        // followed by text (loopCount is +1 since loop count starts at 0)
        StringBuilder builder = new StringBuilder(String.valueOf(loopCount + 1));
            builder.append(". ");
        
        // attempt to add text to builder by appending it to the end 
        if(text.length() < characterLimit)
        {
            builder.append(text);
        }
        else
        {
            builder.append("ERROR: Too Long");
        }
        
        newButton.setText(builder.toString());
        
        newButton.setFont(font);
        
        return newButton;
    }
    
    public void buttonActionUponClick(JButton button, int loopCount)
    {
        // action listener gives button a number representing player choice 
        button.addActionListener(
        new ActionListener() 
        {
            int result = loopCount;
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setOptionChoice(result);
                    System.out.println("choice is: "+getOptionChoice());
                        //frame.dipose();
            }
        }); 
    }

    public void addUsableRightButtonComponent(JButton button, int loopCount, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
	// set font for button text 
	button.setFont(font);
	
	// button will expand horizontally to fill empty space 
	gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
	
	// row position 
	gridBagConstraints.gridy = 2 + loopCount;
	
	// column of specified row position
	gridBagConstraints.gridx = 3;
	
	// specified column length component takes up (1/10 of frame if no 
	// other components are in the way)
	gridBagConstraints.weighty = 0.07;
	
	// specified row length component takes up (1/10 of frame if no 
	// other components are in the way)
	gridBagConstraints.weightx = 0.2;
	
	// vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
	// specifies space component must leave at each edges; (Insets(int 
	// top, int left, int bottom, int right)
	gridBagConstraints.insets = new Insets(0, 70, 0, 0);
	
	// add button to frame with positioning 
	frame.add(button, gridBagConstraints);
    }
    
    public ArrayList<JButton> makeButtonsUsingButtonTextArrayList(ArrayList<String> 
        buttonChoicesText)
    {
        ArrayList<JButton> buttonsArrayList = new ArrayList<>();
        
        for(int i = 0; i < buttonChoicesText.size(); i++)
        {
            JButton button = newVariableButton(buttonChoicesText.get(i), i);
                buttonActionUponClick(button, i);
                    buttonsArrayList.add(button);
        }
        
        return buttonsArrayList;
    }
    
    
        // left off editing for new button stuff here...
        // add left and right buttons separately... 
        // modify to add components once other side buttons are down (for movement)
    
    // allow for text to resize (somewhat) upon change in frame size...
    public void textResizesUponButtonResize(JFrame frame, JButton...array)
    {
        for(JButton element : array)
        {
            if(element != null)
            {
                CommonGUIMethods.resizeButtonTextUsingFrameSize(frame, element);
            }
        }
    }
    
    public void keyboardMouseWheelColumnFunctionality(JFrame frame, ArrayList<JButton> 
        buttonsArrayList, JButton[] privateButtons)
    {
        ArrayList<JButton> columnButtons = new ArrayList<>(buttonsArrayList);
        
        // add left side components to start of array
        for(int i = 0; i < privateButtons.length; i++)
        {
            columnButtons.add(i, privateButtons[i]);
        }
        
        // convert ArrayList to array starting from first position of Arrat
        JButton[] columnButtonsAsArray = columnButtons.toArray(new JButton[0]);
        
        // add button column functionality for keyboard and mouse wheel 
        CommonGUIMethods.buttonColumnKeyboardNavigation(columnButtonsAsArray);
        CommonGUIMethods.frameMouseWheel(frame, columnButtonsAsArray);
        
        // allow button text to resize upon frame resize 
        textResizesUponButtonResize(frame, columnButtonsAsArray);
    }
    
    // determine ordering of JButton container based on container size 
    public int mostElements(JButton[] array, ArrayList<JButton> arrayList)
    {
        int mostElements = 0;
        
        if(arrayList.size() > array.length)
        {
            mostElements = arrayList.size();
        }
        else
        {
            mostElements = array.length;
        }
        
        return mostElements;
    }
    
    // Note: since buttons are in a row x column format and therfore NOT 
    //       in column format, buttons must be supplied in reverse order 
    //       of that specified for column format which requires that all
    //       buttons be ordered such that the first button of the column
    //       is supplied first nad the last button supplied last.
    public void keyboardRowFunctionality(JFrame frame, ArrayList<JButton> buttonsArrayList, 
        JButton[] privateButtons)
    {
        // stores elements in order that left/right arrow keys will move in 
        ArrayList<JButton> rowControlButtons = new ArrayList<>();  
        
        // store value representing most number of elements held in one of two containers
        int mostElements = mostElements(privateButtons, buttonsArrayList);
        
        // add button components to rowControlButtons 
        // Note: add element to position 0 of rowControlButtons since last
        //       button will be first button for arrow key movement 
        for(int i = 0; i < mostElements; i++)
        {
            // add element based on mostElements value and whether or not it 
            // is possible to add element from a given container 
            if(mostElements == privateButtons.length)
            {
                rowControlButtons.add(0, privateButtons[i]);
                
                if(i < buttonsArrayList.size())
                {
                    rowControlButtons.add(0, buttonsArrayList.get(i));
                }
            }
            else if(mostElements == buttonsArrayList.size())
            {
                rowControlButtons.add(0, buttonsArrayList.get(i));
                
                if(i < privateButtons.length)
                {
                    rowControlButtons.add(0, privateButtons[i]);
                }
            }
            // if containers are the same size, add buttons such that left 
            // side buttons have priority over right buttons 
            else
            {
                rowControlButtons.add(0, privateButtons[i]);
                rowControlButtons.add(0, buttonsArrayList.get(i));
            }
        }
        
        // convert ArrayList to array starting from first position of Arrat
        JButton[] buttonsAsArray = rowControlButtons.toArray(new JButton[0]);
        
        // add button row functionality for keyboard 
        CommonGUIMethods.buttonRowKeyboardNavigation(buttonsAsArray);
    }
    
    public void addComponentsToTheirLocations(JFrame frame, ArrayList<JButton> buttonsArrayList, 
        JButton[] privateButtons)
    {
        for(int i = 0; i < privateButtons.length; i++)
        {
            addUsableLeftButtonComponent(privateButtons[i], i, frame);
        }
        
        // add button as components for layout GridBagLayout of the frame 
        for(int i = 0; i < buttonsArrayList.size(); i++)
        {
            addUsableRightButtonComponent(buttonsArrayList.get(i), i, frame);
        }
    }
    
    public void addButtonComponents(JFrame frame, ArrayList<JButton> buttonsArrayList, 
        JButton[] privateButtons)
    {
        keyboardMouseWheelColumnFunctionality(frame, buttonsArrayList, privateButtons);
        
        keyboardRowFunctionality(frame, buttonsArrayList, privateButtons);
        
        addComponentsToTheirLocations(frame, buttonsArrayList, privateButtons);
    }
    
    // Note: number of buttons made depend on size of String ArrayList supplied 
    public void buttonChoices(ArrayList<String> buttonTextArrayList,
        JFrame frame, JButton[] buttons)
    {
        addButtonComponents(frame, makeButtonsUsingButtonTextArrayList(buttonTextArrayList), 
            buttons);
    }
    
    // END: MAKING BUTTONS WITH TEXT
    /*******************************************************************************/

    
    
    
    // START: TEXT AREAS 
    /*******************************************************************************/

    public void titlesForTextAreas(JButton buttonOne, JButton buttonTwo, JFrame frame)
    {
        // title one
        buttonOne = new JButton("Environmental Description");

        buttonOne.setFont(new Font("Serif", Font.BOLD, 12));
        
        // allow text resize for button text upon frame resize 
        textResizesUponButtonResize(frame, buttonOne);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.gridwidth = 2;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) (- value incrases border)
        gridBagConstraints.insets = new Insets(0, 0, 0, -15);
        
        frame.add(buttonOne, gridBagConstraints);
        
        // title two
        buttonTwo = new JButton("Effects On Party");
        
        buttonTwo.setFont(new Font("Serif", Font.BOLD, 16));
        
        // allow text resize for button text upon frame resize 
        textResizesUponButtonResize(frame, buttonTwo);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.gridwidth = 2;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 20, 0, 0);
        
        frame.add(buttonTwo, gridBagConstraints);
    }
    
    public JTextArea textAreaSetUp(JTextArea textArea)
    {
        textArea = new JTextArea();
        
        // set font for text that will be displayed in text area 
        textArea.setFont(font);
        
        // set color of text to white 
        textArea.setForeground(Color.WHITE);
        
        // set color of background to black 
        textArea.setBackground(Color.BLACK);
        
        // text area where text is displayed cannot be editted 
        textArea.setEditable(true);
        
        // sentences "wrap" or go to next line if text area boundary is reached 
        textArea.setLineWrap(true);
        
        // sentences wrap to next line if word touches boundary 
        textArea.setWrapStyleWord(true);
        
        return textArea;
    }
    
    public void textAreasForBox(JTextArea textAreaOneType, JTextArea textAreaTwoType,
        JFrame frame)
    {
        // add first text area 
        JScrollPane textAreaOneScroll = new JScrollPane(textAreaOneType, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.6;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 160;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) (- value incrases border)
        gridBagConstraints.insets = new Insets(0, 0, 0, -15);
        
        frame.add(textAreaOneScroll, gridBagConstraints);
        
        // add second text area 
        JScrollPane textAreaTwoScroll = new JScrollPane(textAreaTwoType, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.6;
        
        // vertical padding in pixels for component in given row 
	gridBagConstraints.ipady = 160;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 20, 0, 0);
        
        frame.add(textAreaTwoScroll, gridBagConstraints);
    }
    
    public void appendTextToEnvironmentDescription(String text)
    {
        StringBuilder builder = new StringBuilder(text);
            builder.append("\n\n");
                textAreaOne.append(builder.toString());
    }
    
    public void appendTextToEffectOnParty(String text)
    {
        StringBuilder builder = new StringBuilder(text);
            builder.append("\n\n");
                textAreaTwo.append(builder.toString());
    }
    
    // END: TEXT AREAS 
    /*******************************************************************************/

    
    
    // START: DISPLAYING FRAME 
    /*******************************************************************************/
    
    // display frame window 
    public void displayFrameWindow(JFrame frame)
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // END: DISPLAYING FRAME 
    /*******************************************************************************/

    
    
    public TraversalBox()
    {
        JFrame frame = new JFrame();
        
        frame.getContentPane().setBackground(Color.BLACK);
        
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // top button components 
        addTopLeftButtonComponent(safeZoneNotice, "Safe Zone", 0, frame);
        addTopRightButtonComponent(currentLocation, "current Location", 0, frame);
        addTopLeftButtonComponent(safeZoneState, "TRUE", 1, frame);
        addTopRightButtonComponent(eventAndEventLine, "event", 1, frame);
        
        // Need to make button first and then add to frame 
        // options available to player 
        mainMenu = newUsableButton(mainMenu, "Main Menu");
            mainMenu.setEnabled(false);
        comms = newUsableButton(comms, "Comms");
            comms.setEnabled(false);
        settings = newUsableButton(settings, "Settings");
            settings.setEnabled(false);
        activities = newUsableButton(activities, "Activities");
            activities.setEnabled(false);
        interactions = newUsableButton(interactions, "Interactions");
            interactions.setEnabled(false);
        save = newUsableButton(save, "Save");
            save.setEnabled(false);
        load = newUsableButton(load, "Load");
            load.setEnabled(false);
        exitGame= newUsableButton(exitGame, "Exit Game");
            exitGame.setEnabled(true);
        
        usableButtonsActionsListeners();
        
        JButton[] privateButtons = {mainMenu, comms, settings, activities,
            interactions, save, load, exitGame};
        
        buttonChoices(textForButtons(), frame, privateButtons);
        
        // panel for displaying map for easier movement 
        addJPanelForMap(map, frame);

        // titles for text area buttons indicating type of text area 
        titlesForTextAreas(textAreaOneTitle, textAreaTwoTitle, frame);
        
        textAreaOne = textAreaSetUp(textAreaOne);
        textAreaTwo = textAreaSetUp(textAreaTwo);
        
        // text areas for different kinds of information 
        textAreasForBox(textAreaOne, textAreaTwo, frame);
        
        displayFrameWindow(frame);
    }
}
