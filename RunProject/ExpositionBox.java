package RunProject;

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

public class ExpositionBox 
{
    /* Note on Gridbag Layout:
        First see these links: 
            https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
            https://www.javatpoint.com/java-gridbaglayout
            https://www.decodejava.com/java-gridbaglayout.htm
        Second:
            components crated for GridBagLayout start off at center and gradually
            reach location specified as more components are added since adding any
            components can cause previously made components to shift as components
            are gradually added
        Third:
            The gridx and gridy of a SINGLE component can affect the layout of the
            entire GridBagLayout positioning scheme meaning certain components may 
            need to be adjusted
        Fourth
            Although it is possible to create many GridBagLayout components soley
            using one GridBagContraints object, this programming style denotes bad
            form due to the increased likelyhood of having bugs in GUI creation as
            some fields of the GridBagContraints object may not have been properly
            reset for the component about to be added to GridBagLayout 
    
            Ex:
                JButton button;
                JPanel panel = new JPanel();
                panel.setLayout(new GridBagLayout());
    
                GridBagContsraints gridBagContsraints = new GridBagContsraints(); 
                
                JButton button; = new JButton("test1");
                
                gridBagContsraints.ipady = 30;
                gridBagContsraints.gridx = 1;
                gridBagContsraints.gridy = 0;
                panel.add(button, gridBagContsraints)
    
                JButton button2; = new JButton("test2");
                
                gridBagContsraints.gridx = 1;
                gridBagContsraints.gridy = 1;
                panel.add(button2, gridBagContsraints)
                    FORGET: TO RESET IPADY SO button2 IS STRETCHED VERTICALLY 30 PIXELS!!!
    */

    private JFrame frame = new JFrame("Exposition Box");
    
    private Font font = new Font("Serif", Font.PLAIN, 18);
    
    private final int topRightComponentPixelPadding = 62;
    
    private JButton currentLocation, eventAndEventLine, currentAndFinalLines;
    
    private final int textDisplayingComponentPixelPadding = 68;
    
    private JButton speakerOrDescription, lineOne, lineTwo, lineThree; 
    
    private final int usableButtonComponentPixelPadding = 45;
    
    // Note: only need to supply THESE buttons for key/mouse movement  
    private JButton backward, forward, autoRun, alternativeNavigation, 
        textBoxSettings, mainMenu;
    
    // variables used to manage aspects of text movement and display 
    private final int characterLimit = 86;
    
    // Note: the number BEFORE - 1 signifies buttons that exist needed while
    //       - 1 is needed to array traversal from first to last button 
    private final int fragmentsNeededForConnectedFragement = 3 - 1;
    
    private ArrayList<String> exposition = new ArrayList<>();
    
    // meant to be incremented by 1 as soon as object is initialized 
    private int arrayPositionWithNames = -1;
    
    private int arrayPositionNoNames = 0;
    
    // meant for use in backtrack 
    private int lastArrayListPosition = 0;
    
    // total lines spoken or something
    private int totalLines = 0;
    
    
    // START: GRID BAG LAYOUT COMPONENT SET UP 
    /*******************************************************************************/
    
    public void expositionBoxComponent(JButton button, int ipady, int gridy, int gridx, 
        int gridwidth, JFrame frame)
    {
        // create object meant to hold positioning constraints for component
        GridBagConstraints gridBagConstraint = new GridBagConstraints();
        
        // determine how components will stretch (in this case horizontally)
	gridBagConstraint.fill = GridBagConstraints.BOTH; 
        
        // specifies component horizontal space distribution upon window resize 
        gridBagConstraint.weightx = 0.1;
        
        // specifies component vertical space distribution upon window resize 
        gridBagConstraint.weighty = 0.1;
        
        // determine how tall component should be in pixels 
        gridBagConstraint.ipady = ipady; 
        
        // specifies row position of component within a container
        gridBagConstraint.gridy = gridy;
        
        // specifies column position of component in a given row of a container
	gridBagConstraint.gridx = gridx;
        
        // how wide (long) a component should be in a given row from left to right
        gridBagConstraint.gridwidth = gridwidth;
        
        // add new button to location specified by gridBagConstraint
        frame.add(button, gridBagConstraint);
    }
    
