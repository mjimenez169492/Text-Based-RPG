package Demo;

import GUI_Collection.*;
import GUI_Collection.OptionsBox;
import GUI_Collection.CommonGUIMethods;
import Object_Factories_For_Testing.PlayerEntityFactory;
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
    
    /*
    // do not proceed until gui has terminated
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
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. When in the Course of human events it becomes necessary for "
            + "one people to dissolve the political bands which have connected them "
            + "with another and to assume among the powers of the earth, the separate "
            + "and equal station to which the Laws of Nature and of Nature's God entitle "
            + "them, a decent respect to the opinions of mankind requires that they "
            + "should declare the causes which impel them to the separation. We hold "
            + "these truths to be self-evident, that all men are created equal, that "
            + "they are endowed by their Creator with certain unalienable Rights, that "
            + "among these are Life, Liberty and the pursuit of Happiness. — That to "
            + "secure these rights, Governments are instituted among Men, deriving their "
            + "just powers from the consent of the governed, — That whenever any Form of "
            + "Government becomes destructive of these ends, it is the Right of the People "
            + "to alter or to abolish it, and to institute new Government, laying its "
            + "foundation on such principles and organizing its powers in such form, as to "
            + "them shall seem most likely to effect their Safety and Happiness. Prudence, "
            + "indeed, will dictate that Governments long established should not be changed "
            + "for light and transient causes; and accordingly all experience hath shewn "
            + "that mankind are more disposed to suffer, while evils are sufferable than to "
            + "right themselves by abolishing the forms to which they are accustomed. But "
            + "when a long train of abuses and usurpations, pursuing invariably the same "
            + "Object evinces a design to reduce them under absolute Despotism, it is their "
            + "right, it is their duty, to throw off such Government, and to provide new Guards "
            + "for their future security. — Such has been the patient sufferance of these "
            + "Colonies; and such is now the necessity which constrains them to alter their "
            + "former Systems of Government. The history of the present King of Great Britain "
            + "is a history of repeated injuries and usurpations, all having in direct object "
            + "the establishment of an absolute Tyranny over these States. To prove this, let "
            + "Facts be submitted to a candid world. He has refused his Assent to Laws, the "
            + "most wholesome and necessary for the public good. He has forbidden his Governors "
            + "to pass Laws of immediate and pressing importance, unless suspended in their "
            + "operation till his Assent should be obtained; and when so suspended, he has "
            + "utterly neglected to attend to them. He has refused to pass other Laws for the "
            + "accommodation of large districts of people, unless those people would relinquish "
            + "the right of Representation in the Legislature, a right inestimable to them and "
            + "formidable to tyrants only. ");
        
        
        return example;
    }
    
    // Note: number of Strings in ArrayList determines number of buttons created 
    public static ArrayList<String> optionsStringsForButtonsPostExposition()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("Sign the document and voice your support for it.");
        example.add("Try your best to stay awake in the face of sheer boredom");
        example.add("Advocate against signing the document.");
        example.add("Walk away.");
        //example.add("This is the text for button 5");
        //example.add("This is the text for button 6");

        return example;
    }
    
    // Note: 18 characeter limit for options 
    public static ArrayList<String> textForTraversalBoxButtons()
    {
        ArrayList<String> example = new ArrayList<>();

        example.add("Approach Cassandra");
        example.add("To Forgotton Armory");
        example.add("Search Office Closet ");
        //example.add("text for button 4");
        //example.add("text for button 5");
        //example.add("012345678901234567");

        return example;
    }
    */

    public static void main(String args[]) 
    {
        PlayerEntityFactory factory = new PlayerEntityFactory();
            PlayerEntity entity = factory.getPlayerEntityExample();
        
        PlayerEntityFactory opposition = new PlayerEntityFactory();
            Party opposingParty = opposition.getPlayerEntityExampleTwo().getParty();
    
        
        pauseBetweenFrames(new GUI_Collection.IntroBox());
        /*
        String location = "Grand Capital - Metro 31 - Plaza - Factory - Boiler Room - West";
        String eventEventLine = "The End - Last Surprise";
        
        pauseBetweenFrames(new ExpositionBox(entity, location, 
            eventEventLine, expositionTextArrayList()));
        
        
        switch(pauseBetweenFramesOptionsPostExposition(new OptionsBox(
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
        */
        
            /*
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
        */
    }
}