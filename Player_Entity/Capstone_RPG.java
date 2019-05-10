package Player_Entity;

// import all files in package Generic_Object
import Generic_Object.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class Capstone_RPG 
{
    public static void main(String args[])
    {
        ArrayList<String> longName = new ArrayList<>();
        
        longName.add("123456789 123456789 123456");
                
            displaySingleTargetOptions(longName);   
        
        ArrayList<String> shape = new ArrayList<>();
        
        shape.add("Square");
                
            //displaySingleTargetOptions(shape);
        
        ArrayList<String> ego = new ArrayList<>();
        
        ego.add("123456789 123456789 123456"); 
        ego.add("123456789 123456789 123456"); 
        ego.add("123456789 123456789 123456");
        
            //displaySingleTargetOptions(ego);
        
        ArrayList<String> fruit = new ArrayList<>();
        
        fruit.add("Apple"); fruit.add("Pear"); fruit.add("Banana"); 
        fruit.add("Orange");
        
            //displaySingleTargetOptions(fruit);
        
        
    }
    
    /* need to account for 
        names that are 0-26 characters long
        even number of combatants 
        odd number of combatants 
        displaying "Cancel move" as last option with no new line 
    */
    public static void displaySingleTargetOptions(ArrayList<String> activeCharacters)
    {
        for(int i = 0; i < activeCharacters.size() + 1; i++)
        {
            if(i != activeCharacters.size())
            {
                if((i % 2 == 0))
                {
                    System.out.printf("%-26s\t", activeCharacters.get(i));
                }
                else if((i % 2 == 1))
                {
                    System.out.printf("%-26s\n", activeCharacters.get(i));
                }
            }
            else
            {
                System.out.printf("%-26s", "Cancel Move");
            }
        }
    }
    
}
