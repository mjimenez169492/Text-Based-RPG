package Generic_Character;

import Commonly_Used_Methods.StaticMethods;
import Move_Creation.StatusEffect;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.TreeSet;

/*
    StatusEffectContainer involves creating/maintaining a TreeSet meant for 
    holding status effects characters can gain in/outside of battle. 
*/

public class StatusEffectContainer 
{
    public StatusEffectContainer()
    {
        // empty constructor
    }
    
    
    
    // START: COMPARATOR FOR STATUS EFFECT CONTAINER
    /*******************************************************************************/

    /* for loop method is the same as lambda expression below:
    
        // custom TreeMap comparator sorts the objects of a TreeMap by name alphabetically
        public Comparator<StatusEffect> sortByName = new Comparator<StatusEffect>() 
        {
            // method compares the names of each object and sorts the objects such that
            // they are alphabetically ordered by name (ascending order from A to Z) 
            @Override 
            public int compare(StatusEffect statusOne, StatusEffect statusTwo) 
            {
                // return result of string comparison which will dictate TreeMap ordering
                return compareStrings(statusOne.getName(), statusTwo.getName());
            }
        };
    */
    
    // custom TreeSet comparator sorts status effects alphabetically by name 
    public Comparator<StatusEffect> sortByName = (StatusEffect statusOne, StatusEffect 
        statusTwo) -> StaticMethods.compareStrings(statusOne.getName(), statusTwo.getName()); 

    // hold status effects that affect a character in statusEffectContainer
    private final TreeSet<StatusEffect> statusEffectContainer = new TreeSet<>(sortByName);

    // END: COMPARATOR FOR STATUS EFFECT CONTAINER
    /*******************************************************************************/


    
    // START: ADDING, ALTERING, REMOVING, AND GETTING STATUS EFFECTS  
    /*******************************************************************************/
    
    public void alterExistingStatusEffect(StatusEffect status)
    {
        for(StatusEffect element : statusEffectContainer)
        {
            if(StaticMethods.sameStatusEffectName(status, element))
            {
                element.addEffects(status);
            }
        }
    }
    
    public void addStatusEffect(StatusEffect status)
    {
        if(status != null)
        {
            if(statusExists(status.getName()))
            {
                alterExistingStatusEffect(status);
            }
            else
            {
                statusEffectContainer.add(status);
            }        
        }
    }	
    
