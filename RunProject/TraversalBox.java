package RunProject;

import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel; 
import java.util.ArrayList;

public class TraversalBox extends CommonGUIMethods
{
    // set frame for TraversalBox 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // font size used for text of all componenets 
    private Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    
    // top buttons containing important environment information
    private JButton safeZoneNotice, currentLocation, safeZoneState, eventAndEventLine;
    
    // left hand vertical column of buttons signifying options available to player 
    private JButton save, load, mainMenu, comms, settings, activities, interactions, exitGame;

    // panel meant for holding an image representing a map for the given location 
    private JPanel map = new JPanel();
    
    // text areas meant to hold information regarding the environment to player party 
    private JTextArea observations, effectsOnParty;
    
    // vertical padding for buttons in pixels 
    private int buttonVerticalPadding = 15;
    
    // meant to store result of choice selected for switch case 
    private int optionChoice = 0;
    
    private int characterLimit = 18;

    
    
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

    public JButton topLeftButtons(JButton button, String text)
    {
        button = new JButton(text);
        
        // set font for button text 
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        
        // set background color of button to black 
        button.setBackground(Color.BLACK);
        
        // set foreground color (i.e., text color) of button to yellow 
        button.setForeground(Color.YELLOW);
        
        return button;
    }
    
    public JButton topCenterRightButtons(JButton button, String text)
    {
        button = new JButton(text);
        
        // set font for button text 
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        // set background color of button to black 
        button.setBackground(Color.BLACK);
        
        // set foreground color (i.e., text color) of button to white 
        button.setForeground(Color.WHITE);
        
        return button;
    }
    
    public void addButtonComponent(JButton button, int gridy, int gridx, int gridheight, 
        int gridwidth, int shrinkRight, int boostLeft, JFrame frame)
    {
        // create object meant to hold positioning constraints for component
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // determine how components will stretch (in this case horizontally)
	gridBagConstraints.fill = GridBagConstraints.BOTH; 
        
        // specifies component horizontal space distribution (how much row space
        // is taken up by component if more than one component is present)
        // ex: code below has component take up 1/10 of total row space 
        gridBagConstraints.weightx = 0.1;
        
        // specifies component vertical space distribution (how much column space
        // is taken up by component if more than one component is present)
        // ex: code below has component take up 1/10 of total column space 
        gridBagConstraints.weighty = 0.1;
        
        // determine how tall component should be in pixels 
        gridBagConstraints.ipady = buttonVerticalPadding; 
        
        // specifies row position of component within a container
        gridBagConstraints.gridy = gridy;
        
        // specifies column position of component in a given row of a container
	gridBagConstraints.gridx = gridx;
        
        // how tall a component should be in a given column
        gridBagConstraints.gridheight = gridheight;
        
        // how wide (long) a component should be in a given row from left to right
        gridBagConstraints.gridwidth = gridwidth;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        // Note: positive shrinks, negative expands...
        gridBagConstraints.insets = new Insets(0, boostLeft, 0, shrinkRight);
        
        // add new button to location specified by gridBagConstraints
        frame.add(button, gridBagConstraints);
    }
    
    public void addTopButtonComponent(JButton button, int gridy, int gridx, int gridwidth, 
        int shrinkRight, int boostLeft, JFrame frame)
    {
        addButtonComponent(button, gridy, gridx, 1, gridwidth, shrinkRight, boostLeft, frame);
    }
    
    public void addTopButtons(String location, String eventEventLine)
    {
        // top left buttons 
        safeZoneNotice = topLeftButtons(safeZoneNotice, "Safe Zone");
            addTopButtonComponent(safeZoneNotice, 0, 0, 1, 225, 0, frame);
        
        safeZoneState = topLeftButtons(safeZoneState, "?");
            addTopButtonComponent(safeZoneState, 1, 0, 1, 225, 0, frame);
        
        // top center right buttons 
        String formatLocation = String.format("%-65s", location);
            currentLocation = topCenterRightButtons(currentLocation, formatLocation);
                addTopButtonComponent(currentLocation, 0, 1, 3, 0, -225, frame);
        
        String formatEventEventLine = String.format("%-10s", eventEventLine);
            eventAndEventLine = topCenterRightButtons(eventAndEventLine, formatEventEventLine);
                addTopButtonComponent(eventAndEventLine, 1, 1, 3, 0, -225, frame);
    }
    
