package Generic_Character;

/*
    StatusEffectContainer involves creating/maintaining a TreeSet meant for holding 
    status effects that the character has gained in or outside of battle. 
*/

import Move_Creation.StatusEffect;
import Universally_Used_Methods.StaticMethods;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.TreeSet;

public class StatusEffectContainer extends Stress
{
    // START: COMPARATOR FOR STATUS EFFECT CONTAINER
    /*******************************************************************************/

    /*	To create a custom comparator: 
            Override existing comparator 
            Comparator must have the same type as the key in TreeMap 
            Comparator {} must end with a semicolon symbol (;)
                    SORTING is done by key NOT by value */

    /* Note on why compareTo() is not used...
       compareTo() sorting: number, Uppercase, lowercase -> 1Apple, Apple, Bee, apple */

    // compare two strings and determine whether they are the same or different regardless
    // of case (i.e. "example" would be considered the same as "Example") 
    // method used in comparators for TreeMaps involving string comparison between keys
    public int compareStrings(String argumentOne, String arguementTwo)
    {
        // code compares names without regard to case and stores result of comparison 
        // (1, 0, -1) in variable stringComparisonResult (1, -1 is different & 0 is same)
        int stringComparisonResult = String.CASE_INSENSITIVE_ORDER.compare(argumentOne, arguementTwo);

        // if strings are identical, set stringComparisonResult to 1 in order to place 
        // entry after the entry it is being compared to since order does not matter 
        // as they are the same String wise 
        if(stringComparisonResult == 0)
        {
                // if stringComparisonResult was not changed here, the key of the entry 
                // that is being compared to the key of entry that exists in the TreeMap 
                // would "merge/disappear" or not be added to the TreeMap along with its 
                // value resulting in data loss 
                stringComparisonResult = 1;
        }

        // return value held in stringComparisonResult
        return stringComparisonResult;
    }

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

    // hold status effects that affect a character in statusEffectContainer
    private final TreeSet<StatusEffect> statusEffectContainer = new TreeSet<StatusEffect>(sortByName);

    // END: COMPARATOR FOR STATUS EFFECT CONTAINER
    /*******************************************************************************/



    // START: ADDING AND REMOVING STATUS EFFECTS  
    /*******************************************************************************/
    
    // alter effects of status effect held in TreeSet by using status meant to be added 
    public void alterTreeSetStatusEffect(StatusEffect status)
    {
        for(StatusEffect element : statusEffectContainer)
        {
            if(StaticMethods.getStatusNameAsValidEnum(status.getName()) == 
                StaticMethods.getStatusNameAsValidEnum(element.getName()))
            {
                element.addEffects(status);
            }
        }
    }
    
    // add status effect object and store in statusEffectContainer 
    public void addStatus(StatusEffect status)
    {
        if(status != null)
        {
            if(statusExists(status.getName()))
            {
                alterTreeSetStatusEffect(status);
            }
            else
            {
                statusEffectContainer.add(status);
            }        
        }
    }	
    
