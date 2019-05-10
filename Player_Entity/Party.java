package Player_Entity;

/*
    Party concerns storing GenericCharacter objects or characters that exist in
    the game world. A party (and characters within it) can either be controlled 
    by the player or by limited AI such that each character within the party is
    directed to perform actions according to code detailing battle behavior for
    the battle based on numerous factors. What makes the player party unique is 
    the ability for players to manage the state of the party and its members. A
    player can use features unique to parties such as access to an inventory to 
    improve the odds of success in/outside the field of battle. One should note
    that some characters inserted into the party cannot be controlled since the
    character has likely been modified to perform according to AI code.
*/

import Generic_Character.GenericCharacter;
import Commonly_Used_Methods.StaticMethods;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.TreeSet;

public class Party  
{
    // determines whether party is under player control or AI control in battle 
    private boolean playerParty; 	
    
    // lambda expression representing comparator TreeMap uses to sort characters 
    public Comparator<GenericCharacter> sortByName = (GenericCharacter characterOne, GenericCharacter 
        characterTwo) -> StaticMethods.compareStrings(characterOne.getGeneralFeatures().getName(), 
        characterTwo.getGeneralFeatures().getName()); 

    // stores character and mode character takes in battle which affects attributes  
    private final TreeSet<GenericCharacter> party = new TreeSet<>(sortByName);

    public Party()
    {
        // empty constructor
    }
    
    
    
    // START: PARTY CONTROL STATE (TRUE FOR PLAYER OR FALSE FOR AI)
    /*******************************************************************************/

    public void playerParty(boolean playerParty)
    {
        this.playerParty = playerParty;
    }

    public boolean playerParty()
    {
        return playerParty;
    }
    
    // END: PARTY CONTROL STATE (TRUE FOR PLAYER OR FALSE FOR AI)
    /*******************************************************************************/

    
    
    // START: ADDING/REMOVING/RETRIEVING CHARACTERS 
    /*******************************************************************************/
    
    public void addToParty(GenericCharacter character)
    {
        if(character != null)
        {
            party.add(character);
        }
    }

    public void removeFromParty(String characterName)
    { 
        if(party != null && !party.isEmpty())
        {
            for(GenericCharacter element : party)
            {
                if(characterName.equals(element.getGeneralFeatures().getName()))
                {
                    party.remove(element);
                }
            }	
        }
    }
    
    public void removeFromParty(GenericCharacter character)
    { 
        if(party != null && !party.isEmpty())
        {
            if(party.contains(character))
            {                
                party.remove(character);
            }		
        }
    }

    public GenericCharacter getDesiredPartyMember(String characterName)
    {
        GenericCharacter character = null;

        if(party != null && !party.isEmpty())
        {
            for(GenericCharacter element : party)
            {
                if(characterName.equals(element.getGeneralFeatures().getName()))
                {
                    character = element;
                }
            }			
        }

        return character;
    }
    
    public boolean partyMemberExists(GenericCharacter character)
    {
        boolean result = true;

        if(party != null && !party.isEmpty())
        {
            for(GenericCharacter element : party)
            {
                if(character.equals(element))
                {
                    result = true;
                }
            }			
        }

        return result;
    }

    // Note: remember to store party members for tracking their states 
    public ArrayList<GenericCharacter> getAllPartyMembersExcept(String characterName)
    {
        ArrayList<GenericCharacter> retrieveCharacters = new ArrayList<>();
        
        if(party != null && party.size() > 1)
        {
            for(GenericCharacter element : party)
            {
                if(!characterName.equals(element.getGeneralFeatures().getName()))
                {
                    retrieveCharacters.add(element);
                }
            }			
        }

        return retrieveCharacters;
    }
    
    public void removePartyMembers(ArrayList<GenericCharacter> members)
    {
        for(GenericCharacter element : members)
        {
            removeFromParty(element);
        }
    }
    
    public TreeSet<GenericCharacter> getPartyMembers()
    {
        return party;
    }

    // END: ADDING/REMOVING/RETRIEVING CHARACTERS 
    /*******************************************************************************/

    
    
    // START: STATES OF CHARACTERS WITHIN PARTY 
    /*******************************************************************************/

    public boolean boss()
    {
        boolean result = false;

        for(GenericCharacter element : party)
        {
            if(element.getGeneralFeatures().boss())
            {
                result = true;
                    break;
            }
        }

        return result;
    }
    
    public boolean endBattle()
    {
        boolean result = false;

        for(GenericCharacter element : party)
        {
            if(element.getGeneralFeatures().endBattle())
            {
                result = true;
            }
        }

        return result;
    }

    // if all characters are knocked out ("KO") then party is KO (fail state)
    public boolean partyKnockedOut()
    {
        // assume party is dead and assign variable with true 
        boolean result = true;

        for(GenericCharacter element : party)
        {
            // if at least one character is NOT knocked out (ie: has more than 0 
            // current health) or if party member is immortal then assign result 
            // with false since the party is not considered knocked out ("KO")
            if(!element.getGeneralFeatures().knockedOut() || element.getMoveImmunity().immortal())
            {
                result = false;
            }
        }

        return result;
    }

