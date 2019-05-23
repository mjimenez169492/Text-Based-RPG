package Demo;

import GUI_Collection.*;
import Object_Factories_For_Testing.PlayerEntityFactory;
import Player_Entity.PlayerEntity;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Capstone_RPG extends JPanel 
{
    // do not proceed until gui has terminated
    
    public static void pauseBetweenFrames(CommonGUIMethods gui)
    {
        ((CommonGUIMethods)gui).guiComplete(false);
        
        boolean result = false;
        
        while(!result)
        {
            // need something to make while loop operate correctly
            System.out.print("");
            
            // while loop breaks when GUI itself is considered complete 
            // Note: remember to signify Gui is complete with guiComplete(true);
            result = ((CommonGUIMethods)gui).guiComplete();
        }
    }
    
    public static int pauseBetweenFramesOptionsPostExposition(OptionsBox gui)
    {
        ((CommonGUIMethods)gui).guiComplete(false);
        
        boolean result = false;
        
        while(!result)
        {
            // need something to make while loop operate correctly
            System.out.print("");
            
            // while loop breaks when GUI itself is considered complete 
            // Note: remember to signify Gui is complete with guiComplete(true);
            result = ((CommonGUIMethods)gui).guiComplete();
        }
        
        return gui.getOptionChoice();
    }
    
    public static int pauseBetweenFramesTraversalOptions(TraversalBox gui)
    {
        ((CommonGUIMethods)gui).guiComplete(false);
        
        boolean result = false;
        
        while(!result)
        {
            // need something to make while loop operate correctly
            System.out.print("");
            
            // while loop breaks when GUI itself is considered complete 
            // Note: remember to signify Gui is complete with guiComplete(true);
            result = ((CommonGUIMethods)gui).guiComplete();
        }
        
        return gui.getOptionChoice();
    }
    
    public static GUI_Collection.Battle pauseBetweenFramesBattle(GUI_Collection.Battle gui)
    {
        boolean result = false;

        while(!result)
        {
            // need something to make while loop operate correctly
            System.out.print("");

            // while loop breaks when GUI itself is considered complete 
            // Note: remember to signify Gui is complete with guiComplete(true);
            result = ((CommonGUIMethods)gui).guiComplete();
        }

        return gui;
    }
    
    // Note: method serves as example of text passed to text box gui
    public static ArrayList<String> textBoxTextExample()
    {
        ArrayList<String> example = new ArrayList<>();
        
        example.add("/Some Guy");
        example.add("A Tribute To the");
        example.add("Declaration of myAppendex...");
        example.add("/Uncle Slam");
        example.add("When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions");
        example.add("When in the Course of human events it becomes necessary for "
            + "one people to Liberty and the pursuit of Happiness. — That to "
            + "secure these districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. ");
        
        return example;
    }
    
    // Note: method serves as example of text passed to options box gui
    public static ArrayList<String> optionsBoxChoicesExample()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("Sign the document and voice your support for it.");
        //example.add("Try your best to stay awake in the face of sheer boredom");
        //example.add("Advocate against signing the document.");
        example.add("Walk away.");
        //example.add("This is the text for button 5");
        //example.add("This is the text for button 6");

        return example;
    }
    
    // Note: 18 characeter limit per String
    // Note method serves as example of text passed to traversal box gui
    public static ArrayList<String> traversalBoxChoicesExample()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("Approach enemy");
        example.add("Walk away");
        //example.add("Search Office Closet ");
        //example.add("text for button 4");
        //example.add("text for button 5");
        //example.add("012345678901234567");

        return example;
    }

    public static void main(String args[]) 
    {
        PlayerEntityFactory factory = new PlayerEntityFactory();
            PlayerEntity entity = factory.getPlayerEntityExample();
        
        PlayerEntityFactory opposition = new PlayerEntityFactory();
            PlayerEntity entityTwo = opposition.getPlayerEntityExampleTwo();
    
        pauseBetweenFrames(new GUI_Collection.IntroBox());
        
        String location = "Grand Capital - Metro 31 - Plaza - Factory - Boiler Room - West";
        String eventEventLine = "The End - Last Surprise";
        
        pauseBetweenFrames(new TextBox(entity, location, 
            eventEventLine, textBoxTextExample()));
        
        switch(pauseBetweenFramesOptionsPostExposition(new OptionsBox(
            textBoxTextExample(), optionsBoxChoicesExample())))
        {
            case 1: 
                System.exit(0);
                    break;
            default:
                    break;
        }


        switch(pauseBetweenFramesTraversalOptions(new TraversalBox(entity, 
            false, location, eventEventLine, traversalBoxChoicesExample())))
        {
            case 1: 
                System.exit(0);
                    break;
            default:
                    break;
        }
        
        // Note: since time constraints resulted in cutting enemy AI script, 
        //       player has been given control of enemy attack action
        GUI_Collection.Battle result = pauseBetweenFramesBattle(new GUI_Collection.Battle(
            entity, entityTwo));

        // if ladder by battle result priority 
        if(result.playerPartyGameOver())
        {
            
        }
        else if(result.endBattleEarlyTrigger())
        {
            
        }
        else if(result.partiesTied())
        {
            
        }
        else if(result.playerPartyWin())
        {
            pauseBetweenFrames(new BattleResults(entity, result.getDefeatedEnemies()));
                System.out.println("Dd");
        }
        else if(result.playerPartyLoss())
        {
            System.exit(0);
        }
        else if(result.playerPartyEscape())
        {
            
        }
        else if(result.partyOneWin())
        {
            
        }
        else if(result.partyTwoWin())
        {
            
        }
        else if(result.partyOneLoss())
        {
            
        }
        else if(result.partyTwoLoss())
        {
            
        }
        else if(result.partyOneEscape())
        {
            
        }
        else if(result.partyTwoEscape())
        {
            
        }
    }
}
