package Move_Creation;

/*
    StatusEffect contains methods relating to creating status effect objects which 
    can positively or negatively effect character stats and/or behavior in and out
    of battle.
*/

import Universally_Used_Methods.StaticMethods;
import java.util.HashMap;

public class StatusEffect
{
    private String name;                    // name of the status effect 
    private int inflictRate;                // chance status has at inflicting target  
    private int turns;                      // how long a status effect lasts in battle 
    private boolean permanenceState;        // determine if status is permanent or not 
    private boolean decrementAtStartOfTurn; // determines if turn count is decremented at start of turn 
    private boolean removeAfterKo;          // determines if status effect is removed upon character knock out ("KO")
    private boolean removeAfterBattle;      // determine whether status effect is removed immediately after battle 

    // hashmap keeps track of attributes/resistances targeted as well as their effects 
    // Note: Double is used instead of double since primitive types cannot be used 
    //       in diamond (<>) meaning that a wrapper must be used (int  -> Integer)
    HashMap<String, Double> effectsOfStatusEffect = new HashMap<String, Double>();

    // constructor allows for creation of status effect object 
    public StatusEffect()
    {
        // empty constructor 
    }



    // START: STATUS EFFECT ATTRIBUTES
    /********************************************************************************/

    // set name for status effect (trim name if it is too long)
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

    // get name of status effect 
    public String getName()
    {
        return name;
    }

    // set how many turns a status effect lasts 
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

    // get how many turns a status effect lasts 
    public int getTurns()
    {
        return turns;
    }

    // set whether or not status can be removed 
    public void setPermanenceState(boolean permanenceState)
    {
        this.permanenceState = permanenceState;
    }

    // get state of status permanence
    public boolean getPermanenceState()
    {
        return permanenceState;
    }

    // sets chance that status can be inflicted on target  
    public void setInflictRate(int inflictRate)
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

    // gets chance that status can be inflicted on target  
    public int getInflictRate()
    {
        return inflictRate;
    }

    // sets whether status effect is decremented at start of turn 
    public void setDecrementAtStartOfTurn(boolean decrementAtStartOfTurn)
    {
        this.decrementAtStartOfTurn = decrementAtStartOfTurn;
    }

    // gets whether status effect is decremented at start of turn 
    public boolean getDecrementAtStartOfTurn()
    {
        return decrementAtStartOfTurn;
    }

    // decrement turn count by 1 
    public void decrementTurns()
    {
        setTurns(getTurns() - 1);
    }

    // sets whether status effect is removed after character is knocked out ("KO")
    public void setRemoveAfterKnockOut(boolean removeAfterKo)
    {
        this.removeAfterKo = removeAfterKo;
    }

    // gets whether status effect is removed after character is knocked out ("KO")
    public boolean getRemoveAfterKnockOut()
    {
        return removeAfterKo;
    }

    // set whether status effect is removed after battle or not 
    public void setRemoveAfterBattle(boolean removeAfterBattle)
    {
        this.removeAfterBattle = removeAfterBattle;
    }

    // get whether status effect is removed after battle or not 
    public boolean getRemoveAfterBattle()
    {
        return removeAfterBattle;
    }

    // END: STATUS EFFECT OBJECT ATTRIBUTES
    /********************************************************************************/

    
    
    // START: STATUS EFFECT OBJECT EFFECTS
    /********************************************************************************/
    
    // ensure that double supplied is within a valid bounds 
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
    
    // adds stat name as key and Double values as value for effectsOfStatusEffect 
    public void addStatAndDoubleEffect(String stat, Double effect)
    {
        if(StaticMethods.getStatusNameAsValidEnum(stat) != null)
        {
            effectsOfStatusEffect.put(stat, validateDouble(effect));
        }
    }
    
    // removes stat name resulting in removal of effect simultaneously 
    // Note: removal of key (in this case stat name) results in removal of value 
    public void removeStat(String stat, Double effect)
    {
        if(StaticMethods.getStatusNameAsValidEnum(stat) != null)
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