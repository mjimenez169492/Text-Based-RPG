package RunProject;

import javax.swing.JLabel; 
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.awt.font.TextAttribute;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TitleScreen
{
    // Create a frame window that will be used for the duration of project 
    private JFrame frame = new JFrame("Capstone RPG");
    
    // set panel that can have components added onto it 
    private JPanel panel = new JPanel();
    
    // hold title of game "Capstone RPG" and the name of the game's creator 
    private JLabel title, creator;
    
    // buttons representing options player can take on title screen 
    private JButton newGame, loadGame, settings, exitGame;
    

    
    // START: SET UP FRAME AND PANEL 
    /*******************************************************************************/

    public void setUpFrameAndPanel()
    {
        // allow for termination of project upon selecting exit button 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set color for panel bydecoding string of hexadecimal color 
        panel.setBackground(Color.decode("#4d5461"));
        
        // Set the Boxayout to be Y_AXIS from top to down
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        
        // set panel layout to match that of boxlayout
        panel.setLayout(boxlayout);
        
        // space (border) container must leave at each edge from top, left, bottom, right
        panel.setBorder(new EmptyBorder(new Insets(110, 125, 110, 125)));
    }
    
    // END: SET UP FRAME AND PANEL 
    /*******************************************************************************/

    
    
    // START: LABEL AND BUTTON CREATION 
    /*******************************************************************************/

    public JLabel newLabel(String labelName, JPanel panel, Font desireFont)
    {
        JLabel newLabel = new JLabel(labelName);
        newLabel.setFont(desireFont);
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        newLabel.setForeground(Color.BLACK);
        return newLabel;
    }
    
    public JButton newButton(String buttonName, JPanel panel, Font desireFont)
    {
        JButton newButton = new JButton(buttonName);
        newButton.setFont(desireFont);
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newButton.setForeground(Color.WHITE);
        newButton.setBackground(Color.decode("#4d5461"));
        
        // button size by width and by height for uniform button appearance 
        newButton.setMinimumSize(new Dimension(110, 30));
        newButton.setMaximumSize(new Dimension(125, 35));
        newButton.setPreferredSize(new Dimension(110, 30));
        
        return newButton;
    }
    
    // START: LABEL AND BUTTON CREATION 
    /*******************************************************************************/

    
    
    // START: SET UP LABELS AND TITLE SCREEN BUTTONS 
    /*******************************************************************************/

    public void setUpTitleAndCreatorLabel()
    {
        // create new label for title of project 
        title = newLabel("Capstone RPG", panel, new Font("Impact", Font.BOLD, 56));
        
        // underline title label to signify its importance 
        Font font = title.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        title.setFont(font.deriveFont(attributes));
        
        // add space between title and creator labels 
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        
        // create new label for creator of project 
        creator = newLabel("By Me", panel, new Font("Lucida Sans Unicode", Font.PLAIN, 22));
    }    
    
    public void titleScreenButtons()
    {
        // create button for new game which starts a new game upon selection 
        newGame = newButton("New Game", panel, new Font("Serif", Font.PLAIN, 18));
        
        // action listener gives button newGame ability to start a new game 
        newGame.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Note: code below executes upon clicking button "New Game"
                        // remove all components on frame 
                    //frame.getContentPane().removeAll();
                    TestClass o = new TestClass();
                    
                    
                }
            }
        ); 
        
        // create button for load game which loads a saved game upon selection 
        // Note: button is disabled since saving/loading does not exist in this build 
        loadGame = newButton("Load Game", panel, new Font("Serif", Font.PLAIN, 18));
            loadGame.setEnabled(false);
        

        // create button for settinfs which allows player to alter game settings 
        // Note: button is disabled since settings does not exist in this build 
        settings = newButton("Settings", panel, new Font("Serif", Font.PLAIN, 18));
            settings.setEnabled(false);
        
        // create button for exiting game upon selection 
        exitGame = newButton("Exit Game", panel, new Font("Serif", Font.PLAIN, 18));
        
        // action listener gives button exitGame ability to terminate program 
        exitGame.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Note: code below executes upon clicking button "Exit Game"
                        // terminate the program 
                    System.exit(0);
                }
            }
        ); 
    }
    
    // END: SET UP LABELS AND TITLE SCREEN BUTTONS 
    /*******************************************************************************/

    
    
    // START: ADDING COMPONENTS TO FRAME 
    /*******************************************************************************/

    public void addComponentsToPanel(JPanel panel, JLabel title, JLabel creator,
        JButton newGame, JButton loadGame, JButton settings, JButton exitGame)
    {
        panel.add(title);
        panel.add(creator);
        
        panel.add(newGame);
        panel.add(loadGame);
        panel.add(settings);
        panel.add(exitGame);
    }
    
    // END: ADDING COMPONENTS TO FRAME 
    /*******************************************************************************/

    
    
    // START: JBUTTON ARRAY TRAVERSAL 
    // Note: code can be modified to traverse things besides JButton objects 
    /*******************************************************************************/

    // MOVE UP (from last array element to first)
    
    public void fromTopToBottomButton(JButton[] buttons)
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
    
    public boolean nextEnabledUpwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void headToNextUpwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void fromLastToNextUpwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void moveUp(int currentButton, JButton[] buttons)
    {
        // move from top button to bottom button 
        if (currentButton == 0)
        {
            fromTopToBottomButton(buttons);
        }
        // button traversal in upward direction  
        else if(currentButton > 0)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton - 1].isEnabled())
            {
                JButton tempCurrentButton = buttons[currentButton];
                
                if(nextEnabledUpwardButton(tempCurrentButton, currentButton, buttons))
                {
                    headToNextUpwardButton(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromLastToNextUpwardButton(tempCurrentButton, currentButton, buttons);
                }
            }
            // head to next enabled button 
            else
            {
                buttons[currentButton - 1].requestFocus();
            }
        }
    }
    
    // MOVE UP (from last array element to first)
    
    
    // MOVE DOWN (from first array element to last)
    
    public void fromBottomToTopButton(JButton[] buttons)
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
    
    public boolean nextEnabledDownwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void headToNextDownwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void fromFirstToNextUpwardButton(JButton tempCurrentButton, int currentButton, 
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
    
    public void moveDown(int currentButton, JButton[] buttons)
    {
        // move from bottom button to top button 
        if(currentButton == 3)
        {
            fromBottomToTopButton(buttons);
        }
        // button traversal in downward direction  
        else if(currentButton < buttons.length - 1)
        {
            // if next button is disabled, find next enabled button 
            if(!buttons[currentButton + 1].isEnabled())
            {
                JButton tempCurrentButton = buttons[currentButton];
                
                if(nextEnabledDownwardButton(tempCurrentButton, currentButton, buttons))
                {
                    headToNextDownwardButton(tempCurrentButton, currentButton, buttons);
                }
                else
                {
                    fromFirstToNextUpwardButton(tempCurrentButton, currentButton, buttons);
                }
            }
            // head next enabled button 
            else
            {
                buttons[currentButton + 1].requestFocus();
            }
        }
    }
    
    // MOVE DOWN (from first array element to last)
    
    // END: JBUTTON ARRAY TRAVERSAL
    /*******************************************************************************/

    
    
    // START: BUTTON COLUMN NAVIGATION USING KEYBOARD AND MOUSE WHEEL
    /*******************************************************************************/

    // KEY LISTENER AND KEYBOARD NAVIGATION 
    
    private KeyListener enter = new KeyAdapter() 
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
    
    public void buttonColumnKeyboardNavigation(JButton...buttons)
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
                            moveUp(currentButton, buttons);
                                break;
                        case KeyEvent.VK_DOWN:
                            moveDown(currentButton, buttons);
                                break;
                        default:
                            break;
                    }
               }
            });
        }
    }
    
    // KEY LISTENER AND KEYBOARD NAVIGATION 
    
    
    // MOUSE WHEEL BUTTON AVIGATION 
    
    // Note: mouse wheel rotation results in a series of -1 if moved up and 
    //       a series of 1 if moved down. If mouse rotation is  not checked,
    //       options may be scrolled over several times with a SINGLE mouse 
    //       wheel rotation making comfortable button navigation impossible.
    //       This method is NEEDED to get only one of these series of values 
    public int getMouseWheelRotationChoice(int...mouseWheelRoatation)
    {
        int[] array = new int[mouseWheelRoatation.length];
        
        for(int i = 0; i <  mouseWheelRoatation.length; i++)
        {
            array[i] = mouseWheelRoatation[i];
        }
        
        return array[0];
    }
    
    public int getButtonInFocusArrayPosition(JButton...buttons)
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
    
    public void frameMouseWheel(JPanel panel, JButton...buttons)
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
                    moveUp(getButtonInFocusArrayPosition(newGame, loadGame,
                        settings, exitGame), buttons);
                }
                else
                {
                    moveDown(getButtonInFocusArrayPosition(newGame, loadGame,
                        settings, exitGame), buttons);
                }
           }
        });
    }

    // MOUSE WHEEL BUTTON AVIGATION 
    
    // END: BUTTON COLUMN NAVIGATION USING KEYBOARD AND MOUSE WHEEL
    /*******************************************************************************/

    
    
    // START: MOUSEHANDLER AND MOUSEWHEELLISTENER FOR COMPONENTS 
    /*******************************************************************************/

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
    
    public void attachHandlersToComponents(JFrame frame, JLabel title, JLabel creator,
        JButton newGame, JButton loadGame, JButton settings, JButton exitGame)
    {
        MouseHandler handler = new MouseHandler();  
        
        frame.addMouseWheelListener(handler);
        
        //newGame.addMouseListener(handler);  
        //newGame.addMouseMotionListener(handler);
        
        //loadGame.addMouseListener(handler);  
        //loadGame.addMouseMotionListener(handler);
        
        //settings.addMouseListener(handler);  
        //settings.addMouseMotionListener(handler);
        
        //exitGame.addMouseListener(handler);  
        //exitGame.addMouseMotionListener(handler);
    }
    
    // END: MOUSEHANDLER AND MOUSEWHEELLISTENER FOR COMPONENTS 
    /*******************************************************************************/

    
    
    // START: DISPLAY FRAME WINDOW 
    /*******************************************************************************/

    public void displayFrameWindow(JFrame frame, JPanel panel)
    {
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(640, 480);
        
        Rectangle r = frame.getBounds();
        System.out.print("frame height :"+r.height);
        System.out.print("frame width :"+r.width);
    }
    
    // END: DISPLAY FRAME WINDOW 
    /*******************************************************************************/

    
    
    // START: CONSTRUCTOR 
    /*******************************************************************************/

    // constructor used to create and display title screen of project 
    public TitleScreen()
    {
        setUpFrameAndPanel();
        
        setUpTitleAndCreatorLabel();

        // add space between labels and buttons 
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        
        titleScreenButtons();
        
        // account for keyboard button navigation 
        buttonColumnKeyboardNavigation(newGame, loadGame, settings, exitGame);
        
        // account for mouse wheel movement for frame (move while outside frame)
        frameMouseWheel(panel, newGame, loadGame, settings, exitGame);
        
        // add appropriate mouse handlers to compoenents 
        attachHandlersToComponents(frame, title, creator, newGame, loadGame, settings, exitGame);
        
        // add components to panel of JFrame 
        addComponentsToPanel(panel, title, creator, newGame, loadGame, settings, exitGame);
        
        // display frame window with components 
        displayFrameWindow(frame, panel);
    }

    // END: CONSTRUCTOR 
    /*******************************************************************************/
}