    // END: GRID BAG LAYOUT COMPONENT SET UP 
    /*******************************************************************************/

    
    
    // START: GRID BAG LAYOUT COMPONENT PLACEMENT
    /*******************************************************************************/

    public JButton unusableButton(JButton newButton, String newButtonName, Font font)
    {
        newButton = new JButton(newButtonName);
        
        newButton.setFont(font);
        
        newButton.setBackground(Color.BLACK);
        
        newButton.setForeground(Color.WHITE);
        
        return newButton;
    }
    
    public void topRightComponents()
    {
        // buttons located on the top left of text box GUI
        currentLocation = unusableButton(currentLocation, "d", font);
            expositionBoxComponent(currentLocation, topRightComponentPixelPadding, 0, 0, 3, frame);
        
        eventAndEventLine = unusableButton(eventAndEventLine, "d", font);
            expositionBoxComponent(eventAndEventLine, topRightComponentPixelPadding, 1, 1, 2, frame);

        currentAndFinalLines = unusableButton(currentAndFinalLines, "# / # d", font);
            expositionBoxComponent(currentAndFinalLines, topRightComponentPixelPadding, 2, 2, 1, frame);
    }
    
    public void textDisplayingComponents()
    {
        // button located just above first line denoting speaker (if there is one)
        speakerOrDescription = unusableButton(speakerOrDescription, " ", font);
            expositionBoxComponent(speakerOrDescription, textDisplayingComponentPixelPadding, 4, 0, 1, frame);
        
        // lines meant for holding text meant to be displayed to player 
        lineOne = unusableButton(lineOne, " ", font);
            lineOne.setHorizontalAlignment(SwingConstants.LEADING);
                expositionBoxComponent(lineOne, textDisplayingComponentPixelPadding, 5, 0, 6, frame);
        
        lineTwo = unusableButton(lineTwo, "(make blank)", font);
            lineTwo.setHorizontalAlignment(SwingConstants.LEADING);
                expositionBoxComponent(lineTwo, textDisplayingComponentPixelPadding, 6, 0, 6, frame);
        
        lineThree = unusableButton(lineThree, "(make blank)", font);
            lineThree.setHorizontalAlignment(SwingConstants.LEADING);
                expositionBoxComponent(lineThree, textDisplayingComponentPixelPadding, 7, 0, 6, frame);
    }
    
    public JButton usableButton(JButton newButton, String newButtonName, Font font)
    {
        newButton = new JButton(newButtonName);
        
        newButton.setFont(font);
        
        return newButton;
    }
    
    public void usableButtonsComponents()
    {
        // SELECTABLE buttons that vary in affect 
        alternativeNavigation = usableButton(alternativeNavigation, "Alternative Navigation", font);
            expositionBoxComponent(alternativeNavigation, usableButtonComponentPixelPadding, 9, 0, 1, frame);
        
        backward = usableButton(backward, "Backward", font);
                expositionBoxComponent(backward, usableButtonComponentPixelPadding, 9, 1, 1, frame);
                
        forward = usableButton(forward, "Forward", font);
                expositionBoxComponent(forward, usableButtonComponentPixelPadding, 9, 2, 1, frame);
     
        textBoxSettings = usableButton(textBoxSettings, "Text Box Setting", font);
                expositionBoxComponent(textBoxSettings, usableButtonComponentPixelPadding, 10, 0, 1, frame);
        
        autoRun = usableButton(forward, "Auto Run", font);
                expositionBoxComponent(autoRun, usableButtonComponentPixelPadding, 10, 1, 1, frame);
        
        mainMenu = usableButton(mainMenu, "Main Menu", font);
                expositionBoxComponent(mainMenu, usableButtonComponentPixelPadding, 10, 2, 1, frame);
    }
    
    // END: GRID BAG LAYOUT COMPONENT PLACEMENT
    /*******************************************************************************/

    
    
    // START: ENABLING BUTTON NAVIGATION 
    /*******************************************************************************/

