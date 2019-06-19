package GUI_Collection;

import GUI_Collection.CommonGUIMethods;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

// box is designed to return a number from 0 -> # of buttons that exist 
public class OptionsBox extends CommonGUIMethods
{
    // set frame for options post exposition box 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // text area displays text supplied from String ArrayList supplied to constructor
    private JTextArea textArea = new JTextArea();
    
    // used to determine max number of characters button can display with text 
    // Note: character limim should be the same as that of ExpositionBox
    private final int characterLimit = 70;
    
    // font size used for text of all componenets 
    private Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    
    // meant to store result of choice selected for switch case 
    private int optionChoice = 0;
    
    
    
    // START: SETTING AND GETTING PLAYER CHOICE VALUE 
    /*******************************************************************************/

    public void setOptionChoice(int optionChoice)
    {
        this.optionChoice = optionChoice;
    }
    
    public int getOptionChoice()
    {
        return optionChoice;
    }
    
    // END: SETTING AND GETTING PLAYER CHOICE VALUE 
    /*******************************************************************************/
    
    
    
    // START: TEXT AREA WITH SCROLL FUNCTIONALITY 
    /*******************************************************************************/
    
    public void addTextToTextArea(JTextArea textArea, ArrayList<String> arrayList)
    {
        // Note: since String is immutable (cannot be changed after assigment), 
        //       need to create new String object with character(s) replaced 
        for(int i = 0; i < arrayList.size(); i++)
        {
            // for first element (always speaker), do not skip down one line 
            if(i == 0)
            {
                // for speaker, replace first boundary indicator "/" with ""
                String newElement = arrayList.get(i).replaceFirst("/", "");
                
                // Note: JTextArea objects CANNOT apppend more than one thing
                //       at a time so .append() must be made separately 
                // add String to text area and new line command to move down
                // one line for readability (text below spoken by speaker)
                textArea.append(newElement);
                
                textArea.append("\n");
            }
            // if speaker boundary indicator "/" exists then handle it 
            else if(arrayList.get(i).regionMatches(0, "/", 0, 1))
            {
                String newElement = arrayList.get(i).replaceFirst("/", "");
                
                // two new line commands are made to separate top text from
                // speaker for sake of readability 
                textArea.append("\n\n");
                
                textArea.append(newElement);
                
                textArea.append("\n");
            }
            // handle text spoken by speaker depending on existence of more lines 
            else
            {
                // if counter (i) has not reached end of ArrayList and if next line 
                // does not hold a speaker then enter if statement
                if(i != (arrayList.size() - 1) && !arrayList.get(i+1).regionMatches(0, "/", 0, 1))
                {
                    // although text is typically displayed in paragraph formaat,
                    // there are times where text consisting of but few words is 
                    // needed to convey important moments or "pauses" in game so
                    // it is best to accomodate for such scenarios with a space 
                    textArea.append(arrayList.get(i));
                        textArea.append(" ");
                }
                // else add text to text area 
                else
                {
                    textArea.append(arrayList.get(i));
                }
            }
        }
    }
    
    public void setUpTextArea(JTextArea textArea)
    {
        // set font for text displayed in text area 
        textArea.setFont(font);
        
        // set color of text to white 
        textArea.setForeground(Color.WHITE);
        
        // set color of background to black 
        textArea.setBackground(Color.BLACK);
        
        // text area where text is displayed cannot be editted 
        textArea.setEditable(false);
        
        // sentences "wrap" or goes to next line if text area boundary is reached 
        textArea.setLineWrap(true);
        
        // sentences wrap to next line if word touches boundary 
        textArea.setWrapStyleWord(true);
    }
    
    public void addTextAreaComponent(JTextArea textArea, ArrayList<String> arrayList)
    {
        // add text to text area
        addTextToTextArea(textArea, arrayList);
        
        // prepare text area properties 
        setUpTextArea(textArea);
        
        // create scroll pane for text area with scollability requirements 
        // Note: JScrollPane object contains text area with scroll functionality 
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GridBagConstraints textAreaConstraints = new GridBagConstraints();
        
        // text area will expand horizontally and vertically to fill empty space 
        textAreaConstraints.fill = GridBagConstraints.BOTH;
        
        // row 0 for the row 
        textAreaConstraints.gridy = 0;
        
        // column 0 for the column 
        textAreaConstraints.gridx = 0;
        
        // specified column length component takes up 
        textAreaConstraints.weighty = 0.50;
        
        // specified row length component takes up 
        textAreaConstraints.weightx = 0.50;
        
        // set vertical padding in pixels for component
        textAreaConstraints.ipady = 150;
        
        // add scroll (with text area inside it) to frame with positioning 
        frame.add(scroll, textAreaConstraints);
    }
    