    public void addTopLeftButtonComponent(JButton button, String text, int gridy, 
        JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row position 
        gridBagConstraints.gridy = gridy;
        
        // column of specified row position
        gridBagConstraints.gridx = 0;
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.07;
        
        // specified row length component takes up 
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
    
    // INCOMPLETE 
    public void usableButtonsActionsListeners()
    {
        mainMenu = newUsableButton(mainMenu, "Main Menu");
            mainMenu.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    mainMenu.setEnabled(false);
        
        comms = newUsableButton(comms, "Comms");
            comms.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    comms.setEnabled(false);
                 
        settings = newUsableButton(settings, "Settings");
            settings.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    settings.setEnabled(false);
        
        activities = newUsableButton(activities, "Activities");
            activities.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    activities.setEnabled(false);
        
        interactions = newUsableButton(interactions, "Interactions");
            interactions.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    interactions.setEnabled(false);
            
        save = newUsableButton(save, "Save");
            save.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    save.setEnabled(false);
        
        load = newUsableButton(load, "Load");
            load.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                    }
                }); 
                    load.setEnabled(false);
        
        exitGame= newUsableButton(exitGame, "Exit Game");
            exitGame.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                    }
                }); 
                    exitGame.setEnabled(true);
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
        gridBagConstraints.insets = new Insets(10, -215, 10, -10);
        
        frame.add(panel, gridBagConstraints);
    }
    
    // END: JPANEL FOR DISPLAYING MAP 
    /*******************************************************************************/

    
    
    // START: TESTING METHODS STUFF 
    /*******************************************************************************/

    /*
    // Note: 18 characeter limit for options 
    public ArrayList<String> textForTraversalBoxButtons()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("text for button 1");
        example.add("text for button 2");
        example.add("text for button 3");
        //example.add("text for button 4");
        //example.add("text for button 5");
        //example.add("text for button 6");

        return example;
    }
    */
    
    // END: TESTING METHODS STUFF 
    /*******************************************************************************/

    
    
    // START: MAKING BUTTONS USING STRINGS FROM SUPPLIED OPTIONS ARRAYLIST
    /*******************************************************************************/

    public JButton newVariableButton(String text, int loopCount)
    {
        JButton button = new JButton(text);
        
        // StringBuilder object holds text meant to be supplied to button 
        StringBuilder builder = new StringBuilder();
        
        // attempt to add text to builder by appending it to the end 
        if(text.length() <= characterLimit)
        {
            // parse int into String and add "." and space for appearance: "#. "
            // followed by text (loopCount is + 1 since loop count starts at 0)
            String formatted = String.format("%s. %-18s", String.valueOf(loopCount + 1), text);
                builder.append(formatted);
        }
        else
        {
            builder.append("ERROR: Too Long");
        }
        
        button.setText(builder.toString());
        
        button.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        return button;
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
                    // set option selected by player for switch case
                    setOptionChoice(result);

                    // signify that Gui is complete 
                    guiComplete(true);

                    // release all native screen resources, subcomponents, and all 
                    // of its owned children; in other words, close GUI and allow  
                    // program to continue running IF other windows are available 
                    frame.dispose();
                }
            }); 
    }
    
    public void addUsableRightButtonComponent(JButton button, int loopCount, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

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
	gridBagConstraints.insets = new Insets(0, 20, 0, 0);
	
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
    
    public void addButtonComponentsToTheirLocations(JFrame frame, ArrayList<JButton> buttonsArrayList, 
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
        
        addButtonComponentsToTheirLocations(frame, buttonsArrayList, privateButtons);
    }
    
    // Note: number of buttons made depend on size of String ArrayList supplied 
    public void buttonChoices(ArrayList<String> buttonTextArrayList, JFrame frame, JButton...buttons)
    {
        addButtonComponents(frame, makeButtonsUsingButtonTextArrayList(buttonTextArrayList), 
            buttons);
    }
    
    // END: MAKING BUTTONS USING STRINGS FROM SUPPLIED OPTIONS ARRAYLIST
    /*******************************************************************************/

    
    
    // START: SAFE ZONE STATE AFFECTING OTHER COMPONENTS 
    /*******************************************************************************/

    public void updateSafeZoneConditions(boolean safeZone)
    {
        if(safeZone)
        {
            safeZoneState.setText("TRUE");
                save.setEnabled(true);
                load.setEnabled(true);
        }
        else
        {
            safeZoneState.setText("FALSE");
                save.setEnabled(false);
                load.setEnabled(false);
        }
    }
    
    // END: SAFE ZONE STATE AFFECTING OTHER COMPONENTS 
    /*******************************************************************************/

    
    
    // START: TEXT AREAS 
    /*******************************************************************************/

    public void titlesForBottomLeftAndRightTextAreas(JFrame frame)
    {
        // title for bottom left text area 
        JButton observationsTitle = new JButton("Observations");

        observationsTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.gridwidth = 2;
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) (- value incrases border)
        gridBagConstraints.insets = new Insets(0, 0, 0, -15);
        
        frame.add(observationsTitle, gridBagConstraints);
        
        // title for bottom right text area 
        JButton effectsOnPartyTitle = new JButton("Effects On Party");
        
        effectsOnPartyTitle.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.gridwidth = 2;
	gridBagConstraints.ipady = buttonVerticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 20, 0, 0);
        
        frame.add(effectsOnPartyTitle, gridBagConstraints);
    }
    
    public JTextArea setUpTextArea(JTextArea textArea)
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
    
    public void addJTextAreasToTraversalBox(JTextArea textAreaObservations, JTextArea textAreaEffectsOnParty,
        JFrame frame)
    {
        // set vertical padding in pixels for JTextArea objects 
        int verticalPadding = 120;
        
        // set up text area 
        setUpTextArea(textAreaObservations);
        
        // add first text area 
        JScrollPane textAreaObservationsScroll = new JScrollPane(textAreaObservations, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
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
	gridBagConstraints.ipady = verticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right) (- value incrases border)
        gridBagConstraints.insets = new Insets(0, 0, 0, -15);
        
        frame.add(textAreaObservationsScroll, gridBagConstraints);
        
        // set up text area 
        setUpTextArea(textAreaEffectsOnParty);
        
        // add second text area 
        JScrollPane textAreaEffectsOnPartyScroll = new JScrollPane(textAreaEffectsOnParty, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.weightx = 0.6;
	gridBagConstraints.ipady = verticalPadding;
        
        // specifies space component must leave at each edges; (Insets(int 
        // top, int left, int bottom, int right)
        gridBagConstraints.insets = new Insets(0, 20, 0, 0);
        
        frame.add(textAreaEffectsOnPartyScroll, gridBagConstraints);
    }
    
    public void appendTextToObservations(String text)
    {
        StringBuilder builder = new StringBuilder(text);
            builder.append("\n\n");
                observations.append(builder.toString());
    }
    
    public void appendTextToEffectOnParty(String text)
    {
        StringBuilder builder = new StringBuilder(text);
            builder.append("\n\n");
                effectsOnParty.append(builder.toString());
    }
    
    // END: TEXT AREAS 
    /*******************************************************************************/

    
    
    // START: CONSTRUCTOR 
    /*******************************************************************************/
    
    // Note: text per String of supplied ArrayList cannot exceed 14 characters 
    public TraversalBox(boolean safeZone, String location, String eventEventLine, 
        ArrayList<String> textForButtons)
    {
        // set up properties of frame for GUI consistency 
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // at buttons to top of frame 
        addTopButtons(location, eventEventLine);
        
        // set up left hand usable buttons and add action listeners them 
        usableButtonsActionsListeners();
        
        // add left hand usable buttons to frame and add right hand buttons to frame
        // based on number of Strings that exist in supplied ArrayList
        buttonChoices(textForButtons, frame, mainMenu, comms, settings, activities,
            interactions, save, load, exitGame);
        
        // update which buttons are enabled based on Safe Zone state
        updateSafeZoneConditions(safeZone);
        
        // panel for displaying map meant to ease movement in game world 
        addJPanelForMap(map, frame);

        // titles for text area buttons indicating type of text area 
        titlesForBottomLeftAndRightTextAreas(frame);
        
        // text areas for different kinds of information relevant to player 
        addJTextAreasToTraversalBox(observations, effectsOnParty, frame);
        
        displayFrameWindow(frame);
    }
}