    public void usableButtonNavigation()
    {
        // Note: since buttons are in a row x column format and therfore NOT 
        //       in column format, buttons must be supplied in reverse order 
        //       of that specified for column format which requires that all
        //       buttons be ordered such that the first button of the column
        //       is supplied first nad the last button supplied last.
        
        JButton buttons[] = {textBoxSettings, forward, mainMenu, backward, 
            autoRun, alternativeNavigation};
        
        // account for arrow key movement up or down
        CommonGUIMethods.buttonColumnKeyboardNavigation(buttons);
        
        // account for arrow key movement left or right
        CommonGUIMethods.buttonRowKeyboardNavigation(mainMenu, autoRun, 
            textBoxSettings, forward, backward, alternativeNavigation);
        
        // account for mouse wheel movement for frame (move while outside frame)
        CommonGUIMethods.frameMouseWheel(frame, buttons);
    }
    
    // MouseAdapter extended to avoid overriding unused methods 
    private class MouseHandler extends MouseAdapter
    {
        // handle event when mouse enters area 
        @Override
        public void mouseEntered(MouseEvent event)
        {
            JButton button = (JButton)event.getSource();
            button.requestFocus();
        }
    
        // handle event when mouse exits area
        @Override
        public void mouseExited(MouseEvent event)
        {
            JButton button = (JButton)event.getSource();
            button.requestFocus();
        }
    }
    
    // attack handlers to components that can be interacted with in some way 
    public void attachHandlersToComponents(JFrame frame, JButton backward, JButton 
        forward, JButton autoRun, JButton alternativeNavigationScheme, JButton 
        textBoxSettings, JButton mainMenu)
    {
        MouseHandler handler = new MouseHandler();
        
        frame.addMouseWheelListener(handler);
        
        backward.addMouseListener(handler);  
        backward.addMouseMotionListener(handler);
        
        forward.addMouseListener(handler);  
        forward.addMouseMotionListener(handler);
        
        autoRun.addMouseListener(handler);  
        autoRun.addMouseMotionListener(handler);
        
        alternativeNavigationScheme.addMouseListener(handler);  
        alternativeNavigationScheme.addMouseMotionListener(handler);
        
        textBoxSettings.addMouseListener(handler);  
        textBoxSettings.addMouseMotionListener(handler);
        
        mainMenu.addMouseListener(handler);  
        mainMenu.addMouseMotionListener(handler);
    }
    
    // END: ENABLING BUTTON NAVIGATION 
    /*******************************************************************************/

    
    
    // START: RESIZE COMPONENT BASED ON FRAME RESIZE AND DISPLAYING FRAME 
    /*******************************************************************************/

    // allow for text to resize (somewhat) upon change in frame size...
    public void textResizesUponComponentResize(JButton...array)
    {
        for(JButton element : array)
        {
            if(element != null)
            {
                CommonGUIMethods.resizeButtonTextUsingFrameSize(frame, element);
            }
        }
    }
    
    // display frame window 
    public void displayFrameWindow()
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // END: RESIZE COMPONENT BASED ON FRAME RESIZE AND DISPLAYING FRAME 
    /*******************************************************************************/

    
    
    // START: DISPLAY TEXT FOR TEXT BOX 
    /*******************************************************************************/
    
                    // Note: method serves as an example of String ArrayList relaying text 
    public ArrayList<String> initializeArrayList()
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
    
    // BREAKING DOWN LARGE PIECES OF TEXT
    
    // turn a String representing a paragraph of text into various sentence
    // fragments that do not exceed the character limit specified 
    public ArrayList<String> paragraphSentenceFragments(String sentence)
    {
        ArrayList<String> sentenceFragments = new ArrayList<>();
        
        // in order to get words in sentence for fragmenet manipulation, need 
        // to split String word by word using a space as a delimter (delimter
        // denotes conditions String is split up by)
        String[] words = sentence.split(" ");
        
        // StringBuilder object is used to create sentence fragments quicker 
        // than by adding Strings together using " + "
        StringBuilder fragment = new StringBuilder();
    
        // use words to create String fragments that adhere to character limit 
        for(String element : words)
        {
                // check dropping or increasing character limit...
            
            // if length of StringBuilder object and word to be added does not
            // exceed character limit then append word to StringBuilder 
            if((fragment.toString().length() + element.length()) < characterLimit)
            {
                fragment.append(element).append(" "); 
            }
            // else add fragment to arrayList as String, reset fragment, and 
            // add word to StringBuilder object
            else
            {
                sentenceFragments.add(fragment.toString());
                fragment = new StringBuilder();
                fragment.append(element).append(" "); 
            }
        }    
    
        // account for when fragment is not empty 
        if(fragment.toString().length() != 0)
        {
            sentenceFragments.add(fragment.toString());
        }

        return sentenceFragments;
    }
    
