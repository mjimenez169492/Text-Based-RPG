package Move_Creation;

/*
    StatusEffect contains methods relating to creating status effect objects which 
    can positively or negatively effect character stats and/or behavior in and out
    of battle.
*/

import Commonly_Used_Methods.StaticMethods;
import java.util.HashMap;

public class StatusEffect
{
    private String name;                    // name of the status effect 
    private int inflictRate;                // chance status has at inflicting target  
    private int turns;                      // how long a status effect lasts in battle 
    private boolean permanent;              // determine if status is permanent or not 
    private boolean decrementAtStartOfTurn; // determines if turn count is decremented at start of turn 
    private boolean removeAfterKo;          // determines if status effect is removed upon character knock out ("KO")
    private boolean removeAfterBattle;      // determine whether status effect is removed immediately after battle 

    // hashmap keeps track of attributes/resistances targeted as well as their effects 
    // Note: Double is used instead of double since primitive types cannot be used 
    //       in diamond (<>) meaning that a wrapper must be used (int  -> Integer)
    HashMap<String, Double> effectsOfStatusEffect = new HashMap<>();
    
    // constructor allows for creation of status effect object 
    public StatusEffect()
    {
        // empty constructor 
    }



    // START: STATUS EFFECT ATTRIBUTES
    /********************************************************************************/

    public void setName(String name)
    {
        if(name != null)
        {
            if(name.length() > 26)
            {
                this.name = name.substring(0, 26);
            }
            else
            {
                this.name = name;
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public void setTurns(int turns)
    {
        if(turns < 0)
        {
            turns = 0;
        }
        else if(turns > 8)
        {
            turns = 8;
        }

        this.turns = turns;
    }

    public int getTurns()
    {
        return turns;
    }

    public void permanent(boolean permanent)
    {
        this.permanent = permanent;
    }

    public boolean permanent()
    {
        return permanent;
    }

    public void setInflictionRate(int inflictRate)
    {
        if(inflictRate < 0)
        {
            inflictRate = 0;
        }
        else if(inflictRate > 100)
        {
            inflictRate = 100;
        }

        this.inflictRate = inflictRate;
    }

    public int getInflictionRate()
    {
        return inflictRate;
    }

    public void decrementAtStartOfTurn(boolean decrementAtStartOfTurn)
    {
        this.decrementAtStartOfTurn = decrementAtStartOfTurn;
    }

    public boolean decrementAtStartOfTurn()
    {
        return decrementAtStartOfTurn;
    }

    public void decrementTurns()
    {
        setTurns(getTurns() - 1);
    }

    public void removeAfterKnockOut(boolean removeAfterKo)
    {
        this.removeAfterKo = removeAfterKo;
    }

    public boolean removeAfterKnockOut()
    {
        return removeAfterKo;
    }

    public void removeAfterBattle(boolean removeAfterBattle)
    {
        this.removeAfterBattle = removeAfterBattle;
    }

    public boolean removeAfterBattle()
    {
        return removeAfterBattle;
    }
    
    // END: STATUS EFFECT OBJECT ATTRIBUTES
    /********************************************************************************/

    
    
    // START: STATUS EFFECT OBJECT EFFECTS
    /********************************************************************************/
    
    public double validateDouble(double value)
    {
        if(value < -1.00)
        {
            value = -1.00;
        }
        else if(value > 1.00)
        {
            value = 1.00;
        }
        
        return value;
    }
    
    // adds stat (attribute/resistance) name as key and Double value as effect
    public void addStatNameAndDoubleEffect(String stat, Double effect)
    {
        if(StaticMethods.getStatString(stat) != null)
        {
            effectsOfStatusEffect.put(stat, validateDouble(effect));
        }
    }
    
    // removes stat name (key) resulting in removal of stat's effect (value)
    public void removeStat(String stat, Double effect)
    {
        if(StaticMethods.getStatString(stat) != null)
        {
            effectsOfStatusEffect.put(stat, effect);
        }
    }
    
    // return status effect HashMap containing attributes/resistances targeted and effects
    public HashMap<String,Double> getEffects()
    {
        return effectsOfStatusEffect;
    }
    
    // Note: method is meant to be used in StatusEffectContainer    
    // adds effects of status effect object meant to be added to effectsOfStatusEffect
    // to effects of status effect object that ALREADY exists in effectsOfStatusEffect 
    public void addEffects(StatusEffect statusToBeAdded)
    {
        // decrement turns for status in status effect container 
        decrementTurns();
        
        // loop through keys and values of status meant to be added status in container
        for(HashMap.Entry<String,Double> copy : statusToBeAdded.getEffects().entrySet())
        {
            // for location specified by key of status effect not in status effect container, 
            // add value of status effect IN container associated with that key with value of
            // that key for status effect not in status effect container 
            effectsOfStatusEffect.put(copy.getKey(), effectsOfStatusEffect.get(copy.getKey()) 
                + statusToBeAdded.getEffects().get(copy.getKey()));
        }
    }
    
    // END: STATUS EFFECT OBJECT EFFECTS 
    /********************************************************************************/
}
