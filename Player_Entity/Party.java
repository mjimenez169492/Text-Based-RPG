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
import Universally_Used_Methods.StaticMethods;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class Party extends 
{
    // determines whether party is under player control or AI control in battle 
    private boolean playerControlState; 	
    
    // lambda expression representing comparator TreeMap uses to sort characters 
    public Comparator<GenericCharacter> sortByName = (GenericCharacter characterOne, GenericCharacter 
        characterTwo) -> compareStrings(characterOne.getName(), characterTwo.getName()); 

    // stores character and mode character takes in battle which affects attributes  
    private final TreeMap<GenericCharacter, ValidModes> party = new TreeMap<>(sortByName);

    
    
    // START: PARTY CONTROL STATE (TRUE FOR PLAYER OR FALSE FOR AI)
    /*******************************************************************************/

    public void setPlayerPartyState(boolean playerControlState)
    {
        this.playerControlState = playerControlState;
    }

    public boolean getPlayerPartyState()
    {
        return playerControlState;
    }
    
    // END: PARTY CONTROL STATE (TRUE FOR PLAYER OR FALSE FOR AI)
    /*******************************************************************************/

    
    
    // START: MODE INTRODUCTION AND COMMON MODE METHODS   
    /*******************************************************************************/

    /* Mode Mechanics
        possible for each party member to enter unique mode affecting attributes 
            attack, defense, dexterity, accuracy, critical, nano attack, nano defense 
        attributes boosted percentage-wise 
            (Ex: "Mode: Assault" boosts attack by 15% of user's own attack)
        modes consume Stamina/Nano points PER TURN to be active at full power
            if points are not available for turn then Mode is switched to NONE
        mode starts off as "None" and can be changed in or outside of battle 
        only ONE mode can be active at any one time due to bodily stress 
            switching to another mode removes current mode before switch 
        the value of a mode on an attribute is multiplied directly against attribute 
        modes by consumption type with consumption rate (Mode: _ where "_" is mode name)
            NO CONSUMPTION 
                None (does not show up)
            STAMINA CONSUMPTION
                Mode: Physical 
                    Effect: raises all non-nano attributes 
                        Attributes Raised: attack (1.09), accuracy (1.11), defense (1.07), dexterity (1.06), critical (1.40)
                            Attributes Lowered: None 
                                Rate: 8% 
                Mode: Assault 
                    Effect: raises all non-nano attack related attributes 
                        Attributes Raised: attack (1.33), accuracy (1.21), critical (1.75) 
                            Attributes Lowered : defense (0.75), dexterity (0.75) 
                                Rate: 13% 
                Mode: Shield 
                    Effect: raises all non-nano defense attributes 
                        Attributes Raised: defense (1.45) 
                            Attributes Lowered : attack (0.80), accuracy (0.85), dexterity (0.85), critical 2.35) 
                                Rate: 16% 
            NANO CONSUMPTION 
                Mode: Glass 
                    Effect: raises all non-attack related attributes at the expense of defenses 
                        Attributes Raised: attack (1.57), accuracy (1.32), dexterity (1.44), critical (2.78), nano attack (1.66)
                            Attributes Lowered : defense (0.35), nano defense (0.35)
                                Rate: 23% 
                Mode: Critz 
                    Effect: raises accuracy and critical by an enormous degree
                        Attributes Raised: accuracy (1.55), critical (6.66) 
                            Attributes Lowered : defense (0.72), nano defense (0.81)
                                Rate: 13% 
                Mode: Nano 
                    Effect: raises all nano attributes 
                        Attributes Raised: nano attack (1.42), nano defense (1.36) 
                            Attributes Lowered : None 
                                Rate: 16%   
        each mode a HashMap to manage its own keys (attribute name) and values
    */
    
    // enum class contains GenericCharacter object attributes considered by modes 
    public enum ValidAttributes
    {
        ATTACK, DEFENSE, DEXTERITY, ACCURACY, CRITICAL, NANO_ATTACK, NANO_DEFENSE;
    }
    
    // gets String form of ValidAttribute argument passed 
    public static String getAttributeStringUsingEnum(ValidAttributes attribute)
    {
        String result = null;
        
        switch(attribute)
        {
            case ATTACK:
                result = "Attack";
                    break;
            case DEFENSE:
                result = "Defense";
                    break;
            case DEXTERITY:
                result = "Dexterity";
                    break;
            case ACCURACY:
                result = "Accuracy";
                    break;
            case CRITICAL:
                result = "Critical";
                    break;
            case NANO_ATTACK:
                result = "Nano Attack";
                    break;
            case NANO_DEFENSE:
                result = "Nano Defense";
                    break;
        }
        
        return result;
    }
    
    // returns array of enum values for ValidAttribute as array of Strings 
    public static String[] validAttributesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(ValidAttributes.values())];
        
        for(int i = 0; i < ValidAttributes.values().length; i++)
        {
            array[i] = getAttributeStringUsingEnum(ValidAttributes.values()[i]);
        }

        return array;
    }
    
    // returns ValidAttribute enum form of String passed so long as String is valid 
    public static ValidAttributes getAttributeEnumUsingString(String argument)
    {
        ValidAttributes result = null;
        
        if(StaticMethods.isStringValid(validAttributesAsStrings(), argument))
        {   
            result = ValidAttributes.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }

    // END: MODE INTRODUCTION AND COMMON MODE METHODS   
    /*******************************************************************************/
    
    
    
    // START: MODE NONE 
    /*******************************************************************************/

    private static final HashMap<ValidAttributes, Double> none = new HashMap<>();
        static
        {
            for (ValidAttributes element : ValidAttributes.values())
            {
                none.put(element, 1.00);
            }
        }
    
    public double getNoneValueForKey(ValidAttributes key)
    {
        return none.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeNone()
    {
        return none;
    }
        
    // END: MODE NONE 
    /*******************************************************************************/

    
    
    // START: STAMINA MODES 
    /*******************************************************************************/

    // START: MODE PHYSICAL 
    
    public static Double getPhysicalValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 1.09;
                    break;
            case DEFENSE:
                result = 1.07;
                    break;
            case DEXTERITY:
                result = 1.06;
                    break;
            case ACCURACY:
                result = 1.11;
                    break;
            case CRITICAL:
                result = 1.44;
                    break;
            case NANO_ATTACK:
                result = 1.00;
                    break;
            case NANO_DEFENSE:
                result = 1.00;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> physical = new HashMap<>();
        static
        {
            for (ValidAttributes element : ValidAttributes.values())
            {
                physical.put(element, getPhysicalValueForAttribute(element));
            }
        }
        
    public double getPhysicalValueForKey(ValidAttributes key)
    {
        return physical.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModePhysical()
    {
        return physical;
    }
    
    // END: MODE PHYSICAL 
    
    
    // START: MODE ASSAULT
    
    public static Double getAssaultValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 1.33;
                    break;
            case DEFENSE:
                result = 0.75;
                    break;
            case DEXTERITY:
                result = 0.75;
                    break;
            case ACCURACY:
                result = 1.21;
                    break;
            case CRITICAL:
                result = 1.75;
                    break;
            case NANO_ATTACK:
                result = 1.00;
                    break;
            case NANO_DEFENSE:
                result = 1.00;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> assault = new HashMap<>();
        static 
        {
            for (ValidAttributes element : ValidAttributes.values()) 
            {
                assault.put(element, getAssaultValueForAttribute(element));
            }
        }
        
    public double getAssaultValueForKey(ValidAttributes key)
    {
        return assault.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeAssault()
    {
        return assault;
    }
    
    // END: MODE ASSAULT
    
    
    // START: MODE SHIELD
    
    public static Double getShieldValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 0.80;
                    break;
            case DEFENSE:
                result = 1.45;
                    break;
            case DEXTERITY:
                result = 0.75;
                    break;
            case ACCURACY:
                result = 0.85;
                    break;
            case CRITICAL:
                result = 2.35;
                    break;
            case NANO_ATTACK:
                result = 1.00;
                    break;
            case NANO_DEFENSE:
                result = 1.00;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> shield = new HashMap<>();
        static 
        {
            for (ValidAttributes element : ValidAttributes.values()) 
            {
                shield.put(element, getShieldValueForAttribute(element));
            }
        }
        
    public double getShieldValueForKey(ValidAttributes key)
    {
        return shield.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeShield()
    {
        return shield;
    }
    
    // END: MODE SHIELD
    
    // END: STAMINA MODES 
    /*******************************************************************************/
    
    
    
    // START: NANO MODES 
    /*******************************************************************************/

    // START: GLASS 
    
    public static Double getGlassValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 1.57;
                    break;
            case DEFENSE:
                result = 0.33;
                    break;
            case DEXTERITY:
                result = 1.44;
                    break;
            case ACCURACY:
                result = 1.32;
                    break;
            case CRITICAL:
                result = 2.78;
                    break;
            case NANO_ATTACK:
                result = 1.66;
                    break;
            case NANO_DEFENSE:
                result = 0.33;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> glass = new HashMap<>();
        static 
        {
            for (ValidAttributes element : ValidAttributes.values()) 
            {
                glass.put(element, getGlassValueForAttribute(element));
            }
        }
        
    public double getGlassValueForKey(ValidAttributes key)
    {
        return glass.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeGlass()
    {
        return glass;
    }
    
    // END: GLASS 
    
    
    // START: CRITZ 
    
    public static Double getCritzValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 1.00;
                    break;
            case DEFENSE:
                result = 0.87;
                    break;
            case DEXTERITY:
                result = 1.00;
                    break;
            case ACCURACY:
                result = 1.55;
                    break;
            case CRITICAL:
                result = 6.66;
                    break;
            case NANO_ATTACK:
                result = 1.00;
                    break;
            case NANO_DEFENSE:
                result = 0.81;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> critz = new HashMap<>();
        static 
        {
            for (ValidAttributes element : ValidAttributes.values()) 
            {
                critz.put(element, getCritzValueForAttribute(element));
            }
        }
        
    public double getCritzValueForKey(ValidAttributes key)
    {
        return critz.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeCritz()
    {
        return critz;
    }
    
    // END: CRITZ 
    
    
    // START: NANO
    
    public static Double getNanoValueForAttribute(ValidAttributes attribute)
    {
        double result = 0.0;
        
        switch(attribute)
        {
            case ATTACK:
                result = 1.00;
                    break;
            case DEFENSE:
                result = 1.00;
                    break;
            case DEXTERITY:
                result = 1.00;
                    break;
            case ACCURACY:
                result = 1.00;
                    break;
            case CRITICAL:
                result = 1.00;
                    break;
            case NANO_ATTACK:
                result = 1.42;
                    break;
            case NANO_DEFENSE:
                result = 1.36;
                    break;
        }
        
        return result;
    }
    
    private static final HashMap<ValidAttributes, Double> nano = new HashMap<>();
        static 
        {
            for (ValidAttributes element : ValidAttributes.values()) 
            {
                nano.put(element, getNanoValueForAttribute(element));
            }
        }
        
    public double getNanoValueForKey(ValidAttributes key)
    {
        return nano.get(key);
    }
    
    public static HashMap<ValidAttributes, Double> getModeNano()
    {
        return nano;
    }
    
    // END: NANO
    
    // END: NANO MODES 
    /*******************************************************************************/

    
    
    // START: MANAGING ALL MODES IN ONE HASHMAP
    /*******************************************************************************/

    // enum class contains valid modes party member can enter in battle 
    public enum ValidModes
    {
        NONE, PHYSICAL, ASSAULT, SHIELD, GLASS, CRITZ, NANO;
    }
    
    // gets String form of ValidModes argument passed 
    public String getModeStringUsingEnum(ValidModes mode)
    {
        String result = null;
        
        switch(mode)
        {
            case NONE:
                result = "None";
                    break;
            case PHYSICAL:
                result = "Physical";
                    break;
            case ASSAULT:
                result = "Assault";
                    break;
            case SHIELD:
                result = "Shield";
                    break;
            case GLASS:
                result = "Glass";
                    break;
            case CRITZ:
                result = "Critz";
                    break;
            case NANO:
                result = "Nano";
                    break;
        }
        
        return result;
    }
    
    // gets array of enum values for ValidModes as array of Strings 
    public String[] validModesAsStrings()
    {
        String[] array = new String[StaticMethods.getNumberOfEnumElements(
            ValidModes.values())];
        
        for(int i = 0; i < ValidModes.values().length; i++)
        {
            array[i] = getModeStringUsingEnum(ValidModes.values()[i]);
        }

        return array;
    }
    
    // gets ValidModes enum form of String passed so long as String is valid 
    public ValidModes getModeEnumUsingString(String argument)
    {
        ValidModes result = null;
        
        if(StaticMethods.isStringValid(validModesAsStrings(), argument))
        {   
            result = ValidModes.valueOf(StaticMethods.stringToEnum(argument));
        }
        
        return result;
    }
    
    // return all HashMaps tied to each mode 
    public static Object[] getAllModeHashMaps()
    {
        Object[] array = {getModeNone(), getModePhysical(), getModeAssault(), 
            getModeShield(), getModeGlass(), getModeCritz(), getModeNano()};
                return array;
    }
    
    // HashMap created for storing all modes HashMaps and populated through static means 
    private static final HashMap<ValidModes, HashMap<ValidAttributes, Double>> modeHashMap = new HashMap<>();
        static 
        {
            // for loop puts mode as key and mode HashMap (after casting) as values
            for (int i = 0; i < ValidModes.values().length; i++)
            {
                modeHashMap.put(ValidModes.values()[i], (HashMap<ValidAttributes, 
                    Double>)getAllModeHashMaps()[i]);
            }
        }
    
    // get multiplier for attribute based on mode character has taken for party 
    // Ex: character with base 100 attack + Mode: Assault = 133 attack power 
    public double modeEffect(GenericCharacter character, ValidAttributes attribute)
    {
        // mode is supplied to modeHashMap to return HashMap tied to mode and 
        // attribute is supplied to HashMap tied to mode in order to get mode 
        // value for attribute 
        return modeHashMap.get(party.get(character)).get(attribute);
    }    
    
    public String getModeAsString(GenericCharacter character)
    {
        return getModeStringUsingEnum(party.get(character));
    }
        
    // END: MANAGING ALL MODES IN ONE HASHMAP
    /*******************************************************************************/

       
        
    // START: MODE PENALTY ON GAUGES  
    /*******************************************************************************/

    public static double getModePenaltyUsingEnum(ValidModes mode)
    {
        double result = 0.0;
        
        switch(mode)
        {
            case NONE:
                result = 0.00;
                    break;
            case PHYSICAL:
                result = 0.08;
                    break;
            case ASSAULT:
                result = 0.13;
                    break;
            case SHIELD:
                result = 0.16;
                    break;
            case GLASS:
                result = 0.23;
                    break;
            case CRITZ:
                result = 0.13;
                    break;
            case NANO:
                result = 0.16;
                    break;
        }
        
        return result;
    }
    
    // HashMap for penalty where valid modes are keys and values are doubles 
    private static final HashMap<ValidModes, Double> penaltyHashMap = new HashMap<>();
        static 
        {
            for (ValidModes element : ValidModes.values())
            {
                penaltyHashMap.put(element, getModePenaltyUsingEnum(element));
            }
        }

    // returns double representing penalty for being in specific party mode 
    public double getModePenalty(ValidModes mode)
    {
        return penaltyHashMap.get(mode);
    }
    
    // enum class containing GenericCharacter object gauges that can be affected
    public enum ValidGauges
    {
        CURRENT_STAMINA, CURRENT_NANO;
    }
    
    // HashMap for penalty for gauge based on party mode 
    private static final HashMap<ValidModes, ValidGauges> gaugePenalty = new HashMap<>();
        static 
        {
            // population for hashmap performed through static means 
            for (int i = 0; i < ValidModes.values().length; i++)
            {
                // Note: despite being classified as stamina draining, mode none does nothing 
                // if accounts for stamina draining modes: physical, assault, shield
                // else accounts for nano draining modes: glass, critz, nano 
                if(i < 4){
                    gaugePenalty.put(ValidModes.values()[i], ValidGauges.CURRENT_STAMINA);
                }else{
                    gaugePenalty.put(ValidModes.values()[i], ValidGauges.CURRENT_NANO);
                }
            }
        }
    
    // gets gauge that will be penalized due to mode that is currently active 
    public ValidGauges getGaugePenalizedForMode(ValidModes mode)
    {
        return gaugePenalty.get(mode);
    }
        
    // apply penalty for being in party mode to appropriate character gauge 
    public void applyModePenalty(GenericCharacter character)
    {
        ValidModes mode = party.get(character);
        
        switch(getGaugePenalizedForMode(mode))
        {
            case CURRENT_STAMINA: 
                character.setCurrentStamina(character.getCurrentStamina() 
                - (character.getMaxStamina() * getModePenalty(mode)));
                    break;
            case CURRENT_NANO:
                character.setCurrentNano(character.getCurrentNano() 
                - (character.getMaxNano() * getModePenalty(mode)));
                    break;
        }
    }
    
    // END: MODE PENALTY ON GAUGES  
    /*******************************************************************************/
    
    
    
    // START: MODES ALLOWED BY PARTY
    /*******************************************************************************/

    // HashMap for penalty for gauge based on party mode 
    private static final HashMap<ValidModes, Boolean> modesEnabledByParty = new HashMap<>();
        static 
        {
            for (ValidModes mode : ValidModes.values())
            {
                modesEnabledByParty.put(mode, false);
            }
        }
    
    // update party mode state affecting whether character in party can use mode 
    public void updateEnabledPartyModes(String key, Boolean state)
    {
        modesEnabledByParty.put(getModeEnumUsingString(key), state);
    }
    
    // END: MODES ALLOWED BY PARTY
    /*******************************************************************************/

    
    
    // START: ADDING/REMOVING/RETRIEVING CHARACTERS 
    /*******************************************************************************/
    
    public void addToParty(GenericCharacter character)
    {
        if(character != null)
        {
            party.put(character, ValidModes.NONE);
        }
    }

    public void removeFromParty(GenericCharacter character)
    { 
        if(party != null && !party.isEmpty())
        {
            if(party.containsKey(character))
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
            for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
            {
                if(characterName.equals(entry.getKey().getName()))
                {
                    character = entry.getKey();
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
            for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
            {
                if(character.equals(entry.getKey()))
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
            for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
            {
                if(!characterName.equals(entry.getKey().getName()))
                {
                    retrieveCharacters.add(entry.getKey());
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
    
    public TreeMap<GenericCharacter, ValidModes> getPartyMembers()
    {
        return party;
    }

    // END: ADDING/REMOVING/RETRIEVING CHARACTERS 
    /*******************************************************************************/

    
    
    // START: STATES OF CHARACTERS WITHIN PARTY 
    /*******************************************************************************/

    public boolean bossEntityPresent()
    {
        boolean result = false;

        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            if(entry.getKey().getBossState() == true)
            {
                result = true;
                    break;
            }
        }

        return result;
    }
    
    public boolean endBattleEarlyTrigger()
    {
        boolean result = false;

        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            if(entry.getKey().getEndBattleTrigger() == true)
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

        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            // if at least one character is NOT knocked out (ie: has more than 0 
            // current health) or if party member is immortal then assign result 
            // with false since the party is not considered knocked out ("KO")
            if(!entry.getKey().knockedOut() && entry.getKey().getImmortalState())
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

        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            // if character is considered "fragile" then death state if knocked out 
            if(entry.getKey().knockedOut() && entry.getKey().getFragileState())
            {
                result = true;
            }
        }

        return result;
    }
    
    // END: STATES OF CHARACTERS WITHIN PARTY 
    /*******************************************************************************/


    
    // START: RESETING END BATTLE TRIGGERS FOR ALL PARTY MEMBERS 
    /*******************************************************************************/

    // resets all end battle triggers for all party members 
    public void resetEndBattleTriggers()
    {
        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            if(entry.getKey().knockedOut() && entry.getKey().getFragileState())
            {
                entry.getKey().setEndBattleTrigger(false);
            }
        }
    }
    
    // END: RESETING END BATTLE TRIGGERS FOR ALL PARTY MEMBERS 
    /*******************************************************************************/

    
    
    // START: AVERAGE PARTY ATTRIBUTE 
    /*******************************************************************************/

    public enum ValidAverages
    {
        LEVEL, ATTACK, DEFENSE, DEXTERITY, CRITICAL, ACCURACY, NANO_ATTACK, 
        NANO_DEFENSE, LUCK, CHANCE_TO_PREVENT_ESCAPE;
    }
    
    public double getAverageAttribute(ValidAverages choice)
    {
        double holdDouble = 0;

        for(Map.Entry<GenericCharacter, ValidModes> entry : party.entrySet())
        {
            switch(choice)
            {
                case LEVEL: 
                    holdDouble += entry.getKey().getLevel();
                        break;
                case ATTACK: 
                    holdDouble += entry.getKey().getTotalAttack();
                        break;
                case DEFENSE: 
                    holdDouble += entry.getKey().getTotalDefense();
                        break;
                case DEXTERITY: 
                    holdDouble += entry.getKey().getTotalDexterity();
                        break;
                case CRITICAL: 
                    holdDouble += entry.getKey().getTotalCritical();
                        break;
                case ACCURACY: 
                    holdDouble += entry.getKey().getTotalAccuracy();
                        break;
                case NANO_ATTACK: 
                    holdDouble += entry.getKey().getTotalNanoAttack();
                        break;
                case NANO_DEFENSE: 
                    holdDouble += entry.getKey().getTotalNanoDefense();
                        break;
                case LUCK: 
                    holdDouble += entry.getKey().getLuck();
                        break;
                case CHANCE_TO_PREVENT_ESCAPE:
                    holdDouble += entry.getKey().getChanceToPreventEscape();
                        break;
            }
        }

        return Math.floor(holdDouble / (double)party.size());
    }

    public double getAverageLevel()
    {
        return getAverageAttribute(ValidAverages.LEVEL);
    }

    public double getAverageAttack()
    {
        return getAverageAttribute(ValidAverages.ATTACK);
    }

    public double getAverageDefense()
    {
        return getAverageAttribute(ValidAverages.DEFENSE);
    }

    public double getAverageDexterity()
    {
        return getAverageAttribute(ValidAverages.DEXTERITY);
    }

    public double getAverageCritical()
    {
        return getAverageAttribute(ValidAverages.CRITICAL);
    }

    public double getAverageAccuracy()
    {
        return getAverageAttribute(ValidAverages.ACCURACY);
    }

    public double getAverageNanoAttack()
    {
        return getAverageAttribute(ValidAverages.NANO_ATTACK);
    }

    public double getAverageNanoDefense()
    {
        return getAverageAttribute(ValidAverages.NANO_DEFENSE);
    }

    public double getAverageLuck()
    {
        return getAverageAttribute(ValidAverages.LUCK);
    }

    public double getAverageChanceToPreventEscape()
    {
        return getAverageAttribute(ValidAverages.CHANCE_TO_PREVENT_ESCAPE);
    }
    
    // END: AVERAGE PARTY ATTRIBUTE 
    /*******************************************************************************/
    
    
    
    // START: AVERAGE PARTY ATTRIBUTE IN BATTLE
    /*******************************************************************************/
    
    // gets average value desired based on party members that have not escaped battle
    // from battle and party members that have not been not knocked out ("KO")
    public double getAverageForActiveCombatants(ArrayList<GenericCharacter> activePartyMembers, 
        ValidAverages choice)
    {	
        double result = 0.0;

        if(activePartyMembers != null && !activePartyMembers.isEmpty())
        {
            for(GenericCharacter element : activePartyMembers)
            {
                if(!element.knockedOut() && party.containsKey(element))
                {
                    switch(choice)
                    {
                        case LEVEL:
                            result += element.getLevel();
                                break;
                        case DEXTERITY: 
                            result += element.getTotalDexterity();
                                break;
                        case CHANCE_TO_PREVENT_ESCAPE: 
                            result += element.getChanceToPreventEscape();
                                break;
                    }
                }
            }
        }

        return Math.floor(result / (double)party.size());
    }

    public double getAverageActiveLevel(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, ValidAverages.LEVEL);
    }
    
    public double getAverageActiveDexterity(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, ValidAverages.DEXTERITY);
    }

    public double getAverageActiveChanceToPreventEscape(ArrayList<GenericCharacter> activePartyMembers)
    {
        return getAverageForActiveCombatants(activePartyMembers, ValidAverages.CHANCE_TO_PREVENT_ESCAPE);
    }
    
    // START: AVERAGE PARTY ATTRIBUTE IN BATTLE 
    /*******************************************************************************/
}