    // remove status effect from statusEffectContainer by name 
    public void removeStatus(String statusName)
    {
        if(statusName != null)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(StaticMethods.getStatusNameAsValidEnum(statusName) == 
                    StaticMethods.getStatusNameAsValidEnum(element.getName()))
                {
                    statusEffectContainer.remove(element);
                }
            }
        }
    }

    // gets TreeSet holding status effects tied to character
    public TreeSet<StatusEffect> getStatusEffects()
    {
        return statusEffectContainer;
    }
    
    // END: ADDING AND REMOVING STATUS EFFECTS  
    /*******************************************************************************/



    // START: USEFUL STATUS EFFECT CONTAINER METHODS 
    /*******************************************************************************/
    
    // returns whether status effect exists in status effect container or not 
    public boolean statusExists(String argument)
    {
        boolean holdBoolean = false;

        if(argument != null)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(StaticMethods.getStatusNameAsValidEnum(argument) == 
                    StaticMethods.getStatusNameAsValidEnum(element.getName()))
                {
                    holdBoolean = true;
                        break;
                }
            }
        }

        return holdBoolean;
    }

    // returns desired status effect according to name supplied 
    public StatusEffect returnStatusByName(String statusName)
    {
        StatusEffect storedStatusEffect = null;
        
        for(StatusEffect element : statusEffectContainer)
        {
            if(StaticMethods.getStatusNameAsValidEnum(statusName) == 
                StaticMethods.getStatusNameAsValidEnum(element.getName()))
            {
                storedStatusEffect = element;
            }
        }
        
        return storedStatusEffect;
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



    // START: REMOVING STATUS EFFECT FROM STATUS EFFECT CONTAINER 
    /*******************************************************************************/

    // decrements turn count of all status effects in statusEffectContainer by one 
    public void decrementAllStatuses()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                element.decrementTurns();
            }
        }
    }
    
    // decrement status effects that can be decremented at start of each turn 
    public void decrementStartOfTurnStatuses()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getDecrementAtStartOfTurn())
                {
                    element.decrementTurns();
                }
            }
        }
    }
    
    // decrement status effects that can be decremented at end of each turn 
    public void decrementEndOfTurnStatuses()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(!element.getDecrementAtStartOfTurn())
                {
                    element.decrementTurns();
                }
            }
        }
    }

    // removes status effect objects if turns are 0 and if they are not "permanent"
    public void removeStatusesIfZeroTurns()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getTurns() == 0 && element.getPermanenceState() == false)
                {
                    getStatusEffects().remove(element);
                }
            }
        }		
    }
    
    // removes status effect objects meant to be removed after knock out ("Ko")
    public void removeStatusesAfterKnockOut()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getRemoveAfterKnockOut() == true)
                {
                    getStatusEffects().remove(element);
                }
            }
        }	
    }

    // removes status effects which are supposed to be removed after battle ends 
    public void removeAfterBattle()
    {
        if(statusEffectContainer != null && !statusEffectContainer.isEmpty())
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getRemoveAfterBattle() == true)
                {
                    getStatusEffects().remove(element);
                }
            }
        }	
    }
    
    // removes status effect from statusEffectContainer at random 
    public void removeStatusEffectRandomly()
    {
        if(!statusEffectContainer.isEmpty())
        {
            int counter = 0;
            
            SecureRandom rand  = new SecureRandom();
            
            int randomNumber = (rand.nextInt(statusEffectContainer.size()) + 1);
            
            StatusEffect statusToBeRemoved = null;
            
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
    
    // END: REMOVING STATUS EFFECT FROM STATUS EFFECT CONTAINER 
    /*******************************************************************************/



    // START: EFFECT OF STATUS EFFECTS ON ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/

    // returns sum of doubles associated with attribute/resistance specified
    // Ex: status effect "Poison" affects Attack by 0.06 and status effect "Bleed"
    //     affects Attack by 0.08 so sum up double values and return that (0.14)
    // Note: NO status effect has both "All Attributes" and "All Resistances" at 
    //       the same time so code below does NOT account for that scenario 
    public double getEffectOfStatusEffects(String argument)
    {
        double sumOfEffectsOfStatusEffects = 0.0;

        if(argument != null && statusEffectContainer != null && statusEffectContainer.size() != 0)
        {
            for(StatusEffect element : statusEffectContainer)
            {
                if(element.getEffects().containsKey(argument))
                {
                    sumOfEffectsOfStatusEffects += element.getEffects().get(argument);
                    
                    if(element.getEffects().containsKey("All_Attributes"))
                    {
                        sumOfEffectsOfStatusEffects += element.getEffects().get("All_Attributes");
                    }
                    else if(element.getEffects().containsKey("All_Resistances"))
                    {
                        sumOfEffectsOfStatusEffects += element.getEffects().get("All_Resistances");
                    }
                }
                else if(element.getEffects().containsKey("All_Attributes"))
                {
                    sumOfEffectsOfStatusEffects += element.getEffects().get("All_Attributes");
                }
                else if(element.getEffects().containsKey("All_Resistances"))
                {
                    sumOfEffectsOfStatusEffects += element.getEffects().get("All_Resistances");
                }
             }
        }

        return sumOfEffectsOfStatusEffects;
    }

    // END: EFFECT OF STATUS EFFECTS ON ATTRIBUTES AND RESISTANCES 
    /*******************************************************************************/
}