    // sentence fragments are put together such that each new fragment would
    // be able to occupy 4 lines of text that are each 64 characters long 
    public ArrayList<String> connectSentenceFragments(ArrayList<String> fragmentArrayList)
    {
        ArrayList<String> connectedFragments = new ArrayList<>();
        
        StringBuilder sentence = new StringBuilder();
        
        // add fragments together such that each connectedFragment String is
        // composed of 4 fragments (if there are enough fragments to do so)
        for(int i = 0; i < fragmentArrayList.size(); i++)
        {
            // frag no char size ??
            
            // completed fragments occur when i is divisible by variable value 
            if(i != 0 && (i % fragmentsNeededForConnectedFragement == 0))
            {
                // remember to add sentence fragement befor adding all of the
                // fragements connected so far to connectedFragments 
                sentence.append(fragmentArrayList.get(i));
                    connectedFragments.add(sentence.toString());
                        sentence = new StringBuilder();
            }
            else
            {
                sentence.append(fragmentArrayList.get(i));
            }
        }    

        // account for when fragment is not empty 
        if(sentence.toString().length() != 0)
        {
            connectedFragments.add(sentence.toString());
        }
        
        return connectedFragments;
    }
    
    // ArrayList elements are treated differently based on whether or not an
    // element represents speaker or text 
    public ArrayList<String> breakdownExposition(ArrayList<String> exposition)
    {
        ArrayList<String> namesAndLines = new ArrayList<>();
        
        ArrayList<String> sentenceFragments = new ArrayList<>();
        
        for(String element : exposition)
        {
            // if String is speaker then add it to arrayList
            if(element.regionMatches(0, "/", 0, 1))
            {
                namesAndLines.add(element);
            }
            // else prepare lines of speaker so that they can be displayed 
            else
            {
                // turn paragraph of spoken text into sentence fragments 
                for(String result : paragraphSentenceFragments(element))
                {
                    sentenceFragments.add(result);
                }
                
                // turn small fragments into larger fragments that can be seen
                // in 4 lines of text that can hold 64 characters long each 
                for(String result : connectSentenceFragments(sentenceFragments))
                {
                    namesAndLines.add(result);
                        
                    // remember to clear ArrayList at end of iteration step in 
                    // order to avoid adding elements from previous iterations 
                    sentenceFragments.clear();
                }
            }
        }

        return namesAndLines;
    }
    
    // BREAKING DOWN LARGE PIECES OF TEXT
    
    
    
    // REMOVE BOUNDARY MARKERS AND SPACE AT START OF BUTTON TEXT LINE
    
    // one of the final steps that must be performed to touch up displayed text
    public ArrayList<String> removeSpecialCharacters(ArrayList<String> unedittedArrayList)
    {
        ArrayList<String> edittedArrayList = new ArrayList<>();
        
        // since Strings are immutable, recommended to use StringBuilder to
        // create object using String and handle character from there or to
        // convert String into character array and handle character there 
            // String -> char -> String style
                // convert String into characters 
                // replace instance of character with something
                // convert character array back to String 
        
        for(String element : unedittedArrayList)
        {
            // checks are performed for FIRST character of String 
            if(element.regionMatches(0, "/", 0, 1))
            {
                char[] chars = element.toCharArray();
                chars[0] = ' ';
                edittedArrayList.add(String.valueOf(chars));
            }
            else if(element.regionMatches(0, "|", 0, 1))
            {
                char[] chars = element.toCharArray();
                chars[0] = ' ';
                edittedArrayList.add(String.valueOf(chars));
            }
            else
            {
                edittedArrayList.add(element);
            }
        }    
        
        return edittedArrayList;
    }
    