    // returns whether party member is dead upon hitting 0 health (fail state)
    public boolean partyMemberDead()
    {
        boolean result = false;

        for(GenericCharacter element : party)
        {
            // if character is considered "fragile" then death state if knocked out 
            if(element.getGeneralFeatures().knockedOut() && element.getMoveImmunity().fragile())
            {
                result = true;
            }
        }

        return result;
    }
    
    // reset all end battle triggers for all party members 
    public void resetEndBattle()
    {
        for(GenericCharacter element : party)
        {
            element.getGeneralFeatures().endBattle(false);
        }
    }
    
    // set battle dexterity for all party members 
    public void setBattleDexterity()
    {
        for(GenericCharacter element : party)
        {
            element.getGeneralFeatures().setBattleDexterity(element);
        }
    }
    
    // END: STATES OF CHARACTERS WITHIN PARTY 
    /*******************************************************************************/

    
    
    // START: AVERAGE PARTY ATTRIBUTE 
    /*******************************************************************************/

    public enum Averages
    {
        LEVEL, ATTACK, DEFENSE, DEXTERITY, CRITICAL, ACCURACY, NANO_ATTACK, 
        NANO_DEFENSE, LUCK, CHANCE_TO_PREVENT_ESCAPE;
    }
    
    public double getAverageAttribute(Averages choice)
    {
        double holdDouble = 0;

        for(GenericCharacter element : party)
        {
            switch(choice)
            {
                case LEVEL: 
                    holdDouble += element.getGeneralFeatures().getLevel();
                        break;
                case ATTACK: 
                    holdDouble += element.getTotalStats().getTotalAttack();
                        break;
                case DEFENSE: 
                    holdDouble += element.getTotalStats().getTotalDefense();
                        break;
                case DEXTERITY: 
                    holdDouble += element.getTotalStats().getTotalDexterity();
                        break;
                case CRITICAL: 
                    holdDouble += element.getTotalStats().getTotalCritical();
                        break;
                case ACCURACY: 
                    holdDouble += element.getTotalStats().getTotalAccuracy();
                        break;
                case NANO_ATTACK: 
                    holdDouble += element.getTotalStats().getTotalNanoAttack();
                        break;
                case NANO_DEFENSE: 
                    holdDouble += element.getTotalStats().getTotalNanoDefense();
                        break;
                case LUCK: 
                    holdDouble += element.getStats().getLuck();
                        break;
                case CHANCE_TO_PREVENT_ESCAPE:
                    holdDouble += element.getGeneralFeatures().getChanceToPreventEscape();
                        break;
            }
        }

        return (holdDouble / (double)party.size());
    }

    public double getAverageLevel()
    {
        return getAverageAttribute(Averages.LEVEL);
    }

    public double getAverageAttack()
    {
        return getAverageAttribute(Averages.ATTACK);
    }

    public double getAverageDefense()
    {
        return getAverageAttribute(Averages.DEFENSE);
    }

    public double getAverageDexterity()
    {
        return getAverageAttribute(Averages.DEXTERITY);
    }

    public double getAverageCritical()
    {
        return getAverageAttribute(Averages.CRITICAL);
    }

    public double getAverageAccuracy()
    {
        return getAverageAttribute(Averages.ACCURACY);
    }

    public double getAverageNanoAttack()
    {
        return getAverageAttribute(Averages.NANO_ATTACK);
    }

    public double getAverageNanoDefense()
    {
        return getAverageAttribute(Averages.NANO_DEFENSE);
    }

    public double getAverageLuck()
    {
        return getAverageAttribute(Averages.LUCK);
    }

    public double getAverageChanceToPreventEscape()
    {
        return getAverageAttribute(Averages.CHANCE_TO_PREVENT_ESCAPE);
    }
    
    // END: AVERAGE PARTY ATTRIBUTE 
    /*******************************************************************************/
    
    
    
    // START: AVERAGE PARTY ATTRIBUTE IN BATTLE
    /*******************************************************************************/
    
    // gets average value desired based on party members that have not escaped battle
    // from battle and party members that have not been not knocked out ("KO")
    public double getAverageForActiveCombatants(ArrayList<GenericCharacter> activePartyMembers, 
        Averages choice)
    {	
        double result = 0.0;

        if(activePartyMembers != null && !activePartyMembers.isEmpty())
        {
            for(GenericCharacter element : activePartyMembers)
            {
                if(!element.getGeneralFeatures().knockedOut() && party.contains(element))
                {
                    switch(choice)
                    {
                        case LEVEL:
                            result += element.getGeneralFeatures().getLevel();
                                break;
                        case DEXTERITY: 
                            result += element.getTotalStats().getTotalDexterity();
                                break;
                        case CHANCE_TO_PREVENT_ESCAPE: 
                            result += element.getGeneralFeatures().getChanceToPreventEscape();
                                break;
                    }
                }
            }
        }

        return (result / (double)party.size());
    }

    public double getAverageActiveLevel(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, Averages.LEVEL);
    }
    
    public double getAverageActiveDexterity(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, Averages.DEXTERITY);
    }

    public double getAverageActiveChanceToPreventEscape(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, Averages.CHANCE_TO_PREVENT_ESCAPE);
    }
    
    // START: AVERAGE PARTY ATTRIBUTE IN BATTLE 
    /*******************************************************************************/
}
