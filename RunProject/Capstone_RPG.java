package RunProject;

// import all files in package Generic_Object
import Generic_Object.*;
import Generic_Character.GenericCharacter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.security.SecureRandom;

public class Capstone_RPG 
{
    public static void main(String args[])
    {
        GenericCharacter genericCharacter = new GenericCharacter();
        
        genericCharacter.getStress().setMaxStress(10);
        genericCharacter.getStress().setCurrentStress(10);
        
        genericCharacter.getStats().setMaxHealth(10);
        
        System.out.println(genericCharacter.getTotalStats().getTotalMaxHealth());
        
        
        
        
        /*
        Armor armor = new Armor();
        
        armor.setMaxHealth(10);
        
        armor.setMaxDurability(14);
        
        armor.setCurrentDurability(10);
        
        System.out.println(armor.getMaxHealth());
        
        double result = armorAccessorySwitch(ArmorAccessorySwitches.GET_MAX_HEALTH, armor);
        
        System.out.println(result);
        */
        
        /*
        System.out.println("Omit".regionMatches(0, "Omitt", 0, 4));
        
        String[] ex = {null, null, null};
        
        String[] cleanedArray = Arrays.stream(ex).filter(s -> (s != null && 
            s.length() > 0)).toArray(String[]::new);
        
        SecureRandom rand = new SecureRandom();
        System.out.println(cleanedArray.length);
        for(int i = 0; i < cleanedArray.length; i++)
        {
            
            //System.out.println(cleanedArray[i]);
        }
        */
        
        ArrayList<String> longName = new ArrayList<>();
        
        longName.add("123456789 123456789 123456");
                
            //displaySingleTargetOptions(longName);   
        
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
    
    public enum ArmorAccessorySwitches
    {
        GET_MAX_HEALTH, GET_MAX_STAMINA, GET_MAX_NANO, GET_DEFENSE, GET_DEXTERITY, 
        GET_NANO_DEFENSE;
    }
    
    public static double armorAccessorySwitch(ArmorAccessorySwitches choice, Armor object)
    {
        double holdEquipValue = 0;
        
        switch(choice)
        {
            case GET_MAX_HEALTH:
                holdEquipValue = object.getTotalMaxHealth();
                    break;
            case GET_MAX_STAMINA:
                holdEquipValue = object.getTotalMaxStamina();
                    break;
            case GET_MAX_NANO:
                holdEquipValue = object.getTotalMaxNano();
                    break;
            case GET_DEFENSE:
                holdEquipValue = object.getTotalDefense();
                    break;
            case GET_DEXTERITY:
                holdEquipValue = object.getTotalDexterity();
                    break;
            case GET_NANO_DEFENSE:
                holdEquipValue = object.getTotalNanoDefense();
                    break;
        }

        return holdEquipValue;
    }
    
    
}