    // one of the final steps that must be performed to touch up displayed text
    public ArrayList<String> removeSpaceAtStart(ArrayList<String> unedittedArrayList)
    {
        ArrayList<String> edittedArrayList = new ArrayList<>();
        
        for(String element : unedittedArrayList)
        {
            // checks are performed for FIRST character of String 
            if(element.regionMatches(0, " ", 0, 1))
            {
                // since String is immutab;e, need to create new String object
                // with character(s) already replaced 
                String newElement = element.replaceFirst(" ", "");
                    edittedArrayList.add(newElement);
            }
            else
            {
                edittedArrayList.add(element);
            }
        }
        
        return edittedArrayList;
    }
    
                // Note: beware of pass by reference issues 
    
    // for preparing text to be displayed 4 lines at a time 
    public ArrayList<String> cleanArrayList(ArrayList<String> arrayList)
    {
        // must be done this way in order to preserve changes in ArrayList 
        // since String objects in final ArrayList differ from Objects in 
        // ArrayList passed to cleanArrayList() 
        return removeSpaceAtStart(removeSpecialCharacters(arrayList));
    }
    
    // REMOVE BOUNDARY MARKERS AND SPACE AT START OF BUTTON TEXT LINE

    
    
    // SETTING JBUTTON EXPOSITION TEXT LINES 
    
    // clear all lines used for displaying spoken text   
    public void clearLines(JButton lineOne, JButton lineTwo, JButton lineThree)
    {
        lineOne.setText(" ");
        lineTwo.setText(" ");
        lineThree.setText(" ");
    }
    
    // set sentence fragments as button text for all buttons provided 
    public void setLines(String connectedFragment, JButton lineOne, JButton lineTwo, 
        JButton lineThree, boolean choice)
    {
        // clear lines each time lines are set 
        clearLines(lineOne, lineTwo, lineThree);
        
        // need to break up connectedFragment consisting of multiple sentence 
        // fragments into smaller fragments that don't exceed character limit 
        // specified; these small fragements must be "cleaned" or have excess
        // spaces and/or boundary markers such as "/" removed for readability
        ArrayList<String> cleanedArrayList = cleanArrayList(paragraphSentenceFragments
            (connectedFragment));
        
        incrementCurrentLineCount(choice);
        
        // clean up arrayList contents before fragments are placed in lines 
        for(int i = 0; i < cleanedArrayList.size(); i++)
        {
            switch(i)
            {
                case 0:
                    lineOne.setText(cleanedArrayList.get(i));
                        break;
                case 1:
                    lineTwo.setText(cleanedArrayList.get(i));
                        break;
                case 2:
                    lineThree.setText(cleanedArrayList.get(i));
                        break;
            }
        }
    }
    
    // set area reserved for speaker based on String supplied 
    public void setSpeaker(String speakerName)
    {
        // create ArrayList to properly "clean" speakerName
        ArrayList<String> uncleanArrayList = new ArrayList<>();
        
        uncleanArrayList.add(speakerName);
        
        ArrayList<String> cleanArrayList = cleanArrayList(uncleanArrayList);
        
        // perform equality check after String is "cleaned"
        if(!cleanArrayList.get(0).equals("Description"))
        {
            speakerOrDescription.setText(cleanArrayList.get(0)); 
        }
        // empty space preserves GUI structure 
        else
        {
            speakerOrDescription.setText(" "); 
        }
    }
    
    // SETTING JBUTTON EXPOSITION TEXT LINES 
    
    
    
    // BACKWARD AND FORWARD TEXT MOVEMENT 
    
    // allows for moving text forward 
    public void moveTextForward(ArrayList<String> arrayList, JButton speakerOrDescription, 
        JButton lineOne, JButton lineTwo, JButton lineThree)
    {
        // if accounts for when speaker role has been encountered 
        if(arrayList.get(arrayPositionWithNames).regionMatches(0, "/", 0 , 1))
        {
            // set speaker role appropriately 
            setSpeaker(arrayList.get(arrayPositionWithNames));
    
            // increment intance variable by 1 to start at spoken line 
            arrayPositionWithNames += 1;
            
            // use number of speaking lines to set text lines 
            setLines(arrayList.get(arrayPositionWithNames), lineOne, lineTwo, 
                lineThree, true);
        }
        // else accounts for when normal text has been encountered
        else
        {
            // use number of speaking lines to set text lines 
            setLines(arrayList.get(arrayPositionWithNames), lineOne, lineTwo, 
                lineThree, true);
        }
    }
    
