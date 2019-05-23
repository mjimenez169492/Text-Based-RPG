package GUI_Collection;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;

public class CommonGUIMethods 
{
    // signifies whether GUI has terminated successfully
    private boolean guiComplete = false;
    
    // When formatting text displayed under certain fonts, it is possible for 
    // text to be displayed "incorrectly" or in an unintended fashion since 
    // characters may not have the same width. Font "Monospaced" alleviates 
    // this problem by making letters the same width-wise
    private static Font buttonFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
    private static Font JListFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);

    
    
    // START: TRACKING GUI COMPLETE STATE
    /*******************************************************************************/

    public void guiComplete(boolean guiComplete)
    {
        this.guiComplete = guiComplete;
    }
    
    public boolean guiComplete()
    {
        return guiComplete;
    }
    
    // END: TRACKING GUI COMPLETE STATE
    /*******************************************************************************/

    
    
    // START: GETTING FONT FOR COMPONENTS
    /*******************************************************************************/

    public Font getButtonFont()
    {
        return buttonFont;
    }
    
    public Font getJListFont()
    {
        return JListFont;
    }
    
    // END: GETTING FONT FOR COMPONENTS
    /*******************************************************************************/

    
    
    // START: JBUTTON ARRAY TRAVERSAL 
    // Note: code can be modified to traverse components besides JButton objects 
    /*******************************************************************************/

    // MOVE BACKWARD (from last array element to first)
    
    // move from last button at position n - 1 to first button at position 0
    public static void fromLastToFirstButton(JButton[] buttons)
    {
        for(int i = buttons.length - 1; i >= 0; i--)
        {
            if(buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    // determine if an enabled button exists while traversing to array head 
    public static boolean nextButtonTowardHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        boolean nextEnabledButtonExists = false;

        for(int i = currentButton; i <= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                nextEnabledButtonExists = true;
                    break;
            }
        }
        
        return nextEnabledButtonExists;
    }
    
    // move from current button to next enabled button while traversing to array head 
    public static void headToNextButtonTowardHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        for(int i = currentButton; i >= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    // loop from end of array to first button of array and move backward until next enabled button is found 
    public static void fromLastToNextButtonFromHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        for(int i = buttons.length - 1; i >= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    // move from current button position to head of array
    public static void moveTowardStartOfButtonArray(int currentButton, JButton[] buttons)
    {
        // move from first button to last button (start moving from end of array)
        if(currentButton == 0)
        {
            fromLastToFirstButton(buttons);
        }
        // button traversal toward head of array 
        else if(currentButton > 0)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton - 1].isEnabled())
            {
                // use location of current button to store current button 
                JButton tempCurrentButton = buttons[currentButton];
                
                // Note: tempCurrentButton and its position currentButton are needed 
                //       to ensure that program does not step out of array bounds 
                if(nextButtonTowardHead(tempCurrentButton, currentButton, buttons))
                {
                    headToNextButtonTowardHead(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromLastToNextButtonFromHead(tempCurrentButton, currentButton, buttons);
                }
            }
            // head to next enabled button 
            else
            {
                buttons[currentButton - 1].requestFocus();
            }
        }
    }
    
    // MOVE BACKWARD (from last array element to first)
    
    
    // MOVE Forward (from first array element to last)
    
    // move from first button at position 0 to last button at position n - 1
    public static void fromFirstToLastButton(JButton[] buttons)
    {
        for(int i = 0; i <= buttons.length - i; i++)
        {
            if(buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    // determine if an enabled button exists while traversing from array head 
    public static boolean nextButtonFromHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        boolean nextEnabledButtonExists = false;

        for(int i = currentButton; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                nextEnabledButtonExists = true;
                    break;
            }
        }

        return nextEnabledButtonExists;
    }
    
    // move from current button to next enabled button while traversing away from array head 
    public static void headToNextButtonFromHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        for(int i = currentButton; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    // loop from start of array to last element of array and move forward until next enabled button is found 
    public static void fromFirstToNextButtonAwayFromHead(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        for(int i = 0; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    public static void moveTowardEndOfButtonArray(int currentButton, JButton[] buttons)
    {
        // move from last button to first button (start moving from start of array)
        if(currentButton == buttons.length - 1)
        {
            fromFirstToLastButton(buttons);
        }
        // button traversal from head of array 
        else if(currentButton < buttons.length - 1)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton + 1].isEnabled())
            {
                // use location of current button to store current button 
                JButton tempCurrentButton = buttons[currentButton];
                
                // Note: tempCurrentButton and its position currentButton are needed 
                //       to ensure that program does not step out of array bounds 
                if(nextButtonFromHead(tempCurrentButton, currentButton, buttons))
                {
                    headToNextButtonFromHead(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromFirstToNextButtonAwayFromHead(tempCurrentButton, currentButton, buttons);
                }
            }
            // head next enabled button 
            else
            {
                buttons[currentButton + 1].requestFocus();
            }
        }
    }
    
    // MOVE BACKWARD (from first array element to last)
    
    // END: JBUTTON ARRAY TRAVERSAL
    /*******************************************************************************/

    
    
    // START: BUTTON COLUMN NAVIGATION USING KEYBOARD AND MOUSE WHEEL
    /*******************************************************************************/

    // KEY LISTENER AND KEYBOARD NAVIGATION 
    
    public static KeyListener enter = new KeyAdapter() 
    {
        @Override
        public void keyTyped(KeyEvent e) 
        {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) 
            {
                ((JButton) e.getComponent()).doClick();
            }
        }
    };
    
    private static KeyListener holdColumnKeyEvent = enter;
    
    public static void buttonColumnKeyboardNavigation(JButton...buttons)
    {
        for (int i = 0; i < buttons.length; i++) 
        {
            int currentButton = i;
            
            // Note: if key listener is not pre-emptively removed at start of
            //       each loop then "enter" key will be pressed twice since 
            //       enter key event is supplied to activate loop and again
            //       once player starts moving through keys 
            buttons[i].removeKeyListener(holdColumnKeyEvent);
            buttons[i].addKeyListener(holdColumnKeyEvent);
            
            buttons[i].addKeyListener(new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_UP:
                            moveTowardStartOfButtonArray(currentButton, buttons);
                                break;
                        case KeyEvent.VK_DOWN:
                            moveTowardEndOfButtonArray(currentButton, buttons);
                                break;
                        default:
                            break;
                    }
               }
            });
        }
    }
    
    public static void buttonRowKeyboardNavigation(JButton...buttons)
    {
        for (int i = 0; i < buttons.length; i++) 
        {
            int currentButton = i;
            
            // Note: if key listener is not pre-emptively removed at start of
            //       each loop then "enter" key will be pressed twice since 
            //       enter key event is supplied to activate loop and again
            //       once player starts moving through keys 
            buttons[i].removeKeyListener(holdColumnKeyEvent);
            buttons[i].addKeyListener(holdColumnKeyEvent);
            
            buttons[i].addKeyListener(new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_RIGHT:
                            moveTowardStartOfButtonArray(currentButton, buttons);
                                break;
                        case KeyEvent.VK_LEFT:
                            moveTowardEndOfButtonArray(currentButton, buttons);
                                break;
                        default:
                            break;
                    }
               }
            });
        }
    }
    
    // KEY LISTENER AND KEYBOARD NAVIGATION 
    
    
    // MOUSE WHEEL BUTTON NAVIGATION 
    
    public static int getButtonInFocusArrayPosition(JButton...buttons)
    {
        int position = 0;
        
        for(int i = 0; i < buttons.length; i++)
        {
            if(buttons[i].isFocusOwner())
            {
                position = i;
            }
        }
        
        return position;
    }
    
    // Note: ineffective method since rotation scheme changes from mouse to mouse 
    public static void frameMouseWheel(JFrame frame, JButton...buttons)
    {
        frame.addMouseWheelListener(
            new MouseAdapter() 
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) 
            {
                // move up else move down
                if(e.getWheelRotation() < 0)
                {
                    moveTowardStartOfButtonArray(getButtonInFocusArrayPosition(buttons), buttons);
                }
                else
                {
                    moveTowardEndOfButtonArray(getButtonInFocusArrayPosition(buttons), buttons);
                }
           }
        });
    }

    // MOUSE WHEEL BUTTON NAVIGATION 
    
    // END: BUTTON COLUMN NAVIGATION USING KEYBOARD AND MOUSE WHEEL
    /*******************************************************************************/
    
    
    
    // START: UNSORTED METHODS 
    /*******************************************************************************/
    
    public String desiredSpaces(int spaces)
    {
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < spaces; i++)
        {
            builder.append(" ");
        }
        
        return builder.toString();
    }
    
    // Note: spaces are used to make value Strings appear aligned 
    public void appendGaugeValueToStringBuilder(StringBuilder builder, double valueAsDouble,
        String valueAsString)
    {
        if(valueAsDouble < 10)
        {
            builder.append(desiredSpaces(3));
        }
        else if(valueAsDouble < 100)
        {
            builder.append(desiredSpaces(2));
        }
        else if(valueAsDouble < 1000)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(valueAsString);
    }
    
    public String formatCurrentMaxGauges(double currentValue, double maximumValue)
    {
        String curValue = String.valueOf(currentValue);
        
        String maxValue = String.valueOf(maximumValue);
        
        StringBuilder builder = new StringBuilder();
        
        appendGaugeValueToStringBuilder(builder, currentValue, curValue);
        
        builder.append(" / ");
        
        appendGaugeValueToStringBuilder(builder, maximumValue, maxValue);
        
        return builder.toString();
    }
    
    public String formatExperience(double suppliedValue)
    {
        String value = String.valueOf(suppliedValue);
        
        StringBuilder builder = new StringBuilder();
        
        if(suppliedValue < 10)
        {
            builder.append(desiredSpaces(8));
        }
        else if(suppliedValue < 100)
        {
            builder.append(desiredSpaces(7));
        }
        else if(suppliedValue < 1000)
        {
            builder.append(desiredSpaces(6));
        }
        else if(suppliedValue < 10000)
        {
            builder.append(desiredSpaces(5));
        }
        else if(suppliedValue < 100000)
        {
            builder.append(desiredSpaces(4));
        }
        else if(suppliedValue < 1000000)
        {
            builder.append(desiredSpaces(3));
        }
        else if(suppliedValue < 10000000)
        {
            builder.append(desiredSpaces(1));
        }
        else if(suppliedValue < 100000000)
        {
            builder.append(desiredSpaces(1));
        }
        
        builder.append(value);
        
        return builder.toString();
    }
    
    // END: UNSORTED METHODS 
    /*******************************************************************************/

    
    
    // START: FRAME RELATED METHODS
    /*******************************************************************************/

    // display frame window with functionalities designated below 
    public static void displayFrameWindow(JFrame frame)
    {
        frame.pack();
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // END: FRAME RELATED METHODS
    /*******************************************************************************/
}
