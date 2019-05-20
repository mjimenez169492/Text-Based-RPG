package RunProject;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Rectangle;




/**
 *
 * @author Miguel
 */
public class CommonGUIMethods 
{
    // START: JBUTTON ARRAY TRAVERSAL 
    // Note: code can be modified to traverse things besides JButton objects 
    /*******************************************************************************/

    // MOVE FORWARD (from last array element to first)
    
    public static void fromFirstToLastButton(JButton[] buttons)
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
    
    public static boolean nextEnabledForwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        boolean nextEnabledButtonExists = false;

        // determine if an enabled button exists further down
        for(int i = currentButton; i <= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && 
                buttons[i].isEnabled())
            {
                nextEnabledButtonExists = true;
                    break;
            }
        }
        
        return nextEnabledButtonExists;
    }
    
    public static void headToNextForwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        // loop backward until next enabled button is found 
        for(int i = currentButton; i >= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && 
                buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    public static void fromLastToNextForwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        // loop from end until next enabled button is found 
        for(int i = buttons.length - 1; i >= 0; i--)
        {
            if(!tempCurrentButton.equals(buttons[i]) && 
                buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    public static void moveForward(int currentButton, JButton[] buttons)
    {
        // move from top button to bottom button 
        if (currentButton == 0)
        {
            fromFirstToLastButton(buttons);
        }
        // button traversal in upward direction  
        else if(currentButton > 0)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton - 1].isEnabled())
            {
                JButton tempCurrentButton = buttons[currentButton];
                
                if(nextEnabledForwardButton(tempCurrentButton, currentButton, buttons))
                {
                    headToNextForwardButton(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromLastToNextForwardButton(tempCurrentButton, currentButton, buttons);
                }
            }
            // head to next enabled button 
            else
            {
                buttons[currentButton - 1].requestFocus();
            }
        }
    }
    
    // MOVE FORWARD (from last array element to first)
    
    
    // MOVE BACKWARD (from first array element to last)
    
    public static void fromLastToFirstButton(JButton[] buttons)
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
    
    public static boolean nextEnabledBackwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        boolean nextEnabledButtonExists = false;

        // determine if an enabled button exists further down
        for(int i = currentButton; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && 
                buttons[i].isEnabled())
            {
                nextEnabledButtonExists = true;
                    break;
            }
        }

        return nextEnabledButtonExists;
    }
    
    public static void headToNextBackwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        // loop forward until next enabled button is found 
        for(int i = currentButton; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    public static void fromFirstToNextBackwardButton(JButton tempCurrentButton, int currentButton, 
        JButton[] buttons)
    {
        // loop from start until next enabled button is found 
        for(int i = 0; i <= buttons.length - 1; i++)
        {
            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
            {
                buttons[i].requestFocus();
                    break;
            }
        }
    }
    
    public static void moveBackward(int currentButton, JButton[] buttons)
    {
        // move from bottom button to top button 
        if(currentButton == buttons.length - 1)
        {
            fromLastToFirstButton(buttons);
        }
        // button traversal in downward direction  
        else if(currentButton < buttons.length - 1)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton + 1].isEnabled())
            {
                JButton tempCurrentButton = buttons[currentButton];
                
                if(nextEnabledBackwardButton(tempCurrentButton, currentButton, buttons))
                {
                    headToNextBackwardButton(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromFirstToNextBackwardButton(tempCurrentButton, currentButton, buttons);
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
    
    public static void buttonColumnKeyboardNavigation(JButton...buttons)
    {
        for (int i = 0; i < buttons.length; i++) 
        {
            int currentButton = i;
            
            buttons[i].addKeyListener(enter);
            
            buttons[i].addKeyListener(new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_UP:
                            moveForward(currentButton, buttons);
                                break;
                        case KeyEvent.VK_DOWN:
                            moveBackward(currentButton, buttons);
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
            
            buttons[i].addKeyListener(enter);
            
            buttons[i].addKeyListener(new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_RIGHT:
                            moveForward(currentButton, buttons);
                                break;
                        case KeyEvent.VK_LEFT:
                            moveBackward(currentButton, buttons);
                                break;
                        default:
                            break;
                    }
               }
            });
        }
    }
    
    // KEY LISTENER AND KEYBOARD NAVIGATION 
    
    /* CONSIDER MAKING OTHER GUI CLASSES SUBCLASSES OF THIS CLASS 
    
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
    */
    
    // MOUSE WHEEL BUTTON AVIGATION 
    
    // Note: mouse wheel rotation results in a series of -1 if moved up and 
    //       a series of 1 if moved down. If mouse rotation is  not checked,
    //       options may be scrolled over several times with a SINGLE mouse 
    //       wheel rotation making comfortable button navigation impossible.
    //       This method is NEEDED to get only one of these series of values 
    public static int getMouseWheelRotationChoice(int...mouseWheelRoatation)
    {
        int[] array = new int[mouseWheelRoatation.length];
        
        for(int i = 0; i <  mouseWheelRoatation.length; i++)
        {
            array[i] = mouseWheelRoatation[i];
        }
        
        return array[0];
    }
    
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
                // move up else move down
                if(getMouseWheelRotationChoice(e.getWheelRotation()) < 0)
                {
                    moveForward(getButtonInFocusArrayPosition(buttons), buttons);
                }
                else
                {
                    moveBackward(getButtonInFocusArrayPosition(buttons), buttons);
                }
           }
        });
    }

    // MOUSE WHEEL BUTTON AVIGATION 
    
    // END: BUTTON COLUMN NAVIGATION USING KEYBOARD AND MOUSE WHEEL
    /*******************************************************************************/
    
    
    
    // START: RESIZE COMPONENT TEXT BASED ON COMPONENT RESIZE EVENT
    /*******************************************************************************/
    
    /*
        protected void decreaseFontSize(JLabel comp) 
        {
            Font font = comp.getFont();
            FontMetrics fm = comp.getFontMetrics(font);
            int width = comp.getWidth();
            int height = comp.getHeight();
            int textWidth = fm.stringWidth(comp.getText());
            int textHeight = fm.getHeight();

            int size = font.getSize();
            while (size > 0 && (textHeight > height || textWidth > width)) {
                size -= 2;
                font = font.deriveFont(font.getStyle(), size);
                fm = comp.getFontMetrics(font);
                textWidth = fm.stringWidth(comp.getText());
                textHeight = fm.getHeight();
            }

            comp.setFont(font);

        }
        
    */
    
    
    
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
}