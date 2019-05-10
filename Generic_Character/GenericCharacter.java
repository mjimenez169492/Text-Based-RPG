package Generic_Character;

/* 
    GenericCharacter extends multiple classes in a "ladder" format by using 
    the keyword "extends" thereby allowing objects from GenericCharacter to 
    access/utilize superclass methods in order to create a character in the 
    game world. GenericCharacter contains the last pieces of code needed in
    order to create a proper character. 
*/

import java.util.ArrayList;

public class GenericCharacter extends CharacterReactionsInBattle 
{
    //denotes unique character states affecting battle progression 
    private boolean playerControlState;	// if party member is NOT under player control then its AI script is used 
    private boolean bossState;		// if character is a boss entity then escape for all combatants is impossible 
    
    // defines character in the game world and to the player 
    private String name;                // what character is called 	
    private String type; 		// what entity character is (human, machine, vampire, ect.)
    
    // concerning leveling and experience mechanic for character growth 
    private int level;			// current level of character 
    private double experience;		// total experience (EXP) for character gained through quests or battle 
    private double expScale;		// sets scale for exp growth per level by adjusting leveling mechanics slightly 

    // current gauges tied to each object capped by "getTotalMax_" versions of gauges 
    private double currentHealth, currentNano, currentStamina;	
    
    // determines whether character can use nanomachines at all (if true then nano skills can be used)
    private boolean nanomachineState;

    // denotes whether a character was damaged in a round of battle or not 
    private boolean damagedState;

    // set dexterity value that will be used to decide turns in battle
    private double battleDexterity;			

    // helps determine how well character can prevent opponents from escaping mid-battle 
    private double chanceToPreventEscape;			

    // considering that characters are composed of several components, it is 
    // recommended that programmers create objects by using patterns akin to
    // the java.beans pattern (object.setName("Tean"); object.setType("You"))
    // instead of telescope pattern where constructor is supplied values: 
    // (GenericCharacter object = new GenericCharacter("Team", "You"))
    public GenericCharacter()
    {
        // empty constructor 
    }	


    
    // START: CHARACTER STATES AFFECTING BATTLE PROGRESSION 
    /*******************************************************************************/

    public void setPlayerControlState(boolean playerControlState)
    {
        this.playerControlState = playerControlState;
    }

    public boolean getPlayerControlState()
    {
        return playerControlState;
    }
    
    public void setBossState(boolean bossState)
    {
        this.bossState = bossState;
    }

    public boolean getBossState()
    {
        return bossState;
    }
    
    // END: CHARACTER STATES AFFECTING BATTLE PROGRESSION 
    /*******************************************************************************/


    // START: DEFINING CHARACTER 
    /*******************************************************************************/

    public String checkStringLength(String argument)
    {
        if(argument.length() > 26)
        {
            argument = argument.substring(0, 26);
        }
        
        return argument;
    }

    public void setName(String name)
    {
        this.name = checkStringLength(name);
    }

    public String getName()
    {
        return name; 
    } 

    public void setType(String type)
    {
        this.type = checkStringLength(type);
    }

    public String getType()
    {
        return type; 
    } 

    // END: DEFINING CHARACTER 
    /*******************************************************************************/



    // START: LEVELING AND EXPERIENCE MECHANICS
    /*******************************************************************************/

    public void setLevel(int level)
    {
        if (level < 1) 
        {
            level = 1; 
        }
        else if(level > 99)
        {
            level = 99;
        }

        this.level = level;
    }

    public int getLevel()
    {
        return level; 
    } 

    public void setExperience(double experience)
    {
        if (experience < 0) 
        {
            experience = 0; 
        }
        else if(experience > 32000000)
        {
            experience = 32000000;
        }

        this.experience = experience;
    }

    public double getExperience()
    {
        return experience; 
    } 

    // Note: METHOD MUST BE MODIFIED IN TANDEM WITH LEVLE UP FILE!!!
    public void setExpScale(double expScale)
    {
        if(expScale % 33 == 0 && expScale <= 256)
        {
            if(expScale < 0)
            {
                    expScale = 0;
            }
            else if(expScale > 264)
            {
                    expScale = 264;
            }
        }
        else
        {
            expScale = 264;
        }

        this.expScale = expScale; 
    }

    // Note: METHOD MUST BE MODIFIED IN TANDEM WITH LEVLE UP FILE!!!
    public double getExpScale()
    {
        return expScale; 
    } 

    // END: LEVELING AND EXPERIENCE 
    /*******************************************************************************/

	
	
    // START: CHARACTER CURRENT GAUGES
    /*******************************************************************************/

