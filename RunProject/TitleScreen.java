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
    
    public JButton newButton(String buttonName, JPanel panel, Font font)
    {
        JButton newButton = new JButton(buttonName);
        newButton.setFont(font);
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
        newGame.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Note: code below executes upon clicking button "New Game"
                        // remove all components on frame 
                    //frame.getContentPane().removeAll();
                    ExpositionBox o = new ExpositionBox();
                    
                    
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
        
        newGame.addMouseListener(handler);  
        newGame.addMouseMotionListener(handler);
        
        loadGame.addMouseListener(handler);  
        loadGame.addMouseMotionListener(handler);
        
        settings.addMouseListener(handler);  
        settings.addMouseMotionListener(handler);
        
        exitGame.addMouseListener(handler);  
        exitGame.addMouseMotionListener(handler);
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
        CommonGUIMethods.buttonColumnKeyboardNavigation(newGame, loadGame, settings, exitGame);
        
        // account for mouse wheel movement for frame (move while outside frame)
        CommonGUIMethods.frameMouseWheel(frame, newGame, loadGame, settings, exitGame);
        
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
