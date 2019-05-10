package RunProject;

import java.awt.FlowLayout; // specifies how components are arranged 
import javax.swing.JFrame; // provides basic window features 
import javax.swing.JLabel; // displays text and images 
import javax.swing.SwingConstants; // common constants used with Swing 
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.Dimension;
import javafx.scene.layout.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.HashMap;
import java.awt.font.TextAttribute;
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images 
import javax.imageio.IIOException;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class TitleScreen extends JPanel
{
    // set panel that can have components added onto it 
    private JPanel panel = new JPanel();
    
    // hold title of game "Capstone RPG" and the name of the game's creator 
    private JLabel title, creator;
    
    // buttons representing options player can take on title screen 
    private JButton newGame, loadGame, settings, exitGame;
    
    // array containins buttons meant to be displayed 
    //private JButton[] buttons;
    
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
    
    // LabelFrame constructor adds JLabels to JFrame 
    public TitleScreen()
    {
        // Create and set up a frame window
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Capstone RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        
        // set color for panel bydecoding string of hexadecimal color 
        panel.setBackground(Color.decode("#4d5461"));
        
        // Set the Boxayout to be Y_AXIS from top to down
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        
        // set panel layout to match that of boxlayout
        panel.setLayout(boxlayout);
        
        // space (border) container must leave at each edge from top, left, bottom, right
        panel.setBorder(new EmptyBorder(new Insets(160, 160, 160, 160)));     

        // create new label for title of project 
        title = newLabel("Capstone RPG", panel, new Font("Impact", Font.BOLD, 56));
        
        // underline title label to signify its importance 
        Font font = title.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        title.setFont(font.deriveFont(attributes));
        
        // add title label to panel 
        panel.add(title);
        
        // add space between title and creator labels 
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        
        // create new label for creator of project 
        creator = newLabel("By Me", panel, new Font("Lucida Sans Unicode", Font.PLAIN, 22));
        
        // add creator label to panel 
        panel.add(creator);
        
        // add space between creator label and buttons 
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        
        // create button for new game which starts a new game upon selection 
        newGame = newButton("New Game", panel, new Font("Serif", Font.PLAIN, 18));
        //newGame.setEnabled(false);
        
        // add new game button to panel 
        //panel.add(newGame);
        
        // create button for load game which loads a saved game upon selection 
        // Note: button is disabled since saving/loading does not exist in this build 
        loadGame = newButton("Load Game", panel, new Font("Serif", Font.PLAIN, 18));
        //loadGame.setEnabled(true);
        
        // add load game button to panel 
        //panel.add(loadGame);
        
        // create button for altering game settings upon selection 
        // Note: button is disabled since settings does not exist in this build 
        settings = newButton("Settings", panel, new Font("Serif", Font.PLAIN, 18));
        //settings.setEnabled(true);
        
        // add settings button to panel 
        //panel.add(settings);
        
        // create button for exiting gameupon selection 
        exitGame = newButton("Exit Game", panel, new Font("Serif", Font.PLAIN, 18));
        //exitGame.setEnabled(false);
        
        // action listener gives button exitGame ability to terminate program 
        exitGame.addActionListener(
            new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Note: code below executes upon clicking button "Exit Game"
                    System.exit(0);
                }
            }
        );  
        
        // add exit game button to panel 
        //panel.add(exitGame);
        
        JButton[] buttons = {newGame, loadGame, settings, exitGame};
        
        for (int i = 0; i < buttons.length; i++) 
        {
            int currentButton = i;
            buttons[i].addKeyListener(enter);
            buttons[i].addKeyListener(
                new KeyAdapter() 
            {
                @Override
                public void keyPressed(KeyEvent e) 
                {
                    switch (e.getKeyCode()) 
                    {
                        case KeyEvent.VK_UP:
                            // move from top button to bottom button 
                            if (currentButton == 0)
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
                            // button traversal in upward direction  
                            else if(currentButton > 0)
                            {
                                // if next button is disabled, find next enabled button 
                                if(!buttons[currentButton - 1].isEnabled())
                                {
                                    JButton tempCurrentButton = buttons[currentButton];
			
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
                                    
                                    if(nextEnabledButtonExists)
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
                                    else
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
                                }
                                // highlight next enabled button 
                                else
                                {
                                    buttons[currentButton - 1].requestFocus();
                                }
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            // move from bottom button to top button 
                            if(currentButton == 3)
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
                            // button traversal in downward direction  
                            else if(currentButton < buttons.length - 1)
                            {
                                // if next button is disabled, find next enabled button 
                                if(!buttons[currentButton + 1].isEnabled())
                                {
                                    JButton tempCurrentButton = buttons[currentButton];
                                    
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
                                    // System.out.println(nextEnabledButtonExists);
                                    if(nextEnabledButtonExists)
                                    {
                                        // loop forward until next enabled button is found 
                                        for(int i = currentButton; i <= buttons.length - 1; i++)
                                        {
                                            System.out.println(buttons[i].getText());
                                            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
                                            {

                                                buttons[i].requestFocus();
                                                    break;
                                            }
                                        }
                                    }
                                    else
                                    {
                                        // loop from start until next enabled button is found 
                                        for(int i = 0; i <= buttons.length - 1; i++)
                                        {
                                            System.out.println(buttons[i].getText());
                                            if(!tempCurrentButton.equals(buttons[i]) && buttons[i].isEnabled())
                                            {

                                                buttons[i].requestFocus();
                                                    break;
                                            }
                                        }
                                    }
                                }
                                // highlight next enabled button 
                                else
                                {
                                    buttons[currentButton + 1].requestFocus();
                                }
                            }
                            break;
                        default:
                            break;
                    }
               }
            });
            
            panel.add(buttons[i]);
        }
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
        MouseHandler handler = new MouseHandler();  
        newGame.addMouseListener(handler);  
        newGame.addMouseMotionListener(handler);
        exitGame.addMouseListener(handler);  
        exitGame.addMouseMotionListener(handler);
        
        
        
        
    }

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

    // MouseAdapter extended to avoid overriding unused methods 
    private class MouseHandler extends MouseAdapter implements MouseWheelListener
    {
        // handle event when mouse enters area 
        @Override
        public void mouseEntered(MouseEvent event)
        {
            JButton button = (JButton)event.getSource();
            button.setFont(new Font("Serif", Font.BOLD, 18));
            
            // need to figure out keyboard stuff...
        }
    
        // handle event when mouse exits area
        @Override
        public void mouseExited(MouseEvent event)
        {
            JButton button = (JButton)event.getSource();
            button.setFont(new Font("Serif", Font.PLAIN, 18));
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) 
        {
            /*
            JButton button = (JButton)e.getSource();
            
            //JButton[] buttons = {newGame, exitGame};
            
            int notches = e.getWheelRotation();
            
            // move up else move down
            if(notches < 0)
            {
                button.mouseEntered(button);
                //mouseEntered();
            }
            else
            {
                button.dispatchEvent(e);
            }
            
            
            if (e.isControlDown()) {
                if (e.getWheelRotation() < 0) {
                    infoLabel.setText("Mouse Wheel Up");
                } else {
                    infoLabel.setText("Mouse Wheel Down");
                }
            } else {
                scrollPane.getListeners(MouseWheelListener.class)[0].mouseWheelMoved(e);
            }
            */
        }
        
    }
    

    
    /*
    private class KeyHandler extends KeyboardAdapter
    {
        
    }
    
    
    public void keyPressed(KeyEvent e) 
    {
        int keyCode = e.getKeyCode();
        
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                // handle up 
                break;
            case KeyEvent.VK_DOWN:
                // handle down 
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                break;
         }
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
    
    */
    
    
    
}
