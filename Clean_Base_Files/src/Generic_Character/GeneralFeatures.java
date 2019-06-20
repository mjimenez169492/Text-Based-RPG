package Generic_Character;

/* 
    GeneralFeatures contains information that is generally available to all 
    GenericCharacter Objects. 
*/ 

public class GeneralFeatures 
{
    // holding objects from other classes 
    private TotalStats totalStats;
    
    // if party member is NOT under player control then its AI script is used 
    private boolean playerControl;	
    
    // if character is a boss entity then escape for all combatants is impossible 
    private boolean boss;		
    
    // what character is called and what kind of entity character is (human, ect.)
    private String name, type; 
    
    // current level, experience (EXP), and expScale dictating leveling behavior 
    private double level, experience, expScale;		

    // current gauges capped by "getTotalMax_" versions of the gauges 
    private double currentHealth, currentNano, currentStamina;	
    
    // denotes if character was damaged, nanomcahine presence, and if battle ends early
    private boolean damaged, nanomachines, endBattle;	

    // decides turns in battle and how well character can stop foes from escaping battle 
    private double battleDexterity, chanceToPreventEscape;			
    
    public GeneralFeatures(TotalStats totalStats)
    {
        this.totalStats = totalStats;
    }	


    
    // START: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/
    
    public void setTotalAttributesAndResistancesObject(TotalStats 
        totalStats)
    {
        this.totalStats = totalStats;
    }
    
    public TotalStats getTotalAttributesAndResistancesObject()
    {
        return totalStats;
    }
    
    // END: HOLDING OBJECTS SUPPLIED FROM OTHER CLASSES 
    /*******************************************************************************/

    
    
    // START: UNIQUE CHARACTER STATES AFFECTING BATTLE PROGRESSION 
    /*******************************************************************************/

    public void playerControl(boolean playerControl)
    {
        this.playerControl = playerControl;
    }

    public boolean playerControl()
    {
        return playerControl;
    }
    
    public void boss(boolean boss)
    {
        this.boss = boss;
    }

    public boolean boss()
    {
        return boss;
    }
    
    // END: UNIQUE CHARACTER STATES AFFECTING BATTLE PROGRESSION 
    /*******************************************************************************/


    // START: DEFINING CHARACTER 
    /*******************************************************************************/

    public String checkStringLength(String argument)
    {
        if(argument != null && !argument.equals(""))
        {
            if(argument.length() > 26)
            {
                argument = argument.substring(0, 25);
            }
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

    public void setLevel(double level)
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

    public double getLevel()
    {
        return level; 
    } 
    
    public void incrementLevel()
    {
        level += 1;
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

    // Note: base expScale should be 33 
    public void setExpScale(double expScale)
    {
        if((int)expScale % 11 == 0)
        {
            this.expScale = expScale;
        }
        else
        {
            this.expScale = 1;
        }
    }

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
        this.currentHealth = Math.floor(validateCurrentGauges(currentHealth, 
            getTotalAttributesAndResistancesObject().getTotalMaxHealth()));
    }

    public double getCurrentHealth()
    {
        return currentHealth;
    }

    public void setCurrentStamina(double currentStamina)
    {
        this.currentStamina = Math.floor(validateCurrentGauges(currentStamina, 
            getTotalAttributesAndResistancesObject().getTotalMaxStamina()));
    }

    public double getCurrentStamina()
    {
        return currentStamina;
    }

    public void setCurrentNano(double currentNano)
    {
        this.currentNano = Math.floor(validateCurrentGauges(currentNano, 
            getTotalAttributesAndResistancesObject().getTotalMaxNano()));
    }

    public double getCurrentNano()
    {
        return currentNano;
    }

    // END: CHARACTER CURRENT GAUGES
    /*******************************************************************************/

	
    
    // START: BOOLEANS REPRESENTING CERTAIN CHARACTER STATES 
    /*******************************************************************************/

    // Note: reset damage every round 
    public void damaged(boolean damaged)
    {
        this.damaged = damaged;
    }

    public boolean damaged()
    {
        return damaged;
    }
    
    public void nanomachines(boolean nanomachines)
    {
        this.nanomachines = nanomachines;
    }

    public boolean nanomachines()
    {
        return nanomachines;
    }
    
    public void endBattle(boolean endBattle)
    {
        this.endBattle = endBattle;
    }

    public boolean endBattle()
    {
        return endBattle;
    }

    // END: BOOLEANS REPRESENTING CERTAIN CHARACTER STATES 
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
        battleDexterity = getTotalAttributesAndResistancesObject().getTotalDexterity();
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
        battleDexterity = checkBattleDexterity((getTotalAttributesAndResistancesObject().
            getTotalDexterity() * value)); 
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