    public void removeStatusEffect(String statusName)
    {
        if(statusName != null)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(StaticMethods.sameStatusEffectName(statusName, element))
                {
                    statusEffectContainer.remove(element);
                }
            }
        }
    }

    public TreeSet<StatusEffect> getStatusEffects()
    {
        return statusEffectContainer;
    }
    
    // END: ADDING, ALTERING, REMOVING, AND GETTING STATUS EFFECTS 
    /*******************************************************************************/



    // START: USEFUL STATUS EFFECT CONTAINER METHODS 
    /*******************************************************************************/
    
    public boolean statusExists(String argument)
    {
        boolean result = false;

        if(argument != null)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(StaticMethods.sameStatusEffectName(argument, element))
                {
                    result = true;
                        break;
                }
            }
        }

        return result;
    }
    
    public boolean specificStatusExists(String[] array)
    {
        boolean result = false;

        for(StatusEffect status : statusEffectContainer)
        {
            if(!result)
            {
                for(String behavior : array)
                {
                    if(StaticMethods.sameStatusEffectName(behavior, status))
                    {
                        result = true;
                            break;
                    }
                }
            }
            else
            {
                break;
            }
        }

        return result;
    }
    
    public boolean behaviorStatusExists()
    {
        return specificStatusExists(StaticMethods.behaviorStatusEffectValueStrings());
    }
    
    public boolean turnBehaviorStatusExists()
    {
        return specificStatusExists(StaticMethods.turnBehaviorStatusEffectValueStrings());
    }
    
    // print the contents of statusEffectContainer (must decide style upon GUI creation)
    /*
    public void printStatusEffects()
    {
        int counter = 0;
        
        if(statusEffectContainer != null && statusEffectContainer.size() != 0)
        {
            for(int i = 0; i < statusEffectContainer.size(); i++)
            {
                if(i != statusEffectContainer.size() - 1)
                {
                    System.out.printf("%s, ", statusEffectContainer[i].getName());
                }
                else
                {
                    System.out.printf("%s", element.getName());
                }
                
                
            }
        }
    }
    */

    // END: USEFUL STATUS EFFECT CONTAINER METHODS 
    /*******************************************************************************/



    // START: DECREMENTING STATUS EFFECTS 
    /*******************************************************************************/

    public void decrementAllStatusEffectTurns()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                element.decrementTurns();
            }
        }
    }
    
    public void decrementStartOfTurnStatusEffectTurns()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.decrementAtStartOfTurn())
                {
                    element.decrementTurns();
                }
            }
        }
    }
    
    public void decrementEndOfTurnStatusEffectTurns()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(!element.decrementAtStartOfTurn())
                {
                    element.decrementTurns();
                }
            }
        }
    }

    // END: DECREMENTING STATUS EFFECTS 
    /*******************************************************************************/

    
    
    // START: REMOVING STATUS EFFECTS 
    /*******************************************************************************/
    
    public void removeStatusEffectIfZeroTurns()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getTurns() == 0 && !element.permanent())
                {
                    statusEffectContainer.remove(element);
                }
            }
        }		
    }
    
    public void removeStatusEffectsAfterKnockOut()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.removeAfterKnockOut())
                {
                    statusEffectContainer.remove(element);
                }
            }
        }	
    }

    public void removeStatusEffectsAfterBattle()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.removeAfterBattle())
                {
                    statusEffectContainer.remove(element);
                }
            }
        }	
    }
    
    public void removeStatusEffectRandomly()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            SecureRandom rand  = new SecureRandom();
            
            int randomNumber = (rand.nextInt(statusEffectContainer.size()));
            
            StatusEffect statusToBeRemoved = null;
            
            int counter = 0;
            
            for(StatusEffect element : statusEffectContainer)
            {
                if(counter == randomNumber)
                {
                    statusToBeRemoved = element;
                        break;
                }
                
                counter++;
            }
            
            statusEffectContainer.remove(statusToBeRemoved);
        }
    }
    
    // END: REMOVING STATUS EFFECTS 
    /*******************************************************************************/



    // START: EFFECT OF STATUS EFFECTS ON ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/

    public double allAttributesOrAllResistances(StatusEffect status, String allAttributes, 
        String allResistances, double sumOfEffectsOfStatusEffects)
    {
        if(status.getEffects().containsKey(allAttributes))
        {
            sumOfEffectsOfStatusEffects += status.getEffects().get(allAttributes);
        }
        else if(status.getEffects().containsKey(allResistances))
        {
            sumOfEffectsOfStatusEffects += status.getEffects().get(allResistances);
        }

        return sumOfEffectsOfStatusEffects;
    }
    
    // returns sum of doubles associated with attribute/resistance specified
    // Ex: status effect "Poison" affects Attack by 0.06 and status effect "Bleed"
    //     affects Attack by 0.08 so sum up double values and return that (0.14)
    public double sumOfEffects(String argument)
    {
        double sumOfEffectsOfStatusEffects = 0.0;

        if(argument != null && statusEffectContainer != null && statusEffectContainer.size() != 0)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getEffects().containsKey(argument))
                {
                    sumOfEffectsOfStatusEffects += element.getEffects().get(argument);
                    
                    if(element.getEffects().containsKey("All_Attributes") && element.getEffects().
                        containsKey("All_Resistances"))
                    {
                        sumOfEffectsOfStatusEffects += element.getEffects().get("All_Attributes");
                        sumOfEffectsOfStatusEffects += element.getEffects().get("All_Resistances");
                    }
                    else
                    {
                        sumOfEffectsOfStatusEffects += allAttributesOrAllResistances(element, 
                            "All_Attributes", "All_Resistances", sumOfEffectsOfStatusEffects);
                    }
                }
                else
                {
                    sumOfEffectsOfStatusEffects += allAttributesOrAllResistances(element, 
                        "All_Attributes", "All_Resistances", sumOfEffectsOfStatusEffects);
                }
             }
        }

        return sumOfEffectsOfStatusEffects;
    }
    
    // END: EFFECT OF STATUS EFFECTS ON ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
}
