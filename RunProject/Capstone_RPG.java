package RunProject;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capstone_RPG extends JPanel 
{
    public static void main (String args[]) 
    {
        TitleScreen labelFrame = new TitleScreen(); 
    //labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    //labelFrame.setSize(280, 180); 
    //labelFrame.setVisible(true); 
    }
}

/*
public class Capstone_RPG extends JPanel 
{

   private JButton[] buttons = new JButton[4];

   public Capstone_RPG(int row) 
   {
      super(new GridLayout(0, 1));
      buttons = new JButton[row];
      for (int i = 0; i < buttons.length; i++) 
      {
          final int curRow = i;
            buttons[i] = new JButton();
            buttons[i].addKeyListener(enter);
            buttons[i].addKeyListener(new KeyAdapter() 
            {
               @Override
               public void keyPressed(KeyEvent e) 
               {
                  switch (e.getKeyCode()) 
                  {
                  case KeyEvent.VK_UP:
                     if (curRow > 0)
                        buttons[curRow - 1].requestFocus();
                     break;
                  case KeyEvent.VK_DOWN:
                     if (curRow < buttons.length - 1)
                        buttons[curRow + 1].requestFocus();
                     break;
                     
                  case KeyEvent.VK_LEFT:
                     if (curCol > 0)
                        buttons[curRow][curCol - 1].requestFocus();
                     break;
                  case KeyEvent.VK_RIGHT:
                     if (curCol < buttons[curRow].length - 1)
                        buttons[curRow][curCol + 1].requestFocus();
                     break;
                     
                  default:
                     break;
                  }
               }
            });
            add(buttons[i]);
         }
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

   public static void main(String[] args) 
{
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Capstone_RPG(4));
      f.pack();
      f.setVisible(true);
   }
}

*/

/*

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capstone_RPG extends JPanel {

   private JButton[][] buttons;

   public Capstone_RPG(int row, int col) {
      super(new GridLayout(row, col));
      buttons = new JButton[row][col];
      for (int i = 0; i < buttons.length; i++) {
         for (int j = 0; j < buttons[i].length; j++) {
            final int curRow = i;
            final int curCol = j;
            buttons[i][j] = new JButton(i + ", " + j);
            buttons[i][j].addKeyListener(enter);
            buttons[i][j].addKeyListener(new KeyAdapter() {
               @Override
               public void keyPressed(KeyEvent e) {
                  switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                     if (curRow > 0)
                        buttons[curRow - 1][curCol].requestFocus();
                     break;
                  case KeyEvent.VK_DOWN:
                     if (curRow < buttons.length - 1)
                        buttons[curRow + 1][curCol].requestFocus();
                     break;
                  case KeyEvent.VK_LEFT:
                     if (curCol > 0)
                        buttons[curRow][curCol - 1].requestFocus();
                     break;
                  case KeyEvent.VK_RIGHT:
                     if (curCol < buttons[curRow].length - 1)
                        buttons[curRow][curCol + 1].requestFocus();
                     break;
                  default:
                     break;
                  }
               }
            });
            add(buttons[i][j]);
         }
      }
   }

   private KeyListener enter = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
         if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            ((JButton) e.getComponent()).doClick();
         }
      }
   };

   public static void main(String[] args) {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new Capstone_RPG(4, 4));
      f.pack();
      f.setVisible(true);
   }
}

*/


/*
public class Capstone_RPG 
{
    public static void main(String[] args) 
    {
        //TitleScreen labelFrame = new TitleScreen(); 
        
        //labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //labelFrame.setSize(280, 180); 
        //labelFrame.setVisible(true); 
    }
    
}
*/





/*
public class Capstone_RPG 
{
    TitleScreen labelFrame = new TitleScreen(); 
    labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    labelFrame.setSize(280, 180); 
    labelFrame.setVisible(true); 
    
    
}
*/


