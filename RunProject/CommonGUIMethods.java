package RunProject;

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
    
    public static void frameMouseWheel(JFrame frame, JButton...buttons)
    {
        frame.addMouseWheelListener(
            new MouseAdapter() 
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) 
            {
System.out.println(e.getWheelRotation());
                
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
    
    
    
    // START: RESIZE COMPONENT TEXT BASED ON COMPONENT RESIZE EVENT
    /*******************************************************************************/

    public static void resizeButtonTextUsingFrameSize(JFrame frame, JButton button)
    {
        button.addComponentListener(
            new ComponentAdapter() 
            {
                private final int baseFrameWidth = 640;
                private final int baseFrameHeight = 480;
                private final int baseFontSize = 16;
                
                public void setButtonFontSize(JButton button, int size)
                {
                    // set size of font for text inside button to size specified 
                    // Note: getStyle() gets font type (like "Times New Roman") 
                    //       and plain/bold/italic state for given text
                    button.setFont(button.getFont().deriveFont(button.getFont().
                        getStyle(), size));
                }
                
                public void resetFontSizeToDefaultValue(JFrame frame, JButton button)
                {
                    if(frame.getWidth() == 640 && frame.getHeight() == 480)
                    {
                        setButtonFontSize(button, baseFontSize);
                    }
                }
                
                // incrase font size if height or width of frame exceeeds base frame
                public void incrementButtonFontSize(JFrame frame, JButton button)
                {
                    // incrase button font size if frame is strecthed horizontally and vertically  
                    if (frame.getHeight() > 480 && frame.getWidth() > 640)
                    {
                        // determine new frame width by using base frame width
                        double newFrameWidth = frame.getWidth() - 640;
                        
                        // determine new frame width by using base frame width
                        double newFrameHeight = frame.getHeight() - 480;
                        
                        // for diagonal frame expansion, need to sum the new frame
                        // and height and divide sum by 22 (difference between max
                        // and base font sizes) to get number of pixels (46) which
                        // is number of pixels that must be traversed to increment 
                        // font size by 1. Value is then added to base font size. 
                        double newFontSize = (((newFrameWidth + newFrameHeight) / 
                            46.0) + baseFontSize); 
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    }
                    // incrase button font size if frame is strecthed horizontally 
                    else if(frame.getWidth() > 640)
                    {
                        // determine new frame width using base frame width
                        double newFrameWidth = frame.getWidth() - 640;
                        
                        // since max screen width for my computer is 1366 pixels, 
                        // the difference between max screen width and base frame 
                        // width is 726. Value is then divided by 22 (number that
                        // represents difference between base font size of 18 and
                        // max font size of 40) to get 33 which represents pixels
                        // that must be traversed to increment by 1 font size 
                        double newFontSize = (newFrameWidth / 33);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    }
                        // code is broken
                    // incrase button font size if frame is strecthed vertically  
                    else if (frame.getHeight() > 480)
                    {
                        // determine new frame width using base frame width
                        double newFrameHeight = frame.getHeight() - 480;
                        
                        // since max screen height for my computer is 768 pixels, 
                        // the difference between max screen height and base frame 
                        // height is 288. Value is then divided by 22 (number that
                        // represents difference between base font size of 18 and
                        // max font size of 40) to get 13 which represents pixels
                        // that must be traversed to increment by 1 font size 
                        double newFontSize = (newFrameHeight / 13) + baseFontSize;
                        System.out.println("NO" + newFontSize);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    }
                }
                
                // sort of works? 
                public void uniqueFrameHeightAndWidthCases()
                {
                    // java - get screen size using the Toolkit class
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        //screenSize.width: 1366 -> 40 font size
                        //screenSize.height: 768 -> 40 font size
                    
                    if(frame.getHeight() > (screenSize.getHeight() - 55) && frame.getWidth() < 640)
                    {
                        // determine new frame width by using base frame width
                        double newFrameHeight = frame.getHeight() - 480;
                        double newFontSizeHeight = (newFrameHeight / 13);
                        
                        // determine new frame width by using base frame width
                        double newFrameWidth =  640 - frame.getWidth();
                        double newFontSizeWidth = (newFrameWidth / 36);
                        
                        double resultingFontSize = (newFontSizeHeight - newFontSizeWidth);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)resultingFontSize);
                    }
                    else if(frame.getHeight() < 480 && frame.getWidth() > 640)
                    {
                        double newFrameHeight = 480 - frame.getHeight();
                        double newFontSizeHeight = (newFrameHeight / 27);
                        
                        double newFrameWidth = frame.getWidth() - 640;
                        double newFontSizeWidth = (newFrameWidth / 33) + baseFontSize;
                        
                        double resultingFontSize = (newFontSizeWidth - newFontSizeHeight);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)resultingFontSize);
                    }
                }
                
                // decrase font size if height or width of frame is less than base frame
                public void decrementButtonFontSize(JFrame frame, JButton button)
                {
                    // incrase button font size if frame is strecthed horizontally and vertically  
                    if (frame.getHeight() < 480 && frame.getWidth() < 640)
                    {
                        // determine new frame width by using base frame width
                        double newFrameWidth = 640 - frame.getWidth();
                        
                        // determine new frame width by using base frame width
                        double newFrameHeight = 480 - frame.getHeight();
                        
                        // for diagonal frame minimization, need to sum new frame
                        // and height and divide it by 63 (sum of pixels for (640 
                        // / base font size) and (480 / base font size) in order 
                        // to get font size that will be subtracted from the base 
                        // font size 18 
                        double newFontSize = (18.0 - ((newFrameWidth + newFrameHeight) 
                            / 63.0)); 
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    } 
                    // decrease button font size if frame is minimized horizontally 
                    else if(frame.getWidth() < 640)
                    {
                        // determine new frame width by using base frame width
                        double newFrameWidth =  640 - frame.getWidth();
                        
                        // for minimization, font ranges from 1 - base font (1 - 18)
                        // where minimum pixel width is 1 and maximum pixel width is 
                        // 640. Frame size / base font size (640 / 18) results in 36
                        // which is pixels that must be traversed per font size 
                        double newFontSize = baseFontSize - (newFrameWidth / 36);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    }
                    // decrease button font size if frame is strecthed vertically  
                    else if (frame.getHeight() < 480)
                    {
                        // determine new frame height by using base frame height
                        double newFrameHeight = 480 - frame.getHeight();
                        
                        // for minimization, font ranges from 1 - base font (1 - 18)
                        // where minimum pixel width is 1 and maximum pixel width is 
                        // 480. Frame size / base font size (480 / 18) results in 27
                        // which is pixels that must be traversed per font size 
                        double newFontSize = baseFontSize - (newFrameHeight / 27);
                        
                        // set new font size for button text
                        setButtonFontSize(button, (int)newFontSize);
                    }
                }
                
                @Override
                public void componentResized(ComponentEvent e) 
                {
                    // cast source of component event as button
                    JButton button = (JButton)e.getComponent();
                    
                    if(frame.getWidth() == baseFrameWidth || frame.getHeight() == baseFrameHeight)
                    {
                        resetFontSizeToDefaultValue(frame, button);
                    }
                    else if(frame.getWidth() > baseFrameWidth || frame.getHeight() > baseFrameHeight)
                    {
                        incrementButtonFontSize(frame, button);
                        
                        // account for unique frame width and height cases 
                        uniqueFrameHeightAndWidthCases();
                    }
                    else
                    {
                        decrementButtonFontSize(frame, button);
                    }
                }
            }
        );
    }
    
    // allow for text to resize (somewhat) upon change in frame size...
    // text resizes within buttons according to frame size itself
    // Note: this is done since buttons are designed to resize on their onw 
    public void textResizesUponComponentResize(JFrame frame, JButton...array)
    {
        for(JButton element : array)
        {
            if(element != null)
            {
                CommonGUIMethods.resizeButtonTextUsingFrameSize(frame, element);
            }
        }
    }
    
    // END: RESIZE COMPONENT TEXT BASED ON COMPONENT RESIZE EVENT
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