    // Note: gauges must be checked after status infliction or armor change
    public double validateCurrentGauges(double current, double max)
    {
        if(current < 0) 
        {
            current = 0;
        }
        else if(current > max)
        {
            current = max;
        }

        return current;
    }
    
    public void setCurrentHealth(double currentHealth)
    {
        this.currentHealth = validateCurrentGauges(currentHealth, getTotalMaxHealth());
    }

    public double getCurrentHealth()
    {
        return currentHealth;
    }

    public void setCurrentStamina(double currentStamina)
    {
        this.currentStamina = validateCurrentGauges(currentStamina, getTotalMaxStamina());
    }

    public double getCurrentStamina()
    {
        return currentStamina;
    }

    public void setCurrentNano(double currentNano)
    {
        this.currentNano = validateCurrentGauges(currentNano, getTotalMaxNano());
    }

    public double getCurrentNano()
    {
        return currentNano;
    }

    // END: CHARACTER CURRENT GAUGES
    /*******************************************************************************/

	
	
    // START: NANOMACHINE STATE REGARDING NANO USE  
    /*******************************************************************************/

    public void setNanomachineState(boolean nanomachineState)
    {
        this.nanomachineState = nanomachineState;
    }

    public boolean getNanomachineState()
    {
        return nanomachineState;
    }

    // END: NANOMACHINE STATE REGARDING NANO USE 
    /*******************************************************************************/



    // START: DAMAGED STATE DENOTING DAMAGE TAKEN IN ROUND (RESET EVERY ROUND)
    /*******************************************************************************/

    public void setDamagedState(boolean damagedState)
    {
        this.damagedState = damagedState;
    }

    public boolean getDamagedState()
    {
        return damagedState;
    }

    // END: DAMAGED STATE DENOTING DAMAGE TAKEN IN ROUND (RESET EVERY ROUND)
    /*******************************************************************************/

    
    
    // START: CHECKING IF CHARACTER IS KNOCKED OUT
    /*******************************************************************************/

    public boolean knockedOut()
    {
        boolean result = false;
        
        if(getCurrentHealth() == 0)
        {
            result = true;
        }
        
        return result;
    }
    
    // END: CHECKING IF CHARACTER IS KNOCKED OUT
    /*******************************************************************************/

    

    // START: BATTLE DEXTERITY (FACTORS IN DEXTERITY EFFECT OF MOVE/CHOICE)
    /*******************************************************************************/

    // check value meant to be passed as batle dexterity of character for current round 
    public double checkBattleDexterity(double argument)
    {
        // if dexterity is not "Flee" dexterity (Double.MAX_VALUE), check it
        if(argument != Double.MAX_VALUE)
        {
            if(argument < 0)
            {
                argument = 0;
            }
            else if(argument > 10000)
            {
                argument = 10000;
            }
        }

        return argument; 
    }

    // Overloaded method sets dexterity for deciding turns in battle using character
    public void setBattleDexterity(GenericCharacter character)
    {
        // assign battleDexterity with total dexterity of character
        battleDexterity = character.getTotalDexterity();
    }
    
    // Overloaded method sets dexterity for deciding turns in battle using value
    public void setBattleDexterity(double characterDexterityWithMoveSpeed)
    {
        // assign battleDexterity with total dexterity of character with move speed 
        battleDexterity = checkBattleDexterity(characterDexterityWithMoveSpeed);
    }

    // Overloaded method sets dexterity for deciding turns in battle using character and move value
    public void setBattleDexterity(GenericCharacter character, double value)
    {
        // assign battleDexterity with value returned from method checkBattleDexterity()
        battleDexterity = checkBattleDexterity((character.getTotalDexterity() * value)); 
    }

    // method gets dexterity used to decide turns in battle 
    public int getBattleDexterity()
    {
        return (int)battleDexterity;
    }

    // END: BATTLE DEXTERITY (FACTORS IN DEXTERITY EFFECT OF MOVE/CHOICE)
    /*******************************************************************************/


    
    // START: CHANCE TO PREVENT FLEEING OPPONENTS
    /*******************************************************************************/

    // set how likely it is for a character to prevent the opposition from fleeing from battle 
    public void setChanceToPreventEscape(double chanceToPreventEscape)
    {
        if(chanceToPreventEscape < 0)
        {
            chanceToPreventEscape = 0;
        }
        else if(chanceToPreventEscape > 100)
        {
            chanceToPreventEscape = 100;
        }

        this.chanceToPreventEscape = chanceToPreventEscape;
    }

    // get how likely it is for a character to prevent fleeing from battle 
    public double getChanceToPreventEscape()
    {
        return chanceToPreventEscape;
    }

    // END: CHANCE TO PREVENT FLEEING OPPONENTS
    /*******************************************************************************/
}