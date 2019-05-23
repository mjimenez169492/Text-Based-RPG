package GUI_Collection;

import GUI_Collection.CommonGUIMethods;
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
import java.awt.event.ActionEvent;

/*
    IntroBox is a GUI for showing the title screen of the porject seen upon
    start up. This is the first GUI I ever made and it should be considered as
    an example of how NOT to make a GUI on account of how messy it is in terms
    of how it is coded.
*/

public class IntroBox extends CommonGUIMethods
{
    // set name for frame on top left of frame 
    private JFrame frame = new JFrame("Capstone RPG");
        
    // set panel that can have components added onto it 
    private JPanel panel = new JPanel();
    
    // hold title of game "Capstone RPG" and the name of the game's creator 
    private JLabel title, creator;
    
    // buttons representing options player can take on title screen 
    private JButton newGame, loadGame, settings, exitGame;
    
    
    
    // START: PREPARE JPANEL FOR COMPONENTS
    /*******************************************************************************/

    public void prepareJPanelForComponents()
    {
        panel.setBackground(Color.WHITE);
        
        // Set Boxlayout to be Y_AXIS so components are placed in column format
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // space (border) container must leave at each edge from top, left, bottom, right
        panel.setBorder(new EmptyBorder(new Insets(110, 125, 110, 125)));
    }
    
    // END: PREPARE JPANEL FOR COMPONENTS
    /*******************************************************************************/

    
    
    // START: LABEL AND BUTTON CREATION 
    /*******************************************************************************/

    public JLabel newLabel(String labelName, JPanel panel, Font font)
    {
        // create new label 
        JLabel newLabel = new JLabel(labelName);
        
        // font for label that includes font type, font thickness and font size 
        newLabel.setFont(font);
        
        // text alignment for label 
        newLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // color of text for label 
        newLabel.setForeground(Color.BLACK);
        
        return newLabel;
    }
    
    public void setUpTitleAndCreatorLabel(JPanel panel)
    {
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
        creator = newLabel("Developed By: Miguel Jimenez", panel, new Font("Lucida Sans Unicode", Font.PLAIN, 22));
        
        // add creator label to panel
        panel.add(creator);
        
        // add space between creator label and button components 
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
    }    
    
    public JButton newButton(String buttonName, JPanel panel, Font font)
    {
        // create new button component with supplied text
        JButton button = new JButton(buttonName);
        
        // font for button that includes font type, font thickness and font size 
        button.setFont(font);
        
        // text alignment for button 
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // set button size by width and by height for uniform button appearance 
        button.setMinimumSize(new Dimension(110, 30));
        button.setMaximumSize(new Dimension(125, 35));
        button.setPreferredSize(new Dimension(110, 30));
        
        return button;
    }
    
    public void titleScreenButtons(JPanel panel, JFrame frame)
    {
        // create button for new game which starts a new game upon selection 
        newGame = newButton("New Game", panel, new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
            // action listener gives button newGame ability to start a new game 
            newGame.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // signify that Gui is complete 
                        guiComplete(true);
                        
                        // terminates program currently running on Java Virtual Machine
                        // and return all memory used by program back to OS
                            // System.exit.(0);

                        // Note: dispose() can be used to close a single window if a
                        //       program has many windows displayed

                        // release all native screen resources, subcomponents, and all 
                        // of its owned children; in other words, close GUI and allow  
                        // program to continue running IF other windows are available 
                        frame.dispose();
                    }
                }
            ); 
                panel.add(newGame);
        
        // create button for load game which loads a saved game upon selection 
        // Note: button is disabled since saving/loading does not exist in this build 
        loadGame = newButton("Load Game", panel, new Font(Font.MONOSPACED, Font.PLAIN, 14));
            loadGame.setEnabled(false);
                panel.add(loadGame);

        // create button for settinfs which allows player to alter game settings 
        // Note: button is disabled since settings does not exist in this build 
        settings = newButton("Settings", panel, new Font(Font.MONOSPACED, Font.PLAIN, 14));
            settings.setEnabled(false);
                panel.add(settings);
        
        // create button for exiting game upon selection 
        exitGame = newButton("Exit Game", panel, new Font(Font.MONOSPACED, Font.PLAIN, 14));
        
            // action listener gives button exitGame ability to terminate program 
            exitGame.addActionListener(
                new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // terminate program upon clicking button "Exit Game"
                        System.exit(0);
                    }
                }
            ); 
                panel.add(exitGame);
                
        frame.add(panel);
    }
    
    // START: LABEL AND BUTTON CREATION 
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

    
    
    // START: CONSTRUCTOR 
    /*******************************************************************************/

    // constructor used to create and display title screen of project 
    public IntroBox()
    {
        // prepare JPanel for components by changing certain properties 
        prepareJPanelForComponents();
        
        // set up and add labels for title screen to panel
        setUpTitleAndCreatorLabel(panel);

        // add space between labels and buttons 
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        
        // add buttons with diffeent functions to title screen
        titleScreenButtons(panel, frame);
        
        // account for keyboard and mouse wheel (sort of works) button navigation 
        buttonColumnKeyboardNavigation(newGame, loadGame, settings, exitGame);
        frameMouseWheel(frame, newGame, loadGame, settings, exitGame);
        
        // add appropriate mouse handlers to compoenents 
        attachHandlersToComponents(frame, title, creator, newGame, loadGame, settings, exitGame);
        
        // display frame window with components 
        displayFrameWindow(frame);
    }

    // END: CONSTRUCTOR 
    /*******************************************************************************/
}
