package RunProject;

import Object_Factories.*;
import Player_Entity.PlayerEntity;
import Player_Entity.Party;
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
    
    // do not proceed until gui has terminated
    public static int pauseBetweenFramesOptionsPostExposition(OptionsPostExpositionBox gui)
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
    
    // do not proceed until gui has terminated
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
    
    // do not proceed until gui has terminated
    public static BattleMenu.Battle pauseBetweenFramesBattle(BattleMenu.Battle gui)
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
    
    // Note: method serves as an example of String ArrayList relaying text 
    public static ArrayList<String> expositionTextArrayList()
    {
        ArrayList<String> example = new ArrayList<>();
        
        example.add("/Name");
        example.add("I see doggy ha ha and i was like totally omg this cannot "
            + "be happening since i ate french fries and waffkes which are supposed "
            + "ti keep them things far away. Anyways I saw it and it saw me and I "
            + "saw it again and it like growled super weirdly like an alien thing "
            + "on t.v. or something. And that is why I am running for president. Bye "
            + "Now haha!");
        example.add("/Hype");
        example.add("Nuh - -d1! !2e Uh");
        example.add("Out of my way");
        example.add("/Description");
        example.add("like Uh huh!!! why say that apple loser!");
        example.add("I see doggy ha ha and i was like totally omg this cannot "
            + "be happening since i ate french fries and waffkes which are supposed "
            + "ti keep them things far away. Anyways I saw it and it saw me and I "
            + "saw it again and it like growled super weirdly like an alien thing "
            + "on t.v. or something. And that is why I am running for president. Bye "
            + "Now haha!");
        
        return example;
    }
    
    // Note: number of Strings in ArrayList determines number of buttons created 
    public static ArrayList<String> optionsStringsForButtonsPostExposition()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("This is the text for button 1");
        example.add("This is the text for button 2");
        example.add("This is the text for button 3");
        example.add("This is the text for button 4");
        //example.add("This is the text for button 5");
        //example.add("This is the text for button 6");

        return example;
    }
    
    // Note: 18 characeter limit for options 
    public static ArrayList<String> textForTraversalBoxButtons()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("text for button1");
        example.add("012345678901234567");
        example.add("text for but 3");
        //example.add("text for button 4");
        //example.add("text for button 5");
        //example.add("text for button 6");

        return example;
    }
    
    public static void main(String args[]) 
    {
        PlayerEntityFactory factory = new PlayerEntityFactory();
            PlayerEntity entity = factory.getPlayerEntityExample();
        
        PlayerEntityFactory opposition = new PlayerEntityFactory();
            Party opposingParty = opposition.getPlayerEntityExampleTwo().getParty();
        
        pauseBetweenFrames(new TitleScreen());
        
        String location = "Grand Capital - Metro 31 - Plaza - Factory - Boiler Room - West";
        String eventEventLine = "The End - Last Surprise";
        
        pauseBetweenFrames(new ExpositionBox(entity, location, 
            eventEventLine, expositionTextArrayList()));
        
        
        switch(pauseBetweenFramesOptionsPostExposition(new OptionsPostExpositionBox(
            expositionTextArrayList(), optionsStringsForButtonsPostExposition())))
        {
            case 0: 
                System.out.println("haha");
                    break;
            default:
                System.out.println("hehe");
                    break;
        }

        switch(pauseBetweenFramesTraversalOptions(new TraversalBox(entity, 
            false, location, eventEventLine, textForTraversalBoxButtons())))
        {
            case 0: 
                System.out.println("haha");
                    break;
            default:
                System.out.println("hehe");
                    break;
        }
        
        BattleMenu.Battle result = pauseBetweenFramesBattle(new BattleMenu.Battle(
            entity, opposingParty));

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
            pauseBetweenFrames(new BattleResults(entity));
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
