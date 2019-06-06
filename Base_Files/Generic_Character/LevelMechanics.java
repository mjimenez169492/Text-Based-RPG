package Generic_Character;

/* 
    public class levelUp contains information regarding 'level up' or increase in 
    strength of a character once enough experience points (i.e. EXP) are acquired 

    methods in this class are dependent upon private int exp which holds the value 
    of a character object's exp scale which is set at the object's creation step. 
    This value will be held by variable exp which will be used in calculations 
    regarding character level up. 
*/ 

import Generic_Character.GenericCharacter;
import java.security.SecureRandom;

public class LevelMechanics
{
    // START: EXP CALCULATION PER LEVEL 
    /*******************************************************************************/

    public double nextLevelExpCalculation(double experience, double expScale)
    {
        double expTotal = (experience * 1.17) + (expScale + (expScale * 0.94));
            return Math.floor(expTotal);
    }

    public double nextLevelExp(GenericCharacter character)
    {
        double exp = 0;

        // exp signifies value that must be exceeded in order to gain a level
        while(exp <= character.getGeneralFeatures().getExperience())
        {
            exp = nextLevelExpCalculation(exp, character.getGeneralFeatures().getExpScale());
        }

        return exp;
    }

    public double correctLevel(GenericCharacter character)
    {
        double exp = 0;

        // lowest level possible is 1 so start counting at 1 
        double correctLevel = 1;

        // loop forever until loop is broken by custom break condition 
        while(true)
        {
            // exp signifies value that must be exceeded in order to gain a level
            exp = nextLevelExpCalculation(exp, character.getGeneralFeatures().getExpScale());

            // break loop if exp for next level has not been met 
            if(exp > character.getGeneralFeatures().getExperience())
            {
                break;
            }
            else
            {
                correctLevel++;
            }
        }

        return correctLevel;
    }
    
    public void randomlyIncreaseAttributes(GenericCharacter character)
    {
        SecureRandom secureRand = new SecureRandom();
        
        switch((secureRand.nextInt(7) + 1))
        {
            case 7:
                character.getStats().setLuck(character.getStats().getLuck() 
                    + secureRand.nextInt(2));
            case 6: 
                character.getStats().setMaxHealth(character.getStats().getMaxHealth() 
                    + secureRand.nextInt(2));
                character.getStats().setMaxStamina(character.getStats().getMaxStamina() 
                    + secureRand.nextInt(2));
                character.getStats().setMaxNano(character.getStats().getMaxNano() 
                    + secureRand.nextInt(2));
                character.getStats().setAttack(character.getStats().getAttack() 
                    + secureRand.nextInt(2));
                character.getStats().setDefense(character.getStats().getDefense() 
                    + secureRand.nextInt(2));
                character.getStats().setDexterity(character.getStats().getDexterity() 
                    + secureRand.nextInt(2));
                character.getStats().setAccuracy(character.getStats().getAccuracy() 
                    + secureRand.nextInt(2)); 
                character.getStats().setNanoAttack(character.getStats().getNanoAttack() 
                    + secureRand.nextInt(2));
                character.getStats().setNanoDefense(character.getStats().getNanoDefense() 
                    + secureRand.nextInt(2));
                character.getStats().setCritical(character.getStats().getCritical() 
                    + secureRand.nextInt(2));
            case 5:
                character.getStats().setNanoAttack(character.getStats().getNanoAttack() 
                    + secureRand.nextInt(3) + 2);
                character.getStats().setNanoDefense(character.getStats().getNanoDefense() 
                    + secureRand.nextInt(2) + 2);
            case 4: 
                character.getStats().setDexterity(character.getStats().getDexterity() 
                    + secureRand.nextInt(3) + 1);
                character.getStats().setAccuracy(character.getStats().getAccuracy() 
                    + secureRand.nextInt(2) + 2); 
            case 3: 
                character.getStats().setMaxStamina(character.getStats().getMaxStamina() 
                    + secureRand.nextInt(4) + 3);
                character.getStats().setMaxNano(character.getStats().getMaxNano() 
                    + secureRand.nextInt(3) + 3);
            case 2:
                character.getStats().setAttack(character.getStats().getAttack() 
                    + secureRand.nextInt(2) + 1);
                character.getStats().setDefense(character.getStats().getDefense() 
                    + secureRand.nextInt(2) + 1);
            case 1: 
                character.getStats().setMaxHealth(character.getStats().getMaxHealth() 
                    + (secureRand.nextInt(4) + 5));
                        break;
            default:
                break;
        }
    }
    
    public void levelUp(GenericCharacter character)
    {
        // store correct level for characters based on their experience
        double nextLevel = correctLevel(character);

        if(nextLevel > character.getGeneralFeatures().getLevel())
        {
            while(nextLevel != character.getGeneralFeatures().getLevel())
            {
                character.getGeneralFeatures().incrementLevel();
                    randomlyIncreaseAttributes(character);
            }
        }
    }

    /*
    // show total experience and experience needed for next level 
    // to be changed at GUI building phase
    public void showNameAndExp(characters character)
    {
        // toNextLevel assigned difference between expNeeded() and character's current experience 
        nextLevelExp = expNeeded(character) - character.getExperience();
        String totalEXP = String.format("%d/%d", character.getExperience(), expNeeded(character));
        System.out.format("%-11s%-22s%s%d\n", "Character:", character.getName(), "Level: ", character.getLevel());
        System.out.format("%-11s%-22s%s%d\n", "Total EXP:", totalEXP, "Next Level: ", nextLevelExp);
    }
    */ 
}