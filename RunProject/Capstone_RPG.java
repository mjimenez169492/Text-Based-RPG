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
        double expScale = 6;
        
        expNeeded(expScale);
        
        
        
        
    }
    
    /* total exp needed per lvl
        1   0
        2   68
        3   135
        4   211
        5   301
        6   422
        7   574
        8   797
        9   1144
    */
    
    
    // method returns experience total for current level based off character's exp scale
    public static double expCalculation(double experience, double expScale)
    {
        double expTotal = (experience * 1.07) + (expScale);
            return expTotal;
    }

    // determine the experience needed for character's next level 
    public static void expNeeded(double expScale)
    {
        double counter = 0;
        
        // assign instance variable exp with 0 each time method is called 
        double exp = 0;

        // loop until exp value exceeds character's current experience points 
        // exp value will be the value that must be exceeded to gain a level 
        while(exp <= 1111)
        {
            // exp assigned value of method expCalculation()
            exp = expCalculation(exp, expScale);
            System.out.println(exp);
            
            counter++;
            
            if(counter > 10)
            {
                break;
            }
        }

        
        // return value stored in exp 
        //return exp;
    }
}