    // END: TEXT AREA WITH SCROLL FUNCTIONALITY 
    /*******************************************************************************/


    
    // START: MAKING BUTTONS WITH TEXT
    /*******************************************************************************/

    // TESTING STUFF 
    /*
    // Note: exposition arrayList passed should be same as one passed to ExpositionBox
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
    
    // Note: number of Strings in ArrayList determines number of buttons created 
    public ArrayList<String> textForButtons()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("This is the text for button 1");
        example.add("This is the text for button 2");
        example.add("This is the text for button 3");
        example.add("This is the text for button 4");
        //example.add("This is the text for button 5");
        //example.add("This is the text for button 6");

        return example;
    }
    */
    // TESTING STUFF
    
    
    
    // MAKING BUTTONS BASED ON OPTIONS STRING ARRAYLIST SIZE 
    
    public JButton newButton(String text, int loopCount)
    {
        JButton button = new JButton(text);
        
        // parse int into String and add "." and space for appearance: "#. "
        // followed by text (loopCount is +1 since loop count starts at 0)
        StringBuilder builder = new StringBuilder(String.valueOf(loopCount + 1));
            builder.append(". ");
        
        // attempt to add text to builder by appending it to the end 
        if(text.length() <= characterLimit)
        {
            builder.append(text);
        }
        else
        {
            builder.append("ERROR: Text Too Long >:)");
        }
        
        button.setHorizontalAlignment(SwingConstants.LEADING);
        
        button.setText(builder.toString());
        
        button.setFont(font);
        
        return button;
    }
    
    // action listener gives button a number representing player choice 
    public void buttonActionUponClick(JButton button, int loopCount)
    {
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
    
    public void addButtonComponent(int loopCount, JButton button, JFrame frame)
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // button will expand horizontally to fill empty space 
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        // row 0 for row 
        gridBagConstraints.gridx = 0;
        
        // row position dependent on loop count and add 1 to accomodate text area 
        gridBagConstraints.gridy = loopCount + 1;
        
        // specified column length component takes up 
        gridBagConstraints.weighty = 0.07;
        
        // specified row length component takes up 
        gridBagConstraints.weightx = 0.1;
        
        // add button to frame with positioning 
        frame.add(button, gridBagConstraints);
    }
    
    // create buttons according to number of Strings in supplied String ArrayList
    public ArrayList<JButton> buttonsUsingButtonTextArrayList(ArrayList<String> 
        buttonChoicesText)
    {
        ArrayList<JButton> buttonsArrayList = new ArrayList<>();
        
        for(int i = 0; i < buttonChoicesText.size(); i++)
        {
            JButton button = newButton(buttonChoicesText.get(i), i);
                buttonActionUponClick(button, i);
                    buttonsArrayList.add(button);
        }
        
        return buttonsArrayList;
    }
    
    public void addVariableButtonComponents(ArrayList<String> variableOptionsStrings,
        JFrame frame)
    {
        // convert ArrayList to array starting from first position of Arrat
        JButton[] buttonsAsArray = buttonsUsingButtonTextArrayList(variableOptionsStrings).
            toArray(new JButton[0]);
        
        // add button column functionality for keyboard and mouse wheel 
        CommonGUIMethods.buttonColumnKeyboardNavigation(buttonsAsArray);
        CommonGUIMethods.frameMouseWheel(frame, buttonsAsArray);
        
        // add button as components for layout GridBagLayout of the frame 
        for(int i = 0; i < buttonsAsArray.length; i++)
        {
            addButtonComponent(i, buttonsAsArray[i], frame);
        }
    }
    
    // MAKING BUTTONS BASED ON OPTIONS STRING ARRAYLIST SIZE    
    
    // END: MAKING BUTTONS WITH TEXT
    /*******************************************************************************/


    
    // Note: exposition text with boundary "/" is supplied 
    // number of buttons (options) varies depending on text supplied for buttons 
    public OptionsBox(ArrayList<String> expositionBoxText, 
        ArrayList<String> variableOptionsStrings)
    { 
        // set color and layout for frame 
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // add text to text area before text area is added to frame 
        addTextAreaComponent(textArea, expositionBoxText);
        
        // add a variable number buttons (options) depending on ArrayList size
        addVariableButtonComponents(variableOptionsStrings, frame);
        
        displayFrameWindow(frame);
    } 
}