    // allows for moving text backward 
    public void moveTextBackward(ArrayList<String> arrayList, JButton speakerOrDescription, 
        JButton lineOne, JButton lineTwo, JButton lineThree)
    {
        // if accounts for when speaker role has been encountered 
        if(arrayList.get(arrayPositionWithNames).regionMatches(0, "/", 0 , 1))
        {
            // store new speaker 
            String newSpeaker = null;
            
            // loop backward from array position denoted by arrayPositionWithNames
            // - 1 to prevent loop from breaking before previous speaker if found  
            for(int i = (arrayPositionWithNames - 1); i < arrayList.size(); i--)
            {
                // if new speaker has been found then break loop (else program dies)
                if(arrayList.get(i).regionMatches(0, "/", 0 , 1))
                {
                    newSpeaker = arrayList.get(i);
                        break;
                }
            }
            
            // set speaker role appropriately 
            setSpeaker(newSpeaker);
    
            // increment intance variable by 1 to start at spoken line 
            arrayPositionWithNames -= 1;
            
            // use number of speaking lines to set text lines 
            setLines(arrayList.get(arrayPositionWithNames), lineOne, lineTwo, 
                lineThree, false);
        }
        // else accounts for when normal text has been encountered
        else
        {
            // use number of speaking lines to set text lines 
            setLines(arrayList.get(arrayPositionWithNames), lineOne, lineTwo, 
                lineThree, false);
        }
    }
    
    // BACKWARD AND FORWARD TEXT MOVEMENT 
    
    // END: DISPLAY TEXT FOR TEXT BOX 
    /*******************************************************************************/

    
    
    // START: ACTION LISTENERS FOR BUTTONS 
    /*******************************************************************************/
    
    public void initializeExpositionBoxLines(ArrayList arrayList)
    {
        arrayPositionWithNames += 1;
            moveTextForward(arrayList, speakerOrDescription, 
                lineOne, lineTwo, lineThree);
    }
    
