package Battle_And_Battle_Results;

/* 
    public class levelUp contains information regarding 'level up' or increase in 
    strength of a character once enough experience points (i.e. EXP) are acquired 

    methods in this class are dependent upon private int exp which holds the value 
    of a character object's exp scale which is set at the object's creation step. 
    This value will be held by variable exp which will be used in calculations 
    regarding character level up. 
*/ 

import java.security.SecureRandom;

public class LevelMechanics
{
    private int holdNextLevel;	// hold next level for a character based on their exp total
    private int toNextLevel;	// hold experience needed for the next level
    private int exp; 			// holds exp scale and is used in exp calculations 
    private int nextLevelExp;	// hold exp needed for the next level 
    private int expTotal;		// used in exp calculations
    private int rightLevel;		// holds the "right level" for a character based on exp
    private int randNumber;		// random number influences method randomAttributesUp()

    // method determines whether a character can "level up" or increase in power
    public void levelUp(characters character)
    {
            // get and hold the next level of the character 
            holdNextLevel = correctLevel(character);

            // if holdNextLevel is greater than current character level (meaning character
            // has enough exp to gain a level), enter the if statement else print out how 
            // exp is needed for the next level 
            if(holdNextLevel > character.getLevel())
            {
                    // print out that character has leveled up 
                    System.out.println("\nLevel up!"); 

                    // add levels to a character until level is equal to level held in holdNextLevel
                    while(holdNextLevel != character.getLevel())
                    {
                            character.setLevel(character.getLevel() + 1);
                    }

                    // print the name and exp of the character using method showNameAndExp()
                    System.out.println("New stats:\n"); 
                            showNameAndExp(character);

                    // randomly increase the character's attributes 
                    levelAttributesRandomly(character);
            }
            else
            {
                    // show character name, level, and exp details 
                    showNameAndExp(character);
            }
    }

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

    // method returns experience total for current level based off character's exp scale
    public int expCalculation(int experience, int expScale)
    {
            // result of experience calculation stored in expTotal is returned
            return expTotal = (int)(experience * 1.63) - (int)(experience/1.86) + (expScale + 16);
    }

    // determine the experience needed for character's next level 
    public int expNeeded(characters character)
    {
            // assign instance variable exp with 0 each time method is called 
            exp = 0;

            // loop until exp value exceeds character's current experience points 
            // exp value will be the value that must be exceeded to gain a level 
            while(exp <= character.getExperience())
            {
                    // exp assigned value of method expCalculation()
                    exp = expCalculation(exp, character.getExpScale());			
            }

            // return value stored in exp 
            return exp;
    }

    // method finds the correct level for character based on experience points gained
    public int correctLevel(characters character)
    {
            // assign instance variable exp with 0 each time method is called 
            exp = 0;

            // assign instance variable rightLevel with 0 each time method is called 
            rightLevel = 0;

            // loop breaks only when exp exceeds character experience
            while(exp < character.getExperience())
            {
                    // exp assigned value of method expCalculation()
                    exp = expCalculation(exp, character.getExpScale());

                    // need if statement to prevent rightLevel from incrementing by 1 when it 
                    // should not do so if exp exceeds character experience since it would 
                    // return a value that is 1 more than it should be 
                    if(exp > character.getExperience())
                    {
                            break;
                    }

                    // increment rightLevel by 1 oer iteration 
                    rightLevel++;
            }

            // return value held in rightLevel
            return rightLevel;
    }

    // method levels attributes randomly and prints a table of attributes showing increases
    public void levelAttributesRandomly(characters character)
    {
            randomAttributesUp(character);
            increasableAttributesTable(character);
    }

    // show increasable attributes as a table
    public void increasableAttributesTable(characters character)
    {
            System.out.format("%-17s%d\t\t%-18s%d\n", "1. Max HP:", character.getMaxHp(), " 6. Dexterity:", character.getDexterity());
            System.out.format("%-17s%d\t\t%-18s%d\n", "2. Attack:", character.getAttack(), " 7. Critical:", character.getCritical());
            System.out.format("%-17s%d\t\t%-18s%d\n", "3. Defense:", character.getDefense(), " 8. Accuracy:", character.getAccuracy());
            System.out.format("%-17s%d\t\t%-18s%d\n", "4. Nano:", character.getMaxNano(), " 9. Nano Attack:", character.getNanoAttack());
            System.out.format("%-17s%d\t\t%-18s%d\n", "5. Stamina:", character.getMaxStamina(), "10. Nano Defense:", character.getNanoDefense());
    }

    // method uses random number generator from SecureRandom to increase attributes
    public void randomAttributesUp(characters character)
    {
            // create object of SecureRandom class to call random methods 
            SecureRandom secureRand = new SecureRandom();

            // assign instance variable randNumber with value ranging from 1 to 7
            // if statements increase attributes depending on value of randNumber
            randNumber = secureRand.nextInt(7) + 1;

            if(randNumber >= 1)
            {
                    character.setMaxHp(character.getMaxHp() + (secureRand.nextInt(4) + 5));
            }

            if(randNumber >= 2)
            {
                    character.setAttack(character.getAttack() + secureRand.nextInt(2) + 1);
                    character.setDefense(character.getDefense() + secureRand.nextInt(2) + 1);
            }

            if(randNumber >= 3)
            {
                    character.setMaxNano(character.getMaxNano() + secureRand.nextInt(3) + 3);
                    character.setMaxStamina(character.getMaxStamina() + secureRand.nextInt(4) + 3);
            }

            if(randNumber >= 4)
            {
                    character.setDexterity(character.getDexterity() + secureRand.nextInt(3) + 1);
                    character.setAccuracy(character.getAccuracy() + secureRand.nextInt(2) + 2); 
            }

            if(randNumber >= 5)
            {
                    character.setNanoAttack(character.getNanoAttack() + secureRand.nextInt(3) + 2);
                    character.setNanoDefense(character.getNanoDefense() + secureRand.nextInt(2) + 2);
            }

            if(randNumber >= 6)
            {
                    character.setMaxHp(character.getMaxHp() + secureRand.nextInt(2));
                    character.setAttack(character.getAttack() + secureRand.nextInt(2));
                    character.setDefense(character.getDefense() + secureRand.nextInt(2));
                    character.setMaxNano(character.getMaxNano() + secureRand.nextInt(2));
                    character.setMaxStamina(character.getMaxStamina() + secureRand.nextInt(2));
                    character.setDexterity(character.getDexterity() + secureRand.nextInt(2));
                    character.setAccuracy(character.getAccuracy() + secureRand.nextInt(2)); 
                    character.setNanoAttack(character.getNanoAttack() + secureRand.nextInt(2));
                    character.setNanoDefense(character.getNanoDefense() + secureRand.nextInt(2));
            }

            if(randNumber == 6)
            {
                    character.setCritical(character.getCritical() + secureRand.nextInt(2));
            }

            if(randNumber == 7)
            {
                    character.setLuck(character.getLuck() + secureRand.nextInt(2));
            }
    }
}
