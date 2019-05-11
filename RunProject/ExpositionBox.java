package RunProject;


// Method keyTyped is called in response to pressing any key that is not an 
// action key. (The action keys are any arrow key, Home, End, Page Up, Page 
// Down, any function key, etc.) 

// Fig. 12.36: KeyDemoFrame.java
// Key event handling.
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ExpositionBox extends JFrame implements KeyListener
{
    private ArrayList<String> exposition = new ArrayList<>();
    private int arrayListPosition;
    
    private String line1 = ""; // first line of text area
    private String line2 = ""; // second line of text area
    private String line3 = ""; // third line of text area
    private JTextArea textArea; // text area to display output
    
    public void initializeExposition()
    {
        exposition.add("Ai");
        exposition.add("Testing. Testing. One, two, three. Testing");
        exposition.add("Please respond.");
        exposition.add("Um hello?");
        exposition.add("Expo");
        exposition.add("Ai delicately taps the glass once and yet again a few seconds later");
    }
    
    // KeyDemoFrame constructor
    public ExpositionBox()
    {
        super("Sample Exposition Box"); 
        
        textArea = new JTextArea(10, 15); // set up JTextArea
        textArea.setText("Press a keyboard arrow key to advance...");
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.BLACK);
        add(textArea); // add text area to JFrame
        
        initializeExposition();
        
        addKeyListener(this); // allow frame to process key events
    }
    

    /* ArrayList of Strings
        filled with "Names" and dialog spoken by "Name"
        need to differentaite between "Names" and their dialog 
        /Name/
        |I see doggy ha ha|
        |aha aha blah blah blah|
        /Name/
        |Nuh Uh|
        
            Need to check for start AND end point of "Name" speaking 
            Need to clear text area after each advancement for "Name" and 
            text panels if applicable 
                if(arraylist.get(i).regionmatches(0, "/", 0 , 1))
                {
                    replaceNameText();
                }
                else if(arraylist.get(i).regionmatches(0, "|", 0 , 1))
                {
                    replaceText();
                }
    
        public void setPanels()
        {
            
        }    
        
    */
    
    
    /* exposition box features
                        current location
                                event line
        Person talking 
            exposition
        options 
            options:
                [current # / max #]: can manually change AND enter desired talking part 
                left key: move back by 1 (if possible [also NO LOOPING])
                right key: advance by 1 (if possible [also NO LOOPING])
                autorun: advance by default millisec (1800) or custom millisec 
                adjust autorun speed: alter line output 
                movement by click: disable other buttons and move via arrow keys, click, or mouse wheel
                    Note: mouse, scroll(fast inc/dec), and keyboard support
    */
    
    // handle press of any key
    @Override
    public void keyPressed(KeyEvent event)
    {
        if(event.getKeyCode() == KeyEvent.VK_UP) 
        {
            //exposition
            //textArea.setText(exposition);
        }
        if(event.getKeyCode() == KeyEvent.VK_DOWN) 
        {
            //
        }
        if(event.getKeyCode() == KeyEvent.VK_LEFT) 
        {
            textArea.setText("Press any key on the keyboard...");
        }
        if(event.getKeyCode() == KeyEvent.VK_RIGHT) 
        {
            textArea.setText("Press any key on the keyboard...");
        }
        
        /*
        line1 = String.format("Key pressed: %s", 
            KeyEvent.getKeyText(event.getKeyCode())); // show pressed key
        setLines2and3(event); // set output lines two and three
        */
    }
    
    // handle release of any key 
    @Override
    public void keyReleased(KeyEvent event)
    {
        line1 = String.format("Key released: %s",
            KeyEvent.getKeyText(event.getKeyCode())); // show released key
        setLines2and3(event); // set output lines two and three
    }
    
    // handle press of an action key
    @Override
    public void keyTyped(KeyEvent event)
    {
        line1 = String.format("Key typed: %s", event.getKeyChar());
        setLines2and3(event); // set output lines two and three
    }
    
    // set second and third lines of output
    private void setLines2and3(KeyEvent event)
    {
        line2 = String.format("This key is %san action key", 
            (event.isActionKey() ? "" : "not "));
        
        String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
        
        line3 = String.format("Modifier keys pressed: %s", 
            (temp.equals("") ? "none" : temp)); // output modifiers
        
        textArea.setText(String.format("%s\n%s\n%s\n", 
            line1, line2, line3)); // output three lines of text
    }
}