    public void usableButtonsActionListeners(ArrayList<String> arrayList, JButton 
        speakerOrDescription, JButton lineOne, JButton lineTwo, JButton lineThree)
    {
        // action listener gives button backward ability to move text backward  
        alternativeNavigation.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    /*  
                        
                        
                    */
                    
                    
                }
            }
        ); 
        
        
        
        
        
        // action listener gives button backward ability to move text backward  
        backward.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if((arrayPositionNoNames - 1) > 0)
                    {
                        arrayPositionWithNames -= 1;
                            moveTextBackward(arrayList, speakerOrDescription, 
                                lineOne, lineTwo, lineThree);
                    }
                }
            }
        ); 
        
        // action listener gives button forward ability to move text forward  
        forward.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if((arrayPositionNoNames + 1) <= totalLines)
                    {
                        arrayPositionWithNames += 1;
                            moveTextForward(arrayList, speakerOrDescription, 
                                lineOne, lineTwo, lineThree);
                    }
                    else
                    {
                        // terminates program currently running on Java Virtual Machine
                        // and return all memory used by program back to OS
                            // System.exit.(0);
                        
                        // Note: dispose() can be used to close a single window if a
                        //       program has many windows displayed
                        
                        // release all native screen resources, subcomponents, and all 
                        // of its owned children; in other words, close GUI and allow  
                        // program to continue running IF other windows are available 
                        frame.dispose();
                        
                        // this would play afterwards (for example) 
                        System.out.println("hahah");
                    }
                }
            }
        ); 
        
        
    }
    
    
    // END: ACTION LISTENERS FOR BUTTONS 
    /*******************************************************************************/

    
    
    // START: SETTING CURRENT AND FINAL LINES FOR LINE TRACKING 
    /*******************************************************************************/
    
    // counts total number of lines that are NOT speaker roles 
    public int totalLines(ArrayList<String> arrayList)
    {
        int counter = 0;
        
        for(String element : arrayList)
        {
            if(!element.regionMatches(0, "/", 0 , 1))
            {
                counter++;
            }
        }
    
        return counter;
    }
    
    // set current and final line after current line argument is supplied 
    public void setCurrentAndFinalLines(int value)
    {
        StringBuilder builder = new StringBuilder(Integer.toString(value));
        
        builder.append(" / ").append(totalLines);
        
        currentAndFinalLines.setText(builder.toString());
    }
    
    public void incrementCurrentLineNoNames()
    {
        setCurrentAndFinalLines(++arrayPositionNoNames);
    }
    
    public void decrementCurrentLineNoNames()
    {
        setCurrentAndFinalLines(--arrayPositionNoNames);
    }
    
    // if true increment current line count else decrement current line count 
    public void incrementCurrentLineCount(boolean argument)
    {
        if(argument)
        {
            incrementCurrentLineNoNames();
        }
        else
        {
            decrementCurrentLineNoNames();
        }
    }
    
    // END: SETTING CURRENT AND FINAL LINES FOR LINE TRACKING 
    /*******************************************************************************/
    
    
    public void expositionBox()
    {
        // set frame layou signifying component positioning style 
        frame.setLayout(new GridBagLayout());
        
        // set color for panel bydecoding string of hexadecimal color 
        frame.getContentPane().setBackground(Color.decode("#4d5461"));
	
        topRightComponents();
        textDisplayingComponents(); 
        
        // text resizes within buttons according to frame size itself
        // Note: this is done since buttons are designed to resize on their onw 
        textResizesUponComponentResize(currentLocation, eventAndEventLine, 
            currentAndFinalLines, speakerOrDescription, lineOne, 
            lineTwo, lineThree, 
            backward, forward, autoRun, alternativeNavigation, textBoxSettings, 
            mainMenu);
        
        usableButtonsComponents();
        usableButtonNavigation();
        
            // arraylist
        ArrayList<String> testArrayList = breakdownExposition(initializeArrayList());

        //ArrayList<String> cleanArrayList = cleanArrayList(breakdownExposition(initializeArrayList()));

        totalLines = totalLines(testArrayList);
        
        String result = Integer.toString(totalLines(testArrayList));
        currentAndFinalLines.setText(result);
        
        initializeExpositionBoxLines(testArrayList);
        
            // text stuff
        usableButtonsActionListeners(testArrayList, speakerOrDescription, lineOne, 
            lineTwo, lineThree);
        
        // add appropriate mouse handlers to compoenents 
        attachHandlersToComponents(frame, backward, forward, autoRun, 
            alternativeNavigation, textBoxSettings, mainMenu);
        
        displayFrameWindow(); 
    }
    
    /*
    public ExpositionBox() 
    {
        // set frame layou signifying component positioning style 
        frame.setLayout(new GridBagLayout());
        
        // set color for panel bydecoding string of hexadecimal color 
        frame.getContentPane().setBackground(Color.decode("#4d5461"));
	
        topRightComponents();
        textDisplayingComponents(); 
        
        // text resizes within buttons according to frame size itself
        // Note: this is done since buttons are designed to resize on their onw 
        textResizesUponComponentResize(currentLocation, eventAndEventLine, 
            currentAndFinalLines, speakerOrDescription, lineOne, 
            lineTwo, lineThree, 
            backward, forward, autoRun, alternativeNavigation, textBoxSettings, 
            mainMenu);
        
        usableButtonsComponents();
        usableButtonNavigation();
        
            // arraylist
        ArrayList<String> testArrayList = breakdownExposition(initializeArrayList());

        //ArrayList<String> cleanArrayList = cleanArrayList(breakdownExposition(initializeArrayList()));

        totalLines = totalLines(testArrayList);
        
        //System.out.println("array pos no names: "+arrayPositionNoNames);
        //System.out.println("clean size: "+totalLines(testArrayList));
        
        
        String result = Integer.toString(totalLines(testArrayList));
        currentAndFinalLines.setText(result);
        
        
        
            // text stuff
        usableButtonsActionListeners(testArrayList, speakerOrDescription, lineOne, 
            lineTwo, lineThree);
        
        // add appropriate mouse handlers to compoenents 
        attachHandlersToComponents(frame, backward, forward, autoRun, 
            alternativeNavigation, textBoxSettings, mainMenu);
        
        displayFrameWindow(); 
    }
    */
}