/*
    // these are the components we need.
    private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom
    private final JScrollPane scrollPane; // makes the text scrollable
    private final JTextArea textArea;     // the text
    private final JPanel inputPanel;      // under the text a container for all the input elements
    private final JTextField textField;   // a textField for the text the user inputs
    private final JButton button;         // and a "send" button

    public Capstone_RPG()
    {

        // first, lets create the containers:
        // the splitPane devides the window in two components (here: top and bottom)
        // users can then move the devider and decide how much of the top component
        // and how much of the bottom component they want to see.
        splitPane = new JSplitPane();

        topPanel = new JPanel();         // our top component
        bottomPanel = new JPanel();      // our bottom component

        // in our bottom panel we want the text area and the input components
        scrollPane = new JScrollPane();  // this scrollPane is used to make the text area scrollable
        textArea = new JTextArea();      // this text area will be put inside the scrollPane

        // the input components will be put in a separate panel
        inputPanel = new JPanel();
        textField = new JTextField();    // first the input field where the user can type his text
        button = new JButton("send");    // and a button at the right, to send the text

        // now lets define the default size of our window and its layout:
        setPreferredSize(new Dimension(400, 400));     // let's open the window with a default size of 400x400 pixels
        // the contentPane is the container that holds all our components
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        // we only add one element to the window itself
        getContentPane().add(splitPane);               // due to the GridLayout, our splitPane will now fill the whole window

        // let's configure our splitPane:
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(200);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"

        // our topPanel doesn't need anymore for this example. Whatever you want it to contain, you can add it here
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the content vertically

        bottomPanel.add(scrollPane);                // first we add the scrollPane to the bottomPanel, so it is at the top
        scrollPane.setViewportView(textArea);       // the scrollPane should make the textArea scrollable, so we define the viewport
        bottomPanel.add(inputPanel);                // then we add the inputPanel to the bottomPanel, so it under the scrollPane / textArea

        // let's set the maximum size of the inputPanel, so it doesn't get too big when the user resizes the window
        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

        inputPanel.add(textField);        // left will be the textField
        inputPanel.add(button);           // and right the "send" button

        pack();   // calling pack() at the end, will ensure that every layout and size we just defined gets applied before the stuff becomes visible
    }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new TestGUI().setVisible(true);
            }
        });
    }
    */

/*
import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Capstone_RPG 
{
    public static void main(String[] args)
    {
        ExpositionBox labelFrame = new ExpositionBox(); 
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        labelFrame.setSize(280, 180); 
        labelFrame.setVisible(true); 
        
        String text = "hello world";
        int i;
        for(i = 0; i < text.length(); i++)
        {
            System.out.printf("%c", text.charAt(i));
            
            try
            {
                if(i % 4 == 0)
                {
                    Thread.sleep(100);//0.5s pause between characters
                }
                else
                {
                    Thread.sleep(400);//0.5s pause between characters
                }
                // Thread.sleep(500);//0.5s pause between characters
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
*/

/*
// paint panel.java
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Capstone_RPG 
{
    public static void main(String[] args) 
    {
        // create JFrame
        JFrame application = new JFrame("A simple paint program");
        
        TestClass paintPanel = new TestClass();
        application.add(paintPanel, BorderLayout.CENTER);
        
        // create a label and place it in SOUTH of BorderLayout
        application.add(new JLabel("Drag the mouse to draw"), 
            BorderLayout.SOUTH);
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(400, 200);
        application.setVisible(true);
    }
    
}
    */


/*

import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Capstone_RPG 
{
    public static void main(String[] args) 
    {
        TestClass labelFrame = new TestClass(); 
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        labelFrame.setSize(280, 180); 
        labelFrame.setVisible(true); 
    }
    
}

*/



    /* 
    import Generic_Object.*;
    import Generic_Character.GenericCharacter;
    import java.util.LinkedHashMap;
    import java.util.Map;
    import java.util.Arrays;
    import java.util.ArrayList;
    import java.security.SecureRandom;

    
        total exp needed per lvl
    weight: 34
        level 0: 66
        level 1: 143
        level 2: 233
        level 3: 339
        level 4: 463
        level 5: 607
        level 6: 776
        level 7: 974
        
    
        1   0
        2   68
        3   135
        4   211
        5   301
        6   422
        7   574
        8   797
        9   1144
    
    public static double calculateNextLevelExp(double experience, double expScale)
    {
        double expTotal = (experience * 1.17) + (expScale + (expScale * 0.94));
            return expTotal;
    }

    public static void nextLevelExp(double expScale)
    {
        double counter = 0;
        
        double nextLevelExp = 0;

        // loop until exp value exceeds character's current experience points 
        // exp value will be the value that must be exceeded to gain a level 
        while(exp <= 9999)
        {
            // exp assigned value of method expCalculation()
            exp = calculateNextLevel(exp, expScale);
            System.out.printf("level %-2.0f: %-8.0f:\t", counter, exp);
               printResultAsChart(exp);
            
            counter++;
            
            if(counter > 50)
            {
                break;
            }
        }

        
        // return value stored in exp 
        //return exp;
    }
    
    */